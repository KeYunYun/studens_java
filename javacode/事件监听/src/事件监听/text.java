package �¼�����;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class text extends JFrame implements ActionListener{
	
	JButton jb1;
	JButton jb2;
	JPanel jp1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		text t=new text();
	
	}

	public text()
	{
		jb1=new JButton("��ɫ");
		jb2=new JButton("��ɫ");
		jp1=new JPanel();
		
		jb1.addActionListener(this);
		jb1.setActionCommand("��ɫ");
		
		jb2.addActionListener(this);
		jb2.setActionCommand("��ɫ");
		
		
		
		this.add(jp1);
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2, BorderLayout.SOUTH);
		
		this.setSize(300,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("��ɫ"))
		{
			jp1.setBackground(Color.BLACK);
		}else{
			jp1.setBackground(Color.red);
		}
			
		
	}
	
}
