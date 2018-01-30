
import java.io.*;
import java.util.Scanner;

public class Io1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directoy = "d://Text1/Text2/TEXT.txt";
		String file="TEXT.txt";
		
		File f=new File(directoy);
		//f.getParentFile().mkdirs();
		if(f.exists())
		{
			
			
				f.delete();
				//f.getParentFile().delete();
				//f.getParentFile().getParentFile().delete();
				System.out.println("删除文件");
		}else
		{
			System.out.println("创建文件");
			f.getParentFile().mkdirs();
			try
			{
				String encoding="GBK";
				f.createNewFile();
				FileOutputStream fos=new FileOutputStream(f);
				Scanner s = new Scanner(System.in);
				 String str = null;
				 System.out.println("输入内容");
				str=s.next();
				fos.write(str.getBytes());
				InputStreamReader read=new InputStreamReader
						(new FileInputStream(f),encoding);
				 BufferedReader Reader = new 
						 BufferedReader(read); 
				 String lineTxt = null; 
				 System.out.println("读出内容如下");
                 while((lineTxt = Reader.readLine()) != null){ 
                     System.out.println(lineTxt); 
                 }

				fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}
}
}
