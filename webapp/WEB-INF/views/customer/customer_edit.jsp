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
        <title>거래처 목록</title>
        <link href="css/styles.css" rel="stylesheet" />
        <link href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" rel="stylesheet" crossorigin="anonymous" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <style>
        	tbody tr:hover {
        	background: orange;
        	}
        	        	.bell1 {
        		padding: 0px 24px;
        		font-size: 17px;
        		color:white;
        	}
        </style>

        <script>
        // 화면 시작시 
        $(document).ready(function(){
        	getCustomerList();
        	getBasket();
    	}); // ready end
        
        
		// 주문 페이지 
	function order(){
		window.open('/StockOrderPage', '주문화면', 'width=650, height=800');
	} // order end
    	
	// 재고 알람 페이지 이동 
	function alarm(){
		window.open('/StockAlarm', '재고알람', 'width=950, height=800');
	} // alarm end
    	
    	// 장바구니 
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
    	
    	function getBasketCallback(obj){
    		var list = obj;
    		var listlen = obj.length;
    		$('.basketList').html('주문(' + listlen + ')');
    	} // getBasketCallback end
        

         // 테이블에 새로운 줄 추가 
    	 function addRow() {
		const table = document.getElementById('dataTable');
		
		//새 행 추가
		const newRow = table.insertRow();
		
		//새 행에 cell 추가
		const newCell1 = newRow.insertCell(0);
		const newCell2 = newRow.insertCell(1);
		const newCell3 = newRow.insertCell(2);
		const newCell4 = newRow.insertCell(3);
		const newCell5 = newRow.insertCell(4);
		const newCell6 = newRow.insertCell(5);
		const newCell7 = newRow.insertCell(6);
		
		//Cell 에 텍스트 추가
		 newCell1.innerHTML = '';
		 newCell2.innerHTML = '';
		 newCell3.innerHTML = '<input type="text" id="it" name="customer_it"/>';
		 newCell4.innerHTML = '<input type="text" id="name" name="customer_name"/>';
		 newCell5.innerHTML = '<input type="text" id="tel" name="customer_tel"/>';
		 newCell6.innerHTML = '<input type="text" id="email" name="customer_email"/>';
		 newCell7.innerHTML = '<input type="text" id="remarks" name="customer_remarks"/>';
     } // addRow() end
	
	
	// 거래처 등록 
	function insertCustomer(){
		var it = $("#customer_it").val();
		var name = $("#customer_name").val();
		var tel = $("#customer_tel").val();
		var email = $("#customer_email").val();
		var remarks = $("#customer_remarks").val();
		
		var yn = confirm("등록");
		if(yn){
			$.ajax({
				url : "/CustomerInsert",
				data : $('#boardForm').serialize(),
				type: 'POST',
				success : function(){
					getCustomerList();
				},
				error : function(xnr, status, error){
					alert('에러 :' + status + error);
				}
			})
		}
	}  // inserboard end
	
	// 거래처 리스트 가져오기 
 	function getCustomerList(){
 		var member_num = ${login.member_num};
		$.ajax({
			url : "/ListCustomer",
			type : "POST",
			data : {member_num: member_num },
			success : function(obj){
				getCustomerListCallback(obj);
			},
			error : function(xnr, status, error){
				alert('실패 :' + status + error);
			}
		}) 
	
	
 	} // getTableList() end
 	
 	
 	


	function getCustomerListCallback(obj){
		var list = obj;
		var listlen = obj.length;
		var str = "";
		
		if(listlen > 0){
			for (var a = 0; a < listlen; a++) {
				var idx = list[a].idx;
				var it = list[a].customer_it;
				var name = list[a].customer_name;
				var tel = list[a].customer_tel;
				var email = list[a].customer_email;
				var remarks = list[a].customer_remarks;
				
				str += "<tr>";
				str += "<td><input type='checkbox' name='check' id='check' value='" + idx + "'/></td>";
				str += "<td contenteditable='true'>" + idx + "</td>";
				str += "<td contenteditable='true'>" + it + "</td>";
				str += "<td contenteditable='true'>" + name + "</td>";
				str += "<td contenteditable='true'>" + tel + "</td>";
				str += "<td contenteditable='true'>" + email + "</td>";
				str += "<td contenteditable='true'>" + remarks + "</td>";
				str += "</tr>";
			}
		}else{
			str += "<tr>";
			str += "<td colspan='6'>없다인마</td>";
			str += "</tr>";
		}
		$('#tbody').html(str);			
	} //getTableListCallback(obj) end
	
	//체크 박스 
	$(function(){
		$('#allCheck').click(function(){
			if($('#allCheck').prop('checked')){
				$('input[type=checkbox]').prop('checked',true);
			}else{
				$('input[type=checkbox]').prop('checked',false);
			}
		})
	}) // allCheck end 
	
	// 거래처 삭제 
	function deleteCustomer(){
		var checkArr = new Array;
		var member_num = ${login.member_num};
		var member_email = '${login.member_email}';
		$('input[name=check]:checked').each(function(){
			 checkArr.push($(this).val()); 
			alert(checkArr);
		});
		
		$.ajax({
			url : '/CustomerDelete',
			type : 'POST',
			data : {checkArr: checkArr, member_num: member_num, member_email: member_email},
			success : function(){
				alert('성공');
				getCustomerList();
			},
			error : function(xnr, status, error){
				alert('실패 :' + status + error);
			}
		})
	} // deleteCustomer
	
	// 거래처 수정 
$(document).on('click', '#CustomerUpdate', function(){
		
		var tdArr = new Array();
		var Arr = [];
	
		// 현재 클릭된  Row(<tr>)
				
		$('#boardForm tbody tr').each(function(index, tr) {
			var prod = new Object();
		    prod.idx  = $('td', tr).eq(1).text();
		    prod.it  = $('td', tr).eq(2).text();
		    prod.name  = $('td', tr).eq(3).text();
		    prod.tel  = $('td', tr).eq(4).text();
		    prod.email  = $('td', tr).eq(5).text();
		    prod.remarks  = $('td', tr).eq(6).text();
		    prod.member_num  = ${login.member_num}
		    tdArr.push(prod);
		});
	   
	   $.ajax({
		   url : '/CostomerUpdate',
		   dataType : 'JSON',
		   data : { arr : tdArr},
		   type : 'POST',
		   success : function(){
			   alert('수정되었습니다!');
			   getCustomerList();
		   },
		   error : function(){
			   getCustomerList();
		   }
	   })
		
	});  // update end 

	
	
</script>
    </head>
    <body class="sb-nav-fixed">
         <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="/MEMBERHOME">재고관리 홈페이지</a>
            <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
            </form>
            <!-- Navbar-->
<a class="bell1" href="javascript:alarm();"><i class="fas fa-bell"></i>재고알람</a><a style="color:white;"href="javascript:order();"><i class="fas fa-box-open"></i><span class="basketList"></span></a>
            <ul class="navbar-nav ml-auto ml-md-0">
                <li class="nav-item dropdown">
<a class="nav-link dropdown-toggle" id="userDropdown" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${login.member_name }<svg class="svg-inline--fa fa-user fa-w-14 fa-fw" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="user" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg=""><path fill="currentColor" d="M224 256c70.7 0 128-57.3 128-128S294.7 0 224 0 96 57.3 96 128s57.3 128 128 128zm89.6 32h-16.7c-22.2 10.2-46.9 16-72.9 16s-50.6-5.8-72.9-16h-16.7C60.2 288 0 348.2 0 422.4V464c0 26.5 21.5 48 48 48h352c26.5 0 48-21.5 48-48v-41.6c0-74.2-60.2-134.4-134.4-134.4z"></path></svg><!-- <i class="fas fa-user fa-fw"></i> Font Awesome fontawesome.com --></a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                        <a class="dropdown-item" href="/Member/Information">내정보</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/logout">로그아웃</a>
                    </div>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">HOME</div>
                             <a class="nav-link" href="/MEMBERHOME">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                재고관리
                            </a> 
                            <div class="sb-sidenav-menu-heading">거래처</div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                거래처
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="/CustomerList">거래처 확인</a>
                                    <a class="nav-link" href="/CustomerEdit">거래처 수정</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                입출고
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                                <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-parent="#sidenavAccordion">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="/CountInCount">입고</a>
                                            <a class="nav-link" href="/CountOutCount">출고</a>
                                            <a class="nav-link" href="/CountInOutCount">입출고 확인</a>
                                        </nav>
                                    </div>
                            <div class="sb-sidenav-menu-heading">고객센터</div>
                            <a class="nav-link" href="/MBoard/List">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                1:1문의
                            </a>
                            <a class="nav-link">
                                <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                                고객센터 1577-1577
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">우리조</div>
                        화이팅
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">거래처 수정</h1>
                        <div class="card mb-4">
                            <div class="card-body">
                           <a href="/CustomerList">거래처 확인</a> &nbsp; &nbsp; <a href="/CustomerEdit">거래처 수정</a>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table mr-1"></i>
                                수정
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                <form id="boardForm" name="boardForm">
                                <input type="hidden" name="member_num" value="${login.member_num }"/>
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>번호</th>
                                                <th>분류</th>
                                                <th>거래처명</th>
                                                <th>연락처</th>
                                                <th>이메일</th>
                                                <th>비고</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th><input type="checkbox" id="allCheck" /></th>
                                                <th>번호</th>
                                                <th>분류</th>
                                                <th>거래처명</th>
                                                <th>연락처</th>
                                                <th>이메일</th>
                                                <th>비고</th>
                                                
                                            </tr>
                                        </tfoot>
                                        <tbody id="tbody">
                                           
                                        </tbody>
                                    </table>
                                    </form>
                                    
                                    <input type="button" onclick='addRow()' value="추가"/>
                                    <input type="submit" onclick="javascript:insertCustomer();" value="확인"/>
                                    <input type="submit" onclick="javascript:deleteCustomer();" value="삭제" />
                                    <input type="button" id="CustomerUpdate" value="수정" />
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2020</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/datatables-demo.js"></script>
    </body>
</html>
