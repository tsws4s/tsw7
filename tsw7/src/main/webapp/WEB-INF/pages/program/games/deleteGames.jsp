<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>Delete <fmt:message key="game.title" /></title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<form:form action="${pageContext.request.contextPath}/saveProgramGames" method="POST" modelAttribute="game">
				<div class="title">
					<h4>
						${game.program.programName} - <fmt:message key="navigation.delete" />&nbsp;Game (${game.gameId})
					</h4>
					<form:hidden id="game_gameId" path="gameId" />
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content inpad">

					<fieldset>
						<br>
						<div>
							<label><fmt:message key="game.gamedate.title" />:&nbsp;&nbsp;
							<strong><fmt:formatDate dateStyle="short" type="date" value="${game.gameDate.time}" />
							&nbsp;-&nbsp;${game.teamByHomeTeamFk.teamName} vs. ${game.teamByVisitorTeamFk.teamName}</strong></label>
						</div>
						<br>
						<div>
							<label>Home Team:&nbsp;&nbsp;
							<strong>(${game.teamByHomeTeamFk.teamId})&nbsp;${game.teamByHomeTeamFk.teamName}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="game.homescore.title" />:&nbsp;&nbsp;
							<strong>${game.homeScore}</strong></label>
						</div>
						<br>
						<div>
							<label>Visitor Team:&nbsp;&nbsp;
							<strong>(${game.teamByVisitorTeamFk.teamId})&nbsp;${game.teamByVisitorTeamFk.teamName}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="game.visitorscore.title" />:&nbsp;&nbsp;
							<strong>${game.visitorScore}</strong></label>
						</div>
						<br>
					</fieldset>
				</div>

				<div class="button-bar">
					<c:if test="${game.homeScore==null && game.visitorScore==nul}">
					<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteProgramGames?program_programId=${game.program.programId}&amp;related_games_gameId=${game.gameId}&amp;'" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 					</c:if>
					<c:if test="${game.homeScore>0 || game.visitorScore<0}"> 	
 						**Cannot Delete Games Played**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 					</c:if>
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/listProgramGames?programIdKey=${game.program.programId}&amp;'" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>
