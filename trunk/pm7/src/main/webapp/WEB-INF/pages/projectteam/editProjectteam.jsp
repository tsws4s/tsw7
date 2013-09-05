<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.projectteam-resources"/>
<html>
<head>
<title>Edit <fmt:message key="projectteam.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveProjectteam" method="POST" modelAttribute="projectteam" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="projectteam.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="projectteam.title"/>
								<form:hidden id="projectteam_projectteamId" path="projectteamId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
		<c:choose>
			<c:when test='${newFlag}' >
		<label>
			<fmt:message key="projectteam.projectteamid.title"/>:
		</label> 
		<form:input id="projectteam_projectTeamId" path="projectTeamId" cssStyle="width:80px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projectteam_projectTeamId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projectteam.projectteamid.help"/>", constraints : {places:0}}})); </script>
			</c:when>
			<c:otherwise>
				<form:hidden id="projectteam_projectTeamId" path="projectTeamId"/>
			</c:otherwise>
		</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.projectrole.title"/>:
	</label> 

							<form:input id="projectteam_projectRole" path="projectRole" cssStyle="width:150px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projectteam_projectRole",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projectteam.projectrole.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.personprojectesthrs.title"/>:
	</label> 

							<form:input id="projectteam_personProjectEstHrs" path="personProjectEstHrs" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projectteam_personProjectEstHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projectteam.personprojectesthrs.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.personprojectactualhrs.title"/>:
	</label> 

							<form:input id="projectteam_personProjectActualHrs" path="personProjectActualHrs" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projectteam_personProjectActualHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projectteam.personprojectactualhrs.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Projectteam"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexProjectteam">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>