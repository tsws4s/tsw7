<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.price-resources" />
<html>
<head>
<title>List <fmt:message key="price.title" />s</title>
</head>
<body style="width:600px;">
	<div class="panel">
		<form:form action="#" name="searchForm">
			<div class="title-large">
				<h2>List Prices</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">
						<table class="tabularData">
							<thead>
								<tr>
									<th>&nbsp;</th>
									<th><fmt:message key="price.pricecategory.title" /></th>
									<th class="center"><fmt:message key="price.pricefield.title" /></th>
									<th class="center"><fmt:message key="price.pricecolor.title" /></th>
								</tr>
							</thead>
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
										<td width="20px" class="center">&nbsp;</td>
										<td>${current.priceCategory}&nbsp;</td>
										<td class="center">${current.priceField}&nbsp;</td>
										<td class="center">${current.priceColor}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
		
				<!-- ## / Panel Content  -->
			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> 
					<input class="button-clean" type="button" name="select" value="Print" onclick="window.print()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Close" onclick="window.close()" />
				 </span>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>
		</form:form>
	</div>

</body>
</html>

