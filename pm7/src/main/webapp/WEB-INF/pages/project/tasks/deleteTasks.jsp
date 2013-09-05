<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.task-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="task.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="task.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="task.taskid.title"/>:
	</label> 
							${task.taskId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.status.title"/>:
	</label> 
							${task.status}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.taskname.title"/>:
	</label> 
							${task.taskName}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.taskdescription.title"/>:
	</label> 
							${task.taskDescription}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.startdate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="both" value="${task.startDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.targetdate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="date" value="${task.targetDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.completedate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="date" value="${task.completeDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.percentcomplete.title"/>:
	</label> 
							${task.percentComplete}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.estimatehrs.title"/>:
	</label> 
							${task.estimateHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.actualhrs.title"/>:
	</label> 
							${task.actualHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="task.tasktype.title"/>:
	</label> 
							${task.taskType}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteProjectTasks?project_projectId=${project_projectId}&related_tasks_taskId=${task.taskId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/editProject?projectIdKey=${project_projectId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>
