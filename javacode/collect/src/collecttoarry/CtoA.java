package collecttoarry;

import java.util.ArrayList;
import java.util.Collection;

public class CtoA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> conn=new ArrayList<String>();
		conn.add("1");
		conn.add("2");
		conn.add("3");
		conn.add("4");
		/**
		 * 集合转数组
		 * Collection中定义了两个方法
		 * Object[] toArryay()
		 * T[] toArray(T[] array)
		 */
		String[] array=conn.toArray(new String[conn.size()]);
		for(String str:array){
			System.out.println(str);
		}
	}

}
