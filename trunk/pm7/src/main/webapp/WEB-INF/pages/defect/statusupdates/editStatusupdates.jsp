<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.defect-resources"/>
<html>
<head>
<title>Edit <fmt:message key="defect.title"/> <fmt:message key="statusupdate.title"/></title>
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
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveDefectStatusupdates?defect_defectId=${defect_defectId}&" method="POST" modelAttribute="statusupdate" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">Defect ${defect_defectId} - 
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="statusupdate.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="statusupdate.title"/>
									<form:hidden id="statusupdate_statusId" path="statusId"/>
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
<%-- <div class="group fixed">
		<label>Level</label>
		<select id="itemSelected1" name="selected_id1">
		<option value="">Select level</option>
		<c:forEach items="${levels}" var="current" varStatus="i">
			<c:choose>
			<c:when test="${program.level!=null && current.levelId eq program.level.levelId}">
				<option value="${current.levelId}" selected="selected">${current.levelName}</option>
			</c:when>
			<c:otherwise>
				<option value="${current.levelId}">${current.levelName}</option>
			</c:otherwise>									
			</c:choose>
		</c:forEach>
		</select>		
	</div>
 --%>

<div class="group fixed">
	<label>
		* <fmt:message key="statusupdate.statusdate.title"/>:
	</label> 

			<input class="datepicker" id="statusupdate_statusDate" name="statusDate" type="text" value="<fmt:formatDate value="${statusupdate.statusDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:80px;" />
</div>

<div class="group fixed">
	<label>
		<fmt:message key="statusupdate.esthrsleft.title"/>:
	</label> 

							<form:input id="statusupdate_estHrsLeft" path="estHrsLeft" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "statusupdate_estHrsLeft",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="statusupdate.esthrsleft.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label><fmt:message key="statusupdate.riskgyr.title"/>: </label> 
        <form:radiobutton id="statusupdate_riskGyr" path="riskGyr" value="Green" /> Green &nbsp;&nbsp;&nbsp;&nbsp;
        <form:radiobutton id="statusupdate_riskGyr" path="riskGyr" value="Yellow" /> Yellow &nbsp;&nbsp;&nbsp;&nbsp;
        <form:radiobutton id="statusupdate_riskGyr" path="riskGyr" value="Red" /> Red
</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="statusupdate.statusupdatedesc.title"/>:
	</label> 

							<form:textarea id="statusupdate_statusUpdateDesc" path="statusUpdateDesc" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "statusupdate_statusUpdateDesc",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="statusupdate.statusupdatedesc.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Statusupdate"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/editDefect?defectIdKey=${defect_defectId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>
