package junit.test;

import java.util.Date;

import org.junit.Test;

import zgq.dao.UserDao;
import zgq.dao.impl.UserDaoImpl;
import zgq.domain.User;

public class UserDaoTest {
	@Test
	public void addTest(){
		User user=new User();
		user.setBirthday(new Date());
		user.setEmail("bb@sina.com");
		user.setId("3424234234");
		user.setNickname("Àî×Ó");
		user.setPassword("123");
		user.setUsername("bbbb");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind(){
		UserDao dao = new UserDaoImpl();
		dao.find("aaa","123");
	}
	
	@Test
	public void testFindByUsername(){
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("aaa"));
	}
}
