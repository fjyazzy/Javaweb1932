package com.fjsdxy.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownManagerServlet
 */
public class DownManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, 
	        HttpServletResponse response)throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
		         // 获取referer头的值
				String referer = request.getHeader("referer"); 
		         // 获取访问地址
				String sitePart = "http://" + request.getServerName();
				// 判断referer头是否为空，这个头的首地址是否以sitePart开始的
				if (referer != null && referer.startsWith(sitePart)) {
					// 处理正在下载的请求
					out.println("dealing download ...");
				} else {
					// 非法下载请求跳转到download.html页面
					RequestDispatcher rd = request
							.getRequestDispatcher("/ch04/download.html");
					rd.forward(request, response);
				}
			}
			public void doPost(HttpServletRequest request,
		        HttpServletResponse response)throws ServletException, IOException {
				doGet(request, response);
			}
			

}
