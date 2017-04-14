<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	body{text-align:center}
</style>
 <script type="text/javascript" src="${pageContext.request.contextPath}/my.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/my2.js"></script>
<script type="text/javascript">
window.onload = function() {
	//得到id=t的文本框
	var txt = document.getElementById("t");
	//给文本框注册一个失去焦点事件
	txt.onblur = function() {
		
		//获取文本框中的信息
		var value=txt.value;
		//第一步:得到XMLHttpRequest对象.
		var xmlhttp=getXmlHttpRequest();
		
		//2.设置回调函数
		
		xmlhttp.onreadystatechange = function() {

			//5.处理响应数据  当信息全部返回，并且是成功
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				
				var msg=xmlhttp.responseText;
				
				document.getElementById("f1").innerHTML=msg;
				
			}
		};

		//post请求方式，参数设置
		xmlhttp.open("POST", "${pageContext.request.contextPath}/Exit");
		xmlhttp.setRequestHeader("content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("username="+value);
	}
};
		
		
</script>
</head>
<body>
		<h1><font color="red">新用户注册</font></h1>
		<form  name="form1" action="${pageContext.request.contextPath}/regist" method="post" onsubmit="return run3()" >
			<table >
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"  id="t" ></td><td><span id="f1"></span><td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password" onblur="run4()" ></td><td><span id="f2"></span></div><td>
			</tr>
			<tr>
				<td>重复密码：</td>
				<td ><input type="password" name="repeatpassword" onblur="run()" onfocus="run2()" ></td><td><span id="f3"></span><td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input type="radio" name="sex" checked="checked" value="男">男<input type="radio" name="sex" value="女">女</td>
				
			</tr>
			<tr>
				<td>爱好：</td>
				<td><input type="text" name="preference"></td>
			</tr>
			<tr>
				
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
			</table>
		</form>
</body>
</html>