<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<style type="text/css">
 div{border:solid 1px; margin-left:auto;margin-right:auto;color:#EFB616;}
 .top{width:1000px;height:120px;
 text-align: center;font-family: "微软雅黑";font-size: 48px;color:#EFB616;background-image: url(imgs/bg.png)}
 .top > div{margin-top:20px;border: 0;}
 .detail{width:1000px;height:484px;border-top: 0;}
 .dleft{width:280px;height:480px;float: left;border-top: 0;border-bottom: 0;}
 .dright{width:716px;height:480px;float:left;border-top: 0;border-left: 0;border-bottom: 0;}
 #content{width: 716px;height: 480px;}
</style>
	<link rel="stylesheet" type="text/css" href="css/SimpleTree.css">
<script type="text/javascript" src="js/jquery-1.6.min.js"></script>
 <script type="text/javascript" src="js/SimpleTree.js"></script>
 
     <script type="text/javascript">
     $(document).ready(function(){
 $(".st_tree").SimpleTree({
		click:function(a){//用户点击超链接之后
			if(!$(a).attr("hasChild")){
		    var ref = $(a).attr("ref");
            $("#content").attr("src",ref);//修改iframe的显示路径
            }
		}
	    });
     });
    </script>
  </head>
  
  <body>
  <div class="top"><div>长秋山耙耙柑综合管理系统欢迎您</div></div>
  <div class="detail">
   <div class="dleft"> 
     <div class="st_tree">
        <ul>
	     <li><a href="#" ref="hyjm">欢迎界面</a></li>
	     <li><a href="#" ref="xtgl">设备管理</a></li>
         <ul show="false">
		   <li><a href="#" ref="MachineS?option=list">查看所有设备管理</a></li>
		    <li><a href="#" ref="machine/add.jsp">增加设备</a></li>
		   <li><a href="#" ref="StudentS?option=getCountStudentByCno&imgname=countStudentByClassC&chartType=category">查看班级人数柱状图</a></li>
		   <li><a href="#" ref="StudentS?option=getCountStudentByCno&imgname=countStudentByClassP&chartType=pie">查看班级人数饼状图</a></li>
	     </ul>
	    <li><a href="#" ref="view.html">实时监控查看</a></li>
		  <li><a href="#" ref="kcgl">传感查看</a></li>
		   <ul show="false">
		    <li><a href="#" ref="fhgl">实时数据</a></li>
            <li><a href="#" ref="ChartS">历史数据折线图</a></li>
            <li><a href="#" ref="rzck">历史数据分析表</a></li>
	       </ul>
		   <li><a href="#" ref="shgl">操作信息管理</a></li>
		   <ul show="false">
		 	<li><a href="#" ref="OperateS?option=list">查看所有设备管理</a></li>
		    <li><a href="#" ref="operate/add.jsp">增加设备</a></li><li><a href="#" ref="StudentS?option=getCountStudentByCno&imgname=countStudentByClassP&chartType=pie">查看班级人数饼状图</a></li>
	     </ul>
		   <li><a href="#" ref="fhgl">员工信息管理</a></li>
            <li><a href="#" ref="yhgl">用户管理</a></li>
            <li><a href="#" ref="rzck">日志查看</a></li>
	</ul>
</div>
   
   </div><div class="dright">
   <iframe id="content" scrolling="auto"></iframe>
   </div>
  </div>
</body>
</html>
