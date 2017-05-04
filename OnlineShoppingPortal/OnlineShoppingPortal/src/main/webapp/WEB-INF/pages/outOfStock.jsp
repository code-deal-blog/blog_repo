<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Out of stock</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
 
</head>
<body>
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
   <h3 style="color:red;">Product is out of stock !</h3>
   <jsp:include page="_footer.jsp" />
</body>
</html>