<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<head>
	<title><decorator:title default="My Project" /></title>
	<link href="images/home-screen-icon.png" rel="apple-touch-icon" />
	<link href="images/startup.png" rel="apple-touch-startup-image" />
	<meta content="yes" name="apple-mobile-web-app-capable" />
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
	<meta content="minimum-scale=1.0, width=device-width, maximum-scale=0.6667, user-scalable=no" name="viewport" />
	<link href="css/style-iwebkit.css" rel="stylesheet" media="screen" type="text/css" />
	<link href="css/style-iphone.css" rel="stylesheet" media="screen" type="text/css" />
	<script src="javascript/functions.js" type="text/javascript"></script>
	<decorator:head />
</head>
<body> 
	
     
			<% if (((HttpServletRequest)pageContext.getRequest()).getServletPath().equals("/index.jsp")){ %>
		        <jsp:include page="/WEB-INF/sitemesh-common/dashboard-iphone.jsp" />
			<% }else{ %>
				<decorator:body />
			<% } %>    
			
			
			<div id="footer">
				<jsp:include page="/WEB-INF/sitemesh-common/footer-iphone.jsp" />
			</div><!-- end footer --> 
	
		
</body>
</html>



