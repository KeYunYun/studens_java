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
			//�������ݿ�
			Connection conn=ConnPool.getConnection();
			//��ʽ
			String sql="insert into websites " +
					"values (?, ?, ?, ?, ?);";
			/**
			 * ����Ԥ����sql��䴴��һ��
			 * PreparedStatement
			 */
			PreparedStatement ps=
				conn.prepareStatement(sql);
			//����ֵ����һ����Ϊ�ֶ�λ�ã��ڶ�������Ϊ��Ҫ�����ֵ
			ps.setInt(1, 6);
			ps.setString(2, "�ٶ�");
			ps.setString(3, "www.baidu.com");
			ps.setInt(4, 20);
			ps.setString(5, "china");
			//ִ��sql
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
