<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Page</title>
</head>
<body>
 
<h1>Report Download Page</h1><p>
<p>&nbsp;</p>
<p><a href="${reportUrl}">View Report</a></p>
<p>&nbsp;</p>

<c:url value="http:///4devPC/test/Simple_Blue.html" var="rptPage"/>
 <p><a href="${rptPage}">rptPage</a></p>

<p>Click the download links below:</p>
<c:url value="jreports/xls" var="downloadXls"/>

 <p><a href="${downloadXls}">Download Excel</a></p>
 
 <p>&nbsp;</p>
<c:url value="jreports/pdf" var="downloadPdf"/>
 <p><a href="${downloadPdf}">Download PDF</a></p> 
 
</body>
</html>