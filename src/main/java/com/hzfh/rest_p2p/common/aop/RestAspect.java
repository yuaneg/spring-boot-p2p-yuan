package com.hzfh.rest_p2p.common.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONObject;
import com.hzfh.rest_p2p.common.parameter.DeviceOrigin;
import com.hzfh.rest_p2p.common.until.RSAUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.hzfh.rest_p2p.common.until.CheckSignature;
import com.hzfh.rest_p2p.common.until.DeviceKeyUtil;


/**
 * @author 袁恩光 AOP类
 */
@Aspect
@Component
public class RestAspect {

	/**
	 * 验签参数名称
	 */
	private static final String SIGN = "sign";
	
	public static final String DEVICE_ORIGIN = "origin";

	private Logger logger = LoggerFactory.getLogger(RestAspect.class);

	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void doRest() {
		
	}

	@Pointcut("@annotation(com.hzfh.rest_p2p.common.annotation.Validate)")
	public void doValidate() {
		
	}
	
	/**
	 * 每次请求的链接
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("doRest()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		StringBuilder sb = new StringBuilder();
		sb.append("url:" + request.getRequestURL().toString() + ",");
		sb.append("method:" + request.getMethod() + ",");
		sb.append("uri:" + request.getRequestURI() + ",");
		sb.append("queryString:" + request.getQueryString() + ",");
		sb.append("time:" + System.currentTimeMillis());
		logger.info(sb.toString());
	}

	/**
	 * 验签方法
	 * 
	 * @param joinPoint
	 * @throws Exception
	 */
	@Before("doValidate()")
	public void validateMethod(JoinPoint joinPoint) throws Exception {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		String sign = request.getParameter(SIGN);
		if (StringUtils.isEmpty(sign)) {
			throw new Exception("验签参数sign为空");
		}
		Object[] objects = joinPoint.getArgs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		Annotation[][] annotations = method.getParameterAnnotations();
		Map<String, Object> m = new HashMap<>();
		for (int i = 0; i < objects.length; i++) {
			for (int j = 0; j < annotations.length; j++) {
				if (i == j) {
					if (null != objects[i]) {
						RequestParam requestParam = (RequestParam) annotations[i][0];
						if (StringUtils.isEmpty(requestParam.value())) {
							if (StringUtils.isEmpty(requestParam.name())) {
								throw new Exception("@RequestParam的name值或value值未填写");
							} else {
								m.put(requestParam.name(), objects[i]);
							}
						} else {
							m.put(requestParam.value(), objects[i]);
						}
					}
					break;
				}
			}
		}
		
		//获取传入设备类型
        String deviceOriginStr = request.getParameter(DEVICE_ORIGIN);
        DeviceOrigin deviceOrigin = DeviceOrigin.valueOf(deviceOriginStr);
        //根据设备类型获取传入的字符串
		String rsaStr = DeviceKeyUtil.getDeviceKey(deviceOrigin);
		String prostr =  RSAUtils.RSADecode(sign,rsaStr);
		//rsa 验签方式
		if(!JSONObject.toJSONString(m).equals(prostr)){
			throw new Exception("【验签失败】methodName:" + method.getDeclaringClass().getName() + "." + method.getName()
					+ "||parameters:" + m.toString() + "||" +
					"sign:" + sign);
		}
		//md5验签
		if (!CheckSignature.check(m, sign)) {
			throw new Exception("【验签失败】methodName:" + method.getDeclaringClass().getName() + "." + method.getName()
					+ "||parameters:" + m.toString() + "||sign:" + sign);
		}
	}


}
