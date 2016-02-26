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

	// 校验代码
	// 校验规则：用户名不能为空，并且是3-6位字母
	// 密码不能为空，并且是3-6位数字
	// 确认密码不能为空，并且和第一次密码一致
	// 邮箱不能为空，并且符合合法邮箱 考察多个正则表达式
	// 生日可以为空，如果不为空，则必须是一个合法日期
	// 昵称必须是汉字
	public boolean validdate() {
		boolean isOK = true;
		if (username == null || username.trim().equals("")) {
			isOK = false;
			errors.put("username", "用户名不能为空");
		} else {
			if (!this.username.matches("[A-Za-z]{3,8}")) {
				isOK = false;
				errors.put("username", "用户名必须3-8位字母");
			}
		}

		if (password == null || password.trim().equals("")) {
			isOK = false;
			errors.put("password", "密码不能为空");
		} else {
			if (!this.password.matches("\\d{3,8}")) {
				isOK = false;
				errors.put("password", "密码必须3-8位数字");
			}
		}

		if (password2 == null || password2.trim().equals("")) {
			isOK = false;
			errors.put("password2", "确认密码不能为空");
		} else {
			if (!this.password.equals(password2)) {
				isOK = false;
				errors.put("password2", "两次密码要一致");
			}
		}

		if (email == null || email.trim().equals("")) {
			isOK = false;
			errors.put("email", "邮箱不能为空");
		} else {
			if (!this.email.matches("\\w+@\\w+(\\.\\w+)+")) {
				isOK = false;
				errors.put("email", "邮箱格式不正确");
			}
		}

		if (this.birthday != null && !this.birthday.trim().equals("")) {
			try {
				DateLocaleConverter dic = new DateLocaleConverter();
				dic.convert(this.birthday, "yyyy-MM-dd");
			} catch (Exception e) {
				isOK = false;
				errors.put("birthday", "日期格式不对");
			}
		}

		if (nickname == null || nickname.trim().equals("")) {
			isOK = false;
			errors.put("nickname", "昵称不能为空");
		} else {
			if (!this.nickname.matches("[\u4e00-\u9fa5]+")) {
				isOK = false;
				errors.put("nickname", "昵称必须为汉字");
			}
		}
		return isOK;
	}

}
