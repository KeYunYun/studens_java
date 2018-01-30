<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="./css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	
</head>
<body>
		<div class="content">
      <form action="../LEDNotices" method="post">
      <table>
    
       <tr><td>请输入你要发送信息的教室：<input type="text" name="roomid" /></td></tr>
       <tr><td>请输入您要发送的消息：<input type="text" name="typehead" /></td></tr>
       <tr><td><input type="hidden" name="option" value="add"/></td></tr>
       <tr><td><input type="submit" value="确定发送"/></td></tr>
      </table>
    </form>
    </div>
  </body>
</body>
</html>