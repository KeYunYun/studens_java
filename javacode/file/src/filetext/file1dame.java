package filetext;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class file1dame {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file =new File("."+File.separator+"Dame.txt");
		/**
		 * String getName()
		 * ��ȡfile��ʾ���ļ���
		 */
		String filename=file.getName();
		System.out.println(filename);
		/**
		 * boolean exists()
		 * �жϵ�ǰfile����ʾ���ļ��Ƿ���ʵ����
		 * false ��ԭ��
		 * 1.�ļ�����
		 * 2.�ļ�û����Ŀ�ļ���
		 */
		System.out.println(file.exists());
		/**
		 * long length()
		 * ��ȡ��ǰFile����ʾ���ļ���ռ�õ��ֽ���
		 */
		System.out.println(file.length());
		
		/**
		 *  canRead()
		 *  canWrite()
		 *  canEXecute()
		 *  �ж��Ƿ��ǿɶ���д��ִ��
		 */
		/**
		 * isFile()
		 * ture ��ʾ��������һ���ļ�
		 * FALSE 
		 */
	/*	System.out.println(file.isFile());
		
		File file1=new File("text.txt");
		if(file1.exists()){
			file1.delete();
			System.out.println("�ɹ�");
		}
		File dir =new File("demo");
		if(dir.exists()){
			dir.delete();
		}*/
		/*File dir =new File(".");
		if(dir.isDirectory()){
			File[] subs=dir.listFiles();
			for(File sub:subs){
				String name =sub.getName();
				long length=sub.length();
				System.out.println(name+":"+length);
				
			}
		}*/
		
/*		File dir =new File(".");
		if(dir.isDirectory()){
			//����������
			FileFilter filter =new MyFilter();
			//ʹ�ù�������������
			File[] subs=dir.listFiles(filter);
			for(File sub:subs){
				System.out.println(sub.getName());
			}
			
		}*/
		
		/**
		 * �����༶Ŀ¼�µ��ļ�
		 */
		/**
		 * File getParentFile()
		 * ��ȡ��ǰ�ļ���Ŀ¼�ĸ�Ŀ¼
		 * 
		 */
	}

}
class MyFilter implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.getName().startsWith(".");
	}
}