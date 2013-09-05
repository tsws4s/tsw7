<%@page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.books-resources"/>
<html>
<head>
<title>Confirm Delete <fmt:message key="books.title"/></title>
</head>
<body>
		<div class="panel-wrapper">
					<div class="panel">
		
						<div class="tabs">
							<ul>
								<li class="active"><a href="#" rel="tab-01-content">
								<img src="css/images/icons/icon-user.png" alt="">
									&nbsp;&nbsp;<fmt:message key="navigation.delete"/> <fmt:message key="books.title"/> 
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
							${books.bookId}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.orderdate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="date" value="${books.orderDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.title.title"/>:
	</label> 
							${books.title}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.format.title"/>:
	</label> 
							${books.format}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.asinisbn.title"/>:
	</label> 
							${books.asinIsbn}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.author.title"/>:
	</label> 
							${books.author}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.releasedate.title"/>:
	</label> 
							<fmt:formatDate dateStyle="short" type="date" value="${books.releaseDate.time}"/>
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.price.title"/>:
	</label> 
							${books.price}
						&nbsp;
</div>
<div class="group fixed">
	<label>
		<fmt:message key="books.userfk.title"/>:
	</label> 
							${books.userFk}
						&nbsp;
</div>

</div>
						<!-- ## / Panel Content  -->
						</div>
										
<div style="padding-left:200px;padding-top:7px;padding-bottom:7px;background-color:rgb(239, 239, 239);">						
	<a class="button-red" href="${pageContext.request.contextPath}/deleteBooks?booksIdKey=${books.booksId}&">Confirm Delete <img alt="" src="css/images/icons/icon-delete.png"></a>
 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="button-pink" href="${pageContext.request.contextPath}/indexBooks">Cancel <img alt="" src="css/images/icons/icon-cancel-white.png"></a>
</div>						
					</div>
				<div class="shadow"></div>
		</div>

</body>
</html>