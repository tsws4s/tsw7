<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.customer-resources" />
<html>
<head>
<title>Search <fmt:message key="customer.title" />s</title>
</head>
<body>
	<div class="panel">
		<form:form action="#" name="searchForm">
			<input type="hidden" id="selectSearch" name="item_selected" />
			<input type="hidden" id="selectSearchName" name="item_name" />
			<div class="title-large">
				<h2>Select Customer</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>

			<div class="content">
				<table class="tabularData">
					
							<thead>
								<tr>
									<th>Select</th>
									<th><fmt:message key="customer.firstname.title" /></th>
									<th><fmt:message key="customer.lastname.title" /></th>
									<th class="center"><fmt:message key="customer.phone.title" /></th>
									<th><fmt:message key="customer.email.title" /></th>
									<th class="center"><fmt:message key="customer.yearborn.title" /></th>
									<th><fmt:message key="customer.city.title" /></th>
								</tr>
							</thead>

							<tbody>
								<c:set var="totalCount" value="0" />
								<c:forEach items="${customers}" var="current" varStatus="i">
									<c:set var="totalCount" value="${totalCount+1}" />
									<c:choose>
										<c:when test="${(i.count) % 2 == 0}">
											<c:set var="rowclass" value="rowtwo" />
										</c:when>
										<c:otherwise>
											<c:set var="rowclass" value="rowone" />
										</c:otherwise>
									</c:choose>
									<tr class="${rowclass}">
										<td width="20px" class="center">
										<div style="height:16px;background-color:grey;padding:5px 7px 5px 7px;opacity:0.7;">
												<input type="radio" name="selectedCustomers" value="${current.customerId}"
													onclick="document.searchForm.item_selected.value ='${current.customerId}'; document.searchForm.item_name.value ='${current.firstname} ${current.lastname}'; document.selectedCustomers.selected=true; return false;">
											</div>
										</td>

										<td>${current.firstname}&nbsp;</td>
										<td>${current.lastname}&nbsp;</td>
										<td class="center">${current.phone}&nbsp;</td>
										<td>${current.email}&nbsp;</td>
										<td class="center">${current.yearBorn}&nbsp;</td>
										<td>${current.city}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>

				</table>
				<!-- ## / Panel Content  -->
			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> 
					<c:set var="clickjs" value="opener.document.parentform.selected_id${custNum}.value = document.searchForm.item_selected.value; opener.document.parentform.custName${custNum}.value = document.searchForm.item_name.value; window.close()" />
					<input class="button-clean" type="button" name="select" value="Select" onclick="${clickjs}" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="window.close()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="delete" value="Delete" onclick="opener.document.parentform.selected_id${custNum}.value =''; opener.document.parentform.custName${custNum}.value =''; window.close()" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
				 </span>
			</div>
		</form:form>
	</div>

</body>
</html>
