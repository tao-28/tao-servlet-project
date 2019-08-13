package com.tao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * ±àÂë¹ýÂË
 * 
 * @author tao
 *
 */
@WebFilter(urlPatterns = "/*")
public class EncodeFilter implements Filter {
	private final String encoder = "UTF-8";

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding(encoder);
		chain.doFilter(req, resp);
		resp.setCharacterEncoding(encoder);
		resp.setContentType("text/html;" + encoder);
	}

	@Override
	public void destroy() {

	}
}
