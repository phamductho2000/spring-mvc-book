<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>Admincast bootstrap 4 &amp; angular 5 admin template, Шаблон админки | Login</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/bootstrap/dist/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/font-awesome/css/font-awesome.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/themify-icons/css/themify-icons.css'/>">
    <!-- THEME STYLES-->
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/css/main.min.css'/>">
    <!-- PAGE LEVEL STYLES-->
    <link href="<c:url value='/resources/admin/assets/css/pages/auth-light.css'/>" rel="stylesheet" />
</head>

<body class="bg-silver-300">
<div class="content">
    <div class="brand">
        <p>QUẢN TRỊ HỆ THỐNG</p>
    </div>
    <form id="login-form" action="/admin/j_spring_security_check" method="post">
        <h2 class="login-title">Log in</h2>
        <c:if test="${accessDenied != null}">
            <div class="alert alert-danger">
               ${accessDenied}
            </div>
        </c:if>
        <c:if test="${param.incorrectAccount != null}">
            <div class="alert alert-danger">
                Tài khoản hoặc mật khẩu không đúng
            </div>
        </c:if>
        <div class="form-group">
            <div class="input-group-icon right">
                <div class="input-icon"><i class="fa fa-envelope"></i></div>
                <input class="form-control" type="text" name="j_username" placeholder="username" autocomplete="off">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group-icon right">
                <div class="input-icon"><i class="fa fa-lock font-16"></i></div>
                <input class="form-control" type="password" name="j_password" placeholder="Password">
            </div>
        </div>
        <div class="form-group d-flex justify-content-between">
            <label class="ui-checkbox ui-checkbox-info">
                <input type="checkbox" name="remember-me">
                <span class="input-span"></span>Remember me</label>
            <a href="forgot_password.html">Forgot password?</a>
        </div>
        <div class="form-group">
            <button class="btn btn-info btn-block" type="submit">Login</button>
        </div>
<%--        <div class="social-auth-hr">--%>
<%--            <span>Or login with</span>--%>
<%--        </div>--%>
<%--        <div class="text-center social-auth m-b-20">--%>
<%--            <a class="btn btn-social-icon btn-twitter m-r-5" href="javascript:;"><i class="fa fa-twitter"></i></a>--%>
<%--            <a class="btn btn-social-icon btn-facebook m-r-5" href="javascript:;"><i class="fa fa-facebook"></i></a>--%>
<%--            <a class="btn btn-social-icon btn-google m-r-5" href="javascript:;"><i class="fa fa-google-plus"></i></a>--%>
<%--            <a class="btn btn-social-icon btn-linkedin m-r-5" href="javascript:;"><i class="fa fa-linkedin"></i></a>--%>
<%--            <a class="btn btn-social-icon btn-vk" href="javascript:;"><i class="fa fa-vk"></i></a>--%>
<%--        </div>--%>
<%--        <div class="text-center">Not a member?--%>
<%--            <a class="color-blue" href="register.html">Create accaunt</a>--%>
<%--        </div>--%>
    </form>
</div>
<!-- BEGIN PAGA BACKDROPS-->
<div class="sidenav-backdrop backdrop"></div>
<div class="preloader-backdrop">
    <div class="page-preloader">Loading</div>
</div>
<!-- END PAGA BACKDROPS-->
<!-- CORE PLUGINS -->
<script src="<c:url value='/resources/admin/assets/vendors/jquery/dist/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/popper.js/dist/umd/popper.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/bootstrap/dist/js/bootstrap.min.js'/>"></script>
<!-- PAGE LEVEL PLUGINS -->
<script src="<c:url value='/resources/admin/assets/vendors/jquery-validation/dist/jquery.validate.min.js'/>" type="text/javascript"></script>
<!-- CORE SCRIPTS-->
<script src="<c:url value='/resources/admin/assets/js/app.js'/>" type="text/javascript"></script>
<!-- PAGE LEVEL SCRIPTS-->
<script type="text/javascript">
    $(function() {
        $('#login-form').validate({
            errorClass: "help-block",
            rules: {
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true
                }
            },
            highlight: function(e) {
                $(e).closest(".form-group").addClass("has-error")
            },
            unhighlight: function(e) {
                $(e).closest(".form-group").removeClass("has-error")
            },
        });
    });
</script>
</body>

</html>