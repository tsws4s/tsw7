<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>List <fmt:message key="program.title" />s</title>
</head>
<body>
	<div class="panel">
		<div class="title-large">
			<c:choose>
				<c:when test='${leagueFlag}'>
					<h2>
						Manage <fmt:message key="league.title" />s
					</h2>
				</c:when>
				<c:otherwise>
					<h2>
						Manage <fmt:message key="program.title" />s
					</h2>
				</c:otherwise>
			</c:choose>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">

			<table class="tabularData">

				<thead>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="program.programname.title" /></th>
						<th>Level</th>
						<th class="text-center"><fmt:message key="program.price.title" /></th>
						<th class="text-center"><fmt:message key="program.startdate.title" /></th>
						<th class="text-center"><fmt:message key="program.enddate.title" /></th>
						<th class="text-center"><fmt:message key="program.publishyn.title" /></th>
						<th class="text-center">Paid</th>
						<th class="text-center">Count</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="program.programname.title" /></th>
						<th>Level</th>
						<th class="text-center"><fmt:message key="program.price.title" /></th>
						<th class="text-center"><fmt:message key="program.startdate.title" /></th>
						<th class="text-center"><fmt:message key="program.enddate.title" /></th>
						<th class="text-center"><fmt:message key="program.publishyn.title" /></th>
						<th class="text-center">Paid</th>
						<th class="text-center">Count</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${programs}" var="current" varStatus="i">
						<c:set var="totalCount" value="${totalCount+1}" />
						<c:choose>
							<c:when test="${(i.count) % 2 == 0}">
								<c:set var="rowclass" value="rowtwo" />
							</c:when>
							<c:otherwise>
								<c:set var="rowclass" value="rowone" />
							</c:otherwise>
						</c:choose>
						<tr class="${rowclass}">
							<td>		
								<a class="button-clean" href="${pageContext.request.contextPath}/editProgram?programIdKey=${current.programId}&amp;indexFrom=0&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgram?programIdKey=${current.programId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>

							<td>${current.programName}&nbsp;</td>
							<td>${current.level.levelName}&nbsp;</td>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber var="fmtPrice" value="${current.price.priceField}" type="currency" pattern="$#,##0.00;" />
							<td class="text-right">${fmtPrice}</td>
							<td class="text-center"><fmt:formatDate type="date" value="${current.startDate.time}" pattern="MM-dd-yyyy" />&nbsp;</td>
							<td class="text-center"><fmt:formatDate type="date" value="${current.endDate.time}" pattern="MM-dd-yyyy" /> &nbsp;</td>
							<td class="text-center">
							<c:if test='${current.publishYn == 1}'>	
								&nbsp;Yes
							</c:if> &nbsp;</td>
							<fmt:setLocale value="en_US"/>
							<fmt:formatNumber var="fmtPaid" value="${current.totalPaid}" type="currency" pattern="$#,##0.00;" />
							<td class="text-right">${fmtPaid}&nbsp;</td>
							<td class="text-center">${current.totalParticipants}&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content  -->
		</div>

		<c:choose>
			<c:when test='${leagueFlag}'>
				<c:set var="theDomain" value="League" />
			</c:when>
			<c:otherwise>
				<c:set var="theDomain" value="Program" />
			</c:otherwise>
		</c:choose>

		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New ${theDomain}" onclick="location.href='${pageContext.request.contextPath}/new${theDomain}'" />
			</span>
		<c:choose>
			<c:when test='${leagueFlag}'>
				<span style="padding-left: 100px;">
					<input class="button-clean" type="button" name="teams" value="Teams" onclick="location.href='${pageContext.request.contextPath}/indexTeam'" />
				</span>
				<span style="padding-left: 160px;"> 
					<input class="button-clean" type="button" name="games" value="Games" onclick="location.href='${pageContext.request.contextPath}/indexGame'" />
				</span>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
			</c:when>
			<c:otherwise>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>

			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>