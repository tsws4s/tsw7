<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.resource-resources" />
<html>
<head>
<title>Search <fmt:message key="resource.title" />s</title>
</head>
<body>
	<div class="panel">
		<form:form action="#" name="searchForm">
			<div class="title-large">
				<h2>Select Resource</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>

			<input type="hidden" id="selectSearch" name="item_selected" />
			<input type="hidden" id="selectSearchName" name="item_name" />
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
										<td width="20px" class="center">
										<div style="height:16px;background-color:grey;padding:0px 7px 10px 7px;opacity:0.7;"> 
												<input class="button-clean" type="radio" name="selectedResources" value="${current.resourceId}" id="test_radio_1"
													onclick="document.searchForm.item_selected.value ='${current.resourceId}'; document.searchForm.item_name.value ='${current.resourceName}'; document.selectedResources.selected=true; return false;">
											</div>
										</td>

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
					<c:set var="clickjs" value="opener.document.parentform.selected_id8.value = document.searchForm.item_selected.value; opener.document.parentform.resName8.value = document.searchForm.item_name.value; window.close()" />
					<input class="button-clean" type="button" name="select" value="Select" onclick="${clickjs}" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="window.close()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="delete" value="Delete" onclick="opener.document.parentform.selected_id8.value =''; opener.document.parentform.resName8.value =''; window.close()" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
				</span>
			</div>
		</form:form>
	</div>
</body>
</html>