layui.use('layer', function(){
	  var layer = layui.layer, $ = layui.jquery;
	  $("#loginBtn").on('click', function(){
			var loginPsd = $("#loginPsd").val();
			var loginCode = $("#loginCode").val();
			if(!loginCode){
				layer.tips("账号不能为空", '#loginCode', {
					  tips: [1, '#dc6a94'],
					  time: 4000
				});
				return;
			}
			if(!loginPsd){
				layer.tips("密码不能为空", '#loginPsd', {
					  tips: [1, '#dc6a94'],
					  time: 4000
				});
				return;
			}
			var loginData = {
				"loginPsd":loginPsd,
				"loginCode":loginCode
			};
			var data = asyncGet("/login", loginData);
			if(data){
				var code = data.responseCode;
				var msg = data.responseMsg;
				if(code != "0"){
					layer.tips(msg, '#loginCode', {
						  tips: [1, '#dc6a94'],
						  time: 4000
					});
				}else{
					//登陆成功
					layer.msg('登陆成功');
					var userData = data.result;
					var index = parent.layer.getFrameIndex(window.name);
					parent.document.getElementById("userName").innerText = userData.loginName;
					parent.document.getElementById("userChildHandle").display = '';
					parent.loginInfoData = data;
					parent.layer.close(index);
				}
			}
		});
});
$("#loginCode").bind("keydown",function(e){
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	if (code == 13) {
		//回车执行查询
		$("#loginBtn").click();
	}
});
$("#loginPsd").bind("keydown",function(e){
	// 兼容FF和IE和Opera
	var theEvent = e || window.event;
	var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
	if (code == 13) {
		//回车执行查询
		$("#loginBtn").click();
	}
});
