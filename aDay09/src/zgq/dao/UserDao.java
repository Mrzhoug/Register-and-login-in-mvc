package zgq.dao;

import zgq.domain.User;

public interface UserDao {

	//����ҵ�������֪�û���¼��ע����Ҫ��add������find����
	void add(User user);

	//�û���¼ʱ����û��������Ƿ���ȷ
	User find(String username, String password);

	//�û�ע��ʱ�����û���������ݿ����Ƿ������ͬ�û���
	boolean find(String username);

}