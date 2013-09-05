<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>Edit <fmt:message key="program.title" /> <fmt:message key="participant.title" />
</title>
<script>
function validateForm()
{
    if(document.parentform.participant_customer.value=="")
    {
      alert("Participant should not be left blank");
      document.parentform.participant_customer.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveProgramParticipants" method="POST" modelAttribute="participant" name="parentform" onSubmit="return validateForm();">
					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									${program.programName}&nbsp;-&nbsp;<fmt:message key="navigation.new" /> <fmt:message key="participant.title" />
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									${participant.program.programName} - <fmt:message key="navigation.edit" /> <fmt:message key="participant.title" />
									(${participant.customer.customerId})<strong>${participant.customer.firstname} ${participant.customer.lastname}</strong>
								</h2>
								<form:hidden id="participant_participantId" path="participantId" />
							</c:otherwise>
						</c:choose>

						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="part-main">Participant</a></li>
							<li><a href="#" rel="part-notes">Notes</a></li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="part-main">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td>
									<br />
								<div>
									<label>Participant *</label>
									<!-- form:hidden id="participant_customer_customerId" path="customerId"/ -->
									<c:if test='${participant.customer == null}'>
										<input type="text" id="participant_customer" name="custName4" value="" readonly="readonly" style="width: 180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" href="/" onclick="window.open('${pageContext.request.contextPath}/searchCustomers', 'myWin', 'toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=770, height=620'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
									</c:if>
									<c:if test='${participant.customer != null}'>
										<input type="text" id="participant_customer" name="custName4" value="${participant.customer.firstname}&nbsp;${participant.customer.lastname}" readonly="readonly" style="width: 180px;" />
										&nbsp;&nbsp;
										<a class="button-clean" href="/" onclick="window.open('${pageContext.request.contextPath}/searchCustomers', 'myWin', 'toolbar=no, directories=no, location=no, status=yes, menubar=no, resizable=no, scrollbars=yes, width=770, height=620'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${participant.customer.customerId}" style="width: 20px;">
									</c:if>
								</div>
								<br>
								<div>
									<label><fmt:message key="participant.group1.title" /></label>
									<form:select id="participant_group1" path="group1" selected="${participant.group1}">
										<form:option value="">Select option</form:option>
										<form:option value="Group1">Group1</form:option>
										<form:option value="Group2">Group2</form:option>
										<form:option value="Group3">Group3</form:option>
										<form:option value="Group4">Group4</form:option>
										<form:option value="Group5">Group5</form:option>
										<form:option value="Group6">Group6</form:option>
									</form:select>
									&nbsp;&nbsp;
								</div>
								<br>
								</td>
								<td>
									<div style="width: 80px;">&nbsp;</div></td>
								<td>
								<br />

								<div>
									<label><fmt:message key="participant.amtpaid.title" /></label>
									$<form:input id="participant_amtPaid" path="amtPaid" cssStyle="width:80px;" />
								</div>
								<br />
								</td>
								<td>
									<div style="width: 100px;">&nbsp;</div></td>
								<td>
								<br>
								<div>
									<label><fmt:message key="participant.signedwaiveryn.title" /></label>
									<form:checkbox id="participant_signedWaiverYn" path="signedWaiverYn" value="1" />
								</div>
								<br>
								<div>
									<label><fmt:message key="participant.activeyn.title" /></label>
									<form:checkbox id="participant_activeYn" path="activeYn" value="1" />
								</div>
								<br>
									</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="part-notes">
							<fieldset>
								<br>
								<div>
									<label><fmt:message key="participant.notes.title" /></label>
									<form:textarea id="participant_notes" path="notes" rows="5" cssStyle="width:630px;" />
								</div>
								<br>
							</fieldset>
						</div>

					</div>
					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Participant" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/editProgram?programIdKey=${program_programId}&amp;indexFrom=0&amp;'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/participants.png" /></span>
						<input type="hidden" id="program_programId" name="program_programId" value="${program_programId}">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
