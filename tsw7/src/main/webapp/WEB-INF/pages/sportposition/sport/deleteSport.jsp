<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.sportposition-resources"/>
<html>
<head>
<title>View <fmt:message key="sportposition.title"/> <fmt:message key="sport.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="sport.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectSportposition?sportPositionIdKey=${sportposition_sportPositionId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.sportid.title"/>:
						</td>
						<td>
							${sport.sportId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.sportname.title"/>:
						</td>
						<td>
							${sport.sportName}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.wikiurl.title"/>:
						</td>
						<td>
							${sport.wikiUrl}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.activeyn.title"/>:
						</td>
						<td>
							${sport.activeYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.numgameplayers.title"/>:
						</td>
						<td>
							${sport.numGamePlayers}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.numteamroster.title"/>:
						</td>
						<td>
							${sport.numTeamRoster}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="sport.normalseason.title"/>:
						</td>
						<td>
							${sport.normalSeason}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteSportpositionSport?sportposition_sportPositionId=${sportposition_sportPositionId}&related_sport_sportId=${sport.sportId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
