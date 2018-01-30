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
    <form action="./ClassRoomManager" method="post">
      <table>
       <tr><td>教室&nbsp;ID&nbsp;&nbsp;：<input type="text" name="roomID" value="<%=rs.getString(1)%>"/></td></tr>
       <tr><td>教室名称：<input type="text" name="roomName" value="<%=rs.getString(2)%>"/></td></tr>

        <tr><td>使用状态：<select type="text" name="roomStatus" >
        													<option value="1">开门</option>
															<option value="0">关门</option>
															<option value="2">查询</option>
        </select></td></tr>
       <tr><td><input type="hidden" name="option" value="update"/></td></tr>
       <tr><td><input type="submit" value="修改信息"/></td></tr>
      </table>
    </form>
    </div>
    <%}%>
</body>
</html>