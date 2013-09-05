<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.resource-resources" />
<html>
<head>
<title>View <fmt:message key="resource.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title-large">
				<h2>
					<fmt:message key="navigation.delete" /> <fmt:message key="resource.title" />
					(${resource.resourceId}) <strong>${resource.resourceName}</strong>
				</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">

				<fieldset>
					<br />
					<div>
						<label><fmt:message key="resource.resourcename.title" />:&nbsp;&nbsp;
						<strong>${resource.resourceName}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="resource.resourcetype.title" />:&nbsp;&nbsp;
						<strong>${resource.resourceType}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="resource.activeyn.title" />:&nbsp;&nbsp;
							<c:if test='${resource.activeYn == 1}'>
								<strong>Yes</strong>
							</c:if> 
						</label>
					</div>
					<br />
				</fieldset>
				<fieldset>
					<br />
					<div>
						<label><fmt:message key="resource.notes.title" />
						</label> <label><strong>${resource.notes}</strong></label>
					</div>
					<br />
				</fieldset>
			</div>

			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteResource?resourceIdKey=${resource.resourceId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexResource'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>

		</div>
	</div>

</body>
</html>