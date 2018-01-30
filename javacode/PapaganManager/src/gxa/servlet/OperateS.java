package gxa.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Conn.Conn;

public class OperateS extends HttpServlet {
    String option;
    Conn conn;//一个类的多个方法都要使用的变量做成员变量，只有一个方法使用的变量局部
	public OperateS() {
		super();
		conn = new Conn();//成员变量都在构造方法中初始化 new
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        option = request.getParameter("option");
	    doPost(request, response);//当我们需要手动在地址栏输出参数进行测试
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		option = request.getParameter("option");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		//代表向用户输出
	    String sql = "";
		if(option.equals("list")){
			sql = "select * from operate";
			ResultSet rs = conn.select(sql);
			request.setAttribute("rs", rs);//将获得的结果集存放到用户的请求属性中取名叫rs
			request.getRequestDispatcher("operate/list.jsp").forward(request, response);
			//代表用户浏览器跳转到指定页面
		}else if(option.equals("add")){
			out.println(option);
		}else if(option.equals("update")){
			out.println(option);
		}else if(option.equals("delete")){
			out.println(option);
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
