package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

	/**
	 * ����������������빲����
	 * @param pw
	 */
	public synchronized void addOut(PrintWriter pw){
		allout.add(pw);
	}
	/**
	 * ��������������ӹ�������ɾ��
	 * @param pw
	 */
	public synchronized void removeOut(PrintWriter pw){
		allout.remove(pw);
	}
	/**
	 * ����������Ϣת�������пͷ���
	 * @param message
	 */
	public synchronized void snedMessage(String message){
		for(PrintWriter pw :allout){
			pw.println(message);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server;
		try {
			server=new Server();
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ʼ��ʧ��");
		}
		
	}
	//�����ڷ���˵�Socket
	private ServerSocket server;
	//�̳߳أ����ڹ���ͻ������ӵĽ����߳�
	private ExecutorService threadPool;
	private List<PrintWriter> allout;
	public Server() throws IOException {
		try {
			/**
			 * ָ���������˿�
			 */
			server =new ServerSocket(8088);
			System.out.println("����˳�ʼ�����");
			
			//�����̳߳�
		threadPool=
			Executors.newFixedThreadPool(50);
		//��ʼ�����Կͻ���������ļ���
		allout =new ArrayList<PrintWriter>();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * �������˿�ʼ�����ķ���
	 */
	public void start(){
		try{
			/**
			 * ServerSocket��accept�������ڼ���8088�˿�
			 * �ȴ��ͻ��˵�����
			 * �÷�����һ������������ֱ��һ���ͻ�������
			 * �����ӿͻ��ˣ��᷵���ÿͻ��˵�socket
			 */
		while(true){
		System.out.println("�ȴ��ͻ�������");
		Socket socket	= server.accept();
		/**
		 * ��һ���ͷ������Ӻú�����һ���߳�ClientHandler
		 * ���ÿͷ��˵�Socket���룬ʹ�ø��̴߳�����ͻ��˵Ľ���
		 * �����������ٴξ���ѭ����������һ���ͻ��˵�����
		 */
		Runnable handler =
			new ClientHandler(socket);
	//	Thread t=new Thread(handler);
	//	t.start();
		/*
		 * ʹ���̳߳ط�������߳�������ǰ���ӵĿͻ���
		 */
		threadPool.execute(handler);
		}
	
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	class ClientHandler implements Runnable{
		/**
		 * ������е�һ���̣߳�������ĳ���ͻ��˽���
		 * ʹ���̵߳�Ŀ����ʹ����˿��Դ����ͻ���
		 */
		private Socket socket;
		//��ǰ�̴߳���Ŀͻ��˵�socket
		private String ip;
		//��ǰ�ͻ��˵�IP
		/**
		 * ���ݸ����Ŀͻ��˵�socket �������߳���
		 */
		public ClientHandler(Socket socket){
			this.socket=socket;
			/**
			 * ͨ��Socket��ȡԶ�˵ĵ�ַ��Ϣ
			 *
			 */
			InetAddress address =
				socket.getInetAddress();
			//��ȡԶ�˼������IP��ַ
			ip = address.getHostAddress();
			//��ȡԶ�˼�����Ķ˿ں�
			
			int port =socket.getPort();
			System.out.println(ip+":"+port+"�ͻ���������");
			System.out.println("�ͻ������ӳɹ�");
			snedMessage("["+ip+"]������");
		}
		
		public void run() {
			PrintWriter pw =null;
			try {
				/**
				 * ͨ��socket��ȡ�������
				 */
				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=
					new OutputStreamWriter(out,"UTF-8");
				 pw=new PrintWriter(osw,true);
				/**���ÿͻ��˵���������빲����
				 *�Ա�ʹ�øÿͻ���Ҳ�ܽ��ܷ����ת������Ϣ
				 */
				//allout.add(pw);
				 addOut(pw);
				/**
				 * ͨ���ո����ϵĿͷ��˵�socket��ȡ��������
				 * ����ȡ�ͷ��˷��͵���Ϣ
				 */
				InputStream in=socket.getInputStream();
				/**
				 * ���ֽ�����������װΪ���������������ָ�����뼯
				 */
				InputStreamReader isr =
					new InputStreamReader(in,"UTF-8");
				/**
				 * ���ַ���ת��Ϊ�����ַ��������������Ϳ�������Ϊ��λ��ȡ�ַ���
				 */
				BufferedReader br=
					new BufferedReader(isr);
				//��ȡ�ͷ��˷��͹�����һ���ַ���
				String message =br.readLine();
				
				
				
				while((message =br.readLine())!=null){
				/*	System.out.println("�ͻ���˵"+message);
					pw.println(message);*/
					/**����ȡ�ͻ��˷��͹�����һ����Ϣ�󣬽�����Ϣת��
					 * �����пͻ��� 
					 */
					/*for(PrintWriter o: allout){
						o.println(message);
					}*/
					snedMessage(ip+"˵��"+message);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				removeOut(pw);
				//�����ǰ��������
				System.out.println("��ǰ��������"+allout.size());
				/**
				 * ������ʲô�û������ڷ������Ͽ����Ӻ�
				 * ���Ƕ�Ҫ�ڷ���˺Ϳͻ��˶Ͽ�����
				 */
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("һ���ͻ�������");
			}
			
		}
		
	}

}
