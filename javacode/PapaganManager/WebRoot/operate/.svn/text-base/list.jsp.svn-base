
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
      margin-left:auto;margin-right:auto;width:600px;
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
       width:80px;
      }
   </style>
  </head>
  
  <body>
   <div class="content">
  <table border="1">
        <tr>
          <td>操作编号</td>
          <td>操作类型</td>
          <td>操作日期</td>
          <td>操作园区</td>
          <td>操作描述</td>
          <td>操作员工</td>
      </tr>
    <%
      ResultSet rs = (ResultSet)request.getAttribute("rs"); 
      while(rs.next()){//如果结果集中还有下一条就 继续循环
       %>
       <!-- 下面这句表示在页面输出 -->
       <tr>
          <td><%= rs.getInt(1)%></td>
          <td><%= rs.getString(2)%></td>
          <td><%= rs.getDate(3)%></td>
          <td><%= rs.getString(4)%></td>
          <td><%= rs.getString(5)%></td>
          <td><%= rs.getString(6)%></td>
      </tr>
                      
       <%
      }
     %>
    </table>
    </div>
  </body>
</html>
