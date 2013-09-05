<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.testcase-resources"/>
<html>
<head>
<title>View <fmt:message key="testcase.title"/> <fmt:message key="testcasestep.title"/></title>
</head>
<body>
<div id="contentarea">      
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
		<div id="content">
			<h1><fmt:message key="navigation.view"/> <fmt:message key="testcasestep.title"/></h1>
			<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/selectTestcase?testIdKey=${testcase_testId}&"><span><img src="images/icons/back.gif" /><fmt:message key="navigation.back"/></span></a></div>
		
			<table cellpadding="0" cellspacing="0" id="viewTable">
				<tbody>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="testcasestep.teststepid.title"/>:
						</td>
						<td>
							${testcasestep.testStepId}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="testcasestep.passfail.title"/>:
						</td>
						<td>
							${testcasestep.passFail}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="testcasestep.testcasestepfield.title"/>:
						</td>
						<td>
							${testcasestep.testCaseStepField}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="testcasestep.stepdescription.title"/>:
						</td>
						<td>
							${testcasestep.stepDescription}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="testcasestep.expectedresult.title"/>:
						</td>
						<td>
							${testcasestep.expectedResult}
						&nbsp;
						</td>
					</tr>
					<tr>
						<td class="label" valign="top">
							<fmt:message key="testcasestep.actualresult.title"/>:
						</td>
						<td>
							${testcasestep.actualResult}
						&nbsp;
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>
