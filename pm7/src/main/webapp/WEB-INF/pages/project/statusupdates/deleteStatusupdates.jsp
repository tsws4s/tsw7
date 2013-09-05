<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>View <fmt:message key="project.title"/> <fmt:message key="statusupdate.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">Project ${project_projectId} - 
									&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="statusupdate.title"/> - ${statusupdate.statusId} 

								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="statusupdate.statusdate.title"/>:
	</label> 
		<fmt:formatDate dateStyle="short" type="date" value="${statusupdate.statusDate.time}"/>
</div>

<div class="group fixed">
	<label>
		<fmt:message key="statusupdate.esthrsleft.title"/>:
	</label> 
		${statusupdate.estHrsLeft}
</div>
<div class="group fixed">
	<label><fmt:message key="statusupdate.riskgyr.title"/>: </label> 
		${statusupdate.riskGyr}
</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="statusupdate.statusupdatedesc.title"/>:
	</label> 
		${statusupdate.statusUpdateDesc}
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteProjectStatusupdates?project_projectId=${project_projectId}&related_statusupdates_statusId=${statusupdate.statusId}&">Confirm Delete</a> 
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/editProject?projectIdKey=${project_projectId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>
