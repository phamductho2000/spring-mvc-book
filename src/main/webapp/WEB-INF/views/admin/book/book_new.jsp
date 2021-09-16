<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-heading">
    <h1 class="page-title">Thêm mới sản phẩm</h1>
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html"><i class="la la-home font-20"></i></a>
        </li>
        <li class="breadcrumb-item">Form Validation</li>
    </ol>
</div>
<div class="page-content fade-in-up">
    <div class="ibox">
        <div class="ibox-head">
            <div class="ibox-title">Basic Validation</div>
            <div class="ibox-tools">
                <a class="ibox-collapse"><i class="fa fa-minus"></i></a>
            </div>
        </div>
        <div class="ibox-body">
            <form:form method="POST" action="/admin/book/save" enctype="multipart/form-data" modelAttribute="book">
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <form:label path="name">Tên sách</form:label>
                        <form:input path="name" type="text" class="form-control" ></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="author" >Tác giả</form:label>
                        <form:input path="author" type="text" class="form-control" ></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="oldPrice" >Đơn giá</form:label>
                        <form:input path="oldPrice" type="text" class="form-control" ></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="page" >Số trang</form:label>
                        <form:input path="page" type="text" class="form-control" ></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="discount" >Khuyến mãi</form:label>
                        <form:input path="discount" type="text" class="form-control" ></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="quanty" >Số lượng</form:label>
                        <form:input path="quanty" type="text" class="form-control" ></form:input>
                    </div>


                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <img src="" width="200px" height="210px" id="imgProduct" style="display: inline-block">
                        <label for="inputImage" path="image" class="btn btn-primary">Chọn hình ảnh</label>
                        <input type="file"  value="Upload File"  hidden="true" name="file" id="inputImage"/>
                    </div>

                    <div class="form-group">
                        <form:label path="publisher_id">Chọn nhà sản xuất</form:label>
                        <br>
                        <form:select cssClass="form-control" path="publisher_id" >
                            <form:option value="0" label=" Chọn nhà sản xuất "/>
                            <form:options items="${listPublisherName}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <form:label path="category_id">Chọn danh mục</form:label>
                        <br>
                        <form:select cssClass="form-control" path="category_id">
                            <form:option value="0" label=" Chọn danh mục "/>
                            <form:options items="${listCategoryName}" itemValue="id" itemLabel="name"/>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <form:label path="weight" >Trọng lượng</form:label>
                        <form:input path="weight" type="text" class="form-control" ></form:input>
                    </div>

                    <div class="form-group">
                        <form:label path="size" >Kích thước</form:label>
                        <form:input path="size" type="text" class="form-control" ></form:input>
                    </div>

                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <form:label path="shortDes" >Mô tả ngắn</form:label>
                        <textarea name="shortDes" rows="5" cols="180" placeholder="Mô tả ngắn về sản phẩm">

                        </textarea>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <form:label path="description" >Mô tả</form:label>
                        <textarea name="des" id="summernote" rows="10" cols="180"></textarea>
                    </div>
                </div>
            </div>
                <button type="submit" class="btn btn-primary">THÊM MỚI</button>
            </form:form>
        </div>
    </div>
</div>

<script>

</script>