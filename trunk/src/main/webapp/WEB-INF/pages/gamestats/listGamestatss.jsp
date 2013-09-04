<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.gamestats-resources"/>
<html>
<head>
<title>List <fmt:message key="gamestats.title"/>s</title>
</head>
<body>
<div id="contentarea" >
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1>Manage <fmt:message key="gamestats.title"/>s</h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newGamestats"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="gamestats.title"/></span></a></div>
		<div id="tablewrapper">
		<table id="listTable" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th class="thead">&nbsp;</th>
					<th class="thead"><fmt:message key="gamestats.gamestatsid.title"/></th>
					<th class="thead"><fmt:message key="gamestats.sportstattypefk.title"/></th>
					<th class="thead"><fmt:message key="gamestats.gamestatvalue.title"/></th>
					<th class="thead"><fmt:message key="gamestats.gamestattime.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${gamestatss}" var="current" varStatus="i">
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
					<td nowrap="nowrap" class="tabletd">
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectGamestats?gameStatsIdKey=${current.gameStatsId}&"><img src="images/icons/view.gif" /></a>
						<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editGamestats?gameStatsIdKey=${current.gameStatsId}&"><img src="images/icons/edit.gif" /></a>
						<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteGamestats?gameStatsIdKey=${current.gameStatsId}&"><img src="images/icons/delete.gif" /></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.gameStatsId}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.sportStatTypeFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.gameStatValue}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate timeStyle="short" type="time" value="${current.gameStatTime.time}"/>
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	</div></div></div></div>
	</div></div></div></div>
</div>
</body>
</html>