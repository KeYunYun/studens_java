import java.util.Random;
import java.util.Vector;

import com.sun.scenario.effect.Bloom;

public class EnemyTank extends Tank implements Runnable {

	//boolean live=true;
	int speed=3;
	int time=0;
	Vector<Shot> ss=new Vector<Shot>(); 
	 
	
	public EnemyTank(int x, int y) {
		super(x, y);

}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
		try {
			
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		this.direct=(int)(Math.random()*4);
		//if(this.x>0&&this.x<400&&this.y>0&&this.y<400)
		
		switch(this.direct)
		{
		case 0:
			for(int i=1;i<30;i++)
			{
				try {
					
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
			if(this.y>0)
			{
			y-=speed;
			}
			}
			break;
		case 1:
			for(int i=1;i<30;i++);
		{
			try {
				
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			if(this.x>0)
			{
			x-=speed;
			}
		}	
			break;
		case 2:
			for(int i=1;i<30;i++){
				try {
					
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				if(this.y<400)
				{
			y+=speed;
				}
			}
			break;
		case 3:
			
			for(int i=1;i<30;i++){
				try {
					
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
					
				}
				if(this.x<400)
				{
				x+=speed;
				}
			}
			break;
			
		}
	
		
		if(this.live==false)
		{
			break;
		}
		
		}
	}
	
}

