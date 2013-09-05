<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.feature-resources"/>
<html>
<head>
<title>Edit <fmt:message key="feature.title"/> <fmt:message key="requirement.title"/></title>
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
		<form:form action="${pageContext.request.contextPath}/saveFeatureRequirements?feature_featureId=${feature_featureId}" method="POST" modelAttribute="requirement" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								Feature-${feature_featureId}
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="requirement.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="requirement.title"/> - ${requirement.reqmtId} 
								<form:hidden id="requirement_reqmtId" path="reqmtId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

						<div class="group fixed">
							<label> <fmt:message key="requirement.reqmtcode.title" />: </label>
								${requirement.reqmtCode}&nbsp;
								<form:hidden id="requirement_reqmtcode" path="reqmtCode" />
						</div>
<div class="group fixed">
	<label>
		* <fmt:message key="requirement.status.title"/>:
	</label> 
							<form:select id="requirement_status" path="status" selected="${requirement.status}">							
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
		* <fmt:message key="requirement.reqmtname.title"/>:
	</label> 

							<form:input id="requirement_reqmtName" path="reqmtName" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "requirement_reqmtName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="requirement.reqmtname.help"/>"}})); </script>
</div>
						<div class="group fixed">
							<label> <fmt:message key="requirement.reqmtpriority.title" />: </label>
							<form:select id="requirement_reqmtPriority" path="reqmtPriority" selected="${requirement.reqmtPriority}">							
								<form:option value="--">Select option</form:option>
								<form:option value="Normal">Normal</form:option>
								<form:option value="High">High</form:option>
								<form:option value="Low">Low</form:option>
							</form:select>													
							&nbsp;&nbsp;&nbsp;
						</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="requirement.reqmtstorydescription.title"/>:
	</label> 

							<form:textarea id="requirement_reqmtStoryDescription" path="reqmtStoryDescription" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "requirement_reqmtStoryDescription",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="requirement.reqmtstorydescription.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Requirement"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/editFeature?featureIdKey=${feature_featureId}">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	
</body>
</html>