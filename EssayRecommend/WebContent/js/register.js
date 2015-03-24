$(document).ready(function() {
	$("#username").blur(function()// 绑定一个当元素失去焦点时发生blur 事件
	{
		var username = $.trim($("#username").val());
		$.post("checkUsername.action", {
			username : username
		}, function(date, state) {
			if (date.result == "ok") {
				$("#span1").html("*&nbsp;&nbsp;<font color=\"red\">用户名可以使用</font>");
				$("#submit").removeClass("disabled");

			} else {
				$("#span1").html("*&nbsp;&nbsp;<font color=\"red\">用户名不可以使用</font>");
				$("#submit").addClass("disabled");
			}
			return false;
		}, 'json');
	});
	$('#userAdd').on('click', function(e) {
		var password = $('#password').val();
		var repassword = $('#repassword').val();
		var email = $('#email').val();	
		var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(password == "") {
			$("#span3").html("*&nbsp;&nbsp;<font color=\"red\">用户密码不能为空</font>");
		}
		else if(password.length < 6) {
			$("#span3").html("*&nbsp;&nbsp;<font color=\"red\">用户密码至少大于6位</font>");
		}
		else if(password != repassword) {
			$("#span3").html("*&nbsp;&nbsp;<font color=\"red\"></font>");
			$("#span4").html("*&nbsp;&nbsp;<font color=\"red\">两次密码不相同</font>");	
		}
		else if(!reg.test(email)) {
			$("#span2").html("*&nbsp;&nbsp;<font color=\"red\">邮箱格式错误</font>");
		}
		else if($("[name='treaty']").prop("checked")== false){
			$("#span4").html("*&nbsp;&nbsp;<font color=\"red\"></font>");
			$("#span3").html("*&nbsp;&nbsp;<font color=\"red\"></font>");
			$("#span2").html("*&nbsp;&nbsp;<font color=\"red\"></font>");
			alert("请阅读注册协议，并同意！");
		}
		else {
			alert($("#regForm").submit());
		}
	});
});
