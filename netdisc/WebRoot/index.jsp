<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>上传页面</title>
	
	
  </head>
  				<h1 align="center"><font color="red">张磊的网盘</font></h1>
  <body>
  			<form  action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
  			
  			<input type="text" name='description'>
   			<input  type="file" name='f'><br/>
   			<input  type="submit" value="上传">
   			</form>
  </body>
</html>
