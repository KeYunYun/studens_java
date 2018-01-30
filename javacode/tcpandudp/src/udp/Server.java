package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server =new Server();
		server.start();
	}
	public void start(){
		try {
			/**
			 * 接收包的步骤：
			 * 1.创建Socket（一次）
			 * 2.创建一个合适大小的包
			 * 3.通过socket接收数据到包中
			 * 4.拆包取数据
			 */
			DatagramSocket socket=
				new DatagramSocket(8088);
			byte[] data=new byte[100];
			DatagramPacket recPacket=
				new DatagramPacket(data, 
									data.length);
			//将接收的数据放在包里
			//该方法是阻塞方法，当socket真的接收到了包才解除
			socket.receive(recPacket);
			//拆包拿数据
			byte[] d= recPacket.getData();
			int dlen =recPacket.getLength();
			String info=new String(d,0,dlen,"UTF-8");
			System.out.println("客户端说："+info);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
