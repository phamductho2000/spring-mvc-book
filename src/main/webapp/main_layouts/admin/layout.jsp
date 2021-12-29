<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width initial-scale=1.0">
    <title>Quản lý bán hàng | Dashboard</title>
    <!-- GLOBAL MAINLY STYLES-->
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/bootstrap/dist/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/font-awesome/css/font-awesome.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/themify-icons/css/themify-icons.css'/>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <!-- PLUGINS STYLES-->
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/vendors/jvectormap/jquery-jvectormap-2.0.3.css'/>">
    <link href="<c:url value='/resources/admin/assets/vendors/bootstrap-datepicker/dist/css/bootstrap-datepicker3.min.css'/>" rel="stylesheet" />
    <link href="<c:url value='/resources/admin/assets/vendors/bootstrap-timepicker/css/bootstrap-timepicker.min.css'/>" rel="stylesheet" />
<%--    <link href="<c:url value='/resources/admin/assets/vendors/summernote/dist/summernote.css'/>" rel="stylesheet" />--%>
    <!-- THEME STYLES-->
    <link rel="stylesheet" href="<c:url value='/resources/admin/assets/css/main.css'/>">
    <!-- PAGE LEVEL STYLES-->

</head>

<body class="fixed-navbar">
<div class="page-wrapper">
    <!-- START HEADER-->
    <tiles:insertAttribute name="header"/>
    <!-- END HEADER-->
    <!-- START SIDEBAR-->
    <tiles:insertAttribute name="sidebar"/>
    <!-- END SIDEBAR-->
    <div class="content-wrapper">
        <!-- START PAGE CONTENT-->
        <tiles:insertAttribute name="content"/>
        <!-- END PAGE CONTENT-->
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
<!-- BEGIN THEME CONFIG PANEL-->
<div class="theme-config">
    <div class="theme-config-toggle"><i class="fa fa-cog theme-config-show"></i><i class="ti-close theme-config-close"></i></div>
    <div class="theme-config-box">
        <div class="text-center font-18 m-b-20">SETTINGS</div>
        <div class="font-strong">LAYOUT OPTIONS</div>
        <div class="check-list m-b-20 m-t-10">
            <label class="ui-checkbox ui-checkbox-gray">
                <input id="_fixedNavbar" type="checkbox" checked>
                <span class="input-span"></span>Fixed navbar</label>
            <label class="ui-checkbox ui-checkbox-gray">
                <input id="_fixedlayout" type="checkbox">
                <span class="input-span"></span>Fixed layout</label>
            <label class="ui-checkbox ui-checkbox-gray">
                <input class="js-sidebar-toggler" type="checkbox">
                <span class="input-span"></span>Collapse sidebar</label>
        </div>
        <div class="font-strong">LAYOUT STYLE</div>
        <div class="m-t-10">
            <label class="ui-radio ui-radio-gray m-r-10">
                <input type="radio" name="layout-style" value="" checked="">
                <span class="input-span"></span>Fluid</label>
            <label class="ui-radio ui-radio-gray">
                <input type="radio" name="layout-style" value="1">
                <span class="input-span"></span>Boxed</label>
        </div>
        <div class="m-t-10 m-b-10 font-strong">THEME COLORS</div>
        <div class="d-flex m-b-20">
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Default">
                <label>
                    <input type="radio" name="setting-theme" value="default" checked="">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-white"></div>
                    <div class="color-small bg-ebony"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Blue">
                <label>
                    <input type="radio" name="setting-theme" value="blue">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-blue"></div>
                    <div class="color-small bg-ebony"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Green">
                <label>
                    <input type="radio" name="setting-theme" value="green">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-green"></div>
                    <div class="color-small bg-ebony"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Purple">
                <label>
                    <input type="radio" name="setting-theme" value="purple">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-purple"></div>
                    <div class="color-small bg-ebony"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Orange">
                <label>
                    <input type="radio" name="setting-theme" value="orange">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-orange"></div>
                    <div class="color-small bg-ebony"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Pink">
                <label>
                    <input type="radio" name="setting-theme" value="pink">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-pink"></div>
                    <div class="color-small bg-ebony"></div>
                </label>
            </div>
        </div>
        <div class="d-flex">
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="White">
                <label>
                    <input type="radio" name="setting-theme" value="white">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color"></div>
                    <div class="color-small bg-silver-100"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Blue light">
                <label>
                    <input type="radio" name="setting-theme" value="blue-light">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-blue"></div>
                    <div class="color-small bg-silver-100"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Green light">
                <label>
                    <input type="radio" name="setting-theme" value="green-light">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-green"></div>
                    <div class="color-small bg-silver-100"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Purple light">
                <label>
                    <input type="radio" name="setting-theme" value="purple-light">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-purple"></div>
                    <div class="color-small bg-silver-100"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Orange light">
                <label>
                    <input type="radio" name="setting-theme" value="orange-light">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-orange"></div>
                    <div class="color-small bg-silver-100"></div>
                </label>
            </div>
            <div class="color-skin-box" data-toggle="tooltip" data-original-title="Pink light">
                <label>
                    <input type="radio" name="setting-theme" value="pink-light">
                    <span class="color-check-icon"><i class="fa fa-check"></i></span>
                    <div class="color bg-pink"></div>
                    <div class="color-small bg-silver-100"></div>
                </label>
            </div>
        </div>
    </div>
</div>
<!-- END THEME CONFIG PANEL-->
<!-- BEGIN PAGA BACKDROPS-->
<div class="sidenav-backdrop backdrop"></div>
<div class="preloader-backdrop">
    <div class="page-preloader">Loading</div>
</div>
<!-- END PAGA BACKDROPS-->
<!-- CORE PLUGINS-->
<script src="<c:url value='/resources/admin/assets/vendors/jquery/dist/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/jquery/src/core/ready-no-deferred.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/popper.js/dist/umd/popper.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/bootstrap/dist/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/metisMenu/dist/metisMenu.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/jquery-slimscroll/jquery.slimscroll.min.js'/>"></script>
<!-- PAGE LEVEL PLUGINS-->
<script src="<c:url value='/resources/admin/assets/vendors/chart.js/dist/Chart.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/jvectormap/jquery-jvectormap-2.0.3.min.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/jvectormap/jquery-jvectormap-us-aea-en.js'/>"></script>
<script src="<c:url value='/resources/admin/assets/vendors/select2/dist/js/select2.full.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/vendors/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/vendors/bootstrap-timepicker/js/bootstrap-timepicker.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/vendors/ckfinder/ckfinder.js'/>" type="text/javascript"></script>
<script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
<!-- CORE SCRIPTS-->
<script src="<c:url value='/resources/admin/assets/js/app.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/js/scripts/remove.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/js/scripts/search.js'/>" type="text/javascript"></script>
<!-- PAGE LEVEL SCRIPTS-->
<script src="<c:url value='/resources/admin/assets/js/scripts/dashboard_1_demo.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/js/scripts/jquery.twbsPagination.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/admin/assets/js/scripts/form-plugins.js'/>" type="text/javascript"></script>
</body>
<script>
    $(document).ready(function () {

        pagination()

        var editor = CKEDITOR.replace('editor');
        CKFinder.setupCKEditor(editor, '/resources/admin/assets/vendors/ckfinder/')

        function exportExcel() {
            $('#formReport').submit()
        }

        $('#inputImage').on('change', function (event) {
            if (this.files && this.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $('#imgProduct').attr('src', e.target.result);
                }
                reader.readAsDataURL(this.files[0]);
            }
        })

    })
</script>
</html>