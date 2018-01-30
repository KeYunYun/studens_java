package connect;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnPool {

	/**
	 * 连接池链接数据库
	 * @param args
	 */
	//数据库连接池
	private static BasicDataSource ds;
	//为不同线程管理链接
	private static ThreadLocal<Connection> t1;
	//不需要实例化，所以在静态方法里创建
	static{
		try {
			//加载配置文件
			Properties prop=
				new Properties();
			InputStream is =
				ConnPool.class.getClassLoader()
				.getResourceAsStream("connect/config.properties");
			prop.load(is);
			is.close();
			//初始化连接池
			ds=new BasicDataSource();
			//设置驱动
			ds.setDriverClassName(prop.getProperty("driver"));
			//设置url
			ds.setUrl(prop.getProperty("url"));
			//设置用户名
			ds.setUsername(prop.getProperty("user"));
			//设置密码
			ds.setPassword(prop.getProperty("pwd"));
			
			//设置允许最大容量
			ds.setMaxActive(Integer.parseInt(prop.getProperty("maxactive")));
			//初始设置容量
			ds.setInitialSize(Integer.parseInt(prop.getProperty("initsize")));
			//设置最大等待时间
			ds.setMaxWait(Integer.parseInt(prop.getProperty("maxwait")));
			//设置最小线程数
			ds.setMinIdle(Integer.parseInt(prop.getProperty("minidle")));
			//设置最大空闲数
			ds.setMaxIdle(Integer.parseInt(prop.getProperty("maxidle")));
			//初始本地线程
			t1=new ThreadLocal<Connection>();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 链接数据库
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		/**
		 * 通过连接池获取一个空闲链接
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
				 * 将链接还给连接池
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
