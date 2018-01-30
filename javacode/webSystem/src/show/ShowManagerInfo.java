package show;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnPool;

public class ShowManagerInfo extends HttpServlet {
	String option;
	ResultSet rs = null;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		option = request.getParameter("option");
		PrintWriter out = response.getWriter();
		String sql="";
		if(option.equals("list")){
			ConnPool conn=new ConnPool();
			try{
				 sql ="select * from tb_manage";
				 rs =conn.select(sql);
				 request.setAttribute("rs", rs);
				 request.getRequestDispatcher("manager/showInof.jsp").forward(request, response);
				 System.out.println(sql);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}else if (option.equals("find")) {
			int id =Integer.parseInt(request.getParameter("ID"));
			sql = "select * from tb_manage where ID="+id+"";
			ConnPool conn=new ConnPool();
			try {
				
				rs =conn.select(sql);
				request.setAttribute("rs", rs);
				request.getRequestDispatcher("manager/updateInfo.jsp").forward(request, response);
				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
			
		}else if (option.equals("update")) {
			int id =Integer.parseInt(request.getParameter("ID"));
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String classname = request.getParameter("classname");
			String wno = request.getParameter("wno");
			String pname = request.getParameter("pname");
			String RFID = request.getParameter("RFID");
			String tatic = request.getParameter("tatic");
			

			sql = "update tb_manage set ID="+id+",name='"+name+"',password='"+pwd+"',"
					+ "classname='"+classname+"',wno='"+wno+"',phonename='"+pname+"',RFIDnum='"+RFID+"',tatic='"+tatic+"' where ID="+id+"";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('修改成功');window.location.href='./ShowManagerInfo?option=list'</script>");
				}else{
					out.println("<script>alert('修改失败');window.location.href='./ShowManagerInfo?option=list'</script>");
				}
				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
			
		}else if(option.equals("add")){
			//int id =Integer.parseInt(request.getParameter("ID"));
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String classname = request.getParameter("classname");
			String wno = request.getParameter("wno");
			String pname = request.getParameter("pname");
			String RFID = request.getParameter("RFID");
			String tatic = request.getParameter("tatic");	
			sql = "insert into tb_manage(name,password,classname,wno,phonename,RFIDnum,tatic) values('"+name+"','"+pwd+"','"+classname+"','"+wno+"','" + pname + "','" +RFID +"'," + tatic + ")";
			System.out.println(sql);
			
			ConnPool conn=new ConnPool();
			try {
				
			int rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('添加成功');window.location.href='./ShowManagerInfo?option=list'</script>");
				}else{
					out.println("<script>alert('添加失败');window.location.href='./ShowManagerInfo?option=list'</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}else if(option.equals("delete")){
			int id =Integer.parseInt(request.getParameter("ID"));
			sql = "delete from tb_manage where ID="+id+"";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('删除成功');window.location.href='./ShowManagerInfo?option=list'</script>");
				}else{
					out.println("<script>alert('删除失败');window.location.href='./ShowManagerInfo?option=list'</script>");
				}

				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
