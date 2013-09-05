<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.releaseplan-resources"/>
<html>
<head>
<title>Edit <fmt:message key="releaseplan.title"/> <fmt:message key="requirement.title"/></title>
</head>
<body>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveReleaseplanRequirements?releaseplan_releaseId=${releaseplan_releaseId}&" method="POST" modelAttribute="requirement" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">Release - ${releaseplan_releaseId}
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
		<c:choose>
			<c:when test='${newFlag}' >
		<label>
			<fmt:message key="requirement.reqmtid.title"/>:
		</label> 
		<form:input id="requirement_reqmtId" path="reqmtId" cssStyle="width:300px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "requirement_reqmtId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="requirement.reqmtid.help"/>", constraints : {places:0}}})); </script>
			</c:when>
			<c:otherwise>
				<form:hidden id="requirement_reqmtId" path="reqmtId"/>
			</c:otherwise>
		</c:choose>
</div>
						<div class="group fixed">
							<label> <fmt:message key="requirement.reqmtcode.title" />: </label>
								${requirement.reqmtCode}&nbsp;
								<form:hidden id="requirement_reqmtcode" path="reqmtCode" />
						</div>
<div class="group fixed">
	<label>
		<fmt:message key="requirement.status.title"/>:
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
		<fmt:message key="requirement.reqmtname.title"/>:
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
				<input type="hidden" name="releaseplan_releaseId" value="${releaseplan_releaseId}" >
 	<a class="button-pink" href="${pageContext.request.contextPath}/editReleaseplan?releaseIdKey=${releaseplan_releaseId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	


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
				<c:forEach items="${requirement.statusupdates}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editRequirementStatusupdates?requirement_reqmtId=${requirement.reqmtId}&statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteRequirementStatusupdates?requirement_reqmtId=${requirement.reqmtId}&related_statusupdates_statusId=${current.statusId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
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
			<a class="button-blue" href="${pageContext.request.contextPath}/newRequirementStatusupdates?requirement_reqmtId=${requirement.reqmtId}">New Statusupdate <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
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
				<c:forEach items="${requirement.attachments}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editRequirementAttachments?requirement_reqmtId=${requirement.reqmtId}&attachments_attachId=${current.attachId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteRequirementAttachments?requirement_reqmtId=${requirement.reqmtId}&related_attachments_attachId=${current.attachId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
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
			<a class="button-blue" href="${pageContext.request.contextPath}/newRequirementAttachments?requirement_reqmtId=${requirement.reqmtId}">New Attachment <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>
</body>
</html>

