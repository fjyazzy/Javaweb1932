package com.fjsdxy.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncludingServlet
 */
public class IncludingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IncludingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, 
	        HttpServletResponse response)throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = request
						.getRequestDispatcher("/IncludedServlet?p1=abc");
				out.println("before including" + "<br>");
				rd.include(request, response);
				out.println("after including" + "<br>");
			}
			public void doPost(HttpServletRequest request,
		        HttpServletResponse response)throws ServletException, IOException {
				doGet(request, response);
			}

}
