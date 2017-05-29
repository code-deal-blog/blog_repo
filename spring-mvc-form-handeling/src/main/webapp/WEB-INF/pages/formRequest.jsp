<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request Form</title>
</head>
<body>
<h1>Form Handling Using @RequestParam</h1>
<h2>${schoolName}</h2>
<form action="formRequest" method="post">
	<label>Name :</label><input type="text" name="sName"><br><br>
	<label>Age :</label><input type="text" name="sAge"><br><br>
	<label>DOB :</label><input type="text" name="sDob"><br><br>
	<label>Hobbies :</label><select name="sHobbies" multiple="multiple">
						<option value="dancing">Dancing</option>
						<option value="sketching">Sketching</option>
						<option value="painting">Painting</option>
					</select><br><br>
	<input type="submit" value="Register">
</form>
</body>
</html>

