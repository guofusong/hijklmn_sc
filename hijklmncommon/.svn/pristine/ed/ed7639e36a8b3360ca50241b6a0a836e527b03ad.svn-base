package edu.guosong.sc.hijklmncommon.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JSONUtil {

	/**
	 * 字符串转对象
	 * 
	 * @param str
	 * @param c
	 * @return
	 */
	public static Object str2Bean(String str, Class<?> c) {
		if (str == null || str.trim().length() == 0)
			return null;
		@SuppressWarnings("static-access")
		JSONObject json = new JSONObject().parseObject(str);
		return JSONObject.toJavaObject(json, c);
	}

	/**
	 * 字符串转对象
	 * 
	 * @param obj
	 * @param c
	 * @return
	 */
	public static Object str2Bean(Object obj, Class<?> c) {
		if (obj == null || obj.toString().trim().length() == 0)
			return null;
		@SuppressWarnings("static-access")
		JSONObject json = new JSONObject().parseObject(obj.toString());
		return JSONObject.toJavaObject(json, c);
	}

	/**
	 * 字符串转list对象
	 * 
	 * @param obj
	 * @param c
	 * @return
	 */
	public static Object str2List(Object obj, Class<?> c) {
		if (obj == null || obj.toString().trim().length() == 0)
			return null;
		@SuppressWarnings("static-access")
		JSONArray arr = new JSONArray().parseArray(obj.toString());
		return JSONObject.toJavaObject(arr, c);
	}

	/**
	 * 对象转字符串
	 * 
	 * @param object
	 * @return
	 */
	public static String bean2Str(Object object) {
		if (object == null)
			return null;
		return JSONObject.toJSONString(object);
	}

}
