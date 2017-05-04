<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>ProductConfirmation</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
 
</head>
<body>
  <jsp:include page="_header.jsp" />
 
  <jsp:include page="_menu.jsp" />
 
  <div class="page-title">Confirmation</div>
 
 
 
  <div class="customer-info-container">
      <h3>Product Information:</h3>
      <form action="${pageContext.request.contextPath}/purchase" method="post">
      <input type="hidden" name="code" value="${product.code}"/>
      <ul>
          <li>Name: ${product.name}</li>
          <li>Price: <fmt:formatNumber value="${product.price}" type="currency"/></li>
          <li>Quantity:<input type="number" min="1" max="${product.quantity}" value="1" step="1" name="quantity" onfocus="this.blur();"/></li>
      </ul>
      <input type="submit" value="Purchase"/>
      </form>
  </div>
 	
   <a class="navi-item"
          href="${pageContext.request.contextPath}/productList">
          BACK</a>
  <jsp:include page="_footer.jsp" />
 
</body>
</html>