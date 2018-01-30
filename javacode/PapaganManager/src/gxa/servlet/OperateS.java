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
    Conn conn;//һ����Ķ��������Ҫʹ�õı�������Ա������ֻ��һ������ʹ�õı����ֲ�
	public OperateS() {
		super();
		conn = new Conn();//��Ա�������ڹ��췽���г�ʼ�� new
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
	    doPost(request, response);//��������Ҫ�ֶ��ڵ�ַ������������в���
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		option = request.getParameter("option");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		//�������û����
	    String sql = "";
		if(option.equals("list")){
			sql = "select * from operate";
			ResultSet rs = conn.select(sql);
			request.setAttribute("rs", rs);//����õĽ������ŵ��û�������������ȡ����rs
			request.getRequestDispatcher("operate/list.jsp").forward(request, response);
			//�����û��������ת��ָ��ҳ��
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
