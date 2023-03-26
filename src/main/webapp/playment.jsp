<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment gateway</title>
</head>
<body>
<form action=bookingsuccess method="post">
		<br>
		Booking ID:<input type="text" name="id" value="${bookingID}" readonly> <br>
		Total amount<input type="text" name="count" value="${totalPrice}" readonly><br>
		Enter your Card number<input type="number" name="card"><br>
		Enter your Card pin<input type="password" name="pin"><br>
		<input type="submit" value="Click to go to pay">
	</form>
</body>
</html>