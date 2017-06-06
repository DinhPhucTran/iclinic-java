<!-- kham-benh.jsp - Add by Hang - 31/05/2017  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
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
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/css/select2.min.css" rel="stylesheet" />
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
    box-shadow: 0 1px 1px rgba(0,0,0,0.1);
    overflow:hidden;
    border: 1px solid #f7f7f7;
}
a{
color:#169F85;
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
				<div class = "row">
					<div class="col-md-6">
						<!-- Begin kham benh -->
						<div class = "box box-info">
							<div class = "box-header with-border">
								<h2 class = "box-title">Khám bệnh</h2>
							</div>
							<div class="form-horizontal">
                   		 		<div class="box-body">
                   		 			<form:form id = "hoaDon" name="hoaDon" action="hoa-don/luu" method="post" 
											class="form-horizontal form-label-left" modelAttribute="hoaDon">
											<!-- phieuKham: phieukhamdangcho -->
										<form:hidden path="phieuKham" id="phieuKham"/> 
										<div class="form-group">
											<label class="col-sm-3 control-label"> Mã phiếu khám 
											</label>
											<div class="col-sm-9">
												<input type="text" id="phieuKhamBenh"
													class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label"> Mã bệnh nhân 
											</label>
											<div class="col-sm-9">
												<input type="text" id="maBenhNhan" 
													class="form-control">
											</div>
										</div> 
										<div class="form-group">
											<label class="col-sm-3 control-label"> Bệnh nhân  
											</label>
											<div class="col-sm-9">
												<input type="text" id="tenBenhNhan"
													class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Tổng tiền </label>
											<div class="col-sm-9">
												<form:input type="number" min = "0" pattern = "^\d*(\.\d{2}$)?" id="tongTien" name = "tongTien"
												class="form-control col-md-7 col-xs-12" path="tongTien"></form:input>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Ngày Khám </label>
											<div class="col-sm-9">
												<h4 id = "ngayKham"></h4>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label">Ngày thanh toán </label>
											<div class="col-sm-9">
												<h4>
													<%
													Date dNow = new Date();
													SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
													out.print("<h4>" + ft.format(dNow) + "</h4>");
												%>
												</h4>
											</div>
										</div>
			                    		<div class="box-footer">
			                   				<button type="reset" id = "btHuy" onClick = "huyHoaDon()" class="btn btn-primary">Hủy</button>
			                    			<button type="submit" class="btn btn-success pull-right">Tạo mới</button>
			               			 	</div>
									</form:form>
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
				                    <table class="table table-bordered table-hover" id="tb_DichVuDaThucHien">
				                        <thead>
				                            <tr>
				                            	<th>STT</th>
				                                <th>Tên dịch vụ</th>
				                                <th>Đơn giá</th>
				                            </tr>
				                        </thead>
				                        <tbody></tbody>
				                    </table>
				                </div>
				            </div>
				        </div>
						<!--  End dịch vụ đã thực hiện -->
					</div>
						<!-- Begin danh sách phiếu khám -->
					 <div class="col-md-6">
					 	 <div class="box box-info">
			                <div class="box-header with-border">
			                    <h2 class="box-title">Danh sách phiếu khám</h2>
			                </div>
			                <div class="form-horizontal">
			                	<div class="box-body table-responsive no-padding">
				                    <table class="table table-bordered table-hover" id="tb_DanhSachPhieuKham">
				                       <thead>
				                            <tr>
				                                <th>Mã phiếu khám</th>
				                                <th>Tên bệnh nhân</th>
				                                <th>Ngày sinh</th>
				                                <th>Tuổi</th>
				                                <th>Giới tính</th>
				                                <th>Ngày khám</th>
				                                <th >Bệnh nhân ID</th>
				                            </tr>
				                        </thead>
				                        <tbody>
				                        	<c:forEach items="${dsPhieuKhamBenh}" var="pkb">
												<tr>
													<td>${pkb.maPhieuKhamBenh}</td>
													<td>${pkb.getBenhNhan().getTenBenhNhan()}</td>
													<td>${pkb.getBenhNhan().getNgaySinh()}</td>
													<td>${pkb.getBenhNhan().getTuoi()}</td>
													<td>
														<c:choose>
															<c:when test ="${pkb.getBenhNhan().getGioiTinh()} = 'F'">Nữ</c:when> 
															<c:when test ="${pkb.getBenhNhan().getGioiTinh()} = 'M'">Nam</c:when> 
															<c:otherwise>Khác</c:otherwise>
														</c:choose>
													</td>
													<td>${pkb.getNgayKham()}</td>
													<td >${pkb.getBenhNhan().getMaBenhNhan()}</td>
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
			</div>
			<!-- End quy trình khám bệnh  -->
			<!-- /page content -->
			<div>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.3/js/select2.min.js"></script>
	<script src="https://select2.github.io/dist/js/select2.full.js"></script>
	<script src="https://select2.github.io/vendor/js/prettify.min.js"></script>
	<script src="https://select2.github.io/vendor/js/anchor.min.js"></script>
	<!-- <script type="text/javascript" src="resources/js/kham-benh.js"></script> -->
	<script>
	/** kham-benh.js - Add by Hang - 31/05/2017
	 * 
	 */
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
		        	
	        	  // set value of phieu kham benh when click row table ds phieu kham
		        var table = $('#tb_DanhSachPhieuKham').DataTable();
		        $('#tb_DanhSachPhieuKham tbody').on('click', 'tr', function () {
		        	if($('#phieuKhamBenh').val() != table.row(this).data()[0]){
			        	$('#phieuKhamBenh').val(table.row(this).data()[0]);
			        	$('#tenBenhNhan').val(table.row(this).data()[1]);
			            $('#maBenhNhan').val(table.row(this).data()[6]);
			            $('#ngayKham').text(table.row(this).data()[5]);
			            getDichVuByMaPhieuKham(); 
			            getPhieuKhamDangChoByMaPhieuKham();
		        	}
		        });
		    });
			
		 function getDichVuByMaPhieuKham(){
			var maPhieuKhamBenh = $('#phieuKhamBenh').val();
	        $.ajax({
	          type: "POST",
	          url: "hoa-don/get-dich-vu-by-ma-phieu-kham",
	          data: { maPhieuKhamBenh: maPhieuKhamBenh },
	          success: function(dsDichVu) {
	        	  displayDichVuThucHien(dsDichVu);
	          },
	          error:function (e){
	         	 console.log("error",e);
	          }
	      });  
		 }
		 
		 function getPhieuKhamDangChoByMaPhieuKham(){
				var maPhieuKhamBenh = $('#phieuKhamBenh').val();
		        $.ajax({
		          type: "POST",
		          url: "hoa-don/get-phieu-kham-dang-cho-by-ma-phieu-kham",
		          data: { maPhieuKhamBenh: maPhieuKhamBenh },
		          success: function(phieuKhamDangCho) {
		        	  $('#phieuKham').val(phieuKhamDangCho.id);
		          },
		          error:function (e){
		         	 console.log("error",e);
		          }
		      });  
			 }
		 
		 function displayDichVuThucHien(dsDichVu) {
			 huyHoaDon();
			 var index;
			 var table = document.getElementById("tb_DichVuDaThucHien");
			 var tongTien = 0;
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
				    
				    tongTien += dsDichVu[index].donGia;
				}
			 $("#tongTien").val(tongTien);
			}
		 function huyHoaDon(){
			 $('#tb_DichVuDaThucHien tr').not(function(){ return !!$(this).has('th').length; }).remove();
		 }
	</script>
</body>
</html>
