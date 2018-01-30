import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
public class Mysql {
	String url="jdbc:mysql://localhost:3306/taskone";
	String user="root";
	String password="kcy000";
	Connection conn;
	Statement stm;
	public Mysql() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//2.链接数据库
			conn=DriverManager.getConnection(url, user, password);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			stm=conn.createStatement();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertWord(String tb_name,String lables_en,String id,
			               String lables_zh,String descriptions_en,
			               String descriptions_zh,String aliases_en,
			               String aliases_zh,String claims){
	/*	String sql="insert into "+tb_name +" values('"
				+lables_en+"','"+id+"','"+lables_zh+"','"+descriptions_en+
				"','"+descriptions_zh+"','"+aliases_en+"','"+aliases_zh+
				"','"+claims+"');";*/
				
		String sql="insert into "+tb_name +" values(?,?,?,?,?,?,?,?);";
	//System.out.println(sql);
	try {
	       PreparedStatement stmt = conn.prepareStatement(sql);   //会抛出异常
	              stmt.setString(1, lables_en);    //设置SQL语句第二个“？”的值
	              stmt.setString(2, id);
	              stmt.setString(3, lables_zh);
	              stmt.setString(4, descriptions_en);
	              stmt.setString(5, descriptions_zh);
	              stmt.setString(6, aliases_en);
	              stmt.setString(7, aliases_zh);
	              stmt.setString(8, claims);
	              stmt.executeUpdate();    
		
		//stm.execute(sql);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void insertSQLNum(String tb_name,String id,String wordentry){
	/*	String sql="insert into "+
					tb_name+"(id,wordentry) values('"+id+"','"+wordentry+"');";
					*/
		String sql="insert into "+
				tb_name+"(id,wordentry) values(?,?);";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);   //会抛出异常
            stmt.setString(1, id);    //设置SQL语句第二个“？”的值
            stmt.setString(2, wordentry);
            stmt.executeUpdate(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void queryNum(){
		String SQL="select * from tb_fristnum_p";
		
		ResultSet res;
		try {
			res = stm.executeQuery(SQL);
			while(res.next()){
				String id=res.getString("id");
				String wordentry=res.getString("wordentry");
			
				System.out.println(id+wordentry);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet query(String labels_en) throws SQLException{
		String fristNum=(String) labels_en.subSequence(0, 1);
		String sql="";
		if(fristNum.equals("K")||fristNum.equals("k")||
				fristNum.equals("V")||fristNum.equals("v")){
			
			sql="select * from tb_word_kv  where lables_en='"+labels_en+"'";
		}else if(fristNum.equals("B")||fristNum.equals("b")||fristNum.equals("C")||
				fristNum.equals("c")||fristNum.equals("F")||fristNum.equals("f")||
				fristNum.equals("G")||fristNum.equals("g")||fristNum.equals("M")||
				fristNum.equals("m")||fristNum.equals("P")||fristNum.equals("p")||
				fristNum.equals("U")||fristNum.equals("u")||fristNum.equals("W")||
				fristNum.equals("w")||fristNum.equals("Y")||fristNum.equals("y")||
				fristNum.equals("D")||fristNum.equals("d")||fristNum.equals("l")||
				fristNum.equals("L")){
			sql="select * from tb_word_"+fristNum.toLowerCase()+" where lables_en='"+labels_en+"'";
			
		}else if(fristNum.equals("E")||fristNum.equals("e")){
			  String sendNum=(String) labels_en.subSequence(1, 2);
			  String pattern1 = "[a-gA-G]";
			  String pattern2 = "[h-pH-P]";
			  if(Pattern.matches(pattern1, sendNum)){;
				  sql="select * from tb_word_e_0 where lables_en='"+labels_en+"'";
			  }else if(Pattern.matches(pattern2, sendNum)){
				  sql="select * from tb_word_e_1 where lables_en='"+labels_en+"'";
			  }else{
				  sql="select * from tb_word_e_2 where lables_en='"+labels_en+"'";
			  }
		     
		}else if(fristNum.equals("A")||fristNum.equals("a")||fristNum.equals("H")||fristNum.equals("h")
				||fristNum.equals("i")||fristNum.equals("I")||fristNum.equals("n")
				||fristNum.equals("N")||fristNum.equals("o")||fristNum.equals("O")
				||fristNum.equals("R")||fristNum.equals("r")||fristNum.equals("S")
				||fristNum.equals("s")||fristNum.equals("T")||fristNum.equals("t")){
			 String sendNum=(String) labels_en.subSequence(1, 2);
			  String pattern1 = "[a-jA-J]";
			  if(Pattern.matches(pattern1, sendNum)){
				  sql="select * from tb_word_"+fristNum.toLowerCase()+"_0 where lables_en=+'"+labels_en+"'";
		  
			  }else {
				  sql="select * from tb_word_"+fristNum.toLowerCase()+"_1 where lables_en=+'"+labels_en+"'";

			  }				
		
		}else{
			  sql="select * from tb_word_jqxz where lables_en='"+labels_en+"'";
		}
		ResultSet res;
		System.out.println(sql);
		res = stm.executeQuery(sql);
//			while(res.next()){
//				String lables_en =res.getString("lables_en");
//			    String id =res.getString("id");
//			    String lables_zh =res.getString("lables_zh");
//			    String descriptions_en =res.getString("descriptions_en");
//			    String descriptions_zh=res.getString("descriptions_zh");
//			    String aliases_en =res.getString("aliases_en");
//				String aliases_zh =res.getString("aliases_zh");
//			    String claims =res.getString("claims");
//				
//			}
		
		return res;
			
	}
	public ArrayList<String> querylike(String labels_en) throws SQLException{
		String fristNum=(String) labels_en.subSequence(0, 1);
		String sql="";
		if(fristNum.equals("K")||fristNum.equals("k")||
				fristNum.equals("V")||fristNum.equals("v")){
			
			sql="select * from tb_word_kv  where lables_en like'"+labels_en+"%'";
		}else if(fristNum.equals("B")||fristNum.equals("b")||fristNum.equals("C")||
				fristNum.equals("c")||fristNum.equals("F")||fristNum.equals("f")||
				fristNum.equals("G")||fristNum.equals("g")||fristNum.equals("M")||
				fristNum.equals("m")||fristNum.equals("P")||fristNum.equals("p")||
				fristNum.equals("U")||fristNum.equals("u")||fristNum.equals("W")||
				fristNum.equals("w")||fristNum.equals("Y")||fristNum.equals("y")||
				fristNum.equals("D")||fristNum.equals("d")||fristNum.equals("l")||
				fristNum.equals("L")){
			sql="select * from tb_word_"+fristNum.toLowerCase()+" where lables_en like'"+labels_en+"%'";
			
		}else if(fristNum.equals("E")||fristNum.equals("e")){
			  String sendNum=(String) labels_en.subSequence(1, 2);
			  String pattern1 = "[a-gA-G]";
			  String pattern2 = "[h-pH-P]";
			  if(Pattern.matches(pattern1, sendNum)){;
				  sql="select * from tb_word_e_0 where lables_en like'"+labels_en+"%'";
			  }else if(Pattern.matches(pattern2, sendNum)){
				  sql="select * from tb_word_e_1 where lables_en like'"+labels_en+"%'";
			  }else{
				  sql="select * from tb_word_e_2 where lables_en like'"+labels_en+"%'";
			  }
		     
		}else if(fristNum.equals("A")||fristNum.equals("a")||fristNum.equals("H")||fristNum.equals("h")
				||fristNum.equals("i")||fristNum.equals("I")||fristNum.equals("n")
				||fristNum.equals("N")||fristNum.equals("o")||fristNum.equals("O")
				||fristNum.equals("R")||fristNum.equals("r")||fristNum.equals("S")
				||fristNum.equals("s")||fristNum.equals("T")||fristNum.equals("t")){
			 String sendNum=(String) labels_en.subSequence(1, 2);
			  String pattern1 = "[a-jA-J]";
			  if(Pattern.matches(pattern1, sendNum)){
				  sql="select * from tb_word_"+fristNum.toLowerCase()+"_0 where lables_en like+'"+labels_en+"%'";
		  
			  }else {
				  sql="select * from tb_word_"+fristNum.toLowerCase()+"_1 where lables_en like+'"+labels_en+"%'";

			  }				
		
		}else{
			  sql="select * from tb_word_jqxz where lables_en like'"+labels_en+"%'";
		}
		ResultSet res;
		//System.out.println(sql);
		res = stm.executeQuery(sql);
		ArrayList<String> list=new ArrayList<String>();
			while(res.next()){
				String lables_en =res.getString("lables_en");
				list.add(lables_en);
				
			}
			System.out.println(list);
		
		return list;
			
	}
	
	public void selectunm(String id){
		String sql="";
		if(id.substring(0, 1).equals("Q")||id.substring(0,1).equals("q")){
			sql="select * from tb_fristnum_q where id = '"+id+"'";
		}else{
			sql="select * from tb_fristnum_p where id = '"+id+"'";
		}
		
	}
	
	public void closeDB(){
		try {
			conn.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Mysql mysql=new Mysql();
		mysql.querylike("en");
		mysql.closeDB();
	}

}
