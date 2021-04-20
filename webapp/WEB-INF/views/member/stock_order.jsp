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
			text-align:center;
		}
		
		body {
			margin:0px;
			padding:0px;
		}
		
		.card-body {
			margin:auto;
			width:500px;
		}
		
		td {padding:8px 14px}
		
		tr {border:1px solid #eee}
		
		table td:nth-of-type(1){ width:90px; }
		table td:nth-of-type(2){ width:150px; }
	</style>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
	
		// 주문 목록에서 체크된 목록 삭제 
		function orderList(){
			var orderList = new Array();
			$('input[type=checkbox]:checked').each(function(){
				orderList.push($(this).val());
			});
			
			alert(orderList);
			$.ajax({
				url : '/BasketDelete',
				type : 'POST',
				data : {orderList: orderList},
				success : function(){
					alert('삭제완료!');
					location.href = "/StockOrderPage";
				},
				error : function(){
					alert('실패');
				}
			})
		} // delete end 
	
		// 주문 완료 
		// 페이지에 있는 모든 재고 목록 배열에 담아서 컨트롤러 전송
		function orderEnd(){
			var orderList = new Array();
			$('#tbody tr').each(function(i,tr){
				var obj = new Object();
				obj.idx = $('td', tr).eq(0).text();
				obj.name = $('td', tr).eq(1).text();
				obj.code = $('td', tr).eq(2).text();
				obj.price = $('td', tr).eq(3).text();
				obj.quantity = $('td', tr).eq(4).text();
				obj.market = $('td', tr).eq(5).text();
				obj.member_num = ${login.member_num};
				orderList.push(obj);
			})
			
			if(orderList.length == 0){
				alert('주문할 목록이 없습니다.');
				return false;	
			}
			
			
			$.ajax({
				url : '/OrderEnd',
				type : 'POST',
				data : {arr: orderList},
				success : function(){
					alert('주문이 완료되었습니다.');
					self.close();
				},
				error : function(){
					alert('주문 실패');
				}
			})
			
		} // orderEnd end
	</script>
	
</head>

<body>


  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">주문 목록 </h1>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">
		<c:forEach var="list" items="${orderList}">
        <div class="row1">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <div class="card-body">
                <table>
                <tr>
                	<td>체크</td>
                	<td>상품명</td>
                	<td>코드</td>
                	<td>가격</td>
                	<td>수량</td>
                	<td>거래처</td>
                </tr>
                <tbody id="tbody">
                <tr>
                	<td><input type="checkbox" id="check" value="${list.idx }"/>${list.idx}</td>
                	<td>${list.name}</td>
                	<td>${list.code}</td>
                	<td>${list.price }</td>
                	<td contenteditable='true'>0</td>
                	<td>${list.market }</td>
                </tr>
                </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
		</c:forEach>
			<div class="orderbar">
         		<input type="submit" id="order" onclick="javascript:orderEnd();"value="주문하기"/>
         		<!-- <input type="submit" onclick="javascript:orderEnd();"value="주문하기"/> -->
         		<input type="submit" onclick="javascript:orderList();"value="삭제"/>
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
