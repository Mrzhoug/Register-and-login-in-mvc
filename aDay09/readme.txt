1.���������
	1.1�����뿪����
		dom4j������
		jstl������
		beanUtils������
		log4j������
	1.2��������֯����Ŀ�����
		zgq.domain
		zgq.dao
		zgq.dao.impl
		zgq.service
		zgq.service.impl
		zgq.web.controller
		zgq.web.UI
		zgq.utils
		junit.test
		
		WEB-INF/jsp
	1.3,�����������ݿ��xml�ļ�
		����Ŀ¼�´���һ���������ݿ��users.xml
2.��������
	2.1���ȿ���javabean  
		��daomian�����洴��User.java����װ
	2.2dao���ʵ��
		2.2.1дdao���ʵ����
			��dao.impl��дUserDaoImpl.java
		2.2.2�����÷���д�빤������ XmlUtils
			д��getDocument��write2Xml��������
		2.2.3д������UserDaoTest 
			ÿһ��д���Ҫ���в���	
		2.2.4��ȡdao�Ľӿ�  
			refactor--extract interface
	2.3service���ʵ��
		2.2.1дservice���ʵ����
			��Service.impl��дBusinessService��
		2.2.2��������ܷ���д��ServiceUtils��
			дmd5����
		2.2.3д���Է���
	2.4web��ʵ��
		2.4.1index.jspʵ���������ܣ�ע��͵�¼
			ע�Ṧ����ת��web.UI���е�RegisterUIServlet
			��¼������ת��web.UI���е�LoginUIServlet
		2.4.2RegisterUIServlet��ת��register.jspҳ����ʾ
		2.4.3�û���������Ϣ֮�󣬵��ע�ᣬ������ת��RegisterServletҳ��
			RegisterServlet���û������йأ��̷���web.controller����
		2.4.4����registerForm���javabean��ע���û���������ݽ���У��
		2.4.5����WebUtils��������Է����װ����  
			WebUtils��д��һ��copybean���������ע����ɹ�����form copy ��user��
		2.4.6����BusinessServiceImpl���󣬵���register����
			д������������з���
3.Loginҳ���ʵ��
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			
		
		
		
		
		
		
		
		
	
	
	