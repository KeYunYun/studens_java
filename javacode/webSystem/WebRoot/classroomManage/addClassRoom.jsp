<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加教室的信息</title>
<link href="./css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	

</head>
<body>
	<div class="content">
      <form action="../ClassRoomManager" method="post">
      <table>
    
       <tr><td>教室&nbsp;ID&nbsp;&nbsp;：<input type="text" name="roomID" /></td></tr>
       <tr><td>教室名称：<input type="text" name="roomName" /></td></tr>
       <tr><td>使用状态：<input type="text" name="roomStatus"/></td></tr>
       <tr><td><input type="hidden" name="option" value="add"/></td></tr>
       <tr><td><input type="submit" value="增添记录"/></td></tr>
      </table>
    </form>
    </div>
</body>
</html>