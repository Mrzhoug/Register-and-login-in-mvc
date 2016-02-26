package zgq.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	private String nickname;

	private Map errors = new HashMap();

	public Map getErrors() {
		return errors;
	}

	public void setErrors(Map errors) {
		this.errors = errors;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	// У�����
	// У������û�������Ϊ�գ�������3-6λ��ĸ
	// ���벻��Ϊ�գ�������3-6λ����
	// ȷ�����벻��Ϊ�գ����Һ͵�һ������һ��
	// ���䲻��Ϊ�գ����ҷ��ϺϷ����� ������������ʽ
	// ���տ���Ϊ�գ������Ϊ�գ��������һ���Ϸ�����
	// �ǳƱ����Ǻ���
	public boolean validdate() {
		boolean isOK = true;
		if (username == null || username.trim().equals("")) {
			isOK = false;
			errors.put("username", "�û�������Ϊ��");
		} else {
			if (!this.username.matches("[A-Za-z]{3,8}")) {
				isOK = false;
				errors.put("username", "�û�������3-8λ��ĸ");
			}
		}

		if (password == null || password.trim().equals("")) {
			isOK = false;
			errors.put("password", "���벻��Ϊ��");
		} else {
			if (!this.password.matches("\\d{3,8}")) {
				isOK = false;
				errors.put("password", "�������3-8λ����");
			}
		}

		if (password2 == null || password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "ȷ�����벻��Ϊ��");
		} else {
			if (!this.password.equals(password2)) {
				isOK = false;
				errors.put("password2", "��������Ҫһ��");
			}
		}

		if (email == null || email.trim().equals("")) {
			isOK = false;
			errors.put("email", "���䲻��Ϊ��");
		} else {
			if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "�����ʽ����ȷ");
			}
		}

		if (this.birthday != null && !this.birthday.trim().equals("")) {
			try {
				DateLocaleConverter dic = new DateLocaleConverter();
				dic.convert(this.birthday, "yyyy-MM-dd");
			} catch (Exception e) {
				isOK = false;
				errors.put("birthday", "���ڸ�ʽ����");
			}
		}

		if (nickname == null || nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "�ǳƲ���Ϊ��");
		} else {
			if (!this.nickname.matches("[\u4e00-\u9fa5]+")) {
				isOK = false;
				errors.put("nickname", "�ǳƱ���Ϊ����");
			}
		}
		return isOK;
	}

}
