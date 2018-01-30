import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel {
	public static final int WIDTH=400;
	public static final int HEIGHT=654;
	public static  BufferedImage background;
	public static  BufferedImage start;
	public static  BufferedImage pause;
	public static  BufferedImage gameover;
	public static  BufferedImage bee;
	public static  BufferedImage hero0;
	public static  BufferedImage hero1;
	public static  BufferedImage bullet;
	public static  BufferedImage airplane;
	
	public Hero hero=new Hero();
	public Bullet[] bullets={};
	public FlyingObject[] flyings={};
	
	public ShootGame(){
		flyings =new FlyingObject[2];
		flyings[0]=new Airplane();
		flyings[1]=new Bee();
		bullets =new Bullet[1];
		bullets[0]=new Bullet(hero.x+hero.width/2, hero.y);
	}
	public void paint(Graphics g){//在paint上当作绘画笔
		g.drawImage(background,0,0,null);//画图片
		paintHero(g);
		paintBullets(g);
		paintFlyingObjects(g);
		paintScore(g);
		paintState(g);
	}
	public void paintHero(Graphics g){
		g.drawImage(hero.image, hero.x,hero.y,null);
	}
	public void paintBullets(Graphics g){
		for(int i=0;i<bullets.length;i++){
			Bullet bullet=bullets[i];
			g.drawImage(bullet.image, bullet.x,bullet.y,null);
		}
	
	}
	public void paintFlyingObjects(Graphics g){
		for(int i=0;i<flyings.length;i++){
			FlyingObject f=flyings[i];
			g.drawImage(f.image,f.x,f.y,null);
		}
	}
	public void paintScore(Graphics g){
		g.drawString("SCORE:"+score, 10, 25);
		g.drawString("LIFE:"+hero.getLife(), 10, 40);
	}
	
	private Timer timer; //定时器
	private int interval=10;//时间间隔 毫秒
	
	public void action(){
		timer =new Timer();//创建定时器
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {//定时执行的方法
				// TODO Auto-generated method stub
				if(state==RUNNING){
					enterAction();
					stepAction();
					shootAction();
					bangAction();
					outofBoundsACtion();
					checkGameOverAction();
				}
				
				repaint();
			}
		}, interval,interval);//定时触发
		//鼠标事件适配器
		MouseAdapter l= new MouseAdapter() {
		@Override//重写鼠标移动的方法
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			//super.mouseMoved(e);
			if(state==RUNNING){
				int x=e.getX();
				int y=e.getY();
				hero.moveTo(x, y);
			}

		}
		@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//super.mouseClicked(e);
				switch(state){
				case START:
					state=RUNNING;
					break;
				case GAME_OVER:
					hero=new Hero();
					flyings=new FlyingObject[0];
					bullets=new Bullet[0];
					score=0;
					state=START;	
					break;
				case RUNNING:
					state=PAUSE;
					break;
				case PAUSE:
					state=RUNNING;
					break;
									
				}
			}
		@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				//super.mouseDragged(e);
			if(state !=GAME_OVER ){
				state=PAUSE;
			}
			
			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					//super.mouseEntered(e);
				if(state==PAUSE){
					state=RUNNING;
				}
				}
		
		};
		//添加鼠标点击事件
		this.addMouseListener(l);
		//给面板增加鼠标滑动侦听事件
		this.addMouseMotionListener(l);
		
	}
	int shootIndex=0;
	
	public void shootAction(){
		shootIndex++;
		if(shootIndex%30==0){
			Bullet[] bs=hero.shoot();
			bullets=Arrays.copyOf(bullets,bullets.length+bs.length );
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length,bs.length);
			
			
			
		}
	}
	int flyEnterIndex=0;
	
	public  void checkGameOverAction(){
		if(isGameOver()){
			state=GAME_OVER;
		}
	}
	public boolean isGameOver(){
		for(int i=0;i<flyings.length;i++){
			int index=-1;
			FlyingObject obj=flyings[i];
			if(hero.hit(obj)){
				hero.subtractLife();
				hero.setDoubleFire(0);
				index=i;
			}
			if(index!=-1){
				FlyingObject t=flyings[index];
				flyings[index]=flyings[flyings.length-1];
				flyings[flyings.length-1]=t;
				flyings=Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife()<=0;
	}
	public void outofBoundsACtion(){
		int index=0;
		FlyingObject[] fliingLives=new FlyingObject[flyings.length];
		for(int i=0;i<flyings.length;i++){
			FlyingObject f=flyings[i];
			if(!f.outofBounds()){
				fliingLives[index++]=f;
			}
		}
		flyings=Arrays.copyOf(fliingLives,index);
		
		index=0;
		Bullet[] bullerLive=new Bullet[bullets.length];
		for(int i=0;i<bullets.length;i++){
			Bullet b=bullets[i];
			if(!b.outofBounds()){
				bullerLive[index++]=b;
			}
		}
		bullets=Arrays.copyOf(bullerLive, index);
	}
	public void bangAction(){
		for(int i=0;i<bullets.length;i++){
			Bullet b=bullets[i];
			bang(b);
		}
	}
	private int score=0;
	private int state;
	public static final int START=0;
	public static final int RUNNING=1;
	public static final int PAUSE=2;
	public static final int GAME_OVER=3;
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(start, 0, 0,null);
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0,null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0,null);
			break;
		}
	}
	public void bang(Bullet b){
		int index=-1;
		for(int i=0;i<flyings.length;i++){
			FlyingObject obj=flyings[i];
			if(obj.shootBy(b)){
				index=i;
				break;
			}
		}
		if(index!=-1){
			FlyingObject one =flyings[index];
			
			FlyingObject t=flyings[index];
			flyings[index]=flyings[flyings.length-1];
			flyings[flyings.length-1]=t;
			flyings=Arrays.copyOf(flyings, flyings.length-1);
			
			if(one instanceof Enemy){
				Enemy e=(Enemy)one;
				score+=e.getScore();
			}else if(one instanceof Award){
				Award a=(Award)one;
				int type=a.getType();
				switch(type){
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
		}
		
	}
	public void enterAction(){
		flyEnterIndex++;
		if(flyEnterIndex%40==0){
			FlyingObject obj=nextOne();
			flyings=Arrays.copyOf(flyings,flyings.length+1);
			flyings[flyings.length-1]=obj;
		}
	}
	public static FlyingObject nextOne(){
		int type=(int)(Math.random()*19);
		if(type==0){
			return new  Bee();
		}else{
			return new Airplane();
		}
		
	}
	public void stepAction(){
		for(int i=0;i<flyings.length;i++){
			flyings[i].step();
		}
		for(int i=0;i<bullets.length;i++){
			bullets[i].step();
		}
		hero.step();
	}

	
	
	static{
		try {
			background=ImageIO.read(ShootGame.class.getResource("background.jpg"));
			start=ImageIO.read(ShootGame.class.getResource("start.jpg"));
			pause=ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover=ImageIO.read(ShootGame.class.getResource("gameover.png"));
			bee=ImageIO.read(ShootGame.class.getResource("bee.png"));
			hero0=ImageIO.read(ShootGame.class.getResource("hero0.png"));
			hero1=ImageIO.read(ShootGame.class.getResource("hero1.png"));
			bullet=ImageIO.read(ShootGame.class.getResource("shoot.png"));
			airplane=ImageIO.read(ShootGame.class.getResource("airplane.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("FLY");//窗口
		ShootGame game =new ShootGame();//创建画板
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setAlwaysOnTop(true);//设置窗口一直在上
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									//设置默认关闭窗口
		frame.setLocationRelativeTo(null);//设置默认相对窗口位置
		frame.setVisible(true);
		game.action();
	}

}
