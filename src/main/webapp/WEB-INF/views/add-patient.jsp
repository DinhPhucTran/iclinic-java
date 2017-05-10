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
						<div class="title_right">
							<div
								class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="Search for..."> <span
										class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								<div class="x_title">
									<h2>Nhập thông tin bệnh nhân</h2>
									<ul class="nav navbar-right panel_toolbox">
										<li><a class="collapse-link"><i
												class="fa fa-chevron-up"></i></a></li>
									</ul>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<form name="benhNhan" action="benhnhan/luu" method="post"
										data-parsley-validate class="form-horizontal form-label-left">
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="name">Họ tên bệnh nhân <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="name" name="tenBenhNhan" required="required"
													class="form-control col-md-7 col-xs-12">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12"
												for="dob">Ngày sinh <span class="required">*</span>
											</label>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<input type="text" id="dob" name="ngaySinh" required="required"
													class="form-control col-md-7 col-xs-12"
													data-inputmask="'alias': 'date'">
											</div>
										</div>
										<div class="form-group">
											<label class="control-label col-md-3 col-sm-3 col-xs-12">Giới
												tính</label>
											<div class="col-md-6 col-sm-6 col-xs-12"
												style="margin-top: 5px;">
												<input type="radio" class="flat" name="gioiTinh" id="genderM"
													value="M" checked="checked" required /> Nam <input
													type="radio" class="flat" name="gioiTinh" id="genderF"
													value="F" /> Nữ <input type="radio" class="flat"
													name="gender" id="genderO" value="O" /> Khác
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
</body>
</html>
