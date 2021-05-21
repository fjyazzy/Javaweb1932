package com.fjsdxy.jdbcdemo;

import java.sql.SQLException;
public class DBUtilsDaoTest1 {
	private static DBUtilsDao dao = new DBUtilsDao();
	public static void testInsert() throws SQLException {
		User user = new User();
		user.setName("j1932");
		user.setPassword("777777");
		boolean b = dao.insert(user);
		System.out.println(b);
	}
	public static void main(String[] args) throws SQLException {
		testInsert();
	}
}
