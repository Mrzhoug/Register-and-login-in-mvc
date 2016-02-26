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
//处理注册请求
public class RegisterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.对用户提交的字段进行合法性校验(把表单数据封装到formbean)
		RegisterForm form=WebUtils.request2bean(request, RegisterForm.class);
		boolean b=form.validdate();
		
		//2.如果校验失败，跳回到表单页面，返回显示校验失败信息
		request.setAttribute("form", form);
		if(!b){
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}
		
		//3.如果校验成功，则调用Service处理注册请求
		User user=new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		
		BusinessServiceImpl service=new BusinessServiceImpl();
		try {
			service.register(user);
			//6.如果Service处理成功，跳转到显示全局消息页面，为用户显示注册成功消息
			request.setAttribute("message", "注册成功！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		} catch (UserExistException e) {
			//4.如果Service处理不成功，并且不成功的原因是因为注册用户已经存在，则调回到注册页面，显示注册用户已存在的信息
			form.getErrors().put("username", "注册用户已经存在！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch(Exception e){
			//5.如果Service处理不成功，并且不成功的原因是其他原因，则页面跳转到处理错误的全局页面，为用户显示友好错误消息
			request.setAttribute("message","服务器出现未知错误！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
