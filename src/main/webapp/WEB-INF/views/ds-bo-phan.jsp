<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Quản lý Bộ phận | Clinic</title>

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="resources/plugin/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- DataTables -->
<link rel="stylesheet" type="text/css"
	href="resources/plugin/datatables/datatables.min.css" />
<!-- Chosen -->
<link rel="stylesheet" type="text/css"
	href="resources/plugin/chosen/chosen.css" />

<!-- Custom Theme Style -->
<link href="resources/css/custom.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<jsp:include page="sidebar-menu.jsp"></jsp:include>

			<jsp:include page="top-nav.jsp"></jsp:include>

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>Clinic Management System</h3>
						</div>
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Danh sách Bộ phận</h2>
									<div class="navbar-right">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#modal-them-bp">
											<i class="fa fa-plus" aria-hidden="true"></i> Thêm bộ phận
										</button>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<table id="table-user"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>Tên bộ phận</th>
												<th>Ghi chú</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${dsBp}" var="bp">
												<tr>
													<td>${bp.tenBoPhan}</td>
													<td>${bp.ghiChu}</td>
													<td><button class="btn btn-info" 
																data-toggle="modal" data-target="#modal-sua-bp"
																onclick="suaBoPhan(${bp.id}, '${bp.tenBoPhan}', '${bp.ghiChu}')">
															<i class="fa fa-pencil-square-o"></i>
														</button>
														<button class="btn btn-danger"
																data-toggle="modal" data-target="#modal-xoa-bp"
																onclick="xoaBoPhan(${bp.id}, '${bp.tenBoPhan}')">
															<i class="fa fa-trash-o"></i>
														</button></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal Them bo phan -->
				<div class="modal fade" id="modal-them-bp">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Thêm bộ phận</h4>
							</div>

							<form:form class="form-horizontal form-label-left"
								action="them-bo-phan" method="POST" modelAttribute="boPhan">
								<div class="modal-body">
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="tenBoPhan" for="ten">Tên bộ phận <span
												class="required">*</span>
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input type="text" id="ten" required="required"
												class="form-control col-md-7 col-xs-12" path="tenBoPhan"></form:input>
										</div>
									</div>

									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="ghiChu" for="ghiChu">Ghi chú
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input type="text" id="ghiChu"
												class="form-control col-md-7 col-xs-12" path="ghiChu"></form:input>

										</div>
									</div>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-primary">Lưu</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- /end Modal Them bo phan -->
				
				<!-- Modal Sua bo phan -->
				<div class="modal fade" id="modal-sua-bp">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Cập nhật thông tin bộ phận</h4>
							</div>

							<form:form class="form-horizontal form-label-left"
								action="them-bo-phan" method="POST" modelAttribute="boPhan">
								<div class="modal-body">
									<form:hidden path="id" id="edit-id"/>
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="tenBoPhan" for="ten">Tên bộ phận <span
												class="required">*</span>
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input type="text" id="edit-ten" required="required"
												class="form-control col-md-7 col-xs-12" path="tenBoPhan"></form:input>
										</div>
									</div>

									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="ghiChu" for="ghiChu">Ghi chú
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input type="text" id="edit-ghiChu"
												class="form-control col-md-7 col-xs-12" path="ghiChu"></form:input>

										</div>
									</div>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-primary">Lưu</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- /end Modal Sua bo phan -->
				
				<!-- Modal Xoa bo phan -->
				<div class="modal fade" id="modal-xoa-bp">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Xóa bộ phận</h4>
							</div>

							<form:form class="form-horizontal form-label-left"
								action="xoa-bo-phan" method="POST" modelAttribute="boPhan">
								<div class="modal-body">
									<p id="del-noti"></p>
									<form:hidden path="id" id="del-id"/>
									<form:hidden path="tenBoPhan" id="del-ten"/>
								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-danger">Xóa</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- /end Modal xoa bo phan -->

			</div>
			<!-- /page content -->

			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>

	<!-- jQuery -->
	<script src="resources/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="resources/js/bootstrap.min.js"></script>
	<!-- Custom Theme Scripts -->
	<script src="resources/js/custom.js"></script>
	<script type="text/javascript"
		src="resources/plugin/datatables/datatables.min.js"></script>
	<script src="resources/plugin/chosen/chosen.jquery.js"></script>

	<script src="resources/js/jquery.uploadPreview.js"></script>

	<script>
		$(document).ready(function() {
			$("#table-user").DataTable({
				buttons : [ {
					extend : "copy",
					className : "btn-sm"
				}, {
					extend : "excel",
					className : "btn-sm"
				}, {
					extend : "print",
					className : "btn-sm"
				}, ]
			});
		});

		function suaBoPhan(id, ten, ghiChu){
			$("#edit-id").val(id);
			$("#edit-ten").val(ten);
			$("#edit-ghiChu").val(ghiChu);
		}
		
		function xoaBoPhan(id, ten){
			$("#del-noti").html("Anh/chị có chắc chắn muốn xóa <big>" + ten + "<big>");
			$("#del-id").val(id);
			$("#del-ten").val(ten);
		}
	</script>
</body>
</html>
