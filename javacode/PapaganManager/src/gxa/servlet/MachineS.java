package gxa.servlet;

import gxa.entity.Machine;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import Conn.Conn;

public class MachineS extends HttpServlet {
	String option;
	Conn conn;// 一个类的多个方法都要使用的变量做成员变量，只有一个方法使用的变量局部

	public MachineS() {
		super();
		conn = new Conn();// 成员变量都在构造方法中初始化 new
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
		doPost(request, response);// 当我们需要手动在地址栏输出参数进行测试
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		option = request.getParameter("option");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		// 代表向用户输出
		String sql = "";
		if (option.equals("list")) {
			sql = "select * from machine";
			ResultSet rs = conn.select(sql);
			request.setAttribute("rs", rs);// 将获得的结果集存放到用户的请求属性中取名叫rs
			request.getRequestDispatcher("machine/list.jsp").forward(request,
					response);
			// 代表用户浏览器跳转到指定页面
		} else if (option.equals("add")) {
			String mno = request.getParameter("mno");
			String mname = request.getParameter("mname");
			String mtype = request.getParameter("mtype");
			String mdesc = request.getParameter("mdesc");
			String ano = request.getParameter("ano");
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));

			sql = "insert into machine values('" + mno + "','" + mname + "','"
					+ mtype + "','" + mdesc + "','" + ano +"'," + x +"," + y + ")";
			int rs = conn.update(sql);
			if (rs > 0) {
				out
						.println("<script>alert('增加成功');window.location.href='MachineS?option=list'</script>");
			} else {
				out
						.println("<script>alert('增加失败，录入的数据可能已存在');window.location.href='MachineS?option=list'</script>");
			}

		} else if (option.equals("update")) {
			String mno = request.getParameter("mno");
			String mname = request.getParameter("mname");
			String mtype = request.getParameter("mtype");
			String mdesc = request.getParameter("mdesc");
			String ano = request.getParameter("ano");

			sql = "update machine set mno='" + mno + "',mname='" + mname
					+ "',mtype='" + mtype + "',mdesc='" + mdesc + "',ano='"
					+ ano + "' where mno='" + mno + "'";
			System.out.println(sql);
			int rs = conn.update(sql);
			if (rs > 0) {
				out
						.println("<script>alert('修改成功');window.location.href='MachineS?option=list'</script>");
			} else {
				out
						.println("<script>alert('修改失败，数据可能不存在');window.location.href='MachineS?option=list'</script>");
			}

		} else if (option.equals("delete")) {
			out.println(option);
		} else if (option.equals("find")) {
			String mno = request.getParameter("mno");
			sql = "select * from machine where mno='" + mno + "'";
			ResultSet rs = conn.select(sql);
			request.setAttribute("rs", rs);// 将获得的结果集存放到用户的请求属性中取名叫rs
			request.getRequestDispatcher("machine/update.jsp").forward(request,
					response);
			// 代表用户浏览器跳转到指定页面
		}else	if (option.equals("monitor")) {
			sql = "select * from machine where mtype = '枪机' or mtype= '球机'";
			ResultSet rs = conn.select(sql);
			List<Machine> machines = new ArrayList<Machine>();
            try {
				while(rs.next()){
					Machine machine = new Machine();//每获取到一条记录，就对应一个设备对象
					machine.setMno(rs.getString(1));//将获取到的值保存到设备对象对应的属性
					machine.setMname(rs.getString(2));
					machine.setMtype(rs.getString(3));
					machine.setMdesc(rs.getString(4));
					machine.setAno(rs.getString(5));
					machine.setX(rs.getInt(6));
					machine.setY(rs.getInt(7));
					machines.add(machine);//将设备放入设备集合
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//使用json工具将java的集合转换为js的集合
			JSONArray nmachines = JSONArray.fromObject(machines);
			out.print(nmachines);
			// 代表用户浏览器跳转到指定页面
		} 
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
