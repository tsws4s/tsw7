<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.team-resources" />
<html>
<head>
<title>View <fmt:message key="team.title" /> <fmt:message
		key="teamplayers.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<form:form action="${pageContext.request.contextPath}/saveTeamTeamplayerses" method="POST" modelAttribute="teamplayers">
				<div class="title-large">
					<h2>
						${teamplayers.team.teamName} - <fmt:message key="navigation.delete" />
						Team Player (${teamplayers.customer.customerId})<strong> ${teamplayers.customer.firstname} ${teamplayers.customer.lastname}</strong>
					</h2>
					<form:hidden id="teamplayers_teamPlayersId" path="teamPlayersId" />
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content inpad">

					<fieldset>
						<br>
						<div>
							<label>Team Player:&nbsp;&nbsp; 
								<c:if test='${teamplayers.customer != null}'>
									<strong>(${teamplayers.customer.customerId})&nbsp;${teamplayers.customer.firstname}&nbsp;${teamplayers.customer.lastname}</strong>
								</c:if>
							</label>
						</div>
						<br>
						<div>
							<label><fmt:message key="teamplayers.amtpaid.title" />:&nbsp;&nbsp;
							<strong>${teamplayers.amtPaid}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="teamplayers.signedwaiveryn.title" />:&nbsp;&nbsp; 
								<c:if test='${teamplayers.signedWaiverYn == 1}'>
									<strong>Yes</strong>
								</c:if> </label>
						</div>
						<br>
						<div>
							<label><fmt:message key="teamplayers.group2.title" />:&nbsp;&nbsp;
							<strong>${teamplayers.group2}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="teamplayers.notes.title" />:&nbsp;&nbsp;
							<strong>${teamplayers.notes}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="teamplayers.activeyn.title" />:&nbsp;&nbsp;
								<c:if test='${teamplayers.activeYn == 1}'>
									<strong>Yes</strong>
								</c:if> </label>
						</div>
					</fieldset>
				</div>

				<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteTeamTeamplayerses?team_teamId=${team_teamId}&amp;related_teamplayerses_teamPlayersId=${teamplayers.teamPlayersId}&amp;'" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgramTeams?program_programId=${program_programId}&amp;program_programName=&amp;teams_teamId=${team_teamId}&amp;'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>