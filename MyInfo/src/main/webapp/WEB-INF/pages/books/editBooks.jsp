<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.books-resources"/>
<html>
<head>
<title>Edit <fmt:message key="books.title"/></title>
</head>
<body>
	<div class="panel-wrapper">
		<div class="panel">
		<form:form action="${pageContext.request.contextPath}/saveBooks" method="POST" modelAttribute="books" name="parentform">
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
							<c:choose>
								<c:when test='${newFlag}' >
									&nbsp;&nbsp;<fmt:message key="navigation.new"/> <fmt:message key="books.title"/>
								</c:when>
								<c:otherwise>
									&nbsp;&nbsp;<fmt:message key="navigation.edit"/> <fmt:message key="books.title"/>
								<form:hidden id="books_booksId" path="booksId"/>
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
		<fmt:message key="books.bookid.title"/>:
	</label> 

							<c:choose>
								<c:when test='${newFlag}' >
							<form:input id="books_bookId" path="bookId" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_bookId",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.bookid.help"/>", constraints : {places:0}}})); </script>
								</c:when>
								<c:otherwise>
							${books.bookId}
						&nbsp;
									<form:hidden id="books_bookId" path="bookId"/>
								</c:otherwise>
							</c:choose>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.orderdate.title"/>:
	</label> 

							<input id="books_orderDate" name="orderDate" type="text" value="<fmt:formatDate value="${books.orderDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.title.title"/>:
	</label> 

							<form:input id="books_title" path="title" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_title",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.title.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.format.title"/>:
	</label> 

							<form:input id="books_format" path="format" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_format",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.format.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.asinisbn.title"/>:
	</label> 

							<form:input id="books_asinIsbn" path="asinIsbn" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_asinIsbn",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.asinisbn.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.author.title"/>:
	</label> 

							<form:input id="books_author" path="author" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_author",widgetType : "dijit.form.ValidationTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.author.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.releasedate.title"/>:
	</label> 

							<input id="books_releaseDate" name="releaseDate" type="text" value="<fmt:formatDate value="${books.releaseDate.time}" pattern="yyyy-MM-dd"/>" dojoType="dijit.form.DateTextBox" constraints="{datePattern:'<fmt:message key="date.format"/>'}" trim="true" promptMessage="<fmt:message key="date.format" />" invalidMessage="<fmt:message key="date.format.invalid" /> <fmt:message key="date.format" />." style="width:300px;" />
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.price.title"/>:
	</label> 

							<form:input id="books_price" path="price" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_price",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.price.help"/>"}})); </script>
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.userfk.title"/>:
	</label> 

							<form:input id="books_userFk" path="userFk" cssStyle="width:300px;"/>
							<script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "books_userFk",widgetType : "dijit.form.NumberTextBox",widgetAttrs : {promptMessage: "<fmt:message key="books.userfk.help"/>", constraints : {places:0}}})); </script>
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<input class="button-green submit" id="save" type="submit" value="Save Books"/>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 	<a class="button-pink" href="${pageContext.request.contextPath}/indexBooks">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>	

					
			</form:form>
					</div>
				<div class="shadow"></div>
</div>	

</body>
</html>