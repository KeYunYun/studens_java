<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addinfo.jsp' starting page</title>
    
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
      <div class="content">
      <form action="./ShowManagerInfo" method="post">
      <table>
    
       <tr><td>姓名：<input type="text" name="name" /></td></tr>
       <tr><td>密码：<input type="text" name="pwd" /></td></tr>
       <tr><td>班级名称：<input type="text" name="classname"/></td></tr>
       <tr><td>学号/职工号：<input type="text" name="wno" /></td></tr>
       <tr><td>电话号码：<input type="text" name="pname" /></td></tr>
       <tr><td>RFID号：<input type="text" name="RFID" /></td></tr>
        <tr><td>状态：<input type="text" name="tatic" /></td></tr>
       <tr><td><input type="hidden" name="option" value="add"/></td></tr>
       <tr><td><input type="submit" value="增添记录"/></td></tr>
      </table>
    </form>
    </div>
  </body>
</html>
