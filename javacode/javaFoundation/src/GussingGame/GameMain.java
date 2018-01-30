package GussingGame;

import java.util.Scanner;

public class GameMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char chs[];
		int count=0;
		char[] input=null;
		int[] result=new int[2];
		Scanner scanner=new Scanner(System.in);
		System.out.println("GuessingGame>��ӭ���Բ���ĸ����");
		chs=generate();
		for(int i=0;i<chs.length;i++){
			System.out.print(chs[i]+" ");
		}
		System.out.println("GussingGame>��Ϸ��ʼ������5���ַ���exit--�˳�");
		while(true){
			String inputStr=scanner.next().trim();
			if("EXIT".equals(inputStr)){
				System.out.println("GussingGame>лл��ĳ��ԣ��ټ���");
				break;
			}
			input=inputStr.toCharArray();
			for(int i=0;i<input.length;i++){
				System.out.print(input[i]+" ");
			}
			result=check(chs, input);
			if(result[0]==chs.length){
				int score=100*chs.length-count*10;
				System.out.println("��ϲ�¶ԣ���ķ�����"+score);
			}else
			{
				count++;
				System.out.println("�¶�"+result[1]+"���ַ�������"
						+result[0]+"���ַ���λ����ȷ����"+count+"��");
			}
		}
		
	}

	public static char[] generate(){
		char chs[]=new char[5];
		char letter[]={'a','b','c','d','e','f','g','h','i',
				'j','k','r','s','t','y','v','w','x','y','z',
				'o','p','q','u','n','m','l'};
		boolean flag[]=new boolean[letter.length];
		for(int i=0;i<chs.length;i++){
			int j;
			do{
			j=(int)(Math.random()*letter.length);
			}while(flag[j]);
			chs[i]=letter[j];
			flag[j]=true;
		}
		return chs;
		
	}
	public static int[] check(char chs[],char input[]){
		int[]result=new int[2];
		for(int i=0;i<input.length;i++){
			for(int j=0;j<chs.length;j++){
				if(input[i]==chs[j]){
					result[1]++;
					if(i==j){
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
		
	}
	
}
