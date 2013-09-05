<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.team-resources" />
<html>
<head>
<title>Edit <fmt:message key="team.title" /> <fmt:message key="teamplayers.title" />
</title>
<script>
function validateForm()
{
    if(document.parentform.users_customer.value=="")
    {
      alert("Teamplayer should not be left blank");
      document.parentform.users_customer.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveTeamTeamplayerses" method="POST" modelAttribute="teamplayers" name="parentform" onSubmit="return validateForm();">

					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									${teamplayers.team.teamName} - <fmt:message key="navigation.new" /> Team Player
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									${teamplayers.team.teamName} - <fmt:message key="navigation.edit" />
									Team Player (${teamplayers.customer.customerId})<strong> ${teamplayers.customer.firstname} ${teamplayers.customer.lastname}</strong>
								</h2>
								<form:hidden id="team_teamPlayersId" path="teamPlayersId" />
							</c:otherwise>
						</c:choose>

						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="tp-main">Team Player</a>
							</li>
							<li><a href="#" rel="tp-notes">Notes</a>
							</li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="tp-main">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td>
								<div>
									<label>Team Player *</label>
									<c:if test='${teamplayers.customer == null}'>
										<input type="text" id="users_customer" name="custName4" value="" readonly="readonly" style="width: 180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" class="icon" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
									</c:if>
									<c:if test='${teamplayers.customer != null}'>
										<input type="text" id="users_customer" name="custName4" value="${teamplayers.customer.firstname}&nbsp;${teamplayers.customer.lastname}" readonly="readonly" style="width: 180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" class="icon" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${teamplayers.customer.customerId}" style="width: 20px;">
									</c:if>
								</div>
								</td>
								<td>
									<div style="width: 80px;">&nbsp;</div></td>
								<td>
								<br />
								<div>
									<label>League <fmt:message key="teamplayers.amtpaid.title" /></label>
									$<form:input id="teamplayers_amtPaid" path="amtPaid" cssStyle="width:100px;" />
								</div>
								<br />
								</td>
								<td>
									<div style="width: 100px;">&nbsp;</div></td>
								<td>
								<div>
									<label><fmt:message key="teamplayers.signedwaiveryn.title" /></label>
									<form:checkbox id="teamplayers_signedWaiverYn" path="signedWaiverYn" value="1" />
								</div>
								</td>

								</tr>
								<tr style="width: 100%;">
									<td><br />
								<div>
									<label>Player Position</label>
									<select id="itemSelectedsportPos4" name="selected_sportPosition_id1">
									<option value="">Select position</option>
										<c:forEach items="${positions}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${teamplayers.sportPosition!=null && current.sportPositionId eq teamplayers.sportPosition.sportPositionId}">
											<option value="${current.sportPositionId}" selected="selected">${current.sportPositionName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.sportPositionId}">${current.sportPositionName}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>
								<br>
								</td>
								<td>
									<div style="width: 80px;">
									<label>Captain</label>
									<form:checkbox id="teamplayers_captain" path="captain" value="0" />
									</div></td>
								<td>
								<br />
								<div>
									<label>Other <fmt:message key="teamplayers.amtpaid.title" /></label>
									$<form:input id="teamplayers_otherAmtPaid" path="otherAmtPaid" cssStyle="width:100px;" />
								</div>
								<br />
								</td>
								<td>
									<div style="width: 100px;">&nbsp;</div></td>
								<td>

								<div>
									<label><fmt:message key="teamplayers.activeyn.title" /></label>
									<form:checkbox id="teamplayers_activeYn" path="activeYn" value="1" />
								</div>
								<br>
									</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="tp-notes">
							<fieldset>
								<br>
								<div>
									<label><fmt:message key="teamplayers.notes.title" /></label>
									<form:textarea id="teamplayers_notes" path="notes" rows="5" cssStyle="width:630px;" />
								</div>
								<br>
							</fieldset>
						</div>

					</div>
					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Team Player" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgramTeams?program_programId=${program_programId}&amp;program_programName=&amp;teams_teamId=${team_teamId}&amp;'" />
						<input type="hidden" id="team_teamId" name="team_teamId" value="${team_teamId}">
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
