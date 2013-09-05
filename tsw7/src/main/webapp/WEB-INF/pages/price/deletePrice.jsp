<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.price-resources" />
<html>
<head>
<title>View <fmt:message key="price.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title">
				<h4>
					<fmt:message key="navigation.delete" /> <fmt:message key="price.title" />
					(${price.priceId}) <strong>${price.priceCategory}</strong>
				</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">

				<fieldset>
					<br />
					<div>
						<label><fmt:message key="price.pricecategory.title" />:&nbsp;&nbsp;
						<strong>${price.priceCategory}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="price.pricefield.title" />:&nbsp;&nbsp; 
						<strong>${price.priceField}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="price.pricecolor.title" />:&nbsp;&nbsp;
						<strong>${price.priceColor}</strong></label>
					</div>
					<br />
				</fieldset>
				<fieldset>
					<br />
					<div>
						<label><fmt:message key="price.description.title" /></label> 
						<strong>${price.description}</strong>
					</div>
					<br />
				</fieldset>
			</div>

			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deletePrice?priceIdKey=${price.priceId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexPrice'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>

		</div>
	</div>

</body>
</html>
