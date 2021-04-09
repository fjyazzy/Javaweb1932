package com.fjsdxy.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request,
	        HttpServletResponse response)throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
	          // 获取PrintWriter对象用于输出信息
				PrintWriter out = response.getWriter();
				// 获取request请求对象中保存的数据
				String company = (String) request.getAttribute("company");
				if (company != null) {
					out.println("公司名称：" + company + "<br>");
				}
			}
			public void doPost(HttpServletRequest request, 
		        HttpServletResponse response)throws ServletException, IOException {
				doGet(request, response);
			}

}
