<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
	<title>Dashboard | Klorofil - Free Bootstrap Dashboard Template</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="<c:url value='/resources/admin/vendor/bootstrap/css/bootstrap.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/admin/vendor/font-awesome/css/font-awesome.min.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/admin/vendor/linearicons/style.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/admin/vendor/chartist/css/chartist-custom.css'/>">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="<c:url value='/resources/admin/css/main.css'/>">
	<link rel="stylesheet" href="<c:url value='/resources/admin/css/toast.css'/>">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="<c:url value='/resources/admin/css/demo.css'/>">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="<c:url value='/resources/admin/img/apple-icon.png'/>">
	<link rel="icon" type="image/png" sizes="96x96" href="<c:url value='/resources/admin/img/favicon.png'/>">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<tiles:insertAttribute name="header"/>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="<c:url value='/admin/home'/>" class="active"><i class="lnr lnr-home"></i> <span>Dashboard</span></a></li>
						<li><a href="<c:url value='/admin/book'/>" class="managerBook"><i class="fa fa-book"></i> <span>Book</span></a></li>
						<li><a href="<c:url value='/admin/category'/>" class=""><i class="lnr lnr-chart-bars"></i> <span>Category</span></a></li>
						<li><a href="<c:url value='/admin/publisher'/>" class=""><i class="lnr lnr-cog"></i> <span>Publisher</span></a></li>
						<li><a href="<c:url value='/admin/order'/>" class=""><i class="lnr lnr-alarm"></i> <span>Order</span></a></li>
						<li>
							<a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages" class="collapse ">
								<ul class="nav">
									<li><a href="page-profile.html" class="">Profile</a></li>
									<li><a href="page-login.html" class="">Login</a></li>
									<li><a href="page-lockscreen.html" class="">Lockscreen</a></li>
								</ul>
							</div>
						</li>
						
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<tiles:insertAttribute name="content"/>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<tiles:insertAttribute name="footer"/>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	
	<script src="<c:url value='/resources/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/vendor/jquery-slimscroll/jquery.slimscroll.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/vendor/chartist/js/chartist.min.js'/>"></script>
	<script src="<c:url value='/resources/admin/scripts/klorofil-common.js'/>"></script>
	<script src="<c:url value='/resources/admin/scripts/toast.js'/>"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
<script>
    //book
    $('.managerBook').click(function () {
        $.ajax({
            type: "GET",
            url: "/admin/book",
            success: function(response) {
                $("#main_home").replaceWith( response );
            }
        })
    })
	function addBook() {
		var url = "/admin/book/new"
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_book").replaceWith( response );
			}
		})
	}
	function editBook(id, pId, cateId) {
		var url = "/admin/book/edit/"+id+"/"+pId+"/"+cateId
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_book").replaceWith( response );
			}
		})
	}
    function removeBook(id) {
        var url = "/admin/book/remove/"+id
        $.ajax({
            type: "GET",
            url: url,
            success: function(response) {
                $("#main_book").replaceWith( response );
            }
        })
    }
    //category
	function addCategory() {
		var url = "/admin/category/new"
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_category").replaceWith( response );
			}
		})
	}
	function editCategory(id) {
		var url = "/admin/category/edit/"+id
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_category").replaceWith( response );
			}
		})
	}
	$(document).ready(function () {
		$(".btnRemoveCate").click(function () {
			$('#myModal').modal('show')
		})
	})
	function removeCategory(id) {
		$("#btnYes").on("click", function(){
			var url = "/admin/category/remove/"+id
			$.ajax({
				type: "GET",
				url: url,
				success: function(response) {
					$("#main_category").replaceWith( response );
				}
			})
		})
	}
	//publisher
	function addPublisher() {
		var url = "/admin/publisher/new"
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_publisher").replaceWith( response );
			}
		})
	}
	function editPublisher(id) {
		var url = "/admin/publisher/edit/"+id
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_publisher").replaceWith( response );
			}
		})
	}
	function removePublisher(id) {
		var url = "/admin/publisher/remove/"+id
		$.ajax({
			type: "GET",
			url: url,
			success: function(response) {
				$("#main_publisher").replaceWith( response );
			}
		})
	}
</script>

