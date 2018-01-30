
import java.awt.image.BufferedImage;
public class Hero extends FlyingObject{
	private BufferedImage [] images={};
	private int index;
	private int doubleFire;
	private int life;
	public int getLife() {
		return life;
	}
	public Hero(){
		image=ShootGame.hero0;
		width=image.getWidth();
		height=image.getHeight();
		x=150;
		y=400;
		doubleFire=0;
		life=3;
		images=new BufferedImage[]{ShootGame.hero0,ShootGame.hero1};
		
		
	}
	@Override
	public void step() {
		// TODO Auto-generated method stub
		int num=index++/10%images.length;
		image=images[num];
	}
	
	public Bullet[] shoot(){
		int xStep=this.width/4-5;
		//int yStep=20;
		if(doubleFire>0){
			Bullet[] bullets=new Bullet[2];
			bullets[0]=new Bullet(this.x+xStep, this.y);
			bullets[1]=new Bullet(this.x+xStep*3, this.y);
			return bullets;
		}else{
			Bullet[] bullets=new Bullet[1];
			bullets[0]=new Bullet(this.x+xStep*2, this.y);
			return bullets;
		}
		
		
	}
	
	public void moveTo(int x,int y){
		this.x=x-this.width/2;
		this.y=y-this.height/2;

	}
	
	public void addDoubleFire(){
		doubleFire +=40;
	}
	public void addLife(){
		life++;
	}
	public boolean outofBounds() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean hit(FlyingObject other){
		int x1=other.x-this.width/2;
		int x2=other.x+other.width+this.width/2;
		int y1=other.y-this.height/2;
		int y2=other.y+other.height+this.height/2;	
		int herox=this.x+this.width/2;
		int heroy=this.y+this.height/2;
		
		return  herox>x1&&herox<x2
				&&
				heroy>y1&&heroy<y2;
	}

	public void subtractLife(){
		life--;
	}
	public void setDoubleFire(int doubleFire){
		this.doubleFire=doubleFire;
	}
}
