<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0" />
<title>论文推荐系统后台管理</title>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/backManage.css" rel="stylesheet" />
<script src="../bootstrap/js/jquery-1.11.2.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#submit').click(function() {
		var username = $('#username').val();
		var password = $('#password').val();
		if(username == "") {
			$('#username').tooltip({
				title: "用户名不能为空！"
			});
			return false;
		}
		else if(password == "") {
			$('#password').tooltip({
				title: "密码不能为空！"
			});
			return false;
		}
		else return true;
	});
});
</script>
<style type="text/css">
body{
	background-color:#60F;
}
.container{
	width: 1080px;
	margin-left:auto;
	margin-right:auto;
	display:block;
}

.container header,footer{
	display:block;
	text-align:center;
	color:#FFF;
	background-color:#60F;
}

     
.loginBox{
	width:420px;
	height:260px;
	padding:0 20px;
	border:1px solid #fff; 
	color:#000; 
	margin-left:auto;
	margin-right:auto;
	margin-top:40px; 
	border-radius:8px;
	background: white;
	box-shadow:0 0 15px #222; 
}
.content{
	width:100%;
	height: 360px;
}
</style>
</head>
<body>
	<div class="container">
		<header>
        	<h1>论文推荐系统后台登录</h1>
        </header>
		<div class="content">
		<section class="loginBox">
        	<label><h3>管理员登录</h3></label>
			<form class="form-horizontal" role="form" action="backLogin" method="post">
				<div class="form-group">
					<label for="username" class="col-sm-3 control-label">账号</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="username"
							name="username" placeholder="username">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-3 control-label">密码</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="password">
					</div>
				</div>
				<div>
					<input type="submit" class="btn btn-primary col-sm-12" id="submit" value="登录">
                </div>
			</form>
		</section>
		<!-- /loginBox -->
		</div>
		<footer>
  			<label><h3>CopyRight@lzjtu 2014-2015
          	<address>
      		甘肃省兰州市安宁区安宁西路88号兰州交通大学
    		</address></h3>
            </label>
  		</footer>
	</div>
	<!-- /container -->
</body>
</html>