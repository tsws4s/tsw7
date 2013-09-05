<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.timeentry-resources"/>
<html>
<head>
<title>Edit <fmt:message key="timeentry.title"/></title>
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
		<form:form action="${pageContext.request.contextPath}/saveTimeentry" method="POST" modelAttribute="timeentry" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="timeentry.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="timeentry.title"/>
								<form:hidden id="timeentry_timeentryId" path="timeEntryId"/>
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
	<label>
		* <fmt:message key="timeentry.timehrs.title"/>:
	</label> 

							<form:input id="timeentry_timeHrs" path="timeHrs" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeentry_timeHrs",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeentry.timehrs.help"/>", constraints : {places:0}}})); </script>
</div>

<div class="group fixed">
	<label>
		* <fmt:message key="timeentry.date.title"/>:
	</label> 

							<input class="datepicker" id="timeentry_date" name="date" type="text" value="<fmt:formatDate value="${timeentry.date.time}" pattern="MM/dd/yyyy"/>" style="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeentry_date",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="navigation.dateTime.title"/>"}})); </script>
</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="timeentry.description.title"/>:
	</label> 

							<form:textarea id="timeentry_description" path="description" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeentry_description",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeentry.description.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="timeentry.rateamt.title"/>:
	</label> 

							<form:input id="timeentry_rateAmt" path="rateAmt" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "timeentry_rateAmt",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="timeentry.rateamt.help"/>"}})); </script>
</div>
</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Timeentry"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexTimeentry">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>