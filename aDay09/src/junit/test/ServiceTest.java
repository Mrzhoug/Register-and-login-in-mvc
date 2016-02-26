package junit.test;

import java.util.Date;

import org.junit.Test;

import zgq.domain.User;
import zgq.exception.UserExistException;
import zgq.service.impl.BusinessServiceImpl;

public class ServiceTest {

	@Test
	public void testRegister(){
		User user=new User();
		user.setBirthday(new Date());
		user.setEmail("bb@sina.com");
		user.setId("3424234234");
		user.setNickname("����");
		user.setPassword("123");
		user.setUsername("jjjjj");
		
		BusinessServiceImpl serviceImpl=new BusinessServiceImpl();
		try {
			serviceImpl.register(user);
			System.out.println("ע��ɹ�");
		} catch (UserExistException e) {
			System.out.println("�û��Ѿ�ע��");
		}
	}
	
	@Test
	public void testLogin(){
		BusinessServiceImpl serviceImpl=new BusinessServiceImpl();
		User user= serviceImpl.login("jjj", "123");
		System.out.println(user);
	}
}
