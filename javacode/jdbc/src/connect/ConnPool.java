package connect;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnPool {

	/**
	 * ���ӳ��������ݿ�
	 * @param args
	 */
	//���ݿ����ӳ�
	private static BasicDataSource ds;
	//Ϊ��ͬ�̹߳�������
	private static ThreadLocal<Connection> t1;
	//����Ҫʵ�����������ھ�̬�����ﴴ��
	static{
		try {
			//���������ļ�
			Properties prop=
				new Properties();
			InputStream is =
				ConnPool.class.getClassLoader()
				.getResourceAsStream("connect/config.properties");
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
	

}
