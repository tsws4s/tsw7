<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.users-resources" />
<html>
<head>
<title>Edit Profile</title>
</head>
<body>
	<div class="formular">
		<div class="panel">

			<form:form action="${pageContext.request.contextPath}/saveUsers" method="POST" modelAttribute="users" name="parentform">

				<div class="title-large">

					<c:choose>
						<c:when test='${newFlag}'>
							<h2>
								<fmt:message key="navigation.new" />
								<fmt:message key="users.title" />
							</h2>
						</c:when>
						<c:otherwise>
							<h2>
								<fmt:message key="navigation.edit" />
								Profile (${users.userId}) <strong>${users.customer.firstname}&nbsp;${users.customer.lastname}</strong>
							</h2>
							<form:hidden id="users_userId" path="userId" />
						</c:otherwise>
					</c:choose>

					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content inpad">

					<fieldset>
							<table>	
								<tbody>
									<tr style="width:100%;">				
										<td style="width:50%;">
											<br>
											<div>
												<label><fmt:message key="users.username.title" /> *</label>
												<form:input id="users_username" path="username" cssStyle="width:200px;" />
											</div>
											<br>
											<div>
												<label><fmt:message key="users.password.title" /> *</label>
												<form:password id="users_password" path="password" cssStyle="width:200px;" />
											</div>
											<br>
											<div>
												<label>User Customer *</label>
												<c:if test='${users.customer == null}'>
													<input id="users_customer" type="text" name="custName4" value="" readonly="readonly" style="width: 180px;" />
													&nbsp;&nbsp;&nbsp;&nbsp;
													<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
														<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
													<input type="hidden" id="itemSelected4" name="selected_id4" value="" style="width: 20px;">
												</c:if>
												<c:if test='${users.customer != null}'>
													<input id="users_customer" type="text" name="custName4" value="${users.customer.firstname}&nbsp;${users.customer.lastname}" readonly="readonly" style="width: 180px;" />
													&nbsp;&nbsp;
													<a class="button-clean" href="/" onclick="window.showModalDialog('${pageContext.request.contextPath}/searchCustomers', 'myWin','dialogWidth:770px;dialogHeight:520px;help:no;border:thin;status:no;toolbar=no;menubar=no'); return false">
														<span><img class="icon" src="explorer/images/icons/icon-view.png" alt="Search" /></span></a>
													<input type="hidden" id="itemSelected4" name="selected_id4" value="${users.customer.customerId}" style="width: 20px;">
												</c:if>
												&nbsp;
											</div>
											<br>
											</td>
											<td>
												<div style="width:80px;">&nbsp;</div>
											</td>
											<td>
											<br>
											<div>
												<label>Results per Page</label>
												<form:select id="users_resultsPerPage" path="resultsPerPage" selected="${users.resultsPerPage}">
													<form:option value="10">10</form:option>
													<form:option value="5">5</form:option>
													<form:option value="20">20</form:option>
												</form:select>
												&nbsp;
											</div>
											<br>
											<div>
												<label>Theme</label>
												<form:select id="users_selectTheme" path="selectTheme" selected="${users.selectTheme}">
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
												<form:checkbox id="users_activeYn" path="activeYn" value="1" />
											</div>
											<br>
										</td>
									</tr>
								</tbody>
							</table>
					</fieldset>
				</div>

				<!-- ## / Panel Content  -->

				<div class="button-bar">
					<input class="button-clean submit" id="save" type="submit" value="Save Account" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="reset" name="reset" value="Reset" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexUsers'" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
				</div>
			</form:form>

		</div>
	</div>
</body>
</html>
