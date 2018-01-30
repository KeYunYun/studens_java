package mqtt;
import java.sql.ResultSet;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import jdbc.ConnPool;

public class PushCallback implements MqttCallback {
	 String[] str;
	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
        // 连接丢失后，一般在这里面进行重连  
        System.out.println("连接断开，可以做重连");  
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		 System.out.println("deliveryComplete---------" + arg0.isComplete()); 
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
			String mess=new String(message.getPayload());
        System.out.println("接收消息主题 : " + topic);  
        System.out.println("接收消息Qos : " + message.getQos());  
        System.out.println("接收消息内容 : " + mess);
        String mess_str=mess.replace("*", "#");
       
        str=mess_str.split("#");
        	
          if(str[0].equals("card")){
        	  
        	  setDateCard(topic,str[1]);
        	 
          }else if(str[0].equals("contral")){
        	  System.out.println("分割后"+str[0]);
        	  setDateContral(topic,str[1]);
          }
	}

	private void setDateContral(String topic, String string) {
		// TODO Auto-generated method stub
		ConnPool conn=new ConnPool();
		ResultSet rs;
		String sql;
		try{
			 sql ="insert into tb_rececontral(rooimid,state,recetime) values('"+topic+"','"+string+"',now())";
			 
			 conn.update(sql);
			
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

	private void setDateCard(String topic, String string) {
		// TODO Auto-generated method stub
		ConnPool conn=new ConnPool();
		ResultSet rs;
		String sql;
		try{
			 sql ="insert into tb_rececard(rooimid,cardnum,recetime) values('"+topic+"','"+string+"',now())";
			 
			 conn.update(sql);
			
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
