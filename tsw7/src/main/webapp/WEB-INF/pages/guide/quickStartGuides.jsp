<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
 
<div id="content">
	<div class="panel">
		<div class="title-large">
		<h2>Quick Start Guides (Step-by-Step)</h2>
		<div class="theme"></div>
		<div class="drop"></div>
		</div>
	<div class="content inpad" style="background-color: #e7e7e7;">
	<div id="header">
			<ul class="nav" style="text-align:center;">
				<li>
				&nbsp;
				</li>
				<li>
				<a href="${pageContext.request.contextPath}/accountQS"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></a>
				<h4>Account</h4>
				<span>quick-start</span>
				</li>
				<li>
				<a href="${pageContext.request.contextPath}/leagueQS"><img alt="tools" src="explorer/images/sports.png" /></a>
				<h4>Leagues</h4>
				<span>quick-start</span>
				</li>
				<li>
				<a href="${pageContext.request.contextPath}/programQS"><img alt="tools" src="explorer/images/participants.png" /></a>
				<h4>Programs</h4>
				<span>quick-start</span>
				</li>
				<li>
				<a href="${pageContext.request.contextPath}/schedulingQS"><img alt="tools" src="explorer/images/calendar.png" /></a>
				<h4>Scheduling</h4>
				<span>quick-start</span>
				</li>
				<li>
				<a href="${pageContext.request.contextPath}/customerQS"><img alt="tools" src="explorer/images/user.png" /></a>
				<h4>Customers</h4>
				<span>quick-start</span>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
