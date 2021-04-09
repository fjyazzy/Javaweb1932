package com.fjsdxy.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncludedServlet
 */
public class IncludedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncludedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, 
	        HttpServletResponse response)throws ServletException, IOException {
			// 设置响应时使用的字符编码
		    response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("中国" + "<br>");
			out.println("URI:" + request.getRequestURI() + "<br>");
			out.println("QueryString:" + request.getQueryString() + "<br>");
			out.println("parameter p1:" + 
	                       request.getParameter("p1") + "<br>");
		}
		public void doPost(HttpServletRequest request,
	        HttpServletResponse response)throws ServletException, IOException {
			doGet(request, response);
		}

}
