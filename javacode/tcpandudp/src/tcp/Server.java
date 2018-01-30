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
	 * 将给定的输出流存入共享集合
	 * @param pw
	 */
	public synchronized void addOut(PrintWriter pw){
		allout.add(pw);
	}
	/**
	 * 将给定的输出流从共享集合中删除
	 * @param pw
	 */
	public synchronized void removeOut(PrintWriter pw){
		allout.remove(pw);
	}
	/**
	 * 将给定的消息转发给所有客服端
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
			System.out.println("初始化失败");
		}
		
	}
	//运行在服务端的Socket
	private ServerSocket server;
	//线程池，用于管理客户端链接的交互线程
	private ExecutorService threadPool;
	private List<PrintWriter> allout;
	public Server() throws IOException {
		try {
			/**
			 * 指定服务器端口
			 */
			server =new ServerSocket(8088);
			System.out.println("服务端初始化完毕");
			
			//创建线程池
		threadPool=
			Executors.newFixedThreadPool(50);
		//初始化所以客户端输出流的集合
		allout =new ArrayList<PrintWriter>();
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 服务器端开始工作的方法
	 */
	public void start(){
		try{
			/**
			 * ServerSocket的accept方法用于监听8088端口
			 * 等待客户端的链接
			 * 该方法是一个阻塞方法，直到一个客户端链接
			 * 若链接客户端，会返还该客户端的socket
			 */
		while(true){
		System.out.println("等待客户端链接");
		Socket socket	= server.accept();
		/**
		 * 当一个客服端连接好后，启动一个线程ClientHandler
		 * 将该客服端的Socket传入，使得该线程处理与客户端的交互
		 * 这样我们能再次静入循环，接受下一个客户端的链接
		 */
		Runnable handler =
			new ClientHandler(socket);
	//	Thread t=new Thread(handler);
	//	t.start();
		/*
		 * 使用线程池分配空闲线程来处理当前链接的客户端
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
		 * 服务端中的一个线程，用于与某个客户端交互
		 * 使用线程的目的是使服务端可以处理多客户端
		 */
		private Socket socket;
		//当前线程处理的客户端的socket
		private String ip;
		//当前客户端的IP
		/**
		 * 根据给定的客户端的socket ，创建线程体
		 */
		public ClientHandler(Socket socket){
			this.socket=socket;
			/**
			 * 通过Socket获取远端的地址信息
			 *
			 */
			InetAddress address =
				socket.getInetAddress();
			//获取远端计算机的IP地址
			ip = address.getHostAddress();
			//获取远端计算机的端口号
			
			int port =socket.getPort();
			System.out.println(ip+":"+port+"客户端连接了");
			System.out.println("客户端链接成功");
			snedMessage("["+ip+"]上线了");
		}
		
		public void run() {
			PrintWriter pw =null;
			try {
				/**
				 * 通过socket获取输出流。
				 */
				OutputStream out=socket.getOutputStream();
				OutputStreamWriter osw=
					new OutputStreamWriter(out,"UTF-8");
				 pw=new PrintWriter(osw,true);
				/**将该客户端的输出流存入共享集合
				 *以便使得该客户端也能接受服务端转发的消息
				 */
				//allout.add(pw);
				 addOut(pw);
				/**
				 * 通过刚刚连上的客服端的socket获取输入流。
				 * 来读取客服端发送的信息
				 */
				InputStream in=socket.getInputStream();
				/**
				 * 将字节流输入流包装为输出流，这样可以指定编码集
				 */
				InputStreamReader isr =
					new InputStreamReader(in,"UTF-8");
				/**
				 * 将字符流转换为缓冲字符输入流，这样就可以以行为单位读取字符流
				 */
				BufferedReader br=
					new BufferedReader(isr);
				//读取客服端发送过来的一行字符串
				String message =br.readLine();
				
				
				
				while((message =br.readLine())!=null){
				/*	System.out.println("客户端说"+message);
					pw.println(message);*/
					/**当读取客户端发送过来的一条信息后，将该消息转发
					 * 给所有客户端 
					 */
					/*for(PrintWriter o: allout){
						o.println(message);
					}*/
					snedMessage(ip+"说："+message);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally{
				removeOut(pw);
				//输出当前在线人数
				System.out.println("当前在线人数"+allout.size());
				/**
				 * 无论是什么用户，当于服务器断开连接后
				 * 我们都要在服务端和客户端断开连接
				 */
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("一个客户端下线");
			}
			
		}
		
	}

}
