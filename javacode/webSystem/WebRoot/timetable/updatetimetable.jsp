<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	

</head>
<body>
			 <%
     ResultSet rs = (ResultSet)request.getAttribute("rs");
     if(rs.next()){
    %>
     <div class="content">
    <form action="./TimeTable" method="post">
      <table>
       <tr><td>课程&nbsp;ID&nbsp;&nbsp;：<input type="text" readonly name="courseID" value="<%=rs.getString(1)%>"/></td></tr>
       <tr><td>课程名称：<input type="text" name="courseName" value="<%=rs.getString(2)%>"/></td></tr>
       <tr><td>班级名称：<input type="text" name="className" value="<%=rs.getString(3)%>"/></td></tr>
       <tr><td>课程老师编码：<input type="text" name="wno" value="<%=rs.getString(4)%>"/></td></tr>
       <tr><td>教室编号：<input type="text" name="roomID" value="<%=rs.getString(5)%>"/></td></tr>
       <tr><td>上课时间：<input type="time" name="shoolTime" value="<%=rs.getString(6)%>"/></td></tr>
       <tr><td>下课时间：<input type="time" name="breaktime" value="<%=rs.getString(7)%>"/></td></tr>
       <tr><td><input type="hidden" name="option" value="update"/></td></tr>
       <tr><td><input type="submit" value="修改信息"/></td></tr>
      </table>
    </form>
    </div>
    <%}%>
</body>
</html>