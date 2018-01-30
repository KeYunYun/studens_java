package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String user =request.getParameter("user");
		String pwd=request.getParameter("pwd");
		String code1 = request.getParameter("code");
		String code2 = (String) request.getSession().getAttribute("code");
		IdentPwd indet=new IdentPwd();
		
		if(indet.checkUsePwd(user, pwd)&&IdentPwd.checkIdentCode(request, response,code1,code2)){
			response.sendRedirect("/webSystem/manager/homepage.jsp");
			
		}else if(indet.checkmanage(user, pwd)&&IdentPwd.checkIdentCode(request, response,code1,code2)){
			response.sendRedirect("/webSystem/manager/managerpage.jsp");
		
		}else if(!IdentPwd.checkIdentCode(request, response,code1,code2)){
			//失败=> 转发到登录页面并提示
			request.setAttribute("error", "请输入正确的验证码");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		}else{
		
			request.setAttribute("pwerror", "请输入正确的密码或用户名");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
