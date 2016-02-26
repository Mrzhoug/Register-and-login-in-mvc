package zgq.dao.impl;

import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.Element;

import zgq.dao.UserDao;
import zgq.domain.User;
import zgq.utils.XmlUtils;

public class UserDaoImpl implements UserDao {
	//����ҵ�������֪�û���¼��ע����Ҫ��add������find����
	/* (non-Javadoc)
	 * @see zgq.dao.impl.UserDao#add(zgq.domain.User)
	 */
	public void add(User user){
		try {
			Document document=XmlUtils.getDocment();
			Element root =document.getRootElement(); //��ȡ���ڵ�
			
			Element user_tag= root.addElement("user"); //����user�ڵ�
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
			user_tag.setAttributeValue("nickname", user.getNickname());
			XmlUtils.write2Xml(document);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//�û���¼ʱ����û��������Ƿ���ȷ
	/* (non-Javadoc)
	 * @see zgq.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	public User find(String username,String password){
		try {
			Document document=XmlUtils.getDocment();
			Element element=(Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(element==null){
				return null;
			}
			User user=new User();
			String date=element.attributeValue("birthday");
			if(date==null||date.equals("")){
				user.setBirthday(null);
			}else {
				SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(sd.parse(date));
			}
			
			user.setEmail(element.attributeValue("email"));
			user.setId(element.attributeValue("id"));
			user.setNickname(element.attributeValue("nickname"));
			user.setPassword(element.attributeValue("password"));
			user.setUsername(element.attributeValue("username"));
		
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//�û�ע��ʱ�����û���������ݿ����Ƿ������ͬ�û���
	/* (non-Javadoc)
	 * @see zgq.dao.impl.UserDao#find(java.lang.String)
	 */
	public boolean find(String username){
		try {
			Document document=XmlUtils.getDocment();
			Element element=(Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(element==null){
				return false;
			}
			return true;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

