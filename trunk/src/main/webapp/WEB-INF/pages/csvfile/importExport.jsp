<%@page language="java" isELIgnored="false"	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.tswacct-resources" />
<html>

<head>
<title>Import</title>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
								<!-- UploadServlet, UploadServlet, uploadResult.jsp, loadResult.jsp -->
		<form method="post" action="${pageContext.request.contextPath}/UploadServlet" name="uploadForm" enctype="multipart/form-data">
						<div class="title-large">
							<h2>
								Import for Account: <strong>${tswacct.acctName}</strong>
							</h2>
							<div class="theme"></div>
							<div class="drop"></div>
						</div>
						<div class="content inpad">
							<fieldset>
								<br>
								<div>
									<label>Import Type</label> 
									<input type="radio" name="dataType" id="Customer">&nbsp;Customer&nbsp;&nbsp;&nbsp;
									<input type="radio" name="dataType" id="Team">&nbsp;Team&nbsp;&nbsp;&nbsp;
									<input type="radio" name="dataType" id="Game">&nbsp;Game&nbsp;&nbsp;&nbsp;
									<input type="radio" name="dataType" id="Event" readonly="readonly">&nbsp;Event&nbsp;&nbsp;&nbsp;
									<input type="radio" name="dataType" id="Participant" readonly="readonly">&nbsp;Participant&nbsp;&nbsp;&nbsp;
									<input type="radio" name="dataType" id="Teamplayer" readonly="readonly">&nbsp;Teamplayer&nbsp;
								</div>
									<br>
								<div>
								<label>Import File</label> 
				                   <input type="file" name="uploadFile" />
 								</div>
								<br>
							</fieldset>
	
					</div>

					<!-- ## / Panel Content  -->

					<div class="button-bar">
					<input class="button-clean submit" id="save" type="submit" value="Upload" />
					<span style="padding-left: 90px;color:#000000;"> 
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexResource'" />
					</span> 
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
					</div>
		</form>
			</div>
		</div>
	</div>
</body>
</html>
