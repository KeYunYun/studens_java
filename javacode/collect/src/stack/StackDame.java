package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackDame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> stack =new LinkedList<String>();
		/**
		 * boolean push(T t)
		 * ��ջ��ѹ��һ��Ԫ��
		 * ��ջ����
		 * 
		 */
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		System.out.println(stack);
		/**
		 * T pop()
		 * ȡ��ջ��Ԫ�أ���ջ����
		 * ȡ�����Ԫ�ؽ���ɾ��
		 */
	}

}
