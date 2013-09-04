<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.level-resources" />
<html>
<head>
<title>Edit <fmt:message key="level.title" />
</title>

<script>
  $(document).ready(function(){
    $("#validForm").validate();
  });
function validateForm()
{
    if(document.levelForm.level_levelName.value=="")
    {
      alert("Name should not be left blank");
      document.levelForm.level_levelName.focus();
      return false;
    }
    else if(document.levelForm.level_levelCode.value=="")
    {
      alert("Code should not be left blank");
      document.levelForm.level_levelCode.focus();
      return false;
    }
}
</script>
</head>
<body>
	<div class="formular">
		<div class="panel">

			<form:form action="${pageContext.request.contextPath}/saveLevel" method="POST" modelAttribute="level" id="validForm" name="levelForm" onSubmit="return validateForm();">

				<div class="title-large">

					<c:choose>
						<c:when test='${newFlag}'>
							<h2>
								<fmt:message key="navigation.new" /> <fmt:message key="level.title" />
							</h2>
						</c:when>
						<c:otherwise>
							<h2>
								<fmt:message key="navigation.edit" /> <fmt:message key="level.title" />
								(${level.levelId}) <strong>${level.levelName}</strong>
							</h2>
							<form:hidden id="level_levelId" path="levelId" />
						</c:otherwise>
					</c:choose>

					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content inpad">

					<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">				
								<td style="width:50%;">
									<br>
									<div>
										<label><fmt:message key="level.levelname.title" /> *</label>
										<form:input id="level_levelName" path="levelName" autofocus="autofocus" size="80" class="required" minlength="2" cssStyle="width:150px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="level.levelcode.title" /> *</label>
										<form:input id="level_levelCode" path="levelCode" size="8" class="required" minlength="2" cssStyle="width:50px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="program.activeyn.title" /></label>
										<form:checkbox id="level_activeYn" path="activeYn" value="1" />
									</div>
									<br>
								</td>
								<td>
									<div style="width:80px;">&nbsp;</div>
								</td>
								<td>
									<br>
									<div>
										<label><fmt:message key="level.agelow.title" /></label>
										<form:input id="level_ageLow" path="ageLow" cssStyle="width:50px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="level.agehigh.title" /></label>
										<form:input id="level_ageHigh" path="ageHigh" cssStyle="width:50px;" />
									</div>
									<br>
								</td>
							</tr>
						</tbody>
					</table>
					</fieldset>
				</div>

				<!-- ## / Panel Content  -->

				<div class="button-bar">
					<input class="button-clean submit" id="save" type="submit" value="Save Level" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="reset" name="reset" value="Reset" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexLevel'" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
				</div>
			</form:form>

		</div>
	</div>
</body>
</html>