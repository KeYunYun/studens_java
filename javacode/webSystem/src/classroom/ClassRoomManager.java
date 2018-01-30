package classroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import jdbc.ConnPool;


public class ClassRoomManager extends HttpServlet {
	private String option;
	private boolean flag=false;
	ResultSet rs = null;
	String classroomID = "";
	String topic="";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		option=request.getParameter("option");
		PrintWriter out = response.getWriter();
		String sql="";
		
		if(option.equals("list")){
			ConnPool conn=new ConnPool();
			try{
				 sql ="select * from tb_classroom";
				 rs =conn.select(sql);
				 System.out.println(sql);
				 request.setAttribute("rs", rs);
				 request.getRequestDispatcher("classroomManage/ShowClassRoom.jsp").forward(request, response);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}else if(option.equals("add")){
			String roomID = request.getParameter("roomID");
			String roomName = request.getParameter("roomName");
			String roomStatus = request.getParameter("roomStatus");	
			sql = "insert into tb_classroom(roomID,roomName,roomStatus) values('"+roomID+"','"+roomName+"','"+roomStatus+"')";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('添加成功');window.location.href='./ClassRoomManager?option=list'</script>");
				}else{
					out.println("<script>alert('添加失败');window.location.href='./ClassRoomManager?option=list'</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}else if (option.equals("find")) {
			 classroomID =request.getParameter("classroomID");
			System.out.println(classroomID);
			sql = "select * from tb_classroom where roomID='"+classroomID+"'";
			ConnPool conn=new ConnPool();
			System.out.println(sql);
			try {
				
				rs =conn.select(sql);
				request.setAttribute("rs", rs);
				request.getRequestDispatcher("classroomManage/updateClassRoom.jsp").forward(request, response);
				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
			
		}else if (option.equals("update")) {
			String roomID = request.getParameter("roomID");
			String roomName = request.getParameter("roomName");
			String roomStatus = request.getParameter("roomStatus");
			System.out.println(roomID+roomName+roomStatus);
			
			sql = "update tb_classroom set roomID='"+roomID+"',roomName='"+roomName+"',roomStatus='"+roomStatus+"' where roomID='"+classroomID+"'";
			System.out.println(sql);
			int rse ;
			int intstatus = Integer.parseInt(roomStatus);
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				
				if(rse>0){
					out.println("<script>alert('修改成功');window.location.href='./ClassRoomManager?option=list'</script>");
					if(1==intstatus){
						flag=true;
						topic=roomID;
						System.out.println("res"+flag);
						System.out.println("res"+topic);
						
					}
				}else{
					out.println("<script>alert('修改失败');window.location.href='./ClassRoomManager?option=list'</script>");
				}
				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
			
		}else if(option.equals("delete")){
			String roomID = request.getParameter("classroomID");
			System.out.println(roomID);
			sql = "delete from tb_classroom  where roomID='"+roomID+"'";
			System.out.println(sql);
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('删除成功');window.location.href='./ClassRoomManager?option=list'</script>");
				}else{
					out.println("<script>alert('删除失败');window.location.href='./ClassRoomManager?option=list'</script>");
				}

				System.out.println(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnPool.closeConnection();
			}
		}
		if(flag){
			System.out.println("flag++++++++"+flag);
			System.out.println("++++++++++++"+topic); 
			 String payload=topic+"123";
				System.out.println("++++++++++++"+payload); 
			//	new ServerMqtt("3-112","88888");  
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
