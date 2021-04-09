package com.fjsdxy;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet04
 */
public class TestServlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, 
		      HttpServletResponse response)throws ServletException, IOException {
				ServletContext context = this.getServletContext();
		         // 保存数据
					context.setAttribute("data", "111111111111111111");
				}
				public void doPost(HttpServletRequest request, 
			      HttpServletResponse response)throws ServletException, IOException {
					this.doGet(request, response);
				}
			

}
