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
		String str="�Ұ�С��";
		/**
		 * String��getBytes(�ַ���)
		 * ����ǰ�ַ������յ�ǰ����ת��
		 * UTF-8,GBK..
		 */
		byte[] buf =str.getBytes("GBK");
		//���ַ�ת��Ϊ�ֽڴ�
		raf.write(buf);
		//д��
		raf.close();
	}

}
