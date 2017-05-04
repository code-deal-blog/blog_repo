<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Access Denied</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
 
</head>
<body>
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
   <div class="page-title">Access Denied!</div>
   <h3 style="color:red;">Sorry, you can not access this page!</h3>
   <jsp:include page="_footer.jsp" />
</body>
</html>