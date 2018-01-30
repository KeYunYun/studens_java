import java.awt.Color;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.tools.Tool;

import com.sun.javafx.iio.ImageLoader;
import com.sun.javafx.tk.Toolkit;
import com.sun.prism.Image;

class Mypanel extends JPanel implements KeyListener ,Runnable
 {
	//Image image1 = null;

	int time=0;
	 //ImageIcon image1=null;
	 
	 Hero hero=null;
	 Vector<EnemyTank> ets=new Vector<EnemyTank>();
	 
	 Vector<Bomb> bomb=new Vector<Bomb>();
	 int enSize=3;
	 java.awt.Image img;
	 
	 public Mypanel()
	 {
		 hero=new Hero(10, 10);
		 for(int i=0;i<enSize;i++)
		 {
			 EnemyTank et=new EnemyTank((i+1)*50, 0);
			 et.setDirect(2);
			 Thread t=new Thread(et);
			 t.start();
			
			 Shot s=new Shot(et.x+10,et.y+30, et.direct);
			 et.ss.add(s);
			 Thread t2=new Thread(s);
			 t2.start();
			  ets.add(et);
		 }
		// image1=new ImageIcon("\bom.jpg");
	//	img=image1.getImage();
		// image1 =Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bom.jpg"));
	 }
	 public void hitme()
	 {
		 for(int i=0;i<this.ets.size();i++)
		 {
			 EnemyTank et=ets.get(i);
			 
			 for(int j=0;j<et.ss.size();j++)
			 {
				 Shot eShot=et.ss.get(j);
				 
				 this.hitEnemyTank(eShot, hero);
			 }
			 
		 }
	 }
	 public void  hitETank()
	 {
		 for(int i=0;i<hero.ss.size();i++)
			{
				Shot sh=hero.ss.get(i);
				if(sh.live)
				{
					for(int j=0;j<ets.size();j++)
					{
						EnemyTank et=ets.get(j);
						if(et.live)
						{
							this.hitEnemyTank(sh, et);
						}
					}
				}
			}
	 }
	 
	 public void paint(java.awt.Graphics g)
	 {		 		 
		 super.paint(g);	
		 //g.setColor(Color.white);
		 g.fillRect(0, 0, 500, 500);
		 if(hero.live)
		 {
		 this.DramTank(hero.getX(),hero.getY(), g, hero.getDirect(), 1);
		 }
		 for(int j=0;j<ets.size();j++)
		 {		
			 EnemyTank ett=ets.get(j);
			if(ett.live)
			{
			 this.DramTank(ett.getX(),ett.getY(), g,ett.getDirect(), 0);
			 
			 for(int k=0;k<ett.ss.size();k++)
			 {
				 Shot eshot=ett.ss.get(k);
				 if(eshot.live)
				 {
					 g.setColor(Color.blue);
					 g.fillOval(eshot.x, eshot.y, 2, 2);
					 
				 }else{
					 ett.ss.remove(eshot);
				 }
				 
			 }
			}	 
		 }
		 for(int i=0;i<hero.ss.size();i++)
		 {
			 Shot s=hero.ss.get(i);
		 if(s!=null && s.live)
		 {
			 this.DramShot(s.x,s.y , g);
		 }
		 if(s.live==false)
		 {
			 hero.ss.remove(s);
		 }
		 }
		 
		 for(int i=0;i<bomb.size();i++)
		 {
			 Bomb b=bomb.get(i);
			//g.drawImage(img, b.x, b.y, 30,30,this);
			 
			 //g.drawRect(b.x, b.y, 30,30);
			 
			 if(b.live==false)
			 {
				 bomb.remove(b);
			 }
		 }
		 
	  }
	 public void DramTank(int x,int y,java.awt.Graphics g,int direct,int type)
	 {
		 switch(type)
		 {
		 case 0:
			 g.setColor(Color.blue);
		 	break;
		 case 1:
			 g.setColor(Color.yellow);
		 
		 }
		 switch(direct)
		 {
		 case 0:
			 //g.setColor(Color.yellow);
			 g.fill3DRect(x,y, 5, 30,false);
			 g.fill3DRect(x+15, y,5, 30,false);
			 g.fill3DRect(x+5, y+8, 10, 15,false);
			 g.fillOval(x+5, y+9, 10, 10);
			 g.drawLine(x+10, y+10, x+10, y+0);
			 break;
		 case 1:
			 //g.setColor(Color.yellow);
			 g.fill3DRect(x,y, 30, 5,false);
			 g.fill3DRect(x, y+15,30, 5,false);
			 g.fill3DRect(x+8, y+6, 15, 10,false);
			 g.fillOval(x+9, y+5, 10, 10);
			 g.drawLine(x+10, y+10, x, y+10);
			 break;
		 case 2:
			 //g.setColor(Color.yellow);
			 g.fill3DRect(x,y, 5, 30,false);
			 g.fill3DRect(x+15, y,5, 30,false);
			 g.fill3DRect(x+5, y+8, 10, 15,false);
			 g.fillOval(x+5, y+9, 10, 10);
			 g.drawLine(x+10, y+10, x+10, y+30);
			 break;
		 case 3:
			 //g.setColor(Color.yellow);
			 g.fill3DRect(x,y, 30, 5,false);
			 g.fill3DRect(x, y+15,30, 5,false);
			 g.fill3DRect(x+8, y+6, 15, 10,false);
			 g.fillOval(x+9, y+5, 10, 10);
			 g.drawLine(x+10, y+10, x+30, y+10);
			 break;
		 }
	 }

	 public void DramShot(int x,int y,java.awt.Graphics g)
	 {
		 g.setColor(Color.yellow);
		 g.fillOval(x, y, 2, 2);
	 }
	 
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_W)
		{
			this.hero.setDirect(0);
			this.hero.moveup();
			
		}else if(e.getKeyCode()==KeyEvent.VK_A)
		{
			this.hero.setDirect(1);
			this.hero.moveright();
			
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.hero.setDirect(2);
			this.hero.movedown();
			
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.hero.setDirect(3);
			this.hero.moveleft();
		}else if(e.getKeyCode()==KeyEvent.VK_J)
		{
			if(hero.ss.size()<=4)
			{
			this.hero.ShotEnemyTank();
			}
		}
		this.repaint();	
		
	}
	public void hitEnemyTank(Shot s ,Tank et)
	{
		switch(et.direct)
		{
		case 0:
		case 2:
			if(s.x>et.x&&s.x<et.x+20&&s.y>et.y&&s.y<et.y+30)
			{
				s.live=false;
				et.live=false;
				Bomb b=new Bomb(et.x, et.y);
				bomb.add(b);
			}
			break;
		case 1:
		case 3:
			if(s.x>et.x&&s.x<et.x+30&&s.y>et.y&&s.y<et.y+20)
			{
				s.live=false;
				et.live=false;
				Bomb b=new Bomb(et.x, et.y);
				bomb.add(b);
			}
			break;
		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
		try {
			Thread.sleep(50);
			time++;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hitETank();
		this.hitme();
		
		if(time%25==0){
		for(int i=0;i<ets.size();i++)
		{
			EnemyTank et=ets.get(i);
			if(et.live)
			{
				if(et.ss.size()<4)
				{
					Shot s=null;
					switch(et.direct)
					{
					case 0:
						s=new Shot(et.x+10, et.y,0);
						et.ss.add(s);
						break;
					case 1:
						s=new Shot(et.x, et.y+10,1);
						et.ss.add(s);
						break;
					case 2:
						s=new Shot(et.x+10,et.y+30,2);
						et.ss.add(s);
						break;
					case 3:
						s=new Shot(et.x+30, et.y+10,3);
						et.ss.add(s);
						break;
					}
					Thread tt=new Thread(s);
					tt.start();
				}
			}
		}
		}
		this.repaint();
		}
	}
	 
 }

