<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.event-resources" />
<html>
<head>
<title>List <fmt:message key="event.title" />s</title>

<script>
function refreshEventList(data)
{
	window.open('${pageContext.request.contextPath}/indexEventFrom?resource_resourceId='+data+'&afterDate=&indexFrom=-1','_self',false); 
	return false;
}
</script>
</head>
<body>
	<div class="panel">
		<div class="title-large">
			<h2>
				Manage <fmt:message key="event.title" />s for Resource:&nbsp;&nbsp;&nbsp;
			<select id="forResource" name="resource" onchange="javascript:refreshEventList(this.value);return false;">
				<c:forEach items="${resources}" var="current" varStatus="i">
				<c:choose>
				<c:when test="${res!=null && current.resourceId eq res.resourceId}">
					<option value="${current.resourceId}" selected="selected">${current.resourceName}</option>
				</c:when>
				<c:otherwise>
					<option value="${current.resourceId}">${current.resourceName}</option>
				</c:otherwise>									
				</c:choose>
				</c:forEach>
			</select></h2>
			<span style="text-align:right; padding: 10px 30px 5px 40px;font-size: 12px;color:#ffffff;">								
			<a href="${pageContext.request.contextPath}/scheduling?resource_resourceId=${res.resourceId}&afterDate=&beforeDate=&"><button>Scheduling Calendar</button></a>
			</span>
			<div class="theme"></div>
			<div class="drop"></div>
		</div>
		<div class="content">

			<table class="tabularData">

				<thead>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th class="text-center">Event Date</th>
						<th class="text-center"><fmt:message key="event.starttime.title" />
						</th>
						<th class="text-center"><fmt:message key="event.endtime.title" />
						</th>
						<th><fmt:message key="event.eventname.title" />
						</th>
						<th><fmt:message key="event.eventtype.title" />
						</th>
						<th><fmt:message key="event.resourcefk.title" />
						</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
						<th class="text-center">Event Date</th>
						<th class="text-center"><fmt:message key="event.starttime.title" />
						</th>
						<th class="text-center"><fmt:message key="event.endtime.title" />
						</th>
						<th><fmt:message key="event.eventname.title" />
						</th>
						<th><fmt:message key="event.eventtype.title" />
						</th>
						<th><fmt:message key="event.resourcefk.title" />
						</th>
					</tr>
				</tfoot>
				<tbody>
					<c:set var="totalCount" value="0" />
					<c:forEach items="${events}" var="current" varStatus="i">
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
								<a class="button-clean" href="${pageContext.request.contextPath}/editEvent?eventIdKey=${current.eventId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
							&nbsp;
								<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteEvent?eventIdKey=${current.eventId}&amp;">
								<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
							</td>
							<td class="text-center"><fmt:formatDate type="date" value="${current.eventDate.time}" pattern="MM-dd-yyyy" />&nbsp;</td>

							<td class="text-center"><fmt:formatDate type="time" value="${current.startTime.time}" pattern="hh:mm a" />&nbsp;</td>
							<td class="text-center"><fmt:formatDate type="time" value="${current.endTime.time}" pattern="hh:mm a" />&nbsp;</td>
							<td>${current.eventName}&nbsp;</td>
							<td>${current.eventType}&nbsp;</td>
							<td>${current.resource.resourceName}&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- ## / Panel Content icon-edit labels icon-remove class="button-clean"  #0099cc  -->
		</div>
		<div class="button-bar">
			<span style="padding-left: 20px;"> 
				<input class="button-clean" type="button" name="new" value="New Event" onclick="location.href='${pageContext.request.contextPath}/newEvent'" />
			</span>
			<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/calendar.png" /></span>
		</div>
	</div>
</body>
</html>
