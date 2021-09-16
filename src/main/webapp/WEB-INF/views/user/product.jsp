<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0" style="background: #dee2e6">
        <div class="container d-flex align-items-center">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/trang-chu">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Product</a></li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content" >
        <div class="container">
            <div class="product-details-top">
                <div class="row">
                    <div class="col-md-6">
                        <div class="product-gallery product-gallery-vertical">
                            <figure class="product-main-image">
                                <img src="/resources/book_images/${book.image}" data-zoom-image="assets/images/products/single/1-big.jpg" alt="product image">

<%--                                    <a href="#" id="btn-product-gallery" class="btn-product-gallery">--%>
<%--                                        <i class="icon-arrows"></i>--%>
<%--                                    </a>--%>
                            </figure><!-- End .product-main-image -->
                        </div><!-- End .product-gallery -->
                    </div><!-- End .col-md-6 -->

                    <div class="col-md-6">
                        <div>
                            <p style="font-size: 20px;">${book.name}</p><!-- End .product-title -->

                            <div class="ratings-container">
                                <div class="ratings">
                                    <div class="ratings-val" style="width: ${book.rate * 20}%;"></div><!-- End .ratings-val -->
                                </div><!-- End .ratings -->
                                <a class="ratings-text" href="#product-review-link" id="review-link">( ${lstReviews.size()} Reviews )</a>
                            </div><!-- End .rating-container -->

                            <c:if test="${book.discount == 0}">
                                <div class="product-price">
                                    <div class="new-price">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${book.oldPrice}"/> ₫
                                    </div>
                                </div><!-- End .product-price -->
                            </c:if>
                            <c:if test="${book.discount > 0}">
                                <div class="product-price">
                                    <div class="new-price">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${book.price}"/> ₫
                                    </div>
                                    <div class="old-price" style="margin-right: .8rem">
                                        <fmt:formatNumber type="number" groupingUsed="true" value="${book.oldPrice}"/> ₫
                                    </div>
                                    <div class="discount-price" style="font-size: 13px; color: rgb(125, 210, 235)">
                                            ${book.discount}%
                                    </div>
                                </div><!-- End .product-price -->
                            </c:if>
                            <div class="product-content" style="margin-bottom: 20px">
                                <p>${book.shortDes}</p>
                            </div><!-- End .product-content -->

                            <div class="details-filter-row details-row-size">
                                <label for="qtyProduct">Số lượng:</label>
                                <div class="product-details-quantity">
                                    <input type="number" id="qtyProduct" class="form-control" value="1" min="1" step="1" data-decimals="0" required>
                                </div><!-- End .product-details-quantity -->
                            </div><!-- End .details-filter-row -->

                            <div class="product-details-action">
                                <a href="#" class="btn-product btn-cart" onclick="addToCart(${book.id})"><span>Thêm giỏ hàng</span></a>
                                <div class="details-action-wrapper">
                                    <a href="#" class="btn-product btn-wishlist" title="Wishlist"><span>Add to Wishlist</span></a>
                                </div><!-- End .details-action-wrapper -->
                            </div><!-- End .product-details-action -->

                            <div class="product-details-footer">
                                <div class="product-cat">
                                    <span>Thể loại:</span>
                                    <a href="#">${book.nameCategory}</a>,
                                </div><!-- End .product-cat -->

                                <div class="social-icons social-icons-sm">
                                    <span class="social-label">Share:</span>
                                    <a href="#" class="social-icon" title="Facebook" target="_blank"><i class="icon-facebook-f"></i></a>
                                    <a href="#" class="social-icon" title="Twitter" target="_blank"><i class="icon-twitter"></i></a>
                                    <a href="#" class="social-icon" title="Instagram" target="_blank"><i class="icon-instagram"></i></a>
                                    <a href="#" class="social-icon" title="Pinterest" target="_blank"><i class="icon-pinterest"></i></a>
                                </div>
                            </div><!-- End .product-details-footer -->
                        </div><!-- End .product-details -->
                    </div><!-- End .col-md-6 -->
                </div><!-- End .row -->
            </div><!-- End .product-details-top -->

            <div class="product-details-tab">
                <ul class="nav nav-pills justify-content-center" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="product-desc-link" data-toggle="tab" href="#product-desc-tab" role="tab" aria-controls="product-desc-tab" aria-selected="true">Mô tả sản phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="product-info-link" data-toggle="tab" href="#product-info-tab" role="tab" aria-controls="product-info-tab" aria-selected="false">Thông tin chi tiết</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="product-review-link" data-toggle="tab" href="#product-review-tab" role="tab" aria-controls="product-review-tab" aria-selected="false">Đánh giá (${lstReviews.size()})</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="product-desc-tab" role="tabpanel" aria-labelledby="product-desc-link">
                        <div class="product-desc-content">
                            ${book.description}
                        </div><!-- End .product-desc-content -->
                    </div><!-- .End .tab-pane -->
                    <div class="tab-pane fade" id="product-info-tab" role="tabpanel" aria-labelledby="product-info-link">
                        <div class="product-desc-content">
                            <h3>Thông tin chi tiết</h3>
                            <ul>
                                <li>Ngày xuất bản : 	</li>
                                <li>Kích thước : ${book.size}</li>
                                <li>Số trang : ${book.page}</li>
                                <li>Trọng lượng : ${book.weight}</li>
                            </ul>
                        </div><!-- End .product-desc-content -->
                    </div><!-- .End .tab-pane -->
                    <div class="tab-pane fade" id="product-review-tab" role="tabpanel" aria-labelledby="product-review-link">
                        <div class="reviews">
                            <c:if test="${lstReviews.size() == 0}">
                                <p style="text-align: center; font-size: 20px">Chưa có nhận xét đánh giá nào về sản phẩm này</p>
                            </c:if>
                            <c:if test="${lstReviews.size() != 0}">
                                <h3>Đánh giá (${lstReviews.size()})</h3>
                                <c:forEach var="item" items="${lstReviews}">
                                    <div class="review">
                                        <div class="row no-gutters">
                                            <div class="col-auto">
                                                <h4><a href="#">${item.userName}</a></h4>
                                                <div class="ratings-container">
                                                    <div class="ratings">
                                                        <div class="ratings-val" style="width: 80%;"></div><!-- End .ratings-val -->
                                                    </div><!-- End .ratings -->
                                                </div><!-- End .rating-container -->
                                                <span class="review-date">
                                             <c:set value="${item.updated_date}" var="dateString" />
                                             <fmt:parseDate value="${dateString}" var="dateObject" pattern="yyyy-MM-dd HH:mm:ss" />
                                             <p>Nhận xét vào <fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></p>
                                        </span>
                                            </div><!-- End .col -->
                                            <div class="col">
                                                <h4>Good, perfect size</h4>

                                                <div class="review-content">
                                                    <p>${item.content}</p>
                                                </div><!-- End .review-content -->

                                                <div class="review-action">
                                                    <a href="#"><i class="icon-thumbs-up"></i>Helpful (2)</a>
                                                    <a href="#"><i class="icon-thumbs-down"></i>Unhelpful (0)</a>
                                                </div><!-- End .review-action -->
                                            </div><!-- End .col-auto -->
                                        </div><!-- End .row -->
                                    </div><!-- End .review -->
                                </c:forEach>
                            </c:if>
                        </div><!-- End .reviews -->
                    </div><!-- .End .tab-pane -->
                </div><!-- End .tab-content -->
            </div><!-- End .product-details-tab -->

            <h2 class="title text-center mb-4">Sản phẩm cùng thể loại</h2><!-- End .title text-center -->

            <div class="owl-carousel owl-simple carousel-equal-height carousel-with-shadow" data-toggle="owl"
                 data-owl-options='{
                            "nav": false,
                            "dots": true,
                            "margin": 20,
                            "loop": false,
                            "responsive": {
                                "0": {
                                    "items":1
                                },
                                "480": {
                                    "items":2
                                },
                                "768": {
                                    "items":3
                                },
                                "992": {
                                    "items":4
                                },
                                "1200": {
                                    "items":4,
                                    "nav": true,
                                    "dots": false
                                }
                            }
                        }'>

                <c:forEach var="item" items="${listBook}">
                    <div class="product product-7 text-center">
                        <figure class="product-media">
                            <span class="product-label label-new">New</span>
                            <a href="/${item.name}/id=${item.id}">
                                <img src="/resources/book_images/${item.image}" alt="Product image" class="product-image">
                            </a>

                            <div class="product-action-vertical">
                                <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                <a href="/xem-nhanh/id=${item.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                            </div><!-- End .product-action-vertical -->

<%--                            <div class="product-action">--%>
<%--                                <a href="#" class="btn-product btn-cart" onclick="addToCart(${item.id})"><span>thêm giỏ hàng</span></a>--%>
<%--                            </div><!-- End .product-action -->--%>
                        </figure><!-- End .product-media -->

                        <div class="product-body">
                            <h3 class="product-title"><a href="/${item.name}/id=${item.id}">${item.name}</a></h3><!-- End .product-title -->
                            <div class="product-price">
                                <c:if test="${item.discount == 0}">
                                    <div class="product-price">
                                        <div class="new-price">
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${item.oldPrice}"/> ₫
                                        </div>
                                    </div><!-- End .product-price -->
                                </c:if>
                                <c:if test="${item.discount > 0}">
                                    <div class="product-price">
                                        <div class="new-price">
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/> ₫
                                        </div>
                                    </div><!-- End .product-price -->
                                    <div class="product-price">
                                        <div class="old-price" style="margin-right: .8rem">
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${item.oldPrice}"/>₫
                                        </div>
                                        <div class="discount-price" style="font-size: 13px; color: rgb(125, 210, 235)">
                                                ${item.discount}%
                                        </div>
                                    </div><!-- End .product-price -->
                                </c:if>
                            </div><!-- End .product-price -->
                        </div><!-- End .product-body -->
                    </div><!-- End .product -->
                </c:forEach>
            </div><!-- End .owl-carousel -->
        </div><!-- End .container -->
    </div><!-- End .page-content -->
</main><!-- End .main -->