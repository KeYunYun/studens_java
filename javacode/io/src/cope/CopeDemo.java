package cope;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class CopeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new
		FileInputStream("src.jpg");
		FileOutputStream fos=new 
		FileOutputStream("copy.jpg");
		//������ �ӿ��дЧ��
		BufferedInputStream bis=new 
		BufferedInputStream(fis);
		//��fis����Ƕ����
		BufferedOutputStream bos=new 
		BufferedOutputStream(fos);
		//��fos����Ƕ����
		int d=-1;
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		System.out.println("���");
		//����ֻ�������ĸ߼���
		bis.close();
		bos.close();
	}

}
