
public class Shot implements Runnable {

	int x;
	int y;
	int direct;
	int speed=5;
	boolean live=true;
	public  Shot(int x,int y,int direct)
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(live)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		switch(direct)
		{
		case 0:
			y-=speed;
		break;
		case 1:
			x-=speed;
		break;
		case 2:
			y+=speed;
		break;
		case 3:
			x+=speed;
		break;
		
		}
		if(x>=500||x<0||y<0||y>=500)
		{
			this.live=false;
		}
		
		}
		
	}
	
	
}
 class Bomb{
	 int x;
	 int y;
	 boolean live=true;
	 public Bomb(int x,int y )
	 {
		 this.x=x;
		 this.y=y;
	 }
	 
 }
