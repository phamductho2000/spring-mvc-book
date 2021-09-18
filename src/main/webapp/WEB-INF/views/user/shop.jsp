<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<main class="main" id="main_shop">
    <nav aria-label="breadcrumb" class="breadcrumb-nav mb-2" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <div class="toolbox">
                        <span style="margin-right: 1rem">Sắp xếp theo</span>
                        <button class="button-sort" id="sortFeature" onclick="sortProduct('sort_feature')">Bán chạy</button>
                        <button class="button-sort" id="sortNew" onclick="sortProduct('sort_new')">Mới về</button>
                        <button class="button-sort" id="sortDiscount" onclick="sortProduct('sort_discount')">Khuyến mãi</button>
                        <button class="button-sort" id="sortDesPrice" onclick="sortProduct('sort_des_price')">Giá giảm dần</button>
                        <button class="button-sort" id="sortAscPrice" onclick="sortProduct('sort_asc_price')">Giá tăng dần</button>
                    </div><!-- End .toolbox -->

                    <div class="products mb-3">
                        <div class="row justify-content-center">
                            <c:forEach var="item" items="${listBook}">
                            <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product product-7 text-center">
                                    <figure class="product-media">
                                        <a href="/${item.name}/id=${item.id}">
                                            <img src="/resources/book_images/${item.image}" alt="Product image" class="product-image">
                                        </a>

                                        <div class="product-action-vertical">
                                            <a href="#" onclick="addToWishlist(${item.id})" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                            <a href="/xem-nhanh/id=${item.id}" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                        </div><!-- End .product-action-vertical -->

                                        <div class="product-action">
                                            <button class="btn-product btn-cart addCart" onclick="addToCart(${item.id})"><span>Thêm giỏ hàng</span></button>
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
                </div><!-- End .col-lg-9 -->
                <aside class="col-lg-3 order-lg-first">
                    <div class="sidebar sidebar-shop">
                        <div class="widget widget-clean">
                            <label>Lọc theo:</label>
                        </div><!-- End .widget widget-clean -->

                        <div class="widget widget-collapsible">
                            <h3 class="widget-title">
                                <a data-toggle="collapse" href="#widget-1" role="button" aria-expanded="true" aria-controls="widget-1">
                                    Nhà xuất bản
                                </a>
                            </h3><!-- End .widget-title -->

                            <div class="collapse show" id="widget-1">
                                <div class="widget-body">
                                    <div class="filter-items filter-items-count">
                                        <c:forEach var="item" items="${listPublisher}">
                                        <div class="filter-item">
                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" name="checkBoxPub" id="${item.id}" value="${item.id}">
                                                <label class="custom-control-label" for="${item.id}">${item.name}</label>
                                            </div><!-- End .custom-checkbox -->
                                        </div><!-- End .filter-item -->
                                        </c:forEach>
                                    </div><!-- End .filter-items -->
                                </div><!-- End .widget-body -->
                            </div><!-- End .collapse -->
                        </div><!-- End .widget -->

                        <div class="widget widget-collapsible">
                            <h3 class="widget-title">
                                <a data-toggle="collapse" href="#widget-5" role="button" aria-expanded="true" aria-controls="widget-5">
                                    Giá
                                </a>
                            </h3><!-- End .widget-title -->

                            <div class="collapse show" id="widget-5">
                                <div class="widget-body">
                                    <div class="filter-price">
                                        <div class="filter-price-text">
                                           Chọn khoảng giá:
                                            <div class="input-group">
                                                <input type="number" pattern="[0-9]*" id="startMoney" class="input-price">
                                                <span style="margin: 0 5px"> - </span>
                                                <input type="number" pattern="[0-9]*" id="endMoney"class="input-price">
                                            </div>
                                        </div><!-- End .filter-price-text -->
                                        <button type="button" class="btn btn-outline-primary" onclick="searchByMoney()">Áp dụng</button>
                                    </div><!-- End .filter-price -->
                                </div><!-- End .widget-body -->
                            </div><!-- End .collapse -->
                        </div><!-- End .widget -->
                    </div><!-- End .sidebar sidebar-shop -->
                </aside><!-- End .col-lg-3 -->
            </div><!-- End .row -->
        </div><!-- End .container -->
    </div><!-- End .page-content -->
</main><!-- End .main -->
