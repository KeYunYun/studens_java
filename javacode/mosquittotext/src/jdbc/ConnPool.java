package jdbc;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnPool {

	/**
	 * ���ӳ��������ݿ�
	 * @param args
	 */

	private static BasicDataSource ds;
	
	private static ThreadLocal<Connection> t1;
	 Connection conn = null;
	Statement sta = null;
	static{
		try {
			//���������ļ�
			Properties prop=
				new Properties();
			InputStream is =
				ConnPool.class.getClassLoader()
				.getResourceAsStream("jdbc"+File.separator+"config.properties");
			prop.load(is);
			is.close();
			//��ʼ�����ӳ�
			ds=new BasicDataSource();
			//��������
			ds.setDriverClassName(prop.getProperty("driver"));
			//����url
			ds.setUrl(prop.getProperty("url"));
			//�����û���
			ds.setUsername(prop.getProperty("user"));
			//��������
			ds.setPassword(prop.getProperty("pwd"));
			
			//���������������
			ds.setMaxActive(Integer.parseInt(prop.getProperty("maxactive")));
			//��ʼ��������
			ds.setInitialSize(Integer.parseInt(prop.getProperty("initsize")));
			//�������ȴ�ʱ��
			ds.setMaxWait(Integer.parseInt(prop.getProperty("maxwait")));
			//������С�߳���
			ds.setMinIdle(Integer.parseInt(prop.getProperty("minidle")));
			//������������
			ds.setMaxIdle(Integer.parseInt(prop.getProperty("maxidle")));
			//��ʼ�����߳�
			t1=new ThreadLocal<Connection>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * �������ݿ�
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		/**
		 * ͨ�����ӳػ�ȡһ����������
		 */
		
		Connection conn =
			ds.getConnection();
		t1.set(conn);
		return conn;
	}
	
	public static void closeConnection(){
		try {
			Connection conn =t1.get();
			if(conn!=null){
				/**
				 * �����ӻ������ӳ�
				 */
				conn.close();
				t1.remove();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public  ConnPool(){
		try {
			conn=ConnPool.getConnection();
			
			sta=conn.createStatement();	
			sta.close();
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	}

	public ResultSet select(String sql) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);//3.�򿪲�ѯ�༭������дsql���
			return pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//
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
