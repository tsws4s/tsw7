<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.timeslotstst-resources"/>
<html>
<head>
<title>Edit <fmt:message key="timeslotstst.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="timeslotstst.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/indexTimeslotstst"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveTimeslotstst" method="POST" modelAttribute="timeslotstst">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.timeslotid.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="timeslotstst_timeslotId" path="timeslotId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_timeslotId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.timeslotid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${timeslotstst.timeslotId}
						&nbsp;
									<form:hidden id="timeslotstst_timeslotId" path="timeslotId"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.timeslot.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_timeslot" path="timeslot" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_timeslot",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.timeslot.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.date.title"/>:
						</td>
						<td>
							<input id="timeslotstst_date" name="date" type="text" value="<fmt:formatDate value="${timeslotstst.date.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.start.title"/>:
						</td>
						<td>
							<input id="timeslotstst_start" name="start" type="text" value="<fmt:formatDate value="${timeslotstst.start.time}" timeStyle="short" type="time" />" style="width:300px;"/>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.end.title"/>:
						</td>
						<td>
							<input id="timeslotstst_end" name="end" type="text" value="<fmt:formatDate value="${timeslotstst.end.time}" timeStyle="short" type="time" />" style="width:300px;"/>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.pricelevel.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_priceLevel" path="priceLevel" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_priceLevel",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.pricelevel.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.custdisplay.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_custDisplay" path="custDisplay" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_custDisplay",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.custdisplay.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.custfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_custFk" path="custFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_custFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.custfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.gamefk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_gameFk" path="gameFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_gameFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.gamefk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.modifiedlast.title"/>:
						</td>
						<td>
							<input id="timeslotstst_modifiedLast" name="modifiedLast" type="text" value="<fmt:formatDate value="${timeslotstst.modifiedLast.time}" pattern="MM/dd/yyyy h:mm a"/>" style="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_modifiedLast",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.modifiedbyuserfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_modifiedByUserFk" path="modifiedByUserFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_modifiedByUserFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.modifiedbyuserfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.zamoperatorcustfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_zamOperatorCustFk" path="zamOperatorCustFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_zamOperatorCustFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.zamoperatorcustfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.activeyn.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_activeYn" path="activeYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_activeYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.activeyn.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.concessionwkrcustfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_concessionWkrCustFk" path="concessionWkrCustFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_concessionWkrCustFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.concessionwkrcustfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.officewkrcustfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_officeWkrCustFk" path="officeWkrCustFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_officeWkrCustFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.officewkrcustfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.t3sfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_t3sFk" path="t3sFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_t3sFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.t3sfk.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.belongstoresid.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_belongsToResId" path="belongsToResId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_belongsToResId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.belongstoresid.help"/>", constraints : {places:0}}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="timeslotstst.programfk.title"/>:
						</td>
						<td>
							<form:input id="timeslotstst_programFk" path="programFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeslotstst_programFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeslotstst.programfk.help"/>", constraints : {places:0}}})); </script>
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