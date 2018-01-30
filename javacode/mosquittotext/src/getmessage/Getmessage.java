package getmessage;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import jdbc.ConnPool;
import mqtt.ClientMqtt;
import mqtt.ServerMqtt;

public class Getmessage implements Runnable {
	String sql;
	String  flag0="null ";
	int setlength=0;
	int setlength_0=0;
	Set<String> strstate;
	Set<String> strstate_0;
	boolean flag=false;
	String roomID="";
	String state="0";
	String int_state="";
	String payload="";
	public Getmessage(boolean flag){
		this.flag=flag;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			
		strstate=new HashSet<String>();
		strstate_0=new HashSet<String>();
		ConnPool conn=new ConnPool();
		ResultSet rs;
		try{
			 sql ="select * from tb_classroom";
			 rs =conn.select(sql);
			 while(rs.next()){
				  roomID=rs.getString("roomID");
				  state =rs.getString("roomStatus");
				  
				 int_state=roomID+state;
				 if((roomID+"1").trim().equals(int_state)){
					// conn.update("insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomID+"','2','"+"syskfz"+"');");
					 strstate.add(int_state);
					 strstate_0.remove(roomID);
					
				 }else if((roomID+"0").trim().equals(int_state)){
					// conn.update("insert into tb_LEDnotice(rooimid,type,typehead)values('"+roomID+"','2','"+"sysgbz"+"');");
					 strstate.remove(int_state);
					 strstate_0.add(roomID);
					
				 }
			 }
			 if(setlength!=strstate.size()){
				 setlength=strstate.size();
				 for(String s:strstate){
					 String topic=s.substring(0,5);
					payload=topic+"#"+"contral"+"#"+"open"+"*";
					openDoor("3401_dis","syskfz*");
					openDoor("3401_dis","syskfz*");
					openDoor("3401_ctrl","open*");
					openDoor("3401_ctrl","open*");
					
				}
				 
			 }
			 if(setlength_0!=strstate_0.size()){
				 setlength_0=strstate_0.size();
				 for(String s:strstate_0){
					 String topic=s;
					payload=topic+"#"+"contral"+"#"+"close"+"*";
					openDoor("3401_ctrl","close*");
					openDoor("3401_dis","sysgbz*");
					openDoor("3401_ctrl","close*");
					openDoor("3401_dis","sysgbz*");
					}
			
		 }
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			ConnPool.closeConnection();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

	private void openDoor(String topic,String mess) {
		// TODO Auto-generated method stub
		ServerMqtt server = new ServerMqtt(topic,mess);
	//	System.out.println(roomID+"++++++++++++"+payload);
	}


}
