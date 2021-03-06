<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Clinic</title>

<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="resources/plugin/iCheck/skins/flat/green.css"
	rel="stylesheet">
<link href="resources/plugin/pnotify/pnotify.custom.css" media="all"
	rel="stylesheet" type="text/css" />
<!-- Custom Theme Style -->
<link href="resources/css/custom.css" rel="stylesheet">
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
							<h3>Tiếp nhận bệnh nhân</h3>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Nhập thông tin bệnh nhân</h2>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<form name="benhNhan" action="benh-nhan/luu" method="post"
										data-parsley-validate class="form-horizontal form-label-left">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Họ tên bệnh nhân<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="name" name="tenBenhNhan"
													required="required" class="form-control col-md-7 col-xs-12">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="dob">Ngày sinh<span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="dob" name="ngaySinh"
													required="required" class="form-control col-md-7 col-xs-12"
													data-inputmask="'alias': 'date'">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Giới
												tính</label>
											<div class="col-md-6 col-sm-6 col-xs-12"
												style="margin-top: 5px;">
												<input type="radio" class="flat" name="gioiTinh"
													id="genderM" value="Nam" checked="checked" required /> Nam <input
													type="radio" class="flat" name="gioiTinh" id="genderF"
													value="Nữ" /> Nữ <input type="radio" class="flat"
													name="gioiTinh" id="genderO" value="Khác" /> Khác
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="job">Nghề nghiệp </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="job" name="ngheNghiep"
													class="form-control col-md-7 col-xs-12">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="address">Địa chỉ </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="address" name="diaChi"
													class="form-control col-md-7 col-xs-12">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="phone">Số điện thoại </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="phone" name="soDienThoai"
													class="form-control col-md-7 col-xs-12"
													data-inputmask="'mask': '9999 999 9999'">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="tienSuBenh">Tiền sử bệnh </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="tienSuBenh" name="tienSuBenh"
													class="form-control col-md-7 col-xs-12">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày
												tiếp nhận </label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<%
													Date dNow = new Date();
													SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
													out.print("<h4>" + ft.format(dNow) + "</h4>");
												%>
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Phòng </label>
												<div class="col-md-6 col-sm-6 col-xs-12">
												<select class="form-control col-md-7 col-xs-12">
													<c:forEach items = "${dsPhong}" var = "phong">
														<option value = "${phong.maPhong}">${phong.tenPhong}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<div class="ln_solid"></div>
										<div class="form-group">
											<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
												<button class="btn btn-primary" type="button">Cancel</button>
												<button class="btn btn-primary" type="reset">Reset</button>
												<button type="submit" class="btn btn-success">Submit</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
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
	<!-- iCheck -->
	<script src="resources/plugin/iCheck/icheck.min.js"></script>
	<!-- Inputmask -->
	<script src="resources/plugin/inputmask/jquery.inputmask.bundle.js"></script>
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
</body>
</html>
