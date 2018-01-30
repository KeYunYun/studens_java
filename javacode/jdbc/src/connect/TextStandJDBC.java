package connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class TextStandJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn=
				ConnPool.getConnection();
			System.out.println("连接成功");
			
			Statement state 
			=conn.createStatement();
			
			String sql ="select * from websites";
			
			ResultSet rs =state.executeQuery(sql);
			
			while(rs.next()){
				int id =rs.getInt("id");     //获得字段名为id的数据
				String name =rs.getString("name");
				String str=rs.getString("url");
				int alex=rs.getInt("alexa");
				String country =rs.getString("country");
				System.out.println(id+name+str+alex+country);
				
			}
			
			state.close();
			ConnPool.closeConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
	}

}
