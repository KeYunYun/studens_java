package filetext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFDemo1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf=new 
		  RandomAccessFile("test.txt", "rw");
		String str="我爱小徐";
		/**
		 * String的getBytes(字符集)
		 * 将当前字符串按照当前编码转化
		 * UTF-8,GBK..
		 */
		byte[] buf =str.getBytes("GBK");
		//将字符转化为字节串
		raf.write(buf);
		//写入
		raf.close();
	}

}
