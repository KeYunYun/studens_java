package fos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * FileInputStream
		 * �ֽ���
		 * ���ڶ�ȡ�ļ����ֽ���
		 */
		FileInputStream fis 
		=new FileInputStream("fos.dat");
		
		int i=fis.read();
		
		byte[] buf=new byte[12];
		int len =fis.read(buf);
		String str=new String(buf,"UTF-8");
		System.out.println(str);
		fis.close();
		
	}

}
