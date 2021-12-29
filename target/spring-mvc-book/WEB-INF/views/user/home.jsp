<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<main class="main">
    <div class="container">
        <div class="intro-slider-container slider-container-ratio mb-2">
            <div class="intro-slider owl-carousel owl-simple owl-light owl-nav-inside" data-toggle="owl" data-owl-options='{"nav": false}'>
                <div class="intro-slide">
                    <figure class="slide-image">
                        <picture>
                            <source media="(max-width: 480px)" srcset="assets/images/demos/demo-10/slider/slide-1-480w.jpg">
                            <img src="assets/images/demos/demo-10/slider/slide-1.jpg" alt="Image Desc">
                        </picture>
                    </figure><!-- End .slide-image -->

                    <div class="intro-content">
                        <h3 class="intro-subtitle">Deals and Promotions</h3><!-- End .h3 intro-subtitle -->
                        <h1 class="intro-title text-white">Sneakers & Athletic Shoes</h1><!-- End .intro-title -->

                        <div class="intro-price text-white">from $9.99</div><!-- End .intro-price -->

                        <a href="category.html" class="btn btn-white-primary btn-round">
                            <span>SHOP NOW</span>
                            <i class="icon-long-arrow-right"></i>
                        </a>
                    </div><!-- End .intro-content -->
                </div><!-- End .intro-slide -->

                <div class="intro-slide">
                    <figure class="slide-image">
                        <picture>
                            <source media="(max-width: 480px)" >
                            <img src="/resources/book_images/inaki-del-olmo-NIJuEQw0RKg-unsplash.png" alt="Image Desc">
                        </picture>
                    </figure><!-- End .slide-image -->

                    <div class="intro-content">
                        <h3 class="intro-subtitle">Trending Now</h3><!-- End .h3 intro-subtitle -->
                        <h1 class="intro-title text-white">This Week's Most Wanted</h1><!-- End .intro-title -->

                        <div class="intro-price text-white">from $49.99</div><!-- End .intro-price -->

                        <a href="category.html" class="btn btn-white-primary btn-round">
                            <span>SHOP NOW</span>
                            <i class="icon-long-arrow-right"></i>
                        </a>
                    </div><!-- End .intro-content -->
                </div><!-- End .intro-slide -->

                <div class="intro-slide">
                    <figure class="slide-image">
                        <picture>
                            <source media="(max-width: 480px)" srcset="assets/images/demos/demo-10/slider/slide-3-480w.jpg">
                            <img src="assets/images/demos/demo-10/slider/slide-3.jpg" alt="Image Desc">
                        </picture>
                    </figure><!-- End .slide-image -->

                    <div class="intro-content">
                        <h3 class="intro-subtitle text-white">Deals and Promotions</h3><!-- End .h3 intro-subtitle -->
                        <h1 class="intro-title text-white">Can’t-miss Clearance:</h1><!-- End .intro-title -->

                        <div class="intro-price text-white">starting at 60% off</div><!-- End .intro-price -->

                        <a href="category.html" class="btn btn-white-primary btn-round">
                            <span>SHOP NOW</span>
                            <i class="icon-long-arrow-right"></i>
                        </a>
                    </div><!-- End .intro-content -->
                </div><!-- End .intro-slide -->
            </div><!-- End .intro-slider owl-carousel owl-simple -->
            <span class="slider-loader"></span><!-- End .slider-loader -->
        </div><!-- End .intro-slider-container -->
    </div><!-- End .container -->

    <div class="icon-boxes-container icon-boxes-separator bg-transparent">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-lg-3">
                    <div class="icon-box icon-box-side">
                        <span class="icon-box-icon text-primary">
                            <i class="icon-rocket"></i>
                        </span>
                        <div class="icon-box-content">
                            <h3 class="icon-box-title">Free Shipping</h3><!-- End .icon-box-title -->
                            <p>Orders $50 or more</p>
                        </div><!-- End .icon-box-content -->
                    </div><!-- End .icon-box -->
                </div><!-- End .col-sm-6 col-lg-3 -->

                <div class="col-sm-6 col-lg-3">
                    <div class="icon-box icon-box-side">
                        <span class="icon-box-icon text-primary">
                            <i class="icon-rotate-left"></i>
                        </span>
                        <div class="icon-box-content">
                            <h3 class="icon-box-title">Free Returns</h3><!-- End .icon-box-title -->
                            <p>Within 30 days</p>
                        </div><!-- End .icon-box-content -->
                    </div><!-- End .icon-box -->
                </div><!-- End .col-sm-6 col-lg-3 -->

                <div class="col-sm-6 col-lg-3">
                    <div class="icon-box icon-box-side">
                        <span class="icon-box-icon text-primary">
                            <i class="icon-info-circle"></i>
                        </span>
                        <div class="icon-box-content">
                            <h3 class="icon-box-title">Get 20% Off 1 Item</h3><!-- End .icon-box-title -->
                            <p>when you sign up</p>
                        </div><!-- End .icon-box-content -->
                    </div><!-- End .icon-box -->
                </div><!-- End .col-sm-6 col-lg-3 -->

                <div class="col-sm-6 col-lg-3">
                    <div class="icon-box icon-box-side">
                        <span class="icon-box-icon text-primary">
                            <i class="icon-life-ring"></i>
                        </span>
                        <div class="icon-box-content">
                            <h3 class="icon-box-title">We Support</h3><!-- End .icon-box-title -->
                            <p>24/7 amazing services</p>
                        </div><!-- End .icon-box-content -->
                    </div><!-- End .icon-box -->
                </div><!-- End .col-sm-6 col-lg-3 -->
            </div><!-- End .row -->
        </div><!-- End .container -->
    </div><!-- End .icon-boxes-container -->

    <div class="bg-light pt-5 pb-10 mb-3">
        <div class="container">
            <div class="heading heading-center mb-3">
                <h2 class="title-lg">Sản phẩm mới về</h2><!-- End .title -->
            </div><!-- End .heading -->

            <div class="tab-content tab-content-carousel">
                <div class="tab-pane tab-pane-shadow p-0 fade show active" id="new-all-tab" role="tabpanel" aria-labelledby="new-all-link">
                    <div class="owl-carousel owl-simple carousel-equal-height" data-toggle="owl"
                         data-owl-options='{
                                    "nav": false,
                                    "dots": true,
                                    "margin": 0,
                                    "loop": false,
                                    "responsive": {
                                        "0": {
                                            "items":2
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
                                            "nav": true
                                        }
                                    }
                                }'>
                    <c:forEach var="item" items="${listBooksNew}">
                        <div class="product product-3 text-center">
                            <figure class="product-media">
                                <span class="product-label label-primary">New</span>
                                <a href="/${item.name}/id=${item.id}">
                                    <img src="/resources/book_images/${item.image}" alt="Product image" class="product-image">
                                </a>

                                <div class="product-action-vertical">
                                    <a href="#" onclick="addToWishlist(${item.id})" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                </div><!-- End .product-action-vertical -->
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

                            <div class="product-footer">
                                <div class="ratings-container">
                                    <div class="ratings">
                                        <div class="ratings-val" style="width: ${item.rate * 20}%;"></div><!-- End .ratings-val -->
                                    </div><!-- End .ratings -->
                                    <span class="ratings-text">( ${item.countReviews} Reviews )</span>
                                </div><!-- End .rating-container -->
                                <div class="product-action">
                                    <a href="#" class="btn-product btn-cart" onclick="addToCart(${item.id})"><span>thêm giỏ hàng</span></a>
                                    <a href="/xem-nhanh/id=${item.id}" class="btn-product btn-quickview"><span>quick view</span></a>
                                </div><!-- End .product-action -->
                            </div><!-- End .product-footer -->
                        </div><!-- End .product -->
                    </c:forEach>
                    </div><!-- End .owl-carousel -->
                </div><!-- .End .tab-pane -->
            </div>
        </div>
    </div>
    <div class="bg-light pt-5 pb-10 mb-3">
        <div class="container">
            <div class="heading heading-center mb-3">
                <h2 class="title-lg">Sản phẩm bán chạy</h2><!-- End .title -->
            </div><!-- End .heading -->
            <div class="tab-content tab-content-carousel">
                <div class="tab-pane tab-pane-shadow p-0 fade show active" id="new-all-tab" role="tabpanel" aria-labelledby="new-all-link">
                    <div class="owl-carousel owl-simple carousel-equal-height" data-toggle="owl"
                         data-owl-options='{
                                    "nav": false,
                                    "dots": true,
                                    "margin": 0,
                                    "loop": false,
                                    "responsive": {
                                        "0": {
                                            "items":2
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
                                            "nav": true
                                        }
                                    }
                                }'>
                        <c:forEach var="item" items="${listBooksFeature}">
                            <div class="product product-3 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-secondary">Hot</span>
                                    <a href="/${item.name}/id=${item.id}">
                                        <img src="/resources/book_images/${item.image}" alt="Product image" class="product-image">
                                    </a>

                                    <div class="product-action-vertical">
                                        <a href="#" onclick="addToWishlist(${item.id})" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                    </div><!-- End .product-action-vertical -->
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
                                                    <fmt:formatNumber type="number" groupingUsed="true" value="${item.oldPrice}"/> ₫
                                                </div>
                                                <div class="discount-price" style="font-size: 13px; color: rgb(125, 210, 235)">
                                                    ${item.discount}%
                                                </div>
                                            </div><!-- End .product-price -->
                                        </c:if>
                                    </div><!-- End .product-price -->
                                </div><!-- End .product-body -->

                                <div class="product-footer">
                                    <div class="ratings-container">
                                        <div class="ratings">
                                            <div class="ratings-val" style="width: ${item.rate * 20}%;"></div><!-- End .ratings-val -->
                                        </div><!-- End .ratings -->
                                        <span class="ratings-text">( ${item.countReviews} Reviews )</span>
                                    </div><!-- End .rating-container -->
                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart" onclick="addToCart(${item.id})"><span>thêm giỏ hàng</span></a>
                                        <a href="/xem-nhanh/id=${item.id}" class="btn-product btn-quickview"><span>quick view</span></a>
                                    </div><!-- End .product-action -->
                                </div><!-- End .product-footer -->
                            </div><!-- End .product -->
                        </c:forEach>
                    </div><!-- End .owl-carousel -->
                </div><!-- .End .tab-pane -->
            </div>
        </div>
    </div>
    <div class="container">
        <div class="heading heading-center mb-3">
            <h2 class="title-lg mb-2">Sản phẩm giảm sâu</h2><!-- End .title-lg text-center -->
        </div><!-- End .heading -->

        <div class="tab-content">
            <div class="tab-pane p-0 fade show active" id="top-all-tab" role="tabpanel" aria-labelledby="top-all-link">
                <div class="products just-action-icons-sm">
                    <div class="row">
                        <c:forEach var="item" items="${listBooksTopSell}">
                        <div class="col-6 col-md-4 col-lg-3 col-xl-5col">
                            <div class="product product-3 text-center">
                                <figure class="product-media">
                                    <span class="product-label label-primary">Sale</span>
                                    <span class="product-label label-sale">${item.discount}% off</span>
                                    <a href="/${item.name}/id=${item.id}">
                                        <img src="/resources/book_images/${item.image}" alt="Product image" class="product-image">
                                    </a>
                                    <div class="product-action-vertical">
                                        <a href="#" onclick="addToWishlist(${item.id})" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                    </div><!-- End .product-action-vertical -->
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
                                                    <fmt:formatNumber type="number" groupingUsed="true" value="${item.oldPrice}"/> ₫
                                                </div>
                                                <div class="discount-price" style="font-size: 13px; color: rgb(125, 210, 235)">
                                                    ${item.discount}%
                                                </div>
                                            </div><!-- End .product-price -->
                                        </c:if>
                                    </div><!-- End .product-price -->
                                </div><!-- End .product-body -->

                                <div class="product-footer">
                                    <div class="ratings-container">
                                        <div class="ratings">
                                            <div class="ratings-val" style="width: ${item.rate * 20}%;"></div><!-- End .ratings-val -->
                                        </div><!-- End .ratings -->
                                        <span class="ratings-text">( ${item.countReviews} Reviews )</span>
                                    </div><!-- End .rating-container -->

                                    <div class="product-action">
                                        <a href="#" class="btn-product btn-cart" title="Add to cart" onclick="addToCart(${item.id})"><span>thêm giỏ hàng</span></a>
                                        <a href="/xem-nhanh/id=${item.id}" class="btn-product btn-quickview" title="Quick view"><span>quick view</span></a>
                                    </div><!-- End .product-action -->
                                </div><!-- End .product-footer -->
                            </div><!-- End .product -->
                        </div><!-- End .col-6 col-md-4 col-lg-3 -->
                        </c:forEach>
                    </div>
                </div>
            </div><!-- .End .tab-pane -->
        <div class="more-container text-center mt-5">
            <a href="#" class="btn btn-outline-lightgray btn-more btn-round"><span>Xem thêm</span><i class="icon-long-arrow-right"></i></a>
        </div><!-- End .more-container -->
    </div><!-- End .container -->
    </div>
</main><!-- End .main -->
