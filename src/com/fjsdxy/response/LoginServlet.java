package com.fjsdxy.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 用HttpServletRequest对象的getParameter()方法获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 假设用户名和密码分别为：itcast和123
		if (("itcast").equals(username) &&("123").equals(password)) {
			// 如果用户名和密码正确，重定向到 welcome.html
              response.sendRedirect("/J1932/ch04/welcome.html");
		} else {
			// 如果用户名和密码错误，重定向到login.html			
			//response.sendRedirect("/J1932/ch04/login.html");
			PrintWriter out = response.getWriter();
			out.print("/J1932/ch04/login.html");
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
