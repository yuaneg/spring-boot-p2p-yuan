package com.hzfh.rest_p2p.common.until;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.springframework.util.StringUtils;

/**
 * @author 袁恩光
 */
public class CheckSignature {

	/**
	 * 验证sign
	 * 
	 * @param params
	 * @param sign
	 * @return
	 */
	public static boolean check(Map<?, ?> params, String sign) {
		if (StringUtils.isEmpty(sign)) {
			return false;
		}
		String outStr = makeMD5(params);
		boolean b = sign.equals(outStr);
		return b;
	}

	/**
	 * sign加密
	 * 
	 * @param params
	 * @return
	 */
	public static String makeMD5(Map<?, ?> params) {
		Entry<?, ?> entry;
		StringBuffer sb = new StringBuffer();
		sb.append("huazhen:");
		for (Iterator<?> iterator = params.entrySet().iterator(); iterator.hasNext();) {
			entry = (Entry<?, ?>) iterator.next();
			sb.append(entry.getKey().toString()).append("=")
					.append(null == entry.getValue() ? "" : entry.getValue().toString())
					.append(iterator.hasNext() ? "&" : "");
		}
		// 1，把sortStr转换为字符数组
		char[] arrayCh = sb.toString().toCharArray();
		// 2，利用数组帮助类自动排序
		Arrays.sort(arrayCh);
		String a = new String(arrayCh);
		String outStr = Md5(a);
		return outStr;
	}

	/**
	 * 进行md5加密
	 * 
	 * @param str
	 * @return
	 */
	public static String Md5(String str) {
		String outStr = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < b.length; i++) {
				int c = b[i] >>> 4 & 0xf;
				buf.append(Integer.toHexString(c));
				c = b[i] & 0xf;
				buf.append(Integer.toHexString(c));
			}
			outStr = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return outStr;
	}

}
