<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.project-resources"/>
<html>
<head>
<title>List <fmt:message key="project.title"/>s</title>
</head>
<body>
				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Manage <fmt:message key="project.title"/>s</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="project.projectname.title"/></th>
					<th><fmt:message key="project.projecttype.title"/></th>
					<th class="center"><fmt:message key="project.startdate.title"/></th>
					<th class="center"><fmt:message key="project.duedate.title"/></th>
					<th class="center">Complete %</th>
					<th class="center"><fmt:message key="project.activeyn.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${projects}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editProject?projectIdKey=${current.projectId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteProject?projectIdKey=${current.projectId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.projectName}
						&nbsp;
					</td>

					<td>
						
							${current.projectType}
						&nbsp;
					</td>
					<td class="center">
						
							<fmt:formatDate pattern="MM-dd-yyyy" value="${current.startDate.time}"/>
						&nbsp;
					</td>
					<td class="center">
						
							<fmt:formatDate pattern="MM-dd-yyyy" value="${current.dueDate.time}"/>
						&nbsp;
					</td>
					<td class="center">
						
							${current.percentComplete+0}%
						&nbsp;
					</td>
					<td class="center">
					<c:choose>
						<c:when test="${current.activeYn == 0}">
		    				No
						</c:when>
						<c:otherwise>
		    				Yes
						</c:otherwise>
					</c:choose>	
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
			<a class="button-blue" href="${pageContext.request.contextPath}/newProject">New Project <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>						

		<div style="float:right;">			
			<ul class="page-navigation">
					<c:choose>
						<c:when test="${(indexFrom-resultsPerPage) < 0}">
							<li><span class="prev"> </span></li>
						</c:when>
						<c:otherwise>
							<li><a class="prev" href="${pageContext.request.contextPath}/indexProjectFrom?indexFrom=${indexFrom-resultsPerPage}"></a></li>
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
							<li><a class="next" href="${pageContext.request.contextPath}/indexProjectFrom?indexFrom=${indexFrom+resultsPerPage}"></a></li>
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