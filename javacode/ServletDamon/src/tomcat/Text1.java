package tomcat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Text1 extends HttpServlet {
	public void service(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException,IOException{
		//设置服务器返回的数据类型
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println(
				"<h1> Hello Kitty </h1>");
		out.close();
	}
}
