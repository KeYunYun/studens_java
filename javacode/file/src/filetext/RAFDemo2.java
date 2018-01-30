package filetext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RAFDemo2 {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf=new 
			RandomAccessFile("test.txt", "rw");
		/**
		 * int read (byte[] buf)
		 * 一次尝试从文件中读取buf数组length
		 * 个字节并从数组的第一个位置处起存放实际
		 * 读取的字节
		 * 返回值为实际读取的字节数
		 * 
		 */
		byte[] buf=new byte[50];
		int len=raf.read(buf);
		System.out.println(len);
		System.out.println(Arrays.toString(buf));
		/**
		 * 从字节数组转化为对应的字符串
		 */
		String str= new String(buf,"GBK");
		System.out.println(str);
		raf.close();
		
	}

}
