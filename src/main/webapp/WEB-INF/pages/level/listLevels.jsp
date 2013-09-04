<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.level-resources" />
<html>
<head>
<title>List <fmt:message key="level.title" />s</title>
</head>
<body>
	<div class="panel">
		<div class="title">
			<h4>Manage Levels</h4>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">

			<table class="tabularData">

				<thead>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="level.levelname.title" />
						</th>
						<th><fmt:message key="level.levelcode.title" />
						</th>
						<th class="text-center"><fmt:message key="level.agelow.title" />
						</th>
						<th class="text-center"><fmt:message key="level.agehigh.title" />
						</th>
						<th class="text-center"><fmt:message key="level.activeyn.title" />
						</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th><fmt:message key="level.levelname.title" />
						</th>
						<th><fmt:message key="level.levelcode.title" />
						</th>
						<th class="text-center"><fmt:message key="level.agelow.title" />
						</th>
						<th class="text-center"><fmt:message key="level.agehigh.title" />
						</th>
						<th class="text-center"><fmt:message key="level.activeyn.title" />
						</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${levels}" var="current" varStatus="i">
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
							<td style="width:100px;">											
							<a class="button-clean" href="${pageContext.request.contextPath}/editLevel?levelIdKey=${current.levelId}&amp;">
							<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
							<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteLevel?levelIdKey=${current.levelId}&amp;">
							<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>	

							<td>${current.levelName}&nbsp;</td>
							<td>${current.levelCode}&nbsp;</td>
							<td class="text-center">${current.ageLow}&nbsp;</td>
							<td class="text-center">${current.ageHigh}&nbsp;</td>
							<td class="text-center">
							<c:if test='${current.activeYn == 1}'>	
							&nbsp;Yes
							</c:if> 
						&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content   #0099cc  -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New Level" onclick="location.href='${pageContext.request.contextPath}/newLevel'" />
			</span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
		</div>
	</div>

</body>
</html>