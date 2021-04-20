<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name회원정보"author" content="" />
        <title>회원정보</title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">회원정보</h3></div>
                                    <div class="card-body">
                                        <form action="/Member/Update" method="POST">
                                            <div class="form-row">
                                                
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                    	<input type="hidden" name="member_num" value="${login.member_num}"/>
                                                        <label class="small mb-1" for="member_name">이름</label>
                                                        <input class="form-control py-4" id="member_name" name="member_name" type="text" value="${login.member_name }" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="member_email">이메일</label>
                                                <input readonly class="form-control py-4" id="member_email" name="member_email" type="email" aria-describedby="emailHelp" value="${login.member_email }" />
                                            </div>
                                            <div class="form-row">
                                                
                                            </div>
                                            <div class="form-group mt-4 mb-0"><input class="btn btn-primary btn-block" type="submit" value="수정"/></div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small" style="display:inline"><a href="/MEMBERHOME">홈으로</a></div>&nbsp;&nbsp;&nbsp;
                                        <div class="small" style="display:inline"><a href="/MemberPassword">비밀번호 변경</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
