<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Order Detail</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
 
</head>
<body>
   <jsp:include page="_header.jsp" />
 
   <jsp:include page="_menu.jsp" />
 
   <div class="page-title">Order Details</div>
  
   <div class="container">
       <h3>Thank you for Order</h3>
       Your order number is: ${order.orderNum} <br>
       Name : ${order.product.name}<br>
       Price : ${order.product.price}<br>
       Quantity : ${order.quantity}<br>
       Total Amount : ${order.amount}<br>
       
   </div>
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>