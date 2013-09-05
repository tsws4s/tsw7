<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.person-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="person.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="person.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="person.personid.title"/>:
	</label> 
							${person.personId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.firstname.title"/>:
	</label> 
							${person.firstname}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.lastname.title"/>:
	</label> 
							${person.lastname}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.phone.title"/>:
	</label> 
							${person.phone}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.email.title"/>:
	</label> 
							${person.email}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.defaultprojectrole.title"/>:
	</label> 
							${person.defaultProjectRole}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.address.title"/>:
	</label> 
							${person.address}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.city.title"/>:
	</label> 
							${person.city}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.state.title"/>:
	</label> 
							${person.state}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.zip.title"/>:
	</label> 
							${person.zip}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="person.activeyn.title"/>:
	</label> 
							${person.activeYn}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deletePerson?personIdKey=${person.personId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexPerson">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>