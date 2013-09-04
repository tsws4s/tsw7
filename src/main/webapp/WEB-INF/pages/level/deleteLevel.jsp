<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.level-resources" />
<html>
<head>
<title>View <fmt:message key="level.title" /></title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title">
				<h4>
					<fmt:message key="navigation.delete" /> <fmt:message key="level.title" />
					(${level.levelId}) <strong>${level.levelName}</strong>
				</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">
				<fieldset>
					<br />
					<div>
						<label><fmt:message key="level.levelname.title" />:&nbsp;&nbsp;
						<strong>${level.levelName}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="level.levelcode.title" />:&nbsp;&nbsp;
						<strong>${level.levelCode}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="program.activeyn.title" />:&nbsp;&nbsp;
							<c:if test='${level.activeYn == 1}'>
							<strong>Yes</strong>
							</c:if> 
						</label>
					</div>
					<br />
				</fieldset>
				<fieldset>
					<br />
					<div>
						<label><fmt:message key="level.agelow.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${level.ageLow}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="level.agehigh.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${level.ageHigh}</strong></label>
					</div>
					<br />
				</fieldset>
			</div>

			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteLevel?levelIdKey=${level.levelId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexLevel'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>

		</div>
	</div>

</body>
</html>