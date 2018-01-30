package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ParStemtentSQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//链接数据库
			Connection conn=ConnPool.getConnection();
			//格式
			String sql="insert into websites " +
					"values (?, ?, ?, ?, ?);";
			/**
			 * 根据预编译sql语句创建一个
			 * PreparedStatement
			 */
			PreparedStatement ps=
				conn.prepareStatement(sql);
			//穿入值，第一参数为字段位置，第二个参数为想要穿入的值
			ps.setInt(1, 6);
			ps.setString(2, "百度");
			ps.setString(3, "www.baidu.com");
			ps.setInt(4, 20);
			ps.setString(5, "china");
			//执行sql
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
