<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.gamestats-resources"/>
<html>
<head>
<title>View <fmt:message key="gamestats.title"/> <fmt:message key="teamplayers.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="teamplayers.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectGamestats?gameStatsIdKey=${gamestats_gameStatsId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.teamplayersid.title"/>:
						</td>
						<td>
							${teamplayers.teamPlayersId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.teamfk.title"/>:
						</td>
						<td>
							${teamplayers.teamFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.customerfk.title"/>:
						</td>
						<td>
							${teamplayers.customerFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.levelfk.title"/>:
						</td>
						<td>
							${teamplayers.levelFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.amtpaid.title"/>:
						</td>
						<td>
							${teamplayers.amtPaid}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.notes.title"/>:
						</td>
						<td>
							${teamplayers.notes}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.group2.title"/>:
						</td>
						<td>
							${teamplayers.group2}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.signedwaiveryn.title"/>:
						</td>
						<td>
							${teamplayers.signedWaiverYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.activeyn.title"/>:
						</td>
						<td>
							${teamplayers.activeYn}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.captain.title"/>:
						</td>
						<td>
							${teamplayers.captain}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.sportpositionfk.title"/>:
						</td>
						<td>
							${teamplayers.sportPositionFk}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.otheramtpaid.title"/>:
						</td>
						<td>
							${teamplayers.otherAmtPaid}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/deleteGamestatsTeamplayers?gamestats_gameStatsId=${gamestats_gameStatsId}&related_teamplayers_teamPlayersId=${teamplayers.teamPlayersId}&"><span><img src="images/icons/delete.gif" /><fmt:message key="navigation.delete"/></span></a></div>
			<div class="clear">&nbsp;</div>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
