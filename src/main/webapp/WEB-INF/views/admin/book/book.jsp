<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: tho20
  Date: 5/24/2021
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="main">
    <!-- TABLE HOVER -->
    <div class="panel">
        <div class="row">
            <div class="col-md-4">
                <h3>Book manager</h3>
            </div>
            <div class="col-md-4">
                <form class="navbar-form navbar-left" action="/admin/home/book/search" method="POST">
                    <div class="input-group">
                        <input type="text" value="" class="form-control" name="key" placeholder="Enter keyword...">
                        <span class="input-group-btn"><button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button></span>
                    </div>
                </form>
            </div>
            <div class="panel-heading col-md-4" style="text-align: end">
                <a href="<c:url value="/admin/home/book/new"/>" class="btn btn-success">NEW</a>
            </div>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Created Date</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listBook}">
                    <tr>
                        <td>${item.id}</td>
                        <td style="width: 400px;">${item.name}</td>
                        <td>${item.author}</td>
                        <td>${item.price}</td>
                        <td>
                            <c:set value="${item.created_date}" var="dateString" />
                            <fmt:parseDate value="${dateString}" var="dateObject"
                                           pattern="yyyy-MM-dd HH:mm:ss" />

                            Date is : <b><fmt:formatDate value="${dateObject }" pattern="dd/MM/yyyy" /></b>
                            </br>
                            Time is : <b><fmt:formatDate value="${dateObject }" pattern="hh:mm a" /></b>
                        </td>
                        <td>
                            <div class="crud" style="text-align: center;">
                                <a href="<c:url value="/admin/home/book/detail/${item.id}"/>" style="margin-right: 8px"><i class="fa fa-info-circle"></i></a>
                                <a href="<c:url value="/admin/home/book/edit/${item.id}/${item.publisher_id}/${item.category_id}"/>" style="margin-right: 8px"><i class="fa fa-edit"></i></a>
                                <a href="<c:url value="/admin/home/book/remove/${item.id}"/>"><i class="fa fa-close"></i></a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- END TABLE HOVER -->
</div>
<script>
    alert(${message})
</script>