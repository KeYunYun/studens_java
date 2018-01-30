package fos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FosDame {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		/**
		 * FileOutputStream
		 * 字节流
		 * 用于向文件中写出字节的流
		 */
		FileOutputStream fos 
		=new FileOutputStream("fos.dat");
		fos.write(97);
		String str="我爱小徐";
		byte[] buf = str.getBytes("UTF-8");
		fos.write(buf);
		fos.close();
	}

}
