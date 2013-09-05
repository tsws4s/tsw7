<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.application-resources"/>

				<ul id="navigation">				
					<li class="first"><a href="${pageContext.request.contextPath}/indexBudget">Budgets<span class="icon-dashboard"></span> </a></li> 
					<li><a href="${pageContext.request.contextPath}/indexBudgetAccount">Budget Accounts <span class="icon-faq"></span></a></li>
					<li><a href="${pageContext.request.contextPath}/indexBooks">Books <span class="icon-faq"></span></a></li>
					<li class="last"><a href="${pageContext.request.contextPath}/indexUsers">Users<span class="icon-forms"></span></a></li>
				</ul>
				

