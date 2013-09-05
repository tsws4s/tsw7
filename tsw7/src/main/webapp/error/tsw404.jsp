<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<title>Team Sportsware</title>
		
		<!-- 1140px Grid styles for IE -->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" /><![endif]-->

		<!-- The 1140px Grid -->
		<link rel="stylesheet" href="simple/1140.css" type="text/css" media="screen" />
	
		<link rel="stylesheet" href="simple/styles.css" type="text/css" media="screen" />
		<link rel='stylesheet' href='_themes/default.css' type='text/css' media='screen' />

		<!-- Fonts -->
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans:regular,bold|PT+Sans+Narrow:regular,bold|Droid+Serif:iamp;v1' rel='stylesheet' type='text/css' />
		
		<!-- Scripts -->
		<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6/jquery.min.js?ver=1.6'></script>

		<!-- Forms Elemets -->
		<script type='text/javascript' src='simple/scripts/jquery.uniform/jquery.uniform.min.js'></script>
		<link rel='stylesheet' href='simple/scripts/jquery.uniform/uniform.default.css' type='text/css' media='screen' />	
		
		<!-- Lightbox - Colorbox -->
		<script type='text/javascript' src='simple/scripts/jquery.colorbox/jquery.colorbox-min.js'></script>
		<link rel='stylesheet' href='simple/scripts/jquery.colorbox/colorbox.css' type='text/css' media='screen' />
				
		<script type='text/javascript' src='simple/custom.js'></script>
	
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.gif" />
	
    </head>
  
  <body>
  <jsp:include page="../WEB-INF/sitemesh-common/header2.jsp" />  
  
	<div class="container">
		<div class="row">
		
		<div><center><a class="button-blue" href="${pageContext.request.contextPath}/login">Retry Login</a></center></div>
				
			<div class="error-message">
				<h1>404</h1>
				<h4>Page not found!</h4>
			</div>
			
		</div>
	</div>

	</body>
	
</html>
