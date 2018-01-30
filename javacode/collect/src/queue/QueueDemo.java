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
		 * 入队方法
		 * 将给定元素添加到队列尾部，添加成功返回TRUE；
		 * 
		 */
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		queue.offer("D");
		System.out.println(queue);
		/**
		 * T poll();
		 * 用于获取队首元素，出队操作
		 */
		String str =queue.poll();
		System.out.println(str);
		/**
		 * T Peek();
		 * 用于获取队首元素，只是引用，不做出队操作
		 */
		String str1 =queue.peek();
		System.out.println(str);
		
		/**
		 * 遍历队列
		 */
		while(queue.size()>0){
			String str2=queue.poll();
			System.out.println(str2);
		}
	}

}

	
