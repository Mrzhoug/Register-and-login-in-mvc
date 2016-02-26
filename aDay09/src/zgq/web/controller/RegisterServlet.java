package zgq.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zgq.domain.User;
import zgq.exception.UserExistException;
import zgq.service.impl.BusinessServiceImpl;
import zgq.utils.WebUtils;
import zgq.web.formbean.RegisterForm;
//����ע������
public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.���û��ύ���ֶν��кϷ���У��(�ѱ����ݷ�װ��formbean)
		RegisterForm form=WebUtils.request2bean(request, RegisterForm.class);
		boolean b=form.validdate();
		
		//2.���У��ʧ�ܣ����ص���ҳ�棬������ʾУ��ʧ����Ϣ
		request.setAttribute("form", form);
		if(!b){
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3.���У��ɹ��������Service����ע������
		User user=new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		
		BusinessServiceImpl service=new BusinessServiceImpl();
		try {
			service.register(user);
			//6.���Service����ɹ�����ת����ʾȫ����Ϣҳ�棬Ϊ�û���ʾע��ɹ���Ϣ
			request.setAttribute("message", "ע��ɹ�������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.���Service�����ɹ������Ҳ��ɹ���ԭ������Ϊע���û��Ѿ����ڣ�����ص�ע��ҳ�棬��ʾע���û��Ѵ��ڵ���Ϣ
			form.getErrors().put("username", "ע���û��Ѿ����ڣ�����");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch(Exception e){
			//5.���Service�����ɹ������Ҳ��ɹ���ԭ��������ԭ����ҳ����ת����������ȫ��ҳ�棬Ϊ�û���ʾ�Ѻô�����Ϣ
			request.setAttribute("message","����������δ֪���󣡣���");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
