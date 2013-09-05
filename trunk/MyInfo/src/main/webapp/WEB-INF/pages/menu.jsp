<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.users-resources"/>

	<div class="panel-wrapper">
		<div class="panel">
			<h1>Spring MVC</h1>
			<p class="line">&nbsp;</p>
			<jsp:include page="/WEB-INF/pages/users/menu.jsp" />
<jsp:include page="/WEB-INF/pages/myinfo/menu.jsp" />
<jsp:include page="/WEB-INF/pages/mycategory/menu.jsp" />
<jsp:include page="/WEB-INF/pages/books/menu.jsp" />
<jsp:include page="/WEB-INF/pages/budgetaccount/menu.jsp" />
<jsp:include page="/WEB-INF/pages/budget/menu.jsp" />
<div class="clear">&nbsp;</div>
		</div>
	
</div>