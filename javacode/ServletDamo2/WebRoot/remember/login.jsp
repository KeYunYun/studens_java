<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ServletDamo2/RFservlet">
	用户名：<input type="text" name="name" value="${cookie.remember.value} "><br>
	<font color="red">${requestScope.error}</font>
	密码：<input type="password" name="password"><br>
	<input type="checkbox" name="remember" value="yes" ${cookie.remember==null?"":"checked==checked"}>记住用户名<br>
	<input type="submit" value="登录">
	</form>
</body>
</html>