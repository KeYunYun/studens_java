package f;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection<String> conn=new ArrayList<String>();
		conn.add("df");
		conn.add("d");
		for(String o :conn){
			System.out.println(o);
		}
		System.out.println(conn);
		Iterator<String> it =conn.iterator();
		while(it.hasNext()){
			String str=it.next();
			System.out.println(str);
		}
	}

}
