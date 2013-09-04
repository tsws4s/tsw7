<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.event-resources" />
<html>
<head>
<title>Edit <fmt:message key="event.title" />
</title>
<!--  link href="explorer/jquery/1.8/jquery-ui.css" rel="stylesheet" type="text/css" /  -->
<!--  script type='text/javascript' src='explorer/jquery/1.5/jquery.min.js'></script  -->
<script>
function validateForm()
{
    if(document.parentform.event_eventName.value=="")
    {
      alert("Event Name should not be left blank");
      document.parentform.event_eventName.focus();
      return false;
    }
    else if(document.parentform.event_startTime.value=="")
    {
      alert("Start Time should not be left blank (unless All Day)");
      document.parentform.event_startTime.focus();
      return false;
    }
}
</script>
 <script>
$(function() {
	$( ".datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "explorer/images/icon-calendar.png",
		buttonImageOnly: true,
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true
	});
});
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">

				<form:form action="${pageContext.request.contextPath}/saveEvent" name="parentform" method="POST" modelAttribute="event" onSubmit="return validateForm();">

					<div class="title-large">

						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									<fmt:message key="navigation.new" />
									<fmt:message key="event.title" />
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									<fmt:message key="navigation.edit" /><fmt:message key="event.title" />
									(${event.eventId}) <strong>${event.eventName}</strong>
								</h2>
								<form:hidden id="event_eventId" path="eventId" />
								<form:hidden id="event_eventUrl" path="eventUrl" />
							</c:otherwise>
						</c:choose>
						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="event-main">Event</a>
							</li>
							<li><a href="#" rel="event-desc">Description</a>
							</li>
							<li><a href="#" rel="event-details">Details</a>
							</li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="event-main">
							<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">						
								<td style="width:60%;" colspan="2">
								<br>
								<div>
									<label><fmt:message key="event.eventname.title" /> *</label>
									<form:input id="event_eventName" path="eventName" autofocus="autofocus" cssStyle="width:250px;" />
								</div>								
								</td>
								<td width="70px;">&nbsp;</td>
								<td>
								<br>
								<div>
									<label>All Day Event</label>
									<form:checkbox id="event_allDay" path="allDay" value="" />
								</div>								
								</td>
							</tr>
							<tr>						
								<td>
								<br>
								<div>
									<label>Start Date *</label> 
									<input class="datepicker" id="event_eventDate" name="eventDate" type="text" value='<fmt:formatDate value="${event.eventDate.time}" pattern="MM/dd/yyyy"/>' style="width: 100px;" />
								</div>								
								</td>
								<td>
								<br>
								<div>
									<label><fmt:message key="event.starttime.title" /> *</label> 
									<input id="event_startTime" name="startTime" type="text" value='<fmt:formatDate value="${event.startTime.time}" pattern="hh:mm a"/>' style="width: 80px;" />
								</div>							
								</td>
								<td width="70px;">&nbsp;</td>
								<td>
								<br>
								<div>
									<label><fmt:message key="event.eventtype.title" /></label>
									<form:select id="event_eventType" path="eventType"
										selected="${event.eventType}">
										<form:option value="">Select option</form:option>
										<form:option value="Game">Game</form:option>
										<form:option value="Program">Program</form:option>
										<form:option value="Reserved">Reserved</form:option>
										<form:option value="Open">Open</form:option>
									</form:select>
									&nbsp;&nbsp;&nbsp;
								</div>								
								</td>
							</tr>
							<tr>						
								<td>
								<br>
								<div>
									&nbsp;
								</div>
								<br>								
								</td>
								<td>
								<br>
								<div>
									<label><fmt:message key="event.endtime.title" /></label> 
									<input id="event_endtime" name="endTime" type="text" value='<fmt:formatDate value="${event.endTime.time}" pattern="hh:mm a"/>' style="width: 80px;" />
								</div>	
								</td>
								<td width="70px;">&nbsp;</td>
								<td>
								<br>
								<div>
									<label>Event Color</label>
									<form:select id="event_eventColor" path="eventColor"
										selected="${event.eventColor}">
										<form:option value="">Select option</form:option>
										<form:option value="Green">Green</form:option>
										<form:option value="Yellow">Yellow</form:option>
										<form:option value="Blue">Blue</form:option>
										<form:option value="Gray">Gray</form:option>
									</form:select>
									&nbsp;&nbsp;&nbsp;
								</div>								
								</td>
							</tr>							
						</tbody>
					</table>	
							</fieldset>
						</div>
						<div class="tabs-content" id="event-desc">
							<fieldset>
								<br>
								<div>
									<label><fmt:message key="event.description.title" /></label>
									<form:textarea id="event_description" path="description" rows="5" cssStyle="width:650px;" />
								</div>
								<br>
							</fieldset>
						</div>
						<div class="tabs-content" id="event-details">
							<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">				
								<td style="width:50%;">
								<br>
								<div>
									<label>Resource</label>
									<select id="itemSelected8" name="selected_id8">
									<option value="">Select resource</option>
										<c:forEach items="${resources}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${event.resource!=null && current.resourceId eq event.resource.resourceId}">
											<option value="${current.resourceId}" selected="selected">${current.resourceName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.resourceId}">${current.resourceName}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>								
								<br>
								<div>
									<label>Price</label>
									<select id="itemSelected11" name="selected_id11">
									<option value="">Select price</option>
										<c:forEach items="${prices}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${event.price!=null && current.priceId eq event.price.priceId}">
											<option value="${current.priceId}" selected="selected">$ ${current.priceField} - ${current.priceCategory}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.priceId}">$ ${current.priceField} - ${current.priceCategory}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>
								<br>
								<div>
									<label>Customer</label>
									<c:if test='${event.customer == null}'>
										<input id="event_customerFk" type="text" name="custName4" value="" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="${pageContext.request.contextPath}/searchCustomers"
											onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
									</c:if>
									<c:if test='${event.customer != null}'>
										<input id="event_customerFk" type="text" name="custName4" value="${event.customer.firstname}&nbsp;${event.customer.lastname}" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="${pageContext.request.contextPath}/searchCustomers"
											onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${event.customer.customerId}" style="width: 20px;">
									</c:if>
								</div>
									<br>
								</td>
								<td>
									<div style="width:50px;">&nbsp;</div>
								</td>
								<td>
									<br>
								<div>
									<label><fmt:message key="event.programfk.title" /></label> 
									<input id="event_programFk" type="text" name="programName" value="${event.program.programName}" readonly="readonly" style="width: 180px;" /> 
									<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span>
									<input type="hidden" id="itemSelected12" name="programId" value="" />
								</div>
								<br>
								<div>
									<label><fmt:message key="event.gamefk.title" /></label> 
									<input id="event_gameFk" type="text" name="gameDate" value="${event.game.gameDate}" readonly="readonly" style="width: 200px;" /> 
									<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span>
									<input type="hidden" id="itemSelected14" name="gameId" value="" />
								</div>
								<br>
								</td>
							</tr>
						</tbody>
					</table>	
							</fieldset>
						</div>
					</div>

					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Event" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/scheduling?resource_resourceId=${event.resource.resourceId}&amp;afterDate=&amp;beforeDate=&amp;'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/calendar.png" /></span>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
