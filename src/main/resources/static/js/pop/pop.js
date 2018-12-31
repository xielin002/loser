var loginInfoData;
layui.use('layer', function(){ 
  var $ = layui.jquery, layer = layui.layer; 
  var sentUrl = "";
  loginInfoData = asyncGet("/currentLoginInfo", null);
  
  function forword(url){
	  if (loginInfoData.exceptionCode != '0') {
		  sentUrl = url;
		  layer.msg('登陆失败，请重新登陆');
		  loginAgain();
	  } else {
		  layer.msg('登陆成功！');
	  }
	  
  }
  if(loginInfoData.exceptionCode != '0'){
	  $("#userChildHandle").hide();
  }else{
	  //$("#userChildHandle").;
	  var userData = loginInfoData.result;
	  document.getElementById("userName").innerText = userData.loginName;
  }
  forword("pages/home/home.html");
  
  function loginAgain(){
		var index = layer.open({
			  type: 2,
			  title: '登陆',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['499px', '275px'],
			  anim:1,
			  resize:false,
			  content: 'pages/login/login.html',
			  end:function(){
				  //data = loginInfoData;
				  if(sentUrl){
					  forword(sentUrl);
					  sentUrl = "";
				  }
			  }
			});
  }
  
  $("#loginUser").on('click', function(){
		if(loginInfoData.exceptionCode != '0'){
			layer.msg('Hello World login');
		} else {
			var userData = loginInfoData.result;
			document.getElementById("userName").innerText = userData.loginName;
		}
  });

  
});