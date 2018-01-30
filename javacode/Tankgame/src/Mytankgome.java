 import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sun.prism.Graphics;

public class Mytankgome extends JFrame{
			public static void main(String[] args) {
		// TODO Auto-generated method stub
			Mytankgome tank= new Mytankgome();
		
	}
	public Mytankgome()
	{
		Mypanel mp=new Mypanel();
		this.add(mp);
		Thread tmp=new Thread(mp);
		tmp.start();
		this.addKeyListener(mp);
		this.setSize(600, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

