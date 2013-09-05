<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.users-resources" />
<html>
<head>
<title>List <fmt:message key="users.title" />s</title>
</head>
<body>
	<div class="panel">
		<div class="title">
			<h4>Manage Users</h4>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">

			<table class="tabularData">

				<thead>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="users.username.title" />
						</th>
						<th>Customer</th>
						<th>Theme</th>
						<th class="text-center"><fmt:message key="users.activeyn.title" />
						</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="users.username.title" />
						</th>
						<th>Customer</th>
						<th>Theme</th>
						<th class="text-center"><fmt:message key="users.activeyn.title" />
						</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${userss}" var="current" varStatus="i">
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
								<a class="button-clean" href="${pageContext.request.contextPath}/editUsers?userIdKey=${current.userId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteUsers?userIdKey=${current.userId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>

							<td>${current.username}&nbsp;</td>
							<td>${current.customer.firstname}&nbsp;${current.customer.lastname}&nbsp;</td>
							<td>${current.selectTheme}&nbsp;</td>
							<td class="text-center">
							<c:if test='${current.activeYn == 1}'>	
								&nbsp;Yes
							</c:if> &nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content   #0099cc  -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New User" onclick="location.href='${pageContext.request.contextPath}/newUsers'" />
			</span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
		</div>
	</div>
</body>
</html>