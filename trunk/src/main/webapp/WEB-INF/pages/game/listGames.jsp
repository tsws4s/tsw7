<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.game-resources"/>
<html>
<head>
<title>List <fmt:message key="game.title"/>s</title>		
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
						<th><fmt:message key="game.gamedate.title"/></th>
						<th>Home Team</th>
						<th><fmt:message key="game.homescore.title"/></th>
						<th>Visitor Team</th>
						<th><fmt:message key="game.visitorscore.title"/></th>						
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Events&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th>League</th>
						<th><fmt:message key="game.gamedate.title"/></th>
						<th>Home Team</th>
						<th><fmt:message key="game.homescore.title"/></th>
						<th>Visitor Team</th>
						<th><fmt:message key="game.visitorscore.title"/></th>						
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0"/>
					<c:forEach items="${games}" var="current"  varStatus="i">	
						<c:set var="totalCount" value="${totalCount+1}"/>				
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
					    		<c:set var="rowclass" value="rowtwo"/>
							</c:when>
							<c:otherwise>
					    		<c:set var="rowclass" value="rowone"/>
							</c:otherwise>
						</c:choose>
					<tr class="${rowclass}">
				<td width="80px">
				<a class="button-clean" href="${pageContext.request.contextPath}/scheduling">				
				<span><img class="icon" src="explorer/images/icons/icon-calendar.png" alt="Games" /></span></a>
				&nbsp;
				<a class="button-clean" href="${pageContext.request.contextPath}/editProgramGames?program_programId=${current.program.programId}&games_gameId=${current.gameId}&">
				<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
				&nbsp;
				<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgramGames?program_programId=${current.program.programId}&related_games_gameId=${current.gameId}&">
				<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
					</td>
						<td>${current.program.programName}&nbsp;</td>
						<td><fmt:formatDate dateStyle="short" type="date" value="${current.gameDate.time}"/>&nbsp;</td>
						<td>${current.teamByHomeTeamFk.teamName}&nbsp;</td>
						<td>${current.homeScore}&nbsp;</td>
						<td>${current.teamByVisitorTeamFk.teamName}&nbsp;</td>
						<td>${current.visitorScore}&nbsp;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
						<!-- ## / Panel Content   #0099cc  -->
						</div>
	<div class="button-bar">						
		<span style="padding-left:20px;">			
			<input class="button-clean" type="button" name="new" value="New Game" onclick="location.href='${pageContext.request.contextPath}/newGame'" />
		</span>	
		<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
	</div>
</div>

</body>
</html>