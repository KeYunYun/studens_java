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
			 * �����˷������ݵĲ���
			 * 1.������Socket��һ�ξͺã�
			 * 2.�������ݰ�
			 * 3.�����ݴ������
			 * 4.�����ݰ�ͨ��socket���͸������
			 */
			DatagramSocket socket =
				new DatagramSocket();
			String str="��ã������";
			//תΪ�ֽ�
			byte[] data=
				str.getBytes("UTF-8");
			//�����׼����������д��ַ��װ������
			InetAddress address
			=InetAddress.getByName("localhost");
			int port =8088;
			//�������Ͱ�
			DatagramPacket sendPacket=
				new DatagramPacket(data,
								data.length
								,address,
								port);
			//����
			socket.send(sendPacket);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
