<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.gamestats-resources"/>
<html>
<head>
<title>View <fmt:message key="gamestats.title"/> <fmt:message key="game.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="game.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectGamestats?gameStatsIdKey=${gamestats_gameStatsId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.gameid.title"/>:
						</td>
						<td>
							${game.gameId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.hometeamfk.title"/>:
						</td>
						<td>
							${game.homeTeamFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.visitorteamfk.title"/>:
						</td>
						<td>
							${game.visitorTeamFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.gamedate.title"/>:
						</td>
						<td>
							<fmt:formatDate dateStyle="short" type="date" value="${game.gameDate.time}"/>
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.homescore.title"/>:
						</td>
						<td>
							${game.homeScore}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.visitorscore.title"/>:
						</td>
						<td>
							${game.visitorScore}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.refereefk.title"/>:
						</td>
						<td>
							${game.refereeFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="game.activeyn.title"/>:
						</td>
						<td>
							${game.activeYn}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteGamestatsGame?gamestats_gameStatsId=${gamestats_gameStatsId}&related_game_gameId=${game.gameId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
