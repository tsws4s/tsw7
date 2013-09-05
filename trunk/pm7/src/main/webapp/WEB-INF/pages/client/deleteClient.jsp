<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.client-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="client.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="client.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="client.clientid.title"/>:
	</label> 
							${client.clientId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.clientname.title"/>:
	</label> 
							${client.clientName}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.phone.title"/>:
	</label> 
							${client.phone}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.email.title"/>:
	</label> 
							${client.email}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.website.title"/>:
	</label> 
							${client.website}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.address.title"/>:
	</label> 
							${client.address}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.city.title"/>:
	</label> 
							${client.city}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.state.title"/>:
	</label> 
							${client.state}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.zip.title"/>:
	</label> 
							${client.zip}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.logofilename.title"/>:
	</label> 
							${client.logoFilename}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.activeyn.title"/>:
	</label> 
							${client.activeYn}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteClient?clientIdKey=${client.clientId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexClient">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>