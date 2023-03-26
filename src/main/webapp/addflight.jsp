<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add flight</title>
</head>
<body>
	<h1>Enter the details to add an flight</h1>
	<form action="addflight" method="post"><br> 
		Enter the ID of the Airline<input type="number" name="airlineid" value="Enter ID of the airlines"><br>
		Enter ID of the source location<input type="number" name="sourceid" value="Enter ID of the source location"><br>
		Enter ID of the destination location<input type="number" name="destinationid" value="Enter ID of the destination location"><br>
		Date of the flight<input type="date" name="date" ><br>
		Departure time of the flight<input type="datetime" name="departure" ><br>
		Arrival time of the flight<input type="datetime" name="arival" ><br>
		<input type="number" name="ticketprice" value="Enter Price per ticket"><br>
		<input type="submit" value="Click here to Add the flight">
	</form>
</body>
</html>