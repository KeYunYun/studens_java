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
		 * 向栈顶压入一个元素
		 * 入栈操作
		 * 
		 */
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		System.out.println(stack);
		/**
		 * T pop()
		 * 取出栈顶元素，出栈操作
		 * 取出后该元素将被删除
		 */
	}

}
