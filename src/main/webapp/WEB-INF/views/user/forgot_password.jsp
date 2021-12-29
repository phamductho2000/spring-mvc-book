<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active" aria-current="page">Forgot password</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17" style="background-image: url('assets/images/backgrounds/login-bg.jpg')">
        <div class="container">
            <div class="form-box">
                <div class="form-tab">
                    <h3>Forgot Password</h3>
                    <form action="/forgot-password" id="formForgotPassword" method="post">
                        <c:if test="${message != null}">
                            <div>
                                <p>${message}</p>
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="emailReset">Email address</label>
                            <input type="email" class="form-control" name="emailReset" id="emailReset">
                        </div>

                        <div style="text-align: center">
                            <button type="submit" class="btn btn-outline-primary-2">SEND</button>
                        </div>
                    </form>
                </div><!-- End .form-tab -->
            </div><!-- End .form-box -->
        </div><!-- End .container -->
    </div><!-- End .login-page section-bg -->
</main><!-- End .main -->
