var loginInfoData;
layui
		.use(
				[ 'layer', 'form', 'element' ],
				function() {
					var layer = layui.layer, form = layui.form, element = layui.element, $ = layui.jquery;
					var sentUrl = "";
					loginInfoData = asyncGet("/currentLoginInfo", null);
					function skip(url){
						if(loginInfoData.responseCode != '200' && url != "pages/home/home.html"){
							sentUrl = url;
							layer.msg("请先登陆");
							loginWin();
						}else{
							$("#contentBody").attr("src", url);
							$("#contentBody").css("width", document.body.clientWidth);
							$("#contentBody").css("height",window.screen.availHeight);
						}
					}
					if(loginInfoData.responseCode != '200'){
						$("#userChildHandle").hide();
					}else{
						//$("#userChildHandle").;
						var userData = loginInfoData.result;
						document.getElementById("userName").innerText = userData.loginName;
					}
					skip("pages/home/home.html");
					$(".nvaBtn").each(function(){
						var url = $(this).attr("data-url");
						$(this).on('click', function(){
							skip(url);
						});
					});
					$("#loginUser").on('click', function(){
						if(loginInfoData.responseCode != '200'){
							loginWin();
						}else{
							var userData = loginInfoData.result;
							document.getElementById("userName").innerText = userData.loginName;
						}
					});
					function loginWin(){
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
									  skip(sentUrl);
									  sentUrl = "";
								  }
							  }
							});
					}
				});
