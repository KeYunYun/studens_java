package login;
import jdbc.ConnPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Uilty.IdentUilty;

public class IdentPwd {
	

	ArrayList<IdentUilty> list;
	String user;
	String password;
	public IdentPwd(){
			ConnPool conn=new ConnPool();
			String sql ="select * from tb_root";
			ResultSet rs = conn.select(sql);
			list=new ArrayList<IdentUilty>();
			try {
				while(rs.next()){
					//int id =rs.getInt("ID"); 
					IdentUilty ident=new IdentUilty();
					ident.setUser(rs.getString("user")); 
					ident.setPassword(rs.getString("password"));
					list.add(ident);
					
					System.out.println(ident.getUser());	
					System.out.println(ident.getPassword());
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ConnPool.closeConnection();
			}	
	
		
			ConnPool.closeConnection();

	}
	
	public static boolean checkIdentCode(HttpServletRequest request, HttpServletResponse response,String code1,String code2) throws IOException{
		
		if(code1!=null && code1.equalsIgnoreCase(code2)){
			//成功=> 登录成功 => 重定向到登录页面
			return true;
		}else{
			//失败=> 转发到登录页面并提示
			return false;
		}

	
	}
	public  boolean checkUsePwd(String use,String pwd){
		for(IdentUilty ident:list){
			 user=ident.getUser();
			 password=ident.getPassword();
			 if(use.equals(user)&&pwd.equals(password)){
					return true;
				}
		}
		return false;	
	}

	public void identmanage(){
		ConnPool conn=new ConnPool();
		String sql ="select * from tb_manage";
		list=new ArrayList<IdentUilty>();
		ResultSet rs = conn.select(sql);
		try {
			while(rs.next()){
				//int id =rs.getInt("ID");   
				IdentUilty ident=new IdentUilty();
				ident.setUser(rs.getString("name"));
				ident.setPassword(rs.getString("password"));
				list.add(ident);
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnPool.closeConnection();
		}

	
		

	}
	
	public boolean checkmanage(String use,String pwd){
		this.identmanage();
		for(IdentUilty ident:list){
			 user=ident.getUser();
			 password=ident.getPassword();
			 if(use.equals(user)&&pwd.equals(password)){
					return true;
				}
		}
		return false;	
	}
	
}
