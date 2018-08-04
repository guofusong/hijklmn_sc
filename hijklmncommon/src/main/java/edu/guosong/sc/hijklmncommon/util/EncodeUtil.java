package edu.guosong.sc.hijklmncommon.util;

import java.util.Base64;

/**
 * 
 * tips : 转码工具<br>
 * description :
 *
 * @author : guosong
 * @date : 2018年5月4日
 * @time : 下午11:18:43
 * @project_name : hijklmncommon
 * @package_name : edu.guosong.sc.hijklmncommon.util
 *
 */
public class EncodeUtil {

	public static String encode(byte[] b) {
		return Base64.getEncoder().encodeToString(b);
	}

	public static byte[] decode(byte[] b) {
		return Base64.getDecoder().decode(b);
	}

	public static byte[] decode(String content) {
		return Base64.getDecoder().decode(content);
	}

}
