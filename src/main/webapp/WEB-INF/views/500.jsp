<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
  <body class="nav-md">    
    <div class="container body">
      <div class="main_container">
        <!-- page content -->
        <div class="col-md-12">
          <div class="col-middle">
            <div class="text-center">
              <h1 class="error-number">500</h1>
              <h2>Internal Server Error</h2>
              <p>${message }
              </p>
              
            </div>
          </div>
        </div>
        <!-- /page content -->
      </div>
    </div>
    
    <script src="resources/js/jquery.min.js"></script>
		
	<!-- Bootstrap -->
    <script src="resources/js/bootstrap.min.js"></script>    
    	
    <!-- Custom Theme Scripts -->
    <script src="resources/js/custom.js"></script>
    
  </body>
</html>
