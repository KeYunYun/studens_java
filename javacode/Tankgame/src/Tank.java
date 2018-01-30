import java.util.Vector;

//ÃπøÀ¿‡
class Tank  
{
	int x=0;
	int y=0;
	int direct=0;
	int speed=3;
	boolean live=true;
	
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

class Hero extends Tank
{
	Vector<Shot> ss=new Vector<Shot>();
		Shot shot=null;	
	public Hero(int x ,int y)
	{
		super(x,y);
	}

	public void ShotEnemyTank()
	{
			
		switch(this.direct)
		{
		case 0:
			shot=new Shot(x+10, y,0);
			ss.add(shot);
			break;
		case 1:
			shot=new Shot(x, y+10,1);
			ss.add(shot);
			break;
		case 2:
			shot=new Shot(x+10, y+30,2);
			ss.add(shot);
			break;
		case 3:
			shot=new Shot(x+30, y+10,3);
			ss.add(shot);
			break;
		}
		Thread t=new Thread(shot);
		t.start();
		
	}
	
	public void moveup()
	{
		y-=speed;
	}
	public void movedown()
	{
		y+=speed;
	}
	public void moveleft()
	{
		x+=speed;
	}
	public void moveright()
	{
		x-=speed;
	}
}