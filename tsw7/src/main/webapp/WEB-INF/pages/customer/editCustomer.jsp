<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.customer-resources" />
<html>
<head>
<title>Edit <fmt:message key="customer.title" />
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
    if(document.parentform.customer_firstname.value=="")
    {
      alert("First Name should not be left blank");
      document.parentform.customer_firstname.focus();
      return false;
    }
     else if(document.parentform.customer_lastname.value=="")
    {
      alert("Last Name should not be left blank");
      document.parentform.customer_lastname.focus();
      return false;
    }
    else if(document.parentform.customer_email.value=="")
    {
      alert("Email should not be left blank");
      document.parentform.customer_email.focus();
      return false;
    }
    else if(document.parentform.customer_password.value=="")
    {
      alert("Password should not be left blank");
      document.parentform.customer_password.focus();
      return false;
    }
} 
</script>
</head>
<body>
	<div id="content">
		<div class="formular">
			<div class="panel">
				<form:form action="${pageContext.request.contextPath}/saveCustomer" method="POST" modelAttribute="customer" name="parentform" onSubmit="return validateForm();">

					<div class="title-large">
						<c:choose>
							<c:when test='${newFlag}'>
								<h2>
									<fmt:message key="navigation.new" />
									<fmt:message key="customer.title" />
								</h2>
							</c:when>
							<c:otherwise>
								<h2>
									<fmt:message key="navigation.edit" /> <fmt:message key="customer.title" />
									(${customer.customerId})<strong> ${customer.firstname} ${customer.lastname}</strong>
								</h2>
								<form:hidden id="customer_customerId" path="customerId" />
							</c:otherwise>
						</c:choose>

						<ul class="tabs-box clearfix">
							<li class="selected"><a href="#" rel="cust-main">Customer</a>
							</li>
							<li><a href="#" rel="cust-address">Address</a>
							</li>
							<li><a href="#" rel="cust-map">Map</a>
							</li>
							<li><a href="#" rel="cust-user">User Info</a>
							</li>
						</ul>
						<div class="theme"></div>
						<div class="drop"></div>
					</div>
					<div class="content inpad">
						<div class="tabs-content selected" id="cust-main">
					<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">				
								<td style="width:50%;">
									<br>
									<div>
										<label><fmt:message key="customer.firstname.title" /> *</label>
										<form:input id="customer_firstname" name="customer_firstname" path="firstname" autofocus="autofocus" cssStyle="width:200px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="customer.lastname.title" /> *</label>
										<form:input id="customer_lastname" path="lastname" cssStyle="width:200px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="customer.email.title" /> *</label>
										<form:input id="customer_email" path="email" placeholder="name@example.com" cssStyle="width:240px;" />
									</div>
									<br>
								</td>
								<td>
									<div style="width:50px;">&nbsp;</div>
								</td>
								<td>
									<br>
									<div>
										<label><fmt:message key="customer.phone.title" /></label>
										<form:input id="customer_phone" path="phone" cssStyle="width:200px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="customer.yearborn.title" /></label>
										<form:input id="customer_yearBorn" path="yearBorn" cssStyle="width:100px;" />
									</div>
									<br>
									<div>
										<label>Family / Parent:</label> <input type="hidden" id="selected_id4" name="selected_id4" style="width: 20px;">
										<c:if test='${customer.customer == null}'>
										<input id="customer_family" type="text" name="custName4" value="" readonly="readonly" style="width: 180px;" />
											
										<a class="button-clean" rel="lightbox" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin2','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
										<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										</c:if>
										<c:if test='${customer.customer != null}'>
										<input id="customer_family" type="text" name="custName4" value="${customer.customer.firstname}&nbsp;${customer.customer.lastname}" readonly="readonly" style="width: 180px;" />
											
										<a class="button-clean" rel="lightbox" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin2','dialogWidth:770px;dialogHeight:620px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
										<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
										</c:if>
									</div>
									<br>
								</td>
							</tr>
						</tbody>
					</table>											
					</fieldset>
						</div>
						<div class="tabs-content" id="cust-address">
							<fieldset>
					<table>	
						<tbody>
							<tr style="width:100%;">				
								<td style="width:50%;">
									<br>
									<div>
										<c:if test="${customer.customer != null}">
										<div>
											<c:set var="clickjs" value="document.parentform.address.value = '${customer.customer.address}'; document.parentform.city.value = '${customer.customer.city}'; document.parentform.state.value = '${customer.customer.state}'; document.parentform.zipcode.value = '${customer.customer.zipcode}'" />
											<label>Copy Family Address?</label>
											<form:checkbox id="customer_addrSameAsFamily" path="addrSameAsFamily" value="0" onclick="${clickjs}; return false;" />
										</div>
										</c:if>
									</div>
									<br>
									<div>
										<label><fmt:message key="customer.address.title" /></label>
										<form:input id="customer_address" path="address" cssStyle="width:200px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="customer.city.title" /></label>
										<form:input id="customer_city" path="city" cssStyle="width:200px;" />
									</div>
									<br>
								</td>
								<td>
									<div style="width:70px;">&nbsp;</div>
								</td>
								<td>
									<br>
									<div class="select">
										<label><fmt:message key="customer.state.title" /></label>
										<form:select id="customer_state" path="state"
											selected="${customer.state}">
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
										<label><fmt:message key="customer.zipcode.title" /></label>
										<form:input id="customer_zipcode" path="zipcode" cssStyle="width:100px;" />
									</div>
									<br>
									<div>
										<label><fmt:message key="tswacct.acctname.title" />:&nbsp;&nbsp;</label>
										<input id="customer_tswacct" type="text" name="acctName" value="${customer.tswacct.acctName}" readonly="readonly" style="width: 180px;" />
									</div>
									<br>
								</td>
							</tr>
						</tbody>
					</table>
							</fieldset>
						</div>
						<div class="tabs-content" id="cust-map">
							<fieldset>
								<br>
								<div>
									<c:set var="addressFields" value="${customer.address}, ${customer.city}, ${customer.state}  ${customer.zipcode}" />
									<label>Address</label> 
									<input type="text" id="addrField" value="${addressFields}" style="width: 300px" readonly="readonly" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<a class="button-blue" href="#" onclick="initMap(); updateAddress(addrField.value); return false"><button>Show Map</button></a>
								</div>
								<br>
								<div>
									<label>Map</label>
									<div id="map_canvas" style="width: 100%; height: 500px;"></div>
								</div>
							</fieldset>
						</div>
						<div class="tabs-content" id="cust-user">
							<fieldset>
								
								<br>
											<div>
												<label>Theme</label>
												<form:select id="customer_selectTheme" path="selectTheme" selected="${customer.selectTheme}">
													<form:option value="Blue">Blue</form:option>
													<form:option value="Green">Green</form:option>
													<form:option value="Black">Black</form:option>
													<form:option value="Orange">Orange</form:option>
												</form:select>
												&nbsp;
											</div>
											<br>
											<div>
												<label><fmt:message key="users.activeyn.title" /></label>
												<form:checkbox id="customer_activeYn" path="activeYn" value="1" />
											</div>
									<br>
									<div>
										<label>Password</label>
										<form:input id="customer_password" type="password" path="password" cssStyle="width:100px;" />
										<span style="color: grey;">Enter password and Save, or click here </span>
										<input class="button-clean" type="button" name="reset" value="Reset Password" 
										onclick="window.showModalDialog('${pageContext.request.contextPath}/resetPasswordRequest?emailAddr=${customer.email}', 'myWin2','dialogWidth:990px;dialogHeight:680px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false;" />
										<span style="color: grey;"> to send email to customer for password reset.</span>
									</div>
									<br>

							</fieldset>
						</div>
					</div>

					<!-- ## / Panel Content  -->

					<div class="button-bar">
						<input class="button-clean submit" id="save" type="submit" value="Save Customer" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="reset" name="reset" value="Reset" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexCustomer'" />
						<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/user.png" /></span>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test='${showFamily}'>
			<div class="panel">
				<div class="title">
					<h4>Family Members</h4>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content">

					<table class="tabularData">

						<thead>
							<tr>
								<th>&nbsp;</th>
								<th><fmt:message key="customer.firstname.title" />
								</th>
								<th><fmt:message key="customer.lastname.title" />
								</th>
								<th class="text-center"><fmt:message key="customer.phone.title" />
								</th>
								<th><fmt:message key="customer.email.title" />
								</th>
								<th class="text-center"><fmt:message key="customer.yearborn.title" />
								</th>
								<th><fmt:message key="customer.city.title" />
								</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>&nbsp;</th>
								<th><fmt:message key="customer.firstname.title" />
								</th>
								<th><fmt:message key="customer.lastname.title" />
								</th>
								<th class="text-center"><fmt:message key="customer.phone.title" />
								</th>
								<th><fmt:message key="customer.email.title" />
								</th>
								<th class="text-center"><fmt:message key="customer.yearborn.title" />
								</th>
								<th><fmt:message key="customer.city.title" />
								</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${customer.customers}" var="current" varStatus="i">
								<c:choose>
									<c:when test="${(i.count) % 2 == 0}">
										<c:set var="rowclass" value="rowtwo" />
									</c:when>
									<c:otherwise>
										<c:set var="rowclass" value="rowone" />
									</c:otherwise>
								</c:choose>

								<tr class="${rowclass}">
									<td width="50px" class="text-center">
									<a href="${pageContext.request.contextPath}/confirmDeleteCustomerCustomers?customer_customerId=${customer.customerId}&amp;related_customers_customerId=${current.customerId}&amp;">
										<img src="explorer/images/icons/icon-delete.png" alt="Delete"></a></td>
									<td>${current.firstname}&nbsp;</td>
									<td>${current.lastname}&nbsp;</td>
									<td class="text-center">${current.phone}&nbsp;</td>
									<td>${current.email}&nbsp;</td>
									<td class="text-center">${current.yearBorn}&nbsp;</td>
									<td>${current.city}&nbsp;</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
</body>
</html>