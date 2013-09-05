<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.customer-resources" />
<html>
<head>
<title>Register <fmt:message key="customer.title" />
</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script>
function validateForm()
{
    if(document.parentform.customer_password.value=="")
    {
      alert("Password should not be left blank");
      document.parentform.customer_password.focus();
      return false;
    }
    else if(document.parentform.retype_password.value=="")
    {
      alert("Re-Type Password should not be left blank");
      document.parentform.retype_password.focus();
      return false;
    }
    else if(document.parentform.retype_password.value!=document.parentform.customer_password.value)
    {
      alert("Password does not match Re-Type Password");
      document.parentform.retype_password.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveChangedPassword" method="POST" modelAttribute="customer" name="parentform" onSubmit="return validateForm();">

					<div class="title-large">
						<h2>
							Register 
							<fmt:message key="customer.title" />
						</h2>
					</div>

					<div>
						<fieldset>
							<br>
							<div>
								<label><fmt:message key="customer.firstname.title" /> *</label>
								<input id="customer_firstname" readonly="readonly" style="width:200px;" />
							</div>
							<br>
							<div>
								<label><fmt:message key="customer.lastname.title" /> *</label>
								<input id="customer_lastname" readonly="readonly" style="width:200px;" />
							</div>
							<br>
							<div>
								<label><fmt:message key="customer.email.title" /> *</label>
								<input id="customer_email" readonly="readonly" style="width:240px;" />
							</div>
							<br>
										
							<label>Password <span>*</span></label>
							<div class="input">
								<form:password id="customer_password" path="password" autofocus="autofocus" cssStyle="width:265px;" />
							</div>
							
							<label>Retype password <span>*</span></label>
							<div class="input">
								<input class="text" id="retype_password" type="password" name="retype_password" style="width:265px;" />
							</div>
						</fieldset>
					</div>
					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Password" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/login'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>