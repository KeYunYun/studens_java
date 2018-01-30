package queue;

import java.io.File;
import java.io.FileFilter;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue =new LinkedList<String>();
		/**
		 * boolean offer(T t)
		 * ��ӷ���
		 * ������Ԫ����ӵ�����β������ӳɹ�����TRUE��
		 * 
		 */
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		System.out.println(queue);
		/**
		 * T poll();
		 * ���ڻ�ȡ����Ԫ�أ����Ӳ���
		 */
		String str =queue.poll();
		System.out.println(str);
		/**
		 * T Peek();
		 * ���ڻ�ȡ����Ԫ�أ�ֻ�����ã��������Ӳ���
		 */
		String str1 =queue.peek();
		System.out.println(str);
		
		/**
		 * ��������
		 */
		while(queue.size()>0){
			String str2=queue.poll();
			System.out.println(str2);
		}
	}

}

	
