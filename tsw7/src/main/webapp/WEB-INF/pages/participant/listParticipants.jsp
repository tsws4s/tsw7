<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.participant-resources"/>
<html>
<head>
<title>List <fmt:message key="participant.title"/>s</title>
</head>
<body>
		<div class="panel">
			<div class="title-large">
				<h2>Manage Participants</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
			<div class="content">	

			<table class="tabularData">	

			<thead>
				<tr>
					<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
					<th><fmt:message key="participant.participantid.title"/></th>
					<th><fmt:message key="participant.amtpaid.title"/></th>
					<th><fmt:message key="participant.notes.title"/></th>
					<th><fmt:message key="participant.group1.title"/></th>
					<th><fmt:message key="participant.signedwaiveryn.title"/></th>
					<th><fmt:message key="participant.activeyn.title"/></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
					<th><fmt:message key="participant.participantid.title"/></th>
					<th><fmt:message key="participant.amtpaid.title"/></th>
					<th><fmt:message key="participant.notes.title"/></th>
					<th><fmt:message key="participant.group1.title"/></th>
					<th><fmt:message key="participant.signedwaiveryn.title"/></th>
					<th><fmt:message key="participant.activeyn.title"/></th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${participants}" var="current" varStatus="i">
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
						<a title="<fmt:message key="navigation.view" />" href="${pageContext.request.contextPath}/selectParticipant?participantIdKey=${current.participantId}&"><img src="images/icons/view.gif" /></a>
						&nbsp;<a title="<fmt:message key="navigation.edit" />" href="${pageContext.request.contextPath}/editParticipant?participantIdKey=${current.participantId}&">
						<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
						&nbsp;<a title="<fmt:message key="navigation.delete" />" href="${pageContext.request.contextPath}/confirmDeleteParticipant?participantIdKey=${current.participantId}&">
						<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.participantId}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.amtPaid}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.notes}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.group1}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.signedWaiverYn}
						&nbsp;
					</td>
					<td nowrap="nowrap" class="tabletd">
						
							${current.activeYn}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
						<!-- ## / Panel Content   #0099cc  -->
						</div>
	<div style="padding-top:10px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
				<input class="button-clean" type="button" name="new" value="New Participant" onclick="location.href='${pageContext.request.contextPath}/newParticipant'" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>
		</span>	
	</div>
</div>
</body>
</html>