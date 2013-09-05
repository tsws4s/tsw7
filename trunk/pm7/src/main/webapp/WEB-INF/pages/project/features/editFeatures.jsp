<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>Edit <fmt:message key="project.title"/> <fmt:message key="feature.title"/></title>
</head>
<body>
<%-- <div class="group fixed">
		<label>Level</label>
		<select id="itemSelected1" name="selected_id1">
		<option value="">Select level</option>
		<c:forEach items="${levels}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${program.level!=null && current.levelId eq program.level.levelId}">
				<option value="${current.levelId}" selected="selected">${current.levelName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.levelId}">${current.levelName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
 --%>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1><fmt:message key="navigation.edit"/> <fmt:message key="feature.title"/></h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectProject?projectIdKey=${project_projectId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		<form:form action="${pageContext.request.contextPath}/saveProjectFeatures" method="POST" modelAttribute="feature">
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="feature.featureid.title"/>:
						</td>
						<td>
							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="feature_featureId" path="featureId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "feature_featureId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="feature.featureid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${feature.featureId}
						&nbsp;
									<form:hidden id="feature_featureId" path="featureId"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="feature.featurecode.title"/>:
						</td>
						<td>
							<form:input id="feature_featureCode" path="featureCode" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "feature_featureCode",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="feature.featurecode.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="feature.featurename.title"/>:
						</td>
						<td>
							<form:input id="feature_featureName" path="featureName" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "feature_featureName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="feature.featurename.help"/>"}})); </script>
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="feature.featurepriority.title"/>:
						</td>
						<td>
							<form:input id="feature_featurePriority" path="featurePriority" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "feature_featurePriority",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="feature.featurepriority.help"/>"}})); </script>
						</td>
					</tr>
				</tbody>
			</table>
			<span class="inputbutton"><input class="savebutton" id="save" type="submit" value="<fmt:message key="navigation.save"/>"/></span>
			<script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'save', event:'onclick'}));</script>
				<input type="hidden" name="project_projectId" value="${project_projectId}" >
				
				
				
				
				
				
				
				
				
				
		</form:form>
		<div class="clear">&nbsp;</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
