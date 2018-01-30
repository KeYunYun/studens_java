<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
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
  <div class="content">
    <form action="MachineS" method="post">
      <table>
       <tr><td>设备编号：<input type="text" name="mno"/></td></tr>
       <tr><td>设备名称：<input type="text" name="mname"/></td></tr>
       <tr><td>设备类型：<input type="text" name="mtype"/></td></tr>
       <tr><td>设备描述：<input type="text" name="mdesc"/></td></tr>
       <tr><td>所在园区：<input type="text" name="ano"/></td></tr>
       <tr><td>X坐标：<input type="text" name="x"/></td></tr>
       <tr><td>Y坐标：<input type="text" name="y"/></td></tr>
       <tr><td><input type="hidden" name="option" value="add"/></td></tr>
       <tr><td><input type="submit" value="增加设备"/></td></tr>
      </table>
    </form>
   </div>
  </body>
</html>
