<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="css/styles.css" rel="stylesheet" />
        <style>
        	tbody tr:hover {
        	background: orange;
        	}
        </style>
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://kit.fontawesome.com/64d4054a0c.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
         <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script>
        
        // 시작과 함께
        $(document).ready(function(){
    		getTableList();
    		getBasket();
    	}); // ready end 
    	
    	// 주문 페이지 이동 
    	function order(){
    		window.open('/StockOrderPage', '주문화면', 'width=650, height=800');
    	} // order end 
        
    	// 장바구니 목록 (obj)에 저장 
        function getBasket(){
    		$.ajax({
    			url : '/OrderBasket',
    			success : function(obj){
    				getBasketCallback(obj);
    			},
    			error : function(){
    				alert('실패');
    			}
    		})
    	} // getBasket end
    	
    	// 장바구니 콜백 (obj)저장된 리시트 length 출력 
    	function getBasketCallback(obj){
    		var list = obj;
    		var listlen = obj.length;
    		$('.basketList').html('주문(' + listlen + ')');
    	} //getBasketCallback end
	
	
    	// 5개 미만의 재고 목록 
 	function getTableList(){
 		var member_num = ${login.member_num};
		$.ajax({
			url : "/LowQuantity",
			type : "POST",
			data : {member_num: member_num },
			success : function(obj){
				getTableListCallback(obj);
			},
			error : function(xnr, status, error){
				alert('실패 :' + status + error);
			}
		}) 
	
	
 	} // getTableList() end
 	

	// 재고 알람 콜백 
	function getTableListCallback(obj){
		var list = obj;
		var listlen = obj.length;
		
		var str = "";
		
		if(listlen > 0){
			for (var a = 0; a < listlen; a++) {
				var idx = list[a].idx;
				var code = list[a].code;
				var name = list[a].name;
				var price = list[a].price;
				var quantity = list[a].quantity;
				var market = list[a].market;
				
				str += "<tr>";
/* 				str += "<td><input type='checkbox' name='check' class='order' value='"+ idx + "'></td>"; */
				str += "<td><input type='button' id='basket' value='담기'></td>";
				str += "<td>" + idx + "</td>";
				str += "<td>" + code + "</td>";
				str += "<td>" + name + "</td>";
				str += "<td>" + price + "</td>";
				str += "<td>" + quantity + "</td>";
				str += "<td>" + market + "</td>";
				str += "</tr>";
			}
		}else{
			str += "<tr>";
			str += "<td colspan='6'>없다인마</td>";
			str += "</tr>";
		}
		$('#tbody').html(str);			
	} //getTableListCallback(obj) end
	
	// 체크 박스 한번에 체크 
	$(function(){
		$('#allCheck').click(function(){
			if($('#allCheck').prop('checked')){
				$('input[type=checkbox]').prop('checked',true);
			}else{
				$('input[type=checkbox]').prop('checked',false);
			}
		})
	})

	// '담기' 클릭시 그 행의 정보를 컨트롤러에 보내 저장 
	$(document).on('click', '#basket', function(){
		var Arr = new Array();
		var basketBtn = $(this);
		var tr = basketBtn.parent().parent();
		var td = tr.children();
		
		var idx = td.eq(1).text();	
		var code = td.eq(2).text();	
		var name = td.eq(3).text();
		var price = td.eq(4).text();
		var market = td.eq(6).text();
		var member_num = ${login.member_num};
		$.ajax({
			url : '/StockBasket',
			type : 'POST',
			data : {idx: idx, code: code, name: name, price: price, market: market,
				member_num: member_num},
			success : function(){
				alert('담겼습니다');
				location.reload();
			},
			error : function(){
				alert('실패');
			}
		})
	}) // basket insert end
		
</script>
    </head>
    <body class="sb-nav-fixed">
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">빨리 시켜주세요</h1>
                        <div class="card mb-4">
                            <div class="card-body">
                              <a href="/StockOrderPage"><i class="fas fa-box-open"></i><span class="basketList"></span></a>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                재고
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>주문</th>
                                                <th>번호</th>
                                                <th>상품코드</th>
                                                <th>상품명</th>
                                                <th>가격</th>
                                                <th>수량</th>
                                                <th>거래처</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th></th>
                                                <th>번호</th>
                                                <th>상품코드</th>
                                                <th>상품명</th>
                                                <th>가격</th>
                                                <th>수량</th>
                                                <th>거래처</th>
                                            </tr>
                                        </tfoot>
                                        
                                        <tbody id="tbody">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>
