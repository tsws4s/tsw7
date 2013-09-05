<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.client-resources"/>
<html>
<head>
<title>Edit <fmt:message key="client.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveClient" method="POST" modelAttribute="client" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="client.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="client.title"/>
								<form:hidden id="client_clientId" path="clientId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Address</a></li>
							<li><a href="#" rel="tab-03-content">Logo</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
							<c:choose>
								<c:when test='${newFlag}' >
	<label>
		<fmt:message key="client.clientid.title"/>:
	</label> 
							<form:input id="client_clientId" path="clientId" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_clientId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.clientid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>

									<form:hidden id="client_clientId" path="clientId"/>
								</c:otherwise>
							</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.clientname.title"/>:
	</label> 

							<form:input id="client_clientName" path="clientName" cssStyle="width:200px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_clientName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.clientname.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.phone.title"/>:
	</label> 

							<form:input id="client_phone" path="phone" cssStyle="width:150px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_phone",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.phone.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.email.title"/>:
	</label> 

							<form:input id="client_email" path="email" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_email",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.email.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.website.title"/>:
	</label> 

							<form:input id="client_website" path="website" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_website",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.website.help"/>"}})); </script>
</div>
</div>
<div id="tab-02-content">	
<div class="group fixed">
	<label>
		<fmt:message key="client.address.title"/>:
	</label> 

							<form:input id="client_address" path="address" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_address",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.address.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.city.title"/>:
	</label> 

							<form:input id="client_city" path="city" cssStyle="width:200px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_city",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.city.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.state.title"/>:
	</label> 

							<form:input id="client_state" path="state" cssStyle="width:50px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_state",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.state.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.zip.title"/>:
	</label> 

							<form:input id="client_zip" path="zip" cssStyle="width:80px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_zip",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.zip.help"/>"}})); </script>
</div>
</div>
<div id="tab-03-content">	
<div class="group fixed">
	<label>
		<fmt:message key="client.logofilename.title"/>:
	</label> 

							<form:input id="client_logoFilename" path="logoFilename" cssStyle="width:200px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_logoFilename",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="client.logofilename.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="client.activeyn.title"/>:
	</label> 

							<form:checkbox id="client_activeYn" path="activeYn" value="" />
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "client_activeYn",widgetType : "dijit.form.CheckBox",widgetAttrs : {promptMessage: "<fmt:message key="client.activeyn.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Client"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexClient">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>