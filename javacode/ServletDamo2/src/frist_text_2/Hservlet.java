package frist_text_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hservlet extends HttpServlet {

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

		//获得servletContext对象
		ServletContext sc=getServletContext();
		//调用方法重ServletContext中的map取出值
		String bag=(String)sc.getAttribute("bag");
		String car=(String)sc.getAttribute("car");
		System.out.println(bag+"==>"+car);
		//遍历键值
		Enumeration<String> en =sc.getAttributeNames();
		while(en.hasMoreElements()){
			String key=en.nextElement();
			System.out.println(key);
		}
	}

}
