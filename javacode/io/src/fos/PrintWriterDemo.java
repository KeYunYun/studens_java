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
		 * �����ַ�������������Զ�ˢ��
		 * ��������Ϊ��λд���ַ���
		 */
		FileOutputStream fos =new
		FileOutputStream("pw.txt");
		OutputStreamWriter osw =new
		OutputStreamWriter(fos,"UTF-8");
		// ת��
		PrintWriter pw 
		=new PrintWriter(osw,true);
		//�Զ�����flush()
		pw.println("�Ұ�С��");
		pw.print("�Ұ�С��");
		pw.flush();//��ζ��д��͹�ȥ
		pw.print("�Ұ�С��");
		pw.close();
	}

}
