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
        <div class="panel-heading" style="text-align: end;">
            <a href="<c:url value="/admin/publisher/new"/>" class="btn btn-success">NEW</a>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Adress</th>
                    <th>Created Date</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listPublisher}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.address}</td>
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
                                <a href="<c:url value="/admin/home/publisher/detail"/>" style="margin-right: 8px"><i class="fa fa-info-circle"></i></a>
                                <a href="<c:url value="/admin/publisher/edit/${item.id}"/>" style="margin-right: 8px"><i class="fa fa-edit"></i></a>
                                <a href="<c:url value="/admin/publisher/remove/${item.id}"/>"><i class="fa fa-close"></i></a>
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