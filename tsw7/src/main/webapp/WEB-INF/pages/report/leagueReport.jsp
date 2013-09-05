<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
 
<div id="content">
	<div class="panel">
		<div class="title-large">
		<h2>League Reports</h2>
		<div class="theme"></div>
		<div class="drop"></div>
		</div>
	<div class="content inpad">
	<div id="header">
			<ul class="nav" style="text-align:center;">
				<li>
				&nbsp;
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/viewReport?rptName=Programs', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></a>
				<h4>Leagues &amp; Programs</h4>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Programs', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<span>generate report</span></a>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/viewReport?rptName=Teams', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/sports.png" /></a>
				<h4>League Teams</h4>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Teams', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<span>generate report</span></a>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/viewReport?rptName=Players', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/participants.png" /></a>
				<h4>Team Players</h4>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Players', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<span>generate report</span></a>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/viewReport?rptName=Games', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/calendar.png" /></a>
				<h4>League Games</h4>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/generateReport?rptName=Games', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<span>generate report</span></a>
				</li>

			</ul>
		</div>
	</div>
</div>
</div>