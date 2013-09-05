<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
 
<div id="content">
	<div class="panel">
		<div class="title-large">
		<h2>Account Reports</h2>
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
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/printReport?rpt=printAccount.jsp', 'myWin2','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></a>
				<h4>Account</h4>
				<span>report</span>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/printReport?rpt=printLevels.jsp', 'myWin2','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/sports.png" /></a>
				<h4>Levels</h4>
				<span>report</span>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/printReport?rpt=printResources.jsp', 'myWin2','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/participants.png" /></a>
				<h4>Reources</h4>
				<span>report</span>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/printReport?rpt=printPrices.jsp', 'myWin2','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/calendar.png" /></a>
				<h4>Prices</h4>
				<span>report</span>
				</li>
				<li>
				<a href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/reportPage?rptName=Customer', 'myWin2','dialogWidth:850px;dialogHeight:700px;help:no;border:thin;status:no;toolbar=yes;menubar=yes'); return false">
				<img alt="tools" src="explorer/images/user.png" /></a>
				<h4>Customers</h4>
				<span>report</span>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>