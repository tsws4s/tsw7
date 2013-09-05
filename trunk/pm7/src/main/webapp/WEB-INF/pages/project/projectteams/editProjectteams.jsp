<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>Edit <fmt:message key="project.title"/> <fmt:message key="projectteam.title"/></title>
<script>
function validateForm()
{
    if(document.parentform.program_programName.value=="")
    {
      alert("Name should not be left blank");
      document.parentform.program_programName.focus();
      return false;
    }
    else if(document.parentform.program_startDate.value=="")
    {
      alert("Start Date should not be left blank");
      document.parentform.program_startDate.focus();
      return false;
    }
    else if(document.parentform.program_gamesPerTeam.value=="")
    {
      alert("Number Sessions/Games should not be left blank");
      document.parentform.program_gamesPerTeam.focus();
      return false;
    }
    else if(document.parentform.program_sport.value=="")
    {
      alert("Sport should not be left blank");
      document.parentform.program_sport.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveProjectProjectteams" method="POST" modelAttribute="projectteams" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">Project - ${project_projectId}
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> Team Member
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> Team Member - ${projectteams.projectteamId}
									<form:hidden id="projectteam_projectteamId" path="projectteamId"/>
									<form:hidden id="projectteam_projectteamId" path="project_projectId"/>
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
		<label>Project Member</label>
		<select id="itemSelected1" name="selected_id1">
		<option value="">Select Person</option>
		<c:forEach items="${persons}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${projectteams.person!=null && current.personId eq projectteams.person.personId}">
				<option value="${current.personId}" selected="selected">${current.firstname} ${current.lastname}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.personId}">${current.firstname} ${current.lastname}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>

<div class="group fixed">
	<label>
		<fmt:message key="projectteam.projectrole.title"/>:
	</label> 
		<form:select id="projectteam_projectRole" path="projectRole" selected="${projectteams.projectRole}">				
			<form:option value="--">Select option</form:option>
			<form:option value="ProjMgr">Project Manager</form:option>
			<form:option value="Developer">Developer</form:option>
			<form:option value="Tester">Tester</form:option>
			<form:option value="Other">Other</form:option>
		</form:select>													
		&nbsp;&nbsp;&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.personprojectesthrs.title"/>:
	</label> 
		<form:input id="projectteam_personProjectEstHrs" path="personProjectEstHrs" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projectteam_personProjectEstHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projectteam.personprojectesthrs.help"/>", constraints : {places:0}}})); </script>
</div>

<div class="group fixed">
	<label>
		<fmt:message key="projectteam.personprojectactualhrs.title"/>:
	</label> 
		<form:input id="projectteam_personProjectActualHrs" path="personProjectActualHrs" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projectteam_personProjectActualHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projectteam.personprojectactualhrs.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
	<!-- ## / Panel Content  -->
		</div>						
		<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
			<input class="button-green submit" id="save" type="submit" value="Save Team Member"/>
		 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		 	<a class="button-pink" href="${pageContext.request.contextPath}/editProject?projectIdKey=${project_projectId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
		</div>	
		</form:form>
		</div>
	<div class="shadow"></div>
</div>	
</body>
</html>