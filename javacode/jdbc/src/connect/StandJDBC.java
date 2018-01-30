package connect;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class StandJDBC {

	/**
	 * @param args
	 * ʹ�������ļ����������ݿ�
	 */
	private static String url;
	private static String user;
	private static String pwd;
	//������ݿ������
	private static ThreadLocal<Connection>
	t1=new ThreadLocal<Connection>();
	static{
		try {
			//��ȡ�����ļ��ı�׼
			Properties prop =
				new Properties();
			InputStream is=
				StandJDBC.class.getClassLoader()
				.getResourceAsStream("connect/config.properties");
			prop.load(is);
			//ȡֵ
			String driver=prop.getProperty("driver");
			 url=prop.getProperty("url");
			user=prop.getProperty("user");
			 pwd=prop.getProperty("pwd");
			System.out.println(driver+url+pwd+user);
			is.close();
			
			//ע������
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception{
		try {
			Connection conn= DriverManager.
			getConnection(url,user,pwd);
			/**
			 * ThreadLocal��set����
			 * �Ὣ��ǰ�߳���Ϊkey,����������ֵ
			 * ��Ϊvaluse�����ڲ���map�б���
			 */
			t1.set(conn);
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
			
	}
	
	public static void closeConnection(){
		try {
			//��õ�ǰ�̴߳����ֵ
			Connection conn =t1.get();
			if(conn!=null){
				conn.close();
				t1.remove();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	


}
