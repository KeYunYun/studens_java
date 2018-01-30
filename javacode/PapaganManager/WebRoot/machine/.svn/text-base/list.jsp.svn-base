<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
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
      margin-left:auto;margin-right:auto;width:520px;
     }
     .content > table{
      border-radius:10px;
     }
     .content > table  tr{
      color: white;
      font-family: "微软雅黑";
      font-size: 14;
      text-align: center;
     }
     .content > table  tr:nth-child(odd){
     /*nth-child表示该元素父亲的儿子 odd奇数*/
      background-color: #EFB616;
      color: rgb(124, 129, 139);

     }
      .content > table  tr:nth-child(even){
     /*nth-child表示该元素父亲的儿子 odd奇数*/
      background-color: #EEF190;
      color: rgb(101, 104, 101);
     }
      .content > table  tr:nth-child(1){
      background-color:rgb(172, 224, 142);
      color:white;
      height:48;
      font-size: 18;
      }
      .content > table  tr:nth-child(1) > td:nth-child(1){
       width:80px;
      }
         .content > table  tr:nth-child(1) > td:nth-child(2){
       width:80px;
      }
         .content > table  tr:nth-child(1) > td:nth-child(3){
       width:80px;
      }
         .content > table  tr:nth-child(1) > td:nth-child(4){
       width:120px;
      }
         .content > table  tr:nth-child(1) > td:nth-child(5){
       width:80px;
      }
       .content > table  tr:nth-child(1) > td:nth-child(6){
       width:60px;
      }
      
      .content > table tr > td > a{color: rgb(44, 39, 39);
      text-decoration: none;}
      .content > table tr > td > a:hover{color: rgb(81, 142, 209);}
   </style>
  </head>
  
  <body>
  <div class="content">
  <table border="1">
        <tr>
          <td>设备编号</td>
          <td>设备名称</td>
          <td>设备型号</td>
          <td>设备描述</td>
          <td>所在园区</td>
          <td>X坐标</td>
          <td>Y坐标</td>
          <td>操作</td>
      </tr>
    <%
      ResultSet rs = (ResultSet)request.getAttribute("rs"); 
      while(rs.next()){//如果结果集中还有下一条就 继续循环
       %>
       <!-- 下面这句表示在页面输出 -->
       <tr>
       <%String mno = rs.getString(1);%>
          <td><%= mno%></td>
          <td><%= rs.getString(2)%></td>
          <td><%= rs.getString(3)%></td>
          <td><%= rs.getString(4)%></td>
          <td><%= rs.getString(5)%></td>
          <td><%= rs.getString(6)%></td>
          <td><%= rs.getString(7)%></td>
          <td><a href="MachineS?option=find&mno=<%=mno%>">修改</a></td>
      </tr>
                      
       <%
      }
     %>
     <tr><td><a href="machine/add.jsp">增加设备</a></td></tr>
    </table>
    </div>
  </body>
</html>
