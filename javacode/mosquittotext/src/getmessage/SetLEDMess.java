package getmessage;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import jdbc.ConnPool;
import mqtt.ServerMqtt;
import utils.LEDUtils;

public class SetLEDMess implements Runnable {
	Set<LEDUtils> set;
	boolean flag=true;
	int setlength=0;
	String	payload;
	String	topic;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			ConnPool conn=new ConnPool();
			ResultSet rs;
			set=new HashSet<LEDUtils>();
			try{
				String sql ="select * from tb_LEDnotice";
				 rs =conn.select(sql);
				
				 while(rs.next()){
					 LEDUtils led=new LEDUtils();
					String  roomID=rs.getString("rooimid");
					String  type=rs.getString("type");
					String  typehead=rs.getString("typehead");
					led.setRoomid(roomID);
					led.setType(type);
					led.setTypehead(typehead);
					set.add(led);
				 }
				 conn.update("truncate table tb_LEDnotice ");
				 if(setlength!=set.size()){
					 setlength=set.size();
					 for(LEDUtils s:set){
						topic=s.getRoomid();
						payload=s.getTypehead()+"*";
						openDoor("3401_dis",payload);
						openDoor("3401_dis",payload);
						openDoor("3401_dis",payload);
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
