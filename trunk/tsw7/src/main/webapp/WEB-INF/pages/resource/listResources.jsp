<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.resource-resources" />
<html>
<head>
<title>List <fmt:message key="resource.title" />s</title>
</head>
<body>
	<div class="panel">
		<div class="title">
			<h4>Manage Resources</h4>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">

			<table class="tabularData">

				<thead>
					<tr>
						<th class="text-center">Events&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="resource.resourcename.title" />
						</th>
						<th class="text-right">Price</th>
						<th class="text-center"><fmt:message key="resource.activeyn.title" />
						</th>
						<th><fmt:message key="resource.resourcetype.title" />
						</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Events&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="resource.resourcename.title" />
						</th>
						<th class="text-right">Price</th>
						<th class="text-center"><fmt:message key="resource.activeyn.title" />
						</th>
						<th><fmt:message key="resource.resourcetype.title" />
						</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${resources}" var="current" varStatus="i">
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
							<td style="width:140px;">		
								<a class="button-clean" href="${pageContext.request.contextPath}/scheduling?resource_resourceId=${current.resourceId}&amp;afterDate=&amp;beforeDate=&amp;">
								<span><img class="icon" src="explorer/images/icon-calendar.png" alt="Calendar" /></span></a>
							&nbsp;									
							<a class="button-clean" href="${pageContext.request.contextPath}/editResource?resourceIdKey=${current.resourceId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteResource?resourceIdKey=${current.resourceId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>

							<td>${current.resourceName}&nbsp;</td>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber var="fmtPrice" value="${current.price.priceField}" type="currency" pattern="$#,##0.00;" />
							<td class="text-right">${fmtPrice}</td>
							<td class="text-center">
							<c:if test='${current.activeYn == 1}'>	
								&nbsp;Yes
							</c:if> &nbsp;</td>
							<td>${current.resourceType}&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content   -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New Resource" onclick="location.href='${pageContext.request.contextPath}/newResource'" />
			</span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
		</div>
	</div>
</body>
</html>