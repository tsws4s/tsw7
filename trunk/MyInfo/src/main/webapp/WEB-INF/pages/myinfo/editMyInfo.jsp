<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.myinfo-resources"/>
<html>
<head>
<title>Edit <fmt:message key="myinfo.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveMyInfo" method="POST" modelAttribute="myinfo" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="myinfo.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="myinfo.title"/>
								<form:hidden id="myinfo_myinfoId" path="myInfoId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="myinfo.myinfoid.title"/>:
	</label> 

							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="myinfo_myInfoId" path="myInfoId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_myInfoId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.myinfoid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${myinfo.myInfoId}
						&nbsp;
									<form:hidden id="myinfo_myInfoId" path="myInfoId"/>
								</c:otherwise>
							</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.title.title"/>:
	</label> 

							<form:input id="myinfo_title" path="title" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_title",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.title.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.url.title"/>:
	</label> 

							<form:input id="myinfo_url" path="url" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_url",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.url.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.categoryfk.title"/>:
	</label> 

							<form:input id="myinfo_categoryFk" path="categoryFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_categoryFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.categoryfk.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.username.title"/>:
	</label> 

							<form:input id="myinfo_username" path="username" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_username",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.username.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.password.title"/>:
	</label> 

							<form:input id="myinfo_password" path="password" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_password",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.password.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.filename.title"/>:
	</label> 

							<form:input id="myinfo_filename" path="filename" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_filename",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.filename.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.account.title"/>:
	</label> 

							<form:input id="myinfo_account" path="account" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_account",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.account.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.userfk.title"/>:
	</label> 

							<form:input id="myinfo_userFk" path="userFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_userFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.userfk.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.active.title"/>:
	</label> 

							<form:input id="myinfo_active" path="active" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "myinfo_active",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="myinfo.active.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save MyInfo"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexMyInfo">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>