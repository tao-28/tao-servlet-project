<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome view</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="register_login">
		<ul>
			<div class="form_top_right">
				<li><span><a href="#">注册</a></span> <span>登录</span></li>
			</div>
			<form action="/user/login" method="post">
				<li><input name="userAccontNo" placeholder="账号(手机号)" /></li>
				<li><input name="userPwd" type="password" placeholder="密码" /></li>
				<span class="promptMessage" style="font-size: 0.5px; color: red">${promptEntity.msg }</span>
				<li>
					<input type="submit" value="提交"> 
					<input type="reset" value="取消">
				</li>
			</form>
		</ul>
	</div>
</body>
</html>