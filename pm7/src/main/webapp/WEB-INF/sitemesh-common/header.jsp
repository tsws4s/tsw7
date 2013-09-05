<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>

	<div id="header-wrapper" class="container">
		<div id="user-account" class="row" >
			<div class="threecol"> <span>Project Management <strong>- Administrator</strong> </span> </div>
			<div class="ninecol last"> <a href="${pageContext.request.contextPath}/">Logout</a> <span>|</span> 
			<a href="${pageContext.request.contextPath}/">My Profile</a> </div>
		</div>

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
	<% } if (servPath.equals("/indexProject") || servPath.equals("/editProject") || servPath.equals("/newProject")  || servPath.equals("/confirmDeleteProject")){  %>
		 <c:set var="projectSelected" value="selected" />
	<% } if (servPath.equals("/indexReleaseplan") || servPath.equals("/editReleaseplan") || servPath.equals("/newReleaseplan")  || servPath.equals("/confirmDeleteReleaseplan")){  %>
		 <c:set var="releaseSelected" value="selected" />
	<% } if (servPath.equals("/indexClient") || servPath.equals("/editClient") || servPath.equals("/newClient")  || servPath.equals("/confirmDeleteClient")){  %>
		 <c:set var="clientSelected" value="selected" />		
	<% } if (servPath.equals("/indexPerson") || servPath.equals("/editPerson") || servPath.equals("/newPerson")  || servPath.equals("/confirmDeletePerson")){  %>
		 <c:set var="resourcesSelected" value="selected" />	
	<% } if (servPath.equals("/indexAccount") || servPath.equals("/editAccount") || servPath.equals("/newAccount")  || servPath.equals("/confirmDeleteAccount")){  %>
		<c:set var="acctSelected" value="selected" />
	<% } if (servPath.equals("/contactUs") || servPath.equals("/faq") || servPath.equals("/helpDesk")){  %>
		 <c:set var="suppSelected" value="selected" />	
	<% } %>
	
		<div id="user-options" class="row">
			<div class="threecol"><a href="${pageContext.request.contextPath}/dashboard"><img class="logo" src="css/images/back-logo.png" alt="Project Management" /></a></div>
			<div class="ninecol last fixed">
				
		<ul class="nav-user-options">

		<li class="${projectSelected}">	
			<a href="${pageContext.request.contextPath}/indexProject">
			<img src="css/images/icons/icon-dashboard-white.png" alt="+" />&nbsp;Projects </a></li>

		<li class="${clientSelected}">	
			<a href="${pageContext.request.contextPath}/indexClient">
			<img src="css/images/icons/icon-grid-white.png" alt="*" />&nbsp;Client </a></li>

		<li class="${acctSelected}">
			<a href="${pageContext.request.contextPath}/indexAccount">
			<img src="css/images/icons/icon-menu-settings.png" alt="#" />&nbsp;Account </a></li>
		
		<li class="${suppSelected}">	
			<a href="#"><img src="css/images/icons/icon-menu-messages.png" alt="!" />&nbsp; Support<img class="pin" src="css/images/back-nav-sub-pin.png" alt="" /></a>
				<ul>
					<li class="first"><a href="${pageContext.request.contextPath}/faq">F.A.Q.</a></li>
					<li class="last"><a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a></li>
					<li class="pin"></li>
				</ul></li>
						 
		</ul>
				
		</div>
	</div>
</div>