<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.budgetaccount-resources"/>
<html>
<head>
<title>List <fmt:message key="budgetaccount.title"/>s</title>
</head>
<body>
				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Manage <fmt:message key="budgetaccount.title"/>s</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="budgetaccount.budid.title"/></th>
					<th><fmt:message key="budgetaccount.account.title"/></th>
					<th><fmt:message key="budgetaccount.incexp.title"/></th>
					<th><fmt:message key="budgetaccount.budgetfk.title"/></th>
					<th><fmt:message key="budgetaccount.jan.title"/></th>
					<th><fmt:message key="budgetaccount.feb.title"/></th>
					<th><fmt:message key="budgetaccount.mar.title"/></th>
					<th><fmt:message key="budgetaccount.apr.title"/></th>
					<th><fmt:message key="budgetaccount.may.title"/></th>
					<th><fmt:message key="budgetaccount.jun.title"/></th>
					<th><fmt:message key="budgetaccount.jul.title"/></th>
					<th><fmt:message key="budgetaccount.aug.title"/></th>
					<th><fmt:message key="budgetaccount.sep.title"/></th>
					<th><fmt:message key="budgetaccount.oct.title"/></th>
					<th><fmt:message key="budgetaccount.nov.title"/></th>
					<th><fmt:message key="budgetaccount.dec.title"/></th>
					<th><fmt:message key="budgetaccount.total.title"/></th>
					<th><fmt:message key="budgetaccount.activeyn.title"/></th>
					<th><fmt:message key="budgetaccount.userfk.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${budgetaccounts}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editBudgetAccount?budIdKey=${current.budId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteBudgetAccount?budIdKey=${current.budId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.budId}
						&nbsp;
					</td>
					<td>
						
							${current.account}
						&nbsp;
					</td>
					<td>
						
							${current.incExp}
						&nbsp;
					</td>
					<td>
						
							${current.budgetFk}
						&nbsp;
					</td>
					<td>
						
							${current.jan}
						&nbsp;
					</td>
					<td>
						
							${current.feb}
						&nbsp;
					</td>
					<td>
						
							${current.mar}
						&nbsp;
					</td>
					<td>
						
							${current.apr}
						&nbsp;
					</td>
					<td>
						
							${current.may}
						&nbsp;
					</td>
					<td>
						
							${current.jun}
						&nbsp;
					</td>
					<td>
						
							${current.jul}
						&nbsp;
					</td>
					<td>
						
							${current.aug}
						&nbsp;
					</td>
					<td>
						
							${current.sep}
						&nbsp;
					</td>
					<td>
						
							${current.oct}
						&nbsp;
					</td>
					<td>
						
							${current.nov}
						&nbsp;
					</td>
					<td>
						
							${current.dec}
						&nbsp;
					</td>
					<td>
						
							${current.total}
						&nbsp;
					</td>
					<td>
						
							${current.activeYn}
						&nbsp;
					</td>
					<td>
						
							${current.userFk}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
						<!-- ## / Panel Content  -->
						</div>

	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newBudgetAccount">New BudgetAccount <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>						

		<div style="float:right;">			
			<ul class="page-navigation">
					<c:choose>
						<c:when test="${(indexFrom-resultsPerPage) < 0}">
							<li><span class="prev"> </span></li>
						</c:when>
						<c:otherwise>
							<li><a class="prev" href="${pageContext.request.contextPath}/indexBudgetAccountFrom?indexFrom=${indexFrom-resultsPerPage}"></a></li>
						</c:otherwise>
					</c:choose>	
					<c:choose>
						<c:when test="${(totalCount) < 2}">
							<span>&nbsp;[${indexFrom+1} of ${indexCount}]&nbsp;&nbsp;</span>
						</c:when>
						<c:otherwise>
							<span>&nbsp;[${indexFrom+1}-${indexFrom+totalCount} of ${indexCount}]&nbsp;&nbsp;</span>
						</c:otherwise>
					</c:choose>	
					<c:choose>
						<c:when test="${(indexFrom+resultsPerPage) > (indexCount-1)}">
							<li><span class="next"> </span></li>
						</c:when>
						<c:otherwise>
							<li><a class="next" href="${pageContext.request.contextPath}/indexBudgetAccountFrom?indexFrom=${indexFrom+resultsPerPage}"></a></li>
						</c:otherwise>
					</c:choose>	
			</ul>
		</div>	
	</div>
							
					</div>
					
					<div class="shadow"></div>
				</div>

</body>
</html>