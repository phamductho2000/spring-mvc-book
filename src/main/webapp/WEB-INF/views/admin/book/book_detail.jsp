<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Thông tin chi tiết sản phẩm</h1>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head">
            <div class="ibox-title">Thông tin chi tiết sản phẩm</div>
        </div>
        <div class="ibox-body">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" href="#tab-1-1" data-toggle="tab"><i class="fa fa-info"></i> Thông tin chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#tab-1-2" data-toggle="tab"><i class="fa fa-rss"></i> Bài viết</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="tab-1-1">
                    <div class="row">
                        <div class="col-md-6 detail-product">
                            <label>Mã sản phẩm: </label>
                            <span>${book.id}</span>
                            <br>
                            <label>Tên sản phẩm: </label>
                            <span>${book.name}</span>
                            <br>
                            <label>Tác giả: </label>
                            <span>${book.author}</span>
                            <br>
                            <label>Đơn giá: </label>
                            <span><fmt:formatNumber type="number" groupingUsed="true" value="${book.price}"/> ₫</span>
                            <br>
                            <label>Số trang: </label>
                            <span>${book.page}</span>
                            <br>
                            <label>Cân nặng: </label>
                            <span>${book.weight}</span>
                            <br>
                            <label>Kích cỡ: </label>
                            <span>${book.size}</span>
                            <br>
                            <label>Trạng thái: </label>
                            <c:if test="${book.status == 1}">
                                <span class="badge badge-danger">Hết hàng</span>
                                <br>
                            </c:if>
                            <c:if test="${book.status == 2}">
                                <span class="badge badge-success">Còn hàng</span>
                                <br>
                            </c:if>
                            <c:if test="${book.status == 3}">
                                <span class="badge badge-dark">Ngừng kinh doanh</span>
                                <br>
                            </c:if>
                            <label>Thể loại: </label>
                            <span> ${book.nameCategory}</span>
                            <br>
                            <label>Nhà xuất bản: </label>
                            <span>${book.namePublisher}</span>
                            <br>
                            <label>Mô tả ngắn: </label>
                            <span> ${book.shortDes}</span>
                        </div>
                        <div class="col-md-6">
                            <img src="/resources/book_images/${book.image}" width="200px" height="200px" id="imgProduct">
                            <p>${book.image}</p>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="tab-1-2">
                    ${book.description}
                </div>
            </div><br></div>
    </div>
</div>

