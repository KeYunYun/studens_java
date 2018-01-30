package text;

public class TextBeep extends  Thread{

	/**
	 * @param args
	 */
	public void run(){
		System.out.println("A");
		try {
			this.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextBeep textbeep=new TextBeep();
		textbeep.start();
	}

}
