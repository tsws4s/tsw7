<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>

<html>
<head>
<title>Help Desk</title>
<!-- WYSISYG Editor -->
<script type='text/javascript' src='simple/scripts/nicEdit/nicEdit.js'></script>

<!-- Forms Elemets -->
<script type='text/javascript' src='simple/scripts/jquery.uniform/jquery.uniform.min.js'></script>
<link rel='stylesheet' href='simple/scripts/jquery.uniform/uniform.default.css' type='text/css' media='screen' />
</head>
<body>

	<div class="section">
		<div class="full">

			<div class="panel">
				<div class="title-large">
					<h2>Help Desk</h2>
					<span style="text-align:right;padding: 10px 30px 5px 300px;font-size: 12px;color:#ffffff;">
					Checkout answers in&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/faq"><button>F.A.Q.</button></a></span>
				<div class="theme"></div>
				<div class="drop"></div>
				</div>
			
			<div class="content inpad">
				<iframe src="https://www.simplyt3s.com/hesk/index.php" width="100%" height="700"></iframe>
			</div>
			</div>			
		</div>
	</div>
</body>
</html>