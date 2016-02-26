package zgq.service.impl;

import zgq.dao.UserDao;
import zgq.dao.impl.UserDaoImpl;
import zgq.domain.User;
import zgq.exception.UserExistException;
import zgq.utils.ServiceUtils;

//��web���ṩ���õ�Ӧ�÷���
public class BusinessServiceImpl {

	private UserDao dao=new UserDaoImpl();   //����ģʽ��spring������ֲ�  �����ĺô����ǵײ�ı䣬�ϲ���벻���޸�
	
	//��web���ṩע�����
	public void register(User user) throws UserExistException{
		//���жϵ�ǰ�û������ݿ����Ƿ����
		boolean b=dao.find(user.getUsername());
		if(b){   //����ʱ�쳣   ϣ���û�����  
				 //����ʱ�쳣   ����֪ͨ�û�����
			
			throw new UserExistException(); //����Ҫע����û��Ѵ��ڣ����web����һ������ʱ�쳣������web�㴦������쳣�����û�һ���Ѻ���ʾ
		}
		else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			dao.add(user);
		}
		
	}
	
	//��web���ṩ��¼����
	public User login(String username,String password){
		password=ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
}
