
public class Bee extends FlyingObject implements Award {

	private int xSpeed=1;
	private int ySpeed=2;
	private int awardType;
	
	public Bee(){
		image=ShootGame.bee;
		width=image.getWidth();
		height=image.getHeight();
		y=-height;
		x=(int)(Math.random()*(ShootGame.WIDTH-width));
		awardType=(int)(Math.random()*2);
	}
	
	public int getType() {
		
		return 0;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		x +=xSpeed;
		y +=ySpeed;
		if(x<0){
			xSpeed=1;
		}
		if(x>ShootGame.WIDTH-width){
			xSpeed=-1;
		}
	}

	@Override
	public boolean outofBounds() {
		// TODO Auto-generated method stub
		return y>ShootGame.HEIGHT;
	}
	
	
}
