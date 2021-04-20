<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>주문</title>

  <!-- Bootstrap core CSS -->
  <link href="/style/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="/style/css/shop-homepage.css" rel="stylesheet">
	<style>
		.orderbar {
			margin:auto;
		}
		
		body {
			margin:0px;
			padding:0px;
		}
		
		.card-body {
			margin:auto;
			width:300px;
		}
	</style>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
/* 		function asdf(){
			alert('gd');
		} */
/* 		
		$(function(){
			var orderList = new Array();
			$('.click').on('click',function(){
				$('input[name=check]:checked').each(function(){
					alert($(this).val());
					orderList.put($(this).val());
				})
				
				alert(orderList);
			});
	}) */
	

	</script>
	
	
</head>

<body>


  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">주문 완료 </h1>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div class="row">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <div class="card-body">
                <h4 class="card-title">
                	주문이 완료되었습니다.
                </h4>
              </div>
            </div>
          </div>
        </div>
			<div class="orderbar">
         	</div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  <!-- Footer -->
	
  <!-- Bootstrap core JavaScript -->
  <script src="/style/vendor/jquery/jquery.min.js"></script>
  <script src="/style/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
