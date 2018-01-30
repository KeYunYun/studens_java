package multiThreadDoanload;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MultiThreadDownload {
	private static int threadcode=3;
	private static int threadsize=0;
    static String urlPath="http://localhost:8080//itheima74/feiq.exe";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String urlPath="http://localhost:8080//itheima74/feiq.exe";
		try {
			URL url =new URL(urlPath);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10*1000);
			int code=connection.getResponseCode();
			System.out.println(code);
			if(code==200){
				//获得资源的大小
				int filelength=connection.getContentLength();
				//在文件中创建一个大小一样的文件
			RandomAccessFile  randmfile=	new RandomAccessFile(new File("feiq.exe"), "rw");
			randmfile.setLength(filelength);
			//分配每个线程下载的开始位置和结束位置
			threadsize=filelength/threadcode;
			for(int i=0;i<threadcode;i++){
				
				int startIndex=-1;
				int endTndex=-1;
				startIndex=i*threadcode;
				endTndex=(i+1)*threadcode-1;
				if(i==threadcode-1){
					endTndex=filelength-1;
				}
				System.out.println(startIndex);
				new Download(i, startIndex, endTndex).start();
			}
			
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static class Download extends Thread{
		private int threadid;
		private int startindex;
		private int endindex;
		private int lastpost;
		private int runthreadcount=0;
		
		public Download(int threadid,int startindex,int endindex){
			this.threadid=threadid;
			this.startindex=startindex;
			this.endindex=endindex;
			System.out.println("线程kai"+threadid);
			
		}
		@Override
		public void run() {
			//分段请求网络连接，分段保存
			try {
				synchronized (Download.class) {
					runthreadcount++;
				}
				
				URL url =new URL(urlPath);
				HttpURLConnection connection=(HttpURLConnection)url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(10*1000);

			//设置分段下载的头信息 Ragne:做分段数据请求用的	
			//读取上次下载结束的位置
				File file2=new File(threadid+".txt");
				if(file2.exists()){
				BufferedReader bufferread=	new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
					String lastPostion_str =bufferread.readLine();
				    lastpost=Integer.parseInt(lastPostion_str);
				    connection.setRequestProperty("Range", "bytes:"+startindex+"-"+endindex);	
				}else{
					connection.setRequestProperty("Range", "bytes:"+startindex+"-"+endindex);
				}
				int code=connection.getResponseCode();
				System.out.println(code);	
				if(code==206){
					//将请求成功的写入文件
					InputStream in=connection.getInputStream();
					RandomAccessFile raf=new RandomAccessFile(new File("feiq.exe"), "rw");
					//设置重什么位置开始写
					raf.seek(lastpost);
					//写入流文件
					byte[] buffer=new byte[1024];
					int length=-1;
					int total=0;
					while((length=in.read(buffer))!=-1){
						raf.write(buffer,0,length);
						total=total+length;
						int currentThreadpostion=lastpost+total;
						//计算出当前位置
						File file=new File(threadid+".txt");
						RandomAccessFile accessfile=new RandomAccessFile(file, "rwd");
						accessfile.write(String.valueOf(currentThreadpostion).getBytes());
						accessfile.close();
					}
				in.close();
				raf.close();
				
				System.out.println("线程下载网络"+threadid);
				synchronized (Download.class) {
					runthreadcount--;
					if(runthreadcount==0){
						for(int i=0;i<threadcode ;i++){
						File file=	new File(i+".text");
							file.delete();
						}
					}
				}	
				
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			super.run();
		}
	}
}
