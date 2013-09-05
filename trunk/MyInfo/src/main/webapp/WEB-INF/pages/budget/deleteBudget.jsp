<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.budget-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="budget.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="budget.title"/> 
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">

<div class="group fixed">
	<label>
		<fmt:message key="budget.budgetid.title"/>:
	</label> 
							${budget.budgetId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.name.title"/>:
	</label> 
							${budget.name}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.year.title"/>:
	</label> 
							${budget.year}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.activeyn.title"/>:
	</label> 
							${budget.activeYn}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.userfk.title"/>:
	</label> 
							${budget.userFk}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteBudget?budgetIdKey=${budget.budgetId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexBudget">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>