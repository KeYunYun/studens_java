
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
				System.out.println("ɾ���ļ�");
		}else
		{
			System.out.println("�����ļ�");
			f.getParentFile().mkdirs();
			try
			{
				String encoding="GBK";
				f.createNewFile();
				FileOutputStream fos=new FileOutputStream(f);
				Scanner s = new Scanner(System.in);
				 String str = null;
				 System.out.println("��������");
				str=s.next();
				fos.write(str.getBytes());
				InputStreamReader read=new InputStreamReader
						(new FileInputStream(f),encoding);
				 BufferedReader Reader = new 
						 BufferedReader(read); 
				 String lineTxt = null; 
				 System.out.println("������������");
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
