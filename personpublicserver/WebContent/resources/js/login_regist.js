
//用于密码输入框数据同步
function copyob1toob2(){
		document.all["inputPassword"].value=document.all["inputPasswordtext"].value
  };
  
function copyob1toob1(){
		document.all["inputPasswordtext"].value=document.all["inputPassword"].value
  };
//layer使用
layui.use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
		
	$("#ddd").click(function(){
		layer.alert('墨绿风格，点击确认看深蓝', {
		  skin: 'layui-layer-lan' //样式类名
		  ,closeBtn: 0
		});
	});
	
	//点击密码眼睛 用于展示是否明文密码
	$("#eye").click(function(){	
				$("#inputPassword").toggleClass("hidden form-control input-lg");
				$("#inputPassword").toggleClass("form-control input-lg");	
				$("#inputPasswordtext").toggleClass("form-control input-lg");
				$("#inputPasswordtext").toggleClass("hidden form-control input-lg");	
				$("#eye").toggleClass("glyphicon glyphicon-eye-close");
				$("#eye").toggleClass("glyphicon glyphicon-eye-open");
		});
	//第三方登录鼠标放上去图片变动
	$("#QQLogin").mouseout(function(){
		$("#QQLogin").attr('src',"../images/QQ1.png"); 
	});
	$("#QQLogin").mouseover(function(){
		$("#QQLogin").attr('src',"../images/QQ2.png"); 
	});
	$("#WXLogin").mouseout(function(){
		$("#WXLogin").attr('src',"../images/WX1.png"); 
	});
	$("#WXLogin").mouseover(function(){
		$("#WXLogin").attr('src',"../images/WX2.png"); 
	});
	$("#WBLogin").mouseout(function(){
		$("#WBLogin").attr('src',"../images/WB4.png"); 
	});
	$("#WBLogin").mouseover(function(){
		$("#WBLogin").attr('src',"../images/WB3.png"); 
	});
	//第三方登录点击后提示
	$("#QQLogin").click(function(){	
		layer.alert('暂未开放,敬请期待', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});	
	});
	$("#WXLogin").click(function(){	
		layer.alert('暂未开放,敬请期待', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});	
	});
	$("#WBLogin").click(function(){	
		layer.alert('暂未开放,敬请期待', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});	
	});
});
//验证登录输入的信息
function checkLogin(){

		if ($("#inputAccount").val() == "" || $("#inputAccount").val()==null) {
			layer.alert('请输入帐号', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});
			return false;
		}
		if ($.trim($("#inputAccount").val()).length < 6 ) {
			layer.alert('帐号长度至少6位！', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});
			return false;
		}
		if ($("#inputAccount").val().indexOf(" ") > -1) {
			layer.alert('帐号不能包含空格', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});
			return false;
		}
		if ($("#inputPassword") == "" || $("#inputPassword")==null) {
			layer.alert('请输入密码', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});
			return false;
		}
		if ($.trim($("#inputPassword").val()).length < 6 ) {
			layer.alert('密码长度至少6位！', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});
			return false;
		}
		if ($("#inputPassword").val().indexOf(" ") > -1 ){
			layer.alert('密码不能包含空格！', {
			skin: 'layui-layer-lan' //样式类名
			,closeBtn: 0
			});
			return false;
		}
		return true;		
};
//用户点击登录
function login(){
	if(checkLogin()){
		var accountId= $("#inputAccount").val();
		var accountPwd = $("#inputPassword").val();
		
	if($("#automaticLogin").is(':checked')){
		var automaticLogin = 'yes';
	}else{
		var automaticLogin = 'no';
	};

		        $.ajax({
                    url: "../../user/login.do",
					 data: {
						accountId : accountId, //账户
						accountPwd : accountPwd,//密码 
						automaticLogin : automaticLogin,//是否自动登录
					},
                    type: "post",
                    dataType: "json",
                    cache: false,
                    success: function(data) {
					console.log(data);
                        if(data.code==0) {
							layer.alert('登录成功', {
							skin: 'layui-layer-lan' //样式类名
							,closeBtn: 0
							});	
						window.location.href='userapply.jsp';
                        }else if(data.code==1) {
							layer.alert(data.msg, {
							skin: 'layui-layer-lan' //样式类名
							,closeBtn: 0
							}); 				
						}
							
                    }
                });	
	}
};