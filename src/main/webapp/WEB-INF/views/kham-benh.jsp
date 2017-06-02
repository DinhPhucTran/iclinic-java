<!-- kham-benh.jsp - Add by Hang - 31/05/2017  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
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
<!-- Chosen -->
<link rel="stylesheet" type="text/css"
	href="resources/plugin/chosen/chosen.css" />
<!-- Select 2 -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css"
	rel="stylesheet" />
<!-- DataTables -->
<link rel="stylesheet" type="text/css"
	href="resources/plugin/datatables/datatables.min.css" />

<style>
div.box.box-info {
	border-top-color: #1ABB9C;
}

div.box {
	position: relative;
	height: auto;
	border-radius: 3px;
	background: #ffffff;
	border-top: 3px solid #d2d6de;
	margin-bottom: 20px;
	width: 100%;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
	overflow: hidden;
	border: 1px solid #f7f7f7;
}

a {
	color: #169F85;
	font-weight: bold;
}
</style>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="sidebar-menu.jsp"></jsp:include>
			<jsp:include page="top-nav.jsp"></jsp:include>
			<!-- page content -->
			<div class="right_col" role="main">
				<!-- Begin quy trinh khám bệnh -->
				<div class="row">
					<div class="col-md-6">
						<!-- Begin kham benh -->
						<div class="box box-info">
							<div class="box-header with-border">
								<h2 class="box-title">Khám bệnh</h2>
							</div>
							<div class="form-horizontal">
								<div class="box-body">
									<form:form id="phieuKhamBenh" name="phieuKhamBenh"
										action="phieu-kham-benh/luu" method="post"
										class="form-horizontal form-label-left"
										modelAttribute="phieuKhamBenh">
										<form:hidden path="maPhieuKhamBenh" id="maPhieuKhamBenh" />
										<form:hidden path="benhNhan" id="benhNhan" />
										<div class="form-group">
											<label class="col-sm-2 control-label">Ngày Khám </label>
											<div class="col-sm-10">
												<%
													Date dNow = new Date();
														SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
														out.print("<h4>" + ft.format(dNow) + "</h4>");
												%>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"> Bệnh nhân<span
												class="required">*</span>
											</label>
											<div class="col-sm-10">
												<input type="text" id="tenBenhNhan" name="tenBenhNhan"
													required="required" class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label for="bs" class="col-sm-2 control-label"> Bác
												sĩ<span class="required">*</span>
											</label>
											<div class="col-sm-10">
												<form:select class="form-control" path="bacSi" id="bs"
													required="required">
													<option value="0"></option>
													<form:options items="${dsUser}" itemValue="id"
														itemLabel="fullName"></form:options>
												</form:select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="name">Lý
												do khám<span class="required">*</span>
											</label>
											<div class="col-sm-10">
												<textarea type="text" id="lyDoKham" name="lyDoKham"
													required="required" class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="name">Chẩn
												đoán<span class="required">*</span>
											</label>
											<div class="col-sm-10">
												<textarea type="text" id="chandoan" name="chanDoan"
													required="required" class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label" for="name">Lời
												dặn </label>
											<div class="col-sm-10">
												<textarea type="text" id="loidan" name="loiDan"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
									</form:form>
									<div class="box-footer">
										<button type="reset" class="btn btn-primary">Hủy</button>
										<button id="btCapNhatThongTinPhieuKham"
											onClick="capNhatThongTinPhieuKham()"
											class="btn btn-success pull-right">Cập nhật</button>
									</div>
								</div>
							</div>
						</div>
						<!-- End kham benh  -->
						<!--  Begin dịch vụ đã thực hiện -->
						<div class="box box-info">
							<div class="box-header with-border">
								<div>
									<h2 class="box-title">Dịch vụ đã thực hiện</h2>
								</div>
							</div>
							<div class="form-horizontal">
								<div class="box-body table-responsive no-padding">
									<table class="table table-bordered table-hover"
										id="tb_DichVuDaThucHien">
										<thead>
											<tr>
												<th hidden>Bác sĩ thực hiện</th>
												<th>Tên dịch vụ</th>
												<th>Chỉ số</th>
												<th>Kết quả</th>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
								</div>
							</div>
						</div>
						<!--  End dịch vụ đã thực hiện -->
						<!--  Begin Thêm dịch vụ -->
						<div class="box box-info">
							<div class="box-header with-border">
								<div class="x_title">
									<h2>Thêm dịch vụ</h2>
									<div class="navbar-right">
										<button class="btn btn-success" onClick="themDichVu()">
											Thêm</button>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<form:form id="phieuYeuCauDichVu" name="dichVuKham"
								action="phieu-yeu-cau-dich-vu/luu" method="post"
								class="form-horizontal form-label-left"
								modelAttribute="listPYCDichVu">
								<div class="form-horizontal">
									<div class="box-body table-responsive no-padding">
										<table class="table table-bordered table-hover"
											id="tb_ThemDichVu">
											<thead>
												<tr>
													<th>Tên dịch vụ</th>
													<th>Phòng khám</th>
													<th>Đơn giá</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
								</div>
								<div class="box-footer">
									<button id="btPhieuKhamBenh" type="submit"
										class="btn btn-success pull-right">Lưu và in phiếu
										khám</button>
								</div>
							</form:form>
						</div>
						<!--  End Thêm dịch vụ -->
					</div>
					<!-- Begin danh sách phiếu khám -->
					<div class="col-md-6">
						<div class="box box-info">
							<div class="box-header with-border">
								<h2 class="box-title">Danh sách phiếu khám</h2>
							</div>
							<div class="form-horizontal">
								<div class="box-body table-responsive no-padding">
									<table class="table table-bordered table-hover"
										id="tb_DanhSachPhieuKham">
										<thead>
											<tr>
												<th>Mã phiếu khám</th>
												<th>Tên bệnh nhân</th>
												<th>Ngày sinh</th>
												<th>Tuổi</th>
												<th>Giới tính</th>
												<th>Nhập viện</th>
												<th style="display: none;">Lý do khám</th>
												<th style="display: none;">Bệnh nhân ID</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${dsPhieuKhamBenh}" var="pkb">
												<tr>
													<td>${pkb.maPhieuKhamBenh}</td>
													<td>${pkb.getBenhNhan().getTenBenhNhan()}</td>
													<td>${pkb.getBenhNhan().getNgaySinh()}</td>
													<td>${pkb.getBenhNhan().getTuoi()}</td>
													<td><c:choose>
															<c:when test="${pkb.getBenhNhan().getGioiTinh()} = 'F'">Nữ</c:when>
															<c:when test="${pkb.getBenhNhan().getGioiTinh()} = 'M'">Nam</c:when>
															<c:otherwise>Khác</c:otherwise>
														</c:choose></td>
													<td><button class="btn btn-info" data-toggle="modal"
															data-target="#modal-dieu-tri"
															onclick="nhapVien(${pkb.getBenhNhan().getMaBenhNhan()}, '${pkb.getBenhNhan().getMaBenhNhan()}, '${pkb.getBenhNhan().getTuoi()}')">
															<i class="fa fa-pencil-square-o">Nhập viện</i>
														</button></td>
													<td style="display: none;">${pkb.getBenhNhan().getTienSuBenh()}</td>
													<td style="display: none;">${pkb.getBenhNhan().getMaBenhNhan()}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<!-- End danh sách phiếu khám  -->
				</div>
				<!-- Begin kê đơn thuốc -->
				<div class="box box-info">
					<div class="box-header with-border">
						<div class="x_title">
							<h2>Kê đơn thuốc</h2>
							<div class="navbar-right">
								<button class="btn btn-success" onClick="themDonThuoc()">
									Thêm</button>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<form:form name="donThuoc" action="don-thuoc/luu" method="post"
						class="form-horizontal form-label-left">
						<div class="form-horizontal">
							<input type="hidden" name="phieuKham" id="phieuKhamThuoc" />
							<div class="box-body table-responsive no-padding">
								<table class="table table-hover" id="tb_ThemDonThuoc">
									<thead>
										<tr style="text-align: center">
											<th>Tên thuốc</th>
											<th>Số lượng</th>
											<th>Sáng</th>
											<th>Trưa</th>
											<th>Chiều</th>
											<th>Tối</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>
						</div>
						<div class="box-footer">
							<button type="reset" class="btn btn-primary">Hủy</button>
							<button type="submit" class="btn btn-success pull-right">Lưu
								và in đơn thuốc</button>
						</div>
					</form:form>
				</div>
				<!-- End kê đơn thuốc -->
				<!-- Modal tao ho so dieu tri -->
				<div class="modal fade" id="modal-dieu-tri">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">

							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
								<h4 class="modal-title">Nhập viện</h4>
							</div>

							<form:form class="form-horizontal form-label-left"
								action="ho-so-dieu-tri" method="POST"
								modelAttribute="hoSoDieuTri">
								<div class="modal-body">
									<div class="item form-group">
										<!-- <h1>Nhập viện</h1> -->
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="benhNhan.maBenhNhan" for="del-id">Mã bệnh nhân <span
												class="required">*</span>
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="benhNhan.maBenhNhan" id="del-id" readonly="true" />
										</div>
									</div>
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											path="benhNhan.tenBenhNhan" for="tenBenhNhan">Tên bệnh nhân
										</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:input class="form-control col-md-7 col-xs-12"
												path="benhNhan.tenBenhNhan" id="del-ten" readonly="true" />

										</div>
									</div>
									<!-- Nhan vien tiep nhan -> giay nhap vien -->
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="receptionists" path="giayNhapVien.nhanVienTiepNhan.id">Nhân viên tiếp nhận 
												</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:select class="form-control" id="receptionists"
												path="giayNhapVien.nhanVienTiepNhan.id">
												<form:options items="${receptionists}" itemValue="id"
													itemLabel="fullName"></form:options>
											</form:select>
										</div>
									</div>
									<!-- Bac si -->
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="doctors" path="bacSi.id">Bác sĩ điều trị 
												</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:select class="form-control" id="doctors"
												path="bacSi.id">
												<form:options items="${doctors}" itemValue="id"
													itemLabel="fullName"></form:options>
											</form:select>
										</div>
									</div>
									<!-- Y ta -->
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="nurses" path="yTa.id">Y tá điều trị 
												</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:select class="form-control" id="nurses" path="yTa.id">
												<form:options items="${nurses}" itemValue="id"
													itemLabel="fullName"></form:options>
											</form:select>
										</div>
									</div>
									<!-- Phong -->
									<div class="item form-group">
										<form:label class="control-label col-md-3 col-sm-3 col-xs-12"
											for="rooms" path="phong.maPhong">Phòng 
												</form:label>
										<div class="col-md-6 col-sm-6 col-xs-12">
											<form:select class="form-control" id="rooms"
												path="phong.maPhong">
												<form:options items="${rooms}" itemValue="maPhong"
													itemLabel="tenPhong"></form:options>
											</form:select>
										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Hủy</button>
									<button type="submit" class="btn btn-danger">Nhập viện</button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
				<!-- /end Modal tao ho so dieu tri -->
				<div></div>
				<!-- End quy trình khám bệnh  -->
				<!-- /page content -->
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
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
	<!-- iCheck -->
	<script src="resources/plugin/iCheck/icheck.min.js"></script>
	<!-- Inputmask -->
	<script src="resources/plugin/inputmask/jquery.inputmask.bundle.js"></script>
	<!-- Select 2  -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
	<script src="https://select2.github.io/dist/js/select2.full.js"></script>
	<script src="https://select2.github.io/vendor/js/prettify.min.js"></script>
	<script src="https://select2.github.io/vendor/js/anchor.min.js"></script>
	<!-- <script type="text/javascript" src="resources/js/kham-benh.js"></script> -->
	<script>
	/** kham-benh.js - Add by Hang - 31/05/2017
	 * 
	 */
	var indexRowDichVu = 0;
	var indexRowThuoc = 0;
	$(document).ready(function(){ 
			 	$("#tb_DanhSachPhieuKham").DataTable({
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
			 	
		        $("#bn").select2({
		        	placeholder: "Chọn bệnh nhân",
		        	allowClear: true
		        });
		        $("#bs").select2({
		        	placeholder: "Chọn bác sĩ",
		        	allowClear: true
		        });
		        $('#tb_ThemDichVu').on('click', 'input[type="button"]', function(e){
		        	   $(this).closest('tr').remove()
		        	})
		         $('#tb_ThemDonThuoc').on('click', 'input[type="button"]', function(e){
		        	   $(this).closest('tr').remove()
		        	})
		        	
	        	  // set value of phieu kham benh when click row table ds phieu kham
		        var table = $('#tb_DanhSachPhieuKham').DataTable();
		        $('#tb_DanhSachPhieuKham tbody').on('click', 'tr', function () {
		        	$('#maPhieuKhamBenh').val(table.row(this).data()[0]);
		            $('#tenBenhNhan').val(table.row(this).data()[1]);
		            $('#lyDoKham').val(table.row(this).data()[6]);
		            $('#benhNhan').val(table.row(this).data()[7]);
		            getDichVuByMaPhieuKham(); 
		        });
		        
		      /*   //submit form phieuDichVu
		        $('#phieuKhamBenh').submit(function(){
		            alert("Submitted phiếu yêu cầu dịch vụ");
		            $("#btPhieuKhamBenh").submit();
		        });
		        $('#phieuYeuCauDichVu').submit(function(){
		            alert("Submitted phiếu khám bệnh");
		        }); */
		    });
	
			function getDichVuByMaPhieuKham(){
				var maPhieuKhamBenh = $('#maPhieuKhamBenh').val();

				console.log("maPhieuKhamBenh",maPhieuKhamBenh);
		        $.ajax({
		          type: "POST",
		          url: "hoa-don/get-dich-vu-by-ma-phieu-kham",
		          data: { maPhieuKhamBenh: maPhieuKhamBenh },
		          success: function(dsDichVu) {
		        	  console.log(dsDichVu);
		        	  displayDichVuThucHien(dsDichVu);
		          },
		          error:function (e){
		         	 console.log("error",e);
		          }
		      });  
			 }
			
			function displayDichVuThucHien(dsDichVu) {
				 var index;
				 var table = document.getElementById("tb_DichVuDaThucHien");
				 for (index = 0; index < dsDichVu.length; ++index) {
					    var row = table.insertRow(index+1);
					    var cell1 = row.insertCell(0);
					    var cell2 = row.insertCell(1);
					    var cell3 = row.insertCell(2);
					    
					    var stt = parseInt(index) + 1;
					    var contentcell1 = "<p class = 'removeRow'>"+ stt +"</p>";
					  	cell1.innerHTML = contentcell1;
					  	
					    var contentcell2 = "<p class = 'removeRow'>"+ dsDichVu[index].tenDichVu +"</p>";
					  	cell2.innerHTML = contentcell2;
					  	
					  	var contentcell3 = "<p class = 'removeRow'>" + dsDichVu[index].donGia + "</p>";
					    cell3.innerHTML = contentcell3; 
					}
				}
			function themDichVu() {
				var rowCount = $('#tb_ThemDichVu').length;
			 	var table = document.getElementById("tb_ThemDichVu");
			    var row = table.insertRow(rowCount);
			    
			    var contentcell1 = "<tr><td><div class='col-sm-10'><select name = 'dichVuSel' id ="+ "dichVuSel" + indexRowDichVu + 
			    " class='form-control' onChange = 'changeDichVuSel(this)'>"
			    +" <c:forEach items='${dsDichVu}' var='dv'>"
			    +"<option value='${dv.maDichVu}' data-othervalue ='${dv.donGia}' >${dv.tenDichVu}</option></c:forEach></select></div>"
			    +"<input type=hidden id=donGiaTemp" + indexRowDichVu + " />"
			    +"<input type=hidden id=donGiaTemp" + indexRowDichVu + " />"
			    +"<input type=hidden id = 'dichVu"+indexRowDichVu+ "' name = 'phieuYeuCauDichVu["+indexRowDichVu +"].dichVu' />"
			    +"<input type=hidden id = 'phieuKham"+indexRowDichVu+ "' name = 'phieuYeuCauDichVu["+indexRowDichVu +"].phieuKham' />";
			    
			    var contentcell2 = "<td><p id = "+"phongKham" + indexRowDichVu + "></p></td>";
			    
			  	var contentcell3 = "<td><p id = "+"donGia" + indexRowDichVu + "></p></td>";
			    
			  	var contentcell4 = "<td><div class='col-sm-10'><input type='button' value =  'Xóa' class='btn btn-default'></input></div></td></tr>";
			  	
			  	var content = contentcell1 +contentcell2+contentcell3+contentcell4;
			  	$("#tb_ThemDichVu tbody").append(content);
			  	 
			  	indexRowDichVu = parseInt(indexRowDichVu) + 1; 
			}
		 
		 function changeDichVuSel(elementCur){
			 var index = elementCur.id.substring(9);
				var phongKham = $('#phongKham' + index);
				var donGia = $('#donGia' + index);
				var maDichVu = elementCur.options[elementCur.selectedIndex].value;
				
				// set modelAttribute phieuYeuCauDichVu
				$('#dichVu').val(maDichVu);
				
				// set name listDichVu.dichVu[].maDichVu
			  	$('#phieuKham' + index).val($('#maPhieuKhamBenh').val());
				$('#dichVu' + index).val(elementCur.value);
				
				// get don gia temp trong attribut data-othervalue
				var donGiaTemp = $('#dichVuSel' + index).find('option:selected').attr('data-othervalue');
				
		        $.ajax({
		          type: "POST",
		          url: "phieu-kham-benh/get-phong-by-ma-dich-vu",
		          data: { maDichVu: maDichVu },
		          success: function(result) {
		         	 phongKham.text(result[0].tenPhong);
		         	 donGia.text(donGiaTemp); 
		          },
		          error:function (e){
		         	 console.log("error",e);
		          }
		      });  
		 }
		 
		 function printDiv(divName) {
		        var contents = document.getElementById(divName).innerHTML;
		        var frame1 = document.createElement('iframe');
		        frame1.name = "frame1";
		        frame1.style.position = "absolute";
		        frame1.style.top = "-1000000px";
		        document.body.appendChild(frame1);
		        var frameDoc = frame1.contentWindow ? frame1.contentWindow : frame1.contentDocument.document ? frame1.contentDocument.document : frame1.contentDocument;
		        frameDoc.document.open();
		        frameDoc.document.write('<html><head><title>DIV Contents</title>');
		        frameDoc.document.write('</head><body>');
		        frameDoc.document.write(contents);
		        frameDoc.document.write('</body></html>');
		        frameDoc.document.close();
		        setTimeout(function () {
		            window.frames["frame1"].focus();
		            window.frames["frame1"].print();
		            document.body.removeChild(frame1);
		        }, 500);
		        return false;
		    }
		 function themDonThuoc() {
				var rowCount = $('#tb_ThemDonThuoc').length;
			 	var table = document.getElementById("tb_ThemDonThuoc");
			    var row = table.insertRow(rowCount);
			    
			     var contentcell1 = "<tr><td><div class='col-sm-10'><select name = 'thuocSel' id ="+ "thuocSel" + indexRowThuoc + 
			    " class='form-control' onChange = 'changeThuocSel(this)'>"
			    +" <c:forEach items='${dsThuoc}' var='dv'>"
			    +"<option value='${dv.maThuoc}' data-othervalue ='${dv.donGia}' >${dv.tenThuoc}</option></c:forEach></select></div>"
			    +"<input type=hidden id=donGiaTemp" + indexRowThuoc + " />"
			    +"<input type=hidden id=donGiaTemp" + indexRowThuoc + " />"
			    +"<input type=hidden id = 'thuoc"+indexRowThuoc+ "' name = 'chiTietDonThuoc["+indexRowThuoc +"].thuoc' />";
			    
			    contentcell1 += "<td><input type = number min = 0 id = "+"soLuong" + indexRowThuoc  + " name = 'chiTietDonThuoc["+indexRowThuoc +"].soLuong' /></td>";
			    contentcell1 += "<td><input type = number min = 0 id = "+"sang" + indexRowThuoc  + " name = 'chiTietDonThuoc["+indexRowThuoc +"].sang' /></td>";
			    contentcell1 += "<td><input type = number min = 0 id = "+"trua" + indexRowThuoc  + " name = 'chiTietDonThuoc["+indexRowThuoc +"].trua' /></td>";
			    contentcell1 += "<td><input type = number min = 0 id = "+"chieu" + indexRowThuoc  + " name = 'chiTietDonThuoc["+indexRowThuoc +"].chieu' /></td>";
			    contentcell1 += "<td><input type = number min = 0 id = "+"toi" + indexRowThuoc  + " name = 'chiTietDonThuoc["+indexRowThuoc +"].toi' /></td>";
			    contentcell1 += "<td><div class='col-sm-10'><input type='button' value =  'Xóa' class='btn btn-default'></input></div></td></tr>";
			  	
			  	$("#tb_ThemDonThuoc tbody").append(contentcell1);
			  	 
				indexRowThuoc = parseInt(indexRowThuoc) + 1;  
			}
			function changeThuocSel(elementCur){
				 var index = elementCur.id.substring(8);
				 console.log("index", index);
					var thuoc = $('#thuoc' + index);
					console.log(thuoc);
					var maDichVu = elementCur.options[elementCur.selectedIndex].value;
					
					// set modelAttribute chitietdonthuoc
					thuoc.val(elementCur.value);
					
				  	$('#phieuKhamThuoc' + index).val($('#maPhieuKhamBenh').val());
					$('#dichVu' + index).val(elementCur.value);
			} 
			function capNhatThongTinPhieuKham(){
				var phieuKham = {
					      "maPhieuKhamBenh" : $('#maPhieuKhamBenh').val(),
					      "benhNhan" : $('#benhNhan').val(),
					      "bacSi" : $('#maPhieuKhamBenh').val(),
					      "lyDoKham" : $('#lyDoKham').val(),
					       "chanDoan" : $('#chandoan').val(),
					   		"loiDan" : $('#loidan').val()
					   };
				/* $.ajax({
			        type: "POST",                
			        url: "phieu-kham-benh/cap-nhat",
			        data: JSON.stringify(phieuKham),
			        success: function(){
			        },
			        error: function (e) {
			            console.log("Error " + e);
			        }
			        
			    }); */
				$.ajax({
			          type: "POST",
			          url: "phieu-kham-benh/cap-nhat",
			          data: { maPhieuKhamBenh : $('#maPhieuKhamBenh').val() , benhNhan : $('#benhNhan').val(),bacSi : $('#maPhieuKhamBenh').val(),
					      lyDoKham : $('#lyDoKham').val(),
					       chanDoan : $('#chandoan').val(),
					   		loiDan : $('#loidan').val() },
			          success: function() {
			          },
			          error:function (e){
			         	 console.log("error",e);
			          }
				});  
			}
			function nhapVien(id, ten, tuoi) {
				$("#del-id").val(id);
				$("#del-ten").val(ten);
			}
	</script>
</body>
</html>
