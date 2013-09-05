<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div class="button-bar">
	<span style="padding-left: 90px;"> 
		<input class="button-clean" type="button" name="select" value="Print" onclick="window.print()" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="button-clean" type="button" name="cancel" value="Close" onclick="window.close()" />
	 </span>
</div>

<jsp:directive.include file="${pageContext.request.contextPath}/ReportsDir/Customer/Simple_Blue.html" />

<div class="button-bar">
	<span style="padding-left: 90px;"> 
		<input class="button-clean" type="button" name="select" value="Print" onclick="window.print()" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input class="button-clean" type="button" name="cancel" value="Close" onclick="window.close()" />
	 </span>
</div>