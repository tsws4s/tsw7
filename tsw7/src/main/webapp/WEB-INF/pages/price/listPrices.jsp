<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.price-resources" />
<html>
<head>
<title>List <fmt:message key="price.title" />s</title>
</head>
<body>
	<div class="panel">
		<div class="title">
			<h4>
				Manage Prices
			</h4>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">
			<table class="tabularData">
				<thead>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="price.pricecategory.title" />
						</th>
						<th><fmt:message key="price.pricecolor.title" />
						</th>
						<th class="text-right"><fmt:message key="price.pricefield.title" />
						</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="price.pricecategory.title" />
						</th>
						<th><fmt:message key="price.pricecolor.title" />
						</th>
						<th class="text-right"><fmt:message key="price.pricefield.title" />
						</th>
						<th>&nbsp;</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${prices}" var="current" varStatus="i">
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
							<td style="width:100px;">											
							<a class="button-clean" href="${pageContext.request.contextPath}/editPrice?priceIdKey=${current.priceId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeletePrice?priceIdKey=${current.priceId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>	

							<td>${current.priceCategory}&nbsp;</td>
							<td>${current.priceColor}&nbsp;</td>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber var="fmtPrice" value="${current.priceField}" type="currency" pattern="$#,##0.00;" />
							<td class="text-right">${fmtPrice}&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content   -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New Price" onclick="location.href='${pageContext.request.contextPath}/newPrice'" />
			 </span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
		</div>
	</div>
</body>
</html>
