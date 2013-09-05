<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.projecttemplate-resources"/>
<html>
<head>
<title>Edit <fmt:message key="projecttemplate.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveProjecttemplate" method="POST" modelAttribute="projecttemplate" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="projecttemplate.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="projecttemplate.title"/>
								<form:hidden id="projecttemplate_projecttemplateId" path="projecttemplateId"/>
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
	<label>
		<fmt:message key="projecttemplate.templateid.title"/>:
	</label> 

							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="projecttemplate_templateId" path="templateId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projecttemplate_templateId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projecttemplate.templateid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${projecttemplate.templateId}
						&nbsp;
									<form:hidden id="projecttemplate_templateId" path="templateId"/>
								</c:otherwise>
							</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.templatename.title"/>:
	</label> 

							<form:input id="projecttemplate_templateName" path="templateName" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projecttemplate_templateName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projecttemplate.templatename.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.templatedesc.title"/>:
	</label> 

							<form:input id="projecttemplate_templateDesc" path="templateDesc" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projecttemplate_templateDesc",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projecttemplate.templatedesc.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="projecttemplate.activeyn.title"/>:
	</label> 

							<form:input id="projecttemplate_activeYn" path="activeYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "projecttemplate_activeYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="projecttemplate.activeyn.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Projecttemplate"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexProjecttemplate">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>