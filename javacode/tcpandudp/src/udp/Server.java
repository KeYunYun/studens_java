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
			 * ���հ��Ĳ��裺
			 * 1.����Socket��һ�Σ�
			 * 2.����һ�����ʴ�С�İ�
			 * 3.ͨ��socket�������ݵ�����
			 * 4.���ȡ����
			 */
			DatagramSocket socket=
				new DatagramSocket(8088);
			byte[] data=new byte[100];
			DatagramPacket recPacket=
				new DatagramPacket(data, 
									data.length);
			//�����յ����ݷ��ڰ���
			//�÷�����������������socket��Ľ��յ��˰��Ž��
			socket.receive(recPacket);
			//���������
			byte[] d= recPacket.getData();
			int dlen =recPacket.getLength();
			String info=new String(d,0,dlen,"UTF-8");
			System.out.println("�ͻ���˵��"+info);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
