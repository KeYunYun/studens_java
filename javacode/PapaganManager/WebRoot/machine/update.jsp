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
   <style type="text/css">
     .content{
      margin-left:auto;margin-right:auto;width:300px;margin-top:80px;
      font-family: "微软雅黑";font-size: 14px;
     }
     .content table tr > td{color:#EFB616;height:40px;}
     .content table tr > td > input{border-radius:3px;height:32px;}
     </style>
  </head>
  
  <body>
    <%
     ResultSet rs = (ResultSet)request.getAttribute("rs");
     if(rs.next()){
    %>
     <div class="content">
    <form action="MachineS" method="post">
      <table>
       <tr><td>设备编号：<input type="text" name="mno" value="<%=rs.getString(1)%>"/></td></tr>
       <tr><td>设备名称：<input type="text" name="mname" value="<%=rs.getString(2)%>"/></td></tr>
       <tr><td>设备类型：<input type="text" name="mtype" value="<%=rs.getString(3)%>"/></td></tr>
       <tr><td>设备描述：<input type="text" name="mdesc" value="<%=rs.getString(4)%>"/></td></tr>
       <tr><td>所在园区：<input type="text" name="ano" value="<%=rs.getString(5)%>"/></td></tr>
       <tr><td>X坐标：<input type="text" name="x" value="<%=rs.getString(6)%>"/></td></tr>
       <tr><td>Y坐标：<input type="text" name="y" value="<%=rs.getString(7)%>"/></td></tr>
       <tr><td><input type="hidden" name="option" value="update"/></td></tr>
       <tr><td><input type="submit" value="修改设备"/></td></tr>
      </table>
    </form>
    </div>
    <%}%>
  </body>
</html>
