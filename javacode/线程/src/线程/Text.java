package Ïß³Ì;

public class Text {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Cat cat=new Cat();
			cat.start();
		
	}

}
class Cat extends Thread
{
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("ok");
		}
	}
	
	
}
