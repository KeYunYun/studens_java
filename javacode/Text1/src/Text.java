import javax.swing.*;
import java.awt.*;

public class Text extends JFrame{

	JPanel jp1,jp2;
	JButton jb1,jb2,jb3,jb4,jb5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Text text=new Text();
		
		
	}
	public Text()
	{
		Image im=Toolkit.getDefaultToolkit().getImage
				(Panel.class.getResource("/bom.jpg"));
						
		jb1=new JButton("1");
		jb2=new JButton("2");		
		jb3=new JButton("3");
		jb4=new JButton("4");
		jb5=new JButton("5");

		jp1=new JPanel();
		jp2=new JPanel();
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb4);
		jp2.add(jb5);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jb3, BorderLayout.CENTER);
		this.add(jp2,BorderLayout.SOUTH);
		
		this.setSize(300,200);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

}
