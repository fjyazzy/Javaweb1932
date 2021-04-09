package com.fjsdxy.cookies;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessServlet
 */
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastAccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

// 指定服务器输出内容的编码方式UTF-8，防止发生乱码
response.setContentType("text/html;charset=utf-8");
String lastAccessTime = null;
// 获取所有的cookie，并将这些cookie存放在数组中
Cookie[] cookies = request.getCookies();
// 遍历cookies数组
for (int i = 0; cookies != null && i < cookies.length; i++) {
if ("lastAccess".equals(cookies[i].getName())) {
// 如果cookie的名称为lastAccess,则获取该cookie的值
lastAccessTime = cookies[i].getValue();
break;
}
}
// 判断是否存在名称为lastAccess的cookie
if (lastAccessTime == null) {
response.getWriter().print("您是首次访问本站！！！");
} else {
response.getWriter().print("您上次的访问时间是： " 
           + lastAccessTime);
}
// 创建cookie,将当前时间作为cookie的值发送给客户端
String currentTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
Cookie cookie = new Cookie("lastAccess",currentTime);
//cookie.setMaxAge(60*60); //设置cookie最大存在时间
// 发送 cookie
response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
