<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.team-resources" />
<html>
<head>
<title>List <fmt:message key="team.title" />s</title>
</head>
<body>
	<div class="panel">
		<form:form action="#" name="searchForm">
			<div class="title-large">
				<h2>${program.programName}&nbsp;Teams</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>

			<input type="hidden" id="selectSearch" name="item_selected" />
			<input type="hidden" id="selectName" name="item_name" />
			<div class="content">

				<table class="tabularData">

					<thead>
						<tr>
							<th>&nbsp;</th>
							<th><fmt:message key="team.teamname.title" /></th>
							<th>Level</th>
							<th>Coach</th>
							<th><fmt:message key="team.group3.title" /></th>
							<th><fmt:message key="team.color.title" /></th>
						</tr>
					</thead>
					<tbody>
						<c:set var="totalCount" value="0" />
						<c:forEach items="${program.teams}" var="current" varStatus="i">
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
								<input type="radio" name="selectedTeam" value="${current.teamId}"
									onclick="document.searchForm.item_selected.value ='${current.teamId}'; document.searchForm.item_name.value ='${current.teamName}'; document.selectedTeam.selected=true; return false;">
								</div>
								</td>
								<td>${current.teamName}&nbsp;</td>
								<td>${current.level.levelName}&nbsp;</td>
								<td>${current.customerByCoachCustFk.firstname}&nbsp;${current.customerByCoachCustFk.lastname}&nbsp;&nbsp;</td>
								<td>${current.group3}&nbsp;</td>
								<td>${current.color}&nbsp;</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> <c:set var="clickjs" value="opener.document.parentform.selected_id${teamNum}.value = document.searchForm.item_selected.value; opener.document.parentform.teamName${teamNum}.value = document.searchForm.item_name.value; window.close()" />
				<input class="button-clean" type="button" name="select" value="Select" onclick="${clickjs}" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="window.close()" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="delete" value="Delete" onclick="opener.document.parentform.selected_id${teamNum}.value =''; opener.document.parentform.teamName${teamNum}.value =''; window.close()" />
				</span>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
			</div>
		</form:form>
	</div>
</body>
</html>
