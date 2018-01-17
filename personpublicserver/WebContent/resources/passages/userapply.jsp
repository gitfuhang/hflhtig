<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 	<link rel="Shortcut Icon" href="../images/favicon.ico" type="image/x-icon" /> 
	<title>用户申请-人事系统</title>
	
	<link rel="stylesheet" href="../js/layui/css/layui.css">
	<link rel="stylesheet" href="http://cdn.gbtags.com/twitter-bootstrap/3.2.0/css/bootstrap.css">
	<link rel="stylesheet" href="../css/login.css"/>
	<script src="../js/layui/layui.js"></script>
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="../js/login_regist.js"></script>
	
</head>
<body>

	<div  id="overlay" class="overlay"></div>
	<img src="https://img.58cdn.com.cn/ui6/my/images/reg-bg.png" alt="" width="100%" height="100%" class="bg-img" style=";">
	<div class="modal show" id="loginModal" >
		 <div class="" style="margin-top:10%"></div>
		 <div class="modal-dialog">
			  <div class="modal-content">
					<div class="modal-header">
					  <button type="button" class="close">×</button>
					  <h1 class="text-center text-primary">登录</h1>
					</div>
					<div class="modal-body">
						<form class="form col-md-12 center-block" id="loginForm" >
							<div class="form-group-lg"  id="accountDiv">
							  <label class="sr-only" for="inputAccount">账号</label>
							  <div class="input-group">
								<div class="input-group-addon"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></div>
								<input class="form-control input-lg" id="inputAccount" name="accountId" type="text" placeholder="账号" required autofocus>
							  </div>
							  <div class="hidden text-center" id="accountMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>用户名不存在</div>
							</div>
							<br>
							<br>
								<!--<div class="clearfix" style="margin-bottom: 20px;"></div> 清除浮动  -->
							<div class="form-group-lg" id="pwdDiv">
							  <label class="sr-only" for="inputPassword">密码</label>
							  <div class="input-group">
								<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
								<input  class="form-control input-lg" id="inputPassword" name="pwd" type="password" placeholder="密码"
								onkeyup="copyob1toob1()" required/>
								<input  class=" hidden form-control input-lg" id="inputPasswordtext" name="accountPwd" type="text" placeholder="密码"     onkeyup="copyob1toob2()" required/>
								<div class="input-group-addon"><span id="eye" class="glyphicon glyphicon-eye-close" style="cursor:pointer" title="用户密码" ></span></div>
							  </div>
							  <div class="hidden text-center" id="pwdMsg"><span class="glyphicon glyphicon-exclamation-sign"></span>用户名密码错误</div>
							</div>
							<br>
							<div class="checkbox">
							  <label class="checkboxline"> <input type="checkbox" id="automaticLogin" value="remember-me">自动登录</label>
							  <span class="loginspan" >没有帐号,<a>去申请</a></span>
							</div>
							
							<br>
							<div class="form-group">
							  <button class="btn btn-primary btn-lg col-md-12" id="btn_login" type="button" onclick="login()">登录</button>		 
							</div>
					  </form>
				</div>
				<div class="modal-footer">
					<button   onclick="test213()">dasd</button>
				</div>
			 </div>
		</div>
	</div>
	<script>
		
	</script>
</body>
</html>