<<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<main class="main">
    <nav aria-label="breadcrumb" class="breadcrumb-nav" style="background: #dee2e6">
        <div class="container">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Shop</a></li>
                <li class="breadcrumb-item active" aria-current="page">Order</li>
            </ol>
        </div><!-- End .container -->
    </nav><!-- End .breadcrumb-nav -->
    <div class="page-content">
        <div class="dashboard">
            <div class="container">
                        <div class="main-account products mb-3" >
                            <h3 style="font-size: 30px">Thông tin hóa đơn</h3>
                            <sec:authorize access="isAnonymous()">
                                <p>Chưa có hóa đơn nào</p>
                                <a href="category.html" class="btn btn-outline-primary-2"><span>GO SHOP</span><i class="icon-long-arrow-right"></i></a>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <table class="table table-hover" width="100%">
                                    <thead>
                                    <tr>
                                        <th>Mã đơn hàng</th>
                                        <th>Tổng tiền</th>
                                        <th>Ngày mua hàng</th>
                                        <th>Trạng thái đơn hàng</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${lstOrder}">
                                        <tr>
                                            <td><a href="/tai-khoan/chi-tiet-don-hang/${item.id}" >${item.id}</a></td>
                                            <td><fmt:formatNumber type="number" groupingUsed="true" value="${item.total_price}"/> ₫</td>
                                            <td>
                                                <c:set value="${item.created_date}" var="dateString" />
                                                <fmt:parseDate value="${dateString}" var="dateObject"
                                                               pattern="yyyy-MM-dd HH:mm:ss" />
                                                <fmt:formatDate value="${dateObject }" pattern="hh:mm" />
                                                <fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" />
                                            </td>
                                            <c:if test="${item.status == 1}">
                                                <td><span>Hoàn thành</span></td>
                                            </c:if>
                                            <c:if test="${item.status == 0}">
                                                <td>
                                                    <span>Đang xử lý</span>
                                                    <span style="float: right"><a href="/tai-khoan/don-hang/huy/${item.id}" class="button-sort">Hủy đặt hàng</a></span>
                                                </td>
                                            </c:if>
                                            <c:if test="${item.status == 2}">
                                                <td><span>Đang giao</span></td>
                                            </c:if>
                                            <c:if test="${item.status == 3}">
                                                <td><span>Đã hủy</span></td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </sec:authorize>
                        </div><!-- .End .tab-pane -->
                <nav id="page_navigation" aria-label="page_navigation">
                    <ul id="pagination" class="pagination-lg" style="float: right"></ul>
                    <input hidden="true" id="totalPage" value="${totalPage}">
                    <input hidden="true" id="currentPage" value="${currentPage}">
                </nav>
            </div><!-- End .container -->
        </div><!-- End .dashboard -->
    </div><!-- End .page-content -->
</main>

