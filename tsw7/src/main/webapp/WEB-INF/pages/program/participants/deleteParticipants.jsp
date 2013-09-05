<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>View <fmt:message key="program.title" /> <fmt:message key="participant.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<form:form action="${pageContext.request.contextPath}/saveProgramParticipants" method="POST" modelAttribute="participant">
				<div class="title">
					<h4>
						${participant.program.programName} - <fmt:message key="navigation.delete" /> <fmt:message key="participant.title" />
						(${participant.customer.customerId})<strong> ${participant.customer.firstname} ${participant.customer.lastname}</strong>
					</h4>
					<form:hidden id="participant_participantId" path="participantId" />
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content inpad">

					<fieldset>
						<br />
						<div>
							<label>Participant:&nbsp;&nbsp; 
								<c:if test='${participant.customer != null}'>
									<strong>(${participant.customer.customerId})&nbsp;${participant.customer.firstname}&nbsp;${participant.customer.lastname}</strong>
								</c:if> </label>
						</div>
						<br>
						<div>
							<label><fmt:message key="participant.amtpaid.title" />:&nbsp;&nbsp;
							<strong>${participant.amtPaid}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="participant.signedwaiveryn.title" />:&nbsp;&nbsp; 
								<c:if test='${participant.signedWaiverYn == 1}'>
									<strong>Yes</strong>
								</c:if> </label>
						</div>
						<br>
						<div>
							<label><fmt:message key="participant.group1.title" />:&nbsp;&nbsp;
							<strong>${participant.group1}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="participant.notes.title" />:&nbsp;&nbsp;
							<strong>${participant.notes}</strong></label>
						</div>
						<br>
						<div>
							<label><fmt:message key="participant.activeyn.title" />:&nbsp;&nbsp;
								<c:if test='${participant.activeYn == 1}'>
									<strong>Yes</strong>
								</c:if> </label>
						</div>
						<br />
					</fieldset>
				</div>

				<div class="button-bar">
					<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteProgramParticipants?program_programId=${program_programId}&amp;related_participants_participantId=${participant.participantId}&amp;'" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgram?programIdKey=${program_programId}&amp;indexFrom=0&amp;'" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>
					<input type="hidden" name="program_programId" value="${program_programId}">
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
