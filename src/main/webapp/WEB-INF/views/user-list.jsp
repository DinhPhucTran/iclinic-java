<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
									<h2>Danh sách người dùng</h2>
									<div class="navbar-right">
										<button class="btn btn-primary" data-toggle="modal"
											data-target="#modal-add-user">
											<i class="fa fa-plus" aria-hidden="true"></i> Thêm người dùng
										</button>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="x_content">
									<table id="table-user"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>ID</th>
												<th>Username</th>
												<th>Role</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${userList}" var="user">
												<tr>
													<td>${user.id}</td>
													<td>${user.userName}</td>
													<td><c:forEach items="${user.roles}" var="role">${role.position} </c:forEach></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal Add user -->
				<div class="modal fade" id="modal-add-user">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Thêm người dùng
									mới</h4>
							</div>

							<form:form class="form-horizontal form-label-left"
								action="add-user" method="POST" modelAttribute="user"
								enctype="multipart/form-data">
								<div class="modal-body">
									<div class="row">
										<div class="col-md-4">
											<div class="ava-container">
												<div id="img-preview" class="ava-image">
													<input type="file" name="image1" class="ava-input" id="img-upload"/>
												</div>
												<div class="ava-middle" onclick="openFileDialog()" title="Chọn ảnh đại diện">
													<div class="ava-text"><i class="fa fa-camera"></i></div>
												</div>
											</div>
										</div>
										<div class="col-md-8">
											<div class="item form-group">
												<form:label
													class="control-label col-md-3 col-sm-3 col-xs-12"
													path="userName" for="username">UserName <span
														class="required">*</span>
												</form:label>
												<div class="col-md-6 col-sm-6 col-xs-12">
													<form:input type="text" id="username" required="required"
														class="form-control col-md-7 col-xs-12" path="userName"></form:input>
												</div>
											</div>

											<div class="item form-group">
												<form:label
													class="control-label col-md-3 col-sm-3 col-xs-12"
													path="password" for="password">Mật khẩu <span
														class="required">*</span>
												</form:label>
												<div class="col-md-6 col-sm-6 col-xs-12">
													<form:input type="text" id="password" required="required"
														class="form-control col-md-7 col-xs-12" path="password"></form:input>

												</div>
												<div class="col-md-2">
													<button class="btn btn-success" id="bt-gen-pass"
														type="button" onclick="generatePassword()">
														<i class="fa fa-random" title="Tạo mật khẩu"></i>
													</button>
												</div>
											</div>

											<div class="form-group">
												<form:label
													class="control-label col-md-3 col-sm-3 col-xs-12"
													for="roles" path="roles">Roles <span
														class="required">*</span>
												</form:label>
												<div class="col-md-6 col-sm-6 col-xs-12">
													<form:select class="form-control" id="roles" path="roles"
														multiple="true">
														<form:options items="${roleList}" itemValue="id"
															itemLabel="position"></form:options>
													</form:select>
												</div>
											</div>
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
				<!-- /end Modal Add user -->

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

			$("#roles").chosen({
				width : "100%",
				placeholder_text_multiple : "Chọn role"
			});
			
			$.uploadPreview({
			    input_field: "#img-upload",   // Default: .image-upload
			    preview_box: "#img-preview",  // Default: .image-preview
			    label_field: "#image-label",    // Default: .image-label
			    label_default: "Choose File",   // Default: Choose File
			    label_selected: "Change File",  // Default: Change File
			    no_label: true                 // Default: false
			  });
		});

		function generatePassword() {
			$("#password").val(randomPass());
		}

		function randomPass() {
			//(Math.random() + 1).toString(36).substring(2, 7)
			var text = "";
			var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

			for (var i = 0; i < 5; i++)
				text += possible.charAt(Math.floor(Math.random()
						* possible.length));

			return text;
		}
		
		function openFileDialog(){
			$("#img-upload").trigger("click");
		}
	</script>
</body>
</html>
