<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quản lý bệnh nhân | Clinic</title>

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
									<h2>Danh sách bệnh nhân</h2>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="x_content">
								<table id="table-user"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Họ tên</th>
											<th>Giới tính</th>
											<th>Tuổi</th>
											<th>Số điện thoại</th>
											<th>Tiền sử bệnh</th>
											<th>Ngày tiếp nhận</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${dsBenhNhan}" var="bn">
											<tr>
												<td>${bn.tenBenhNhan}</td>
												<td>${bn.gioiTinh}</td>
												<td>${bn.tuoi}</td>
												<td>${bn.soDienThoai}</td>
												<td>${bn.tienSuBenh}</td>
												<td>${bn.ngayTiepNhan}</td>
												<td>
													<button class="btn btn-info" data-toggle="modal"
														data-target="#modal-dieu-tri"
														onclick="nhapVien(${bn.maBenhNhan}, '${bn.tenBenhNhan}', '${bn.tuoi}')">
														<i class="fa fa-pencil-square-o"></i>
													</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal tao ho so dieu tri -->
			<div class="modal fade" id="modal-dieu-tri">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
							<h4 class="modal-title">Nhập viện</h4>
						</div>

						<form:form class="form-horizontal form-label-left"
							action="tao-ho-so-dieu-tri" method="POST"
							modelAttribute="benhNhan">
							<div class="modal-body">
								<div class="item form-group">
									<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
										path="maBenhNhan" for="maBenhNhan">Mã bệnh nhân <span
											class="required">*</span>
									</form:label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<form:input class="form-control col-md-7 col-xs-12"
											path="maBenhNhan" id="del-id" readonly="true" />
									</div>
								</div>
								<div class="item form-group">
									<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
										path="tenBenhNhan" for="tenBenhNhan">Tên bệnh nhân
										</form:label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<form:input class="form-control col-md-7 col-xs-12"
											path="tenBenhNhan" id="del-ten" readonly="true" />

									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Hủy</button>
								<button type="submit" class="btn btn-danger">Tạo</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
			<!-- /end Modal tao ho so dieu tri -->

		</div>
		<!-- /page content -->

		<jsp:include page="footer.jsp"></jsp:include>
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
		
		function nhapVien(id, ten, tuoi) {
			alert(id);
			$("#del-id").val(id);
			$("#del-ten").val(ten);
		}
	</script>
</body>
</html>