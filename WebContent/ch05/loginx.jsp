<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="java.sql.SQLException" %> 
<%@ page import="java.sql.Statement" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String usernamex = request.getParameter("username");
String passwordx = request.getParameter("password");
PrintWriter pw = response.getWriter();

Statement stmt = null;
ResultSet rs = null;
Connection conn = null;
try {
	// 1. 注册数据库的驱动
	Class.forName("com.mysql.cj.jdbc.Driver");
	// 2.通过DriverManager获取数据库连接
	String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
	String username = "root";
	String password = "root";
	conn = DriverManager.getConnection (url, username,password);
	// 3.通过Connection对象获取Statement对象
	 stmt = conn.createStatement();
	
	// 4.使用Statement执行SQL语句。
	String sql = "select password from users where name='" + usernamex + "'";	
	rs = stmt.executeQuery(sql);
	// 5. 操作ResultSet结果集
	if(rs.next()){
		String psw = rs.getString("password");	
		
		  //假设正确的用户名 是itcast 密码是123
		if (psw.equals(passwordx)) {
			//User user = new User();
			//user.setUsername(username);
			//user.setPassword(password);
			//request.getSession().setAttribute("user", user);
			//response.sendRedirect("/J1932/IndexServlet");
			pw.write("登录成功");
		} else {
			pw.write("密码错误，登录失败<font color=white>" + psw +"</font>");
		}		
		
		
		
	}
	else{
		out.println("用户名错误！");
	}
} catch (ClassNotFoundException e) {
	e.printStackTrace();
} finally{
	// 6.回收数据库资源
	if(rs!=null) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = null;
	}
	if(stmt!=null) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = null;
	}
	if(conn!=null) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}

}




%>
</body>
</html>