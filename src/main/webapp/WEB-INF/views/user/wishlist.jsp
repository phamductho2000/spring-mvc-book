<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Wishlist</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->

    <div class="page-content">
        <div class="container" id="main-whishlist">
           <ul class="list">
               <c:forEach var="item" items="${wishlist}">
                   <li class="item">
                       <a onclick="removeItemWishlist(${item.id})" class="btn-delete">×</a>
                       <div class="thumbnail">
                           <a href="/${item.book.name}/id=${item.book.id}">
                               <img src="/resources/book_images/${item.book.image}" width="300px" height="130px">
                           </a>
                       </div>
                       <div class="body">
                           <a class="name" href="/${item.book.name}/id=${item.book.id}" >${item.book.name}</a>
                           <div class="ratings-container">
                               <div class="ratings">
                                   <div class="ratings-val" style="width: ${item.book.rate * 20}%;"></div><!-- End .ratings-val -->
                               </div><!-- End .ratings -->
                               <span class="ratings-text">( ${item.book.countReviews} Reviews )</span>
                           </div><!-- End .rating-container -->
                           <div class="description">
                               ${item.book.shortDes}
                           </div>
                       </div>
                       <div class="footer">
                           <c:if test="${item.book.discount == 0}">
                               <div class="product-price">
                                   <div class="new-price">
                                       <fmt:formatNumber type="number" groupingUsed="true" value="${item.book.oldPrice}"/> ₫
                                   </div>
                               </div><!-- End .product-price -->
                           </c:if>
                           <c:if test="${item.book.discount > 0}">
                               <div class="product-price">
                                   <div class="new-price">
                                       <fmt:formatNumber type="number" groupingUsed="true" value="${item.book.price}"/> ₫
                                   </div>
                               </div><!-- End .product-price -->
                               <div class="product-price">
                                   <div class="old-price" style="margin-right: .8rem">
                                       <fmt:formatNumber type="number" groupingUsed="true" value="${item.book.oldPrice}"/> ₫
                                   </div>
                                   <div class="discount-price" style="font-size: 13px; color: rgb(125, 210, 235)">
                                           ${item.book.discount}%
                                   </div>
                               </div><!-- End .product-price -->
                           </c:if>
                       </div>
                   </li>
               </c:forEach>
           </ul>
        </div><!-- End .container -->
    </div><!-- End .page-content -->
</main><!-- End .main -->
