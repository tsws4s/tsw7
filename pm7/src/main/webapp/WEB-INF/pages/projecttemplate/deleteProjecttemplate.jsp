<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.projecttemplate-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="projecttemplate.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="projecttemplate.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.templateid.title"/>:
	</label> 
							${projecttemplate.templateId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.templatename.title"/>:
	</label> 
							${projecttemplate.templateName}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.templatedesc.title"/>:
	</label> 
							${projecttemplate.templateDesc}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.activeyn.title"/>:
	</label> 
							${projecttemplate.activeYn}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteProjecttemplate?projecttemplateIdKey=${projecttemplate.projecttemplateId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexProjecttemplate">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>