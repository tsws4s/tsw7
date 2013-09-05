<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.users-resources" />
<html>
<head>
<title>View <fmt:message key="users.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title">
				<h4>
					<fmt:message key="navigation.delete" /> <fmt:message key="users.title" />
					(${users.userId}) <strong>${users.username}</strong>
				</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">

				<fieldset>
					<div>
						<label><fmt:message key="users.username.title" />:&nbsp;&nbsp;
							${users.username}</label>
					</div>
					<br>
					<div>
						<label><fmt:message key="users.password.title" />:&nbsp;&nbsp;***********</label>
					</div>
					<br>
					<div>
						<label><fmt:message key="users.activeyn.title" />:&nbsp;&nbsp;&nbsp;
							${users.activeYn}</label>
					</div>
					<br>
					<div>
						<label>User Customer:&nbsp;&nbsp;
						(${users.customer.customerId})&nbsp;${users.customer.firstname}&nbsp;${users.customer.lastname}</label> 
					</div>
					<br>
					<div>
						<label>List Results per Page</label> 3
					</div>
					<br>
					<div>Theme: Default</div>
				</fieldset>
			</div>

			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteUsers?userIdKey=${users.userId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexUsers'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>

		</div>
	</div>

</body>
</html>
