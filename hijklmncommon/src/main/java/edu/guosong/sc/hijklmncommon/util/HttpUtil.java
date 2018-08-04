package edu.guosong.sc.hijklmncommon.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * tips : 下面的代码用于练习<br>
 * description :
 *
 * @author : guosong
 * @date : 2018年1月10日
 * @time : 下午3:17:55
 * @project_name : admin
 * @package_name : com.store.admin.common
 *
 */
public class HttpUtil {

	public static void initSession(HttpServletRequest request) {
		Enumeration<String> em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
	}

}
