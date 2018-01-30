/*package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class TextStandJDBC {

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn=
				ConnPool.getConnection();
			System.out.println("succed");
			
			Statement state 
			=conn.createStatement();
			
			String sql ="select * from tb_root";
			
			ResultSet rs =state.executeQuery(sql);
			
			while(rs.next()){
				int id =rs.getInt("ID");     
				String user =rs.getString("user");
				String password=rs.getString("password");
				System.out.println(id+user+password);
				
			}
			
			state.close();
			ConnPool.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}

}*/
