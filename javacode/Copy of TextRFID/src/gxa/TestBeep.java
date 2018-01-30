package gxa;


import dcrf.JavaRD800;


public class TestBeep extends Thread{
	short status;
	int lDevice = 0;
	int[] pSnr = new int[1];//类型
	char[] pSBuffer = new char[16];//缓冲
	char[] pRBuffer = new char[16];//缓冲
	JavaRD800 rd = new JavaRD800();
	
	//线程体
	public void run(){
		while(true){
				try {
				    initRF();//1.打开设备
					readCard();
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public void initRF(){

		lDevice = rd.dc_init(100,115200);//端口与波特率
		if(lDevice <= 0)
		{
			System.out.print("dc_init error!\n");
			return;
		}
		System.out.print("设备初始化正常!\n");	
	}
	public void readCard(){
		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("卡初始化正常!\n");
		System.out.println(pSnr[0]);
		rd.dc_beep(lDevice,(short) 1);  
	}
	public static void main(String[] args) {		
       TestBeep testBeep = new TestBeep();//线程为新建状态
       testBeep.start();//线程为启动运行
	}

}
