<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>Games for <fmt:message key="program.title" /></title>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveGeneratedGames" method="POST" modelAttribute="generatedGames" name="parentform">

					<div class="title-large">
						<h2>Generate Games</h2>
						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="game-main">Games
									for <fmt:message key="league.title" /> (${program.programId})<strong>
										${program.programName}</strong> </a></li>
							<li><a href="#" rel="game-gend">Generated Games</a></li>
							<li><a href="#" rel="game-teams">Teams (${numTeams+0})</a></li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="game-main">
							<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td style="width: 50%;">
									<br />
								<div>
									<label><fmt:message key="program.programname.title" /></label> 
									<input type="text" name="programName" value="${program.programName}" readonly="readonly" style="width: 180px;" /> 
								</div>
								<br>
								<div>
									<label>Level</label>
									<input type="text" name="levelName1" value="${program.level.levelName}" readonly="readonly" style="width: 180px;" />
								</div>
								<br>
								<div>									
								<label><fmt:message key="program.startdate.title" /> </label>
									<input type="text" name="startDate" value='<fmt:formatDate value="${program.startDate.time}" pattern="MM-dd-yyyy"/>' readonly="readonly" style="width: 100px;" /> 
								</div>
								<br>
								<div>
									<label><fmt:message key="program.enddate.title" /> </label> 
									<input type="text" name="endDate" value='<fmt:formatDate value="${program.endDate.time}" pattern="MM-dd-yyyy"/>' readonly="readonly" style="width: 100px;" />
								</div>
								<br>
									</td>
									<td>
										<div style="width: 80px;">&nbsp;</div></td>
									<td>
									<br />
								<div>
									<label>Number of Teams</label> 
									<input type="text" name="numTeams" value="${numTeams+0}" readonly="readonly" style="width: 50px;" /> 
								</div>
								<br>
								<div>
									<label>Games per Team &nbsp;</label>
									<input type="text" name="gamesPerTeam" value="${program.gamesPerTeam}" readonly="readonly" style="width: 50px;" /> 
								</div>
								<br>
								<div>
									<label>Games per Date &nbsp;</label> 
									<input type="text" name="gamesPerDate" value="1" style="width: 50px;" />
								</div>
								<br>
								<div>
									<label>Resource</label>
									<input type="text" name="resourceName1" value="${program.resource.resourceName}" readonly="readonly" style="width: 180px;" />
								</div>
								<br>
									</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="game-gend">
							<fieldset>
								<div>
									<div class="content">
										<table class="tabularData">
											<thead>
												<tr>
													<th><fmt:message key="game.gamedate.title" /></th>
													<th>Resource</th>
													<th>Home Team</th>
													<th>Visitor Team</th>
													<th>Game#</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="totalCount" value="0" />
												<c:forEach items="${generatedGames.gengamesList}" var="current" varStatus="i">
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
														<td><input type="hidden" name="current.gameDateTime.time" value="${current.gameDateTime.time}" /><fmt:formatDate type="date" value="${current.gameDateTime.time}" pattern="MM-dd-yyyy hh:mm a" />&nbsp;</td>
														<td> <input type="hidden" name="program.resource.resourceName" value="${program.resource.resourceName}" />${program.resource.resourceName}&nbsp;</td>
														<td>(${current.homeTeamId})&nbsp;${current.homeTeamName}&nbsp;</td>
														<td>(${current.visitorTeamId})&nbsp;${current.visitorTeamName}&nbsp;</td>
														<td>${current.gameNum+1}&nbsp;</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</fieldset>
						</div>
						<div class="tabs-content" id="game-teams">
							<fieldset>
								<div>
									<div class="content">
										<table class="tabularData">
											<thead>
												<tr>
													<th>&nbsp;Include</th>
													<th><fmt:message key="team.teamname.title" /></th>
													<th><fmt:message key="team.amtpaid.title" /></th>
													<th><fmt:message key="team.group3.title" /></th>
													<th><fmt:message key="team.color.title" /></th>
												</tr>
											</thead>
											<tbody>
												<c:set var="totalCount2" value="0" />
												<c:forEach items="${teams}" var="current" varStatus="i">
													<c:set var="totalCount2" value="${totalCount2+1}" />
													<c:choose>
														<c:when test="${(i.count) % 2 == 0}">
															<c:set var="rowclass" value="rowtwo" />
														</c:when>
														<c:otherwise>
															<c:set var="rowclass" value="rowone" />
														</c:otherwise>
													</c:choose>
													<tr class="${rowclass}">
														<td><input type="checkbox" name="useTeam" value="${current.teamId}" checked="checked" /></td>
														<td>${current.teamName}&nbsp;</td>
														<td>${current.amtPaid}&nbsp;</td>
														<td>${current.group3}&nbsp;</td>
														<td>${current.color}&nbsp;</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									<div class="button-bar">
											<input class="button-clean" type="button" name="regenGame" value="Re-Generate Games" onclick="location.href='${pageContext.request.contextPath}/generateGames?programIdKey=${program.programId}&amp;'" />
									</div>
									</div>
								</div>
							</fieldset>
						</div>

					</div>
					<!-- ## / Panel Content  -->
	
					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Game" />
						<!-- <input type="hidden" name="program_programId" /> -->
						<!-- <input type="hidden"  id="proggengames_gengamesList" name="gengamesList" />
						<input type="hidden"  id="proggengames_gengames" name="gengames" />
						<input type="hidden"  id="proggengames_programId" name="programId" /> -->
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexLeague'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</div>	
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>