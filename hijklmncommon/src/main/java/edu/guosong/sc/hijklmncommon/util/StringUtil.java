package edu.guosong.sc.hijklmncommon.util;

import java.util.UUID;

import edu.guosong.sc.hijklmncommon.param.DateOption;

public class StringUtil {

	public static String generatorUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "").toLowerCase();
	}

	public static String generatorRandom32l() {
		return generatorUUID().substring(0, 18) + DateUtil.generatorStrWithFormat(DateOption.yyyyMMddHHmmss);
	}

	public static String generatorRandom20l() {
		return generatorUUID().substring(0, 10) + DateUtil.generatorStrWithFormat(DateOption.yyMMddHHmm);
	}

	public static String[] split(String content, String regex) {
		return content.split(regex);
	}

	public static String generatorSuffix(String content, String regex) {
		String[] s = content.split(regex);
		return s[s.length - 1];
	}

	public static String generatorPerfix(String content, String regex) {
		String[] s = content.split(regex);
		return content.substring(content.length() - s[s.length - 1].length(), content.length());
	}

}
