package edu.guosong.sc.hijklmndbserver.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import edu.guosong.sc.hijklmncommon.param.DateOption;
import edu.guosong.sc.hijklmncommon.util.DateUtil;

@Order(1)
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void destroy() {
		log.info("logfilter destroy . . . ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		log.info("date:[{}],url:[{}].", DateUtil.generatorStrWithFormat(DateOption.YYYYMMDDHHMMSS),
				req.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		log.info("logfilter init . . . ");
	}

}
