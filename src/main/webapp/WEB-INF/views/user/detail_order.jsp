<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Account</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->
    <div class="page-content">
        <div class="dashboard">
            <div class="container">

                        <div class="ibox invoice main-account ">
                            <div class="invoice-header">
                                <h3>Chi tiết đơn hàng #${Order.id}</h3>
                                <div>
                                    <p style="text-align: end; margin-bottom: 10px">
                                        <c:set value="${Order.created_date}" var="dateString" />
                                        <fmt:parseDate value="${dateString}" var="dateObject"
                                                       pattern="yyyy-MM-dd HH:mm:ss" />
                                        Ngày đặt hàng:
                                        <fmt:formatDate value="${dateObject }" pattern="hh:mm" /></b>
                                        <fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></b>
                                    </p>
                                </div>
                                <div style="display: flex; justify-content: space-between">
                                    <div>
                                        <p style="font-size: 15px">Địa chỉ người nhận</p>
                                        <div class="infoCustomer">
                                            <p style="font-weight: 700">${Order.user_name}</p>
                                            <p>Địa chỉ: ${Order.user_address}</p>
                                            <p>Điện thoại: ${Order.user_phone}</p>
                                        </div>
                                    </div>
                                    <div>
                                        <p style="font-size: 15px">Hình thức giao hàng</p>
                                        <div class="infoCustomer">
                                            <p>
                                                <img src="https://salt.tikicdn.com/ts/upload/2a/47/46/0e038f5927f3af308b4500e5b243bcf6.png" width="56" alt="TikiFast" >
                                                Giao hàng tiết kiệm
                                            </p>
                                            <p>Miễn phí vận chuyển</p>
                                        </div>
                                    </div>
                                   <div>
                                       <p style="font-size: 15px">Hình thức thanh toán</p>
                                       <div class="infoCustomer">
                                           <p>Thanh toán bằng tiền mặt</p>
                                       </div>
                                   </div>
                                </div>
                            </div>
                            <table class="table" >
                                <thead>
                                <tr>
                                    <th>Sản phẩm</th>
                                    <th>Số lượng</th>
                                    <th>Đơn giá</th>
                                    <th>Thành tiền</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${listDetailOrder}">
                                    <tr>
                                        <td style="width: 70%">
                                            <div class="product-item" style="display: flex">
                                            <img src="/resources/book_images/${item.imgBook}" id="imgProduct" width="80px" height="60px" style="display: inline-block">
                                            <div class="product-info">
                                                <div>
                                                    <a href="/${item.bookName}/id=${item.book_id }" id="nameProduct">${item.bookName}</a>
                                                </div>
                                                <br>
                                                <a href="#" class="button-sort" onclick="showReviewProduct('${item.book_id}', '${item.bookName}', '${item.imgBook}')">Viết nhận xét</a>
                                            </div>
                                            </div>
                                        </td>
                                        <td>${item.quantity}</td>
                                        <td><fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/> ₫</td>
                                        <td style="color: #007bff"><fmt:formatNumber type="number" groupingUsed="true" value="${item.total}"/> ₫</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <table class="table no-border">
                                <tbody>
                                <tr class="text-right">
                                    <td>TẠM TÍNH:</td>
                                    <td><fmt:formatNumber type="number" groupingUsed="true" value="${Order.total_price - 30000}"/> ₫</td>
                                </tr>
                                <tr class="text-right">
                                    <td>Phí vận chuyển:</td>
                                    <td><fmt:formatNumber type="number" groupingUsed="true" value="30000"/> ₫</td>
                                </tr>
                                <tr class="text-right">
                                    <td><b>TỔNG:</b></td>
                                    <td><b><fmt:formatNumber type="number" groupingUsed="true" value="${Order.total_price}"/> ₫</b></td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="container-review" id="reviewProduct"  style="position:fixed ;z-index: 99; display: none; background: rgba(36, 36, 36, 0.5); width: 100%; height: 100%; top: 0; right: 0; left: 0">
                                <div class="review-product" style="border-radius: 4px; padding: 16px; position: absolute; background: white; width: 605px; top: 50%; left: 50%;  transform: translate(-50%, -50%)">
                                    <div class="review-close">
                                        <i class="fa fa-close" onclick="closeReviewProduct()" style="float: right; cursor: pointer"></i>
                                    </div>
                                    <div class="reivew-content">
                                        <div class="review-product-info">
                                            <input type="hidden" id="idProduct">
                                            <img src="" width="40px" height="40px" style="border-radius: 50%; display: inline-block">
                                            <span class="product-title"></span>
                                        </div>
                                        <div class="review-rate" style="text-align: center">
                                            <p>Vui lòng đánh giá</p>
                                            <div class="rate">
                                                <input type="radio" id="star5" name="rate" value="5" />
                                                <label for="star5" title="text">5 stars</label>
                                                <input type="radio" id="star4" name="rate" value="4" />
                                                <label for="star4" title="text">4 stars</label>
                                                <input type="radio" id="star3" name="rate" value="3" />
                                                <label for="star3" title="text">3 stars</label>
                                                <input type="radio" id="star2" name="rate" value="2" />
                                                <label for="star2" title="text">2 stars</label>
                                                <input type="radio" id="star1" name="rate" value="1" />
                                                <label for="star1" title="text">1 star</label>
                                            </div>
                                        </div>
                                        <textarea rows="8" cols="72" id="contentReivew" style="border-radius: 4px; padding: 12px" placeholder="Vui lòng chia sẻ thêm thông tin sản phẩm"></textarea>
                                        <div class="list-image-review" id="list-image-review" style="display: flex; justify-content: flex-start">

                                        </div>
                                        <div style="display: flex; justify-content: space-around">
                                            <label for="inputImgReviewProduct" class="btn btn-primary">Thêm ảnh</label>
                                            <input id="inputImgReviewProduct" type="file" hidden="true">
                                            <button type="button" class="btn btn-primary" onclick="sendReviewProduct()">Gửi đánh giá</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

            </div><!-- End .container -->
        </div><!-- End .dashboard -->
    </div><!-- End .page-content -->
</main>
<style>
    .invoice {
        padding: 20px
    }

    .invoice-header {
        margin-bottom: 50px
    }

    .invoice-logo {
        margin-bottom: 50px;
    }

    .table-invoice tr td:last-child {
        text-align: right;
    }
</style>

