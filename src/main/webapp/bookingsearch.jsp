<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Flight search</title>
</head>
<body>
	<h1>Enter the complete details to search for flight</h1>
	<form action="flightsearch" method="post"><br> 
		Enter the From location<input type="text" name="source"><br>
		Enter the To location<input type="text" name="destination"><br>
		Date of the flight<input type="date" name="date" ><br>
		<input type="submit" value="Click here to search for flights">
		</form>
</body>
</html>