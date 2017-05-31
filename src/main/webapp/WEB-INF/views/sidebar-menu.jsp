<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="${pageContext.request.contextPath}" class="site_title"><i
				class="fa fa-heart"></i> <span>Clinic</span></a>
		</div>

		<div class="clearfix"></div>

		<!-- menu profile quick info -->
		<div class="profile clearfix">
			<div class="profile_pic">
				<img src="getProfileImageByUserName?username=${username}" alt="..."
					class="img-circle profile_img"
					onerror="this.src='resources/images/user.jpg';">
			</div>
			<div class="profile_info">
				<span>Welcome,</span>
				<h2>${username}</h2>
			</div>
			<div class="clearfix"></div>
		</div>
		<!-- /menu profile quick info -->

		<br />

		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
			<div class="menu_section">
				<ul class="nav side-menu">
					<li><a href="${pageContext.request.contextPath}"><i
							class="fa fa-home"></i> Home </a></li>
					<li><a><i class="fa fa-users"></i> Đón tiếp <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="tiep-nhan">Tiếp nhận bệnh nhân</a></li>
							<li><a href="thanh-toan">Thanh toán</a></li>
							<li><a href="benh-nhan">Danh sách bệnh nhân</a></li>
						</ul></li>
					<li><a><i class="fa fa-stethoscope"></i> Khám bệnh <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							 <li><a href="kham-benh">Khám bệnh</a></li>
							<li><a href="media_gallery.html">Media Gallery</a></li>
							<li><a href="typography.html">Typography</a></li>
						</ul></li>
					<li><a><i class="fa fa-heartbeat"></i> Điều trị <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="benh-nhan-dieu-tri">Danh sách bệnh nhân</a></li>
						</ul></li>
					<li><a><i class="fa fa-bar-chart-o"></i> Quản lý thuốc <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="chartjs.html">Chart JS</a></li>
							<li><a href="chartjs2.html">Chart JS2</a></li>
						</ul></li>
					<li><a><i class="fa fa-clone"></i>Báo cáo <span
							class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="fixed_sidebar.html">Fixed Sidebar</a></li>
							<li><a href="fixed_footer.html">Fixed Footer</a></li>
						</ul></li>
					<li><a><i class="fa fa-bar-chart-o"></i> Quản lý đối tượng
							<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="benh-nhan">Bệnh nhân - danh sách</a></li>
							<li><a href="bo-phan">Bộ phận - Thêm, xoá, sửa</a></li>
							<li><a href="dich-vu">Dịch vụ - Thêm, xoá, sửa</a></li>
						</ul></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<li><a href="user-list"><i class="fa fa-user"></i> Quản lý người dùng
							<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu">
							<li><a href="user-list">Danh sách người dùng</a></li>
						</ul></li>
					</sec:authorize>
				</ul>
			</div>


		</div>
		<!-- /sidebar menu -->
	</div>
</div>