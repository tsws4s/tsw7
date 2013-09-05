<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>

<html>
<head>
<title>Timer Display</title>
		<!-- WYSISYG Editor -->
		<script type='text/javascript' src='simple/scripts/nicEdit/nicEdit.js'></script>

		<!-- Forms Elemets -->
		<script type='text/javascript' src='simple/scripts/jquery.uniform/jquery.uniform.min.js'></script>
		<link rel='stylesheet' href='simple/scripts/jquery.uniform/uniform.default.css' type='text/css' media='screen' />
</head>
<body>
					<div class="formular">
							<div class="panel">
		
								<div class="title">
						<h4>Timer Display</h4>
									<div class="theme"></div>
									<div class="drop"></div>
								</div>
								<div class="content inpad">

<fieldset>
<div>		
	<label>Timer Task Mode</label> 
	<input name="taskMode" readonly="readonly" value="${taskMode}" style="width:200px;"/>
</div>
<br>
<div>
	<label>Task Status</label> 
	<input name="taskStatus" readonly="readonly" value="${taskStatus}" style="width:400px;"/>
</div>
</fieldset>
</div>				
	<div class="button-bar">						
		<span style="padding-left:40px;">
			<a href="${pageContext.request.contextPath}/startTimer"><button>Start</button></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/getTimerStatus"><button>Get Status</button></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/stopTimer"><button>Stop</button></a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/dashboard"><button>Cancel</button></a>
		</span>	<br /><br />
	</div>		
	</div>
</div>			
</body>
</html>