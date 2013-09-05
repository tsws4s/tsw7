<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.testcasestep-resources"/>
<html>
<head>
<title>Edit <fmt:message key="testcasestep.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveTestcasestep" method="POST" modelAttribute="testcasestep" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="testcasestep.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="testcasestep.title"/>
								<form:hidden id="testcasestep_testcasestepId" path="testcasestepId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Results</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label><fmt:message key="testcasestep.passfail.title"/>: </label> 
        <form:radiobutton id="testcasestep_passFail" path="passFail" value="pass" /> Pass  
        <form:radiobutton id="testcasestep_passFail" path="passFail" value="fail" /> Fail &nbsp;&nbsp;&nbsp;&nbsp;
        <form:radiobutton id="testcasestep_passFail" path="passFail" value="" /> Not Complete
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.testcasestepfield.title"/>:
	</label> 

							<form:input id="testcasestep_testCaseStepField" path="testCaseStepField" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcasestep_testCaseStepField",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcasestep.testcasestepfield.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.stepdescription.title"/>:
	</label> 

							<form:textarea id="testcasestep_stepDescription" path="stepDescription" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcasestep_stepDescription",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcasestep.stepdescription.help"/>"}})); </script>
</div>
</div>
<div id="tab-02-content">	
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.expectedresult.title"/>:
	</label> 

							<form:textarea id="testcasestep_expectedResult" path="expectedResult" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcasestep_expectedResult",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcasestep.expectedresult.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.actualresult.title"/>:
	</label> 

							<form:textarea id="testcasestep_actualResult" path="actualResult" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcasestep_actualResult",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcasestep.actualresult.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Testcasestep"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexTestcasestep">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>