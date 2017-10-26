var IndexController = {
	filterBoxOpen: false,
	init: function () {
		IndexController.filterControl();
	},
	filterControl: function () {
		$("#sex").click(function () {
			if (!IndexController.filterBoxOpen) {
				$("#filter-box").removeClass("hidden").addClass("show");
				IndexController.filterBoxOpen = true;
			} else {
				$("#filter-box").removeClass("show").addClass("hidden");
				IndexController.filterBoxOpen = false;
			}
		});
	}
}

$(document).ready(function () {
	IndexController.init();
	getProList();
});


function getProList(){
	var data = {
			"limit" : globalVar.size,
			"offset" :globalVar.first-1, 
			"search" : globalVar.tags,
			"protype":globalVar.protype
		};
		$.ajax({
			url : "order/prolist",
			type : "post",
			data : JSON.stringify(data),
			contentType : 'application/json',
			dataType : "json",
			async : false,
			success : function(data) {
			    refreshPage(data);
				
			}
		});
	
}

function typeSelect(id){
	var domid="#"+id;
	if(id=="all"){
		globalVar.protype=null;	
	}
	if(id=="wman"){	
		globalVar.protype="女童装";
	}
	if(id=="man"){
		globalVar.protype="男童装";		
	}
	
	
	$("#all").css("background-color","white");
	$("#wman").css("background-color","white");
	$("#man").css("background-color","white");
	$(domid).css("background-color","lightgrey");
	
	globalVar.first=1;
	globalVar.end=10;
	globalVar.pageCount="";
	globalVar.pageIndex=1;
	
	getProList();
}

function pageChange(e){
	var pindex;
	if(e==0){
		pindex=$("#selectHtml").val();	
	}
	if(e==-1){
		if(globalVar.pageIndex==1){
			alert("本页是第一页");
			return;
		}
		pindex=globalVar.pageIndex-1
	}
	if(e==1){
		if(globalVar.pageIndex==globalVar.pageCount){
			alert("本页是最后页");
			return;
		}
		pindex=globalVar.pageIndex+1
	}
	globalVar.pageIndex=pindex;
	globalVar.first=10*(pindex-1)+1;
	globalVar.end=10*pindex;
	getProList();
	
	
}

function searchKey(){
	var tag=$("#newkeyword").val();
	globalVar.tags=tag;
	getProList();
	
}

function refreshPage(data){
	globalVar.data=data.rows;
	globalVar.total=data.total;
	var total=(globalVar.total)/10;
	globalVar.pageCount=parseInt(total)+1
	$("#pageLabel").html("");
	var pageLabel=globalVar.pageIndex+"/"+globalVar.pageCount
	$("#pageLabel").html(pageLabel);
	var selectHtml="";
	$("#selectHtml").html("");
	for(var i=1;i<=globalVar.pageCount;i++){
		selectHtml+="<option value='"+i+"' >第"+i+"页</option>";		
	}	
	$("#selectHtml").html(selectHtml);	
	$("#selectHtml").val(globalVar.pageIndex);
	initList(globalVar.layout);		
}


function showBtn(index){
	globalVar.layout=index;
	for(var i=1;i<=2;i++){
		if(i==index){
			$('#m'+i).addClass('on');
		}else{
			$('#m'+i).removeClass('on');
		}
	}
	initList(globalVar.layout);
}

function initList(index){
	if(index==1){showList();}
	else{showDetail();}
	}

function showDetail(){
		$("#listContainer").html("");
		var html="";
		var data=globalVar.data
		var length=data.length;
		html+="<ul class='new-mu_l2w'>";
		for(var i=0;i<length;i++){
			html+="<li class='new-mu_l2'><a href='prodetail/detail.html?id="+data[i].proid+"' class='new-mu_l2a'>";
			html+="<span class='new-mu_tmb'><img  src='/jiashop/"+data[i].file+"' width='100' " +
					"height='100'  alt=''/></span>";
			html+="<span class='new-mu_l2cw'><strong class='new-mu_l2h'>" +data[i].tags+
					"</strong>";
			html+="<span class='new-mu_l2h new-mu_l2h-v1'><span class='new-txt-rd2'></span></span>";
			html+="<span class='new-mu_l2c new-p-re'><strong class='new-txt-rd2'>&yen;"+data[i].prolab+"</strong>";
			html+="<span class='new-txt-price' style='color:red'></span></span> </span></a></li>";	
			
			
			
		}
		html+="</ul>";
		$("#listContainer").html(html);



	}


	function showList(){
		$("#listContainer").html("");
		var html="";
		var data=globalVar.data
		var length=data.length;
		var grp=parseInt(length/2);

		if(grp>0){
			for(var i=0;i<grp;i++){
				html="";
				html="<div class='new-goods-img-lst new-tbl-type'>";
				html+="<div class='new-tbl-cell'><a href='prodetail/detail.html?id="+data[i*2].proid+"' class='new-goods-section'>";
				html+="<div class='new-img-box'><img  src='"+data[i*2].file+"' onerror='this.src=''' width='130' height='130' alt='' class='new-goods-img'/>";
				html+="<span class='new-goods-txt new-p-re'><strong class='new-txt'>&yen;"+data[i*2].prolab+".00</strong>";
				html+="<span class='new-txt2' style='color:red'></span></span></div></a></div>";

				html+="<div class='new-tbl-cell'><a href='prodetail/detail.html?id="+data[i*2+1].proid+"' class='new-goods-section'>";
				html+="<div class='new-img-box'><img  src='"+data[i*2+1].file+"' onerror='this.src=''' width='130' height='130' alt='' class='new-goods-img'/>";
				html+="<span class='new-goods-txt new-p-re'><strong class='new-txt'>&yen;"+data[i*2+1].prolab+".00</strong>";
				html+="<span class='new-txt2' style='color:red'></span></span></div></a></div>";

				html+="</div>";
				$("#listContainer").append(html);

			}

		}

		if(length%2==1){
			html="";
			html="<div class='new-goods-img-lst new-tbl-type'>";
			html+="<div class='new-tbl-cell'><a href='prodetail/detail.html?id="+data[length-1].proid+"' class='new-goods-section'>";
			html+="<div class='new-img-box'><img  src='"+data[length-1].file+"'' onerror='this.src=''' width='130' height='130' alt='' class='new-goods-img'/>";
			html+="<span class='new-goods-txt new-p-re'><strong class='new-txt'>&yen;"+data[length-1].prolab+".00</strong>";
			html+="<span class='new-txt2' style='color:red'></span></span></div></a></div>";
			html+="</div>";
			$("#listContainer").append(html);

		}

	}


