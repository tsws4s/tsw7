<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="project.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="project.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="project.projectid.title"/>:
	</label> 
							${project.projectId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.projectname.title"/>:
	</label> 
							${project.projectName}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.projectdesc.title"/>:
	</label> 
							${project.projectDesc}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.projecttype.title"/>:
	</label> 
							${project.projectType}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.startdate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="both" value="${project.startDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.duedate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="both" value="${project.dueDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.completedate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="both" value="${project.completeDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.estimatehrs.title"/>:
	</label> 
							${project.estimateHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.actualhrs.title"/>:
	</label> 
							${project.actualHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.hrrate.title"/>:
	</label> 
							${project.hrRate}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="project.activeyn.title"/>:
	</label> 
							${project.activeYn}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteProject?projectIdKey=${project.projectId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexProject">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>