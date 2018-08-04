package edu.guosong.sc.hijklmncommon.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具 tips : 下面的代码用于练习<br>
 * description :
 *
 * @author : guosong
 * @date : 2018年4月29日
 * @time : 下午2:52:55
 * @project_name : hijklmnutil
 * @package_name : edu.guosong.sc.hijklmnutil
 *
 */
public class SecurityUtil {

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	private static final String MD5ALGORITHM = "MD5";

	private static final String SHA1ALGORITHM = "SHA-1";

	private static String generatorHEXText(byte[] b) {
		int len = b.length;
		StringBuilder buf = new StringBuilder(len * 2);
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(b[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[b[j] & 0x0f]);
		}
		return buf.toString();
	}

	public static String MD5(String content) {
		if (content == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(MD5ALGORITHM);
			messageDigest.update(content.getBytes());
			return generatorHEXText(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String SHA1(String content) {
		if (content == null) {
			return null;
		}
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(SHA1ALGORITHM);
			messageDigest.update(content.getBytes());
			return generatorHEXText(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

}
