package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;

public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Client client =new Client();
			client.start();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ͷ��˳�ʼ��ʧ��");
		}
	}
	private Socket socket;

	public Client() throws IOException{
		try {
			/**
			 * ����Socket����ʱ���ͻ� ���Ը��ݸ����ĵ�ַ�Ͷ˿�
			 * ���ӷ�������
			 * ���ԣ���ö��󴴽��ɹ���˵�������������������
			 */
			System.out.println("�������ӷ�����");
			socket=new  Socket("localhost",8088);
			System.out.println("�ɹ����ӷ����");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	public void start(){
		
		try {
			Runnable runn=new 
			GetServerInfoHamdler();
			Thread t=new Thread(runn);
			t.start();

			/**
			 * ����ͨ��Socket��getoutStream()��
			 * ������ȡһ������������ڽ���Ϣ���͵������
			 * 
			 */
			OutputStream out=
				socket.getOutputStream();
			/**
			 * ʹ���ַ���������ָ���ı��뼯���ַ���ת��Ϊ�ֽں�
			 * ��ͨ��out���͸�������
			 */
			OutputStreamWriter osw =
				new OutputStreamWriter(out,"UTF-8");
			/**
			 * ���ֽ�����װΪ�����ֽ������Ϳ��԰���Ϊ��λд���ַ���
			 */
			PrintWriter pw =
				new PrintWriter(osw,true);
			Scanner scanner=
				new Scanner(System.in);
			while(true){
				String str=scanner.nextLine();
				pw.println(str);
				//��������ͷ����˳�����	
				//�����������߳�

			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	class GetServerInfoHamdler implements Runnable{

		
		public void run() {
			try {
				/**
				 * ͨ��Socket��ȡ������
				 */
				InputStream in=
					socket.getInputStream();
				InputStreamReader isr =
					new InputStreamReader(in,"UTF-8");
				BufferedReader br=
					new BufferedReader(isr);
				String message =null;
				while((message=br.readLine())!=null){
					System.out.println(message);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
