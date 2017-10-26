var forms = [ "#formlist", "#formmgr", "#forminfo" ];
function removeClass() {
	$('#tabids').find('div').each(function(index) {
		$(this).removeClass("selected");
	});
}
function changeForm(e) {
	for (var i = 0; i < forms.length; i++) {
		if (e == i) {
			$("" + forms[i]).show();
		} else {
			$("" + forms[i]).hide();
		}

	}

}

var CustomerController = {
	proid : '',
	filename:'',
	uploadedFileIds : new Array(),
	init : function() {
		CustomerController.initProductTable();
	},
	initProductTable : function() {
		$("#customerOrderTable").bootstrapTable('destroy');
		$('#customerOrderTable').bootstrapTable({
			url : "order/prolist",// 这个接口需要处理bootstrap table传递的固定参数
			method : "post",
			dataType : "json",
			queryParamsType : "limit",
			pagination : true, // 分页
			singleSelect : false,
			sidePagination : "server", // 服务端处理分页
			striped : true, // 是否显示行间隔色
			clickToSelect : true,
			search : true,
			queryParams : function(params) {
				var data = {
					"limit" : params.limit,
					"offset" : params.offset,
					"search" : params.search,
					"sort" : params.sort,
					"customerId" : "1"
				}
				return data;
			},
			columns : [ {
				field : 'proid',
				title : '商品编号',
				width : '15%'
			}, {
				field : 'proname',
				title : '商品名称',
				width : '15%'
			}, {
				field : 'prolab',
				title : '价格',
				width : '10%'
			}, {
				field : 'addtime',
				title : '上架时间',
				width : '15%'
			}, {
				field : 'prodescrip',
				title : '描述'
			} ],
			onClickRow : function(row, $element, field) {
				CustomerController.fillOrderData(row);
				$("#prolist").addClass("unactive");
				$("#proinfo").addClass("selected");
				$("#forminfo").show();
				$("#formlist").hide();

			}
		});
	},
	fillOrderData : function(row) {
		CustomerController.proid = row.proid;
		CustomerController.filename = row.files;
		$("#proname").val(row.proname);
		$("#protype").val(row.protype);
		$("#tags").val(row.tags);
		$("#prolab").val(row.prolab);
		$("#prodescrip").val(row.prodescrip);
		$("#addtime").val(row.addtime);
		$("#files_show").html("");
		// 查询附件
		if (row.files) {
			$
					.ajax({
						url : "file/query",
						type : "post",
						data : {
							fileStr : row.files
						},
						success : function(data) {
							var files = data.data;
							var html_ = '';
							for (var i = 0; i < files.length; i++) {
								html_ += '<div style="margin: 10px 20px;display: inline-block;width: 120px;">';
								if (files[i].fileType
										&& (files[i].fileType == 'jpg'
												|| files[i].fileType == 'jpeg'
												|| files[i].fileType == 'png' || files[i].fileType == 'gif')) {
									html_ += '<img src="'
											+ files[i].path
											+ '" style="width: 120px;height:120px;">';
								} else {
									html_ += '<img src="resources/statics/img/file.jpg" style="width: 120px;height: 120px;">';
								}
								html_ += '<a target="_blank" href="'
										+ files[i].path
										+ '" style="display: inline-block;max-width: 120px;overflow: hidden;">'
										+ files[i].fileName + '</a>';
								html_ += '</div>';
							}
							$("#files_show").append(html_);
						}
					});
		}
	},
	orderForm : function() {
		$('#file').fileinput('destroy');
		initFileInput("file");
		$("#file").on("fileuploaded", function(event, data, previewId, index) {

			CustomerController.uploadedFileIds.push(data.response.data[0]);
		});
		$("#add_order_form")[0].reset();

	},
	saveOrder : function() {
		// 订单详情
		// 打包数据
		var filenames = "";
		for (var m = 0; m < CustomerController.uploadedFileIds.length; m++) {
			filenames += CustomerController.uploadedFileIds[m];
			if (m < CustomerController.uploadedFileIds.length - 1) {

				filenames += ',';
			}
		}
		var data = {
			proname : $("#proname_add").val(),
			protype : $("#protype_add").val(),
			prolab : $("#prolab_add").val(),
			prodescrip : $("#prodescrip_add").val(),
			tags : $("#tags_add").val(),
			files : filenames
		}
		$.ajax({
			url : "order/addpro",
			type: "post",
			data : JSON.stringify(data),
			contentType : 'application/json',
			dataType : "json",
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if(data.message=='success'){
					window.location.href='index.jsp';
					
				}
				
			}
		});

	}
};

$(document).ready(function() {
					CustomerController.init();

					// 新建订单
					$("#add_order").click(function() {
						$("#prolist").addClass("unactive");
						$("#promgr").addClass("selected");
						changeForm(1);
						CustomerController.orderForm();
					});

					// 修改订单
					$("#update_order").click(
							function() {
								var data = {
									proid : CustomerController.proid,
									proname : $("#proname").val(),
									protype : $("#protype").val(),
									prolab : $("#prolab").val(),
									prodescrip : $("#prodescrip").val(),
									tags : $("#tags").val(),
								};
								$.ajax({
									url : "order/update",
									type : "post",
									data : JSON.stringify(data),
									contentType : 'application/json',
									dataType : "json",
									async : false,
									success : function(data) {
										$('#customerOrderTable')
												.bootstrapTable('refresh');
										changeForm(0);
									}
								});

							});

					// 删除订单
					$("#delete_order").click(
							function() {
								var msg = '';
								msg += '<h4>商品编号：' + CustomerController.proid
										+ '</h2><br/>';
								msg += '<h4>商品名称：' + $("#proname").val()
										+ '</h2><br/>';
								msg += '<h4>是否确认删除该商品?</h2>';
								$("#msg").html(msg);
								$('#myModal').modal({
									keyboard : true
								});
							});

					$("#commit").click(
							function() {
								var data = {
									proid : CustomerController.proid,
									files:CustomerController.filename
								};
								$.ajax({
									url : "order/delete",
									type : "post",
									data : JSON.stringify(data),
									contentType : 'application/json',
									dataType : "json",
									success : function(data) {
										$('#customerOrderTable')
												.bootstrapTable('refresh');
										changeForm(0);
									}
								});
								$('#myModal').modal("hide");
							});

					// 保存订单
					$("#save_order").click(
							function() {
								var bootstrapValidator = $("#add_order_form")
										.data("bootstrapValidator");
								if (!bootstrapValidator.isValid()) {
									bootstrapValidator.validate();
									return;
								}
	
								CustomerController.saveOrder();
							});
					// 页面点击切换样式

					$('#tabids').find('div').each(function(index) {
						$(this).bind("click", function(e) {
							changeForm(index);
							removeClass();
							$(this).addClass("selected");
							$(this).removeClass("unactive");
						});
					});

					$('#add_order_form')
							.bootstrapValidator(
									{
										message : '表单验证失败',
										feedbackIcons : {
											valid : 'glyphicon glyphicon-ok',
											invalid : 'glyphicon glyphicon-remove',
											validating : 'glyphicon glyphicon-refresh'
										},
										fields : {
											proname_add : {
												message : '输入不符合要求',
												validators : {
													notEmpty : {
														message : '不能为空'
													},
													stringLength : {
														min : 2,
														max : 100,
														message : '必须在2-100个字符间'
													}
												}
											},
											prodescrip_add : {
												validators : {
													notEmpty : {
														message : '不能为空'
													}
												}
											},
											protype_add : {
												validators : {
													notEmpty : {
														message : '不能为空'
													}
												}
											},
											tags_add : {
												validators : {
													notEmpty : {
														message : '不能为空'
													}
												}
											},
											prodescrip_add : {
												validators : {
													notEmpty : {
														message : '不能为空'
													}
												}
											},
											prolab_add : {
												validators : {
													digits : {
														message : '必须为数字'
													},
													notEmpty : {
														message : '不能为空'
													}

												}
											}

										}
									});

				});