package listsort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Listsort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> conn=new ArrayList<Integer>();
		Random random=new Random();
		for(int i=0;i<10;i++){
			conn.add(random.nextInt(100));
		}
		/**
		 * ͨ��Collections������ϵĹ�����
		 * ���Զ�List���Ͻ�����Ȼ����
		 */
		System.out.println(conn);
		Collections.sort(conn);
		System.out.println(conn);
	}

}
