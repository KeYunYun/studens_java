<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	

</head>
<body>
		<div class="content">
      <form action="../TimeTable" method="post">
      <table>
    
       <tr><td>课程&nbsp;ID&nbsp;&nbsp;：<input type="text" name="courseID" /></td></tr>
       <tr><td>课程名称：<input type="text" name="courseName" /></td></tr>
       <tr><td>班级名称：<input type="text" name="className"/></td></tr>
       <tr><td>课程老师编码：<input type="text" name="wno" /></td></tr>
       <tr><td>教室编号：<input type="text" name="roomID" /></td></tr>
       <tr><td>上课时间：<input type="time" name="shoolTime" /></td></tr>
       <tr><td>下课时间：<input type="time" name="breaktime" /></td></tr>
  
       <tr><td><input type="hidden" name="option" value="add"/></td></tr>
       <tr><td><input type="submit" value="增添记录"/></td></tr>
      </table>
    </form>
    </div>
</body>
</html>