<%@ page import="com.webbansach.dto.CartDTO" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.webbansach.util.SecurityUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%  HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>)session.getAttribute("Cart"); %>

<main class="main" id="main_cart">
    <nav aria-label="breadcrumb" class="breadcrumb-nav" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Shopping Cart</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content" >
        <div class="cart">
            <div class="container">
                <c:if test="${message != null}">
                    <div class="alert alert-primary alert-dismissible fade show" role="alert">
                        <strong>Áp dụng thành công!</strong> ${message}.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <% if (cart == null || cart.size() == 0) { %>
                <p style="text-align: center">KHÔNG CÓ SẢN PHẨM NÀO TRONG GIỎ HÀNG</p>
                    <br>
                <a href="/trang-chu" class="btn btn-primary">QUAY LẠI TRANG CHỦ</a>
                <% } else { %>
                <div class="row">
                    <div class="col-lg-9">
                        <table class="table table-cart table-mobile">
                            <thead>
                            <tr>
                                <th>Sản phẩm</th>
                                <th>Giá</th>
                                <th>Số lượng</th>
                                <th>Tổng tiền</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${Cart}">
                                <tr>
                                    <td id="idProduct" hidden="true">${item.value.book.id}</td>
                                    <td class="product-col">
                                        <div class="product">
                                            <figure class="product-media">
                                                <a href="#">
                                                    <img src="/resources/book_images/${item.value.book.image}" alt="Product image">
                                                </a>
                                            </figure>
                                            <p class="">
                                                <a href="/${item.value.book.name}/id=${item.value.book.id}">${item.value.book.name}</a>
                                            </p><!-- End .product-title -->
                                        </div><!-- End .product -->
                                    </td>
                                    <td class="price-col">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.book.price}"/> ₫
                                    </td>
                                    <td class="quantity-col">
                                        <div class="cart-product-quantity">
                                            <input type="number" id="quanty" class="form-control" value="${item.value.quanty}" min="1" max="10" step="1" data-decimals="0" required>
                                        </div><!-- End .cart-product-quantity -->
                                    </td>
                                    <td class="total-col">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${item.value.totalPrice}"/> ₫
                                    </td>
                                    <td class="remove-col">
                                        <button onclick="removeItemCart(${item.value.book.id})" style="background: none; border: none;"><i class="icon-close" style="color: red"></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table><!-- End .table table-wishlist -->

                        <div class="cart-bottom">
                            <div class="cart-discount">
                                <form action="#">
                                    <div class="input-group">
                                        <input type="text" class="form-control" required placeholder="NHẬP MÃ GIẢM GIÁ" id="voucher">
                                        <div class="input-group-append">
                                            <button class="btn btn-outline-primary-2" id="btnApplyVoucher" type="button" onclick="applyVoucher()"><i class="icon-long-arrow-right"></i></button>
                                            <a href="/huy-voucher" class="btn btn-outline-primary-2" id="btnDisableVoucher" style="display:none;"><i class="icon-close"></i></a>
                                        </div><!-- .End .input-group-append -->
                                    </div><!-- End .input-group -->
                                </form>
                            </div><!-- End .cart-discount -->
                            <button onclick="updateCart()" class="btn btn-outline-dark-2"><span>CẬP NHẬT GIỎ HÀNG</span><i class="icon-refresh"></i></button>
                        </div><!-- End .cart-bottom -->
                    </div><!-- End .col-lg-9 -->
                    <aside class="col-lg-3">

                        <div class="summary summary-cart">
                            <div>
                                <span style="color: black">Giao tới</span>
                                <a href="/tai-khoan/thong-tin" style="float: right">Thay đổi</a>
                            </div>
                            <div>
                                <input type="hidden" name="userId" value="<%= SecurityUtils.getPrincipal().getId() %>">
                                <span class="nameUser" style="color: black"><%= SecurityUtils.getPrincipal().getFullName() %></span>
                                <span style="color: black"><%= SecurityUtils.getPrincipal().getPhone() %></span>
                            </div>
                            <div>
                                <p><%= SecurityUtils.getPrincipal().getAddress() %></p>
                            </div>
                        </div>

                        <div class="summary summary-cart">
                            <table class="table table-summary">
                                <tbody>
                                <tr class="summary-subtotal">
                                    <td style="border: none">Tạm tính:</td>
                                    <td style="border: none">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice}"/> ₫
                                    </td>
                                </tr><!-- End .summary-subtotal -->
                                <tr class="summary-subtotal">
                                    <td>Giảm giá:</td>
                                    <c:if test="${discount == null}">
                                        <td>
                                            0 ₫
                                        </td>
                                    </c:if>
                                    <c:if test="${discount != null}">
                                        <td>
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${discount}"/> ₫
                                        </td>
                                    </c:if>
                                </tr><!-- End .summary-subtotal -->

                                <tr class="summary-total">
                                    <td>Tổng:</td>
                                    <c:if test="${discount == null}">
                                        <td id="totalPrice">
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice}"/> ₫
                                        </td>
                                    </c:if>
                                    <c:if test="${discount != null}">
                                        <td id="totalPrice">
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice - discount}"/> ₫
                                        </td>
                                    </c:if>
                                </tr><!-- End .summary-total -->
                                </tbody>
                            </table><!-- End .table table-summary -->

                            <a href="/thanh-toan" class="btn btn-outline-primary-2 btn-order btn-block">TIẾN HÀNH ĐẶT HÀNG</a>
                        </div><!-- End .summary -->

                        <a href="/trang-chu" class="btn btn-outline-dark-2 btn-block mb-3"><span>TIẾP TỤC MUA SẮM</span><i class="icon-refresh"></i></a>
                    </aside><!-- End .col-lg-3 -->
                </div><!-- End .row -->
                <% } %>

            </div><!-- End .container -->
        </div><!-- End .cart -->
    </div><!-- End .page-content -->
</main><!-- End .main -->
