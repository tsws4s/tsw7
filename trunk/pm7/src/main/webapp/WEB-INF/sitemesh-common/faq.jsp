<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Team Sportsware</title>

</head>
<body>
				<div class="panel-wrapper fixed">
					<div class="panel">
						<div class="title">
							<h4>Testing</h4>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="content inpad">
						<!-- ## Panel Content  -->
						
							<ul class="content-gallery fixed">
								<li>
									<div><a href="images/Slide2.png" rel="gallery"></a></div>
									<img src="images/Slide2sm.png" alt="" />
								</li>
								
								<li>
									<div><a href="images/Slide3.png" rel="gallery"></a></div>
									<img src="images/Slide3sm.png" alt="" />
								</li>
								
								<li>
									<div><a href="images/Slide4.png" rel="gallery"></a></div>
									<img src="images/Slide4sm.png" alt="" />
								</li>
								
						</ul>
								
						
						<!-- ## / Panel Content  -->
						</div>
					</div>
					
					<div class="shadow"></div>
				</div>

				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
							<h4>F.A.Q. - Frequently Asked Questions
							&nbsp;&nbsp;-&nbsp;&nbsp;or Contact Us from&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/helpDesk"><button>Help Desk</button></a></h4>
							<div class="collapse">collapse</div>							
						</div>
				<div class="content inpad">

					<div id="faq-list">
						<div>
						<input class="search" type="text" placeholder="Type your question">
						</div>
							<ul class="list">
								<li><a href="#faq-st-features">1. What are the Team Sportware features?</a>
								</li>
								<li><a href="#faq-st-feature-level">2. What are the subscription levels?</a>
								</li>
								<li><a href="#faq-st-subscription">3. What are prices for levels?</a>
								</li>
								<li><a href="#faq-st-contact">4. How can you contact us?</a>
								</li>
								<li class="selected"><a href="#faq-st-problem">5. How do I get started?</a>
								</li>
							</ul>
						</div>
						<div class="hr"></div>
							<div id="faq-details">
								<h2 id="faq-st-features">
									<strong>1.</strong> What are the Team Sportware features?
									<a href="#" class="screencast-button"></a>
								</h2>
								<p>Team Sportsware provides the following features:</p>
								<p> </p>
									<p>o Dashboard - home page</p>
									<p>o Leagues - teams &amp; games (standings)</p>
									<p>o Programs - participants</p>
									<p>o Scheduling - resources &amp; games (define patterns)</p>
									<p>o Customers - manage relations</p>
									<p>o Account - account settings (Resources, Levels, Prices, Import/Export)</p>
									<p>o Support - help desk, faq</p>
									<p>o My Profile - update preferences</p>
									<p>o Login - login, register user, new account</p>
									<p>o File Uploads -</p>
								<p> </p>
							</div>

							<div id="faq-st-feature-level">
								<h2>
									<a id="faq-st-stepbystep-20"><strong>2.</strong> What features are available for subscription levels?</a> 
								</h2>
								<p> </p>
							</div>

							<div id="faq-st-subscription">
								<h2>
									<strong>3.</strong> What are the prices for subscription levels?
									<a href="#" class="screencast-button"></a>
								</h2>
								<p style="padding-left: 100px;">
									<img width="354" height="184" src="images/tswSubscrPricing.png" alt="" />
								</p>
							</div>

							<div id="faq-st-contact">
								<h2>
									<strong>4.</strong> How can I get further questions answered?
									<a href="#" class="screencast-button"></a>
								</h2>
								<p>
									You can submit a problem ticket to the 
									<a href="${pageContext.request.contextPath}/helpDesk">Help Desk</a>
									using the form under the Support menu.
								</p>
							</div>

							<div id="faq-st-problem" class="selected">
								<h2>
									<strong>5.</strong>How do I get started?
									<a href="#" class="screencast-button"></a>
								</h2>
								<div style="padding-right:25px;">
								<p><strong>Team Sportsware, Software for Sports</strong> - simplify the management of sports activities.</p>

								<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Ten (10) Easy Steps</strong> ... .</p>
				
								<p><img width="40" height="50" src="images/menu6.png" style="float:left;padding-right:10px;" />(1) Create your <strong>New Account</strong> from the 
								<strong>Login</strong> page, which includes selecting a subscription level, establishing the default Administrator's user 
								information in <strong>My Profile</strong>, and then entering the <strong>Account settings</strong>.</p>

								<p><img width="40" height="50" src="images/menu6.png" style="float:left;padding-right:10px;" />(2) You must create <strong>Resources</strong> - 
								minimum of one, then define <strong>Levels</strong> which are used to identify
								eligibility for Programs and Leagues, and set common <strong>Prices</strong> that will be charged to customers.
								You can also <strong>Import</strong> data from spreadsheets into your Account.</p>

								<p><img  width="40" height="50" src="images/menu2.png" style="float:left;padding-right:10px;" />(3) Setting up <strong>Leagues</strong> is the 
								next step where you will define the primary resource, level of play, prices charged to teams,
								Coordinator responsible for managing the league, the start &amp; end dates, and then publish as available for customers.</p> 
									 
								<p><img  width="40" height="50" src="images/menu2.png" style="float:left;padding-right:10px;" />(4) <strong>Customers</strong> can register <strong>Teams</strong> 
								 for leagues that have been published which match the level of <strong>Team Players</strong> on the team.  The <strong>Team Coach</strong> or Manager usually registers 
								 the team, and publishes for customers to join as a Team Player.</p>
								 
								<p><img  width="40" height="50" src="images/menu2.png" style="float:left;padding-right:10px;" />(5) <strong>League Coordinator</strong> can accept 
								 Teams/Players who <strong>Register online</strong>, make <strong>Payments online</strong>, and electronically sign waivers. <strong>Games</strong>
								 are generated based upon league criteria, and Referee enters game scores to update <strong>League Standings</strong>.</p>
								 
								<p><img width="40" height="50" src="images/menu3.png" style="float:left;padding-right:10px;" />(6) Setting up <strong>Programs</strong> for individuals 
								or groups is much the same process as setting up leagues,
								 and once published by the Coordinator then customers can register as <strong>Participants</strong> for any program available.</p>
								 
								<p><img width="40" height="50" src="images/menu4.png" style="float:left;padding-right:10px;" />(7) Both league games and program events 
								can be <strong>Scheduled</strong> to specific resources, either automatically
								 by defined patterns and/or Games generated, or managed individually on each resource <strong>Calendar</strong>.</p>

								<p><img width="40" height="50" src="images/menu5.png" style="float:left;padding-right:10px;" />(8) Managing <strong>Customer</strong> relations is 
								the key to any organization's success. Information can be updated directly by the customers for accuracy, and <strong>Email campaigns</strong> can 
								help to keep your customers well informed.</p>

								<p><img width="40" height="50" src="images/menu1.png" style="float:left;padding-right:10px;" />(9) Graphs and Charts on your <strong>Dashboard</strong> 
								provide a simplified view of the current status for all active Leagues and Programs. Many <strong>Reports</strong> are available online, 
								and secure "<strong>widgets</strong>" can be embedded into any website to directly link them with Team Sportsware.</p>
								
								<p><img width="40" height="50" src="images/menu7.png" style="float:left;padding-right:10px;" />(10) Help is available online through Support, 
								which contains answers to many of the <strong>Frequently Asked Questions</strong> "FAQs" or
								by submitting tickets using <strong>Help Desk</strong>. <br />We focus on great <strong>Customer Service</strong> as our top priority.</p>
								</div>
							</div>
		
						<!-- ## / Panel Content  -->
						</div>
					</div>
					
					<div class="shadow"></div>
				</div>
			<!-- .panel -->
	<script>

		loadScript('explorer/jquery/1.8/jquery.min.js', function (){
			loadScript('explorer/jquery/1.8/jquery-ui.min.js', function (){
				loadScript('explorer/js/explorer-extra.js', function (){
					loadScript('explorer/js/explorer-custom.js', function (){
				
					});
				});
			});
		});
		
		function loadScript(url, callback){
			var script = document.createElement("script");
			script.type = "text/javascript";

			if (script.readyState){ //IE
				script.onreadystatechange = function(){
					if (script.readyState == "loaded" || script.readyState == "complete"){
						script.onreadystatechange = null;
						callback();
					}
				};
			} else { //Others
				script.onload = function(){
					callback();
				};
			}

			script.src = url;
			document.getElementsByTagName("head")[0].appendChild(script);
		}
	
	</script>	

</body>

</html>
