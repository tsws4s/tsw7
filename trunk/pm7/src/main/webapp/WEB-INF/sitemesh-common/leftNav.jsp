<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>

	<c:set var="dashbdSelected" value="" />
	<c:set var="projectSelected" value="" />	
	<c:set var="releaseSelected" value="" />	
	<c:set var="clientSelected" value="" />	
	<c:set var="resourcesSelected" value="" />	
	<c:set var="acctSelected" value="" />
	<c:set var="suppSelected" value="" />

	<% String servPath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
		if (servPath.equals("/dashboard") || servPath.equals("/loginSuccess")) {  %>
		<c:set var="dashbdSelected" value="selected" />
	<% } if (servPath.equals("/indexProject") || servPath.equals("/editProject") || servPath.equals("/newProject")  || servPath.equals("/confirmDeleteProject") || servPath.equals("/deleteProject") || servPath.equals("/saveProject") || 
		servPath.equals("/indexTask") || servPath.equals("/editTask") || servPath.equals("/newTask")  || servPath.equals("/confirmDeleteTask") || servPath.equals("/deleteTask") || servPath.equals("/saveTask") ||
		servPath.equals("/editProjectTasks") || servPath.equals("/newProjectTasks")  || servPath.equals("/confirmDeleteProjectTasks") ||  servPath.equals("/deleteProjectTasks") || servPath.equals("/saveProjectTasks") ||
		servPath.equals("/editTaskStatusupdates") || servPath.equals("/newTaskStatusupdates")  || servPath.equals("/confirmDeleteTaskStatusupdates") || servPath.equals("/deleteTaskStatusupdates") || servPath.equals("/saveTaskStatusupdates") ||
		servPath.equals("/editTaskAttachments") || servPath.equals("/newTaskAttachments")  || servPath.equals("/confirmDeleteTaskAttachments") || servPath.equals("/deleteTaskAttachments") || servPath.equals("/saveTaskAttachments") ||
		servPath.equals("/indexTestcase") || servPath.equals("/editTestcase") || servPath.equals("/newTestcase")  || servPath.equals("/confirmDeleteTestcase") || servPath.equals("/deleteTestcase") || servPath.equals("/deleteTestcase") || servPath.equals("/saveTestcase") ||
		servPath.equals("/editTestcaseTestcasesteps") || servPath.equals("/newTestcaseTestcasesteps")  || servPath.equals("/confirmDeleteTestcaseTestcasesteps") || servPath.equals("/deleteTestcaseTestcasesteps") || servPath.equals("/saveTestcaseTestcasesteps") ||
		servPath.equals("/editTestcaseStatusupdates") || servPath.equals("/newTestcaseStatusupdates")  || servPath.equals("/confirmDeleteTestcaseStatusupdates") || servPath.equals("/deleteTestcaseStatusupdates") ||  servPath.equals("/saveTestcaseStatusupdates") ||
		servPath.equals("/editTestcaseAttachments") || servPath.equals("/newTestcaseAttachments")  || servPath.equals("/confirmDeleteTestcaseAttachments") ||  servPath.equals("/deleteTestcaseAttachments") || servPath.equals("/saveTestcaseAttachments") ||
		servPath.equals("/editDefectStatusupdates") || servPath.equals("/newDefectStatusupdates")  || servPath.equals("/confirmDeleteDefectStatusupdates") || servPath.equals("/deleteDefectStatusupdates") || servPath.equals("/saveDefectStatusupdates") ||
		servPath.equals("/editDefectAttachments") || servPath.equals("/newDefectAttachments")  || servPath.equals("/confirmDeleteDefectAttachments") ||  servPath.equals("/deleteDefectAttachments") || servPath.equals("/saveDefectAttachments") ||
		servPath.equals("/indexDefect") || servPath.equals("/editDefect") || servPath.equals("/newDefect")  || servPath.equals("/confirmDeleteDefect")  ||  servPath.equals("/deleteDefect")  || servPath.equals("/saveDefect") ||
		servPath.equals("/indexFeature") || servPath.equals("/editFeature") || servPath.equals("/newFeature")  || servPath.equals("/confirmDeleteFeature") || servPath.equals("/deleteFeature") || servPath.equals("/saveFeature") ||
		servPath.equals("/indexRequirement") || servPath.equals("/editRequirement") || servPath.equals("/newRequirement")  || servPath.equals("/confirmDeleteRequirement") || servPath.equals("/deleteRequirement") || servPath.equals("/saveRequirement") ||
		servPath.equals("/editRequirementStatusupdates") || servPath.equals("/newRequirementStatusupdates")  || servPath.equals("/confirmDeleteRequirementStatusupdates") || servPath.equals("/deleteRequirementStatusupdates") || servPath.equals("/saveRequirementStatusupdates") ||
		servPath.equals("/editFeatureRequirements") || servPath.equals("/newFeatureRequirements")  || servPath.equals("/confirmDeleteFeatureRequirements") || servPath.equals("/deleteFeatureRequirements") || servPath.equals("/saveFeatureRequirements") ||
		servPath.equals("/editFeatureChangerequests") || servPath.equals("/newFeatureChangerequests")  || servPath.equals("/confirmDeleteFeatureChangerequests") || servPath.equals("/deleteFeatureChangerequests") || servPath.equals("/saveFeatureChangerequests") ||
		servPath.equals("/editRequirementAttachments") || servPath.equals("/newRequirementAttachments")  || servPath.equals("/confirmDeleteRequirementAttachments") || servPath.equals("/deleteRequirementAttachments") || servPath.equals("/saveRequirementAttachments") ||
		servPath.equals("/editChangerequestStatusupdates") || servPath.equals("/newChangerequestStatusupdates")  || servPath.equals("/confirmDeleteChangerequestStatusupdates") || servPath.equals("/deleteChangerequestStatusupdates") || servPath.equals("/saveChangerequestStatusupdates") ||
		servPath.equals("/editChangerequestAttachments") || servPath.equals("/newChangerequestAttachments")  || servPath.equals("/confirmDeleteChangerequestAttachments") || servPath.equals("/deleteChangerequestAttachments") || servPath.equals("/saveChangerequestAttachments") ||
		servPath.equals("/indexReleaseplan") || servPath.equals("/editReleaseplan") || servPath.equals("/newReleaseplan")  || servPath.equals("/confirmDeleteReleaseplan") || servPath.equals("/deleteReleaseplan") || servPath.equals("/saveReleaseplan") ||
		servPath.equals("/editProjectProjectteams") || servPath.equals("/newProjectProjectteams")  || servPath.equals("/confirmDeleteProjectProjectteams") || servPath.equals("/deleteProjectProjectteams") || servPath.equals("/saveProjectProjectteams") ||
		servPath.equals("/indexChangerequest") || servPath.equals("/editChangerequest") || servPath.equals("/newChangerequest")  || servPath.equals("/confirmDeleteChangerequest") || servPath.equals("/deleteChangerequest") || servPath.equals("/saveChangerequest")){  %>
		 <c:set var="projectSelected" value="selected" />
	<% } if (servPath.equals("/indexClient") || servPath.equals("/editClient") || servPath.equals("/newClient")  || servPath.equals("/confirmDeleteClient") || servPath.equals("/deleteClient") || servPath.equals("/saveClient") ||
		servPath.equals("/indexPerson") || servPath.equals("/editPerson") || servPath.equals("/newPerson")  || servPath.equals("/confirmDeletePerson") || servPath.equals("/deletePerson") || servPath.equals("/savePerson") ||
		servPath.equals("/indexInvoice") || servPath.equals("/editInvoice") || servPath.equals("/newInvoice")  || servPath.equals("/confirmDeleteInvoice") || servPath.equals("/deleteInvoice") || servPath.equals("/saveInvoice") ||
		servPath.equals("/indexTimeentry") || servPath.equals("/editTimeentry") || servPath.equals("/newTimeentry")  || servPath.equals("/confirmDeleteTimeentry")  || servPath.equals("/deleteTimeentry")  || servPath.equals("/saveTimeentry")){  %>
		 <c:set var="clientSelected" value="selected" />
	<% } if (servPath.equals("/indexAccount") || servPath.equals("/editAccount") || servPath.equals("/newAccount")  || servPath.equals("/confirmDeleteAccount")  || servPath.equals("/deleteAccount")  ||  servPath.equals("/saveAccount")){  %>
		<c:set var="acctSelected" value="selected" />
	<% } if (servPath.equals("/faq") || servPath.equals("/helpDesk")){  %>
		 <c:set var="suppSelected" value="selected" />	
	<% } %>


	<ul id="navigation">				
		<c:choose>
			<c:when test="${dashbdSelected=='selected'}">
					<li class="first"><a href="${pageContext.request.contextPath}/indexProject">Project <span class="icon-dashboard"></span> </a></li> 
					<li><a href="${pageContext.request.contextPath}/indexPerson">Person <span class="icon-users"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/indexClient">Client <span class="icon-tables"></span></a></li>
					<li class="last"><a href="${pageContext.request.contextPath}/indexReleaseplan">Releases <span class="icon-calendar"></span></a></li>
			</c:when>
	
			<c:when test="${projectSelected=='selected'}">
					<li class="first"><a href="${pageContext.request.contextPath}/indexProject">Project <span class="icon-dashboard"></span> </a></li> 
					<li><a href="${pageContext.request.contextPath}/indexFeature">Features <span class="icon-faq"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/indexTestcase">Test Cases <span class="icon-tasks"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/indexDefect">Defects <span class="icon-error"></span></a></li>
					<li class="last"><a href="${pageContext.request.contextPath}/indexReleaseplan">Releases <span class="icon-calendar"></span></a></li>
			</c:when>

			<c:when test="${clientSelected=='selected'}">
					<li class="first"><a href="${pageContext.request.contextPath}/indexClient">Client <span class="icon-tables"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/indexInvoice">Invoice <span class="icon-elements"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/indexPerson">Person <span class="icon-users"></span></a></li>
					<li class="last"><a href="${pageContext.request.contextPath}/indexTimeentry">Time Entry <span class="icon-time"></span></a></li>
			</c:when>
					
			<c:when test="${acctSelected=='selected'}">
					<li class="first"><a href="${pageContext.request.contextPath}/indexAccount">Account <span class="icon-settings"></span> </a></li> 
			</c:when>
		</c:choose>
	</ul>
				

