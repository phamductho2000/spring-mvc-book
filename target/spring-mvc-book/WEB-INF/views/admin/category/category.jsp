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
<div class="main" id="main_category">
    <!-- TABLE HOVER -->
    <div class="panel">
        <div class="" STYLE="text-align: center;">
            <h3>QUẢN LÝ THỂ LOẠI SÁCH</h3>
        </div>
        <div class="row">
            <div class="col-md-6">
                <form class="navbar-form navbar-left" action="/admin/book/search" method="POST">
                    <div class="input-group">
                        <input type="text" value="" class="form-control" name="key" placeholder="Enter keyword...">
                        <span class="input-group-btn"><button type="submit" class="btn btn-primary"><i class="fa fa-search"></i></button></span>
                    </div>
                </form>
            </div>
            <div class="panel-heading" style="text-align: end;">
                <button type="button" class="btn btn-success"  onclick="addCategory()">NEW</button>
            </div>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Tên loại sách</th>
                    <th>Ngày tạo</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${listCategory}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
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
                                <button class="" style="border: none;background: none;"><i class="fa fa-eye"></i></button>
                                <button style="border: none;background: none;" onclick="editCategory(${item.id})"><i class="fa fa-edit"></i></button>
                                <button class="btnRemoveCate" style="border: none;background: none;" onclick="removeCategory(${item.id})"><i class="fa fa-trash"></i></button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <!-- END TABLE HOVER -->
    <div class="modal" tabindex="-1" role="dialog" id="myModal">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Thông báo</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>Bạn có chắc chắn muốn xóa?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="btnYes">Có</button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                </div>
            </div>
        </div>
    </div>
</div>