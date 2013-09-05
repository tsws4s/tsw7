<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.application-resources" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html dir="ltr" xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<title>Team Sportsware</title>

<link href="explorer/css/style-explorer.css" rel="stylesheet" type="text/css" />
<link href="explorer/css/style-calendar.css" rel="stylesheet" type="text/css" />
<link href="explorer/css/style-custom.css" rel="stylesheet" type="text/css" />

<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="explorer/css/style-ie.css" /> 
	<![endif]-->

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />


<link href='http://fonts.googleapis.com/css?family=Droid+Sans:regular,bold' rel='stylesheet' type='text/css' />
<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css' />


<!--[if IE]><script type="text/javascript" src="explorer/js/excanvas.compiled.js"></script><![endif]-->

<script type='text/javascript' src='explorer/js/explorer-custom.js'></script>
<script type='text/javascript' src='explorer/js/explorer-extra.js'></script>

<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.gif" />

</head>

<body>

	<div id="content">
		<div class="formular">
			<div class="panel">
				<div class="title-large">
					<h2>Contact Us</h2>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>

				<div class="content inpad">

					<fieldset>
						<table>
							<tbody>
								<tr style="width: 100%;">
									<td style="width: 50%;">
									<br />
										<div>
											<label>From Name</label> 
											<input id="from_name" type="text" style="width: 200px;" />
										</div> 
										<br />
										</td>
									<td>
										<div style="width: 40px;">&nbsp;</div></td>
									<td>
									<br />
										<div>
											<label>Email</label> 
											<input id="from_email" type="text" style="width: 300px;" />
										</div> 
										<br />
									</td>
								</tr>
							</tbody>
						</table>
						<div>
							<label>Subject</label> 
							<input id="from_subject" type="text" style="width: 300px;" />
						</div>
						<br />
						<div>
							<label>Message</label>
							<textarea id="contact_notes" rows="5" style="width: 620px;" cols=""></textarea>
						</div>
					</fieldset>
				</div>

				<div class="button-bar">
					<a href="${pageContext.request.contextPath}/sendMessage"><button>Send Message</button>
					</a>
				</div>
			</div>
		</div>
	</div>
	<div id="style-background"></div>
	<div id="style-shadow"></div>

	<script type="">

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