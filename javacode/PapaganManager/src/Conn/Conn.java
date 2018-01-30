package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
  public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=plantmanager";//final��׼�޸�ֵ
  public static final String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  public static final String user = "sa";
  public static final String password = "gxa";
  Connection conn;
  
  public Conn(){//���췽�� new��ʱ����ã�ֻ����һ��
	  try {
		  Class.forName(drivername);//1.�򿪳���,�������� �������
		  conn = DriverManager.getConnection(url, user, password);//2.��д��¼��Ϣ ����д�û�������������ַ
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  
  }
  public ResultSet select(String sql){//ResultSet��������
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);//3.�򿪲�ѯ�༭������дsql���
			return pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//�����������ִ�� ִ�е�����һ��return���˳���������쳣���򷵻�null
}
  public int update(String sql){
	 
	  int rs = 0;
	try {
		PreparedStatement pstm = conn.prepareStatement(sql);//3.�򿪲�ѯ�༭������дsql���
		  rs = pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return rs;
  }
}
