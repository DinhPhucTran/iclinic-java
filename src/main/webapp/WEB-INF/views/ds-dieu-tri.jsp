<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Điều trị | Clinic</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/plugin/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="resources/plugin/datatables/datatables.min.css" />
<link rel="stylesheet" type="text/css"
	href="resources/plugin/chosen/chosen.css" />
<link href="resources/css/custom.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/plugin/pnotify/pnotify.custom.css" media="all"
	rel="stylesheet" type="text/css" />

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
						<div class="title_left"></div>
					</div>

					<div class="clearfix"></div>

					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Danh sách bệnh nhân đang điều trị</h2>
									<div class="clearfix"></div>
								</div>
								
								<div class="x_content">
								<table id="table-user"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Họ tên</th>
											<th>Giới tính</th>
											<th>Tuổi</th>
											<th>Ngày tiếp nhận</th>
											<th>Tình trạng gần đây</th>
											<th>Số lần điều trị</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${dsHoSoDieuTri}" var="hoSo">
											<tr>
												<td>${hoSo.benhNhan.tenBenhNhan}</td>
												<td>${hoSo.benhNhan.gioiTinh}</td>
												<td>${hoSo.benhNhan.tuoi}</td>
												<td>${hoSo.giayNhapVien.ngayNhapVien}</td>
												<td>${hoSo.tinhTrangGanDay}</td>
												<td>${hoSo.soLanDieuTri}</td>
												<td>
													<button class="btn btn-info" data-toggle="modal"
														data-target="#modal-dieu-tri"
														onclick="capNhat(${hoSo.maHoSo}, '${hoSo.benhNhan.tenBenhNhan}')">
														<i class="fa fa-pencil-square-o">Điều trị</i>
													</button>
													<button class="btn btn-info" data-toggle="modal"
														data-target="#modal-xuat-vien"
														onclick="xuatVien(${hoSo.maHoSo}, '${hoSo.benhNhan.tenBenhNhan}')">
														<i class="fa fa-pencil-square-o">Xuất viện</i>
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
					<div class="modal-dialog modal-lg">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title">Điều trị</h4>
							</div>

							<form:form class="form-horizontal form-label-left"
								action="cap-nhat-tinh-trang" method="POST"
								modelAttribute="chiTietDieuTri">
								<div class="modal-body">
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="hoSoDieuTriNoiTru.maHoSo" for="maHoSo">Hồ sơ số <span
												class="required">*</span>
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="hoSoDieuTriNoiTru.maHoSo" id="maHoSo" readonly="true" />
										</div>
									</div>
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="hoSoDieuTriNoiTru.benhNhan.tenBenhNhan"
											for="tenBenhNhan">Tên bệnh nhân
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="hoSoDieuTriNoiTru.benhNhan.tenBenhNhan"
												id="tenBenhNhan" readonly="true" />

										</div>
									</div>
									<!-- dsChiTietDieuTri -->
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="tinhTrang" for="tinhTrang">Tinh trạng 
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="tinhTrang" id="tinhTrang" />
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-danger">Xuất viện</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- /end Modal tao ho so dieu tri -->
				
				<!-- Modal xuat vien -->
				<div class="modal fade" id="modal-xuat-vien">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title">Xuất viện</h4>
							</div>
							<form:form class="form-horizontal form-label-left"
								action="xuat-vien" method="POST"
								modelAttribute="hoSoDieuTri">
								<div class="modal-body">
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="maHoSo" for="maHoSoXuatVien">Hồ sơ số <span
												class="required">*</span>
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="maHoSo" id="maHoSoXuatVien" readonly="true" />
										</div>
									</div>
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="benhNhan.tenBenhNhan"
											for="tenBenhNhanXuatVien">Tên bệnh nhân
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="benhNhan.tenBenhNhan"
												id="tenBenhNhanXuatVien" readonly="true" />
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-danger">Xuất viện</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- /end Modal xuat vien -->
			</div>

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
	<script src="resources/plugin/pnotify/pnotify.custom.js"></script>
	<c:if test="${not empty message}">
		<script>
			new PNotify({
				title : 'Thông báo',
				text : '${message}',
				type : '${msgType}',
				styling : 'bootstrap3',
				delay : 2000
			});
		</script>
	</c:if>
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
		function capNhat(id, ten) {
			$("#maHoSo").val(id);
			$("#tenBenhNhan").val(ten);
		}
		function xuatVien(id, ten) {
			$("#maHoSoXuatVien").val(id);
			$("#tenBenhNhanXuatVien").val(ten);
		}
	</script>
</body>

</html>