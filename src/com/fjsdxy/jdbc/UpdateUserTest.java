package com.fjsdxy.jdbc;
import java.util.Date;

public class UpdateUserTest{
	public static void main(String[] args) {
         // 修改User对象的数据
		UsersDao usersDao = new UsersDao();
		User user = new User();
			user.setId(4);
			user.setUsername("zhaoxiaoliu");
			user.setPassword("456");
			user.setEmail("zhaoxiaoliu@sina.com");
			user.setBirthday(new Date());
			boolean b = usersDao.update(user);
			System.out.println(b);
		}
}
