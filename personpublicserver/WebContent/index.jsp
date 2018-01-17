
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8"> 
	<title>人事公示系统首页</title>
	
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/common/layui/css/layui.css">
	<link rel="stylesheet" href="/resources/css/header.css">
	<link rel="shortcut icon" href="/resources/images/favicon.ico" />
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/resources/common/layui/layui.js"></script>
	<script src="/resources/js/jqthumb.js"></script>
	<script src="/resources/js/jqthumb.min.js"></script>
	
</head>

<body>
<div>
	     <nav class="navbar navbar-default">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>

              <a class="navbar-brand" href="#">
                <img src="http://cloudresource-1251063063.costj.myqcloud.com/image/yomail_logo@1x.png" class="img-responsive" alt="Personnel系统客户端">
                <span style="
                    position: relative;
                    top: -38px;
                    left: 60px;
                    color: #0088e9;
                    font-size: 25px;
                ">Personnel</span>
              </a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-collapse">
              <ul class="nav navbar-nav navbar-right">
                <li class="active">
                  <a href="/">首页</a>
                </li>
                <li>
                  <a  href="/">访客浏览</a>
                </li>
                <li>
                  <a href="resources/passages/login.jsp">员工登录</a>
                </li>
                <li>
                  <a target="_blank" href="/" blank="_target">人事社区</a>
                </li>
                <li>
                  <a target="_blank" href="resources/backstage/index.html" blank="_target">后台管理</a>
                </li>
              </ul>
            </div>
          </div>
          <hr>
        </nav>
</div>

<div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>   

	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active">
			<img src="/resources/images/index1.jpg" alt="First slide" />
		</div>
		<div class="item">
			<img src="/resources/images/index2.jpg" alt="Second slide" />
		</div>
		<div class="item">
			<img src="/resources/images/index3.jpg" alt="Third slide" />
		</div>
		<div class="item">
			<img src="/resources/images/indexbg6.jpg" alt="Fourth slide" />
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
	<a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
</div>

	<form method="POST" enctype="multipart/form-data" action="/upLoad/file.do">
    <input type="file" name="file"><br/>
	 <input type="hidden" name="fileType" value="images"><br/>
	
    <br/>
    <input type="submit" value="上传2"> 
	</form>
	

<!-- 控制按钮 -->

<!--<div style="text-align:center;">
	<input type="button" class="btn start-slide" value="Start">
	<input type="button" class="btn pause-slide" value="Pause">
	<input type="button" class="btn prev-slide" value="Previous Slide">
	<input type="button" class="btn next-slide" value="Next Slide">
	<input type="button" class="btn slide-one" value="Slide 1">
	<input type="button" class="btn slide-two" value="Slide 2">
	<input type="button" class="btn slide-three" value="Slide 3">
	<input type="button" class="btn slide-four" value="Slide 4">
</div> -->
<script>
	$(function(){
		// 初始化轮播
		$(".start-slide").click(function(){
			$("#myCarousel").carousel('cycle');
		});
		// 停止轮播
		$(".pause-slide").click(function(){
			$("#myCarousel").carousel('pause');
		});
		// 循环轮播到上一个项目
		$(".prev-slide").click(function(){
			$("#myCarousel").carousel('prev');
		});
		// 循环轮播到下一个项目
		$(".next-slide").click(function(){
			$("#myCarousel").carousel('next');
		});
		// 循环轮播到某个特定的帧 
		$(".slide-one").click(function(){
			$("#myCarousel").carousel(0);
		});
		$(".slide-two").click(function(){
			$("#myCarousel").carousel(1);
		});
		$(".slide-three").click(function(){
			$("#myCarousel").carousel(2);
		});
		$(".slide-four").click(function(){
			$("#myCarousel").carousel(3);
		});
	});
	
	$(function(){
		$('.item img').jqthumb({
			width: '100%',
			height: '600',
			after: function(imgObj){
				imgObj.css('opacity', 0).animate({opacity: 1}, 2000);
			}
		});
	});
layui.use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
	
	$("#ddd").click(function(){
		layer.alert('墨绿风格，点击确认看深蓝', {
		  skin: 'layui-layer-lan' //样式类名
		  ,closeBtn: 0
		}, 
		/*function(){
		  layer.alert('偶吧深蓝style', {
			skin: 'layui-layer-lan',
			closeBtn: 0,
			anim: 4 动画类型
		  });
		}*/
		);
	});
});
</script>
</body>
</html>