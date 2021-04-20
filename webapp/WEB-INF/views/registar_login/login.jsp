<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>로그인</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js" crossorigin="anonymous"></script>
         <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <script>
        $(document).ready(function(){
           $("#submit").on("click", function(){
            if($("#member_email").val()==""){
               alert("이메일을 입력해주세요.");
               $("#member_email").focus();
               return false;
            }
            if($("#member_pwd").val()==""){
               alert("비밀번호를 입력해주세요.");
               $("#member_pwd").focus();
               return false;
            }
            
         //   alert("로그인 성공!");
            return true;
            
         });
        })

        </script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-5">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">로그인</h3></div>
                                    <div class="card-body">
                                        <form action="/loginProcess" method="POST">
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputEmailAddress">이메일</label>
                                                <input class="form-control py-4" id="member_email" name="member_email" type="email" placeholder="이메일을 입력하세요" />
                                            </div>
                                            <div class="form-group">
                                                <label class="small mb-1" for="inputPassword">비밀번호</label>
                                                <input class="form-control py-4" id="member_pwd" name="member_pwd" type="password" placeholder="비밀번호를 입력하세요" />
                                            </div>
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox">
                                                    <input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" />
                                                    <label class="custom-control-label" for="rememberPasswordCheck">비밀번호 저장</label>
                                                </div>
                                            </div>
                                            <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                                <a class="small" href="password.html">비밀번호찾기</a>
                                                <input class="btn btn-primary" id="submit" type="submit" value="로그인"/>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="card-footer text-center">
                                        <div class="small"><a href="/MEMBER/REGISTER">회원가입 바로가기</a></div>
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
