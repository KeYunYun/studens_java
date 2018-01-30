
public class Bullet extends FlyingObject {
	private int speed=3;
	public Bullet(int x,int y){
		image=ShootGame.bullet;
		width=image.getWidth();
		height=image.getHeight();
		this.x=x;
		this.y=y;
	}
	@Override
	public void step() {
		// TODO Auto-generated method stub
		y-=speed;
	}
	public boolean outofBounds() {
		// TODO Auto-generated method stub
		return y<-height;
	}
	
}
