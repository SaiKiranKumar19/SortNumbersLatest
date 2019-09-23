<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SortNumbers</title>
</head>
<body>
<div class="container">
<form action="/sort" method="post" modelAttribute="randomNumbers">
<label>Enter The Numbers to be sorted:</label>
<input type="text" name ="randomNumbers" placeholder="Enter un sorted numbers "><br>
<button type="submit" class="btn btn-primary" style="background-color:Green;">Sort Numbers</button>
</form>
</div>
</body>
</html>
<%@ include file="common/footer.jspf" %>
