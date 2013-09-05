<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.feature-resources"/>
<html>
<head>
<title>View <fmt:message key="feature.title"/> <fmt:message key="requirement.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="../images/icons/icon-user.png" alt="">
								Feature-${feature_featureId}
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="requirement.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="requirement.reqmtid.title"/>:
	</label> 
							${requirement.reqmtId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="requirement.status.title"/>:
	</label> 
							${requirement.status}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="requirement.reqmtpriority.title"/>:
	</label> 
							${requirement.reqmtPriority}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="requirement.reqmtcode.title"/>:
	</label> 
							${requirement.reqmtCode}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="requirement.reqmtname.title"/>:
	</label> 
							${requirement.reqmtName}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="requirement.reqmtstorydescription.title"/>:
	</label> 
							${requirement.reqmtStoryDescription}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteFeatureRequirements?feature_featureId=${feature_featureId}&related_requirements_reqmtId=${requirement.reqmtId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/editFeature?featureIdKey=${feature_featureId}">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>

