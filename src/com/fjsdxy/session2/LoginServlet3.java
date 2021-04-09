package com.fjsdxy.session2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet3
 */
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * 添加了验证码
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String checkCode = request.getParameter("check_code");
			String savedCode = (String) request.getSession().getAttribute(
					"check_code");
			PrintWriter pw = response.getWriter();
			if (("itcast").equals(username) && ("123").equals(password)
					&& checkCode.equals(savedCode)) {
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/J1932/IndexServlet");
			} else if (checkCode.equals(savedCode)) {
				pw.write("用户名或密码错误，登录失败");
			} else {
				pw.write("验证码错误");
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
