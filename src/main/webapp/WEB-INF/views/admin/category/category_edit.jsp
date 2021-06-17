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
    <div class="container-fluid">
        <form:form method="POST" action="/admin/category/update" modelAttribute="category">
            <form:input path="id" value="${category.id}" type="hidden"></form:input>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" type="text" class="form-control" value="${category.name}"></form:input>
            </div>
            <button type="submit" class="btn btn-primary">Cập nhật</button>
        </form:form>
    </div>
</div>