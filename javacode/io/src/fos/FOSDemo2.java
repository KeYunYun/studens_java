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
		 * ʹ���ļ��ֽ�����������е��ļ�
		 * ����д����
		 * 
		 */
		FileOutputStream fos=
			new FileOutputStream("fos.dat",true);
		//���췽������TRUE����д��������׷�Ӷ��ļ���д
		fos.write(99);
		
		fos.close();
	}

}
