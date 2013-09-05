<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.releaseplan-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="releaseplan.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="releaseplan.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releaseid.title"/>:
	</label> 
							${releaseplan.releaseId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasecode.title"/>:
	</label> 
							${releaseplan.releaseCode}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasename.title"/>:
	</label> 
							${releaseplan.releaseName}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasedescription.title"/>:
	</label> 
							${releaseplan.releaseDescription}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasedate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="date" value="${releaseplan.releaseDate.time}"/>
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteReleaseplan?releaseplanIdKey=${releaseplan.releaseplanId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexReleaseplan">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>