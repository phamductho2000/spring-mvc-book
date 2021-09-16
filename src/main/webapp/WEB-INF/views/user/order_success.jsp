<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Order</a></li>
                <li class="breadcrumb-item active" aria-current="page">Success</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->
    <div class="error-content text-center" >
        <div class="container">
            <i class="fa fa-check-circle" style="text-align: center; font-size: 40px; color: #28a745"></i>
            <h3 class="error-title">ĐẶT HÀNG THÀNH CÔNG</h3>
            <table class="table table-cart table-mobile">
                <thead class="thead-light">
                <tr>
                    <th scope="col">Sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Thành tiền</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listCart}">
                    <tr>
                        <td>${item.book.name}</td>
                        <td>${item.quanty}</td>
                        <td>
                            <fmt:formatNumber type="number" groupingUsed="true" value="${item.totalPrice}"/> ₫
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td style="border-bottom: none"></td>
                    <td style="text-align: right; border-bottom: none">TỔNG</td>
                    <td style="text-align: right; border-bottom: none">
                        <fmt:formatNumber type="number" groupingUsed="true" value="${totalPrice}"/> ₫
                    </td>
                </tr>
                </tbody>
            </table>
            <a href="/trang-chu" class="btn btn-outline-primary-2 btn-minwidth-lg" style="margin-bottom: 20px">
                <span>TRỞ VỀ TRANG CHỦ</span>
                <i class="icon-long-arrow-right"></i>
            </a>
        </div><!-- End .container -->
    </div><!-- End .error-content text-center -->
</main><!-- End .main -->