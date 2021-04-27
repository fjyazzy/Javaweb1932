package com.fjsdxy.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet8
 */
public class LoginServlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
			throws ServletException, IOException {
		// 获得用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 检查用户名和密码
		if ("itcast".equals(username) && "123456".equals(password)) {
			// 登录成功
			// 将用户状态 user 对象存入 session域
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			request.getSession().setAttribute("user", user);
			// 发送自动登录的cookie
			String autoLogin = request.getParameter("autologin");
			if (autoLogin != null) {
				// 注意 cookie 中的密码要加密
				Cookie cookie = new Cookie("autologin", username + "-"
						+ password);
				cookie.setMaxAge(Integer.parseInt(autoLogin));
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		// 跳转至首页
		response.sendRedirect(request.getContextPath()+"/ch08/index.jsp");
		} else {
			request.setAttribute("errerMsg", "用户名或密码错");
			request.getRequestDispatcher("/ch08/login.jsp")
			.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
