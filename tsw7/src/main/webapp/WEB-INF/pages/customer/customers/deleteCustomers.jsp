<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.customer-resources" />
<html>
<head>
<title>Delete <fmt:message key="customer.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title">
				<h4>
					<fmt:message key="navigation.delete" /> <fmt:message key="customer.title" />
					(${customer.customerId})<strong> ${customer.firstname} ${customer.lastname}</strong>
				</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">

				<fieldset>
					<br />
					<div>
						<label><fmt:message key="customer.firstname.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.firstname}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.lastname.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.lastname}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.email.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.email}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.phone.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.phone}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.yearborn.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.yearBorn}</strong></label>
					</div>
					<br />
					<div>
						<label>Family / Parent: 
						<c:if test='${customer.customer != null}'>
							<strong>(${customer.customer.customerId})&nbsp;${customer.customer.firstname}&nbsp;${customer.customer.lastname}&nbsp;</strong>
						</c:if>
						</label>
					</div>
					<br />
				</fieldset>
				<fieldset>
					<br>
					<div>
						<label><fmt:message key="customer.address.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.address}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.city.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.city}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.state.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.state}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="customer.zipcode.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.zipcode}</strong></label>
					</div>
					<br />
					<div>
						<label><fmt:message key="tswacct.acctname.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${customer.tswacct.acctName}</strong></label>
					</div>
				</fieldset>
			</div>

			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteCustomerCustomers?customer_customerId=${customer_customerId}&amp;related_customers_customerId=${customer.customerId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editCustomer?customerIdKey=${customer_customerId}&amp;'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
			</div>

		</div>
	</div>

</body>
</html>
