<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>Edit <fmt:message key="project.title"/> <fmt:message key="task.title"/></title>
<script>
function validateForm()
{
    if(document.parentform.event_eventName.value=="")
    {
      alert("Event Name should not be left blank");
      document.parentform.event_eventName.focus();
      return false;
    }
    else if(document.parentform.event_startTime.value=="")
    {
      alert("Start Time should not be left blank (unless All Day)");
      document.parentform.event_startTime.focus();
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
		<form:form action="${pageContext.request.contextPath}/saveProjectTasks" method="POST" modelAttribute="task" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >&nbsp;&nbsp;Project - ${project_projectId}
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="task.title"/>
								</c:when>
								<c:otherwise>&nbsp;&nbsp;Project - ${project_projectId}
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="task.title"/> - ${task.taskId}
								<form:hidden id="task_taskId" path="taskId"/>
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
<div class="group fixed">
	<label>
		* <fmt:message key="task.taskname.title"/>:
	</label> 
		<form:input id="task_taskName" path="taskName" cssStyle="width:250px;"/>
</div>
</td>
<td style="border-top:0px;border-left:0px;">
<div class="group">
	<label>
		* Start:
	</label> 
		<input class="datepicker" id="task_startDate" name="startDate" type="text" value="<fmt:formatDate value="${task.startDate.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
</div>
</td></tr>
<tr><td colspan=2 style="border-top:0px;border-left:0px;">
<div class="group fixed">
	<label>
		<fmt:message key="task.tasktype.title"/>:
	</label> 
		<form:select id="task_taskType" path="taskType" selected="${task.taskType}">							
			<form:option value="--">Select option</form:option>
			<form:option value="Requirement">Requirement</form:option>
			<form:option value="Change Request">Change Request</form:option>
			<form:option value="Test Case">Test Case</form:option>
			<form:option value="Defect">Defect</form:option>					
		</form:select>													
		&nbsp;&nbsp;&nbsp;
</div>

</td><td style="border-top:0px;border-left:0px;">
<div class="group">
	<label>
		&nbsp;&nbsp;&nbsp;Due:
	</label> 
		<input class="datepicker" id="task_targetDate" name="targetDate" type="text" value="<fmt:formatDate value="${task.targetDate.time}" pattern="MM/dd/yyyy"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:80px;" />
</div>
</td></tr>
<tr><td colspan=1 style="border-top:0px;border-left:0px;">

<div class="group">
	<div class="progress-bar">
		<span>${task.percentComplete+0}%</span>
		<div><div style="width:${task.percentComplete+0}%"></div></div>
	</div>
</div>
</td><td colspan=2 style="border-top:0px;border-left:0px;">

<div class="group fixed left">
	<label>
		* <fmt:message key="task.status.title"/>:
	</label> 

		<form:select id="task_status" path="status" selected="${task.status}">							
			<form:option value="--">Select option</form:option>
			<form:option value="Open">Open</form:option>
			<form:option value="Hold">Hold</form:option>
			<form:option value="Cancel">Cancel</form:option>
			<form:option value="Closed">Closed</form:option>					
		</form:select>													
			&nbsp;&nbsp;&nbsp;
	</div>
</td></tr>

</tbody></table>

</div>
<div id="tab-02-content">
	<c:choose>
		<c:when test="${task.taskType=='Requirement'}" >
	
	<div class="group fixed">
		<label>Requirement</label>
		<select id="itemSelected3" name="selected_id3" style="width: 350px;">
		<option value="">Select Requirement</option>
		<c:forEach items="${reqmts}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${task.requirement!=null && current.reqmtId eq task.requirement.reqmtId}">
				<option value="${current.reqmtId}" selected="selected">${current.reqmtCode}-${current.reqmtName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.reqmtId}">${current.reqmtCode}-${current.reqmtName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
			</c:when>
		<c:when test="${task.taskType=='Change Request'}" >
	<div class="group fixed">
		<label>Change Request</label>
		<select id="itemSelected4" name="selected_id4" style="width: 350px;">
		<option value="">Select Change Request</option>
		<c:forEach items="${changereqs}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${task.changerequest!=null && current.changeId eq task.changerequest.changeId}">
				<option value="${current.changeId}" selected="selected">${current.changeCode}-${current.changeName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.changeId}">${current.changeCode}-${current.changeName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
			</c:when>
		<c:when test="${task.taskType=='Test Case'}" >
		<div class="group fixed">
		<label>Test Case</label>
		<select id="itemSelected5" name="selected_id5" style="width: 350px;">
		<option value="">Select Test Case</option>
		<c:forEach items="${tests}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${task.testcase!=null && current.testId eq task.testcase.testId}">
				<option value="${current.testId}" selected="selected">${current.testCaseCode}-${current.testName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.testId}">${current.testCaseCode}-${current.testName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
		</c:when>
		<c:when test="${task.taskType=='Defect'}" >
		<div class="group fixed">
		<label>Defect</label>
		<select id="itemSelected6" name="selected_id6" style="width: 350px;">
		<option value="">Select Defect</option>
		<c:forEach items="${defects}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${task.defect!=null && current.defectId eq task.defect.defectId}">
				<option value="${current.defectId}" selected="selected">${current.defectId}-${current.defectName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.defectId}">${current.defectId}-${current.defectName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>		
		</c:when>
		<c:otherwise> 
			&nbsp;&nbsp;&nbsp;*** Select Task Type ***&nbsp;&nbsp;&nbsp;
		</c:otherwise>
	</c:choose>
	
<div class="group fixed">
	<label>
		<fmt:message key="task.taskdescription.title"/>:
	</label> 

	<form:textarea id="task_taskDescription" path="taskDescription" cssStyle="width:500px;"/>
	<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "task_taskDescription",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="task.taskdescription.help"/>"}})); </script>
</div>
</div>

<div id="tab-03-content">	
<div class="group fixed">
	<label>
		<fmt:message key="task.estimatehrs.title"/>:
	</label> 
		<form:input id="task_estimateHrs" path="estimateHrs" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "task_estimateHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="task.estimatehrs.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.actualhrs.title"/>:
	</label> 
		<form:input id="task_actualHrs" path="actualHrs" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "task_actualHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="task.actualhrs.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.percentcomplete.title"/>:
	</label> 
		<form:input id="task_percentComplete" path="percentComplete" cssStyle="width:50px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "task_percentComplete",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="task.percentcomplete.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.completedate.title"/>:
	</label> 
	<input class="datepicker" id="task_completeDate" name="completeDate" type="text" value="<fmt:formatDate value="${task.completeDate.time}" pattern="MM/dd/yyyy"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:80px;" />
</div>
</div>
	<!-- ## / Panel Content  -->
	</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Task"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/editProject?projectIdKey=${project_projectId}">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
				<input type="hidden" name="project_projectId" value="${project_projectId}" >

</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	



	<!--   Status Updates   -->

	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Status Updates</h4>
			</div>
			<div class="content">
				<!-- ## Panel Content  -->
			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th class="center"><fmt:message key="statusupdate.statusdate.title"/></th>
					<th class="center"><fmt:message key="statusupdate.riskgyr.title"/></th>
					<th class="center"><fmt:message key="statusupdate.esthrsleft.title"/></th>
					<th><fmt:message key="statusupdate.statusupdatedesc.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${task.statusupdates}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editTaskStatusupdates?task_taskId=${task.taskId}&statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteTaskStatusupdates?task_taskId=${task.taskId}&related_statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>
					<td class="center">
						
							<fmt:formatDate dateStyle="short" type="date" value="${current.statusDate.time}"/>
						&nbsp;
					</td>
					<td class="center">
						
							${current.riskGyr}
						&nbsp;
					</td>

					<td class="center">
						
							${current.estHrsLeft}
						&nbsp;
					</td>
					<td>
						
							${current.statusUpdateDesc}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
				<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">
				<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newTaskStatusupdates?task_taskId=${task.taskId}">New Statusupdate <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>

</body>
</html>
