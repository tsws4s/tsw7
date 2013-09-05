<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.task-resources"/>
<html>
<head>
<title>Edit <fmt:message key="task.title"/></title>
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
		<form:form action="${pageContext.request.contextPath}/saveTask" method="POST" modelAttribute="task" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="task.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="task.title"/> - ${task.taskId}
					<%-- 			<form:hidden id="task_taskId" path="taskId"/> --%>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							<li><a href="#" rel="tab-03-content">Dates</a></li>
							<li><a href="#" rel="tab-04-content">Hours</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
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
<div class="group fixed">
	<label>
		* <fmt:message key="task.taskname.title"/>:
	</label> 

							<form:input id="task_taskName" path="taskName" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "task_taskName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="task.taskname.help"/>"}})); </script>
</div>
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
</div>
<div id="tab-02-content">	
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
		<fmt:message key="task.startdate.title"/>:
	</label> 

							<input class="datepicker" id="task_startDate" name="startDate" type="text" value="<fmt:formatDate value="${task.startDate.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "task_startDate",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.targetdate.title"/>:
	</label> 

							<input class="datepicker" id="task_targetDate" name="targetDate" type="text" value="<fmt:formatDate value="${task.targetDate.time}" pattern="MM/dd/yyyy"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:80px;" />
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.completedate.title"/>:
	</label> 

							<input class="datepicker" id="task_completeDate" name="completeDate" type="text" value="<fmt:formatDate value="${task.completeDate.time}" pattern="MM/dd/yyyy"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:80px;" />
</div>

</div>
<div id="tab-04-content">	
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

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Task"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexTask">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
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
					<th><fmt:message key="statusupdate.statusid.title"/></th>
					<th><fmt:message key="statusupdate.statusdate.title"/></th>
					<th><fmt:message key="statusupdate.statusupdatedesc.title"/></th>
					<th><fmt:message key="statusupdate.riskgyr.title"/></th>
<%-- 					<th><fmt:message key="statusupdate.fkresourceid.title"/></th>
					<th><fmt:message key="statusupdate.fkreleaseid.title"/></th>
					<th><fmt:message key="statusupdate.fkdefectid.title"/></th>
					<th><fmt:message key="statusupdate.fkreqmtid.title"/></th>
					<th><fmt:message key="statusupdate.fktaskid.title"/></th>
					<th><fmt:message key="statusupdate.fktestid.title"/></th> --%>
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

					<td>
						
							${current.statusId}
						&nbsp;
					</td>
					<td>
						
							<fmt:formatDate dateStyle="short" type="date" value="${current.statusDate.time}"/>
						&nbsp;
					</td>
					<td>
						
							${current.statusUpdateDesc}
						&nbsp;
					</td>
					<td>
						
							${current.riskGyr}
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