$('#newPopUp').modal('toggle');
$(document).ready(function() {
	$('#newPopUp').on('shown.bs.modal', function (e) {
		var modal = $(this);
		modal.find('#Username').val('ss');
		modal.find('#btnReset').on('click', function(e) {
			modal.find('#username').val('');
			modal.find('#password').val('');
			modal.find('#repassword').val('');
			modal.find('#email').val('');
		});
		modal.find('#btnCreate').on('click', function(e) {
			var username = modal.find('#username').val();
			var password = modal.find('#password').val();
			var repassword = modal.find('#repassword').val();
			var email = modal.find('#email').val();			
			if(username == "") {
				modal.find('#username').tooltip({
					title: "用户名不能为空！"
				});
			}
			else if(password == "") {
				modal.find('#password').tooltip({
					title: "密码不能为空！"
				});			
			}
			else if(password != repassword) {
				alert("两次密码不相同！");		
			}
			else {
				modal.modal('hide');
				modal.find('#myform').submit();
			}
		});
	});
});


