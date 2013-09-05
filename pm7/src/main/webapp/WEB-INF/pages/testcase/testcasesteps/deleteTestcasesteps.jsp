<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.testcase-resources"/>
<html>
<head>
<title>Delete <fmt:message key="testcase.title"/> <fmt:message key="testcasestep.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">TestCase Step&nbsp;&nbsp;${testcasestep_testcasestepId} - 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.teststepid.title"/>:
	</label> 
		${testcasestep.testStepId}
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.passfail.title"/>:
	</label> 
		${testcasestep.passFail}
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.testcasestepfield.title"/>:
	</label> 
		${testcasestep.testCaseStepField}
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.stepdescription.title"/>:
	</label> 
		${testcasestep.stepDescription}
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.expectedresult.title"/>:
	</label> 
		${testcasestep.expectedResult}
</div>
<div class="group fixed">
	<label>
		<fmt:message key="testcasestep.actualresult.title"/>:
	</label> 
		${testcasestep.actualResult}
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteTestcaseTestcasesteps?testcase_testId=${testcase_testId}&related_testcasesteps_testStepId=${testcasestep.testStepId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/editTestcase?testIdKey=${testcase_testId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>

