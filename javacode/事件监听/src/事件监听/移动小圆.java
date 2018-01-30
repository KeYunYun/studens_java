package 事件监听;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.prism.Graphics;

public class 移动小圆 extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 移动小圆 w=new 移动小圆();
		
	}
	public 移动小圆()
	{
	
		Mypanel mp= new Mypanel();
		
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(300, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
class Mypanel extends JPanel implements KeyListener
{
	int x=10;
	int y=10;
	public void paint(java.awt.Graphics g)
	{
		super.paint( g);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("按下");
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			y=y+3;
		}else if(e.getKeyCode()==KeyEvent.VK_UP){
			y=y-3;	
		}else if(e.getKeyCode()==KeyEvent.VK_LEFT){
			x=x-3;
		}else{
			x=x+3;
		}
			
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("放开");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("一尺");
	}
	
}
