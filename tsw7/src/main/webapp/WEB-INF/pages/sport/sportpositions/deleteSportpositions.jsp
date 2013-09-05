<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.sport-resources"/>
<html>
<head>
<title>View <fmt:message key="sport.title"/> <fmt:message key="sportposition.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="sportposition.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectSport?sportIdKey=${sport_sportId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sportposition.sportpositionid.title"/>:
						</td>
						<td>
							${sportposition.sportPositionId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sportposition.sportpositionname.title"/>:
						</td>
						<td>
							${sportposition.sportPositionName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sportposition.numgameplayers.title"/>:
						</td>
						<td>
							${sportposition.numGamePlayers}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sportposition.numteamplayers.title"/>:
						</td>
						<td>
							${sportposition.numTeamPlayers}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteSportSportpositions?sport_sportId=${sport_sportId}&related_sportpositions_sportPositionId=${sportposition.sportPositionId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
