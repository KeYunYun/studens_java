package filetext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAFDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		RandomAccessFile raf=new 
			RandomAccessFile("raf.dat", "rw");
		int num=48;
		/**
		 * 将int值写入文件
		 */
		raf.writeInt(num);
		raf.close();
	}

}
