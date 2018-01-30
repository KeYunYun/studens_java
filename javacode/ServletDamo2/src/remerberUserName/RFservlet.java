package remerberUserName;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RFservlet extends HttpServlet {

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得键的名字
		String name=request.getParameter("name");
		//校验用户名密码
		if(name==null||"".equals(name.trim())){
			request.setAttribute("error", "请输入用户名");
			request.getRequestDispatcher("/remeber/login.jsp").forward(request, response);
			return;
		}
		//创建cookies添加要保存的用户名
		Cookie c=new Cookie("remember", name);
		//查看记住用户名是否被选中
		String remember =request.getParameter("remember");
		if("yes".equals(remember)){
			c.setMaxAge(60*60*24*7);
		}else{
			c.setMaxAge(0);
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
