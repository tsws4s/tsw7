<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.quickStart-resources" />

<html>
  <head>
    <title>League Quick Entry</title>
<script>
function validateForm()
{
    if(document.parentform.leagueName.value=="")
    {
      alert("League Name should not be left blank");
      document.parentform.leagueName.focus();
      return false;
    }
    else if(document.parentform.startDate.value=="")
    {
      alert("Start Date should not be left blank");
      document.parentform.startDate.focus();
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
		showButtonPanel: true
	});
});
</script>
  </head>
  
  <body>
	<div class="section">
		<div class="full">
		
		<div class="panel wizard">
		
				<form:form action="${pageContext.request.contextPath}/saveLeagueQuickStart" name="parentform" method="POST" modelAttribute="event" onSubmit="return validateForm();">
		
			<div class="header">
				<div class="wizard-title">
					<h2>League Quick Entry</h2>
					<span>We will guide you through League &amp; Team setup</span>
				</div>
				<div class="progress-zone">
					<div class="progress-bar">
					
						<div class="progress-wrap">
							<div class="pbar ct-step-1"><div class="done"></div></div>
							
							<div class="step-1 selected">1</div>
							<div class="step-2 off">2</div>
							<div class="step-3 off">3</div>
							<div class="step-4 off">4</div>
							<div class="step-5 off">5</div>
							<div class="step-6 off">6</div>
						</div>
						
						<div class="label selected">League<span>Enter League information</span></div>
						<div class="label">Coordinator<span>Select a coordinator</span></div>
						<div class="label">Teams<span>Enter Team names</span></div>
						<div class="label">Teams (Cont)<span>Enter Team names</span></div>
						<div class="label">Finish<span>Save league &amp; teams</span></div>
						<div class="label">Extra1<span>Extra1</span></div>
						
					</div>
				</div>
				<div class="theme"></div>
			</div>
			
			<div class="content">					
				<div class="wizard-content">
					<ul>
						<li>
							<div class="wizard-text">
								<span class="numbering">1</span>
								<h2>League</h2>
								<span class="subtext">Enter League information</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>League</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>
								
									<p>
										<label for="text"><fmt:message key="league.name"/></label>
										<input type="text" id="leagueName" name="leagueName" />
									</p>
										
									<p>
										<label for="text"><fmt:message key="league.startdate"/></label>
										<input type="text" id="startDate" name="startDate" />
									</p>
									
									<p>
										<label for="text"><fmt:message key="league.enddate"/></label>
										<input type="text" id="endDate" name="endDate" />
									</p>
									<p>
										<label for="text"><fmt:message key="league.level"/></label>
										<input type="text" id="level" name="level" />
									</p>
								</div>
								
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">2</span>
								<h2>Coordinator</h2>
								<span class="subtext">Select a coordinator</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Coordinator</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>
																
							
									<p>
										<label for="text"><fmt:message key="league.coordinatorname"/></label>
										<input type="text" id="coordinatorName" name="coordinatorName" />
									</p>
										
									<p>
										<label for="text"><fmt:message key="league.gamesperteam"/></label>
										<input type="text" id="gamePerTeam" name="gamePerTeam" />
									</p>
									<p>
										<label for="text"><fmt:message key="league.resource"/></label>
										<input type="text" id="resource" name="resource" />
									</p>
									<p>
										<label for="text"><fmt:message key="league.price"/></label>
										<input type="text" id="price" name="price" />
									</p>
								</div>
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">3</span>
								<h2>Team Names</h2>
								<span class="subtext">Enter Team names</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Team Names</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>

										<table>
											<tbody>
												<tr>
													<td>
														<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName1" name="teamName1" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName1" name="coachName1" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName2" name="teamName2" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName2" name="coachName2" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName3" name="teamName3" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName3" name="coachName3" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName4" name="teamName4" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName4" name="coachName4" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName5" name="teamName5" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName5" name="coachName5" />

													</td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">4</span>
								<h2>Team Names (Cont)</h2>
								<span class="subtext">Enter Team names</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">
								<div class="formular">
									<h1>Team Names (Cont)</h1>
									<div class="hr"></div>
									<p>The term database is correctly applied to the data itself, and is different from the DBMS which is a software system that allows to store and change the data, as well as retrieve information from it.</p>

										<table>
											<tbody>
												<tr>
													<td>
														<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName6" name="teamName6" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName6" name="coachName6" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName7" name="teamName7" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName7" name="coachName7" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName8" name="teamName8" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName8" name="coachName8" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName9" name="teamName9" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName9" name="coachName9" />
													</td>
												</tr>
												<tr>
													<td>
													<label for="text"><fmt:message key="league.teamname"/></label>
														<input type="text" id="teamName10" name="teamName10" />
													</td>
													<td>
														<label for="text"><fmt:message key="league.coachname"/></label>
														<input type="text" id="coachName10" name="coachName10" />

													</td>
												</tr>
											</tbody>
										</table>
									</div>
							</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">5</span>
								<h2>Finish</h2>
								<span class="subtext">Save league &amp; teams</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">							
							<h1>Save</h1>
							<div class="hr"></div>
							<p>Save new League.</p>
					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexLeague'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/calendar.png" /></span>
					</div>
					&nbsp;</div>
						</li>
						<li>
							<div class="wizard-text">
								<span class="numbering">6</span>
								<h2>Extra1</h2>
								<span class="subtext">Extra1</span>
								<p>Older machines are known as single-stroke headers, while newer machines are known as double-stroke headers, because they have two strokes; one stroke moves the workpiece into the machine and the second heads the workpiece.</p>
							</div>
							<div class="step-content">							
							<h1>Extra1</h1>
							<div class="hr"></div>
							<p>Extra1</p>
							<br><br>				
							&nbsp;</div>
						</li>
					</ul>
				</div>
				
				<div class="wizard-nav clearfix">
					<a href="#" class="wiz-prev">
						<span><img src="explorer/images/icon-previews.png" /> &nbsp;Previous Step</span>
					</a>
					<a href="#" class="wiz-next">
						<span>Next Step&nbsp;&nbsp;<img src="explorer/images/icon-next.png" /></span>
					</a>
				</div>
				
			</div>

				</form:form>			
			
		</div>
		
		</div>
	</div>
  </body>
</html>