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
                   		 			<form:form name="phieuKhamBenh" action="phieu-kham-benh/luu" method="post" 
											class="form-horizontal form-label-left" modelAttribute="phieuKhamBenh">
										<form:hidden path="maPhieuKhamBenh" id="maPhieuKhamBenh"/> 
										<form:hidden path="benhNhan" id="benhNhan"/> 
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
											<label class="col-sm-2 control-label"> Bệnh nhân  
											</label>
											<div class="col-sm-10">
												<input type="text" id="tenBenhNhan" name="tenBenhNhan"
													class="form-control">
											</div>
										</div>
										<div class="form-group">
											<label for="bs"
											class="col-sm-2 control-label"> Bác sĩ  
											</label>
											<div class="col-sm-10">
												<form:select class="form-control" path="bacSi" id="bs">
														<option value = "0"></option>
														<form:options items="${dsUser}"
															itemValue="id" itemLabel="fullName"></form:options>
												</form:select>
											</div> 
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"
												for="name">Lý do khám <span class="required">*</span>
											</label>
											<div class="col-sm-10">
												<textarea type="text" id="lyDoKham" name="lyDoKham" required="required"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"
												for="name">Chẩn đoán <span class="required">*</span>
											</label>
											<div class="col-sm-10">
												<textarea type="text" id="chandoan" name="chanDoan" required="required"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label"
												for="name">Lời dặn<span class="required">*</span>
											</label>
											<div class="col-sm-10">
												<textarea type="text" id="loidan" name="loiDan"
													class="form-control col-md-7 col-xs-12"></textarea>
											</div>
										</div>
			                    		<div class="box-footer">
			                   				<button type="reset" class="btn btn-primary">Hủy</button>
			                    			<button id = "btPhieuKhamBenh" type="submit" class="btn btn-success pull-right">Cập nhật</button>
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
									<button class="btn btn-success" onClick ="themDichVu()"> Thêm </button>
								</div>
								<div class="clearfix"></div>
							</div>
		                    </div>
	                    	<form:form name="dichVuKham" action="dich-vu-kham/luu" method="post" 
										class="form-horizontal form-label-left" modelAttribute = "phieuYeuCauDichVu">
								<form:hidden path="dichVu" id="dichVu"/>
								<form:hidden path="phieuKham" id="phieuKham"/> 
			                    <div class="form-horizontal">
	                        		<div class="box-body table-responsive no-padding">
	                        			<table class="table table-bordered table-hover" id="tb_ThemDichVu">
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
			                        <button type="reset" class="btn btn-primary" onClick ="xoaDichVu()">Hủy</button>
			                        <button type="submit" class="btn btn-success pull-right">Lưu và in phiếu khám</button>
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
				                    <table class="table table-bordered table-hover" id="tb_DanhSachPhieuKham">
				                       <thead>
				                            <tr>
				                                <th>Mã phiếu khám</th>
				                                <th>Tên bệnh nhân</th>
				                                <th>Ngày sinh</th>
				                                <th>Tuổi</th>
				                                <th>Giới tính</th>
				                                <th>Nhập viện</th>
				                                <th style="display:none;">Lý do khám</th>
				                                <th style="display:none;">Bệnh nhân ID</th>
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
													<td><a href ="" style="color:#3c8db;"> Nhập viện </a></td>
													<td style="display:none;">${pkb.getBenhNhan().getTienSuBenh()}</td>
													<td style="display:none;">${pkb.getBenhNhan().getMaBenhNhan()}</td>
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
				 	<form:form name="donThuoc" action="don-thuoc/luu" method="post" 
					class="form-horizontal form-label-left" modelAttribute="donThuoc">
		            <div class="box-header with-border">
		                <div class="x_title">
							<h2>Kê đơn thuốc</h2>
							<div class="navbar-right">
								<button class="btn btn-success" onClick = "themDonThuoc()"> Thêm </button>
							</div>
							<div class="clearfix"></div>
						</div>
		            </div>
		            <div class="form-horizontal">
		                <div class="box-body table-responsive no-padding">
		                	<table class="table table-hover" id = "tb_ThemDonThuoc">
		                		 <thead>
		                            <tr style = "text-align:center">
		                                <th>Tên thuốc</th>
		                                <th>Số lượng</th>
		                                <th>Sáng</th>
		                                <th>Trưa</th>
		                                <th>Chiều</th>
		                                <th>Tối</th>
		                            </tr>
		                        </thead>
		                        <tbody></tbody>
		                	</table>
		                </div>
		            </div>
		             <div class="box-footer">
                        <button type="reset" class="btn btn-primary">Hủy</button>
                        <button type="submit" class="btn btn-success pull-right">Lưu và in đơn thuốc</button>
                    </div>
                    </form:form>
		        </div>
				<!-- End kê đơn thuốc -->
				<div>
				</div>
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
		        	console.log(table.row(this).data());
		        	$('#maPhieuKhamBenh').val(table.row(this).data()[0]);
		            $('#tenBenhNhan').val(table.row(this).data()[1]);
		            $('#lyDoKham').val(table.row(this).data()[6]);
		            $('#benhNhan').val(table.row(this).data()[7]);
		        });
		        
		        //submit form phieuDichVu
		        $('#phieuYeuCauDichVu').submit(function(){
		            alert("Submitted phiếu yêu cầu dịch vụ");
		            $("#btPhieuKhamBenh").submit();
		        });
		        $('#phieuKhamBenh').submit(function(){
		            alert("Submitted phiếu khám bệnh");
		        });
		    });
			function themDichVu() {
			 	var rowCount = $('#tb_ThemDichVu').length;
			 	var table = document.getElementById("tb_ThemDichVu");
			    var row = table.insertRow(rowCount);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			  
			    var contentcell1 = "<div class='col-sm-10'><select name = 'dichVuSel' id ="+ "dichVu" + rowCount + 
			    " class='form-control' onChange = 'changeDichVuSel(this)'>"
			    +" <c:forEach items='${dsDichVu}' var='dv'>"
			    +"<option value='${dv.maDichVu}' data-othervalue ='${dv.donGia}' >${dv.tenDichVu}</option></c:forEach></select></div>"
			    +"<input type=hidden id=donGiaTemp" + rowCount + " />";
			    cell1.innerHTML = contentcell1;
			    
			    var contentcell2 = "<p id = "+"phongKham" + rowCount + "></p>";
			  	cell2.innerHTML = contentcell2;
			  	console.log(contentcell2);
			  	
			  	var contentcell3 = "<p id = "+"donGia" + rowCount + "></p>";
			    cell3.innerHTML = contentcell3;
			    
			  	var contentcell4 = "<div class='col-sm-10'><input type='button' value =  'Xóa' class='btn btn-default'></input></div>";
			    cell4.innerHTML = contentcell4; 
			}
		 
		 function themDonThuoc() {
				var rowCount = $('#tb_ThemDonThuoc').length;
			 	var table = document.getElementById("tb_ThemDonThuoc");
			    var row = table.insertRow(rowCount);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			    var cell5 = row.insertCell(4);
			    var cell6 = row.insertCell(5);
			    var cell7 = row.insertCell(6);
			  
			    // tam thoi chua co thuocService
			    var contentcell1 = "<div class='col-sm-10'><select  class='form-control' onChange = 'changeDichVuSel()'> <c:forEach items='${dsDichVu}' var='dv'><option value='${dv.maDichVu}'>${dv.tenDichVu}</option></c:forEach></select></div>";
			    cell1.innerHTML = contentcell1;
			    
			    var contentcell2 = "<input class='form-control' type = 'number'  min = 0  />";
			  	cell2.innerHTML = contentcell2;
			  	
			  	var contentcell3 = "<input class='form-control' type = 'number'  min = 0  />";
			  	cell3.innerHTML = contentcell3;
			    
			  	var contentcell4 = "<input class='form-control' type = 'number'  min = 0  />";
			  	cell4.innerHTML = contentcell4;
			  	
			  	var contentcell5 = "<input class='form-control' type = 'number'  min = 0  />";
			  	cell5.innerHTML = contentcell5;
			  	
			 	var contentcell6 = "<input class='form-control' type = 'number'  min = 0  />";
			  	cell6.innerHTML = contentcell6;
			  	
			  	var contentcell7 = "<div class='col-sm-10'><input type='button' value =  'Xóa' class='btn btn-default'></input></div>";
			    cell7.innerHTML = contentcell7; 
		 }
		 function changeDichVuSel(elementCur){
			var index = elementCur.id.substring(6);
			var phongKham = $('#phongKham' + index);
			phongKham.text("abc");
			var donGia = $('#donGia' + index);
			var maDichVu = elementCur.options[elementCur.selectedIndex].value;
			// set modelAttribute phieuYeuCauDichVu
			$('#dichVu').val(maDichVu);
			$('#phieuKham').val($('#maPhieuKhamBenh').val());
			// get don gia temp trong attribut data-othervalue
			var donGiaTemp = $('#dichVu' + index).find('option:selected').attr('data-othervalue');
			
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
	</script>
</body>
</html>
