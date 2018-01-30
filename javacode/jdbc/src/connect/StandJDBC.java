package connect;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class StandJDBC {

	/**
	 * @param args
	 * 使用配置文件来连接数据库
	 */
	private static String url;
	private static String user;
	private static String pwd;
	//获得数据库的链接
	private static ThreadLocal<Connection>
	t1=new ThreadLocal<Connection>();
	static{
		try {
			//读取配置文件的标准
			Properties prop =
				new Properties();
			InputStream is=
				StandJDBC.class.getClassLoader()
				.getResourceAsStream("connect/config.properties");
			prop.load(is);
			//取值
			String driver=prop.getProperty("driver");
			 url=prop.getProperty("url");
			user=prop.getProperty("user");
			 pwd=prop.getProperty("pwd");
			System.out.println(driver+url+pwd+user);
			is.close();
			
			//注册驱动
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
			 * ThreadLocal的set方法
			 * 会将当前线程作为key,并将给定的值
			 * 作为valuse存入内部的map中保存
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
			//获得当前线程存入的值
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
