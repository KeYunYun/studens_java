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
		 * �����ַ�������
		 * ��������Ϊ��λ��ȡ�ַ���
		 */
		FileInputStream fis 
		=new FileInputStream("pw.txt");
		
		InputStreamReader isr 
		=new InputStreamReader(fis,"UTF-8");
		
		BufferedReader br 
		=new BufferedReader(isr);
		/**
		 * String readline()
		 * һ�ζ�ȡһ���ַ������÷������ж϶�ȡ�����з�Ϊֹ
		 * ��֮ǰ��һ���ַ�������
		 * ��ֵΪnull����û�пɶ���
		 * 
		 */
		String str=null;
		while((str=br.readLine())!=null){
			System.out.println(str);
		}
		br.close();
	}

}
