<%--
  Created by IntelliJ IDEA.
  User: tho20
  Date: 5/24/2021
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://cdn.ckeditor.com/ckeditor5/27.1.0/classic/ckeditor.js"></script>
<div class="main">
    <div class="container-fluid" style="margin: 20px 20px;">
        <form:form method="POST" action="save" modelAttribute="book">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="author" >Author</form:label>
                        <form:input path="author" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="price" >Price</form:label>
                        <form:input path="price" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="image" >Image</form:label>
                        <form:input path="image" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="page" >Page</form:label>
                        <form:input path="page" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="weight" >Weight</form:label>
                        <form:input path="weight" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="size" >Size</form:label>
                        <form:input path="size" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:select path="publisher_id">
                            <form:option value="0" label="--- Select publisher ---"/>
                            <form:options items="${listPublisherName}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:select path="category_id">
                            <form:option value="0" label="--- Select category ---"/>
                            <form:options items="${listCategoryName}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <form:label path="description" >Description</form:label>
                <form:input path="description" type="text" class="form-control" id="des"></form:input>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
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