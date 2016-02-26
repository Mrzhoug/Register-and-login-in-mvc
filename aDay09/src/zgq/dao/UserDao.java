package zgq.dao;

import zgq.domain.User;

public interface UserDao {

	//根据业务需求得知用户登录和注册需要有add方法和find方法
	void add(User user);

	//用户登录时检测用户名密码是否正确
	User find(String username, String password);

	//用户注册时根据用户名检测数据库中是否存在相同用户名
	boolean find(String username);

}