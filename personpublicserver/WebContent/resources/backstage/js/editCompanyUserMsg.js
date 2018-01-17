window.onload=function(){
	
	
layui.use(['layer', 'form','jquery'], function(){
	  var layer = layui.layer
	  var form = layui.form;
	  var $=layui.jquery;
	  var myurl='http://www.personalPub.com';
	  
   //网址参数提取
	function GetRequest(webside){
				//接收一个url 如果没有参数则获取本地网址
				if(webside==undefined){
					var url = location.search;//获取本地url中"?"符后的字串
				}else{
					var url=webside
				}
			   		var theRequest = new Object(); 
			   if (url.indexOf("?") != -1) {  
			   	  var num=url.indexOf("?")
			      var str = url.substr(num+1);
			      strs = str.split("&");   //分割为数组
			      for(var i = 0; i < strs.length; i ++){  //循环创建对象
			         theRequest[strs[i].split("=")[0]]=strs[i].split("=")[1];  
			      }  
			   } 
   				return theRequest;   
			}
	var webObj=GetRequest()
	var userId=webObj.userId;
		//根据ID查询公司信息
		$.ajax({
			type:"get",
			url:myurl+"/company/getCompanyUserMsgById.do",
			data:{
				userId:userId
			},
			async:true,
			dataType:'json',
			success:function(data){
				if(data.code==0){
					console.log(data.Result[0])
					renderFrom(data.Result[0])
				}else{
					layer.msg(data.msg);
				}
				
			},
			err:function(err){
				layer.alert('网络错误 未获取到公司信息', {
				    skin: 'layui-layer-lan'
				    ,closeBtn: 0
				    ,anim: 4 //动画类型
				  });
			}
		});
		//数据填充
		function renderFrom(data){
			console.log('获取数据',data)
			$("#companyCode").val(data.companyCode)
			$("#companyName").val(data.companyName)
			$("#companyId").val(data.companyId)
			$("#WX_MchanNum").val(data.WX_MchanNum)
			$("#WX_NumberPwd").val(data.WX_NumberPwd)
			$("#WX_APPId").val(data.WX_APPId)
			$("#WX_DiplomaName").val(data.WX_DiplomaName)
			$("#WX_DiplomaPwd").val(data.WX_DiplomaPwd)
			$("#WX_TokenNum").val(data.WX_TokenNum)
			$("#ALI_MchanNum").val(data.ALI_MchanNum)
			$("#ALI_NumberPwd").val(data.ALI_NumberPwd)
			$("#ALI_SellerEml").val(data.ALI_SellerEml)
			$("#ALI_PrivatePwd").val(data.ALI_PrivatePwd)
			$("#ALI_PublicPwd").val(data.ALI_PublicPwd)
			$("#YL_DiplomaName").val(data.YL_DiplomaName)
			$("#YL_MchanNum").val(data.YL_MchanNum)
			$("#YL_DiplomaPwd").val(data.YL_DiplomaPwd)
			$("#companyAutCode").val(data.companyAutCode)
			$("#companyAutSECRET").val(data.companyAutSECRET)
			$("#companyEncryCode").val(data.companyEncryCode)
			$("#marketDomName").val(data.marketDomName)
		}
		//数据获取
		function collectFrom(){
			var data={};
			data.companyCode=$("#companyCode").val()
			data.companyName=$("#companyName").val()
			data.companyId=$("#companyId").val()
			data.WX_MchanNum=$("#WX_MchanNum").val()
			data.WX_NumberPwd=$("#WX_NumberPwd").val()
			data.WX_APPId=$("#WX_APPId").val()
			data.WX_DiplomaName=$("#WX_DiplomaName").val()
			data.WX_DiplomaPwd=$("#WX_DiplomaPwd").val()	
			data.WX_TokenNum=$("#WX_TokenNum").val()
			data.ALI_MchanNum=$("#ALI_MchanNum").val()
			data.ALI_NumberPwd=$("#ALI_NumberPwd").val()
			data.ALI_SellerEml=$("#ALI_SellerEml").val()
			data.ALI_PrivatePwd=$("#ALI_PrivatePwd").val()
			data.ALI_PublicPwd=$("#ALI_PublicPwd").val()
			data.YL_DiplomaName=$("#YL_DiplomaName").val()
			data.YL_MchanNum=$("#YL_MchanNum").val()
			data.YL_DiplomaPwd=$("#YL_DiplomaPwd").val()
			data.companyAutCode=$("#companyAutCode").val()
			data.companyAutSECRET=$("#companyAutSECRET").val()
			data.companyEncryCode=$("#companyEncryCode").val()
			data.marketDomName=$("#marketDomName").val()
			return data
			
		}
		//验证公司编码输入框信息
		function checkEdit(){

			if ($.trim($("#companyCode").val()).length <10 || $.trim($("#companyCode").val()).length >10 ) {
				layer.msg('公司编码必须为10位', {icon: 7});
				return false;
			}
			if ($("#companyCode").val().indexOf(" ") > -1) {
				layer.msg('公司编码不能包含空格', {icon: 7});
				return false;
			}
			return true;		
		}
		
		//提交修改
		$("#ediSubmit").on('click',function(){
			
			if(checkEdit()){
			var webObj=GetRequest()
			var companyId=webObj.companyId;
			var dataObj=collectFrom();
				dataObj.companyId=companyId;
			console.log(dataObj)
			layer.msg('数据提交中', {
			  icon: 16
			  ,shade: 0.01
			});
			$.ajax({
				type:"post",
				data:dataObj,
				url:myurl+"/company/updateCompanyInfo.do",
				async:true,
				dataType:'json',
				success:function(data){
					
					if(data.code==0){
						layer.msg('修改成功', {icon: 1});
						setTimeout(function(){
							layer.closeAll();
							
						},2000)
					}else{
						layer.msg(data.msg, {icon: 5});
					}
				},
				error:function(err){
					layer.msg('修改失败'+err, {icon: 5});
					console.log(err)
				}
			});
			}		
		})	
});
	
	
}
