<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.releaseplan-resources"/>
<html>
<head>
<title>Edit <fmt:message key="releaseplan.title"/></title>
<script>
function validateForm()
{
    if(document.parentform.program_programName.value=="")
    {
      alert("Name should not be left blank");
      document.parentform.program_programName.focus();
      return false;
    }
    else if(document.parentform.program_startDate.value=="")
    {
      alert("Start Date should not be left blank");
      document.parentform.program_startDate.focus();
      return false;
    }
    else if(document.parentform.program_gamesPerTeam.value=="")
    {
      alert("Number Sessions/Games should not be left blank");
      document.parentform.program_gamesPerTeam.focus();
      return false;
    }
    else if(document.parentform.program_sport.value=="")
    {
      alert("Sport should not be left blank");
      document.parentform.program_sport.focus();
      return false;
    }
} 
</script>
 <script>
$(function() {
	$( ".datepicker" ).datepicker({
		showOn: "button",
		buttonImage: "css/images/icons/icon-calendar.png",
		buttonImageOnly: true,
		showButtonPanel: true,
		changeMonth: true,
		changeYear: true
	});
});
</script>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveReleaseplan" method="POST" modelAttribute="releaseplan" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="releaseplan.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="releaseplan.title"/> - ${releaseplan.releaseId}
								<form:hidden id="releaseplan_releaseId" path="releaseId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							<li><a href="#" rel="tab-02-content">Description</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasecode.title"/>:
	</label> 
		${releaseplan.releaseCode}&nbsp;
		<form:hidden id="releaseplan_releaseCode" path="releaseCode" />
</div>
<div class="group fixed">
	<label>
		* <fmt:message key="releaseplan.releasename.title"/>:
	</label> 
		<form:input id="releaseplan_releaseName" path="releaseName" cssStyle="width:300px;"/>
		<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "releaseplan_releaseName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="releaseplan.releasename.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasedate.title"/>:
	</label> 

							<input class="datepicker" id="releaseplan_releaseDate" name="releaseDate" type="text" value="<fmt:formatDate value="${releaseplan.releaseDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:80px;" />
</div>
</div>
<div id="tab-02-content">
<div class="group fixed">
	<label>
		<fmt:message key="releaseplan.releasedescription.title"/>:
	</label> 

							<form:textarea id="releaseplan_releaseDescription" path="releaseDescription" cssStyle="width:500px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "releaseplan_releaseDescription",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="releaseplan.releasedescription.help"/>"}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Releaseplan"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexReleaseplan">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

	<!--   Features   -->

	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
					&nbsp;&nbsp;Features</h4>
			</div>
			<div class="content">
				<!-- ## Panel Content  -->
			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="feature.featureid.title"/></th>
					<th><fmt:message key="feature.featurecode.title"/></th>
					<th><fmt:message key="feature.featurename.title"/></th>
					<th><fmt:message key="feature.featurepriority.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${releaseplan.features}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editReleaseplanFeatures?releaseplan_releaseId=${releaseplan.releaseId}&featureIdKey=${current.featureId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteReleaseplanFeatures?releaseplan_releaseId=${releaseplan.releaseId}&featureIdKey=${current.featureId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.featureId}
						&nbsp;
					</td>
					<td>
						
							${current.featureCode}
						&nbsp;
					</td>
					<td>
						
							${current.featureName}
						&nbsp;
					</td>
					<td>
						
							${current.featurePriority}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table></div>
	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newReleaseplanFeatures?releaseplan_releaseId=${releaseplan.releaseId}&">New Feature <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
			</div>
		</div>
		<div class="shadow"></div>
	</div>	
	
	<!--   Defects   -->

	<div class="panel-wrapper fixed">
		<div class="panel">
			<div class="title">
				<h4><img src="simple/images/icons/icon-users.png" alt="">
						&nbsp;&nbsp;<fmt:message key="defect.title"/>s</h4>
			</div>
			<div class="content">
				<!-- ## Panel Content  -->
			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="defect.defectid.title"/></th>
					<th><fmt:message key="defect.status.title"/></th>
					<th><fmt:message key="defect.defectpriority.title"/></th>
					<th><fmt:message key="defect.defectname.title"/></th>
					<th><fmt:message key="defect.defectdescriptin.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${releaseplan.defects}" var="current" varStatus="i">
					<c:set var="totalCount" value="${totalCount+1}"/>
					<c:choose>
						<c:when test="${(i.count) % 2 == 0}">
		    				<c:set var="rowclass" value="rowtwo"/>
						</c:when>
						<c:otherwise>
		    				<c:set var="rowclass" value="rowone"/>
						</c:otherwise>
					</c:choose>	
				<tr class="${rowclass}">
				<td width="80px" class="center">
				<a class="icon" href="${pageContext.request.contextPath}/editReleaseplanDefect?releaseplan_releaseId=${releaseplan.releaseId}&defectIdKey=${current.defectId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteReleaseplanDefect?releaseplan_releaseId=${releaseplan.releaseId}&defectIdKey=${current.defectId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.defectId}
						&nbsp;
					</td>
					<td>
						
							${current.status}
						&nbsp;
					</td>
					<td>
						
							${current.defectPriority}
						&nbsp;
					</td>
					<td>
						
							${current.defectName}
						&nbsp;
					</td>
					<td>
						
							${current.defectDescriptin}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table></div>

	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newReleaseplanDefect?releaseplan_releaseId=${releaseplan.releaseId}&">New Defect <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	
			</div>
		</div>
		<div class="shadow"></div>
	</div>				
</body>
</html>