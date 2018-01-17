layui.use(['form','layer','jquery','laypage','laydate'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		laydate=layui.laydate,
		$ = layui.jquery;
		
	//加载页面数据
	var newsData = '';
	var myurl='http://www.personalPub.com'
	function randerdatble(){
		$.get(myurl+"/company/getuserCompanyMsg.do", function(data){
			var newArray = [];
			var data=JSON.parse(data)
				newsData=data.Result;
				console.log(newsData);
				newsList();
		})
	}
	
	randerdatble()
		
	//查询
	$(".search_btn").click(function(){
		var objData={}

		objData.userName=$("#userName").val();
		
		var newArray = [];
		/*if(objData.userName==''){
			layer.msg("请输入需要查询的内容");
		}else{*/
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
			console.log(objData)
			$.ajax({
					url : myurl+'/company/getuserCompanyMsg.do',
					type : "post",
					data:objData,
					dataType : "json",
					success : function(data){
						console.log(data)
		            	if(data.code==0){
							layer.alert(data.msg,{icon:6, title:'查询提示'});
								//删除成功之后，重新渲染页面
							newsData = data.Result;
							newsList(newsData)
		            	}else{
		            		layer.msg(data.msg, {icon: 5});
		            	}
					},
					error:function(err){
						layer.msg('查询失败！请稍后在试',{icon: 5});
					}
					
				})
				
              layer.close(index);
		//}
	})
	
	
	//删除信息
	$("body").on("click",".news_del",function(){  //删除
		var _this = $(this);
		layer.confirm('确定删除此信息？',{icon:3, title:'提示信息'},function(index){
			//_this.parents("tr").remove();
			for(var i=0;i<newsData.length;i++){
				if(newsData[i].userId == _this.attr("data-id")){
					//获取ID
					var userId=newsData[i].userId;
					$.ajax({
						type:"post",
						url:myurl+"/company/delCompanyUserMsg.do",
						data:{
							userId:userId
						},
						async:true,
						datatype:'json',
						success:function(data){
							var data=JSON.parse(data)
							if(data.code==0){			   
								layer.alert(data.msg,{icon:6, title:'删除提示'});
								//删除成功之后，重新渲染页面
								randerdatble()
							}else{
								layer.alert(data.msg,{icon:5, title:'删除提示'});
							}
						},
						error:function(data){
							layer.alert('网络异常',{icon:5, title:'删除提示'});
						}
					});
												
					newsList(newsData);
				}
			}
			layer.close(index);
		});
	})
	
	//详情
	$("body").on("click",".news_edit",function(){  //编辑
		//layer.alert('功能还未开放',{icon:6, title:'文章编辑'});
		var _this = $(this);
		for(var i=0;i<newsData.length;i++){
				if(newsData[i].userId == _this.attr("data-id")){
					//获取ID
					var userId=newsData[i].userId;
					console.log("获取userId:"+userId)
					
					$(window).one("resize",function(){
						function openCompanyEdit(){
							var index = layui.layer.open({
								title : "员工详细信息",
								type : 2,
								content : "editCompanyUserMsg.html?userId="+userId,
								success : function(layero, index){
									setTimeout(function(){
										layui.layer.tips('点击此处返回员工列表', '.layui-layer-setwin .layui-layer-close', {
											tips: 3
										});
									},500)
								}
						})			
						layui.layer.full(index);
				};
				openCompanyEdit()
			
	}).resize();
						
				}
		}
	})
	
	
	
	
			
			
		$("#ddd").click(function(){
		layer.alert('墨绿风格，点击确认看深蓝', {
		  skin: 'layui-layer-lan' //样式类名
		  ,closeBtn: 0
		});
	})
	
	function newsList(that){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			if(!that){
				currData = newsData.concat().splice(curr*nums-nums, nums);
			}else{
				currData = that.concat().splice(curr*nums-nums, nums);
			}
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					dataHtml += '<tr>'
//			    	+'<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+'<td>'+data[i].userName+'</td>'
			    	+'<td>'+data[i].gender+'</td>'
			    	+'<td>'+data[i].age+'</td>'
					+'<td>'+data[i].gender+'</td>'
			    	+'<td>'+data[i].age+'</td>'
			    	+'<td>'+data[i].departMent+'</td>'
			    	+'<td>'+data[i].socialSecurity+'</td>'
			    	+'<td>'+data[i].salaryTreatment+'</td>'
			    	+'<td>'+data[i].workingYears+'</td>'
			    	+'<td>'
					+  '<a class="layui-btn layui-btn-mini news_edit" data-id="'+data[i].userId+'"><i class="iconfont icon-edit"></i> 编辑</a>'
					+  '<a class="layui-btn layui-btn-danger layui-btn-mini news_del" data-id="'+data[i].userId+'"><i class="layui-icon">&#xe640;</i> 删除</a>'
			        +'</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="8">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 5; //每页出现的数据量
		if(that){		
			newsData = that;
			
		}
		laypage({
			cont : "page",
			pages : Math.ceil(newsData.length/nums),
			jump : function(obj){
				
					$(".news_content").html(renderDate(newsData,obj.curr));
					$('.news_list thead input[type="checkbox"]').prop("checked",false);
				
		    	//form.render();
		    	//form.render();
			}
		})
	}
})
    