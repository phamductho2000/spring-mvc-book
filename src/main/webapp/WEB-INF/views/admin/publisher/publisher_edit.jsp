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
        <form:form method="POST" action="/admin/publisher/update" modelAttribute="publisher">
            <form:input path="id" value="${publisher.id}" type="hidden"></form:input>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" type="text" class="form-control" value="${publisher.name}"></form:input>
            </div>
            <div class="form-group">
                <form:label path="address" >Author</form:label>
                <form:input path="address" type="text" class="form-control" value="${publisher.address}"></form:input>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
</div>