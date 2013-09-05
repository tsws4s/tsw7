<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.requirement-resources"/>
<html>
<head>
<title>List <fmt:message key="requirement.title"/>s</title>
</head>
<body>
				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Manage <fmt:message key="requirement.title"/>s</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="requirement.status.title"/></th>
					<th><fmt:message key="requirement.reqmtcode.title"/></th>
					<th><fmt:message key="requirement.reqmtname.title"/></th>
					<th><fmt:message key="requirement.reqmtpriority.title"/></th>
					<th><fmt:message key="requirement.reqmtstorydescription.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${requirements}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editRequirement?reqmtIdKey=${current.reqmtId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteRequirement?reqmtIdKey=${current.reqmtId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.status}
						&nbsp;
					</td>

					<td>
						
							${current.reqmtCode}
						&nbsp;
					</td>
					<td>
						
							${current.reqmtName}
						&nbsp;
					</td>
					<td>
						
							${current.reqmtPriority}
						&nbsp;
					</td>
					<td>
						
							${current.reqmtStoryDescription}
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
			<a class="button-blue" href="${pageContext.request.contextPath}/newRequirement">New Requirement <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>						

		<div style="float:right;">			
			<ul class="page-navigation">
					<c:choose>
						<c:when test="${(indexFrom-resultsPerPage) < 0}">
							<li><span class="prev"> </span></li>
						</c:when>
						<c:otherwise>
							<li><a class="prev" href="${pageContext.request.contextPath}/indexRequirementFrom?indexFrom=${indexFrom-resultsPerPage}"></a></li>
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
							<li><a class="next" href="${pageContext.request.contextPath}/indexRequirementFrom?indexFrom=${indexFrom+resultsPerPage}"></a></li>
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