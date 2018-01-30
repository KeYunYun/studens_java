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
		 * 获取file表示的文件名
		 */
		String filename=file.getName();
		System.out.println(filename);
		/**
		 * boolean exists()
		 * 判断当前file所表示的文件是否真实存在
		 * false 的原因
		 * 1.文件名错
		 * 2.文件没在项目文件下
		 */
		System.out.println(file.exists());
		/**
		 * long length()
		 * 获取当前File所表示的文件所占用的字节量
		 */
		System.out.println(file.length());
		
		/**
		 *  canRead()
		 *  canWrite()
		 *  canEXecute()
		 *  判断是否是可读可写可执行
		 */
		/**
		 * isFile()
		 * ture 表示描述的是一个文件
		 * FALSE 
		 */
	/*	System.out.println(file.isFile());
		
		File file1=new File("text.txt");
		if(file1.exists()){
			file1.delete();
			System.out.println("成功");
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
			//创建过滤器
			FileFilter filter =new MyFilter();
			//使用过滤器过滤子项
			File[] subs=dir.listFiles(filter);
			for(File sub:subs){
				System.out.println(sub.getName());
			}
			
		}*/
		
		/**
		 * 创建多级目录下的文件
		 */
		/**
		 * File getParentFile()
		 * 获取当前文件或目录的父目录
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