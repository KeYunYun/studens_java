
import javax.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.scenario.animation.shared.TimerReceiver;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sun.security.util.PendingException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
public class Text extends JFrame implements ActionListener  {
	JButton jb1;
	JButton jb2;
	JButton jb3;
	JButton jb4;
	JButton jb5;
	JButton jb6;
	JButton jb7;
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;
	JPanel jp4;
	JPanel jp5;
	JPanel jp6;
	int x=0;
	int y=0;
	boolean islive=false;
	static Timer timer;
	static Text text;
	public static void main(String[] args) {
		 text=new Text();
		//timer=new Timer();
		timer = new Timer();
		timer.scheduleAtFixedRate(text.new Mark(), 0, 50);

		
	}
	 class Mark  extends TimerTask
	{	
		 
	
		public void run() {
			// TODO Auto-generated method stub
			
			System.out.println(jp5.getLocation().x+"  "+jp5.getLocation().y);
				
			Point p=new Point();
			p=jp5.getLocation();
			if(islive==true)
			{
				if(x>p.x)
				{
					jp5.setLocation(p.x+1, p.y);
				}
				if(x<p.x)
				{
					jp5.setLocation(p.x-1, p.y);
				}
				if(y>p.y)
				{
					jp5.setLocation(p.x, p.y+1);
				}
				if(y<p.y)
				{
					jp5.setLocation(p.x, p.y-1);
				}
				if(x==p.x&&y==p.y)
				{
					JOptionPane.showMessageDialog(null, "寻找成功");
					 cancel();
				}
				
			}
		}
	}
	public Text()
	{
		jb1=new JButton("上");
		jb1.addActionListener(jb1handler);
		jb2=new JButton("下");
		jb2.addActionListener(jb1hand2er);
		jb3=new JButton("左");
		jb3.addActionListener(jb1hand3er );
		jb4=new JButton("右");
		jb4.addActionListener(jb1hand4er);
		jb5=new JButton("开始寻找");
		jb5.addActionListener(jjb1hand5er);
		
		jb6=new JButton("停止");
		//jb6.addActionListener(jb1hand6er);
		jb6.addActionListener(this);
		jb6.setActionCommand("停止");
		
		jb7=new JButton("开始");
		jb7.addActionListener(jb1hand7er);
		
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		jp5.setBackground(Color.green);
		jp5.setPreferredSize(new Dimension(50, 50));
		jp5.setLocation(50, 50);
		
		jp6.setBackground(Color.red);
		jp6.setPreferredSize(new Dimension(10, 10));
		jp6.setLocation(50, 50);
		
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp3.add(jb5);
		jp3.add(jb6);
		jp3.add(jb7);
		
		
		
		jp1.setBackground(Color.white);
		jp1.add(jp5);
		jp1.add(jp6);
		jp5.setLayout(null);
		jp5.setVisible(true);
		jp2.setBackground(Color.yellow );
		jp3.setBackground(Color.green);
		
		jp3.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
		jp4.setLayout(new GridLayout(1,2));

		jp4.add(jp2);
		jp4.add(jp3);
		
		this.add(jp1);
		this.add(jp4,BorderLayout.SOUTH);
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private ActionListener jb1handler =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Point p=new Point();
			p=jp5.getLocation();
			jp5.setLocation(p.x, p.y-10);
		}
	};
private ActionListener jb1hand2er =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Point p=new Point();
			p=jp5.getLocation();
			jp5.setLocation(p.x, p.y+10);
		}
	};
private ActionListener jb1hand3er =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Point p=new Point();
			p=jp5.getLocation();
			jp5.setLocation(p.x-10, p.y);
		}
	};
private ActionListener jb1hand4er =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Point p=new Point();
			p=jp5.getLocation();
			jp5.setLocation(p.x+10, p.y);
		}
	};
private ActionListener jjb1hand5er =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			x=(int)(Math.random()*300);
			y=(int)(Math.random()*300);
			Point p=new Point();
			p=jp6.getLocation();
			jp6.setLocation(x, y);
			islive=true;
		}
	};
private ActionListener jb1hand6er =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			islive=false;
		}
	};
private ActionListener jb1hand7er =new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			islive=true;
		}
	};

public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("停止"))
	{
		
		
		islive=false;
		//jb6.setText("开始");
	    jb6.setActionCommand("开始");
	
		
	}
	else if(e.getActionCommand().equals("开始"))
	{
		
		
		//jb6.setText("停止");
		jb6.setActionCommand("停止");
		islive=true;
	}
}

}
