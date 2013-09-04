<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.programresource-resources"/>
<html>
<head>
<title>View <fmt:message key="programresource.title"/> <fmt:message key="program.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="program.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectProgramresource?programResourceIdKey=${programresource_programResourceId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.programid.title"/>:
						</td>
						<td>
							${program.programId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.programname.title"/>:
						</td>
						<td>
							${program.programName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.pgmcoordfk.title"/>:
						</td>
						<td>
							${program.pgmCoordFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.pricefk.title"/>:
						</td>
						<td>
							${program.priceFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.startdate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${program.startDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.enddate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${program.endDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.levelfk.title"/>:
						</td>
						<td>
							${program.levelFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.activeyn.title"/>:
						</td>
						<td>
							${program.activeYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.publishyn.title"/>:
						</td>
						<td>
							${program.publishYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.totalpaid.title"/>:
						</td>
						<td>
							${program.totalPaid}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.totalparticipants.title"/>:
						</td>
						<td>
							${program.totalParticipants}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.gamesperteam.title"/>:
						</td>
						<td>
							${program.gamesPerTeam}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.leagueyn.title"/>:
						</td>
						<td>
							${program.leagueYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="program.resourcefk.title"/>:
						</td>
						<td>
							${program.resourceFk}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteProgramresourceProgram?programresource_programResourceId=${programresource_programResourceId}&related_program_programId=${program.programId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
