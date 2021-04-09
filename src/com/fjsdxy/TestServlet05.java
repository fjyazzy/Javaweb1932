package com.fjsdxy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet05
 */
public class TestServlet05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet05() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, 
		      HttpServletResponse response)throws ServletException, IOException {
		      PrintWriter out = response.getWriter();
				ServletContext context = this.getServletContext();
			       String data = (String) context.getAttribute("data");
					out.println(data);
				}
			 public void doPost(HttpServletRequest request, 
			   HttpServletResponse response)throws ServletException, IOException {
			     this.doGet(request, response);
				}

}
