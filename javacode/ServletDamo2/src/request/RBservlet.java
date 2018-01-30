package request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RBservlet extends HttpServlet {

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
		//获得所以参数的键
		Enumeration<String> en=
				request.getParameterNames();
		//遍历所以键
		while(en.hasMoreElements()){
			String key=en.nextElement();
			String value=request.
					getParameter(key);
			System.out.println(key+"==>"+value);
		}
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得所以参数的键
				Enumeration<String> en=
						request.getParameterNames();
				//遍历所以键
				while(en.hasMoreElements()){
					String key=en.nextElement();
					String value=request.
							getParameter(key);
					System.out.println(key+"==>"+value);
				}
		
	}

}
