<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.level-resources" />
<html>
<head>
<title>List <fmt:message key="level.title" />s</title>
</head>
<body style="width:600px;">
	<div class="panel">

			<div class="title-large">
				<h2>List Levels</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">
	
						<table class="tabularData">

							<thead>
								<tr>
									<th>&nbsp;</th>
									<th><fmt:message key="level.levelname.title" />
									</th>
									<th><fmt:message key="level.levelcode.title" />
									</th>
									<th class="text-center"><fmt:message key="level.agelow.title" />
									</th>
									<th class="text-center"><fmt:message key="level.agehigh.title" />
									</th>
								</tr>
							</thead>
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
										<td width="20px" class="center">&nbsp;</td>
										<td>${current.levelName}&nbsp;</td>
										<td>${current.levelCode}&nbsp;</td>
										<td class="text-center">${current.ageLow}&nbsp;</td>
										<td class="text-center">${current.ageHigh}&nbsp;</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

				<!-- ## / Panel Content  -->
			</div>
			<div class="button-bar">
				<span style="padding-left: 90px;"> 
					<input class="button-clean" type="button" name="select" value="Print" onclick="window.print()" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Close" onclick="window.close()" />
				 </span>
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
			</div>

	</div>

</body>
</html>
