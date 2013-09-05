<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.myinfo-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="myinfo.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="myinfo.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="myinfo.myinfoid.title"/>:
	</label> 
							${myinfo.myInfoId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.title.title"/>:
	</label> 
							${myinfo.title}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.url.title"/>:
	</label> 
							${myinfo.url}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.categoryfk.title"/>:
	</label> 
							${myinfo.categoryFk}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.username.title"/>:
	</label> 
							${myinfo.username}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.password.title"/>:
	</label> 
							${myinfo.password}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.filename.title"/>:
	</label> 
							${myinfo.filename}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.account.title"/>:
	</label> 
							${myinfo.account}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.userfk.title"/>:
	</label> 
							${myinfo.userFk}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="myinfo.active.title"/>:
	</label> 
							${myinfo.active}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteMyInfo?myinfoIdKey=${myinfo.myInfoId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexMyInfo">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>