<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.game-resources" />
<html>
<head>
<title>List <fmt:message key="game.title" />s</title>
<script>
function refreshGameList(data)
{
	window.open('${pageContext.request.contextPath}/listProgramGames?programIdKey='+data+'&','_self',false); 
	return false;
}
</script>
</head>
<body>
	<div class="panel">
		<div class="title-large">
			<h2>Manage Games for League:&nbsp;&nbsp;&nbsp;
			<select id="forProgram" name="program1" onchange="javascript:refreshGameList(this.value);return false;">
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
						<th class="text-center">Events&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th>League</th>
						<th>Referee</th>
						<th class="text-center"><fmt:message key="game.gamedate.title" /></th>
						<th>Home Team</th>
						<th class="text-center">Home</th>
						<th>Visitor Team</th>
						<th class="text-center">Visitor</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Events&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th>League</th>
						<th>Referee</th>
						<th class="text-center"><fmt:message key="game.gamedate.title" /></th>
						<th>Home Team</th>
						<th class="text-center">Home</th>
						<th>Visitor Team</th>
						<th class="text-center">Visitor</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${program.games}" var="current" varStatus="i">
						<c:set var="totalCount" value="${totalCount+1}" />
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
								<c:set var="rowclass" value="rowtwo" />
							</c:when>
							<c:otherwise>
								<c:set var="rowclass" value="rowone" />
							</c:otherwise>
						</c:choose>
						<c:set var="resId" value="${program.resource.resourceId}" />
						<c:if test="${current.resource!=null}">
						<c:set var="resId" value="${current.resource.resourceId}" />
						</c:if>
						<tr class="${rowclass}">
							<td style="width:140px;">			
								<a class="button-clean" href="${pageContext.request.contextPath}/scheduling?resource_resourceId=${resId}&amp;afterDate=&amp;beforeDate=&amp;">
								<span><img class="icon" src="explorer/images/icon-calendar.png" alt="Events" /></span></a>
							&nbsp;		
								<a class="button-clean" href="${pageContext.request.contextPath}/editProgramGames?program_programId=${program.programId}&amp;games_gameId=${current.gameId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgramGames?program_programId=${program.programId}&amp;related_games_gameId=${current.gameId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>					

							<td>${current.program.programName}&nbsp;</td>
							<td>${current.customer.firstname}&nbsp;${current.customer.lastname}</td>
							<td class="text-center"><fmt:formatDate type="date" value="${current.gameDate.time}" pattern="MM-dd-yyyy" />&nbsp;</td>
							<td>${current.teamByHomeTeamFk.teamName}&nbsp;</td>
							<td class="text-center">${current.homeScore}&nbsp;</td>
							<td>${current.teamByVisitorTeamFk.teamName}&nbsp;</td>
							<td class="text-center">${current.visitorScore}&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content   -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 10px;"> 
				<input class="button-clean" type="button" name="new" value="New Game" onclick="location.href='${pageContext.request.contextPath}/newProgramGames?program_programId=${program.programId}&amp;program_programName=${program.programName}&amp;'" />
			</span> 
			<span style="padding-left: 70px;">
				<input class="button-clean" type="button" name="teams" value="Teams" onclick="location.href='${pageContext.request.contextPath}/listProgramTeams?programIdKey=${program.programId}&amp;'" />
			</span>
			<c:if test='${(numTeams>1) && (totalCount<1)}'>
				<span style="padding-left: 130px;"> 
				<input class="button-clean" type="button" name="games" value="Generate Games" onclick="location.href='${pageContext.request.contextPath}/generateGames?programIdKey=${program.programId}&amp;'" />
				</span>	
			</c:if>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
		</div>
	</div>

</body>
</html>