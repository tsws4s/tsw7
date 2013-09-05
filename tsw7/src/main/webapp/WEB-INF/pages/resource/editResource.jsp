<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.resource-resources" />
<html>
<head>
<title>Edit <fmt:message key="resource.title" />
</title>
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
    if(document.parentform.resource_resourceName.value=="")
    {
      alert("Resource Name should not be left blank");
      document.parentform.resource_resourceName.focus();
      return false;
    }
    else if(document.parentform.resource_resourceType.value=="")
    {
      alert("Resource Type should not be left blank");
      document.parentform.resource_resourceType.focus();
      return false;
    }
}
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">

				<form:form action="${pageContext.request.contextPath}/saveResource" name="parentform" method="POST" modelAttribute="resource" onSubmit="return validateForm();">

					<div class="title-large">

						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									<fmt:message key="navigation.new" /> <fmt:message key="resource.title" />
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									<fmt:message key="navigation.edit" /> <fmt:message key="resource.title" />
									- <strong>${resource.resourceName}</strong>
								</h2>
								<form:hidden id="resource_resourceId" path="resourceId" />
							</c:otherwise>
						</c:choose>
						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="res-main">Resource</a></li>
							<li><a href="#" rel="res-address">Address</a></li>
							<li><a href="#" rel="res-map">Map</a></li>
							<li><a href="#" rel="res-notes">Notes</a></li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="res-main">
							<fieldset>
							<table>	
								<tbody>
									<tr style="width:100%;">				
										<td style="width:50%;">
											<br>
											<div>
												<label><fmt:message key="resource.resourcename.title" /> *</label>
												<form:input id="resource_resourceName" path="resourceName" autofocus="autofocus" cssStyle="width:300px;" />
											</div>
											<br>
											<div>
												<label><fmt:message key="resource.resourcetype.title" /> *</label>
												<form:select id="resource_resourceType" path="resourceType"
													selected="${resource.resourceType}">
													<form:option value="--">Select option</form:option>
													<form:option value="Cricket Field">Cricket Field</form:option>
													<form:option value="Baseball Field">Baseball Field</form:option>
													<form:option value="Softball Field">Softball Field</form:option>
													<form:option value="LaCrose Field">LaCrose Field</form:option>
													<form:option value="Soccer Field">Soccer Field</form:option>
													<form:option value="Football Field">Football Field</form:option>
													<form:option value="Ice Rink">Ice Rink</form:option>
													<form:option value="Exercise Room">Exercise Room</form:option>
													<form:option value="Indoor Field">Indoor Field</form:option>
													<form:option value="Basketball Court">Basketball Court</form:option>
													<form:option value="Racquetball Court">Racquetball Court</form:option>
													<form:option value="Bowling Alley">Bowling Alley</form:option>
												</form:select>
												&nbsp;&nbsp;&nbsp;
											</div>
											<br>
											<div>
												<label>Price</label>
												<select id="itemSelected11" name="selected_id11">
												<option value="">Select price</option>
													<c:forEach items="${prices}" var="current" varStatus="i">
													<c:choose>
													<c:when test="${resource.price!=null && current.priceId eq resource.price.priceId}">
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
										</td>
										<td>
											<div style="width:40px;">&nbsp;</div>
										</td>
										<td>
											<br>
											<div>
												<label><fmt:message key="resource.activeyn.title" /></label>
												<form:checkbox id="resource_activeYn" path="activeYn" value="1" />
											</div>
											<br>
											<div>
												<label>Contact Email</label>
												<form:input id="resource_email" type="text" path="email" placeholder="name@example.com" cssStyle="width:300px;" />
											</div>
											<br>
											<div>
												<label>Contact Phone</label>
												<form:input id="resource_phone" type="tel" path="phone" cssStyle="width:200px;" />
											</div>
											<br>
										</td>
									</tr>
								</tbody>
							</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="res-address">
							<fieldset>
							<table>	
								<tbody>
									<tr style="width:100%;">				
										<td style="width:50%;">
											<br>
											<div>
												<label>Location Address</label>
												<form:input id="resource_address" type="text" path="address" cssStyle="width:200px;" />
											</div>
											<br>
											<div>
												<label>City</label>
												<form:input id="resource_city" type="text" path="city" cssStyle="width:200px;" />
											</div>
											<br>
										</td>
										<td>
											<div style="width:100px;">&nbsp;</div>
										</td>
										<td>
											<br>
											<div class="select">
												<label>State</label>
												<form:select id="resource_state" path="state"
													selected="${resource.state}">
													<form:option value="--">Select option</form:option>
													<form:option value="AA">AA</form:option>
													<form:option value="AE">AE</form:option>
													<form:option value="AK">AK</form:option>
													<form:option value="AL">AL</form:option>
													<form:option value="AP">AP</form:option>
													<form:option value="AR">AR</form:option>
													<form:option value="AS">AS</form:option>
													<form:option value="AZ">AZ</form:option>
													<form:option value="CA">CA</form:option>
													<form:option value="CO">CO</form:option>
													<form:option value="CT">CT</form:option>
													<form:option value="DC">DC</form:option>
													<form:option value="DE">DE</form:option>
													<form:option value="FL">FL</form:option>
													<form:option value="FM">FM</form:option>
													<form:option value="GA">GA</form:option>
													<form:option value="GU">GU</form:option>
													<form:option value="HI">HI</form:option>
													<form:option value="IA">IA</form:option>
													<form:option value="ID">ID</form:option>
													<form:option value="IL">IL</form:option>
													<form:option value="IN">IN</form:option>
													<form:option value="KS">KS</form:option>
													<form:option value="KY">KY</form:option>
													<form:option value="LA">LA</form:option>
													<form:option value="MA">MA</form:option>
													<form:option value="MD">MD</form:option>
													<form:option value="ME">ME</form:option>
													<form:option value="MH">MH</form:option>
													<form:option value="MI">MI</form:option>
													<form:option value="MN">MN</form:option>
													<form:option value="MO">MO</form:option>
													<form:option value="MP">MP</form:option>
													<form:option value="MS">MS</form:option>
													<form:option value="MT">MT</form:option>
													<form:option value="NC">NC</form:option>
													<form:option value="ND">ND</form:option>
													<form:option value="NE">NE</form:option>
													<form:option value="NH">NH</form:option>
													<form:option value="NJ">NJ</form:option>
													<form:option value="NM">NM</form:option>
													<form:option value="NV">NV</form:option>
													<form:option value="NY">NY</form:option>
													<form:option value="OH">OH</form:option>
													<form:option value="OK">OK</form:option>
													<form:option value="OR">OR</form:option>
													<form:option value="PA">PA</form:option>
													<form:option value="PR">PR</form:option>
													<form:option value="PW">PW</form:option>
													<form:option value="RI">RI</form:option>
													<form:option value="SC">SC</form:option>
													<form:option value="SD">SD</form:option>
													<form:option value="TN">TN</form:option>
													<form:option value="TX">TX</form:option>
													<form:option value="UT">UT</form:option>
													<form:option value="VA">VA</form:option>
													<form:option value="VI">VI</form:option>
													<form:option value="VT">VT</form:option>
													<form:option value="WA">WA</form:option>
													<form:option value="WI">WI</form:option>
													<form:option value="WV">WV</form:option>
													<form:option value="WY">WY</form:option>
												</form:select>
												&nbsp;&nbsp;&nbsp;
											</div>
											<br>
											<div>
												<label>Zip Code</label>
												<form:input id="resource_zipcode" type="text" path="zipcode" cssStyle="width:100px;" />
											</div>
											<br>
										</td>
									</tr>
								</tbody>
							</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="res-map">
							<fieldset>
								<br>
								<div>
									<c:set var="addressFields" value="${resource.address}, ${resource.city}, ${resource.state}  ${resource.zipcode}" />
									<label>Address</label> <input type="text" id="addrField" value="${addressFields}" style="width: 300px" readonly="readonly" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<a href="#" onclick="initMap(); updateAddress(addrField.value); return false"><button>Show Map</button></a>
								</div>
								<br>
								<div>
									<label>Map</label>
									<div id="map_canvas" style="width: 100%; height: 500px;"></div>
								</div>
								<br>
							</fieldset>
						</div>
						<div class="tabs-content" id="res-notes">
							<fieldset>
								<br />
								<div>
									<label><fmt:message key="resource.notes.title" /></label>
									<form:textarea id="resource_notes" path="notes" rows="5" cssStyle="width:630px;" />
								</div>
								<br>
							</fieldset>

						</div>
					</div>

					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Resource" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexResource'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
