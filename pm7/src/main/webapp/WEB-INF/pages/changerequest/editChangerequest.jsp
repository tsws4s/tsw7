<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.changerequest-resources"/>
<html>
<head>
<title>Edit <fmt:message key="changerequest.title"/></title>
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
		<form:form action="${pageContext.request.contextPath}/saveChangerequest" method="POST" modelAttribute="changerequest" name="parentform" onSubmit="return validateForm();">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="changerequest.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="changerequest.title"/> - ${changerequest.changeId}
								<form:hidden id="changerequest_changeId" path="changeId"/>
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
		<fmt:message key="changerequest.changecode.title"/>:
	</label> 
								${changerequest.changeCode}&nbsp;
								<form:hidden id="changerequest_changeCode" path="changeCode" />
						</div>
<div class="group fixed">
	<label>
		<fmt:message key="changerequest.status.title"/>:
	</label> 
							<form:select id="changerequest_status" path="status" selected="${requirement.status}">							
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
		<fmt:message key="changerequest.changename.title"/>:
	</label> 

							<form:input id="changerequest_changeName" path="changeName" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "changerequest_changeName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="changerequest.changename.help"/>"}})); </script>
</div>
						<div class="group fixed">
							<label> <fmt:message key="changerequest.changepriority.title" />: </label>
							<form:select id="changerequest_changepriority" path="changePriority" selected="${requirement.reqmtPriority}">							
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
		<fmt:message key="changerequest.changedescription.title"/>:
	</label> 

							<form:textarea id="changerequest_changeDescription" path="changeDescription" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "changerequest_changeDescription",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="changerequest.changedescription.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Changerequest"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexChangerequest">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	


<%-- 
	<!--   Status Updates   -->

	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Status Updates</h4>
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
					<th><fmt:message key="statusupdate.fkresourceid.title"/></th>
					<th><fmt:message key="statusupdate.fkreleaseid.title"/></th>
					<th><fmt:message key="statusupdate.fkdefectid.title"/></th>
					<th><fmt:message key="statusupdate.fkreqmtid.title"/></th>
					<th><fmt:message key="statusupdate.fktaskid.title"/></th>
					<th><fmt:message key="statusupdate.fktestid.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${changerequest.statusupdates}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editChangerequestStatusupdates?changerequest_changeId=${changerequest.changeId}&statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteChangerequestStatusupdates?changerequest_changeId=${changerequest.changeId}&related_statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
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
			<a class="button-blue" href="${pageContext.request.contextPath}/newChangerequestStatusupdates?changerequest_changeId=${changerequest.changeId}">New Statusupdate <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div> --%>


	<!--   Attachments   -->
	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Attachments</h4>
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
				<c:forEach items="${changerequest.attachments}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editChangerequestAttachments?changerequest_changeId=${changerequest.changeId}&attachments_attachId=${current.attachId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteChangerequestAttachments?changerequest_changeId=${changerequest.changeId}&related_attachments_attachId=${current.attachId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
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
			<a class="button-blue" href="${pageContext.request.contextPath}/newChangerequestAttachments?changerequest_changeId=${changerequest.changeId}">New Attachment <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>


</body>
</html>