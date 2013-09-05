<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<html>
<head>

<title>Dashboard</title>

</head>
<body>
<div class="section">
	<div class="full">
	
		<div class="panel charts">
			<div class="title-large">
				<h2>Account Overview Charts</h2>
				<div class="theme"></div>
				<div class="drop"></div>
			</div>
				
			<div class="content">
				<div class="toolbar clearfix">
					<span>View: &nbsp;</span>
					<a href="#" class="view-button view-chart-bar selected" rel="view-chart-bar"></a>
					<a href="#" class="view-button view-chart-pie" rel="view-chart-pie"></a>
					<a href="#" class="view-button view-chart-area" rel="view-chart-area"></a>
					<a href="#" class="view-button view-chart-line" rel="view-chart-line"></a>
				</div>
				
				<div class="view-content selected" id="view-chart-bar">
					<div id="fullpan-exp-bar-chart"></div>
				</div>
				
				<div class="view-content" id="view-chart-pie">
					<div id="fullpan-exp-pie-chart"></div>
				</div>
				
				<div class="view-content" id="view-chart-area">
					<div id="fullpan-exp-area-chart"></div>
				</div>
				
				<div class="view-content" id="view-chart-line">
					<div id="fullpan-exp-line-chart"></div>
				</div>
			</div>
		</div>	
	</div>

</div>

<table class="chartData" style="display:none;">
	<caption>Leagues and Programs</caption>
	<thead>
		<tr>
			<td></td>
			<th scope="col">totals</th>
			<th scope="col">paid</th>
		</tr>
	</thead>	
		
	<tbody>
		<c:forEach items="${programs}" var="current" varStatus="i">
		<tr>
			<th scope="row">${current.programName}</th>
			<fmt:setLocale value="en_US"/>
			<fmt:formatNumber var="fmtTotal" value="${current.price.priceField * current.totalParticipants}" pattern="#####0.00;" />			
			<td>${fmtTotal}</td>
			<fmt:formatNumber var="fmtPaid" value="${current.totalPaid}" pattern="####0.00;" />
			<td>${fmtPaid}</td>
		</tr>						
		</c:forEach>
	</tbody>
</table>
	<script>
		loadScript('explorer/jquery/1.5/jquery.min.js', function() {
			loadScript('explorer/jquery/1.8/jquery-ui.min.js', function() {
				loadScript('explorer/js/explorer-extra.js', function() {
					loadScript('explorer/js/explorer-custom.js', function() {
						loadScript('explorer/js/jquery.validate.js',
								function() {
								});
					});
				});
			});
		});
		function loadScript(url, callback) {
			var script = document.createElement("script");
			script.type = "text/javascript";
			if (script.readyState) { //IE
				script.onreadystatechange = function() {
					if (script.readyState == "loaded"
							|| script.readyState == "complete") {
						script.onreadystatechange = null;
						callback();
					}
				};
			} else { //Others
				script.onload = function() {
					callback();
				};
			}
			script.src = url;
			document.getElementsByTagName("head")[0].appendChild(script);
		}
	</script>
</body>
</html>
	