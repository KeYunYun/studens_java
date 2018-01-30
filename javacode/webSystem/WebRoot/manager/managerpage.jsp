<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"src="../js/jscript.js" >
    </script>


	<link href="../css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	

</head>
<body>

	<div class="top">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img  src="../image/log.png" width="200" height="50">
	</div>
	<div class="cent">
		<div class="cent-lef">
			
		
			
		
			
			<div class="list">
	<ul class="yiji">
		<li><a href="#">菜单栏</a></li>
		
		</li>
		<li><a href="#" class="inactive">&nbsp;&nbsp;&nbsp;&nbsp;课表信息管理</a>
			<ul style="display: none">
				<li><a href="../TimeTable?option=list" target="content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;显示课表</a><br>
				</li> 
				<li>		<a href="../timetable/addtimetable.jsp" target="content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加课表</a><br>
				</li>
			</ul>
		</li>
		<li><a href="#" class="inactive">&nbsp;&nbsp;&nbsp;&nbsp;操作记录</a>
			<ul style="display: none">
				<li><a href="../OperaterMessage?option=list" target="content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看操作记录</a><br>
				<li><a href="../operatemessage/findmessage.jsp" target="content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查询操作记录</a><br>
				</li> 
			</ul>
		</li>
		<li><a href="#" class="inactive">&nbsp;&nbsp;&nbsp;&nbsp;发送消息</a>
			<ul style="display: none">
				<li><a href="../LEDnotice/lednotice.jsp" target="content">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发送消息到LED屏</a><br>
			
				</li> 
			</ul>
		</li>
	</ul>
</div>
		</div>
		<div class="cent-right">
		
			 <iframe id="content" name="content" scrolling="auto">
			 	
			 </iframe>
		</div>
	</div>
	<div class="low">
		
	</div>
	
</body>
</html>