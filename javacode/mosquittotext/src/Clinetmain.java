import java.sql.ResultSet;
import java.util.HashSet;

import getmessage.Getmessage;
import getmessage.SetLEDMess;
import jdbc.ConnPool;
import mqtt.ClientMqtt;

public class Clinetmain  {
	HashSet<String> strstate;
	String sql;
	int setlengthclient=0;
	static String[] strArr;
	
	public static void main(String[] args) {

		new Clinetmain();
		Getmessage get=new Getmessage(true);
	  	new Thread(get).start();
	  	SetLEDMess setled=new SetLEDMess();
	  	new Thread(setled).start();
	}

	public  Clinetmain() {
			 strstate = new HashSet<String>();
			ConnPool conn=new ConnPool();
			ResultSet rs;
			try{
				 sql ="select * from tb_classroom";
				 rs =conn.select(sql);
				 while(rs.next()){
					 String roomID=rs.getString("roomID");
					  strstate.add(roomID);
				 }	
				 int[] qos=new int[strstate.size()];
				
				
				strArr = (String[]) strstate.toArray(new String[strstate.size()]);
				for(int i=0;i<strstate.size();i++){
					qos[i]=2;
			}
			ClientMqtt client = new ClientMqtt(strArr,qos);
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
