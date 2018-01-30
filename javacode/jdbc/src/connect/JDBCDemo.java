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
			 * ���������ļ��Ķ�ȡ
			 * Properties�����ڶ�ȡproperties
			 * �ļ���������map����ʽ��ȡ�����ļ��е�����
			 * 
			 * 
			 * properties�ļ��еĸ�ʽ�������� 
			 * user=XXXXX
			 * �Ⱥ���߾���key,�ұ���vluse
			 */
			Properties prop =
				new Properties();
			/**
			 * ʹ��propertiesȥ��ȡ�����ļ�
			 */
			FileInputStream fis=
				new FileInputStream("src/connect/config.properties");
			prop.load(fis);
			/**
			 * ������Ϻ󣬾͸��ݵȺŻ�ȡֵ
			 */
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String user=prop.getProperty("user");
			String pwd=prop.getProperty("pwd");
			System.out.println(driver+url+pwd+user);
			//����
			
			fis.close();
			//��һ�� ע������
			 Class.forName(driver);
			System.out.println("���ݿ������С�����������");
			/**�ڶ��� ͨ��DriverManager ������ݿ�����
			 * ����Java.sql*;
			 */
			Connection conn=
				DriverManager.
				getConnection
				(url, user, pwd);
			/**
			 * ������ ͨ��connection ����statement
			 * ����ִ��sql���
			 */
			Statement state =conn.createStatement();
			
			/**
			 * ִ��SQL���
			 */
			String SQL="select * from websites";
			System.out.println(SQL);
			ResultSet  rs= state.executeQuery(SQL);
			
			while(rs.next()){//rs.next()����
				int id =rs.getInt("id");     //����ֶ���Ϊid������
				String name =rs.getString("name");
				String str=rs.getString("url");
				int alex=rs.getInt("alexa");
				String country =rs.getString("country");
				System.out.println(id+name+str+alex+country);
				
			}
			//�ر�
			conn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			
		}
	}

}
