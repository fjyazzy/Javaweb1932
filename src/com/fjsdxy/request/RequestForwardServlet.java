package com.fjsdxy.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestForwardServlet
 */
public class RequestForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestForwardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request,
	        HttpServletResponse response)throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			// 将数据存储到request对象中
				request.setAttribute("company", "北京传智播客教育有限公司");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/ResultServlet");
				dispatcher.forward(request, response);
			}
			public void doPost(HttpServletRequest request,
		        HttpServletResponse response)throws ServletException, IOException {
				doGet(request, response);
			}

}
