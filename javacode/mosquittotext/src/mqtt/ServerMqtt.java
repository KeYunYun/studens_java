package mqtt;
import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ServerMqtt {
	
    public static final String HOST = "tcp://192.168.101.254:1883"; 
    private static final String clientid = "server";  
  //  private static String TOPIC = "";
    private MqttClient client;  
    private MqttTopic topic11;  
   // private String userName = "mosquitto";  
   // private String passWord = "";  
    private MqttMessage message; 
    String payload;
    String topic;
    
     public ServerMqtt(String topic,String payload){
    	 this.payload=payload;
    	 this.topic=topic;
    	  try {
			client = new MqttClient(HOST, clientid, new MemoryPersistence());
			connect(topic);
	        this.message = new MqttMessage();  
	        this.message.setQos(1);  
	        this.message.setRetained(true);  
	        this.message.setPayload(payload.getBytes());  
	        this.publish(this.topic11 , this.message);  
	        System.out.println(this.message.isRetained() + "------ratained状态");  
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("链接失败1");
		}
     }
	private void connect(String topic) {
		// TODO Auto-generated method stub
		 MqttConnectOptions options = new MqttConnectOptions(); 
		 options.setCleanSession(false);  
	   // options.setUserName(userName);  
	   // options.setPassword(passWord.toCharArray());
	    // 设置超时时间  
        options.setConnectionTimeout(10);  
        // 设置会话心跳时间  
        options.setKeepAliveInterval(20);  
        try {  
            client.setCallback(new PushCallback());  
            client.connect(options);  
            topic11 = client.getTopic(topic);  
        } catch (Exception e) {  
            e.printStackTrace(); 
            System.out.println("链接失败2");
        }  
	}
    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,  
    MqttException {  
    	MqttDeliveryToken token = topic.publish(message);  
    	token.waitForCompletion();  
    	System.out.println("message is published completely! "  
        + token.isComplete());  
}


}
