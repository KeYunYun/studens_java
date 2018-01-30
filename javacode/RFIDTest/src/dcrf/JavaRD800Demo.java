package dcrf;


/*
 * 本例程采用JAR的调用方式，包dcrf.jar需要加在JAVA的需求库路径中
 *
 * 
 * 
 * 
 * 
 * 
 * 
 *
 */

import java.io.UnsupportedEncodingException;

import dcrf.*;

class JavaRD800Demo
{
	public static void main(String[] args)
	{
		short status;
		int lDevice = 0;
		int[] pSnr = new int[1];//类型
		char[] pSBuffer = new char[16];//缓冲
		char[] pRBuffer = new char[16];//缓冲
		JavaRD800 rd = new JavaRD800();
		//for(int i=0;i<10000;i++){
			//System.out.println(i);
		 lDevice = rd.dc_init(100,115200);//端口与波特率
		 //if(lDevice>0){
			 //System.out.println(i+"aa");
			 //break;
		 //}
		//}
		if(lDevice <= 0)
		{
			System.out.print("dc_init error!\n");
			return;
		}
		System.out.print("设备初始化正常!\n");
		
		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("卡初始化正常!\n");
		System.out.println(pSnr[0]);
		
		
		pSBuffer[0] = 0xFF;
		pSBuffer[1] = 0xFF;
		pSBuffer[2] = 0xFF;
		pSBuffer[3] = 0xFF;
		pSBuffer[4] = 0xFF;
		pSBuffer[5] = 0xFF;
		pSBuffer[6] = 0xFF;

		//将密码装入读写模块RAM中
		//第2个参数为装入密码模式
		//第3个参数为扇区号
		status = rd.dc_load_key(lDevice,(short)0,(short)0,pSBuffer);
		if(status != 0)
		{
			System.out.print("dc_load_key error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print(pSBuffer);
		System.out.print("读取卡密码成功!\n");
		//核对密码函数
		//第二个参数为密码验证模式
		//第三个参数为扇区号
		status = rd.dc_authentication(lDevice,(short)0,(short)0);
		if(status != 0)
		{
			System.out.print("dc_authentication error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("核对密码成功!\n");
//		
//		for(int i=0;i<16;i++)
//		{
//			pSBuffer[i] = 'M';
//		}
//		status = rd.dc_write(lDevice,(short)2,pSBuffer);
//		if(status != 0)
//		{
//			System.out.print("dc_write error!\n");
//			rd.dc_exit(lDevice);
//			return;
//		}
//		System.out.print("dc_write ok!\n");
//		
		status = rd.dc_read(lDevice,(short)0,pRBuffer);
		if(status != 0)
		{
			System.out.print("dc_read error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("读取卡成功!\n");

		System.out.print(Utils.encode(String.valueOf(pRBuffer)));
		
		System.out.print("\n");
		
		
		status = rd.dc_exit(lDevice);
		if(status != 0)
		{
			System.out.print("dc_exit error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("卡退出!\n");
	}
	
}
