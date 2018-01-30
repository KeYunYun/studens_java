package iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection conn =new ArrayList();
		conn.add("a");
		conn.add("b");
		conn.add("c");
		conn.add("d");
        
/*		Iterator it=conn.iterator();
		while(it.hasNext()){
			Object obj =it.next();
			
			String str=(String)obj;
			System.out.println(str);
		}*/
		
		for(Object o :conn){
			String str =(String) o;
			System.out.println(str);
			
		}
		
	}

}
