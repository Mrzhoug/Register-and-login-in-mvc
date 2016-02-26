package zgq.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//�����û�ע������
public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
		}
		//ע���ɹ�����תȫ����Ϣ��ʾҳ��
		request.setAttribute("message", "ע���ɹ������������3�����ת�����û����ת����͵�....����<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/index.jsp'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
