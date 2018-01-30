
public class Airplane extends FlyingObject implements Enemy{

	private int speed=2;
	public Airplane(){
		image=ShootGame.airplane;
		width=image.getWidth();
		height=image.getHeight();
		y=-height;
		x=(int)(Math.random()*(ShootGame.WIDTH-width));
	}
	public void step(){
		y+=speed;
	}
	public int getScore() {
		
		return 5;
	}
	public boolean outofBounds() {
		// TODO Auto-generated method stub
		return y>ShootGame.HEIGHT;
	}
	
}
