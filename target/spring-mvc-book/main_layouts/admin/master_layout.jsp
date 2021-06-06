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
						<li><a href="<c:url value='/admin/home/book'/>" class=""><i class="lnr lnr-code"></i> <span>Book</span></a></li>
						<li><a href="<c:url value='/admin/home/category'/>" class=""><i class="lnr lnr-chart-bars"></i> <span>Category</span></a></li>
						<li><a href="<c:url value='/admin/home/publisher'/>" class=""><i class="lnr lnr-cog"></i> <span>Publisher</span></a></li>
						<li><a href="<c:url value='/admin/home'/>" class=""><i class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>
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
	<script>
	$(function() {
		var data, options;

		// headline charts
		data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			series: [
				[23, 29, 24, 40, 25, 24, 35],
				[14, 25, 18, 34, 29, 38, 44],
			]
		};

		options = {
			height: 300,
			showArea: true,
			showLine: false,
			showPoint: false,
			fullWidth: true,
			axisX: {
				showGrid: false
			},
			lineSmooth: false,
		};

		new Chartist.Line('#headline-chart', data, options);


		// visits trend charts
		data = {
			labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
			series: [{
				name: 'series-real',
				data: [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
			}, {
				name: 'series-projection',
				data: [240, 350, 360, 380, 400, 450, 480, 523, 555, 600, 700, 800],
			}]
		};

		options = {
			fullWidth: true,
			lineSmooth: false,
			height: "270px",
			low: 0,
			high: 'auto',
			series: {
				'series-projection': {
					showArea: true,
					showPoint: false,
					showLine: false
				},
			},
			axisX: {
				showGrid: false,

			},
			axisY: {
				showGrid: false,
				onlyInteger: true,
				offset: 0,
			},
			chartPadding: {
				left: 20,
				right: 20
			}
		};

		new Chartist.Line('#visits-trends-chart', data, options);


		// visits chart
		data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			series: [
				[6384, 6342, 5437, 2764, 3958, 5068, 7654]
			]
		};

		options = {
			height: 300,
			axisX: {
				showGrid: false
			},
		};

		new Chartist.Bar('#visits-chart', data, options);


		// real-time pie chart
		var sysLoad = $('#system-load').easyPieChart({
			size: 130,
			barColor: function(percent) {
				return "rgb(" + Math.round(200 * percent / 100) + ", " + Math.round(200 * (1.1 - percent / 100)) + ", 0)";
			},
			trackColor: 'rgba(245, 245, 245, 0.8)',
			scaleColor: false,
			lineWidth: 5,
			lineCap: "square",
			animate: 800
		});

		var updateInterval = 3000; // in milliseconds

		setInterval(function() {
			var randomVal;
			randomVal = getRandomInt(0, 100);

			sysLoad.data('easyPieChart').update(randomVal);
			sysLoad.find('.percent').text(randomVal);
		}, updateInterval);

		function getRandomInt(min, max) {
			return Math.floor(Math.random() * (max - min + 1)) + min;
		}

	});
	</script>
</body>

</html>