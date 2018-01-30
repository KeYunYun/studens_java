package dcrf;


/*
 * ����̲���JAR�ĵ��÷�ʽ����dcrf.jar��Ҫ����JAVA�������·����
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
import dcrf.JavaRD800;

class JavaRD800Demo
{
	public static void main(String[] args)
	{
		short status;
		int lDevice = 0;
		int[] pSnr = new int[1];//����
		char[] pSBuffer = new char[16];//����
		char[] pRBuffer = new char[16];//����
		JavaRD800 rd = new JavaRD800();
		//for(int i=0;i<10000;i++){
			//System.out.println(i);
		 lDevice = rd.dc_init(100,115200);//�˿��벨����
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
		System.out.print("�豸��ʼ����!\n");
		
		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("����ʼ����!\n");
		System.out.println(pSnr[0]);
		
		
		pSBuffer[0] = 0xFF;
		pSBuffer[1] = 0xFF;
		pSBuffer[2] = 0xFF;
		pSBuffer[3] = 0xFF;
		pSBuffer[4] = 0xFF;
		pSBuffer[5] = 0xFF;
		pSBuffer[6] = 0xFF;

		//������װ���дģ��RAM��
		//��2������Ϊװ������ģʽ
		//��3������Ϊ�����
		status = rd.dc_load_key(lDevice,(short)0,(short)0,pSBuffer);
		if(status != 0)
		{
			System.out.print("dc_load_key error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print(pSBuffer);
		System.out.print("��ȡ������ɹ�!\n");
		//�˶����뺯��
		//�ڶ�������Ϊ������֤ģʽ
		//���������Ϊ�����
		status = rd.dc_authentication(lDevice,(short)0,(short)0);
		if(status != 0)
		{
			System.out.print("dc_authentication error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("�˶�����ɹ�!\n");
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
		System.out.print("��ȡ���ɹ�!\n");

		System.out.print(Utils.encode(String.valueOf(pRBuffer)));
		
		System.out.print("\n");
		
		
		status = rd.dc_exit(lDevice);
		if(status != 0)
		{
			System.out.print("dc_exit error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("���˳�!\n");
	}
	
}
