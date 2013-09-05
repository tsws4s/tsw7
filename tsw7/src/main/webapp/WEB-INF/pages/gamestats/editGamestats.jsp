<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.gamestats-resources"/>
<html>
<head>
<title>Edit <fmt:message key="gamestats.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="gamestats.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexGamestats"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveGamestats" method="POST" modelAttribute="gamestats">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="gamestats.gamestatsid.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="gamestats_gameStatsId" path="gameStatsId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "gamestats_gameStatsId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="gamestats.gamestatsid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${gamestats.gameStatsId}
						&nbsp;
									<form:hidden id="gamestats_gameStatsId" path="gameStatsId"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="gamestats.sportstattypefk.title"/>:
						</td>
						<td>
							<form:input id="gamestats_sportStatTypeFk" path="sportStatTypeFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "gamestats_sportStatTypeFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="gamestats.sportstattypefk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="gamestats.gamestatvalue.title"/>:
						</td>
						<td>
							<form:input id="gamestats_gameStatValue" path="gameStatValue" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "gamestats_gameStatValue",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="gamestats.gamestatvalue.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="gamestats.gamestattime.title"/>:
						</td>
						<td>
							<input id="gamestats_gameStatTime" name="gameStatTime" type="text" value="<fmt:formatDate value="${gamestats.gameStatTime.time}" timeStyle="short" type="time" />" style="width:300px;"/>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>