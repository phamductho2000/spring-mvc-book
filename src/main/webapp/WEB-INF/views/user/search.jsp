<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav mb-2">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Search</a></li>
            </ol>
        </div><!-- End .container-fluid -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content">
        <div class="container-fluid">
            <div class="toolbox">
                <div class="toolbox-center">
                    <div class="toolbox-info">
                        Kết quả <span>16 of ${totalItem}</span> sản phẩm
                    </div><!-- End .toolbox-info -->
                </div><!-- End .toolbox-center -->
            </div><!-- End .toolbox -->

            <div class="products">
                <div class="row">
                    <c:forEach var="item" items="${listBook}">
                    <div class="col-6 col-md-4 col-lg-4 col-xl-3 col-xxl-2">
                        <div class="product">
                            <figure class="product-media">
                                <span class="product-label label-new">New</span>
                                <a href="/${item.name}/id=${item.id}">
                                    <img src="/resources/book_images/${item.image}" alt="Product image" class="product-image">
                                </a>

                                <div class="product-action-vertical">
                                    <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                </div><!-- End .product-action -->

                                <div class="product-action action-icon-top">
                                    <a href="#" class="btn-product btn-cart" onclick="addToCart(${item.id})"><span>thêm giỏ hàng</span></a>
                                    <a href="popup/quickView.html" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                                </div><!-- End .product-action -->
                            </figure><!-- End .product-media -->

                            <div class="product-body">
                                <p class="product-title" style="font-size: 13px"><a href="/${item.name}/id=${item.id}">${item.name}</a></p><!-- End .product-title -->
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
                                            <fmt:formatNumber type="number" groupingUsed="true" value="${item.oldPrice}"/> ₫
                                        </div>
                                        <div class="discount-price" style="font-size: 13px; color: rgb(125, 210, 235)">
                                                ${item.discount}%
                                        </div>
                                    </div><!-- End .product-price -->
                                </c:if>
                                <div class="ratings-container">
                                    <div class="ratings">
                                        <div class="ratings-val" style="width: ${item.rate * 20}%;"></div><!-- End .ratings-val -->
                                    </div><!-- End .ratings -->
                                    <span class="ratings-text">( ${item.countReviews} Reviews )</span>
                                </div><!-- End .rating-container -->
                            </div><!-- End .product-body -->
                        </div><!-- End .product -->
                    </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                    </c:forEach>
                </div><!-- End .row -->
            </div><!-- End .products -->
            <nav aria-label="page_navigation">
                <ul id="pagination" class="pagination-lg" style="float: right"></ul>
                <input hidden="true" id="totalPage" value="${totalPage}">
                <input hidden="true" id="currentPage" value="${currentPage}">
            </nav>
        </div><!-- End .container-fluid -->
    </div><!-- End .page-content -->
</main><!-- End .main -->