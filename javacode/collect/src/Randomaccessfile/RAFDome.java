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
		 * ����Ŀ��Ŀ¼��һ���ļ����ݽ��ж�д
		 * 
		 */
		RandomAccessFile raf=
			new RandomAccessFile("demo.dat", "rw");
		RandomAccessFile raf1=
			new RandomAccessFile("demo.dat", "rw");
		/**
		 * void write(int n)
		 * д������intֵ�ġ���8λ��
		 * ֻһλһλ��д��
		 */
		int num=1;
		raf.write(99);
		raf.write(-1);
		/**
		 * ʹ��IO�� ��һ��Ҫ�ر�
		 */
		/**
		 * ��
		 * read()
		 * ��ǰ�ļ��ж�ȡһ���ֽ�
		 * intֵ   �Ͱ�λ  ��Ч
		 * �������ֵΪ-1��˵���������ļ�ĩβ
		 */
		raf.close();
			int i=raf1.read();
		System.out.println(i);
		int j=raf1.read();
		System.out.println(j);
		raf.close();

		
	}

}
