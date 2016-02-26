package zgq.service.impl;

import zgq.dao.UserDao;
import zgq.dao.impl.UserDaoImpl;
import zgq.domain.User;
import zgq.exception.UserExistException;
import zgq.utils.ServiceUtils;

//对web层提供所用的应用服务
public class BusinessServiceImpl {

	private UserDao dao=new UserDaoImpl();   //工厂模式和spring来解决分层  这样的好处就是底层改变，上层代码不用修改
	
	//对web层提供注册服务
	public void register(User user) throws UserExistException{
		//先判断当前用户在数据库中是否存在
		boolean b=dao.find(user.getUsername());
		if(b){   //编译时异常   希望用户处理  
				 //运行时异常   不会通知用户处理
			
			throw new UserExistException(); //发现要注册的用户已存在，则给web层抛一个编译时异常，提醒web层处理这个异常，给用户一个友好提示
		}
		else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
		
	}
	
	//对web成提供登录服务
	public User login(String username,String password){
		password=ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
}
