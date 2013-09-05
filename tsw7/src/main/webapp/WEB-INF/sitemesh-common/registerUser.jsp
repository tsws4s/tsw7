<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>Team Sportsware</title>
			
		<link rel="stylesheet" href="explorer/css/style-explorer.css" type="text/css" media="screen" />
<script>
function validateForm()
{
    if(document.parentform.customer_email.value=="")
    {
      alert("Email should not be left blank");
      document.parentform.customer_email.focus();
      return false;
    }
    else if(document.parentform.customer_firstname.value=="")
    {
      alert("First Name should not be left blank");
      document.parentform.customer_firstname.focus();
      return false;
    }
    else if(document.parentform.customer_lastname.value=="")
    {
      alert("Last Name should not be left blank");
      document.parentform.customer_lastname.focus();
      return false;
    }
    else if(document.parentform.customer_password.value=="")
    {
      alert("Password should not be left blank");
      document.parentform.customer_password.focus();
      return false;
    }
    else if(document.parentform.customer_tswacct.value=="")
    {
      alert("Account should not be left blank");
      document.parentform.customer_tswacct.focus();
      return false;
    }
}
</script>		
	</head>

	<body class="texture">

<div class="exp-form">
	<form:form action="${pageContext.request.contextPath}/saveRegisteredUser" method="POST" modelAttribute="customer" name="parentform" onSubmit="return validateForm();">

	<div class="exp-wrapper">
	
		<div class="brand">
			<img src="explorer/images/TeamSportsware.png" alt="" />
		</div><br /><br />
		
		<div class="hr"></div>		

		<div id="exp-login" class="form">
			<label>Username <span>*</span></label>
			<div class="input">
				<form:input id="customer_email" path="email" placeholder="name@emailAddr.com" cssStyle="width:265px;" />
			</div>
			<label>Firstname <span>*</span></label>
			<div class="input">
				<form:input id="customer_firstname" name="customer_firstname" path="firstname" autofocus="autofocus" cssStyle="width:265px;" />
			</div>
			<label>Lastname <span>*</span></label>
			<div class="input">
				<form:input id="customer_lastname" path="lastname" cssStyle="width:265px;" />
			</div>
												
			<div class="hr"></div>

			
			<label>Select Account <span>*</span></label>
			<div class="select">
				<select id="customer_tswacct" name="tswacct_id" style="width:265px;">
					<option value="">Select option</option>
					<option value="1">Simply T3S</option>
					<option value="101">HArsha</option>
					<option value="102">Veera</option>
				</select>
			</div>
			<div class="hr"></div>	
			<div class="clearfix topad">
				<input type="submit" value="Register User" class="submit right" />
				<a href="#" onclick="location.href='${pageContext.request.contextPath}/login'" class="btn-cancel center">Cancel</a>
			</div>
			<br />
		
		</div>
	</div>
	</form:form>
</div>
	 
	</body>
	
</html>
