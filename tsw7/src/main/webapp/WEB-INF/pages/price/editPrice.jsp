<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.price-resources" />
<html>
<head>
<title>Edit <fmt:message key="price.title" />
</title>
<script>
function validateForm()
{
    if(document.priceForm.price_priceCategory.value=="")
    {
      alert("Category should not be left blank");
      document.priceForm.price_priceCategory.focus();
      return false;
    }
    else if(document.priceForm.price_priceField.value=="")
    {
      alert("Price should not be left blank");
      document.priceForm.price_priceField.focus();
      return false;
    }
}
</script>
</head>
<body>

	<div class="formular">
		<div class="panel">
			<form:form action="${pageContext.request.contextPath}/savePrice" method="POST" modelAttribute="price" name="priceForm" onSubmit="return validateForm();">
				<div class="title-large">
					<c:choose>
						<c:when test='${newFlag}'>
							<h2>
								<fmt:message key="navigation.new" /> <fmt:message key="price.title" />
							</h2>
						</c:when>
						<c:otherwise>
							<h2>
								<fmt:message key="navigation.edit" /> <fmt:message key="price.title" />
								(${price.priceId}) <strong>${price.priceCategory}</strong>
							</h2>
							<form:hidden id="price_priceId" path="priceId" />
						</c:otherwise>
					</c:choose>
					<ul class="tabs-box clearfix">
						<li class="selected"><a href="#" rel="price-main">Price</a>
						</li>
						<li><a href="#" rel="price-desc">Description</a>
						</li>
					</ul>
					<div class="theme"></div>
					<div class="drop"></div>
				</div>
				<div class="content inpad">
					<div class="tabs-content selected" id="price-main">
					<fieldset>
						<br />
						<div>
							<label><fmt:message key="price.pricecategory.title" /> *</label>
							<form:select id="price_priceCategory" path="priceCategory"
								autofocus="autofocus" selected="${price.priceCategory}">
								<form:option value="">Select option</form:option>
								<form:option value="Daytime">Daytime</form:option>
								<form:option value="Evening">Evening</form:option>
								<form:option value="Night">Night</form:option>
								<form:option value="Weekend">Weekend</form:option>
								<form:option value="Individual">Individual</form:option>
								<form:option value="Team">Team</form:option>
							</form:select>
							&nbsp;&nbsp;&nbsp;
						</div>
						<br>
						<div>
							<label><fmt:message key="price.pricefield.title" /> *</label>
							$<form:input id="price_priceField" path="priceField" cssStyle="width:80px;" />
						</div>
						<br>
						<div>
							<label><fmt:message key="price.pricecolor.title" /></label>
							<form:select id="price_priceColor" path="priceColor"
								selected="${price.priceColor}">
								<form:option value="">Select option</form:option>
								<form:option value="Green">Green</form:option>
								<form:option value="Tan">Tan</form:option>
								<form:option value="Yellow">Yellow</form:option>
								<form:option value="Blue">Blue</form:option>
							</form:select>
							&nbsp;&nbsp;&nbsp;
						</div>
						<br />
							</fieldset>
						</div>
						<div class="tabs-content" id="price-desc">
							<fieldset>
								<br>
						<div>
							<label><fmt:message key="price.description.title" /></label>
							<form:textarea id="price_description" path="description" rows="5" cssStyle="width:650px;" />
						</div>
						<br />
					</fieldset>
					</div>
				</div>
				<div class="button-bar">
					<input class="button-clean submit" id="save" type="submit" value="Save Price" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="reset" name="reset" value="Reset" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="button-clean" type="button" name="cancel" value="Cancel" onclick="location.href='${pageContext.request.contextPath}/indexPrice'" />
					<span style="float:right;padding-right:20px;"><img alt="tools" src="explorer/images/icons/nav/icon-settings.png" /></span>
				</div>
			</form:form>

		</div>
	</div>


</body>
</html>
