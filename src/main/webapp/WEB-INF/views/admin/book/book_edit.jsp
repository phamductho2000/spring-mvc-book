<%--
  Created by IntelliJ IDEA.
  User: tho20
  Date: 5/24/2021
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="main">
    <div class="container-fluid" style="margin: 20px 20px;">
        <form:form method="POST" action="/admin/book/update" modelAttribute="book">
            <div class="row">
                <form:input path="id" type="hidden" value="${book.id}"></form:input>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="name">Tên sách</form:label>
                        <form:input path="name" type="text" class="form-control" value="${book.name}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="author" >Tác giả</form:label>
                        <form:input path="author" type="text" class="form-control" value="${book.author}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="price" >Đơn giá</form:label>
                        <form:input path="price" type="text" class="form-control" value="${book.price}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="image" >Hình ảnh</form:label>
                        <form:input path="image" type="text" class="form-control" value="${book.image}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="page" >Số trang</form:label>
                        <form:input path="page" type="text" class="form-control" value="${book.page}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="weight" >Cân nặng</form:label>
                        <form:input path="weight" type="text" class="form-control" value="${book.weight}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="size" >Kích thước</form:label>
                        <form:input path="size" type="text" class="form-control" value="${book.size}"></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:select path="publisher_id">
                            <form:option value="${item.publisher_id}" label="${pName}"/>
                            <form:options items="${listPublisher}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:select path="category_id">
                            <form:option value="${item.category_id}" label="${cName}"/>
                            <form:options items="${listCategory}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <form:label path="description" >Mô tả</form:label>
                <form:input path="description" type="text" class="form-control" id="des"></form:input>
            </div>
            <button type="submit" class="btn btn-primary" onclick="createNotification({position: 'bottom right',type: 'warning', duration: -18})">Update</button>
        </form:form>
    </div>
</div>
<%--<script>--%>
<%--    ClassicEditor--%>
<%--        .create( document.querySelector( '#des' ) )--%>
<%--        .catch( error => {--%>
<%--            console.error( error );--%>
<%--        } );--%>
<%--</script>--%>
