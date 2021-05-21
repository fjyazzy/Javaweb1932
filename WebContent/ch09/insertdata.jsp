<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager" %> 
<%@ page import="java.sql.SQLException" %> 
<%@ page import="java.sql.PreparedStatement" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>插入一行数据</title>
</head>
<body>
<%
Connection conn = null;
PreparedStatement  preStmt = null;
	try {
         // 加载数据库驱动
		// 1. 注册数据库的驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2.通过DriverManager获取数据库连接
		String url = "jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC";
		String username = "root";
		String password = "root";
         // 创建应用程序与数据库连接的Connection对象
		conn = DriverManager.getConnection(url, username, password);
		// 执行的SQL语句
		String sql = "INSERT INTO users(name,password,email,birthday)"
				+ "VALUES(?,?,?,?)";
         // 创建执行SQL语句的PreparedStatement 对象
		preStmt = conn.prepareStatement(sql);
		preStmt.setString(1, "zl0520");
		preStmt.setString(2, "123456");
		preStmt.setString(3, "zl@sina.com");
		preStmt.setString(4, "1789-12-23");
		preStmt.executeUpdate();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {    // 释放资源
		if (preStmt != null) {
			try {
				preStmt.close();
				out.println("你添加的数据已经被保存!");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			preStmt = null;
		}
		if (conn != null) {
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