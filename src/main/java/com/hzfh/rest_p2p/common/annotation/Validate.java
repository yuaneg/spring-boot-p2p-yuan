package com.hzfh.rest_p2p.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 袁恩光 
 * 验签注解
 * 只能作用方法  被注解的方法上的参数必须被 @RequestParam 注解并指定name 或者 value值
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validate {
	
}
