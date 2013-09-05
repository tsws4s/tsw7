<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.person-resources"/>
<html>
<head>
<title>View <fmt:message key="person.title"/> <fmt:message key="projectteam.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="projectteam.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectPerson?personIdKey=${person_personId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projectteam.projectteamid.title"/>:
						</td>
						<td>
							${projectteam.projectTeamId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projectteam.projectrole.title"/>:
						</td>
						<td>
							${projectteam.projectRole}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projectteam.personprojectesthrs.title"/>:
						</td>
						<td>
							${projectteam.personProjectEstHrs}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="projectteam.personprojectactualhrs.title"/>:
						</td>
						<td>
							${projectteam.personProjectActualHrs}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deletePersonProjectteams?person_personId=${person_personId}&related_projectteams_projectTeamId=${projectteam.projectTeamId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
