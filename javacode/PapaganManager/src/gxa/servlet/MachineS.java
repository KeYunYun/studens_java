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
	Conn conn;// һ����Ķ��������Ҫʹ�õı�������Ա������ֻ��һ������ʹ�õı����ֲ�

	public MachineS() {
		super();
		conn = new Conn();// ��Ա�������ڹ��췽���г�ʼ�� new
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
		doPost(request, response);// ��������Ҫ�ֶ��ڵ�ַ������������в���
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		option = request.getParameter("option");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		// �������û����
		String sql = "";
		if (option.equals("list")) {
			sql = "select * from machine";
			ResultSet rs = conn.select(sql);
			request.setAttribute("rs", rs);// ����õĽ������ŵ��û�������������ȡ����rs
			request.getRequestDispatcher("machine/list.jsp").forward(request,
					response);
			// �����û��������ת��ָ��ҳ��
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
						.println("<script>alert('���ӳɹ�');window.location.href='MachineS?option=list'</script>");
			} else {
				out
						.println("<script>alert('����ʧ�ܣ�¼������ݿ����Ѵ���');window.location.href='MachineS?option=list'</script>");
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
						.println("<script>alert('�޸ĳɹ�');window.location.href='MachineS?option=list'</script>");
			} else {
				out
						.println("<script>alert('�޸�ʧ�ܣ����ݿ��ܲ�����');window.location.href='MachineS?option=list'</script>");
			}

		} else if (option.equals("delete")) {
			out.println(option);
		} else if (option.equals("find")) {
			String mno = request.getParameter("mno");
			sql = "select * from machine where mno='" + mno + "'";
			ResultSet rs = conn.select(sql);
			request.setAttribute("rs", rs);// ����õĽ������ŵ��û�������������ȡ����rs
			request.getRequestDispatcher("machine/update.jsp").forward(request,
					response);
			// �����û��������ת��ָ��ҳ��
		}else	if (option.equals("monitor")) {
			sql = "select * from machine where mtype = 'ǹ��' or mtype= '���'";
			ResultSet rs = conn.select(sql);
			List<Machine> machines = new ArrayList<Machine>();
            try {
				while(rs.next()){
					Machine machine = new Machine();//ÿ��ȡ��һ����¼���Ͷ�Ӧһ���豸����
					machine.setMno(rs.getString(1));//����ȡ����ֵ���浽�豸�����Ӧ������
					machine.setMname(rs.getString(2));
					machine.setMtype(rs.getString(3));
					machine.setMdesc(rs.getString(4));
					machine.setAno(rs.getString(5));
					machine.setX(rs.getInt(6));
					machine.setY(rs.getInt(7));
					machines.add(machine);//���豸�����豸����
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ʹ��json���߽�java�ļ���ת��Ϊjs�ļ���
			JSONArray nmachines = JSONArray.fromObject(machines);
			out.print(nmachines);
			// �����û��������ת��ָ��ҳ��
		} 
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
