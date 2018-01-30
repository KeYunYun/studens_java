package fos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class BufferedReaderDemo {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		/**
		 * BufferedReader
		 * 缓冲字符输入流
		 * 可以以行为单位读取字符串
		 */
		FileInputStream fis 
		=new FileInputStream("pw.txt");
		
		InputStreamReader isr 
		=new InputStreamReader(fis,"UTF-8");
		
		BufferedReader br 
		=new BufferedReader(isr);
		/**
		 * String readline()
		 * 一次读取一行字符串，该方法会判断读取到换行符为止
		 * 将之前的一行字符串返回
		 * 如值为null，则没有可读的
		 * 
		 */
		String str=null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		br.close();
	}

}
