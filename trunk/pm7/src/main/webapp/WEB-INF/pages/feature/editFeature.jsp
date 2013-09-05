<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.feature-resources"/>
<html>
<head>
<title>Edit <fmt:message key="feature.title"/></title>
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

</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveFeature" method="POST" modelAttribute="feature" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="feature.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="feature.title"/> - ${feature.featureId}
								<form:hidden id="feature_featureId" path="featureId"/>
								</c:otherwise>
							</c:choose>
								</a></li>
							</ul>
							<div class="collapse">collapse</div>
						</div>
						
						<div class="tabs-content">
						<!-- ## Panel Content  -->
	<div id="tab-01-content" class="active">	

<div class="group fixed">
	<label>
		<fmt:message key="feature.featurecode.title"/>:
	</label> 
								${feature.featureCode}&nbsp;
								<form:hidden id="feature_featurecode" path="featureCode" />
						</div>
<div class="group fixed">
	<label>
		* <fmt:message key="feature.featurename.title"/>:
	</label> 

							<form:input id="feature_featureName" path="featureName" cssStyle="width:200px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "feature_featureName",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="feature.featurename.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="feature.featurepriority.title"/>:
	</label> 

							<form:select id="feature_featurePriority" path="featurePriority" selected="${requirement.reqmtPriority}">							
								<form:option value="--">Select option</form:option>
								<form:option value="Normal">Normal</form:option>
								<form:option value="High">High</form:option>
								<form:option value="Low">Low</form:option>
							</form:select>													
							&nbsp;&nbsp;&nbsp;
						</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Feature"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexFeature">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

	<!--   Requirements   -->
				<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Manage <fmt:message key="requirement.title"/>s</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="requirement.status.title"/></th>
					<th><fmt:message key="requirement.reqmtpriority.title"/></th>
					<th><fmt:message key="requirement.reqmtcode.title"/></th>
					<th><fmt:message key="requirement.reqmtname.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${feature.requirements}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editFeatureRequirements?feature_featureId=${feature.featureId}&requirements_reqmtId=${current.reqmtId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteFeatureRequirements?feature_featureId=${feature.featureId}&related_requirements_reqmtId=${current.reqmtId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.status}
						&nbsp;
					</td>
					<td>
						
							${current.reqmtPriority}
						&nbsp;
					</td>
					<td>
						
							${current.reqmtCode}
						&nbsp;
					</td>
					<td>
						
							${current.reqmtName}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newFeatureRequirements?feature_featureId=${feature.featureId}">New Requirement <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>	

				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>		
		
	<!--   Changes   -->
					<div class="panel-wrapper">
					<div class="panel">
						<div class="title">
						<h4><img src="css/images/icons/icon-users.png" alt=""> 
						&nbsp;&nbsp;Manage <fmt:message key="changerequest.title"/>s</h4>
							<div class="collapse">collapse</div>
						</div>
						<div class="content">
						<!-- ## Panel Content  -->

			<table id="listTable" class="sortable resizable"> 
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th><fmt:message key="changerequest.status.title"/></th>
					<th><fmt:message key="changerequest.changepriority.title"/></th>
					<th><fmt:message key="changerequest.changecode.title"/></th>
					<th><fmt:message key="changerequest.changename.title"/></th>
				</tr>
			</thead>
			<tbody>
				<c:set var="totalCount" value="0"/>
				<c:forEach items="${feature.changerequests}" var="current" varStatus="i">
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
				<a class="icon" href="${pageContext.request.contextPath}/editFeatureChangerequests?feature_featureId=${feature.featureId}&changerequests_changeId=${current.changeId}&"><img src="css/images/icons/icon-edit.png" alt="Edit"></a>
				<a class="icon" href="${pageContext.request.contextPath}/confirmDeleteFeatureChangerequests?feature_featureId=${feature.featureId}&related_changerequests_changeId=${current.changeId}&"><img src="css/images/icons/icon-delete.png" alt="Delete"></a>
				</td>

					<td>
						
							${current.status}
						&nbsp;
					</td>
					<td>
						
							${current.changePriority}
						&nbsp;
					</td>
					<td>
						
							${current.changeCode}
						&nbsp;
					</td>
					<td>
						
							${current.changeName}
						&nbsp;
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

	<div style="padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
		<span style="padding-left:20px;">			
			<a class="button-blue" href="${pageContext.request.contextPath}/newFeatureChangerequests?feature_featureId=${feature.featureId}">New Changerequest <img src="css/images/icons/icon-menu-tasks.png" alt=""></a>
		</span>						

				</div>
			</div>
		</div>
		<div class="shadow"></div>
	</div>
	
</body>
</html>