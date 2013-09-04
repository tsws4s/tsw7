<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>Edit <fmt:message key="program.title" />
</title>

<script>
function validateForm()
{
    if(document.parentform.program_programName.value=="")
    {
      alert("Name should not be left blank");
      document.parentform.program_programName.focus();
      return false;
    }
    else if(document.parentform.program_startDate.value=="")
    {
      alert("Start Date should not be left blank");
      document.parentform.program_startDate.focus();
      return false;
    }
    else if(document.parentform.program_gamesPerTeam.value=="")
    {
      alert("Number Sessions/Games should not be left blank");
      document.parentform.program_gamesPerTeam.focus();
      return false;
    }
    else if(document.parentform.program_sport.value=="")
    {
      alert("Sport should not be left blank");
      document.parentform.program_sport.focus();
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
				<form:form action="${pageContext.request.contextPath}/saveProgram" method="POST" modelAttribute="program" name="parentform" onSubmit="return validateForm();">

					<div class="title-large">
						<c:choose>
							<c:when test='${leagueFlag}'>
								<c:set var="league_program" value="League" />
								<c:choose>
									<c:when test='${newFlag}'>
										<h2>
											<fmt:message key="navigation.new" /> <fmt:message key="league.title" />
										</h2>
										<form:hidden id="program_leagueYn" path="leagueYn" value="1" />
									</c:when>
									<c:otherwise>
										<h2>
											<fmt:message key="navigation.edit" /> <fmt:message key="league.title" />
											(${program.programId}) <strong>${program.programName}</strong>
										</h2>
										<form:hidden id="program_programId" path="programId" />
										<form:hidden id="program_totalPaid" path="totalPaid" />
										<form:hidden id="program_totalParticipants" path="totalParticipants" />
										<form:hidden id="program_leagueYn" path="leagueYn" value="1" />
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
								<c:set var="league_program" value="Program" />
								<c:choose>
									<c:when test='${newFlag}'>
										<h2>
											<fmt:message key="navigation.new" /> <fmt:message key="program.title" />
										</h2>
										<form:hidden id="program_leagueYn" path="leagueYn" value="0" />
									</c:when>
									<c:otherwise>
										<h2>
											<fmt:message key="navigation.edit" /> <fmt:message key="program.title" />
											(${program.programId})<strong> ${program.programName}</strong>
										</h2>
										<form:hidden id="program_programId" path="programId" />
										<form:hidden id="program_totalPaid" path="totalPaid" />
										<form:hidden id="program_totalParticipants" path="totalParticipants" />
										<form:hidden id="program_leagueYn" path="leagueYn" value="0" />
									</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>

						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="pgm-main">${league_program}</a>
							</li>
							<li><a href="#" rel="pgm-coord">Coordinator</a>
							</li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="pgm-main">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td style="width: 40%;">
									<br />
									<div>
										<label>${league_program} Name *</label>
										<form:input id="program_programName" path="programName" cssStyle="width:200px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="program.startdate.title" /> *</label> 
										<input class="datepicker" id="program_startDate" name="startDate" type="text" value='<fmt:formatDate value="${program.startDate.time}" pattern="MM/dd/yyyy"/>' style="width: 150px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="program.enddate.title" /></label> 
										<input class="datepicker" id="program_endDate" name="endDate" type="text" value='<fmt:formatDate value="${program.endDate.time}" pattern="MM/dd/yyyy"/>' style="width: 150px;" />
									</div>
									<br />
									</td>
									<td>
										<div style="width: 80px;">&nbsp;</div></td>
									<td>

								<div>
									<label>Level</label>
									<select id="itemSelected1" name="selected_id1">
									<option value="">Select level</option>
										<c:forEach items="${levels}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${program.level!=null && current.levelId eq program.level.levelId}">
											<option value="${current.levelId}" selected="selected">${current.levelName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.levelId}">${current.levelName}</option>
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
										<c:when test="${program.price!=null && current.priceId eq program.price.priceId}">
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
										<label><fmt:message key="program.publishyn.title" /></label>
										<form:checkbox id="program_publishYn" path="publishYn" value="1" />
									</div>
									<br>
									</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="pgm-coord">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td style="width: 40%;">
									<br />	
								<div>
									<label>Coordinator</label>
									<!-- form:hidden id="program_customer_customerid" path="customerId"/ -->
									<c:if test='${program.customer == null}'>
										<input id="program_coord" type="text" name="custName4" value="" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="${pageContext.request.contextPath}/searchCustomers"
											onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
									</c:if>
									<c:if test='${program.customer != null}'>
										<input id="program_coord" type="text" name="custName4" value="${program.customer.firstname}&nbsp;${program.customer.lastname}" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="${pageContext.request.contextPath}/searchCustomers"
											onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${program.customer.customerId}" style="width: 20px;">
									</c:if>
									&nbsp;
								</div>		
									</td>
									<td width="80px;">&nbsp;</td>
									<td>
								<div>
									<label>Sport *</label>
								<c:choose>
									<c:when test='${newFlag}'>
										<select id="itemSelectedsport4" name="selected_sport_id1">
										<option value="">Select sport</option>
											<c:forEach items="${sports}" var="current" varStatus="i">
											<c:choose>
											<c:when test="${program.sport!=null && current.sportId eq program.sport.sportId}">
												<option value="${current.sportId}" selected="selected">${current.sportName}</option>
											</c:when>
											<c:otherwise>
												<option value="${current.sportId}">${current.sportName}</option>
											</c:otherwise>									
											</c:choose>
											</c:forEach>
										</select>	
									</c:when>
									<c:otherwise>
										<input id="itemSelectedsport4b" type="text" name="selected_sport_id1b" value="${program.sport.sportName}" readonly="readonly" style="width: 100px;" />									
										<input id="itemSelectedsport4" type="hidden" name="selected_sport_id1" value="${program.sport.sportId}" />									
									</c:otherwise>
								</c:choose>
	
								</div>	
									</td>
								</tr>
								 <tr>
									<td>
								<div>
									<c:set var="gamesOrSessions" value="Number of Sessions" />
									<c:if test='${leagueFlag}'>
										<c:set var="gamesOrSessions" value="Games per Team" />
									</c:if>
									<label>${gamesOrSessions} *</label>
									<form:input id="program_gamesPerTeam" path="gamesPerTeam" cssStyle="width:50px;" />
									&nbsp;Duration:&nbsp;		
									<form:select id="program_gameMins" path="gameMins" selected="${program.gameMins}">
										<form:option value="">Select</form:option>
										<form:option value="50">50 Mins</form:option>
										<form:option value="60">60 Mins</form:option>
										<form:option value="90">90 Mins</form:option>
										<form:option value="120">2 Hrs</form:option>
										<form:option value="150">150 Mins</form:option>
										<form:option value="180">3 Hrs</form:option>
										<form:option value="240">4 Hrs</form:option>
									</form:select>
								</div>
									</td>
									<td width="80px;">&nbsp;</td>
									<td>
								<div>
									<label><fmt:message key="program.activeyn.title" /></label>
									<form:checkbox id="program_activeYn" path="activeYn" value="1" />
								</div>
									</td>
								</tr>
								 <tr>
									<td>
									<br />
								<div>
									<label>Default Resource</label>
									<select id="itemSelected8" name="selected_id8">
									<option value="">Select resource</option>
										<c:forEach items="${resources}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${program.resource!=null && current.resourceId eq program.resource.resourceId}">
											<option value="${current.resourceId}" selected="selected">${current.resourceName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.resourceId}">${current.resourceName}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>	
								<br />
									</td>
									<td width="80px;">&nbsp;</td>
									<td>
								<br />
								<div>
									&nbsp;
								</div>
								<br />
									</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
					</div>
					<div class="button-bar">
						<c:choose>
							<c:when test='${leagueFlag}'>
								<input class="button-clean submit" id="save" type="submit" value="Save League" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="button-clean" type="reset" name="reset" value="Reset" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexLeague'" />
								<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
							</c:when>
							<c:otherwise>
								<input class="button-clean submit" id="save" type="submit" value="Save Program" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="button-clean" type="reset" name="reset" value="Reset" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexProgram'" />
								<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>
							</c:otherwise>
						</c:choose>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test='${newFlag}'>

		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test='${leagueFlag}'>
					<div class="panel">
						<div class="title">
							<h4>Teams</h4>
							<div class="theme"></div>
							<div class="drop"></div>
						</div>
						<div class="content">
							<table class="tabularData">
								<thead>
									<tr>
										<th class="text-center">Games&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
										<th><fmt:message key="team.teamname.title" /></th>
										<th>Coach</th>
										<th class="text-right">Paid</th>
										<th><fmt:message key="team.group3.title" /></th>
										<th><fmt:message key="team.color.title" /></th>
										<th class="text-center"><fmt:message key="team.wins.title" /></th>
										<th class="text-center"><fmt:message key="team.losses.title" /></th>
										<th class="text-center"><fmt:message key="team.ties.title" /></th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th class="text-center">Games&nbsp;&nbsp;|&nbsp;&nbsp;Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
										<th><fmt:message key="team.teamname.title" /></th>
										<th>Coach</th>
										<th class="text-right">Paid</th>
										<th><fmt:message key="team.group3.title" /></th>
										<th><fmt:message key="team.color.title" /></th>
										<th class="text-center"><fmt:message key="team.wins.title" /></th>
										<th class="text-center"><fmt:message key="team.losses.title" /></th>
										<th class="text-center"><fmt:message key="team.ties.title" /></th>
									</tr>
								</tfoot>
								<tbody>
									<c:set var="totalCount" value="0" />
									<c:forEach items="${program.teams}" var="current" varStatus="i">
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
											<td style="width:140px;">				
											<a class="button-clean" href="${pageContext.request.contextPath}/listProgramGames?programIdKey=${program.programId}&amp;">
											<span><img class="icon" src="explorer/images/icon-calendar.png" alt="Calendar" /></span></a>
											&nbsp;	
												<a class="button-clean" href="${pageContext.request.contextPath}/editProgramTeams?program_programId=${program.programId}&amp;program_programName=${program.programName}&amp;teams_teamId=${current.teamId}&amp;">
												<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
											&nbsp;
												<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgramTeams?program_programId=${program.programId}&amp;program_programName=${program.programName}&amp;related_teams_teamId=${current.teamId}&amp;">
												<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
											</td>											

											<td>${current.teamName}&nbsp;</td>
											<td>${current.customerByCoachCustFk.firstname}&nbsp;${current.customerByCoachCustFk.lastname}&nbsp;</td>
											<fmt:setLocale value="en_US"/>
											<fmt:formatNumber var="fmtPaid" value="${current.amtPaid}" type="currency" pattern="$#,##0.00;" />
											<td class="text-right">${fmtPaid}&nbsp;</td>
											<td>${current.group3}&nbsp;</td>
											<td>${current.color}&nbsp;</td>
											<td class="text-center">${current.wins}&nbsp;</td>
											<td class="text-center">${current.losses}&nbsp;</td>
											<td class="text-center">${current.ties}&nbsp;</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="button-bar">
							<span style="padding-left: 20px;"> 
							<input class="button-clean" type="button" name="new" value="New Team" onclick="location.href='${pageContext.request.contextPath}/newProgramTeams?program_programId=${program.programId}&amp;'" />
							</span> <span style="padding-left: 90px;"> 
							<input class="button-clean" type="button" name="game" value="Games" onclick="location.href='${pageContext.request.contextPath}/listProgramGames?programIdKey=${program.programId}&amp;'" />
							</span>
							<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="panel">
						<div class="title">
							<h4>Participants</h4>
							<div class="theme"></div>
							<div class="drop"></div>
						</div>
						<div class="content">
							<table class="tabularData">
								<thead>
									<tr>
										<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
										<th>Participant Firstname</th>
										<th>Lastname</th>
										<th class="text-center">Year Born</th>
										<th class="text-right"><fmt:message key="participant.amtpaid.title" /></th>
										<th class="text-center"><fmt:message key="participant.signedwaiveryn.title" /></th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
										<th>Participant Firstname</th>
										<th>Lastname</th>
										<th class="text-center">Year Born</th>
										<th class="text-right"><fmt:message key="participant.amtpaid.title" /></th>
										<th class="text-center"><fmt:message key="participant.signedwaiveryn.title" /></th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${program.participants}" var="current"
										varStatus="i">
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
												<a class="button-clean" href="${pageContext.request.contextPath}/editProgramParticipants?program_programId=${program.programId}&amp;participants_participantId=${current.participantId}&amp;">
												<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
											&nbsp;
												<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgramParticipants?program_programId=${program.programId}&amp;related_participants_participantId=${current.participantId}&amp;">
												<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
											</td>								

											<td>${current.customer.firstname}&nbsp;</td>
											<td>${current.customer.lastname}&nbsp;</td>
											<td class="text-center">${current.customer.yearBorn}&nbsp;</td>
											<fmt:setLocale value="en_US"/>
											<fmt:formatNumber var="fmtPaid" value="${current.amtPaid}" type="currency" pattern="$#,##0.00;" />
											<td class="text-right">${fmtPaid}&nbsp;</td>
											<td class="text-center">
											<c:if test='${current.signedWaiverYn == 1}'>	
												&nbsp;Yes
											</c:if>
							 			&nbsp;</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="button-bar">
							<span style="padding-left: 20px;"> 
							<input class="button-clean" type="button" name="game" value="New Participant" onclick="location.href='${pageContext.request.contextPath}/newProgramParticipants?program_programId=${program.programId}&amp;'" />
							</span>
							<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
								<div class="panel">
						<div class="title">
							<h4>Resources</h4>
							<div class="theme"></div>
							<div class="drop"></div>
						</div>
						<div class="content">
							<table class="tabularData">
								<thead>
									<tr>
										<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
										<th>Reource</th>
										<th>Type</th>
										<th class="text-right">Hourly Rate</th>
										<th>City</th>
										<th>State</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
										<th>Reource</th>
										<th>Type</th>
										<th class="text-right">Hourly Rate</th>
										<th>City</th>
										<th>State</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach items="${program.programresources}" var="current"
										varStatus="i">
										<c:choose>
											<c:when test="${(i.count) % 2 == 0}">
												<c:set var="rowclass" value="rowtwo" />
											</c:when>
											<c:otherwise>
												<c:set var="rowclass" value="rowone" />
											</c:otherwise>
										</c:choose>
										<fmt:setLocale value="en_US"/>
										<fmt:formatNumber var="fmtPaid" value="${current.resourcePrice.priceField}" type="currency" pattern="$#,##0.00;" />
										<tr class="${rowclass}">
											<td style="width:100px;">				
												<a class="button-clean" href="${pageContext.request.contextPath}/editProgramresource?programResourceIdKey=${current.programResourceId}&amp;">
												<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
											&nbsp;
												<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteProgramresource?programResourceIdKey=${current.programResourceId}&amp;">
												<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
											</td>								
											<td>${current.resource.resourceName}&nbsp;</td>
											<td>${current.resource.resourceType}&nbsp;</td>
											<td class="text-right">${fmtPaid}&nbsp;</td>
											<td>${current.resource.city}&nbsp;</td>
											<td>${current.resource.state}&nbsp;</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="button-bar">
							<span style="padding-left: 20px;"> 
							<input class="button-clean" type="button" name="game" value="New Resource" onclick="location.href='${pageContext.request.contextPath}/newProgramresource?program_programId=${program.programId}&amp;'" />
							</span>
							<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
						</div>
					</div>
			
		</c:otherwise>
	</c:choose>
</body>
</html>
