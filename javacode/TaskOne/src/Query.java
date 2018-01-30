import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class Query extends JFrame implements ActionListener{
	 BorderLayout layout;
	 JPanel inpanel,inpane2;
	 JLabel lable;
	 JTextField jtext;
	 JButton button1;
	 JTextArea textArea;
	 Mysql mysql;
	public Query() throws SQLException{
		super("Query");
		mysql=new Mysql();
		layout=new BorderLayout(5,5);
		Container container=getContentPane();
		container.setLayout(layout);
		
		inpanel =new JPanel();
		jtext=new JTextField(20);
		//textArea.setLineWrap(true); 
		jtext.getDocument().addDocumentListener(new DocumentListener() {
			
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text=jtext.getText();
				String str="";
				if(text.length()>=2){
					try {
						ArrayList list=mysql.querylike(text);
						System.out.println(list);
						for(int i=0;i<list.size();i++){
							str=list.get(i)+"\n"+str;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textArea.setText(str);
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				String text=jtext.getText();
				String str="";
				if(text.length()>=2){
					try {
						ArrayList list=mysql.querylike(text);
						System.out.println(list);
						for(int i=0;i<list.size();i++){
							str=list.get(i)+"\n"+str;
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textArea.setText(str);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		button1=new JButton("确定");
		button1.addActionListener(this);
		inpanel.add(new JLabel("输入"));
		inpanel.add(jtext);
		inpanel.add(button1);
		container.add(inpanel,BorderLayout.NORTH);
		
		inpane2=new JPanel();
		textArea=new JTextArea(20,20);
		inpane2.add(textArea);
		container.add(inpane2,BorderLayout.CENTER);
		
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Query q=new Query();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		String text="";
		String lables_en="",id="",lables_zh="",claims="",aliases_zh="",descriptions_en="",descriptions_zh="",aliases_en="";

		if(e.getSource()==button1){
			String lable_text=jtext.getText();
		try {

				ResultSet res = mysql.query(lable_text);
				System.out.println(res);
				while(res.next()){
				     lables_en =res.getString("lables_en");
				     id =res.getString("id");
				     lables_zh =res.getString("lables_zh");
				     descriptions_en =res.getString("descriptions_en");
				     descriptions_zh=res.getString("descriptions_zh");
				     aliases_en =res.getString("aliases_en");
					 aliases_zh =res.getString("aliases_zh");
				     claims =res.getString("claims");
					
				}
				textArea.setLineWrap(true); 
			     text="英文名称:"+lables_en+"\n"
				 +"id:"+id+"\n"
				 +"中文名称:"+lables_zh+"\n"
				 +"英文描述:"+descriptions_en+"\n"
				 +"中文描述:"+descriptions_zh+"\n"
				 +"英文别称:"+aliases_en+"\n"
				 +"中文别称:"+aliases_zh+"\n"
				 +"claims:"+claims+"\n";
			    
			      textArea.setText(text);
			      String[] strArray = null;   
				   strArray = claims.split("##");
				     System.out.println();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
