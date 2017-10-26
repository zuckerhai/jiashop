<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>佳佳の小店</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="resources/proshow.css" type="text/css">
<link rel="stylesheet"
	href="resources/statics/plugins/bootstrap-3.3.7/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet" type="text/css" href="resources/base.css"
	charset="gbk" />
<link rel="stylesheet" type="text/css" href="resources/sale.css"
	charset="gbk" />
<style type="text/css">
.new-search .new-mu_l2 {
	padding: 5px 0;
	border-bottom: 1px solid #e8e5e5;
}
.new-mu_l2w{
left:-30px;
position:relative;
}
.form-group{
margin-bottom: 6px;
}
.qklink{
    border: 1px solid lightgrey;
    border-width: 0 0 0 2px;
    padding-left:4px;
    padding-right:4px;
    font-size:11px;
}

.qklink a:visited,a:link,a:hover, a:focus {
    text-decoration:none;
    color: black;
}
.qklink a:active{text-decoration:none;color: black;}

</style>
</head>
<body>
	<div class="container">
		<div id="logo" class="page-header"
			style="border: 1px solid #ddd;border-width:0 0 1px 0;margin:0 auto;">
			<h3>
				佳佳小店铺 <small>工厂特卖</small>
			</h3>

		</div>
		<div class="row form-group">
			<div class="search" style="position:relative">
				<span class="input-box">
					<form action="/pro/search" id="searchForm" class="">
					<input name="keyword" type="text" id="newkeyword" class="new-input" >
					</form> <a  onclick="searchKey();" class="btn-search"><span>search</span></a>
				</span>
			</div>
		</div>

		<div class="new-ct">
			<div class="new-search new-goods-lst">
				<div class="new-goods-tab" style="line-height:20px;">
					<span class="tit">商品列表</span>
					   <small>
					      <span class="qklink" id="all"><a onclick="typeSelect('all')">全部</a></span>
					      <span class="qklink" id="wman"> <a onclick="typeSelect('wman')">女装</a></span>
					      <span class="qklink" id="man"><a onclick="typeSelect('man')">男装</a></span>
					  </small>
					  
					<div class="new-goods-btn">
						<a id="m1" onclick="showBtn(1)" class="new-g-tbn" alt='列表图'>列表图</a>
						<a id="m2" onclick="showBtn(2)" class="new-g-tbn2  on">列表</a>
					</div>
				</div>
				<div id="listContainer"></div>

				<div class="new-paging">
					<div class="new-tbl-type">
						<div class="new-tbl-cell">
							<a class="new-a-prve" onclick="pageChange(-1);"><span>上一页</span></a>
						</div>
						<div class="new-tbl-cell new-p-re">
							<div class="new-a-page">
								<span class="new-open" id="pageLabel">1/5</span>
							</div>
							<select class="new-select" onchange="pageChange(0);" id="selectHtml">
								<option value="1" >第1页</option>
								<option value="2" >第2页</option>
								<option value="3" >第3页</option>
								<option value="4" >第4页</option>
							</select>
						</div>
						<div class="new-tbl-cell">
							<a class="new-a-next" onclick="pageChange(1);"><span>下一页</span></a>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>
	<script>
/////////////定义全局变量////////////
var globalVar={
	first:1,
	end:10,
	pageCount:"",
	pageIndex:1,
	total:"",
	size: 10,
	proid:"",
	tags:"",
	data:"",
	layout:2,
	protype:null
}
</script>
<script src="resources/statics/js/jquery-1.10.1.min.js"></script>
<script src="resources/statics/js/proshow.js"></script>
<script src="resources/statics/js/data.js"></script>
</body>

</html>