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
		//缓冲流 加快读写效率
		BufferedInputStream bis=new 
		BufferedInputStream(fis);
		//将fis输入嵌进来
		BufferedOutputStream bos=new 
		BufferedOutputStream(fos);
		//将fos输入嵌进来
		int d=-1;
		while((d=bis.read())!=-1){
			bos.write(d);
		}
		System.out.println("完成");
		//关流只关最外层的高级流
		bis.close();
		bos.close();
	}

}
