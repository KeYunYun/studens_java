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
			System.out.println("客服端初始化失败");
		}
	}
	private Socket socket;

	public Client() throws IOException{
		try {
			/**
			 * 创建Socket对象时，就会 尝试根据给定的地址和端口
			 * 链接服务器。
			 * 所以，如该对象创建成功，说明与服务器链接正常。
			 */
			System.out.println("正在链接服务器");
			socket=new  Socket("localhost",8088);
			System.out.println("成功链接服务端");
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
			 * 可以通过Socket的getoutStream()；
			 * 方法获取一条输出流，用于将信息发送到服务端
			 * 
			 */
			OutputStream out=
				socket.getOutputStream();
			/**
			 * 使用字符流来根据指定的编码集将字符串转换为字节后
			 * 在通过out发送给服务器
			 */
			OutputStreamWriter osw =
				new OutputStreamWriter(out,"UTF-8");
			/**
			 * 将字节流包装为缓冲字节流，就可以按行为单位写出字符串
			 */
			PrintWriter pw =
				new PrintWriter(osw,true);
			Scanner scanner=
				new Scanner(System.in);
			while(true){
				String str=scanner.nextLine();
				pw.println(str);
				//发完流后客服端退出链接	
				//创建并启动线程

			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	class GetServerInfoHamdler implements Runnable{

		
		public void run() {
			try {
				/**
				 * 通过Socket获取输入流
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
