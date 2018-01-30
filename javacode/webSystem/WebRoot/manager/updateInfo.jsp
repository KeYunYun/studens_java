<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="./css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	
  </head>
 
 <body>
    <%
     ResultSet rs = (ResultSet)request.getAttribute("rs");
     if(rs.next()){
    %>
     <div class="content">
    <form action="./ShowManagerInfo" method="post">
      <table>
       <tr><td>ID：<input type="text" readonly name="ID" value="<%=rs.getInt(1)%>"/></td></tr>
       <tr><td>姓名：<input type="text" name="name" value="<%=rs.getString(2)%>"/></td></tr>
       <tr><td>密码：<input type="text" name="pwd" value="<%=rs.getString(3)%>"/></td></tr>
       <tr><td>班级名称：<input type="text" name="classname" value="<%=rs.getString(4)%>"/></td></tr>
       <tr><td>学号/职工号：<input type="text" name="wno" value="<%=rs.getString(5)%>"/></td></tr>
       <tr><td>电话号码：<input type="text" name="pname" value="<%=rs.getString(6)%>"/></td></tr>
       <tr><td>RFID号：<input type="text" name="RFID" value="<%=rs.getString(7)%>"/></td></tr>
       <tr><td>状态：<input type="text" name="tatic" value="<%=rs.getInt(8)%>"/></td></tr>
       <tr><td><input type="hidden" name="option" value="update"/></td></tr>
       <tr><td><input type="submit" value="修改信息"/></td></tr>
      </table>
    </form>
    </div>
    <%}%>
  </body>
</html>
