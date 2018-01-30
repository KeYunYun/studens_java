package fos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public abstract class PrintWriterDemo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/**
		 * PrintWriter
		 * 缓冲字符输出流，带有自动刷新
		 * 可以以行为单位写出字符串
		 */
		FileOutputStream fos =new
		FileOutputStream("pw.txt");
		OutputStreamWriter osw =new
		OutputStreamWriter(fos,"UTF-8");
		// 转码
		PrintWriter pw 
		=new PrintWriter(osw,true);
		//自动调永flush()
		pw.println("我爱小徐");
		pw.print("我爱小徐");
		pw.flush();//意味着写完就过去
		pw.print("我爱小徐");
		pw.close();
	}

}
