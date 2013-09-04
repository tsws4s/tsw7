<%@page import="tsw.dao.UsersDAO"%>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<title>Team Sportsware</title>
			
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="explorer/css/style-ie.css" /> 
	<![endif]--> 
	
	<!--[if IE]><script type="text/javascript" src="explorer/js/excanvas.compiled.js"></script><![endif]--> 

	<% if (!((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/dashboard")
		&& !((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/faq")
		&& !((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/loginSuccess")) { %>

		<script type='text/javascript' src='explorer/jquery/1.8/jquery.min.js'></script>
		<script type='text/javascript' src='explorer/jquery/1.8/jquery-ui.min.js'></script>
		<script type='text/javascript' src='explorer/js/explorer-custom.js'></script>
		<script type='text/javascript' src='explorer/js/explorer-extra.js'></script>
		<script type='text/javascript' src='explorer/jquery.colorbox/jquery.colorbox-min.js'></script>
		
	<% }  %>

		<link href="explorer/jquery/1.8/jquery-ui.css" rel="stylesheet" type="text/css" />
		<link href="explorer/css/style-explorer.css" rel="stylesheet" type="text/css" />
		<link href="explorer/css/style-calendar.css" rel="stylesheet" type="text/css" />
		<link href="explorer/css/style-custom${sessionScope.selectTheme}.css" rel="stylesheet" type="text/css" />
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans:regular,bold' rel='stylesheet' type='text/css' />
		<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css' />
		<link href='explorer/jquery.colorbox/colorbox.css' rel='stylesheet' type='text/css' media='screen' />
			
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.gif" />
	
	<decorator:head />
    </head>

 	<body>
		<c:set var="useLeftNav" value="true" />
		<c:set var="mainContent" value="full" />
		<c:set var="isReport" value="false" />
		<c:set var="useLogin" value="false" />
		<c:set var="isDashboard" value="false" />
				<% if (((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/index.jsp")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/login")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/saveRegisteredUser")	
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/resetPasswordRequest")	
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/saveChangedPassword")		
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/saveRegisteredUser")		
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/loginError"))	{ %>
 		<c:set var="useLogin" value="true" />	
				<% } else if (((HttpServletRequest)pageContext.getRequest()).getServletPath().startsWith("/ReportsDir")) { %>
		<c:set var="isReport" value="true" />				
				<% } else if (((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/dashboard")) { %>		
		<c:set var="isDashboard" value="true" />
				<% } else if (((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/resetPasswordRequest")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/getTimerStatus")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/registerUser"))	{ %>
		<c:set var="notAuthenticated" value="true" />
		<c:set var="useLeftNav" value="false" />
				<% } else if (((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/scheduling")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/faq")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/saveEvent")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/emailCustomers")
				|| ((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/helpDesk"))	{ %>
		<c:set var="useLeftNav" value="false" />
				<% } %>
			<c:if test='${isDashboard==true && notAuthenticated==true}' >
			 		<c:set var="useLogin" value="true" />	
			</c:if>
						
		<c:choose>
			<c:when test='${searchFlag || reportFlag || isReport}' >
				<c:set var="useLeftNav" value="false" />
				<c:set var="mainContent" value="tiny x3" />		
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test='${useLogin==true || notAuthenticated==true}' >
						<jsp:include page="/WEB-INF/sitemesh-common/header2.jsp" />        		
					</c:when>
					<c:otherwise>
						<jsp:include page="/WEB-INF/sitemesh-common/header.jsp" />
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>

	<div id="container" class="clearfix fixed fluid_">
	<div id="content"><div class="section">

		<c:choose>
			<c:when test='${useLogin}' >
 					<jsp:include page="/WEB-INF/sitemesh-common/login.jsp" />
			</c:when>
			<c:otherwise>

			<c:if test='${useLeftNav}' >
					<jsp:include page="/WEB-INF/sitemesh-common/leftNav.jsp" />
				<c:set var="mainContent" value="tiny x3" />		
			</c:if>

			<div class="${mainContent}">		
			
					<decorator:body />			
			</div>
			</c:otherwise>
		</c:choose>
			
	</div></div>
</div>	<!--  #container  -->	
	
	<div id="style-background"> </div>
	<div id="style-shadow"> </div>
						
	</body>   

</html>



