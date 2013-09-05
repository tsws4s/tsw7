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
				
		<!-- 1140px Grid styles for IE -->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" /><![endif]-->

		<!-- The 1140px Grid -->
		<link rel="stylesheet" href="css/1140.css" type="text/css" media="screen" />
	
		<link rel='stylesheet' href='scripts/jquery.fullcalendar/fullcalendar.css' type='text/css' media='screen' />
		<link rel='stylesheet' href='scripts/jquery.fullcalendar/fullcalendar.print.css' type='text/css' media='print' />
		
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
		<link rel='stylesheet' href='_themes/default.css' type='text/css' media='screen' />

		<!--css3-mediaqueries-js - http://code.google.com/p/css3-mediaqueries-js/ - Enables media queries in some unsupported browsers-->
		<script type="text/javascript" src="scripts/css3-mediaqueries.js"></script>
		
		<!-- Fonts -->
		<link href='http://fonts.googleapis.com/css?family=Droid+Sans:regular,bold|PT+Sans+Narrow:regular,bold|Droid+Serif:iamp;v1' rel='stylesheet' type='text/css' />
		
		<!-- Scripts -->
 		<script type='text/javascript' src='scripts/jquery.18/jquery.min.js'></script>
		<script type='text/javascript' src='scripts/jquery.18/jquery-ui.min.js'></script>
		<link rel='stylesheet' href='scripts/jquery.18/jquery-ui.css' type='text/css' media='screen' />
		
		
		<!-- Charts -->
		<script type='text/javascript' src='scripts/jquery.raphael/raphael-min.js'></script>
		<script type='text/javascript' src='scripts/jquery.morris/morris.min.js'></script>
	
		
		<!-- WYSISYG Editor -->
		<script type='text/javascript' src='scripts/nicEdit/nicEdit.js'></script>
		
		
		<!-- Forms Elemets -->
		<script type='text/javascript' src='scripts/jquery.uniform/jquery.uniform.min.js'></script>
		<link rel='stylesheet' href='scripts/jquery.uniform/uniform.default.css' type='text/css' media='screen' />
		
		
		<!-- Table sorter -->
		<script type='text/javascript' src='scripts/jquery.tablesorter/jquery.tablesorter.min.js'></script>
		<script type='text/javascript' src='scripts/table.resizable/resizable.tables.js'></script>
		
		
		<!-- Lightbox - Colorbox -->
		<script type='text/javascript' src='scripts/jquery.colorbox/jquery.colorbox-min.js'></script>
		<link rel='stylesheet' href='scripts/jquery.colorbox/colorbox.css' type='text/css' media='screen' />

		<!-- Calendar -->
		<script type='text/javascript' src='scripts/jquery.fullcalendar/fullcalendar.min.js'></script>
				
		<script type='text/javascript' src='css/custom.js'></script>
	
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.gif" />
	
	<decorator:head />
    </head>

	<body>
		<c:choose>
			<c:when test='${searchFlag}' >

			</c:when>
			<c:otherwise>
				<jsp:include page="/WEB-INF/sitemesh-common/header.jsp" />
			</c:otherwise>
		</c:choose>
		
 	<div class="container">
		<div class="row">
	<% String servPath = ((HttpServletRequest)pageContext.getRequest()).getServletPath();
		if (servPath.equals("/faq") || servPath.equals("/helpDesk")){  %>
			<div id="content" class="full last">
				<decorator:body />
					<div class="hidden">&nbsp;</div>  
			</div>  
	<% } else { %>
			<div id="sidebar" class="threecol">	
				<jsp:include page="/WEB-INF/sitemesh-common/leftNav.jsp" />
			</div>
										
			<div id="content" class="ninecol last">
				<decorator:body />
					<div class="hidden">&nbsp;</div>  
			</div><!-- end contentwrapper -->  
	<% } %>
		<jsp:include page="/WEB-INF/sitemesh-common/footer.jsp" />
		</div><!-- end wrapper -->
	</div>

	</body>
</html>



