$(document).ready(function() {
	var Request = new Object();
	Request = GetRequest();
	var proid = Request["id"];
	if(proid=="" || proid==null){
		alert("该商品已断货");
		history.go(-1);		
		return;
	}
	
	detailData.proid=proid;	
	var ahtml="http://106.14.163.136/jiashop/prodetail/detail.html?id="+detailData.proid
	$("#ctext").val(ahtml);
	
	getInfos();
	initPage();

});

function getInfos() {
	var data = {
			"customerId":detailData.proid
		};
		$.ajax({
			url : "/jiashop/order/getproinfo",
			type : "post",
			data : JSON.stringify(data),
			contentType : 'application/json',
			dataType : "json",
			async : false,
			success : function(data) {
				detailData.proInfo=data.data;
				
			}
		});

	// 查询附件
	if (detailData.proInfo.files) {
		$.ajax({
					url : "/jiashop/file/query",
					type : "post",
					async : false,
					data : {
						fileStr : detailData.proInfo.files
					},
					success : function(data) {
						var files = data.data;
						detailData.fileInfo=files;
					}
				});
	}

} 

function initPage(){
	if(!detailData.proInfo){
//		alert("该商品已断货");
//		history.go(-1);	
		return;
	}
	var title="";
	var price="";
	var images="";
	var info="";
	
	if(detailData.fileInfo){
		for(var i=0;i<detailData.fileInfo.length;i++){		
			images+="<li class='swiper-slide'><a href='#'> <img src='/jiashop/"+(detailData.fileInfo)[i].path+"' /></a></li>";
		}
		
		$("#images").html(images);
	}
	
	if(detailData.proInfo){
	   var orgin=detailData.proInfo.prolab;
	   var addsth=(parseInt(orgin)+RandomNumBoth(15,30));
	   price+="<b>￥"+orgin+"</b><del>￥"+addsth+"</del>";	
	   $("#price").html(price);
	   
	   
	   
	   var ti=detailData.proInfo.tags;
	   title+=ti;
	   $("#title").html(title);
	   
	   
	   info+="<b>商品名称："+detailData.proInfo.proname+"</b> <b>商品类型："+detailData.proInfo.protype+"</b>";
	   info+="<b>商品标签："+detailData.proInfo.tags+"</b> <b>商品上架时间："+detailData.proInfo.addtime+"</b>";
	   info+="<b>商品详细描述："+detailData.proInfo.prodescrip+"</b>";
	   $("#infoHtml").html(info);
	}
	
	
	
}
function RandomNumBoth(Min,Max){
    var Range = Max - Min;
    var Rand = Math.random();
    var num = Min + Math.round(Rand * Range); //四舍五入
    return num;
}
function GetRequest() {
	var url = location.search; // 获取url中"?"符后的字串
	var theRequest = new Object();
	if (url.indexOf("?") != -1) {
		var str = url.substr(1);
		strs = str.split("&");
		for (var i = 0; i < strs.length; i++) {
			theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
		}
	}
	return theRequest;
}