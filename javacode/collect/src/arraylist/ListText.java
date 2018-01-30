package arraylist;

import java.util.ArrayList;
import java.util.List;

public class ListText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<String> list=new ArrayList<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			list.add("four");
			/**
			 * T get(int index)
			 * 获取给定下标所对应的元素
			 */
			String str=list.get(2);
			System.out.println(str);
			/**
			 * T set(int index,T t)
			 * 将给定的元素设置到给定的位置上
			 * 返回原来位置的值
			 * 所以该方法是替换的元素
			 */
			System.out.println(list.set(2,"3"));
			System.out.println(list);
			
			/**
			 * void add(int index,T t)
			 * 将给定的元素添加到指定的位置上
			 * 原来位置以及后续的元素顺序向后移
			 *  
			 */
			list.add(4, "5");
			System.out.println(list);
			/**
			 * E remove(int index)
			 * 删除指定位置上的元素
			 * 返回值为被删除的元素
			 */
			System.out.println(list.remove(4));
			System.out.println(list);
			
			/**
			 * list subList（int start，int end）
			 * 获取当前集合中的子集
			 */
			List<String> sub=list.subList(1, 3);
			System.out.println(sub);
			
	}

}
