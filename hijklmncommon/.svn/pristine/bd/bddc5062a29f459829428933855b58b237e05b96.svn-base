package edu.guosong.sc.hijklmncommon.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final ThreadLocal<SimpleDateFormat> local = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat();
		}
	};

	public static String generatorStrWithFormat(String regex) {
		SimpleDateFormat format = local.get();
		format.applyPattern(regex);
		return format.format(new Date());
	}

	public static String generatorStrWithFormatE(String regex) throws Exception {
		try {
			SimpleDateFormat format = local.get();
			format.applyPattern(regex);
			return format.format(new Date());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static String str2strE(String dateStr, String regex) throws Exception {
		try {
			SimpleDateFormat format = local.get();
			format.applyPattern(regex);
			Date date = format.parse(dateStr);
			return format.format(date);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public static Date str2dateE(String dateStr, String regex) throws Exception {
		try {
			SimpleDateFormat format = local.get();
			format.applyPattern(regex);
			Date date = format.parse(dateStr);
			return date;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
