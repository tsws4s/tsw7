<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>View <fmt:message key="program.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title">
				<h4>
				<c:choose>
					<c:when test='${program.leagueYn == 1}'>
							<fmt:message key="navigation.delete" /> <fmt:message key="league.title" />
							(${program.programId})<strong> ${program.programName}</strong>
					</c:when>
					<c:otherwise>
							<fmt:message key="navigation.delete" /> <fmt:message key="program.title" />
							(${program.programId})<strong> ${program.programName}</strong>
					</c:otherwise>
				</c:choose>
				</h4>
				<div class="theme"></div>
				<div class="drop"></div>

			</div>
			<div class="content inpad">

				<fieldset>
					<br>
					<div>
						<label><fmt:message key="program.programname.title" />:&nbsp;&nbsp;<strong>
						${program.programName}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.price.title" />:&nbsp;&nbsp;
						<strong>${program.price.priceField}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.startdate.title" />:&nbsp;&nbsp;
						<strong><fmt:formatDate value="${program.startDate.time}" pattern="MM-dd-yyyy" /></strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.enddate.title" />:&nbsp;&nbsp;
						<strong><fmt:formatDate value="${program.endDate.time}" pattern="MM-dd-yyyy" /></strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.leagueyn.title" />:&nbsp;&nbsp;
							<c:if test='${program.leagueYn == 1}'>
								<strong>Yes</strong>
							</c:if> </label>
					</div>
					<br />
				</fieldset>
				<fieldset>
					<br />
					<div>
						<label>Level:&nbsp;&nbsp; 
							<c:if test='${program.level != null}'>
								<strong>${program.level.levelName}&nbsp;</strong>
							</c:if>
						</label>
					</div>
					<br>
					<div>
						<label>Coordinator:&nbsp;&nbsp; 
							<c:if test='${program.customer != null}'>
								<strong>${program.customer.firstname}&nbsp;${program.customer.lastname}&nbsp;</strong>
							</c:if>
						</label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.activeyn.title" />:&nbsp;&nbsp;
							<c:if test='${program.activeYn == 1}'>
								<strong>Yes</strong>
							</c:if> </label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.publishyn.title" />:&nbsp;&nbsp;
							<c:if test='${program.publishYn == 1}'>
								<strong>Yes</strong>
							</c:if> </label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.gamesperteam.title" />:&nbsp;&nbsp;
						<strong>${program.gamesPerTeam}</strong></label>
					</div>
					<br>
					<div>
						<label>Account:&nbsp;&nbsp;
						<strong>${program.tswacct.acctName}</strong></label>
					</div>
				</fieldset>
			</div>
			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteProgram?programIdKey=${program.programId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test='${program.leagueYn == 1}'>
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexLeague'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</c:when>
					<c:otherwise>
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexProgram'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

</body>
</html>