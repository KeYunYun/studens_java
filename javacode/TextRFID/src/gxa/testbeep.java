package gxa;

import dcrf.JavaRD800;



public class testbeep extends Thread{

	short status;
	int lDevice = 0;
	int[] pSnr = new int[1];//����
	char[] pSBuffer = new char[16];//����
	char[] pRBuffer = new char[16];//����
	JavaRD800 rd = new JavaRD800();
	/**
	 * @param args
	 */
	public void run(){
		while(true){
			try {
				
				this.sleep(1000);
				read();
				initRFID();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void initRFID(){
	
		 lDevice = rd.dc_init(100,115200);
		if(lDevice <= 0)
		{
			System.out.print("dc_init error!\n");
			return;
		}
		System.out.print("�豸��ʼ����!\n");
		
	}
	public void read(){

		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("����ʼ����!\n");
		System.out.println(pSnr[0]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testbeep t=new testbeep();
		
		t.start();
	}

}
