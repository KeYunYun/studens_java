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
		 * һ�γ��Դ��ļ��ж�ȡbuf����length
		 * ���ֽڲ�������ĵ�һ��λ�ô�����ʵ��
		 * ��ȡ���ֽ�
		 * ����ֵΪʵ�ʶ�ȡ���ֽ���
		 * 
		 */
		byte[] buf=new byte[50];
		int len=raf.read(buf);
		System.out.println(len);
		System.out.println(Arrays.toString(buf));
		/**
		 * ���ֽ�����ת��Ϊ��Ӧ���ַ���
		 */
		String str= new String(buf,"GBK");
		System.out.println(str);
		raf.close();
		
	}

}
