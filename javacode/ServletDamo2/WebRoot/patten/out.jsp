<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="/ServletDamo2/Hservlet?name=dell">Dell</a><br>
	<a href="/ServletDamo2/Hservlet?name=hp">Hp</a><br>
	<a href="/ServletDamo2/Hservlet?name=hasee">Hasee</a><br>
	<a href="/ServletDamo2/Hservlet?name=apple">apple</a><br>
	<a href="/ServletDamo2/Hservlet?name=accer">accer</a><br>
	浏览器历史：${cookie.history.value}
		
</body>
</html>