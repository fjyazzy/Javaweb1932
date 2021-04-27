package com.fjsdxy.session2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 解决乱码问题
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print("<h1>11111111</h1>");
		         // 创建或者获取保存用户信息的Session对象
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				if (user == null) {
					response.getWriter().print(
					"您还没有登录，请<a href='/J1932/ch05/login.html'>登录</a>");
				} else {
		            response.getWriter().print("您已登录，欢迎你，" + user.getUsername() + "！");
					response.getWriter().print(
							"<a href='/J1932/LogoutServlet'>退出</a>");
					// 创建Cookie存放Session的标识号
					Cookie cookie = new Cookie("JSESSIONID", session.getId());
					cookie.setMaxAge(60 * 30);
					cookie.setPath("/J1932");
					response.addCookie(cookie);
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
