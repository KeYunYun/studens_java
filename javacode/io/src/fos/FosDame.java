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
		 * �ֽ���
		 * �������ļ���д���ֽڵ���
		 */
		FileOutputStream fos 
		=new FileOutputStream("fos.dat");
		fos.write(97);
		String str="�Ұ�С��";
		byte[] buf = str.getBytes("UTF-8");
		fos.write(buf);
		fos.close();
	}

}
