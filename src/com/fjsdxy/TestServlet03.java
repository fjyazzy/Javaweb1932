package com.fjsdxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet03
 */
public class TestServlet03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet03() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, 
		     HttpServletResponse response)throws ServletException, IOException {
		         PrintWriter out = response.getWriter();
				 ServletContext context = this.getServletContext();
				Enumeration<String> paramNames = context.getInitParameterNames();
				 out.println("all the paramName and paramValue are following:<br>");
				 while (paramNames.hasMoreElements()) {
					String name = paramNames.nextElement();
					String value = context.getInitParameter(name);
					out.println(name + ": " + value);
		             out.println("<br>");
		         }
			}
			public void doPost(HttpServletRequest request, 
		      HttpServletResponse response)throws ServletException, IOException {
		          this.doGet(request, response);
			}
}
