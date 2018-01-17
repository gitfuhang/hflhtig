layui.use(['jquery','layer','element','laypage'],function(){
	      window.jQuery = window.$ = layui.jquery;
	      window.layer = layui.layer;
          var element = layui.element(),
              laypage = layui.laypage;
			
			
		$("#ddd").click(function(){
		layer.alert('墨绿风格，点击确认看深蓝', {
		  skin: 'layui-layer-lan' //样式类名
		  ,closeBtn: 0
		});
	});
            

});