package response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ftupian extends HttpServlet {

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
		/**
		 * 图片下载
		 */
		//获得图片的输入流
		InputStream is=
				getServletContext().
				getResourceAsStream("/WEB-INF/lib/897.jgp");
		//使用ServletContext中的getResourceAsStream
		//获得相对位置
		OutputStream os=response.getOutputStream();
		//获得输出到浏览器的输出流
		byte[] buffer =new byte[1024];
		int len = -1;
		while(-1!=(len=is.read(buffer))){
			os.write(buffer, 0, len);
			os.flush();
		}
		os.close();
		is.close();
	}
	
}
