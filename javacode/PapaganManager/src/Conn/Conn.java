package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
  public static final String url = "jdbc:sqlserver://localhost:1433;databaseName=plantmanager";//final不准修改值
  public static final String drivername = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  public static final String user = "sa";
  public static final String password = "gxa";
  Connection conn;
  
  public Conn(){//构造方法 new的时候调用，只调用一次
	  try {
		  Class.forName(drivername);//1.打开程序,加载驱动 反射机制
		  conn = DriverManager.getConnection(url, user, password);//2.填写登录信息 ，填写用户名密码主机地址
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  
  }
  public ResultSet select(String sql){//ResultSet代表结果集
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);//3.打开查询编辑器，编写sql语句
			return pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;//如果代码正常执行 执行到上面一个return就退出，如果有异常，则返回null
}
  public int update(String sql){
	 
	  int rs = 0;
	try {
		PreparedStatement pstm = conn.prepareStatement(sql);//3.打开查询编辑器，编写sql语句
		  rs = pstm.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  return rs;
  }
}
