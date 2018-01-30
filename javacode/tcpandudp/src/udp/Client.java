package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client =new Client();
		client.start();
	}
	public void start(){
		try {
			/**
			 * 向服务端发送数据的步骤
			 * 1.创建好Socket（一次就好）
			 * 2.创建数据包
			 * 3.将数据存入包中
			 * 4.将数据包通关socket发送给服务端
			 */
			DatagramSocket socket =
				new DatagramSocket();
			String str="你好！服务端";
			//转为字节
			byte[] data=
				str.getBytes("UTF-8");
			//打包：准备包裹，填写地址，装入数据
			InetAddress address
			=InetAddress.getByName("localhost");
			int port =8088;
			//创建发送包
			DatagramPacket sendPacket=
				new DatagramPacket(data,
								data.length
								,address,
								port);
			//发送
			socket.send(sendPacket);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
