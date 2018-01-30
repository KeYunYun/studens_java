<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"src="js/jscript.js" >
    </script>

	<link href="css/mystyle.css" rel="stylesheet" type="text/css" media="all" />	
  </head>
  
  <body class="background-body">
  	<div class="Htop">
  	</div>
  	<div class="container">
		<div class="Hleft">
			
		</div>
		<div class="Hright">
			<div class="Hright-top">
				<p >
				欢迎进入系统
				</p>
			</div>
			<div class="Hright-cent">
				<form action="./servlet/Login" method="post">
     			<div class="from-grop">
     			用户名：
     			<input type="text" placeholder="请输入用户名" name="user"><br>
				</div>
				<div class="from-grop">	
     			密&nbsp;&nbsp;码：
     			<input type="password" placeholder="请输入密码" name="pwd"><br>
     			</div>
     			<div class="from-grop">	
				验证码：<input type="text" name="code" placeholder="验证码" />
				</div>
				<div class="from-grop">	
				<img id="one"  src="./servlet/ImageIdent" >
					<a href="javaScript:void(0)" onclick="fun1();" >看不清,换一张</a> <br>
     			<div class="from-grop">	
     			<font color="red" >${requestScope.error}</font><br>
     			
     			<font color="red" >${requestScope.pwerror}</font><br>
     			</div>
				<input type="submit" value="登录"><br>
     			</div>
     			<div class="from-grop">	
     			</div>
     			</form>
				</div>
			<div class="Hright-low">
			</div>
			 
		</div>
  		
  	</div>
     
  </body>
</html>
