<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
 
<div id="header">
	<div class="nav-wrapper-left">
	<div class="nav-wrapper-right">
	<c:set var="dashbdSelected" value="" />
	<c:set var="custSelected" value="" />	
	<c:set var="schedSelected" value="" />	
	<c:set var="programSelected" value="" />	
	<c:set var="leagueSelected" value="" />	
	<c:set var="acctSelected" value="" />
	<c:set var="suppSelected" value="" />

	<% String servPath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
		if (servPath.equals("/dashboard") || servPath.equals("/loginSuccess") || servPath.equals("/qsGuides") || servPath.equals("/accountReport")) {  %>
		<c:set var="dashbdSelected" value="selected" />
	<% } if (servPath.equals("/indexCustomer") || servPath.equals("/editCustomer") || servPath.equals("/newCustomer")  || servPath.equals("/confirmDeleteCustomerCustomers")
		|| servPath.equals("/customerQS") || servPath.equals("/confirmDeleteCustomer") || servPath.equals("/saveCustomer") || servPath.equals("/emailCustomers")  || servPath.equals("/customerReport")){  %>
		 <c:set var="custSelected" value="selected" />
	<% } if (servPath.equals("/scheduling") || servPath.equals("/indexEvent") || servPath.equals("/indexEventFrom") || servPath.equals("/editEvent") || servPath.equals("/newEvent")   || servPath.equals("/schedulingReport")
		|| servPath.equals("/schedulingQS") || servPath.equals("/confirmDeleteEvent")){  %>
		 <c:set var="schedSelected" value="selected" />		
	<% } if (servPath.equals("/indexProgram") || servPath.equals("/editProgram") || servPath.equals("/newProgram") || servPath.equals("/confirmDeleteProgram") || servPath.equals("/programQS")
		|| servPath.equals("/saveProgramParticipants") || servPath.equals("/deleteProgramParticipants") || servPath.equals("/saveProgram")  || servPath.equals("/programReport")
		|| servPath.equals("/editProgramParticipants") || servPath.equals("/newProgramParticipants") || servPath.equals("/confirmDeleteProgramParticipants")){  %>
		 <c:set var="programSelected" value="selected" />
		 <c:set var="leagueSelected" value="" />
		 <c:if test='${leagueFlag}'>
			 <c:set var="programSelected" value="" />
			 <c:set var="leagueSelected" value="selected" />
		 </c:if>
	<% } if (servPath.equals("/indexLeague") || servPath.equals("/generateGames")
	 	|| servPath.equals("/indexTeam") || servPath.equals("/editProgramTeams") || servPath.equals("/newProgramTeams") || servPath.equals("/confirmDeleteProgramTeams")
	 	|| servPath.equals("/editTeamTeamplayerses") || servPath.equals("/newTeamTeamplayerses") || servPath.equals("/confirmDeleteTeamTeamplayerses")
	 	|| servPath.equals("/listProgramTeams") || servPath.equals("/saveProgramTeams") || servPath.equals("/listProgramGames")
	 	|| servPath.equals("/saveProgramGames") || servPath.equals("/newLeague")   || servPath.equals("/leagueReport")  || servPath.equals("/leagueQS")
	 	|| servPath.equals("/indexGame") || servPath.equals("/editProgramGames") || servPath.equals("/newProgramGames") || servPath.equals("/confirmDeleteProgramGames")){  %>
		 <c:set var="leagueSelected" value="selected" />	
	<% } if (servPath.equals("/indexTswacct") || servPath.equals("/editTswacct") || servPath.equals("/newTswacct") || servPath.equals("/confirmDeleteTswacct")
		 || servPath.equals("/indexResource") || servPath.equals("/editResource") || servPath.equals("/newResource") || servPath.equals("/confirmDeleteResource")
		 || servPath.equals("/indexLevel") || servPath.equals("/editLevel") || servPath.equals("/newLevel") || servPath.equals("/confirmDeleteLevel") || servPath.equals("/accountQS")
		 || servPath.equals("/indexPrice") || servPath.equals("/editPrice") || servPath.equals("/newPrice") || servPath.equals("/confirmDeletePrice")){  %>
		<c:set var="acctSelected" value="selected" />
	<% } if (servPath.equals("/contactUs") || servPath.equals("/faq") || servPath.equals("/helpDesk")){  %>
		 <c:set var="suppSelected" value="selected" />	
	<% } %>

		<ul class="nav"> 
			<li class="logo">
				<div class="greeting">Welcome,<br />&nbsp;&nbsp;&nbsp;${user.customer.firstname}&nbsp;${user.customer.lastname}</div>
			</li>
			
			<li class="${dashbdSelected}">
				<a href="${pageContext.request.contextPath}/dashboard"><img alt="tools" src="explorer/images/icons/nav/icon-dashboard.png" /></a>
				<h3>Dashboard</h3>
				<span>home page</span>
				
				<div class="sel"></div>
			</li>
			<li class="${leagueSelected}">
				<a href="${pageContext.request.contextPath}/indexLeague"><img alt="tools" src="explorer/images/sports.png" /></a>
				<h3>Leagues</h3>
				<span>teams &amp; games</span>
				
				<div class="sel"></div>
			</li>
			<li class="${programSelected}">
				<a href="${pageContext.request.contextPath}/indexProgram"><img alt="tools" src="explorer/images/participants.png" /></a>
				<h3>Programs</h3>
				<span>participants</span>
				
				<div class="sel"></div>
			</li>

			<li class="${schedSelected}">
				<a href="${pageContext.request.contextPath}/scheduling?resource_resourceId=&afterDate=&beforeDate=&"><img alt="tools" src="explorer/images/calendar.png" /></a>
				<h3>Scheduling</h3>
				<span>resources &amp; games</span>
				
				<div class="sel"></div>
			</li>
			<li class="${custSelected}">
				<a href="${pageContext.request.contextPath}/indexCustomer"><img alt="tools" src="explorer/images/user.png" /></a>
				<h3>Customers</h3>
				<span>manage relations</span>
				
				<div class="sel"></div>
			</li>
			<li class="${acctSelected}">
				<a href="${pageContext.request.contextPath}/editTswacct?tswAcctIdKey=${user.tswacct.tswAcctId}&"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></a>
				<h3>Account</h3>
				<span>settings</span>
				
				<div class="sel"></div>
			</li>
			<li class="${suppSelected}">
				<a href="${pageContext.request.contextPath}/faq"><img alt="tools" src="explorer/images/icons/nav/icon-layout.png" /></a>
				<h3>Support</h3>
				<span>faq, help desk</span>
				
				<div class="sel"></div>
			</li>
			
		</ul>
	</div>
	</div>
		
	<c:set var="profSelected" value="" />	
	
	<%  servPath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
	 	if (servPath.equals("/indexUsers") || servPath.equals("/editUsers") || servPath.equals("/newUsers") || servPath.equals("/confirmDeleteUsers")){  %>
		 <c:set var="profSelected" value="selected" />
	<% } %>

	<div id="notice-wrapper-left">
	<div id="notice-wrapper-right">
		<div id="notice">
			<a href="${pageContext.request.contextPath}/editCustomer?customerIdKey=${user.userId}&" class="${profSelected}">My Profile</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
		</div>
	</div>
</div>

<div id="style-background"> </div>
<div id="style-shadow"> </div>	

</div>