<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.resource-resources" />
<html>
<head>
<title>List <fmt:message key="resource.title" />s</title>
</head>
<body style="width:600px;">
	<div class="panel">
		<form:form action="#" name="searchForm">
			<div class="title-large">
				<h2>List Resources</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">

						<table class="tabularData">

							<thead>
								<tr>
									<th>&nbsp;</th>
									<th><fmt:message key="resource.resourcename.title" /></th>
									<th class="center">Price</th>
									<th class="center"><fmt:message key="resource.activeyn.title" /></th>
									<th><fmt:message key="resource.resourcetype.title" /></th>
								</tr>
							</thead>
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
									<tr class="${rowclass}" >
										<td width="20px" class="center">&nbsp;</td>
										<td>${current.resourceName}&nbsp;</td>
										<td class="right">${current.price.priceField} (${current.price.priceCategory})</td>
										<td class="center">
										<c:if test='${current.activeYn == 1}'>	
											&nbsp;Yes
										</c:if> &nbsp;</td>
										<td>${current.resourceType}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> 
					<input class="button-clean" type="button" name="select" value="Print" onclick="window.print()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Close" onclick="window.close()" />
				</span>
			</div>
		</form:form>
	</div>
</body>
</html>