<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Scheduling</title>
<!-- Calendar  resourceId, afterDate, beforeDate -->
<script type='text/javascript' src='simple/scripts/jquery.fullcalendar/fullcalendar.js'></script>
<script>
function refreshCalendar(data)
{
//	alert("refresh window with calendar for new resource = "+data);
	window.open('${pageContext.request.contextPath}/scheduling?resource_resourceId='+data+'&afterDate=&beforeDate=','_self',false); 
	return false;
}
</script>
</head>

<body>
			<div class="section">
				<div class="tiny">

					<div class="panel">
						<div class="title">
							<h4>Events for Date</h4>
							<div class="theme"></div>
							<div class="drop"></div>
						</div>
						<div class="content clearfix">

							<div class="popup-calendar-hours">

								<div class="content">

									<div id="scrolable_content">

										<div class="customScrollBox">
											<div class="container">
												<div class="content">

													<ul class="calendar-events">
														<li><strong>8<span>00</span>
														</strong>
														</li>
														<li><strong>8<span>30</span>
														</strong> <span>Get more tomatos</span> <a href="#"></a></li>
														<li><strong>9<span>00</span>
														</strong></li>
														<li><strong>9<span>30</span>
														</strong>
														</li>
														<li><strong>10<span>00</span>
														</strong>
														</li>
														<li><strong>10<span>30</span>
														</strong>
														</li>
														<li><strong>11<span>00</span>
														</strong> <span>Meet with Joe at mall</span> <a href="#"></a></li>
														<li><strong>11<span>30</span>
														</strong>
														</li>
														<li><strong>12<span>00</span>
														</strong>
														</li>
														<li><strong>12<span>30</span>
														</strong>
														</li>
														<li><strong>13<span>00</span>
														</strong>
														</li>
														<li><strong>13<span>30</span>
														</strong>
														</li>
														<li><strong>14<span>00</span>
														</strong>
														</li>
														<li><strong>14<span>30</span>
														</strong>
														</li>
														<li><strong>15<span>00</span>
														</strong> <span>Doctor apointment</span> <a href="#"></a></li>
														<li><strong>15<span>30</span>
														</strong>
														</li>
														<li><strong>16<span>00</span>
														</strong>
														</li>
														<li><strong>16<span>30</span>
														</strong>
														</li>
														<li><strong>17<span>00</span>
														</strong>
														</li>
														<li><strong>17<span>30</span>
														</strong>
														</li>
														<li><strong>18<span>00</span>
														</strong>
														</li>
														<li><strong>18<span>30</span>
														</strong>
														</li>
														<li><strong>19<span>00</span>
														</strong>
														</li>
														<li><strong>19<span>30</span>
														</strong>
														</li>
														<li><strong>20<span>00</span>
														</strong>
														</li>
														<li><strong>20<span>30</span>
														</strong>
														</li>
														<li><strong>21<span>00</span>
														</strong> <span>Finish newsletter design</span> <a href="#"></a></li>
														<li><strong>21<span>30</span>
														</strong>
														</li>
														<li><strong>22<span>00</span>
														</strong>
														</li>
														<li><strong>22<span>30</span>
														</strong>
														</li>
														<li><strong>23<span>00</span>
														</strong>
														</li>
														<li><strong>23<span>30</span>
														</strong>
														</li>
														<li><strong>24<span>00</span>
														</strong>
														</li>
													</ul>
												</div>
												<a class="scrollUpBtn" href="#" style="display: inline-block;"></a> 
												<a class="scrollDownBtn" href="#" style="display: inline-block;"></a>
											</div>
											<div class="dragger_container">
												<div class="dragger"></div>
											</div>
										</div>
									</div>


								</div>
							</div>



						</div>
					</div>
				</div>

				<div class="tiny x3">
					<div class="panel">
						<div class="title-large">
							<h2>Resource Calendar for Scheduling</h2>
							<span style="text-align:right;padding: 10px 30px 5px 100px;font-size: 12px;color:#ffffff;">
							<a href="${pageContext.request.contextPath}/indexEventFrom?resource_resourceId=${res.resourceId}&afterDate=&indexFrom=-1"><button>Event Listing</button></a></span>
							<div class="theme"></div>
							<div class="drop"></div>
						</div>
						<div class="content clearfix">

							<div class="calendar-nav clearfix">
								<h1>*</h1>
								<a href="#" class="next">Next month</a> <a href="#" class="back">Prev month</a>
							</div>

							<div class="calendar-stats clearfix">
								<div>
									<h4>
									<input type="radio" name="calFor" id="calFor1" value="Resource" checked="checked" />	
									<label for="calFor1">Resource:</label>									
									<select id="forResource" name="resource" onchange="javascript:refreshCalendar(this.value);return false;">
									<option value="">Select resource</option>
										<c:forEach items="${resources}" var="current" varStatus="i">
										<c:choose>
										<c:when test="${res!=null && current.resourceId eq res.resourceId}">
											<option value="${current.resourceId}" selected="selected">${current.resourceName}</option>
										</c:when>
										<c:otherwise>
											<option value="${current.resourceId}">${current.resourceName}</option>
										</c:otherwise>									
										</c:choose>
										</c:forEach>
									</select>										

										&nbsp;&nbsp;
									<input type="radio" name="calFor" id="calFor2" value="Games" disabled="disabled" />
									<label for="calFor2">Games for: </label>
										<select id="forLeague" name="league" disabled="disabled">
											<option value="--">Select League</option>
											<option value="Hockey 3on3">Hockey 3on3</option>
											<option value="Cricket">Cricket</option>
										</select>	</h4>								
								</div>
								<div class="item">
									<input type="radio" name="calType" id="calType1" value="Monthly" checked="checked" />
									<label for="calType1">Monthly</label>
									<input type="radio" name="calType" id="calType2" value="Weekly" disabled="disabled" />
									<label for="calType2">Weekly</label>
								</div>								
							</div>

							<div class="calendar-body" id="calendar-events-rnd"></div>

						</div>
					</div>

				</div>

			</div>

	<!--  #container  -->
</body>

</html>
