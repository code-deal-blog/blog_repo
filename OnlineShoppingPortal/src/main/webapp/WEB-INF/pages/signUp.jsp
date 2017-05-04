<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Sign Up</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
 
</head>
<body>
 
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
 
 
   <div class="page-title">Sign Up</div>
 
   <div class="login-container">
 
       <h3>Enter Details</h3>
       <br>
       <!-- /login?error=true -->
       <c:if test="${param.error == 'true'}">
           <div style="color: red; margin: 10px 0px;">
 
               Login Failed!!!<br /> Reason :
               ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
 
           </div>
       </c:if>
 
 		<form:form action="${pageContext.request.contextPath}/signUp" method="POST" modelAttribute="account">
 			<table>
               <tr>
                   <td><form:label path="userName">User Name *</form:label></td>
                   <td><form:input path="userName" required="required"/> </td>
                   <td style="color:red;"><form:errors path="userName"></form:errors> </td>
               </tr>
 
               <tr>
                   <td><form:label path="password">Password *</form:label></td>
                   <td><form:password path="password" required="required"/></td>
                   <td style="color:red;"><form:errors path="password"></form:errors> </td>
               </tr>
 
 			   <tr>
                   <td><form:label path="confirmPassword">Confirm Password *</form:label></td>
                   <td><form:password path="confirmPassword" required="required"/></td>
                   <td style="color:red;"><form:errors path="confirmPassword"></form:errors> </td>
               </tr> 
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Sign Up" /> <input type="reset"
                       value="Reset" /></td>
               </tr>
           </table>
 		</form:form>
       <%-- <form method="POST"
           action="${pageContext.request.contextPath}/j_spring_security_check">
           <table>
               <tr>
                   <td>User Name *</td>
                   <td><input name="userName" /></td>
               </tr>
 
               <tr>
                   <td>Password *</td>
                   <td><input type="password" name="password" /></td>
               </tr>
 
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Login" /> <input type="reset"
                       value="Reset" /></td>
               </tr>
           </table>
       </form>
 	   <a href="${pageContext.request.contextPath}/signUp">Sign Up Here</a> --%>
       <span class="error-message">${error }</span>
 
   </div>
 
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>