package edu.guosong.sc.hijklmnadmin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import edu.guosong.sc.hijklmncommon.param.StringOption;


@Order(1)
@WebFilter(filterName = "encodeFilter", urlPatterns = "*")
public class EncodeFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(EncodeFilter.class);

	@Override
	public void destroy() {
		log.info("encodefilter destroy . . . ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(StringOption.UTF8);
		response.setCharacterEncoding(StringOption.UTF8);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		log.info("encodefilter init . . . ");
	}

}
