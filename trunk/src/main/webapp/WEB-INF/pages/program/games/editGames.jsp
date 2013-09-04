<%@page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.program-resources" />
<html>
<head>
<title>Edit <fmt:message key="program.title" /> <fmt:message key="game.title" /></title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
#map_canvas {
	width: 100%;
}
</style>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC-xV0KLoyYlogf6tJtxLNa2pUWyXUcimk&amp;sensor=false">
</script>
<script type="text/javascript">
  var map;
  function initMap() {
    var latlng = new google.maps.LatLng(44.962906, -93.184942);
    var mapOptions = {
      zoom: 14,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
  }

  function updateAddress(address) {
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert("Geocode not successful: " + status);
      }
    });
  }

    </script>
<script>
function validateForm()
{
    if(document.parentform.game_gameDate.value=="")
    {
      alert("Game Date should not be left blank");
      document.parentform.game_gameDate.focus();
      return false;
    }
     else if(document.parentform.game_startTime.value=="")
    {
      alert("Start Time should not be left blank");
      document.parentform.game_startTime.focus();
      return false;
    }
     else if(document.parentform.game_home.value=="")
    {
      alert("Home Team should not be left blank");
      document.parentform.game_home.focus();
      return false;
    }
    else if(document.parentform.game_visitor.value=="")
    {
      alert("Visitor Team should not be left blank");
      document.parentform.game_visitor.focus();
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
				<form:form action="${pageContext.request.contextPath}/saveProgramGames" method="POST" modelAttribute="game" name="parentform" onSubmit="return validateForm();">
					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									${program_programName}&nbsp;-&nbsp;<fmt:message key="navigation.new" />&nbsp;Game
								</h2>
								<form:hidden id="game_gameId" path="gameId" />
							</c:when>
							<c:otherwise>
								<h2>
									${game.program.programName} - <fmt:message key="navigation.edit" />
									&nbsp;Game (${game.gameId}) <strong><fmt:formatDate dateStyle="short" type="date" value="${game.gameDate.time}" />&nbsp;</strong>
									${game.teamByHomeTeamFk.teamName} vs. ${game.teamByVisitorTeamFk.teamName}
								</h2>
								<form:hidden id="game_gameId" path="gameId" />
							</c:otherwise>
						</c:choose>
						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="game-main">Game</a></li>
							<li><a href="#" rel="game-map">Map</a></li>
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
									<td>
								<br />
								<div>
									<label><fmt:message key="game.gamedate.title" /> *</label> 
									<input class="datepicker" id="game_gameDate" name="gameDate" type="text" value='<fmt:formatDate value="${game.gameDate.time}" pattern="MM/dd/yyyy"/>' style="width: 150px;" />
								</div>
								</td>
								<td width="150px;">
								<br>
								<div>
									<label>Game Time *</label> 
									<input id="game_startTime" name="startTime" type="text" value='<fmt:formatDate value="${game.startTime.time}" pattern="hh:mm a"/>' style="width: 80px;" />
								</div>
								</td>
								<td>
								<br>
								<div>
									<label>Game Minutes</label> 
									<input type="text" id="game_program_gameMins" name="gameMins" readonly="readonly" value='${game.program.gameMins}' style="width:100px;" />
								</div>
								</td>
								</tr>
								<tr>
								<td>
								<br>
								<div>
									<label>Resource</label>
									<select id="itemSelected8" name="selected_id8">
									<option value="">Select resource</option>
										<c:forEach items="${resources}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${game.resource!=null && current.resourceId eq game.resource.resourceId}">
											<option value="${current.resourceId}" selected="selected">${current.resourceName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.resourceId}">${current.resourceName}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>		
								</div>								
								</td>
								<td width="150px;">&nbsp;

								</td>
								<td>
								<br>
								<div>
									<label>Referee</label>
									<c:if test='${game.customer == null}'>
										<input type="text" id="game_refereeFk" name="custName4" value="" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="${pageContext.request.contextPath}/searchCustomers"
											onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
									</c:if>
									<c:if test='${game.customer != null}'>
										<input type="text" id="game_refereeFk" name="custName4" value="${game.customer.firstname}&nbsp;${game.customer.lastname}" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="${pageContext.request.contextPath}/searchCustomers"
											onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected4" name="selected_id4" value="${game.customer.customerId}" style="width: 20px;">
									</c:if>
								</div>	
								</td>
								</tr>
								<tr>
								<td>
								<br />
								<div>
									<label>Home Team *</label>
									<c:if test='${game.teamByHomeTeamFk == null}'>
										<input type="text" id="game_home" name="teamName2" value="" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchTeam?program_programId=${program_programId}&amp;teamNum=2&amp;', 'myWin','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected2" name="selected_id2" value="" style="width: 20px;">
									</c:if>
									<c:if test='${game.teamByHomeTeamFk != null}'>
										<input type="text" id="game_home" name="teamName2" value="${game.teamByHomeTeamFk.teamName}" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchTeam?program_programId=${game.program.programId}&amp;teamNum=2&amp;', 'myWin','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected2" name="selected_id2" value="${game.teamByHomeTeamFk.teamId}" style="width: 20px;">
									</c:if>
								</div>
								</td>
								<td>&nbsp;</td>
								<td>
								<br>
								<div>
									<label><fmt:message key="game.homescore.title" /></label>
									<form:input id="game_homeScore" path="homeScore" cssStyle="width:50px;" />
									<strong>&nbsp;&nbsp;&nbsp;${game.teamByHomeTeamFk.teamName}</strong>
								</div>	
								</td>						
								</tr>
								<tr>
								<td>
								<br>
								<div>
									<label>Visitor Team *</label>
									<c:if test='${game.teamByVisitorTeamFk == null}'>
										<input type="text" id="game_visitor" name="teamName3" value="" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchTeam?program_programId=${program_programId}&amp;teamNum=3&amp;', 'myWin','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected3" name="selected_id3" value="" style="width: 20px;">
									</c:if>
									<c:if test='${game.teamByVisitorTeamFk != null}'>
										<input type="text" id="game_visitor" name="teamName3" value="${game.teamByVisitorTeamFk.teamName}" readonly="readonly" style="width: 180px;" />
										<a class="button-clean" href="" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchTeam?program_programId=${game.program.programId}&amp;teamNum=3&amp;', 'myWin','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
											<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										<input type="hidden" id="itemSelected3" name="selected_id3" value="${game.teamByVisitorTeamFk.teamId}" style="width: 20px;">
									</c:if>
								</div>
								<br>
									</td>
								<td>&nbsp;</td>
								<td>
								<br>
								<div>
									<label><fmt:message key="game.visitorscore.title" /></label>
									<form:input id="game_visitorScore" path="visitorScore" cssStyle="width:50px;" />
									<strong>&nbsp;&nbsp;&nbsp;${game.teamByVisitorTeamFk.teamName}</strong>
								</div>
								<br>
									</td>
								</tr>
							</tbody>
						</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="game-map">
							<fieldset>
								<br>
								<div>
								<label>Resource Address</label>
									<c:if test='${game.resource != null}'>									
									${game.resource.resourceName}&nbsp;&nbsp; 
										<c:set var="addressFields" value="${game.resource.address}, ${game.resource.city}, ${game.resource.state}  ${game.resource.zipcode}" />
										<input type="text" id="addrField" value="${addressFields}" style="width: 300px" readonly="readonly" />
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
										<a href="#" onclick="initMap(); updateAddress(addrField.value); return false"><button>Show Map</button></a>
									</c:if>
								</div>
								<br>
								<div>
									<label>Map</label>
									<div id="map_canvas" style="width: 100%; height: 500px;"></div>
								</div>
								<br>
							</fieldset>
						</div>
						
					</div>
					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Game" />
						<input type="hidden" name="program_programId" value="${program_programId}">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexGame'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/sports.png" /></span>
					</div>

				</form:form>
			</div>
		</div>
	</div>

</body>
</html>
