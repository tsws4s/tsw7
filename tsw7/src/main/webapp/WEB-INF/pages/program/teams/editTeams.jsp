<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>Edit <fmt:message key="league.title" /> <fmt:message key="team.title" />
</title>
<script>
function validateForm()
{
    if(document.parentform.team_teamName.value=="")
    {
      alert("Team Name should not be left blank");
      document.parentform.team_teamName.focus();
      return false;
    }
     else if(document.parentform.team_coach.value=="")
    {
      alert("Coach should not be left blank");
      document.parentform.team_coach.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveProgramTeams" method="POST" modelAttribute="team" name="parentform" onSubmit="return validateForm();">
					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									${program.programName}&nbsp;-&nbsp;<fmt:message key="navigation.new" /> <fmt:message key="team.title" />
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									${team.program.programName}&nbsp;-&nbsp;<fmt:message key="navigation.edit" />
									Team (${team.teamId})<strong> ${team.teamName}</strong>
								</h2>
								<form:hidden id="team_teamId" path="teamId" />
							</c:otherwise>
						</c:choose>

						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="team-main">Team</a></li>
							<li><a href="#" rel="team-coach">Coach/Notes</a></li>
							<li><a href="#" rel="team-standing">Standing</a></li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="team-main">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td style="width: 50%;">
									<br />
								<div>
									<label><fmt:message key="team.teamname.title" /> *</label>
									<form:input id="team_teamName" path="teamName" cssStyle="width:200px;" />
								</div>
								<br>
								<div>
									<label>Level</label>
									<select id="itemSelected1" name="selected_id1">
									<option value="">Select level</option>
										<c:forEach items="${levels}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${team.level!=null && current.levelId eq team.level.levelId}">
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
									<label><fmt:message key="team.group3.title" /></label>
									<form:select id="team_group3" path="group3" selected="${team.group3}">
										<form:option value="">Select option</form:option>
										<form:option value="Beginner">Beginner</form:option>
										<form:option value="Intermediate">Intermediate</form:option>
										<form:option value="Advanced">Advanced</form:option>
									</form:select>
								</div>
								<br />
								</td>
								<td>
									<div style="width: 60px;">&nbsp;</div></td>
								<td>
								<br />
								<div>
									<label>Jersey <fmt:message key="team.color.title" /></label>
									<form:select id="team_color" path="color" selected="${team.color}">
										<form:option value="">Select option</form:option>
										<form:option value="Green">Green</form:option>
										<form:option value="Blue">Blue</form:option>
										<form:option value="Red">Red</form:option>
										<form:option value="Yellow">Yellow</form:option>
										<form:option value="Tan">Tan</form:option>
										<form:option value="Gray">Gray</form:option>
										<form:option value="White">White</form:option>
										<form:option value="Black">Black</form:option>
										<form:option value="Brown">Brown</form:option>
									</form:select>
								</div>
								<br>
								<div>
									<label><fmt:message key="team.publishyn.title" /></label>
									<form:checkbox id="team_publishYn" path="publishYn" value="1" />
								</div>
								<br>
								<div>
									<label><fmt:message key="team.amtpaid.title" /></label>
									$<form:input id="team_amtPaid" path="amtPaid" cssStyle="width:80px;" />
								</div>
								<br>
								</td>
								<td>
									<div style="width: 80px;">&nbsp;</div></td>
								<td>								
								<td>
								<br />
								<div>
									<label><fmt:message key="team.activeyn.title" /></label>
									<form:checkbox id="team_activeYn" path="activeYn" value="1" />
								</div>
								<br>
								</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="team-coach">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td style="width: 50%;">
								<br>
								<div>
									<label>Coach *</label>
									<c:if test='${team.customerByCoachCustFk == null}'>
										<input type="text" id="team_coach" name="custName4" value="" readonly="readonly" style="width:180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin2','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width:20px;" />
									</c:if>
									<c:if test='${team.customerByCoachCustFk != null}'>
										<input type="text" id="team_coach" name="custName4" value="${team.customerByCoachCustFk.firstname}&nbsp;${team.customerByCoachCustFk.lastname}" readonly="readonly" style="width:180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin2','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${team.customerByCoachCustFk.customerId}" style="width:20px;" />
									</c:if>
								</div>
								<br />
								</td>
								<td>
									<div style="width: 80px;">&nbsp;</div></td>
								<td>
								<br />
								<div>
									<label>Manager</label>
									<c:if test='${team.customerByManagerCustFk == null}'>
										<input type="text" id="team_manager" name="custName5" value="" 	readonly="readonly" style="width:180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers2?custNum=5&', 'myWin3','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected5" name="selected_id5" value="" style="width:20px;" />
									</c:if>
									<c:if test='${team.customerByManagerCustFk != null}'>
										<input type="text" id="team_manager" name="custName5" value="${team.customerByManagerCustFk.firstname}&nbsp;${team.customerByManagerCustFk.lastname}" readonly="readonly" style="width:180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers2?custNum=5&', 'myWin3','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected5" name="selected_id5" value="${team.customerByManagerCustFk.customerId}" style="width:20px;" />
									</c:if>
								</div>
								<br />
								</td>
								</tr>
							</tbody>
						</table>
								
								<div>
									<label><fmt:message key="team.notes.title" /></label>
									<form:textarea id="team_notes" path="notes" rows="5" cssStyle="width:650px;" />
								</div>
								<br>
							</fieldset>
						</div>
						<div class="tabs-content" id="team-standing">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td><div style="width: 150px;">&nbsp;</div></td>
									<td>
									<br />
									<div>
										<label><fmt:message key="team.wins.title" /></label>
										<form:input type="text" id="team_wins" path="wins" readonly="readonly" cssStyle="width:50px;" />
									</div>
									<br>
									</td>
									<td>
										<div style="width: 50px;">&nbsp;</div></td>
									<td>
									<br />
								<div>
									<label><fmt:message key="team.losses.title" /></label>
									<form:input type="text" id="team_losses" path="losses" readonly="readonly" cssStyle="width:50px;" />
								</div>
								<br>
									</td>
									<td>
										<div style="width: 50px;">&nbsp;</div></td>
									<td>
									<br />
								<div>
									<label><fmt:message key="team.ties.title" /></label>
									<form:input type="text" id="team_ties" path="ties" readonly="readonly" cssStyle="width:50px;" />
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
						<input class="button-clean submit" id="save" type="submit" value="Save Team" />
						<input type="hidden" name="program_programId" value="${team.program.programId}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgram?programIdKey=${team.program.programId}&indexFrom=0&'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</div>


				</form:form>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test='${newFlag}'>

		</c:when>
		<c:otherwise>
			<div class="panel">
				<div class="title">
					<h4>Team Players</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content">
					<table class="tabularData">
						<thead>
							<tr>
								<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
								<th>Player Firstname</th>
								<th>Player Lastname</th>
								<th>Position</th>
								<th class="text-center">Year Born</th>
								<th class="text-center"><fmt:message key="teamplayers.amtpaid.title" /></th>
								<th class="text-center"><fmt:message key="teamplayers.signedwaiveryn.title" /></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th class="text-center">Edit&nbsp;&nbsp;|&nbsp;&nbsp;Delete</th>
								<th>Player Firstname</th>
								<th>Player Lastname</th>
								<th>Position</th>
								<th class="text-center">Year Born</th>
								<th class="text-center"><fmt:message key="teamplayers.amtpaid.title" /></th>
								<th class="text-center"><fmt:message key="teamplayers.signedwaiveryn.title" /></th>
							</tr>
						</tfoot>
						<tbody>
							<c:set var="totalCount" value="0" />
							<c:forEach items="${team.teamplayerses}" var="current" varStatus="i">
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
									<a class="button-clean" href="${pageContext.request.contextPath}/editTeamTeamplayerses?team_teamId=${team.teamId}&teamplayerses_teamPlayersId=${current.teamPlayersId}&">
									<span><img class="icon" src="explorer/images/icons/icon-edit.png" alt="Edit" /></span></a>
								&nbsp;
									<a class="button-clean" href="${pageContext.request.contextPath}/confirmDeleteTeamTeamplayerses?team_teamId=${team.teamId}&related_teamplayerses_teamPlayersId=${current.teamPlayersId}&">
									<span><img class="icon" src="explorer/images/icons/icon-delete.png" alt="Delete"></span></a>
								</td>							

									<td>${current.customer.firstname}&nbsp;</td>
									<td>${current.customer.lastname}&nbsp;</td>
									<td>${current.sportPosition.sportPositionName}&nbsp;</td>
									<td class="text-center">${current.customer.yearBorn}&nbsp;</td>
									<fmt:setLocale value="en_US"/>
									<fmt:formatNumber var="fmtPaid" value="${current.amtPaid}" type="currency" pattern="$#,##0.00;" />
									<td class="text-right">${fmtPaid}&nbsp;</td>
									<td class="text-center">
									<c:if test='${current.signedWaiverYn == 1}'>	
										&nbsp;Yes
									</c:if> &nbsp;</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="button-bar">
					<span style="padding-left:20px;"> 
						<input class="button-clean" type="button" name="new" value="New Team Player" onclick="location.href='${pageContext.request.contextPath}/newTeamTeamplayerses?team_teamId=${team.teamId}&'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</span>
				</div>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>
