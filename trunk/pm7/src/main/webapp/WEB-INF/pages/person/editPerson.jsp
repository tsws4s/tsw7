<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.person-resources"/>
<html>
<head>
<title>Edit <fmt:message key="person.title"/></title>
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
		<form:form action="${pageContext.request.contextPath}/savePerson" method="POST" modelAttribute="person" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="person.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="person.title"/>
								<form:hidden id="person_personId" path="personId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Address</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="person.firstname.title"/>:
	</label> 

							<form:input id="person_firstname" path="firstname" cssStyle="width:100px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_firstname",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.firstname.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.lastname.title"/>:
	</label> 

							<form:input id="person_lastname" path="lastname" cssStyle="width:100px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_lastname",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.lastname.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.phone.title"/>:
	</label> 

							<form:input id="person_phone" path="phone" cssStyle="width:100px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_phone",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.phone.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.email.title"/>:
	</label> 

							<form:input id="person_email" path="email" cssStyle="width:250px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_email",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.email.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.defaultprojectrole.title"/>:
	</label> 

							<form:input id="person_defaultProjectRole" path="defaultProjectRole" cssStyle="width:100px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_defaultProjectRole",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.defaultprojectrole.help"/>"}})); </script>
</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="person.address.title"/>:
	</label> 

							<form:input id="person_address" path="address" cssStyle="width:250px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_address",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.address.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.city.title"/>:
	</label> 

							<form:input id="person_city" path="city" cssStyle="width:200px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_city",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.city.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.state.title"/>:
	</label> 

							<form:input id="person_state" path="state" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_state",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.state.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.zip.title"/>:
	</label> 

							<form:input id="person_zip" path="zip" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_zip",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="person.zip.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.activeyn.title"/>:
	</label> 

							<form:checkbox id="person_activeYn" path="activeYn" value=""/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "person_activeYn",widgetType : "dijit.form.CheckBox",widgetAttrs : {promptMessage: "<fmt:message key="person.activeyn.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Person"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexPerson">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>