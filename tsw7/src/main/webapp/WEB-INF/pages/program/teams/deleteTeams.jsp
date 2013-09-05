<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.program-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="team.title"/></title>
</head>
<body>
	<div class="formular">
		<div class="panel">
	<form:form action="${pageContext.request.contextPath}/saveProgramTeams" method="POST" modelAttribute="team">
			<div class="title">
				<h4>${team.program.programName}&nbsp;-&nbsp;<fmt:message key="navigation.delete"/>&nbsp;Team
								 (${team.teamId})<strong> ${team.teamName}</strong></h4>
								    <form:hidden id="team_teamId" path="teamId"/>
		<div class="theme"></div>
		<div class="drop"></div>
		</div>
	<div class="content inpad">

<fieldset><br>
<div>
			<label><fmt:message key="team.teamname.title"/>:&nbsp;&nbsp;<strong>${team.teamName}</strong></label>
</div>
<br>
<div>
			<label>Level:&nbsp;&nbsp;
					<c:if test='${team.level != null}'>
						<strong>(${team.level.levelId})&nbsp;${team.level.levelName}</strong>
					</c:if>
					</label>
</div>
<br>
<div>
			<label><fmt:message key="team.group3.title"/>:&nbsp;&nbsp;<strong>${team.group3}</strong></label>
</div>
<br>
<div>	
			<label><fmt:message key="team.color.title"/>:&nbsp;&nbsp;<strong>${team.color}</strong></label>
</div>
<br>
<div>
			<label><fmt:message key="team.amtpaid.title"/>:&nbsp;&nbsp;<strong>${team.amtPaid}</strong></label>
</div>
<br>
<div>
			<label><fmt:message key="team.publishyn.title"/>:&nbsp;&nbsp; 
		<c:if test='${team.publishYn == 1}'>				
			<strong>Yes</strong>
		</c:if>				
		</label>	
</div>
</fieldset>
<fieldset><br>
<div>
			<label>Coach:&nbsp;&nbsp;	
					<c:if test='${team.customerByCoachCustFk != null}'>
						<strong>(${team.customerByCoachCustFk.customerId})&nbsp;${team.customerByCoachCustFk.firstname}&nbsp;${team.customerByCoachCustFk.lastname}</strong>
					</c:if>
					</label>
</div>
<br>
<div>
			<label>Manager:&nbsp;&nbsp; 
					<c:if test='${team.customerByManagerCustFk != null}'>
						<strong>(${team.customerByManagerCustFk.customerId})&nbsp;${team.customerByManagerCustFk.firstname}&nbsp;${team.customerByManagerCustFk.lastname}</strong>
					</c:if>
					</label>
</div>
<br>
<div>
			<label><fmt:message key="team.notes.title"/>:&nbsp;&nbsp;<strong>${team.notes}</strong></label>
</div>
<br>
<div>
			<label><fmt:message key="team.activeyn.title"/>:&nbsp;&nbsp; 
		<c:if test='${team.activeYn == 1}'>				
			<strong>Yes</strong>	
		</c:if>			
	</label>
</div>
</fieldset>
<fieldset><br>
<div>	
			<label><fmt:message key="team.wins.title"/>:&nbsp;&nbsp;<strong>${team.wins}</strong></label>
</div>
<br>
<div>
			<label><fmt:message key="team.losses.title"/>:&nbsp;&nbsp;<strong>${team.losses}</strong></label>
</div>
<br>
<div>
			<label><fmt:message key="team.ties.title"/>:&nbsp;&nbsp;<strong>${team.ties}</strong></label>
</div>
</fieldset>	
</div>

			<div class="button-bar">						
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteProgramTeams?program_programId=${team.program.programId}&related_teams_teamId=${team.teamId}&'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgram?programIdKey=${team.program.programId}&indexFrom=0&'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
			</div>	
		</form:form>						
	</div>
</div>			

</body>
</html>
