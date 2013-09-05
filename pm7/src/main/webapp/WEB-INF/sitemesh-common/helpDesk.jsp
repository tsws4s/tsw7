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

		<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
							<h4>Help Desk&nbsp;&nbsp;&nbsp;&nbsp;-&nbsp;&nbsp;
							Checkout answers in&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/faq"><button>F.A.Q.</button></a></h4>
							<div class="collapse">collapse</div>
		</div>
			
			<div class="content inpad">
				<iframe src="https://www.simplyt3s.com/hesk/index.php" width="100%" height="700"></iframe>
						<!-- ## / Panel Content  -->
						</div>
					</div>
					
					<div class="shadow"></div>
			</div>		

</body>
</html>