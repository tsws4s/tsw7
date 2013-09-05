<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.sportposition-resources"/>
<html>
<head>
<title>Search <fmt:message key="sportposition.title"/>s</title>
</head>
<body>
	<div class="panel">
		<form:form action="#" name="searchForm">
			<div class="title-large">
				<h2>Select Position</h2>
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
									<th><fmt:message key="sportposition.sportpositionname.title" />
									</th>
									<th><fmt:message key="sportposition.numgameplayers.title" />
									</th>
									<th><fmt:message key="sportposition.numteamplayers.title" />
									</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="totalCount" value="0" />
								<c:forEach items="${sport.sportpositions}" var="current" varStatus="i">
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
											<input type="radio" name="selectedSportPosition" value="${current.sportPositionId}" id="test_radio_1"
												onclick="document.searchForm.item_selected.value ='${current.sportPositionId}'; document.searchForm.item_name.value ='${current.sportPositionName}'; document.selectedSportPosition.selected=true; return false;">
											</div>
										</td>
										<td>${current.sportPositionName}&nbsp;</td>
										<td class="text-center">${current.numGamePlayers}&nbsp;</td>
										<td class="text-center">${current.numTeamPlayers}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

				<!-- ## / Panel Content  -->
			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> 
					<c:set var="clickjs" value="opener.document.parentform.selected_sportPosition_id1.value = document.searchForm.item_selected.value; opener.document.parentform.sportPositionName.value = document.searchForm.item_name.value; window.close()" />
					<input class="button-clean" type="button" name="select" value="Select" onclick="${clickjs}" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="window.close()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="delete" value="Delete" onclick="opener.document.parentform.selected_sportPosition_id1.value =''; opener.document.parentform.sportPositionName.value =''; window.close()" />
				 </span>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>
		</form:form>
	</div>

</body>
</html>
