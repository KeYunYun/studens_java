package fos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**
		 * 使用文件字节输出流对已有的文件
		 * 进行写操作
		 * 
		 */
		FileOutputStream fos=
			new FileOutputStream("fos.dat",true);
		//构造方法加入TRUE后，在写入内容是追加都文件后写
		fos.write(99);
		
		fos.close();
	}

}
