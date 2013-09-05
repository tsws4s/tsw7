<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>Edit <fmt:message key="project.title"/></title>
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
 <script>
$(function() {
	$( ".datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "css/images/icons/icon-calendar.png",
		buttonImageOnly: true,
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true
	});
});
</script>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveProject" method="POST" modelAttribute="project" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="project.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="project.title"/> - ${project.projectId}
								<form:hidden id="project_projectId" path="projectId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							<li><a href="#" rel="tab-03-content">Hours</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	
<table><tbody>
<tr height="60px"><td colspan=2 style="border-top:0px;border-left:0px;">
<div class="group ">
	<label>
		<fmt:message key="project.projectname.title"/>:
	</label> 
		<form:input id="project_projectName" path="projectName" cssStyle="width:250px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_projectName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="project.projectname.help"/>"}})); </script>
</div>
</td>
<td style="border-top:0px;border-left:0px;">
<div class="group">
	<label>
		* Start:
	</label> 
		<input class="datepicker" id="project_startDate" name="startDate" type="text" value="<fmt:formatDate value="${project.startDate.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
</div>
</td></tr>
<tr><td colspan=2 style="border-top:0px;border-left:0px;">
<div class="group">
	<div class="progress-bar">
		<span>${project.percentComplete+0}%</span>
		<div><div style="width:${project.percentComplete+0}%"></div></div>
	</div>
</div>
</td><td style="border-top:0px;border-left:0px;">
<div class="group">
	<label>
		&nbsp;&nbsp;&nbsp;Due:
	</label> 
	<input class="datepicker" id="project_dueDate" name="dueDate" type="text" value="<fmt:formatDate value="${project.dueDate.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
</div>
</td></tr>

</tbody></table>
</div>
<div id="tab-02-content">	

<div class="group fixed">
	<label>
		<fmt:message key="project.projecttype.title"/>:
	</label> 
		<form:select id="project_projectType" path="projectType" selected="${project.projectType}">							
			<form:option value="--">Select option</form:option>
			<form:option value="WebApp">Web Application</form:option>
			<form:option value="Website">Web Site</form:option>
			<form:option value="Other">Other</form:option>
		</form:select>													
	&nbsp;&nbsp;&nbsp;
</div>

	<div class="group fixed">
		<label>Project Manager</label>
		<select id="itemSelected1" name="selected_id1">
		<option value="">Select Person</option>
		<c:forEach items="${persons}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${project.personByFkProjMgrId!=null && current.personId eq project.personByFkProjMgrId.personId}">
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
		<fmt:message key="project.projectdesc.title"/>:
	</label> 
		<form:textarea id="project_projectDesc" path="projectDesc" cssStyle="width:500px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_projectDesc",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="project.projectdesc.help"/>"}})); </script>
</div>

</div>
<div id="tab-03-content">
<div class="group fixed">
	<label>
		<fmt:message key="project.completedate.title"/>:
	</label> 
	<input class="datepicker" id="project_completeDate" name="completeDate" type="text" value="<fmt:formatDate value="${project.completeDate.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
	<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_completeDate",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		Percent Complete:
	</label> 
		<form:input id="project_percentComplete" path="percentComplete" cssStyle="width:50px;"/>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.estimatehrs.title"/>:
	</label> 
		<form:input id="project_estimateHrs" path="estimateHrs" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_estimateHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="project.estimatehrs.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.actualhrs.title"/>:
	</label> 
		<form:input id="project_actualHrs" path="actualHrs" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_actualHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="project.actualhrs.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.hrrate.title"/>:
	</label> 
		<form:input id="project_hrRate" path="hrRate" cssStyle="width:80px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_hrRate",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="project.hrrate.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.activeyn.title"/>:
	</label> 
		<form:checkbox id="project_activeYn" path="activeYn" value=""/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "project_activeYn",widgetType : "dijit.form.CheckBox",widgetAttrs : {promptMessage: "<fmt:message key="project.activeyn.help"/>", constraints : {places:0}}})); </script>
</div>

	<div class="group fixed">
		<label>Client</label>
		<select id="itemSelected2" name="selected_id2">
		<option value="">Select Client</option>
		<c:forEach items="${clients}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${project.client!=null && current.clientId eq project.client.clientId}">
				<option value="${current.clientId}" selected="selected">${current.clientName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.clientId}">${current.clientName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
</div>
	<!-- ## / Panel Content  -->
	</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Project"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexProject">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

<!--   Project Tasks   -->

				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Manage <fmt:message key="task.title"/>s</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="task.tasktype.title"/></th>
					<th><fmt:message key="task.taskname.title"/></th>
					<th><fmt:message key="task.status.title"/></th>
					<th class="center"><fmt:message key="task.targetdate.title"/></th>
					<th class="center">Complete %</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${project.tasks}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editProjectTasks?project_projectId=${project.projectId}&tasks_taskId=${current.taskId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteProjectTasks?project_projectId=${project.projectId}&related_tasks_taskId=${current.taskId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>
					<td>					
							${current.taskType}
						&nbsp;
					</td>

					<td>				
							${current.taskName}
						&nbsp;
					</td>
					<td>			
							${current.status}
						&nbsp;
					</td>
					<td class="center">	
							<fmt:formatDate dateStyle="short" type="date" value="${current.targetDate.time}"/>
						&nbsp;
					</td>
					<td class="center">
							${current.percentComplete+0}%
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
						</div>
	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newProjectTasks?project_projectId=${project.projectId}&">New Task <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>						
			</div>
		</div>
		<div class="shadow"></div>
	</div>	

	<!--   Project Team Members   -->
				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Project Team Members</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="projectteam.title"/></th>
					<th><fmt:message key="projectteam.projectrole.title"/></th>
					<th><fmt:message key="projectteam.personprojectesthrs.title"/></th>
					<th><fmt:message key="projectteam.personprojectactualhrs.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${project.projectteams}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editProjectProjectteams?project_projectId=${project.projectId}&projectteams_projectTeamId=${current.projectTeamId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteProjectProjectteams?project_projectId=${project.projectId}&related_projectteams_projectTeamId=${current.projectTeamId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.person.firstname} ${current.person.lastname}
						&nbsp;
					</td>
					<td>
						
							${current.projectRole}
						&nbsp;
					</td>
					<td>
						
							${current.personProjectEstHrs}
						&nbsp;
					</td>
					<td>
						
							${current.personProjectActualHrs}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
						</div>
	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newProjectProjectteams?project_projectId=${project.projectId}&">New Projectteam <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
			</div>
		</div>
		<div class="shadow"></div>
	</div>	




</body>
</html>