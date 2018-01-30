package connect;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/**
			 * 测试配置文件的读取
			 * Properties类用于读取properties
			 * 文件，该类以map的形式读取配置文件中的内容
			 * 
			 * 
			 * properties文件中的格式内容类似 
			 * user=XXXXX
			 * 等号左边就是key,右边是vluse
			 */
			Properties prop =
				new Properties();
			/**
			 * 使用properties去读取配置文件
			 */
			FileInputStream fis=
				new FileInputStream("src/connect/config.properties");
			prop.load(fis);
			/**
			 * 加载完毕后，就根据等号获取值
			 */
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String user=prop.getProperty("user");
			String pwd=prop.getProperty("pwd");
			System.out.println(driver+url+pwd+user);
			//关流
			
			fis.close();
			//第一步 注册驱动
			 Class.forName(driver);
			System.out.println("数据库连接中。。。。。。");
			/**第二步 通过DriverManager 获得数据库连接
			 * 导入Java.sql*;
			 */
			Connection conn=
				DriverManager.
				getConnection
				(url, user, pwd);
			/**
			 * 第三步 通过connection 创建statement
			 * 用来执行sql语句
			 */
			Statement state =conn.createStatement();
			
			/**
			 * 执行SQL语句
			 */
			String SQL="select * from websites";
			System.out.println(SQL);
			ResultSet  rs= state.executeQuery(SQL);
			
			while(rs.next()){//rs.next()便利
				int id =rs.getInt("id");     //获得字段名为id的数据
				String name =rs.getString("name");
				String str=rs.getString("url");
				int alex=rs.getInt("alexa");
				String country =rs.getString("country");
				System.out.println(id+name+str+alex+country);
				
			}
			//关闭
			conn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			
		}
	}

}
