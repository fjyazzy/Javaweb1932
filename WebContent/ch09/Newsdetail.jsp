<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.ResultSet" %> 
<%@ page import="java.sql.SQLException" %> 
<%@ page import="java.sql.Statement" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻详细页</title>
</head>
<body>
<%
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
	String id=request.getParameter("id");
	String sql = "select * from newslist where id=" +id;
	rs = stmt.executeQuery(sql);
	// 5. 操作ResultSet结果集
	out.println("<a href=Newslist.jsp>回到列表</a>");
	if(rs.next()){
		String bt = rs.getString("bt");
		String nr = rs.getString("nr");
		out.println("<h1>"+ bt  + "</h1>");
		out.println("<p>"+ nr  + "<p>");		
	}
	else{
		out.println("新闻列表号错误！");
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