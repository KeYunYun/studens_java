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
			 * ��ȡ�����±�����Ӧ��Ԫ��
			 */
			String str=list.get(2);
			System.out.println(str);
			/**
			 * T set(int index,T t)
			 * ��������Ԫ�����õ�������λ����
			 * ����ԭ��λ�õ�ֵ
			 * ���Ը÷������滻��Ԫ��
			 */
			System.out.println(list.set(2,"3"));
			System.out.println(list);
			
			/**
			 * void add(int index,T t)
			 * ��������Ԫ����ӵ�ָ����λ����
			 * ԭ��λ���Լ�������Ԫ��˳�������
			 *  
			 */
			list.add(4, "5");
			System.out.println(list);
			/**
			 * E remove(int index)
			 * ɾ��ָ��λ���ϵ�Ԫ��
			 * ����ֵΪ��ɾ����Ԫ��
			 */
			System.out.println(list.remove(4));
			System.out.println(list);
			
			/**
			 * list subList��int start��int end��
			 * ��ȡ��ǰ�����е��Ӽ�
			 */
			List<String> sub=list.subList(1, 3);
			System.out.println(sub);
			
	}

}
