<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="main">
    <div class="container-fluid" style="margin: 20px 20px;">
        <form:form method="POST" action="/admin/order/save" modelAttribute="order">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <form:select path="book_id">
                            <form:option value="0" label="--- Chọn sản phẩm ---"/>
                            <form:options items="${listBook}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="quantity" >Số lượng</form:label>
                        <form:input path="quantity" type="text" class="form-control" ></form:input>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="price" >Đơn giá</form:label>
                        <form:input path="price" type="text" class="form-control" ></form:input>
                    </div>
                    <div class="form-group">
                        <form:label path="total" >Tổng tiền</form:label>
                        <form:input path="total" type="text" class="form-control" ></form:input>
                    </div>
                </div>
            <button type="submit" class="btn btn-primary">THÊM MỚI</button>
        </form:form>
        </div>
    </div>
</div>
