<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.team-resources" />
<html>
<head>
<title>List <fmt:message key="team.title" />s</title>
<script>
function refreshTeamList(data)
{
	window.open('${pageContext.request.contextPath}/listProgramTeams?programIdKey='+data+'&','_self',false); 
	return false;
}
</script>
</head>
<body>
	<div class="panel">
		<div class="title-large">
			<h2>Manage Teams for League:&nbsp;&nbsp;&nbsp;
			<select id="forProgram" name="program1" onchange="javascript:refreshTeamList(this.value);return false;">
				<c:forEach items="${leagues}" var="current" varStatus="i">
				<c:choose>
				<c:when test="${program!=null && current.programId eq program.programId}">
					<option value="${current.programId}" selected="selected">${current.programName}</option>
				</c:when>
				<c:otherwise>
					<option value="${current.programId}">${current.programName}</option>
				</c:otherwise>									
				</c:choose>
				</c:forEach>
			</select></h2>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">

			<table class="tabularData">

				<thead>
					<tr>
						<th class="text-center">Games&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="team.teamname.title" />
						</th>
						<th>Coach</th>
						<th class="text-center">Paid</th>
						<th><fmt:message key="team.group3.title" />
						</th>
						<th><fmt:message key="team.color.title" />
						</th>
						<th class="text-center"><fmt:message key="team.wins.title" />
						</th>
						<th class="text-center"><fmt:message key="team.losses.title" />
						</th>
						<th class="text-center"><fmt:message key="team.ties.title" />
						</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Games&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="team.teamname.title" />
						</th>
						<th>Coach</th>
						<th class="text-center">Paid</th>
						<th><fmt:message key="team.group3.title" />
						</th>
						<th><fmt:message key="team.color.title" />
						</th>
						<th class="text-center"><fmt:message key="team.wins.title" />
						</th>
						<th class="text-center"><fmt:message key="team.losses.title" />
						</th>
						<th class="text-center"><fmt:message key="team.ties.title" />
						</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${teams}" var="current" varStatus="i">
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
							<td>			
								<a class="button-clean" href="${pageContext.request.contextPath}/listProgramGames?programIdKey=${program.programId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-calendar.png" alt="Events" /></span></a>
							&nbsp;
							<td>			
								<a class="button-clean" href="${pageContext.request.contextPath}/editProgramTeams?program_programId=${program.programId}&amp;program_programName=${program.programName}&amp;teams_teamId=${current.teamId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgramTeams?program_programId=${program.programId}&amp;program_programName=${program.programName}&amp;related_teams_teamId=${current.teamId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>	
								
							<td>${current.teamName}&nbsp;</td>
							<td>${current.customerByCoachCustFk.firstname}&nbsp;${current.customerByCoachCustFk.lastname}&nbsp;</td>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber var="fmtPaid" value="${current.amtPaid}" type="currency" pattern="$#,##0.00;" />
							<td class="text-right">${fmtPaid}&nbsp;</td>
							<td>${current.group3}&nbsp;</td>
							<td>${current.color}&nbsp;</td>
							<td class="text-center">${current.wins}&nbsp;</td>
							<td class="text-center">${current.losses}&nbsp;</td>
							<td class="text-center">${current.ties}&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content    -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New Team" onclick="location.href='${pageContext.request.contextPath}/newTeam'" />
			</span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
		</div>
	</div>
</body>
</html>