package Randomaccessfile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class RAFDome {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 对项目根目录下一个文件内容进行读写
		 * 
		 */
		RandomAccessFile raf=
			new RandomAccessFile("demo.dat", "rw");
		RandomAccessFile raf1=
			new RandomAccessFile("demo.dat", "rw");
		/**
		 * void write(int n)
		 * 写出给定int值的“低8位”
		 * 只一位一位的写入
		 */
		int num=1;
		raf.write(99);
		raf.write(-1);
		/**
		 * 使用IO后 ，一定要关闭
		 */
		/**
		 * 读
		 * read()
		 * 当前文件中读取一个字节
		 * int值   低八位  有效
		 * 如果返回值为-1，说明读到了文件末尾
		 */
		raf.close();
			int i=raf1.read();
		System.out.println(i);
		int j=raf1.read();
		System.out.println(j);
		raf.close();

		
	}

}
