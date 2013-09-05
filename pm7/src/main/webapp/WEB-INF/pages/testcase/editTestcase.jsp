<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.testcase-resources"/>
<html>
<head>
<title>Edit <fmt:message key="testcase.title"/></title>
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
		<form:form action="${pageContext.request.contextPath}/saveTestcase" method="POST" modelAttribute="testcase" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="testcase.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="testcase.title"/> - ${testcase.testId}
								<form:hidden id="testcase_testId" path="testId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							<li><a href="#" rel="tab-03-content">Setup</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="testcase.testcasecode.title"/>:
	</label> 
								${testcase.testCaseCode}&nbsp;
								<form:hidden id="testcase_testCaseCode" path="testCaseCode" />
						</div>
<div class="group fixed">
	<label>
		* <fmt:message key="testcase.testname.title"/>:
	</label> 

							<form:input id="testcase_testName" path="testName" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcase_testName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcase.testname.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label><fmt:message key="testcase.passfail.title"/>: </label> 
        <form:radiobutton id="testcase_passFail" path="passFail" value="pass" /> Pass  
        <form:radiobutton id="testcase_passFail" path="passFail" value="fail" /> Fail &nbsp;&nbsp;&nbsp;&nbsp;
        <form:radiobutton id="testcase_passFail" path="passFail" value="" /> Not Complete
</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="testcase.testdescription.title"/>:
	</label> 

							<form:textarea id="testcase_testDescription" path="testDescription" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcase_testDescription",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcase.testdescription.help"/>"}})); </script>
</div>
</div>
<div id="tab-03-content">
<div class="group fixed">
	<label>
		<fmt:message key="testcase.testsetup.title"/>:
	</label> 

							<form:textarea id="testcase_testSetup" path="testSetup" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "testcase_testSetup",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="testcase.testsetup.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Testcase"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexTestcase">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	
	<!--   Test Case Steps   -->

	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Test Case Steps</h4>
					<div class="collapse">collapse</div>
			</div>
			<div class="content">
				<!-- ## Panel Content  -->
			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="testcasestep.passfail.title"/></th>
					<th><fmt:message key="testcasestep.testcasestepfield.title"/></th>
					<th><fmt:message key="testcasestep.stepdescription.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${testcase.testcasesteps}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editTestcaseTestcasesteps?testcase_testId=${testcase.testId}&testcasesteps_testStepId=${current.testStepId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteTestcaseTestcasesteps?testcase_testId=${testcase.testId}&related_testcasesteps_testStepId=${current.testStepId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.passFail}
						&nbsp;
					</td>
					<td>
						
							${current.testCaseStepField}
						&nbsp;
					</td>
					<td>
						
							${current.stepDescription}
						&nbsp;
					</td>

				</tr>
				</c:forEach>
			</tbody>
		</table>
				<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newTestcaseTestcasesteps?testcase_testId=${testcase.testId}">New Testcasestep <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>		

				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>


	<!--   Status Updates   -->

	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Status Updates</h4>
					<div class="collapse">collapse</div>
			</div>
			<div class="content">
				<!-- ## Panel Content  -->
			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="statusupdate.statusid.title"/></th>
					<th><fmt:message key="statusupdate.statusdate.title"/></th>
					<th><fmt:message key="statusupdate.statusupdatedesc.title"/></th>
					<th><fmt:message key="statusupdate.riskgyr.title"/></th>
<%-- 					<th><fmt:message key="statusupdate.fkresourceid.title"/></th>
					<th><fmt:message key="statusupdate.fkreleaseid.title"/></th>
					<th><fmt:message key="statusupdate.fkdefectid.title"/></th>
					<th><fmt:message key="statusupdate.fkreqmtid.title"/></th>
					<th><fmt:message key="statusupdate.fktaskid.title"/></th>
					<th><fmt:message key="statusupdate.fktestid.title"/></th> --%>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${testcase.statusupdates}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editTestcaseStatusupdates?testcase_testId=${testcase.testId}&statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteTestcaseStatusupdates?testcase_testId=${testcase.testId}&related_statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.statusId}
						&nbsp;
					</td>
					<td>
						
							<fmt:formatDate dateStyle="short" type="date" value="${current.statusDate.time}"/>
						&nbsp;
					</td>
					<td>
						
							${current.statusUpdateDesc}
						&nbsp;
					</td>
					<td>
						
							${current.riskGyr}
						&nbsp;
					</td>

				</tr>
				</c:forEach>
			</tbody>
		</table>
				<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">
				<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newTestcaseStatusupdates?testcase_testId=${testcase.testId}">New Statusupdate <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>

	<!--   Attachments   -->
	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Attachments</h4>
					<div class="collapse">collapse</div>
			</div>
			<div class="content">
				<!-- ## Panel Content  -->
				<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="attachment.attachid.title"/></th>
					<th><fmt:message key="attachment.attachmenttype.title"/></th>
					<th><fmt:message key="attachment.attachmenturl.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${testcase.attachments}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editTestcaseAttachments?testcase_testId=${testcase.testId}&attachments_attachId=${current.attachId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteTestcaseAttachments?testcase_testId=${testcase.testId}&related_attachments_attachId=${current.attachId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.attachId}
						&nbsp;
					</td>
					<td>
						
							${current.attachmentType}
						&nbsp;
					</td>
					<td>
						
							${current.attachmentUrl}
						&nbsp;
					</td>

				</tr>
				</c:forEach>
			</tbody>
		</table>
				<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newTestcaseAttachments?testcase_testId=${testcase.testId}">New Attachment <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>

</body>
</html>