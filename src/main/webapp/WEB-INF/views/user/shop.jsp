<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tho20
  Date: 5/30/2021
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main class="main">
    <div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
        <div class="container">
            <h1 class="page-title">Grid 4 Columns<span>Shop</span></h1>
        </div><!-- End .container -->
    </div><!-- End .page-header -->
    <nav aria-label="breadcrumb" class="breadcrumb-nav mb-2">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Grid 4 Columns</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content">
        <div class="container">
            <div class="row">
                <div class="col-lg-9">
                    <div class="toolbox">
                        <div class="toolbox-left">
                            <div class="toolbox-info">
                                Showing <span>9 of 56</span> Products
                            </div><!-- End .toolbox-info -->
                        </div><!-- End .toolbox-left -->

                        <div class="toolbox-right">
                            <div class="toolbox-sort">
                                <label for="sortby">Sort by:</label>
                                <div class="select-custom">
                                    <select name="sortby" id="sortby" class="form-control">
                                        <option value="popularity" selected="selected">Most Popular</option>
                                        <option value="rating">Most Rated</option>
                                        <option value="date">Date</option>
                                    </select>
                                </div>
                            </div><!-- End .toolbox-sort -->
                            <div class="toolbox-layout">
                                <a href="category-list.html" class="btn-layout">
                                    <svg width="16" height="10">
                                        <rect x="0" y="0" width="4" height="4" />
                                        <rect x="6" y="0" width="10" height="4" />
                                        <rect x="0" y="6" width="4" height="4" />
                                        <rect x="6" y="6" width="10" height="4" />
                                    </svg>
                                </a>

                                <a href="category-2cols.html" class="btn-layout">
                                    <svg width="10" height="10">
                                        <rect x="0" y="0" width="4" height="4" />
                                        <rect x="6" y="0" width="4" height="4" />
                                        <rect x="0" y="6" width="4" height="4" />
                                        <rect x="6" y="6" width="4" height="4" />
                                    </svg>
                                </a>

                                <a href="category.html" class="btn-layout">
                                    <svg width="16" height="10">
                                        <rect x="0" y="0" width="4" height="4" />
                                        <rect x="6" y="0" width="4" height="4" />
                                        <rect x="12" y="0" width="4" height="4" />
                                        <rect x="0" y="6" width="4" height="4" />
                                        <rect x="6" y="6" width="4" height="4" />
                                        <rect x="12" y="6" width="4" height="4" />
                                    </svg>
                                </a>

                                <a href="category-4cols.html" class="btn-layout active">
                                    <svg width="22" height="10">
                                        <rect x="0" y="0" width="4" height="4" />
                                        <rect x="6" y="0" width="4" height="4" />
                                        <rect x="12" y="0" width="4" height="4" />
                                        <rect x="18" y="0" width="4" height="4" />
                                        <rect x="0" y="6" width="4" height="4" />
                                        <rect x="6" y="6" width="4" height="4" />
                                        <rect x="12" y="6" width="4" height="4" />
                                        <rect x="18" y="6" width="4" height="4" />
                                    </svg>
                                </a>
                            </div><!-- End .toolbox-layout -->
                        </div><!-- End .toolbox-right -->
                    </div><!-- End .toolbox -->

                    <div class="products mb-3">
                        <div class="row justify-content-center">
                            <c:forEach var="item" items="${listBook}">
                            <div class="col-6 col-md-4 col-lg-4 col-xl-3">
                                <div class="product product-7 text-center">
                                    <figure class="product-media">
                                        <a href="product.html">
                                            <img src="${item.image}" alt="Product image" class="product-image">
                                        </a>

                                        <div class="product-action-vertical">
                                            <a href="#" class="btn-product-icon btn-wishlist btn-expandable"><span>add to wishlist</span></a>
                                            <a href="popup/quickView.html" class="btn-product-icon btn-quickview" title="Quick view"><span>Quick view</span></a>
                                            <a href="#" class="btn-product-icon btn-compare" title="Compare"><span>Compare</span></a>
                                        </div><!-- End .product-action-vertical -->

                                        <div class="product-action">
                                            <a href="#" class="btn-product btn-cart"><span>add to cart</span></a>
                                        </div><!-- End .product-action -->
                                    </figure><!-- End .product-media -->

                                    <div class="product-body">
                                        <h3 class="product-title"><a href="product.html">${item.name}</a></h3><!-- End .product-title -->
                                        <div class="product-price">
                                            ${item.price}₫
                                        </div><!-- End .product-price -->
                                        <div class="ratings-container">
                                            <div class="ratings">
                                                <div class="ratings-val" style="width: 0%;"></div><!-- End .ratings-val -->
                                            </div><!-- End .ratings -->
                                            <span class="ratings-text">( 0 Reviews )</span>
                                        </div><!-- End .rating-container -->
                                    </div><!-- End .product-body -->
                                </div><!-- End .product -->
                            </div><!-- End .col-sm-6 col-lg-4 col-xl-3 -->
                            </c:forEach>
                        </div><!-- End .row -->
                    </div><!-- End .products -->


                    <nav aria-label="Page navigation">
                        <ul class="pagination justify-content-center">
                            <li class="page-item disabled">
                                <a class="page-link page-link-prev" href="#" aria-label="Previous" tabindex="-1" aria-disabled="true">
                                    <span aria-hidden="true"><i class="icon-long-arrow-left"></i></span>Prev
                                </a>
                            </li>
                            <li class="page-item active" aria-current="page"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item-total">of 6</li>
                            <li class="page-item">
                                <a class="page-link page-link-next" href="#" aria-label="Next">
                                    Next <span aria-hidden="true"><i class="icon-long-arrow-right"></i></span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div><!-- End .col-lg-9 -->
                <aside class="col-lg-3 order-lg-first">
                    <div class="sidebar sidebar-shop">
                        <div class="widget widget-clean">
                            <label>Filters:</label>
                            <a href="#" class="sidebar-filter-clear">Clean All</a>
                        </div><!-- End .widget widget-clean -->

                        <div class="widget widget-collapsible">
                            <h3 class="widget-title">
                                <a data-toggle="collapse" href="#widget-1" role="button" aria-expanded="true" aria-controls="widget-1">
                                    Nhà sản xuất
                                </a>
                            </h3><!-- End .widget-title -->

                            <div class="collapse show" id="widget-1">
                                <div class="widget-body">
                                    <div class="filter-items filter-items-count">
                                        <c:forEach var="item" items="${listPublisher}">
                                        <div class="filter-item">
                                            <div class="custom-control custom-checkbox">
                                                <input type="checkbox" class="custom-control-input" id="cat-7">
                                                <label class="custom-control-label" for="cat-7">${item.name}</label>
                                            </div><!-- End .custom-checkbox -->
                                            <span class="item-count">1</span>
                                        </div><!-- End .filter-item -->
                                        </c:forEach>
                                    </div><!-- End .filter-items -->
                                </div><!-- End .widget-body -->
                            </div><!-- End .collapse -->
                        </div><!-- End .widget -->

                        <div class="widget widget-collapsible">
                            <h3 class="widget-title">
                                <a data-toggle="collapse" href="#widget-5" role="button" aria-expanded="true" aria-controls="widget-5">
                                    Price
                                </a>
                            </h3><!-- End .widget-title -->

                            <div class="collapse show" id="widget-5">
                                <div class="widget-body">
                                    <div class="filter-price">
                                        <div class="filter-price-text">
                                            Price Range:
                                            <span id="filter-price-range"></span>
                                        </div><!-- End .filter-price-text -->

                                        <div id="price-slider"></div><!-- End #price-slider -->
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
