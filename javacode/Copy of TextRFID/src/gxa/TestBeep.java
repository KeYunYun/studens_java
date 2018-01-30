package gxa;


import dcrf.JavaRD800;


public class TestBeep extends Thread{
	short status;
	int lDevice = 0;
	int[] pSnr = new int[1];//����
	char[] pSBuffer = new char[16];//����
	char[] pRBuffer = new char[16];//����
	JavaRD800 rd = new JavaRD800();
	
	//�߳���
	public void run(){
		while(true){
				try {
				    initRF();//1.���豸
					readCard();
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public void initRF(){

		lDevice = rd.dc_init(100,115200);//�˿��벨����
		if(lDevice <= 0)
		{
			System.out.print("dc_init error!\n");
			return;
		}
		System.out.print("�豸��ʼ������!\n");	
	}
	public void readCard(){
		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("����ʼ������!\n");
		System.out.println(pSnr[0]);
		rd.dc_beep(lDevice,(short) 1);  
	}
	public static void main(String[] args) {		
       TestBeep testBeep = new TestBeep();//�߳�Ϊ�½�״̬
       testBeep.start();//�߳�Ϊ��������
	}

}
