<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理</title>
<link rel="stylesheet" href="resources/statics/css/default.css"
	type="text/css">
<link rel="stylesheet" href="resources/statics/css/head.css"
	type="text/css">
<link rel="stylesheet"
	href="resources/statics/plugins/bootstrap-3.3.7/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="resources/statics/plugins/bootstrap-3.3.7/css/bootstrapValidator.min.css">
<link rel="stylesheet"
	href="resources/statics/plugins/bootstrap-table/src/bootstrap-table.css">
<link rel="stylesheet"
	href="resources/statics/css/plugins/third/fileinput.css">
<script src="resources/statics/js/plugins/third/jquery-1.11.1.js"></script>
<style>
</style>
</head>
<body>
	<div class="container">
	<div class="row top">
		<div class="user">
			<label>佳佳小工具 </label><label class='sub'>商品维护</label>
		</div>
	</div>
	<div class="row right">
		<div class="tabs" id='tabids'>
			<div class="tab selected" id="prolist">商品列表</div>
			<div class="tab" id="promgr">添加商品</div>
			<div class="tab" id="proinfo">商品详情</div>
			<button type="button" class="button btn-4" id="add_order"
				style="float: right;margin: 8px;width:150px;font-size:15px;">新建商品</button>

		</div>
		<div class="main-container">
			<div id="formlist" class="formgroups">
				<table id="customerOrderTable"></table>
			</div>
			<div id="formmgr" style="display: none;" class="formgroups">
				<form id="add_order_form" style="width: 80%;margin: auto;">
					<div class="form-head first-head">商品信息</div>

					<div id="addform">
						<div class="form-group">
							<label class="block clearfix">商品名称:<span
								class="block input-icon input-icon-right"> <input
									class="form-control" id="proname_add" name="proname_add"
									class="form-control" required />
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">商品类别:<span
								class="block input-icon input-icon-right">
								<select class="form-control" id="protype_add" name="protype_add" required>
										<option>女童装</option>
										<option>男童装</option>
										<option>女装</option>
										<option>男装</option>
								</select>
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">Tag标识:<span
								class="block input-icon input-icon-right"> <input
									class="form-control" id="tags_add" name="tags_add"
									class="form-control" required />
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">价格:<span
								class="block input-icon input-icon-right"> <input
									class="form-control" id="prolab_add" name="prolab_add"
									class="form-control" required />
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">特征/描述:<span
								class="block input-icon input-icon-right"> <textarea
										class="form-control" name="prodescrip_add" id="prodescrip_add"
										required></textarea>
							</span></label>
						</div>

						<div class="form-group">
							<button type="button" class="button btn-4" id="save_order"
								style="margin:0 auto;display:block;width:200px;height:50px;font-size:20px;">保 存</button>
						</div>
					</div>
				</form>
						<div class="form-group">
							<label class="block clearfix">上传图片:<span
								class="block input-icon input-icon-right"> <input
									id="file" name="file" class="form-control" class="file-loading"
									type="file" multiple data-min-file-count="1"
									data-show-preview="true">
							</span></label>
						</div>
			</div>
			<div id="forminfo" style="display: none;" class="formgroups">
				<div style="margin:0 auto;display:block;text-align:center;padding:2px;margin-bottom:5px;">
						<button type="button" class="button btn-4" id="update_order" style="width:200px;height:50px;font-size:20px;">修改</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    	<button type="button" class="button btn-4" id="delete_order" style="width:200px;height:50px;font-size:20px;">删除</button>
			    	</div>

				<form name="order-detail" style="width: 80%;margin: auto;">
					<div class="form-head first-head">商品信息</div>
					<div id='showform'>
						<div class="form-group">
							<label class="block clearfix">商品名称:<span
								class="block input-icon input-icon-right"> <input
									class="form-control" id="proname" name="proname"
									class="form-control" required/>
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">商品类别:<span
								class="block input-icon input-icon-right"> 
						 <select class="form-control" id="protype" name="protype" required>
										<option>女童装</option>
										<option>男童装</option>
										<option>女装</option>
										<option>男装</option>
								</select>
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">Tag标识:<span
								class="block input-icon input-icon-right"> <input
									class="form-control" id="tags" name="tags" class="form-control"
									required />
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">价格:<span
								class="block input-icon input-icon-right"> <input
									class="form-control" id="prolab" name="prolab"
									class="form-control" required />
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">特征/描述:<span
								class="block input-icon input-icon-right"> <textarea
										class="form-control" name="prodescrip" id="prodescrip"
										required></textarea>
							</span></label>
						</div>
						<div class="form-group">
							<label class="block clearfix">图片信息: </label>
							<div class="block" id="files_show"></div>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">提示框</h4>
				</div>
				<div class="modal-body" id='msg'></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消
					</button>
					<button type="button" id="commit" class="btn btn-primary">
						更改(删除)</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</div>
</body>
<script
	src="resources/statics/plugins/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<script
	src="resources/statics/plugins/bootstrap-3.3.7/js/bootstrapValidator.min.js"></script>
<script
	src="resources/statics/plugins/bootstrap-table/src/bootstrap-table.js"></script>
<script
	src="resources/statics/plugins/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
<script src="resources/statics/js/plugins/third/fileinput.js"></script>
<script src="resources/statics/js/plugins/file.js"></script>
<script src="resources/statics/js/haimgr.js"></script>
</html>