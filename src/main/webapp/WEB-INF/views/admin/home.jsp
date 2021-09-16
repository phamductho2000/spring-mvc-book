<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page-content fade-in-up">
	<div class="row">
		<div class="col-lg-3 col-md-6">
			<div class="ibox bg-success color-white widget-stat">
				<div class="ibox-body">
					<h2 class="m-b-5 font-strong">${countNewOrder}</h2>
					<div class="m-b-5">NEW ORDERS</div><i class="ti-shopping-cart widget-stat-icon"></i>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="ibox bg-warning color-white widget-stat">
				<div class="ibox-body">
					<h2 class="m-b-5 font-strong"><fmt:formatNumber type="number" groupingUsed="true" value="${totalIncome}"/> ₫</h2>
					<div class="m-b-5">TOTAL INCOME</div><i class="fa fa-money widget-stat-icon"></i>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="ibox bg-danger color-white widget-stat">
				<div class="ibox-body">
					<h2 class="m-b-5 font-strong">${countNewUser}</h2>
					<div class="m-b-5">NEW USERS</div><i class="ti-user widget-stat-icon"></i>
				</div>
			</div>
		</div>
	</div>
</div>