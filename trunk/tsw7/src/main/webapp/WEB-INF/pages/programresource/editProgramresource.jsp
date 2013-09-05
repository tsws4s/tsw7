<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.programresource-resources"/>
<html>
<head>
<title>Edit <fmt:message key="programresource.title"/>
</title>
<script>
function validateForm()
{
    if(document.parentform.team_teamName.value=="")
    {
      alert("Team Name should not be left blank");
      document.parentform.team_teamName.focus();
      return false;
    }
     else if(document.parentform.team_coach.value=="")
    {
      alert("Coach should not be left blank");
      document.parentform.team_coach.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveProgramresource" method="POST" modelAttribute="programresource" name="parentform" onSubmit="return validateForm();">
					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									${program.programName}&nbsp;-&nbsp;<fmt:message key="navigation.new" /> <fmt:message key="programresource.title"/>
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									${program.programName}&nbsp;-&nbsp;<fmt:message key="navigation.edit" />
									<fmt:message key="programresource.title"/> (${programresource.programResourceId})<strong> ${programresource.resource.resourceName}</strong>
								</h2>
								<form:hidden id="programresource_programResourceId" path="programResourceId"/>
							</c:otherwise>
						</c:choose>

						<div class="theme"></div>
						<div class="drop"></div>
					</div>

					<div class="content">
					<br />
						<fieldset>
								<div>
									<label>Default Resource</label>
									<select id="itemSelected8" name="selected_id8">
									<option value="">Select resource</option>
										<c:forEach items="${resources}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${programresource.resource!=null && current.resourceId eq programresource.resource.resourceId}">
											<option value="${current.resourceId}" selected="selected">${current.resourceName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.resourceId}">${current.resourceName}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>
								<br />
							</fieldset>
							<fieldset>
								<div>
									<label>Program Resource Price</label>
									<select id="itemSelected11" name="selected_id11">
									<option value="">Select price</option>
										<c:forEach items="${prices}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${programresource.resourcePrice!=null && current.priceId eq programresource.resourcePrice.priceId}">
											<option value="${current.priceId}" selected="selected">$ ${current.priceField} - ${current.priceCategory}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.priceId}">$ ${current.priceField} - ${current.priceCategory}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>
								<br>
							</fieldset>
					</div>
					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Program Resource" />
						<input type="hidden" name="program_programId" value="${programresource.program.programId}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgram?programIdKey=${programresource.program.programId}&indexFrom=0&'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
