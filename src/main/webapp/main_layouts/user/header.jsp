<%@ page import="com.webbansach.dto.CartDTO" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ page import = "com.webbansach.util.SecurityUtils"%>
<%  HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart"); %>

<header class="header header-8" id="header_user">
    <div class="header-top">
        <div class="container">
            <div class="header-left">
                <ul class="top-menu">
                    <li>
                        <a href="#">Links</a>
                        <ul>
                            <li><a href="tel:#"><i class="icon-phone"></i>${contact.phone}</a></li>
                            <li><a href=""><i class="fa fa-envelope-o"></i>${contact.email}</a></li>
                        </ul>
                    </li>
                </ul><!-- End .top-menu -->
            </div>
            <div class="header-right">
                <ul class="top-menu">
                    <li>
                        <a href="#">Links</a>
                        <ul>
                            <sec:authorize access="isAuthenticated()">
                            <li>
                                <a>
                                    Xin chào <%= SecurityUtils.getPrincipal().getFullName() %>
                                </a>
                            </li>
                            </sec:authorize>
                        </ul>
                    </li>
                </ul><!-- End .top-menu -->
            </div><!-- End .header-right -->
        </div><!-- End .container -->
    </div><!-- End .header-top -->

    <div class="header-middle sticky-header">
        <div class="container">
            <div class="header-left">
                <button class="mobile-menu-toggler">
                    <span class="sr-only">Toggle mobile menu</span>
                    <i class="icon-bars"></i>
                </button>

                <a href="" class="logo">
                    <img src="/resources/user/assets/images/logo.png" width="105px" height="25px">
                </a>
            </div><!-- End .header-left -->

            <div class="header-right">
                <nav class="main-nav">
                    <ul class="menu sf-arrows">
                        <li class="megamenu-container active">
                            <a href="/trang-chu" >Trang chủ</a>
                        </li>
                        <li>
                            <a href="#" class="sf-with-ul">Sách</a>
                            <ul>
                                <c:forEach var="item" items="${menu}">
                                <li class="custom-link">
                                    <a href="/${item.name}/${item.id}?page=1&limit=16" class="linkMenu">${item.name}</a>
                                </li>
                                </c:forEach>
                            </ul>
                        </li>
                        <li>
                            <a href="/lien-he" class="sf-with-ul">Liên hệ</a>
                        </li>
                    </ul><!-- End .menu -->
                </nav><!-- End .main-nav -->

                <div class="header-search">
                    <a id="btnSearch" class="search-toggle" style="border: none; background: none" ><i class="icon-search"></i></a>
                    <form action="/tim-kiem" method="GET" id="formSearch">
                        <div class="header-search-wrapper">
                            <label for="q" class="sr-only">Search</label>
                            <input type="search" class="form-control" name="key" id="q" placeholder="Tìm kiếm..." required>
                        </div><!-- End .header-search-wrapper -->
                    </form>
                </div><!-- End .header-search -->

                <sec:authorize access="isAnonymous()">
                    <div style="padding-top: 1.2rem; padding-left: 2.5rem;">
                        <a href="#signin-modal" data-toggle="modal">
                            <i class="fa fa-user-circle" style="font-size: 2.2rem; color: #435d7a;"></i>
                        </a>
                    </div>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <div class="dropdown user-dropdown" style="padding-top: 1.2rem; padding-left: 2.5rem;">

                        <a aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-user-circle" style="font-size: 2.2rem; color: #435d7a;"></i>
                        </a>

                        <div class="dropdown-menu" style="width: 200px; font-size: 1.3rem; border-radius: 10px; margin: .125rem -5rem;">
                            <a class="dropdown-item" href="/tai-khoan/thong-tin">Tài khoản</a>
                            <a class="dropdown-item" href="/tai-khoan/don-hang">Lịch sử mua hàng</a>
                            <a class="dropdown-item" href="/tai-khoan/yeu-thich">Yêu thích</a>
                            <a class="dropdown-item" href="/dang-xuat">Đăng xuất</a>
                        </div>
                    </div>
                </sec:authorize>

                <div class="dropdown cart-dropdown" id="cart_dropdown">
                    <a href="/gio-hang" class="dropdown-toggle" role="button" >
                        <i class="icon-shopping-cart"></i>
                        <% if (cart == null) { %>
                            <span class="cart-count">0</span>
                        <% } else { %>
                            <span class="cart-count">${Cart.size()}</span>
                        <% } %>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <% if (cart == null || cart.size() == 0) { %>
                            <div class="dropdown-cart-products">
                                <div class="product">
                                    <p>Chưa có sản phẩm nào trong giỏ hàng</p>
                                </div>
                            </div>
                        <% } else { %>
                            <c:forEach var="item" items="${Cart}">
                                <div class="dropdown-cart-products">
                                    <div class="product">
                                        <div class="product-cart-details">
                                            <h4 class="product-title">
                                                <a href="product.html">${item.value.book.name}</a>
                                            </h4>
                                            <span class="cart-product-info">
                                                <span class="cart-product-qty">${item.value.quanty}</span>
                                                x <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.book.price}"/> ₫
                                            </span>
                                        </div><!-- End .product-cart-details -->
                                        <figure class="product-image-container">
                                            <a href="product.html" class="product-image">
                                                <img src="/resources/book_images/${item.value.book.image}" alt="product">
                                            </a>
                                        </figure>
                                        <a href="#" onclick="removeItemCartDropDown(${item.value.book.image})" class="btn-remove" title="Remove Product"><i class="icon-close"></i></a>
                                    </div><!-- End .product -->
                                </div><!-- End .cart-product -->
                            </c:forEach>
                            <div class="dropdown-cart-total">
                                        <span>TỔNG</span>
                                        <span class="cart-total-price"><fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice}"/> ₫</span>
                            </div><!-- End .dropdown-cart-total -->

                            <div class="dropdown-cart-action">
                                        <a href="/gio-hang" class="btn btn-primary" style="width: 100%">XEM GIỎ HÀNG VÀ THANH TOÁN</a>
                            </div><!-- End .dropdown-cart-total -->
                        <% } %>
                    </div><!-- End .dropdown-menu -->
                </div><!-- End .cart-dropdown -->
            </div><!-- End .header-right -->
        </div><!-- End .container -->
    </div><!-- End .header-middle -->
</header><!-- End .header -->

<!-- Sign in / Register Modal -->
<div class="modal fade" id="signin-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true"><i class="icon-close"></i></span>
                </button>

                <div class="form-box">
                    <div class="form-tab">
                        <ul class="nav nav-pills nav-fill nav-border-anim" role="tablist">
                            <li class="nav-item">
                                    <a class="nav-link active" id="signin-tab" data-toggle="tab" href="#signin" role="tab" aria-controls="signin" aria-selected="true">ĐĂNG NHẬP</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="register-tab" data-toggle="tab" href="#register" role="tab" aria-controls="register" aria-selected="false">ĐĂNG KÝ</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="tab-content-5">
                            <br>
                                <div class="alert alert-danger" id="alertLoginFail" style="display: none">
                                    Tài khoản hoặc mật khẩu không đúng
                                </div>
                            <div class="tab-pane fade show active" id="signin" role="tabpanel" aria-labelledby="signin-tab">
                                <form action="/j_spring_security_check" method="post" id="formLogin">
                                    <div class="form-group">
                                        <label for="singin-username">Tài khoản</label>
                                        <input type="text" class="form-control" id="singin-username" name="j_username" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="singin-password">Mật khẩu</label>
                                        <input type="password" class="form-control" id="singin-password" name="j_password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="button" id="submitLogin" class="btn btn-outline-primary-2">
                                            <span>ĐĂNG NHẬP</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="signin-remember" name="remember-me">
                                            <label class="custom-control-label" for="signin-remember">Remember Me</label>
                                        </div><!-- End .custom-checkbox -->

                                        <a href="/forgot-password" class="forgot-link">Quên mật khẩu?</a>
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">hoặc đăng nhập với</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
                            <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">
                                <form action="/dang-ky" method="post">
                                    <div class="form-group">
                                        <label for="register-user">Nhập tài khoản *</label>
                                        <input type="text" class="form-control" id="register-user" name="register-user" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-group">
                                        <label for="register-password">Nhập mật khẩu *</label>
                                        <input type="password" class="form-control" id="register-password" name="register-password" required>
                                    </div><!-- End .form-group -->

                                    <div class="form-footer">
                                        <button type="submit" class="btn btn-outline-primary-2">
                                            <span>ĐĂNG KÝ</span>
                                            <i class="icon-long-arrow-right"></i>
                                        </button>

                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" class="custom-control-input" id="register-policy" required>
                                            <label class="custom-control-label" for="register-policy">I agree to the <a href="#">privacy policy</a> *</label>
                                        </div><!-- End .custom-checkbox -->
                                    </div><!-- End .form-footer -->
                                </form>
                                <div class="form-choice">
                                    <p class="text-center">hoặc đăng nhập với</p>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login btn-g">
                                                <i class="icon-google"></i>
                                                Login With Google
                                            </a>
                                        </div><!-- End .col-6 -->
                                        <div class="col-sm-6">
                                            <a href="#" class="btn btn-login  btn-f">
                                                <i class="icon-facebook-f"></i>
                                                Login With Facebook
                                            </a>
                                        </div><!-- End .col-6 -->
                                    </div><!-- End .row -->
                                </div><!-- End .form-choice -->
                            </div><!-- .End .tab-pane -->
                        </div><!-- End .tab-content -->
                    </div><!-- End .form-tab -->
                </div><!-- End .form-box -->
            </div><!-- End .modal-body -->
        </div><!-- End .modal-content -->
    </div><!-- End .modal-dialog -->
</div><!-- End .modal -->

</head>
