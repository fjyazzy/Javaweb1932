package com.fjsdxy;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet06
 */
public class TestServlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet06() {
        super();
        // TODO Auto-generated constructor stub
    }

public void doGet(HttpServletRequest request, 
  HttpServletResponse response)throws ServletException, IOException {
	ServletContext context = this.getServletContext();
		PrintWriter out = response.getWriter();
		InputStream in = context.getResourceAsStream("/WEB-INF/classes/itcast.properties");
		Properties pros = new Properties();
		pros.load(in);
		out.println("Company=" + pros.getProperty("Company") + "<br>");
		out.println("Address=" + pros.getProperty("Address") + "<br>");
}
/**
 * 缁濆璺緞
 
public void doGet(HttpServletRequest request, 
      HttpServletResponse response)throws ServletException, IOException {
 	  PrintWriter out = response.getWriter();
      ServletContext context = this.getServletContext();
         //鑾峰彇鏂囦欢缁濆璺緞
 	String path = context.getRealPath("/WEB-INF/classes/itcast.properties");
 	FileInputStream in = new FileInputStream(path);
 	Properties pros = new Properties();
 	pros.load(in);
 	out.println("Company=" + pros.getProperty("Company") + "<br>");
 	out.println("Address=" + pros.getProperty("Address") + "<br>");
 }
*/
	
public void doPost(HttpServletRequest request, 
  HttpServletResponse response)throws ServletException, IOException {
	this.doGet(request, response);
}

}
