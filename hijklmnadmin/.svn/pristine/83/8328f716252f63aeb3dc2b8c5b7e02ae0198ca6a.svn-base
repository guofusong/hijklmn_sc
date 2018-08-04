package edu.guosong.sc.hijklmnadmin.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.alibaba.fastjson.JSONObject;

import edu.guosong.sc.hijklmnadmin.common.RequestOption;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.ResultParam;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.User;

@Order(2)
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class AuthFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

	@Override
	public void destroy() {
		log.info("authfilter destroy . . . ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;

		String requestUrl = req.getRequestURI();

		if (requestUrl.contains(RequestOption.BOOSTRAP) || requestUrl.contains(RequestOption.BOOSTRAP)
				|| requestUrl.contains(RequestOption.BUILD) || requestUrl.contains(RequestOption.DIST)
				|| requestUrl.contains(RequestOption.JS) || requestUrl.contains(RequestOption.CSS)
				|| requestUrl.contains(RequestOption.IMAGE) || requestUrl.contains(RequestOption.PLUGINS)) {
			chain.doFilter(req, rep);
			return;
		}

		User user = (User) req.getSession().getAttribute(WebOption.USER);
		if (requestUrl.equals(RequestOption.INDEX) || requestUrl.equals(RequestOption.LOGIN)) {
			if (user == null) {
				chain.doFilter(req, rep);
			} else {
				rep.sendRedirect(RequestOption.HOME);
			}
		} else {
			if (user == null) {
				String requestType = req.getHeader(WebOption.AJAXXREQUESTEDWITH);
				if (WebOption.AJAXXMLHTTPREQUEST.equals(requestType)) {
					RequestResult requestResult = new RequestResult();
					requestResult.setCode(ResultParam.sessionexpires.code());
					requestResult.setReason(ResultParam.sessionexpires.desc());
					PrintWriter pw = response.getWriter();
					pw.println(JSONObject.toJSONString(requestResult));
					pw.flush();
					pw.close();
					return;
				}
				rep.sendRedirect(RequestOption.INDEX);
				return;
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		log.info("authfilter init . . . ");
	}

}
