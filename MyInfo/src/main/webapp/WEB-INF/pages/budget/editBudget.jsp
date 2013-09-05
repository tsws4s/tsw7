<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.budget-resources"/>
<html>
<head>
<title>Edit <fmt:message key="budget.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveBudget" method="POST" modelAttribute="budget" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="budget.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="budget.title"/>
								<form:hidden id="budget_budgetId" path="budgetId"/>
								</c:otherwise>
							</c:choose>
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

							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="budget_budgetId" path="budgetId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "budget_budgetId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="budget.budgetid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${budget.budgetId}
						&nbsp;
									<form:hidden id="budget_budgetId" path="budgetId"/>
								</c:otherwise>
							</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.name.title"/>:
	</label> 

							<form:input id="budget_name" path="name" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "budget_name",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="budget.name.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.year.title"/>:
	</label> 

							<form:input id="budget_year" path="year" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "budget_year",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="budget.year.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.activeyn.title"/>:
	</label> 

							<form:input id="budget_activeYn" path="activeYn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "budget_activeYn",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="budget.activeyn.help"/>", constraints : {places:0}}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="budget.userfk.title"/>:
	</label> 

							<form:input id="budget_userFk" path="userFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "budget_userFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="budget.userfk.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Budget"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexBudget">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>