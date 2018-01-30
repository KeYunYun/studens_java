package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdt =
			new SimpleDateFormat("HH:mm:ss");
		while(true){
			Date now=new Date();
			System.out.println(sdt.format(now));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
