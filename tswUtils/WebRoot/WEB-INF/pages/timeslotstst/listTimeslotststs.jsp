<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.timeslotstst-resources"/>
<html>
<head>
<title>List <fmt:message key="timeslotstst.title"/>s</title>
</head>
<body>
<div id="contentarea" >
	<div id="lb"><div id="rb"><div id="bb"><div id="blc">
	<div id="brc"><div id="tb"><div id="tlc"><div id="trc">
	<div id="content">
		<h1>Manage <fmt:message key="timeslotstst.title"/>s</h1>
		<div class="navitem"><a class="button" href="${pageContext.request.contextPath}/newTimeslotstst"><span><img src="${pageContext.request.contextPath}/images/icons/new.gif" /><fmt:message key="navigation.new"/> <fmt:message key="timeslotstst.title"/></span></a></div>
		<div id="tablewrapper">
		<table id="listTable" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<th class="thead">&nbsp;</th>
					<th class="thead"><fmt:message key="timeslotstst.timeslotid.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.timeslot.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.date.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.start.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.end.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.pricelevel.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.custdisplay.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.custfk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.gamefk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.modifiedlast.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.modifiedbyuserfk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.zamoperatorcustfk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.activeyn.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.concessionwkrcustfk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.officewkrcustfk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.t3sfk.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.belongstoresid.title"/></th>
					<th class="thead"><fmt:message key="timeslotstst.programfk.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${timeslotststs}" var="current" varStatus="i">
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
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectTimeslotstst?timeslotIdKey=${current.timeslotId}&"><img src="images/icons/view.gif" /></a>
						<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editTimeslotstst?timeslotIdKey=${current.timeslotId}&"><img src="images/icons/edit.gif" /></a>
						<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteTimeslotstst?timeslotIdKey=${current.timeslotId}&"><img src="images/icons/delete.gif" /></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.timeslotId}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.timeslot}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="date" value="${current.date.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate timeStyle="short" type="time" value="${current.start.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate timeStyle="short" type="time" value="${current.end.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.priceLevel}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.custDisplay}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.custFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.gameFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							<fmt:formatDate dateStyle="short" type="both" value="${current.modifiedLast.time}"/>
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.modifiedByUserFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.zamOperatorCustFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.activeYn}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.concessionWkrCustFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.officeWkrCustFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.t3sFk}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.belongsToResId}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.programFk}
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