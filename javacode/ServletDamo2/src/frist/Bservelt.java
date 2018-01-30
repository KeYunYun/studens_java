package frist;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Bservelt implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	//方法功能是放回ServletConfig对象，由init（）方法穿过来的
	//定义一个变量
	private ServletConfig config;
	public ServletConfig getServletConfig() {
		
		return config;
	}
	
	public void init(ServletConfig arg0) throws ServletException {
		//因为config对象要在getServlet方法中返回
		
		this.config=arg0;
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse resp) throws ServletException, IOException {
	 Enumeration<String> en=
			 getServletConfig().getInitParameterNames();
		//获得键值集
	 while(en.hasMoreElements()){
		 String key=en.nextElement();
		 String value=getServletConfig().
				 getInitParameter(key);
		 
		 resp.getWriter().write(key+"==>"+value+"<br>");
		 //response推送信息
	 }
	 String servletName=getServletConfig()
			 .getServletName();
	 resp.getWriter().write(servletName);
	}
	
	@Override
	//没有用，可以用于返回作者，版权等信息
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
