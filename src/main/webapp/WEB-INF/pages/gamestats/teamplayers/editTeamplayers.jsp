<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.gamestats-resources"/>
<html>
<head>
<title>Edit <fmt:message key="gamestats.title"/> <fmt:message key="teamplayers.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="teamplayers.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectGamestats?gameStatsIdKey=${gamestats_gameStatsId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveGamestatsTeamplayers" method="POST" modelAttribute="teamplayers">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.teamplayersid.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="teamplayers_teamPlayersId" path="teamPlayersId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_teamPlayersId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.teamplayersid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${teamplayers.teamPlayersId}
						&nbsp;
									<form:hidden id="teamplayers_teamPlayersId" path="teamPlayersId"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.teamfk.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_teamFk" path="teamFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_teamFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.teamfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.customerfk.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_customerFk" path="customerFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_customerFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.customerfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.levelfk.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_levelFk" path="levelFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_levelFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.levelfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.amtpaid.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_amtPaid" path="amtPaid" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_amtPaid",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.amtpaid.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.notes.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_notes" path="notes" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_notes",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.notes.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.group2.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_group2" path="group2" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_group2",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.group2.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.signedwaiveryn.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_signedWaiverYn" path="signedWaiverYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_signedWaiverYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.signedwaiveryn.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.activeyn.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_activeYn" path="activeYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_activeYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.activeyn.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.captain.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_captain" path="captain" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_captain",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.captain.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.sportpositionfk.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_sportPositionFk" path="sportPositionFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_sportPositionFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.sportpositionfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="teamplayers.otheramtpaid.title"/>:
						</td>
						<td>
							<form:input id="teamplayers_otherAmtPaid" path="otherAmtPaid" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "teamplayers_otherAmtPaid",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="teamplayers.otheramtpaid.help"/>"}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="gamestats_gameStatsId" value="${gamestats_gameStatsId}" >
				
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
