package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.JDBC接口或类在java.sql包中。
		Connection con;
		Statement stm;
		String url="jdbc:mysql://localhost:3306/mydb";
		String user="root";
		String password="kcy000";
		try {
			//1.JDBC接口或类在java.sql包中。
			Class.forName("com.mysql.jdbc.Driver");
			//2.链接数据库
			con=DriverManager.getConnection(url, user, password);
			// Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
			stm=con.createStatement();
			
			//建立sql

			String sql="insert into rb_root " +
					"values (?, ?, ?);";
			//执行插入sql语句
			PreparedStatement ps=con.prepareStatement(sql);		
			System.out.println(12);
			ps.setInt(1, 2);
			ps.setString(2, "xd");
			ps.setString(3, "sd");
			System.out.println(35);
			
			ps.executeUpdate();
			System.out.println(67);
			
		/*	String sql1="select * from tb_root";
			System.out.println(sql);
			//执行sql语句，建立结果集
			ResultSet res=stm.executeQuery(sql1);
			while(res.next()){
				int id=res.getInt("ID");
				String name=res.getString("user");
				String pwd=res.getString("password");
				System.out.println(id+name+pwd);
			}
			*/
			ps.close();
			//stm.close();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			
		}finally {

		}
	}

}
