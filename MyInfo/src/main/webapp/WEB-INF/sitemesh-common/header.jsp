<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>

	<div id="header-wrapper" class="container">
		<div id="user-account" class="row" >
			<div class="threecol"> <span>Software for Sports <strong>- Administrator</strong> </span> </div>
			<div class="ninecol last"> <a href="${pageContext.request.contextPath}/">Logout</a> <span>|</span> 
			<a href="${pageContext.request.contextPath}/">My Profile</a> <span> </div>
		</div>

		<div id="user-options" class="row">
			<div class="threecol"><a href="${pageContext.request.contextPath}/dashboard"><img class="logo" src="css/images/back-logo.png" alt="Team Sportsware" /></a></div>
			<div class="ninecol last fixed">
				
				<ul class="nav-user-options">
				
					<li><a href="${pageContext.request.contextPath}/indexMyInfo"><img src="css/images/icons/icon-menu-settings.png" alt="Settings" />MyInfo </a>					

					</li>
				
					<li><a href="#"><img src="css/images/icons/icon-menu-messages.png" alt="Messages" />&nbsp; Support<img class="pin" src="css/images/back-nav-sub-pin.png" alt="" /></a>
			
						<ul>
							<li class="first"><a href="${pageContext.request.contextPath}/faq">F.A.Q.</a></li>
							<li class="#"><a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a></li>
							<li class="last"><a href="${pageContext.request.contextPath}/contactUs">Contact Us</a></li>
							<li class="pin"></li>
						</ul></li>
						 
				</ul>
				
			</div>
		</div>
	</div>

	