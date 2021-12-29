<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active" aria-current="page">Change password</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17" style="background-image: url('assets/images/backgrounds/login-bg.jpg')">
        <div class="container">
            <div class="form-box">
                <div class="form-tab">
                    <h3>Change Password</h3>
                    <form action="/change-password" id="formChangePassword" method="post">
                       <c:if test="${token != null}">
                           <input type="hidden" name="token" value="${token}">
                       </c:if>
                        <c:if test="${message != null}">
                            <div class="alert alert-success" role="alert">
                                ${message}
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="new-password">New password</label>
                            <input type="password" class="form-control" id="new-password" name="new-password" >
                        </div><!-- End .form-group -->

                        <div class="form-group">
                            <label for="re-password">Confirm new password</label>
                            <input type="password" class="form-control" id="re-password" name="re-password" >
                        </div><!-- End .form-group -->

                        <div style="text-align: center">
                            <button type="submit" class="btn btn-outline-primary-2">CHANGE</button>
                        </div>
                    </form>
                </div><!-- End .form-tab -->
            </div><!-- End .form-box -->
        </div><!-- End .container -->
    </div><!-- End .login-page section-bg -->
</main><!-- End .main -->
