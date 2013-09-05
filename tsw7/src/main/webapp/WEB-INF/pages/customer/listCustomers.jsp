<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.customer-resources"/>
<html>
<head>
<title>List <fmt:message key="customer.title"/>s</title>
</head>
<body>
		<div class="panel">
			<div class="title">
				<h4>Manage Customers</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">	

			<table class="tabularData">		
		
			<thead>
				<tr>
					<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
					<th><fmt:message key="customer.firstname.title"/></th>
					<th><fmt:message key="customer.lastname.title"/></th>
					<th class="text-center"><fmt:message key="customer.phone.title"/></th>
					<th><fmt:message key="customer.email.title"/></th>
					<th class="text-center"><fmt:message key="customer.yearborn.title"/></th>
					<th><fmt:message key="customer.city.title"/></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
					<th><fmt:message key="customer.firstname.title"/></th>
					<th><fmt:message key="customer.lastname.title"/></th>
					<th class="text-center"><fmt:message key="customer.phone.title"/></th>
					<th><fmt:message key="customer.email.title"/></th>
					<th class="text-center"><fmt:message key="customer.yearborn.title"/></th>
					<th><fmt:message key="customer.city.title"/></th>
				</tr>
			</tfoot>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${customers}" var="current" varStatus="i">
				<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	

				<tr class="${rowclass}">
					<td style="width:100px;">			
						<a class="button-clean" href="${pageContext.request.contextPath}/editCustomer?customerIdKey=${current.customerId}&">
						<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
					&nbsp;
						<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteCustomer?customerIdKey=${current.customerId}&">
						<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
					</td>				
					
					<td>${current.firstname}&nbsp;</td>
					<td>${current.lastname}&nbsp;</td>
					<td class="text-center">${current.phone}&nbsp;</td>
					<td>${current.email}&nbsp;</td>
					<td class="text-center">${current.yearBorn}&nbsp;</td>
					<td>${current.city}&nbsp;</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
						<!-- ## / Panel Content   -->
						</div>
		<div class="button-bar">
			<span style="padding-left: 10px;"> 
				<input class="button-clean" type="button" name="new" value="New Customer" onclick="location.href='${pageContext.request.contextPath}/newCustomer'" />
			</span> 
			<span style="padding-left: 70px;">
				<input class="button-clean" type="button" name="emails" value="Email Campaign" onclick="location.href='${pageContext.request.contextPath}/emailCustomers'" />
			</span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
		</div>
</div>
</body>
</html>