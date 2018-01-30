package tomcat_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BMIServelet extends HttpServlet {
	public void service(HttpServletRequest 
			request,HttpServletResponse response)
	throws ServletException,IOException{
		//读请求参数值
	String weight=request.getParameter("weight");
	String height=request.getParameter("height");
		//计算
	double bmi=Double.parseDouble(weight)/Double
			.parseDouble(height)/Double.parseDouble(height)
			;
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println(bmi);
	out.close();
	}
}
