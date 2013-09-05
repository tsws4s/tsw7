<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.event-resources" />
<html>
<head>
<title>View <fmt:message key="event.title" />
</title>
</head>
<body>
	<div class="formular">
		<div class="panel">
			<div class="title">
				<h4>
					<fmt:message key="navigation.delete" /> <fmt:message key="event.title" />
					(${event.eventId}) <strong>${event.eventName}</strong>
				</h4>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content inpad">

				<fieldset>
					<br>
					<div>
						<label><fmt:message key="event.eventname.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.eventName}</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.starttime.title" />:&nbsp;&nbsp;&nbsp;
						<strong><fmt:formatDate value="${event.startTime.time}" pattern="yyyy-MM-dd hh:mm a" /></strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.endtime.title" />:&nbsp;&nbsp;&nbsp;
						<strong><fmt:formatDate value="${event.endTime.time}" pattern="yyyy-MM-dd hh:mm a" /></strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.eventtype.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.eventType}</strong></label>
					</div>
					<br>
					<div>
						<label>Event Color:&nbsp;&nbsp;&nbsp;
						<strong>${event.eventColor}</strong></label>
					</div>
					<br>
				</fieldset>
				<fieldset>
					<br>
					<div>
						<label><fmt:message key="event.description.title" />
						</label> <strong>${event.description}</strong>
					</div>
					<br>
				</fieldset>
				<fieldset>
					<br>
					<div>
						<label><fmt:message key="event.resourcefk.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.resource.resourceName}&nbsp;</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.pricefk.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.price.priceField}&nbsp;</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.programfk.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.program.programName}&nbsp;</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.gamefk.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.game.gameDate}&nbsp;</strong></label>
					</div>
					<br>
					<div>
						<label><fmt:message key="event.customerfk.title" />:&nbsp;&nbsp;&nbsp;
						<strong>${event.customer.firstname}&nbsp;${event.customer.lastname}&nbsp;</strong></label>
					</div>
					<br>
				</fieldset>
			</div>
			<div class="button-bar">
				<input class="button-clean" type="button" name="delete" value="Confirm Delete" onclick="location.href='${pageContext.request.contextPath}/deleteEvent?eventIdKey=${event.eventId}&amp;'" />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexEvent'" />
				<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/calendar.png" /></span>
			</div>

		</div>
	</div>

</body>
</html>
