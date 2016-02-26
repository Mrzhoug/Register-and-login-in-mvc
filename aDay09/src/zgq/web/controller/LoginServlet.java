package zgq.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zgq.domain.User;
import zgq.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		BusinessServiceImpl service=new BusinessServiceImpl();
		System.out.println("aa");
		User user= service.login(username, password);
		if(user!=null){
			request.getSession().setAttribute("user", user);
			//�û���¼�ɹ�����ת����ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		request.setAttribute("message", "�û��������������");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
