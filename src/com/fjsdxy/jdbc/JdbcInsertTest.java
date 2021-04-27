package com.fjsdxy.jdbc;
import java.util.Date;

public class JdbcInsertTest{
	public static void main(String[] args) {
         // 向users表插入一个用户信息
		UsersDao ud = new UsersDao();
		User user=new User();
			user.setId(5);
			user.setUsername("hl");
			user.setPassword("123");
			user.setEmail("hl@sina.com");
			user.setBirthday(new Date());
			boolean b=ud.insert(user);
			System.out.println(b);
		}
}
