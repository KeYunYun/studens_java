package cheakmessage;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import Uilty.CheckMessUtils;
import Uilty.StringToDateUtils;
import jdbc.ConnPool;

public class ChackMess implements Runnable {
	Set<CheckMessUtils> set;
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true){
			set =new HashSet<CheckMessUtils>();
			CheckMessUtils checkMessutils=new CheckMessUtils();
			ConnPool conn=new ConnPool();
			String cardnum="";
			ResultSet rs =conn.select("select * from tb_rececard");
			ResultSet copere=rs;
			String recrtime = "";
			String wno = "";
			String className="";
			String courseName="";
			String shoolTime="";
			String breakTime="";
			String roomid="";
			String name="";
			Long recedate;
			Long shooltime;
			Long breaktime;
			try{	
				if(rs.next()){
					roomid=rs.getString("rooimid");
				    cardnum= rs.getString("cardnum");
					 recrtime= rs.getString("recetime").substring(11,19); 
				
				ResultSet resultset1= conn.select("select wno,name from tb_manage where RFIDnum='"+cardnum+"'");
				System.out.println(cardnum);
				if(resultset1.next()){
					wno=resultset1.getString("wno");
					name=resultset1.getString("name");
					ResultSet resultset2= conn.select("select courseName,roomID,shoolTime,breaktime from tb_timetable where wno='"+wno+"'");	
					if(resultset2.next()){
						courseName=resultset2.getString("courseName");
						className=resultset2.getString("roomID");
						shoolTime=resultset2.getString("shoolTime");
						breakTime=resultset2.getString("breaktime");
						recedate=StringToDateUtils.StrToDate(recrtime).getTime();
						shooltime=StringToDateUtils.StrToDate(shoolTime).getTime();
						breaktime=StringToDateUtils.StrToDate(breakTime).getTime();
						System.out.println("recedate>shooltime"+(recedate>shooltime));
						System.out.println("recedate<breaktime"+(recedate<breaktime));
						System.out.println("roomid.equals(className)"+(roomid.equals(className)));
						if(recedate>shooltime&&recedate<breaktime&&roomid.equals(className)){
							System.out.println("open");
							 String sql1 = "update tb_classroom set roomStatus='1' where roomID='"+className+"'";											
							conn.update(sql1);	
							String sql2="insert into tb_dealwithmessage(roomID,Tname,RFIFnum,courseName,currenttime)"+
							" values('"+className+"','"+name+"','"+cardnum+"','"+courseName+"',now())";
							conn.update(sql2);
							conn.update("insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomid+"','2','"+"yztg"+"');");
						}else{
							System.out.println("时间未到或者教室不对");
							conn.update("insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomid+"','2','"+"myqx"+"');");
							conn.update("update tb_classroom set roomStatus='"+0+"' where roomID='"+roomid+"'");
						}
					}else{
						System.out.println("信息不对");
						conn.update("insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomid+"','2','"+"myqx"+"');");
						conn.update("update tb_classroom set roomStatus='"+0+"' where roomID='"+roomid+"'");
					}
				}else{
					conn.update("insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomid+"','2','"+"myqx"+"');");
					conn.update("update tb_classroom set roomStatus='"+0+"' where roomID='"+roomid+"'");
				}
				}else{

				}
				conn.update("truncate table tb_rececard ");
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				
				ConnPool.closeConnection();
				
			}
			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
