<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<title>Team Sportsware</title>
			
		<link rel="stylesheet" href="explorer/css/style-explorer.css" type="text/css" media="screen" />
		
	</head>

	<body class="texture">
<div class="exp-form">
	<form action='${pageContext.request.contextPath}/j_spring_security_check' method='post' id='loginForm'> 

	<div class="exp-wrapper">
	
		<div class="brand">
			<img src="explorer/images/TeamSportsware.png" alt="" />
		</div><br /><br />
		
		<div class="hr"></div>		
						
		<div id="exp-login" class="form">
			<label>Username</label>
			<div class="input">
				<input class="text" type="text" name="j_username" value='<c:out value="${SPRING_SECURITY_LAST_USERNAME}"/>' />
			</div>
			<label>Password</label>
			<div class="input">
				<input class="text" type="password" name="j_password" />
			</div>
			
			<div class="clearfix"><br />
				<input type="submit" value="Login" class="submit right" />
			</div>
		</div>

		<div id="exp-recovery" class="form">
			<label>Type your e-mail address</label>
			<div class="input">
				<input class="text" type="text" name="emailAddr" />
			</div>
			
			<span class="small">In order to recover the password you need to confirm your e-mail.</span>
			
			<div class="clearfix topad">
				<input class="button-clean" type="button" name="send" value="Send" onclick="location.href='${pageContext.request.contextPath}/resetPasswordRequest?emailAddr=${document.loginForm.emailAddr.value}';" />
				<a href="#" class="btn-cancel right">Cancel</a>
			</div>

		</div>
		
		<div class="hr"></div>
			
		<div class="options clearfix">
				<a href="#" class="btn-recovery">Password Recovery<span>You forgot your password?</span></a>
				<a href="#" onclick="location.href='${pageContext.request.contextPath}/registerUser'" class="btn-register">Register New User<span>Register a new user here!</span></a>
		</div>
		
	</div>
	</form>
</div>
	 
	</body>
	
</html>
