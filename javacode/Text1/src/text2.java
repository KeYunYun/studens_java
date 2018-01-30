import javax.swing.*;
import java.awt.*;
public class text2 extends JFrame {
	
	JPanel jp1,jp2,jp3;
	JLabel jl1,jl2;
	JButton jb1,jb2;
	JTextField jt1;
	JPasswordField jp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		text2 t=new text2();
	}
	public text2()
	{
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
				
		jb1=new JButton("µÇÂ¼");
		jb2=new JButton("×¢²á");
				
		jl1=new JLabel("ÓÃ»§Ãû");
		jl2=new JLabel("ÃÜÂë");
		
		jp=new JPasswordField(10);
		jt1=new JTextField(10);
		
		this.setLayout(new GridLayout(3,1));
		
		jp1.add(jl1);
		jp1.add(jt1);
		
		jp2.add(jl2);
		jp2.add(jp);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	

}
