package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnPool;

public class LEDNotices extends HttpServlet {
	String option;
	ResultSet rs = null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		option = request.getParameter("option");
		PrintWriter out = response.getWriter();
		String sql="";
		 if(option.equals("add")){
			//int id =Integer.parseInt(request.getParameter("ID"));
			String roomid = request.getParameter("roomid");
			String typehead = request.getParameter("typehead");
			sql = "insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomid+"','1','"+typehead+"');";
			int rse ;
			ConnPool conn=new ConnPool();
			try {
				
				rse =conn.update(sql);
				if(rse>0){
					out.println("<script>alert('发送成功');</script>");
				}else{
					out.println("<script>alert('发送失败');'</script>");
				}
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
