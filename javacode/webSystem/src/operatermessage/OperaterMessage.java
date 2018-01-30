package operatermessage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnPool;

public class OperaterMessage extends HttpServlet {
	String option;
	public void doGet( HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		option=request.getParameter("option");
		if(option.equals("list")){	
						ConnPool conn=new ConnPool();
						ResultSet rs;
						
						try{
							 String sql ="select * from tb_dealwithmessage";
							 rs =conn.select(sql);
							 request.setAttribute("rs", rs);
							 request.getRequestDispatcher("operatemessage/messageshow.jsp").forward(request, response);
							
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}finally{
							ConnPool.closeConnection();
						}
						}else if (option.equals("find")) {
							 String roomid =request.getParameter("roomid");
								
								String	sql = "select * from tb_dealwithmessage where roomID='"+roomid+"'";
									ConnPool conn=new ConnPool();
									System.out.println(sql);
									try{
									  ResultSet  rs =conn.select(sql);
										request.setAttribute("rs", rs);
										request.getRequestDispatcher("operatemessage/findresult.jsp").forward(request, response);
										System.out.println(sql);
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}finally{
										ConnPool.closeConnection();
									}		
							
						}else if (option.equals("drop")) {
							String sql = "truncate table tb_dealwithmessage";
					
							ConnPool conn=new ConnPool();
							try {
								
								int rse =conn.update(sql);
								if(rse>0){
									out.println("<script>alert('修改成功');window.location.href='./OperaterMessage?option=list'</script>");
								}else{
									out.println("<script>alert('修改失败');window.location.href='./OperaterMessage?option=list'</script>");
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
