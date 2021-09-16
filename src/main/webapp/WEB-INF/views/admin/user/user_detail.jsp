<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-heading">
    <h1 class="page-title">Thông tin chi tiết khách hàng</h1>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head">
            <div class="ibox-title">Thông tin chi tiết khách hàng</div>
        </div>
        <div class="ibox-body">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link active" href="#tab-1-1" data-toggle="tab"><i class="fa fa-info"></i> Thông tin chi tiết</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#tab-1-2" data-toggle="tab"><i class="fa fa-rss"></i> Lịch sử mua hàng</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane fade show active" id="tab-1-1">
                    <div class="row">
                        <div class="col-md-6 detail-product">
                            <label>Họ và tên: </label>
                            <span>${user.name}</span>
                            <br>
                            <label>Số điện thoại: </label>
                            <span>${user.phone}</span>
                            <br>
                            <label>Địa chỉ: </label>
                            <span>${user.address}</span>
                            <br>
                            <label>Email: </label>
                            <span>${user.email}</span>
                            <br>
                            <label>Tên đăng nhập: </label>
                            <span>${user.username}</span>
                            <br>
                            <label>Mật khẩu: </label>
                            <span>${user.password}</span>
                            <br>
                            <label>Trạng thái: </label>
                            <span>${user.status}</span>
                        </div>
                        <div class="col-md-6">
                            <img src="/resources/book_images/${user.avatar}" width="200px" height="200px" id="imgProduct">
                            <p>${user.avatar}</p>
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

