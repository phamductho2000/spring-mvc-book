<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container quickView-container">
	<div class="quickView-content">
		<div class="row">
			<div class="col-lg-7 col-md-6">
				<figure class="product-main-image">
					<img src="/resources/book_images/${book.image}" data-zoom-image="assets/images/products/single/1-big.jpg" alt="product image">

					<%--                                    <a href="#" id="btn-product-gallery" class="btn-product-gallery">--%>
					<%--                                        <i class="icon-arrows"></i>--%>
					<%--                                    </a>--%>
				</figure><!-- End .product-main-image -->
			</div>
			<div class="col-lg-5 col-md-6">
				<h2 class="product-title">${book.name}</h2>
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
				<div class="ratings-container">
					<div class="ratings">
						<div class="ratings-val" style="width: ${book.rate * 20}%;"></div><!-- End .ratings-val -->
					</div><!-- End .ratings -->
					<a class="ratings-text" href="#product-review-link" id="review-link">( ${lstReviews.size()} Reviews )</a>
				</div><!-- End .rating-container -->

                <p class="product-txt">${book.shortDes}</p>

				<div class="details-filter-row details-row-size">
					<label for="qty">Số lượng:</label>
					<div class="product-details-quantity">
						<input type="number" id="qty" class="form-control" value="1" min="1" step="1" data-decimals="0" required>
					</div><!-- End .product-details-quantity -->
				</div><!-- End .details-filter-row -->

				<div class="product-details-action">
					<a href="#" class="btn-product btn-cart" onclick="addToCart(${book.id})"><span>Thêm giỏ hàng</span></a>
					<div class="details-action-wrapper">
						<a href="#" class="btn-product btn-wishlist" title="Wishlist"><span>Add to Wishlist</span></a>
					</div><!-- End .details-action-wrapper -->
				</div><!-- End .product-details-action -->

			</div>
		</div>
	</div>
</div>