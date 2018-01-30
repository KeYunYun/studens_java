package thread;

import javax.management.RuntimeErrorException;

public class JoinDamo {

	/**
	 * @param args
	 */
	public static boolean isFinish;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * jion可以使线程同步
		 */
		final Thread download=new Thread(){
			public void run(){
				System.out.println("down");
				for(int i=0;i<=100;i++){
					System.out.println("down"+i+"%");
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("完成");
				isFinish=true;
			}
		};
		download.start();
		
		Thread show=new Thread(){
			public void run(){
				System.out.println("show");
				//等待下载线程完成
				try {
					download.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * main方法中定义了一个内部类show,
				 * 该内部类中若想引用main方法中的其他局部变量
				 * ，那么这个变量必须是final的
				 */
				if(!isFinish){
					throw new RuntimeErrorException(null, "没图片");
				}
				System.out.println("show success");
			}
		};
		show.start();
	}

}
