<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />

	<c:set var="dashbdSelected" value="false" />
	<c:set var="custSelected" value="false" />
	<c:set var="schedSelected" value="false" />
	<c:set var="programSelected" value="false" />
	<c:set var="leagueSelected" value="false" />
	
	<% String servPath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
		if (servPath.equals("/dashboard") || servPath.equals("/loginSuccess") || servPath.equals("/qsGuides") || servPath.equals("/accountReport")) {  %>
		<c:set var="dashbdSelected" value="true" />
		<% } if (servPath.equals("/indexCustomer") || servPath.equals("/editCustomer") || servPath.equals("/newCustomer")  || servPath.equals("/confirmDeleteCustomerCustomers") || servPath.equals("/customerQS")
		|| servPath.equals("/confirmDeleteCustomer") || servPath.equals("/saveCustomer") || servPath.equals("/emailCustomers")  || servPath.equals("/customerReport")) {  %>
		<c:set var="custSelected" value="true" />
		<% } if (servPath.equals("/indexEvent") || servPath.equals("/indexEventFrom") || servPath.equals("/editEvent") || servPath.equals("/newEvent") || servPath.equals("/confirmDeleteEvent") || servPath.equals("/schedulingQS") || servPath.equals("/schedulingReport")) {  %>
		<c:set var="schedSelected" value="true" />
		<% } if (servPath.equals("/indexProgram") || servPath.equals("/editProgram") || servPath.equals("/newProgram") || servPath.equals("/confirmDeleteProgram") || servPath.equals("/programQS")
		|| servPath.equals("/saveProgramParticipants") || servPath.equals("/deleteProgramParticipants") || servPath.equals("/saveProgram") || servPath.equals("/programReport")
		|| servPath.equals("/indexProgramParticipant") || servPath.equals("/editProgramParticipants") || servPath.equals("/newProgramParticipants") || servPath.equals("/confirmDeleteProgramParticipants")){  %>
		 <c:set var="programSelected" value="true" />
		 <c:set var="leagueSelected" value="false" />
		 <c:if test='${leagueFlag}'>
			 <c:set var="programSelected" value="false" />
			 <c:set var="leagueSelected" value="true" />
		 </c:if>
		<% } if (servPath.equals("/indexLeague") || servPath.equals("/generateGames")
		 || servPath.equals("/indexTeam") || servPath.equals("/editProgramTeams") || servPath.equals("/newProgramTeams") || servPath.equals("/confirmDeleteProgramTeams")
		 || servPath.equals("/editTeamTeamplayerses") || servPath.equals("/newTeamTeamplayerses") || servPath.equals("/confirmDeleteTeamTeamplayerses")
	 	 || servPath.equals("/listProgramTeams") || servPath.equals("/saveProgramTeams") || servPath.equals("/listProgramGames") || servPath.equals("/leagueQS") 
	 	 || servPath.equals("/saveProgramGames") || servPath.equals("/newLeague")  || servPath.equals("/leagueReport") 
		 || servPath.equals("/indexGame") || servPath.equals("/editProgramGames") || servPath.equals("/newProgramGames") || servPath.equals("/confirmDeleteProgramGames")){  %>
		<c:set var="leagueSelected" value="true" />
	<% } %>

<div class="tiny">
	<div class="panel">

		<c:choose>

			<c:when test="${dashbdSelected}">
				<div class="title">
					<h4>Dashboard &amp; Reports</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div id="sidebar">
					<ul id="navigation">
						<li class="first"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
						<li><a href="${pageContext.request.contextPath}/qsGuides">Guides (Step-by-Step)</a></li>
						<li class="last">
						<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/printReport?rpt=printAccount.jsp', 'myWin2','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=yes'); return false">
						Account Reports</a></li>
					</ul>
					<div class="help " style="padding-left: 80px;">
						<h4 class="help-button">Help</h4>
						<div class="popup-help">
							<div class="center">
								<div class="top">
								
									<h3 class="strong">Dashboard Help</h3>
									<p>Dashboard, Reports, Step-by-Step Guides.</p>
									<p>(check <a href="${pageContext.request.contextPath}/faq">F.A.Q.</a> or 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>)</p>
									
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					</div>
				</div>

			</c:when>

			<c:when test="${custSelected}">
				<div class="title">
					<h4>Customer Relations Mgt</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div id="sidebar">
					<ul id="navigation">
						<li class="first"><a href="${pageContext.request.contextPath}/indexCustomer">Customers</a></li>
						<li><a href="${pageContext.request.contextPath}/customerQS">Family Quick Entry</a></li>
						<li><a href="${pageContext.request.contextPath}/emailCustomers">Email Campaign</a></li>
						<li class="last">
						<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Customers', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
						Customer Reports</a></li>
					</ul>
					<div class="help " style="padding-left: 80px;">
						<h4 class="help-button">Help</h4>
						<div class="popup-help">
							<div class="center">
								<div class="top">
								
									<h3 class="strong">Customer Relations Help</h3>
									<p>Manage Customers, Create Email Campaigns, and Print Customer Reports.</p>
									<p>(check <a href="${pageContext.request.contextPath}/faq">F.A.Q.</a> or 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>)</p>
									
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					</div>
				</div>

			</c:when>

			<c:when test="${schedSelected}">
				<div class="title">
					<h4>Scheduling Events</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div id="sidebar">
					<ul id="navigation">
						<li class="first"><a href="${pageContext.request.contextPath}/indexEvent">Event Listing</a></li>
						<li><a href="${pageContext.request.contextPath}/indexResource">Resources, Prices</a></li>
						<li><a href="${pageContext.request.contextPath}/indexGame">Games</a></li>
						<li><a href="${pageContext.request.contextPath}/indexEvent">Define Patterns</a></li>
						<li class="last">
						<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Games', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
						Game Schedules</a></li>
					</ul>
					<div class="help " style="padding-left: 80px;">
						<h4 class="help-button">Help</h4>
						<div class="popup-help">
							<div class="center">
								<div class="top">
								
									<h3 class="strong">Scheduling Events Help</h3>
									<p>Scheduling of Events, Resources, Games.</p>
									<p>(check <a href="${pageContext.request.contextPath}/faq">F.A.Q.</a> or 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>)</p>
									
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					</div>
				</div>

			</c:when>

			<c:when test="${programSelected}">
				<div class="title">
					<h4>Programs, Participants</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div id="sidebar">
					<ul id="navigation">
						<li class="first"><a href="${pageContext.request.contextPath}/indexProgram">Programs</a></li>
						<li class="last">
						<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Programs', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
						Program Reports</a></li>
					</ul>
					<div class="help " style="padding-left: 80px;">
						<h4 class="help-button">Help</h4>
						<div class="popup-help">
							<div class="center">
								<div class="top">
								
									<h3 class="strong">Programs, Participants</h3>
									<p>Manage Programs &amp; Participants.</p>
									<p>(check <a href="${pageContext.request.contextPath}/faq">F.A.Q.</a> or 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>)</p>
									
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					</div>
				</div>

			</c:when>

			<c:when test="${leagueSelected}">
				<div class="title">
					<h4>Leagues, Teams, Games</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div id="sidebar">
					<ul id="navigation">
						<li class="first"><a href="${pageContext.request.contextPath}/indexLeague">Leagues</a></li>
						<li><a href="${pageContext.request.contextPath}/indexTeam">Teams</a></li>
						<li><a href="${pageContext.request.contextPath}/indexGame">Games</a></li>
						<li class="last"><a href="${pageContext.request.contextPath}/leagueReport">League &amp; Game Reports</a></li>
					</ul>
					<div class="help " style="padding-left: 80px;">
						<h4 class="help-button">Help</h4>
						<div class="popup-help">
							<div class="center">
								<div class="top">
								
									<h3 class="strong">Leagues, Teams, Games</h3>
									<p>Manage Leagues, Teams, Games.</p>
									<p>(check <a href="${pageContext.request.contextPath}/faq">F.A.Q.</a> or 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>)</p>
									
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					</div>
				</div>

			</c:when>
			
			<c:otherwise>
				<div class="title">
					<h4>Account Settings</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div id="sidebar">
					<ul id="navigation">
						<li class="first"><a href="${pageContext.request.contextPath}/indexResource">Resources</a></li>
						<li><a href="${pageContext.request.contextPath}/indexLevel">Levels</a></li>
						<li><a href="${pageContext.request.contextPath}/indexPrice">Prices</a></li>
						<li class="last"><a href="${pageContext.request.contextPath}/importExport">Upload/Import</a></li>
					</ul>
					<div class="help " style="padding-left: 80px;">
						<h4 class="help-button">Help</h4>
						<div class="popup-help">
							<div class="center">
								<div class="top">
								
									<h3 class="strong">Account Settings Help</h3>
									<p>Manage Account, Resources, Levels, Prices, and Import/Export data.</p>
									<p>(check <a href="${pageContext.request.contextPath}/faq">F.A.Q.</a> or 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>)</p>
									
								</div>
							</div>
							<div class="bottom"></div>
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
</div>
