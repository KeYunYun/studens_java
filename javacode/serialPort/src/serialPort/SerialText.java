package serialPort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gnu.io.SerialPort;

public class SerialText extends JFrame {

	JPanel jpanel1;
	GridLayout grid;
	JLabel jlable1;
	ArrayList<String> list=null;
	
  //  private SerialPort serialPort = null;    //保存串口对象
	public SerialText(){
		super("串口通信");
		SerialTool serial=SerialTool.getSerialTool();
		setSize(600,600);
		setResizable(true);
		setVisible(true);
		jpanel1=new JPanel();
		jpanel1.setBackground(Color.yellow);
		
		jlable1=new JLabel("串口");
		jpanel1.add(jlable1);
		
		list=SerialTool.findPort();
		
  
		add(jpanel1,BorderLayout.WEST);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerialText sert=new SerialText();

		sert.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


}
