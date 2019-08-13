package com.tao.user.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tao.cache.UserIdCache;
import com.tao.entity.PromptEntity;
import com.tao.user.service.LoginApi;
import com.tao.user.service.impl.LoginApiImpl;

@WebServlet(urlPatterns = { "/user/login" }, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -6141489747294241658L;
	private LoginApi loginApi = new LoginApiImpl();
	private final String standerStr = "/user/login";

	public LoginServlet() {
		System.out.println("get LoginServlet object");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("LoginServlet do init");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("head message: ");
		Enumeration<String> heads = req.getHeaderNames();
		while (heads.hasMoreElements()) {
			String header = heads.nextElement();
			String value = req.getHeader(header);
			System.out.printf("%s\t%s%n", header, value);
		}
		// System.out.println("�������������ʱ������URL������Э�� ������ �˿�(�����): " +
		// req.getRequestURL());
		// System.out.println("����������������Դ�����֣�ȥ����Э���������: " +
		// req.getRequestURI());
		// System.out.println("�������еĲ������֣�ֻ����ʾ��get��ʽ�����Ĳ�����post��ʽ�Ŀ�����: " +
		// req.getQueryString());
		// System.out.println("����������ڵĿͻ�����IP��ַ: " + req.getRemoteAddr());
		// System.out.println("����������ڵĿͻ�����������: " + req.getRemoteHost());
		// System.out.println("����������ڵĿͻ���ʹ�õ�����˿�: " + req.getRemotePort());
		// System.out.println("��������IP��ַ: " + req.getRemotePort());
		// System.out.println("��������������: " + req.getLocalName());
		// System.out.println("�õ��ͻ�������ʽһ����GET����POST: " + req.getMethod());

		String uri = req.getRequestURI();
		int index = uri.indexOf("?");
		String suffix = uri.substring(uri.indexOf(standerStr) + standerStr.length(), index < 0 ? uri.length() : index);
		switch (suffix) {
		case "/success":
			success(req, resp);
			break;
		case "":
		default:
			doLogin(req, resp);
			break;
		}
	}

	public void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userAccontNo = req.getParameter("userAccontNo");
		String userPwd = req.getParameter("userPwd");
		PromptEntity promptEntity = loginApi.doLogin(userAccontNo, userPwd);
		if (promptEntity != null && promptEntity.getId() > 0) {
			Set<String> userIdSet = UserIdCache.getInstance();
			userIdSet.add(userAccontNo);
			req.getSession().setAttribute("userIdSet", userIdSet);
			Cookie userIdCookie = new Cookie("userId", userAccontNo);
			userIdCookie.setMaxAge(10);
			resp.addCookie(userIdCookie);
			req.setAttribute("userAccontNo", userAccontNo);
			resp.sendRedirect("/user/login/success");
		} else {
			req.setAttribute("promptEntity", promptEntity);
			req.getRequestDispatcher("/mainView.jsp").forward(req, resp);
		}
	}

	public void success(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/success.jsp").forward(req, resp);
	}
}
