package com.fjsdxy.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement ;
import java.sql.SQLException;
public class Example02 {
	public static void main(String[] args) throws SQLException {
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
				
//				String sql = "INSERT INTO grjj(xm,ah,jj) VALUES(?,?,?)";
				
	             // 创建执行SQL语句的PreparedStatement 对象
				preStmt = conn.prepareStatement(sql);
				
				//String xm=request.getParameter("xm");
				//preStmt.setString(1, xm);
				
				preStmt.setString(1, "zl11111");
				preStmt.setString(2, "123456111");
				preStmt.setString(3, "zl111@sina.com");
				preStmt.setString(4, "2001-12-23");
				preStmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {    // 释放资源
				if (preStmt != null) {
					try {
						preStmt.close();
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
		}
	}
