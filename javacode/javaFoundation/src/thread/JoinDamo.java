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
		 * jion����ʹ�߳�ͬ��
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
				System.out.println("���");
				isFinish=true;
			}
		};
		download.start();
		
		Thread show=new Thread(){
			public void run(){
				System.out.println("show");
				//�ȴ������߳����
				try {
					download.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				 * main�����ж�����һ���ڲ���show,
				 * ���ڲ�������������main�����е������ֲ�����
				 * ����ô�������������final��
				 */
				if(!isFinish){
					throw new RuntimeErrorException(null, "ûͼƬ");
				}
				System.out.println("show success");
			}
		};
		show.start();
	}

}
