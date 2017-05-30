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

<title>Clinic</title>

<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="${pageContext.request.contextPath}/resources/css/custom.css"
	rel="stylesheet">
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">

			<jsp:include page="sidebar-menu.jsp"></jsp:include>

			<jsp:include page="top-nav.jsp"></jsp:include>

			<!-- page content -->
			<div class="right_col" role="main">
				<div class="">
					<div class="row tile_count">
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-users"></i> Tổng bệnh nhân</span>
							<div class="count">${countBN}</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-user-plus"></i> Bệnh nhân mới</span>
							<div class="count green">${BNmoi}</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-clock-o"></i> Lượt khám trong ngày</span>
							<div class="count green">0</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-calendar"></i> Lượt khám trong tháng</span>
							<div class="count green">0</div>
						</div>
					</div>
					
					<div class="row tile_count">
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-user"></i> Tổng số nhân viên</span>
							<div class="count">${countUser}</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-user-md"></i> Bác sĩ</span>
							<div class="count green">${countBS}</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-user-md"></i> Y tá</span>
							<div class="count green">${countYT}</div>
						</div>
						<div class="col-md-2 col-sm-4 col-xs-6 tile_stats_count">
							<span class="count_top"><i class="fa fa-user"></i> Nhân viên khác</span>
							<div class="count green">${countOthers}</div>
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
</body>
</html>
