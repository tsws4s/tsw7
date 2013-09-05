<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.changerequest-resources"/>
<html>
<head>
<title>Edit <fmt:message key="changerequest.title"/> <fmt:message key="attachment.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveChangerequestAttachments?changerequest_changeId=${changerequest_changeId}&" method="POST" modelAttribute="attachment" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">Change Request&nbsp;&nbsp;${changerequest_changeId} - 
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="attachment.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="attachment.title"/> - ${attachment.attachId}
									<form:hidden id="attachment_attachId" path="attachId"/>									
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
	<c:choose>
		<c:when test='${newFlag}' >
	<label>
		<fmt:message key="attachment.attachid.title"/>:
	</label> 
	<form:input id="attachment_attachId" path="attachId" cssStyle="width:80px;"/>
	<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "attachment_attachId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="attachment.attachid.help"/>", constraints : {places:0}}})); </script>
		</c:when>
	</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="attachment.attachmenttype.title"/>:
	</label> 
			<form:select id="attachment_attachmentType" path="attachmentType" selected="${attachment.attachmentType}">							
				<form:option value="--">Select option</form:option>
				<form:option value="File">File</form:option>
				<form:option value="Website">Web Site</form:option>
				<form:option value="Other">Other</form:option>
			</form:select>													
			&nbsp;&nbsp;&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="attachment.attachmenturl.title"/>:
	</label> 
			<form:input id="attachment_attachmentUrl" path="attachmentUrl" cssStyle="width:300px;"/>
			<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "attachment_attachmentUrl",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="attachment.attachmenturl.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Attachment"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/editChangerequest?changeIdKey=${changerequest_changeId}&">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>
