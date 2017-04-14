<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易云盘</title>
	<style type="text/css">
		#bottom{
		 background: gray;
       	 width: 100%;
      	 height: 25px;
             	 position: fixed;
       	 bottom: 0;
		}
	</style>
	<style> 
	body{text-align:center} 
	</style>
	<script type="text/javascript">
			function jump()
			{
				window.location.href="/netdisc/regist.jsp";
			}
	</script>
</head>
		
<body>	
			
		<h1 align="center" ><font color="red">欢迎使用易云盘</font></h1>
		<form  action="${pageContext.request.contextPath}/login" method="post">
		<table border="1" align="center" bgcolor="gray">	
		<tr>
			<td>用户名</td>
			<td><input type="text" name="username"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr align="center">
			<td colspan="2" >
			<input type="submit" value="登陆" />&nbsp;&nbsp;&nbsp;
			<input type="button" value="注册" onclick="jump()">
			</td>
		</tr>
		
		
		</table>
		</form >
		<font color="red" >${requestScope.error}</font>
		<div style="width:100%;text-align:center" id="bottom">copyritht@2017</div>
</body>
</html>