<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.timeentry-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="timeentry.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="timeentry.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="timeentry.timeentryid.title"/>:
	</label> 
							${timeentry.timeEntryId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="timeentry.timehrs.title"/>:
	</label> 
							${timeentry.timeHrs}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="timeentry.rateamt.title"/>:
	</label> 
							${timeentry.rateAmt}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="timeentry.date.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="both" value="${timeentry.date.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="timeentry.description.title"/>:
	</label> 
							${timeentry.description}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteTimeentry?timeentryIdKey=${timeentry.timeentryId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexTimeentry">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>