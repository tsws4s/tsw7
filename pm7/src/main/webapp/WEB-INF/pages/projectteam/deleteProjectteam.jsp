<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.projectteam-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="projectteam.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="projectteam.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="projectteam.projectteamid.title"/>:
	</label> 
							${projectteam.projectTeamId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.projectrole.title"/>:
	</label> 
							${projectteam.projectRole}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.personprojectesthrs.title"/>:
	</label> 
							${projectteam.personProjectEstHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projectteam.personprojectactualhrs.title"/>:
	</label> 
							${projectteam.personProjectActualHrs}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteProjectteam?projectteamIdKey=${projectteam.projectteamId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexProjectteam">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>