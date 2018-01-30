<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.sql.ResultSet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showInof.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="./css/homestyle.css" rel="stylesheet" type="text/css" media="all" />	
 
  </head>
  
  <body>
     	<div class="content">
     		   
<span id="spanFirstt">第一页</span> <span id="spanPret">上一页</span> <span id="spanNextt">下一页</span> <span id="spanLastt">最后一页</span> 第<span id="spanPageNumt"></span>页/共<span id="spanTotalPaget"></span>页     
     		
			<table border="1">
			<tbody id="tablelsw">    
				<tr>
					<td>ID</td>
					<td>教室</td>
					<td>老师名字</td>
					<td>RFID号</td>
					<td>课程名字</td>
					<td>开门时间</td>
				</tr>
	<%
	
      ResultSet rs = (ResultSet)request.getAttribute("rs"); 
      while(rs.next()){//如果结果集中还有下一条就 继续循环
      %>
    		 
				<tr>
					<%int id = rs.getInt(1);%>
					<td><%= id%></td>
					<td><%= rs.getString(2)%></td>
					<td><%= rs.getString(3)%></td>
					<td><%= rs.getString(4)%></td>
					<td><%= rs.getString(5)%></td>
					<td><%= rs.getString(6)%></td>

				</tr>
				    
	<%} %>	
	</tbody> 
			</table>
   	<span id="spanFirst">第一页</span>   
<span id="spanPre">上一页</span>   
<span id="spanNext">下一页</span>   
<span id="spanLast">最后一页</span>   
第<span id="spanPageNum"></span>页/共<span id="spanTotalPage"></span>页  
     	</div>
     	<form action="./OperaterMessage" method="post">
      <table>
       <tr><td><input type="hidden" name="option" value="drop"/></td></tr>
       <tr><td><input type="submit" value="清空表"/></td></tr>
      </table>
    </form>
     		        	
  </body>
</html>
<script>    
// JavaScript Document By lishewen     
var theTable = document.getElementById("tablelsw");     
var totalPage = document.getElementById("spanTotalPage");     
var pageNum = document.getElementById("spanPageNum");     
    
var spanPre = document.getElementById("spanPre");     
var spanNext = document.getElementById("spanNext");     
var spanFirst = document.getElementById("spanFirst");     
var spanLast = document.getElementById("spanLast");     
    
var totalPaget = document.getElementById("spanTotalPaget");     
var pageNumt = document.getElementById("spanPageNumt");     
    
var spanPret = document.getElementById("spanPret");     
var spanNextt = document.getElementById("spanNextt");     
var spanFirstt = document.getElementById("spanFirstt");     
var spanLastt = document.getElementById("spanLastt");     
    
var numberRowsInTable = theTable.rows.length;     
var pageSize = 10;     
var page = 1;     
    
//下一页     
function next(){     
    
    hideTable();     
         
    currentRow = pageSize * page;     
    maxRow = currentRow + pageSize;     
    if ( maxRow > numberRowsInTable ) maxRow = numberRowsInTable;     
    for ( var i = currentRow; i< maxRow; i++ ){     
        theTable.rows[i].style.display = '';     
    }     
    page++;     
         
    if ( maxRow == numberRowsInTable ) { nextText(); lastText(); }     
    showPage();     
    preLink();     
    firstLink();     
}     
    
//上一页     
function pre(){     
    
    hideTable();     
         
    page--;     
         
    currentRow = pageSize * page;     
    maxRow = currentRow - pageSize;     
    if ( currentRow > numberRowsInTable ) currentRow = numberRowsInTable;     
    for ( var i = maxRow; i< currentRow; i++ ){     
        theTable.rows[i].style.display = '';     
    }     
         
         
    if ( maxRow == 0 ){ preText(); firstText(); }     
    showPage();     
    nextLink();     
    lastLink();     
}     
    
//第一页     
function first(){     
    hideTable();     
    page = 1;     
    for ( var i = 0; i<pageSize; i++ ){     
        theTable.rows[i].style.display = '';     
    }     
    showPage();     
         
    preText();     
    nextLink();     
    lastLink();     
}     
    
//最后一页     
function last(){     
    hideTable();     
    page = pageCount();     
    currentRow = pageSize * (page - 1);     
    for ( var i = currentRow; i<numberRowsInTable; i++ ){     
        theTable.rows[i].style.display = '';     
    }     
    showPage();     
         
    preLink();     
    nextText();     
    firstLink();     
}     
    
function hideTable(){     
    for ( var i = 0; i<numberRowsInTable; i++ ){     
        theTable.rows[i].style.display = 'none';     
    }     
}     
    
function showPage(){     
    pageNum.innerHTML = page;     
    pageNumt.innerHTML = page;     
}     
    
//总共页数     
function pageCount(){     
    var count = 0;     
    if ( numberRowsInTable%pageSize != 0 ) count = 1;      
    return parseInt(numberRowsInTable/pageSize) + count;     
}     
    
//显示链接     
function preLink(){ spanPre.innerHTML = "<a href='javascript:pre();'>上一页</a>"; spanPret.innerHTML = "<a href='javascript:pre();'>上一页</a>";}     
function preText(){ spanPre.innerHTML = "上一页"; spanPret.innerHTML = "上一页"; }     
    
function nextLink(){ spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>"; spanNextt.innerHTML = "<a href='javascript:next();'>下一页</a>";}     
function nextText(){ spanNext.innerHTML = "下一页"; spanNextt.innerHTML = "下一页";}     
    
function firstLink(){ spanFirst.innerHTML = "<a href='javascript:first();'>第一页</a>"; spanFirstt.innerHTML = "<a href='javascript:first();'>第一页</a>";}     
function firstText(){ spanFirst.innerHTML = "第一页"; spanFirstt.innerHTML = "第一页";}     
    
function lastLink(){ spanLast.innerHTML = "<a href='javascript:last();'>最后一页</a>"; spanLastt.innerHTML = "<a href='javascript:last();'>最后一页</a>";}     
function lastText(){ spanLast.innerHTML = "最后一页"; spanLastt.innerHTML = "最后一页";}     
    
//隐藏表格     
function hide(){     
    for ( var i = pageSize; i<numberRowsInTable; i++ ){     
        theTable.rows[i].style.display = 'none';     
    }     
         
    totalPage.innerHTML = pageCount();     
    pageNum.innerHTML = '1';     
         
    totalPaget.innerHTML = pageCount();     
    pageNumt.innerHTML = '1';     
         
    nextLink();     
    lastLink();     
}     
    
hide();     
</script>    