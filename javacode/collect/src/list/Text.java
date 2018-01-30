package list;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @
 *  集合的批量处理
 */
public class Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection conn =new ArrayList();
		conn.add("java");
		conn.add("C#");
		conn.add(".net");
		conn.add("php");
		System.out.println(conn);
		
		Collection conn2=new ArrayList();
		conn2.add("android");
		conn2.add("c++");
		conn2.add("c++");
		conn.addAll(conn2);
		System.out.println(conn);
		System.out.println(conn.addAll(conn2));
		
		Collection conn3=new ArrayList();
		conn3.add("c++");
		conn3.add("c");
		System.out.println(conn.containsAll(conn3));
		
		conn2.remove("c++");
		System.out.println(conn2);
	}

}
