package timetable;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnPool;

public class TimeTable extends HttpServlet {
	private String option;
	ResultSet rs = null;
	String courseID = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		option=request.getParameter("option");
		PrintWriter out = response.getWriter();
		String sql="";
		
		if(option.equals("list")){
			ConnPool conn=new ConnPool();
			try{
				 sql ="select * from tb_timetable";
				 rs =conn.select(sql);
				 System.out.println(sql);
				 request.setAttribute("rs", rs);
				 request.getRequestDispatcher("timetable/showtimetable.jsp").forward(request, response);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}else if(option.equals("add")){
			 courseID = request.getParameter("courseID");
			String courseName = request.getParameter("courseName");
			String className = request.getParameter("className");
			String wno = request.getParameter("wno");
			String roomID = request.getParameter("roomID");	
			String shoolTime = request.getParameter("shoolTime");
			String breaktime = request.getParameter("breaktime");	
			sql = "insert into tb_timetable(courseID,courseName,className,wno,roomID,shoolTime,breaktime)"
					+ " values('"+courseID+"','"+courseName+"','"+className+"','"+wno+"','"+roomID+"','"+shoolTime+"','"+breaktime+"')";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('添加成功');window.location.href='./TimeTable?option=list'</script>");
				}else{
					out.println("<script>alert('添加失败');window.location.href='./TimeTable?option=list'</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}else if (option.equals("find")) {
			courseID =request.getParameter("courseID");
			System.out.println(courseID);
			sql = "select * from tb_timetable where courseID='"+courseID+"'";
			ConnPool conn=new ConnPool();
			System.out.println(sql);
			try {
				
				rs =conn.select(sql);
				request.setAttribute("rs", rs);
				request.getRequestDispatcher("timetable/updatetimetable.jsp").forward(request, response);
				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
			
		}else if (option.equals("update")) {
			 courseID = request.getParameter("courseID");
			String courseName = request.getParameter("courseName");
			String className = request.getParameter("className");
			String wno = request.getParameter("wno");
			String roomID = request.getParameter("roomID");	
			String shoolTime = request.getParameter("shoolTime");
			String breaktime = request.getParameter("breaktime");
			System.out.println(roomID+courseName+className);

			sql = "update tb_timetable set courseID='"+courseID+"',courseName='"+courseName+"',className='"+className+"'"
					+ ",wno='"+wno+"',roomID='"+roomID+"',shoolTime='"+shoolTime+"',breaktime='"+breaktime+"' where courseID='"+courseID+"'";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('修改成功');window.location.href='./TimeTable?option=list'</script>");
				}else{
					out.println("<script>alert('修改失败');window.location.href='./TimeTable?option=list'</script>");
				}
				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
			
		}else if(option.equals("delete")){
			courseID = request.getParameter("courseID");
			System.out.println(courseID);
			sql = "delete from tb_timetable  where courseID='"+courseID+"'";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('删除成功');window.location.href='./TimeTable?option=list'</script>");
				}else{
					out.println("<script>alert('删除失败');window.location.href='./TimeTable?option=list'</script>");
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
