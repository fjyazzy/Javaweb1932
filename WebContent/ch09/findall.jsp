<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.fjsdxy.jdbc.User"%>
<%@ page import="com.fjsdxy.jdbc.UsersDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>第九章：JDBC--JDBCUtils</title>
</head>
<body>
<%
//创建一个名称为usersDao的对象
UsersDao usersDao = new UsersDao();
//将UsersDao对象的findAll()方法执行后的结果放入list集合
ArrayList<User> list = usersDao.findAll();
//循环输出集合中的数据
for (int i = 0; i < list.size(); i++) {
		out.println("第" + (i + 1) + "条数据的username值为:"
				+ list.get(i).getUsername() + "<br>");
	}
%>
</body>
</html>