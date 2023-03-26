<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="com.to.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking</title>
</head>
<body>
	<%
	try {
		List<Flights> F1= (List<Flights>) request.getAttribute("message");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Airline</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Date</th>
				<th>Departure</th>
				<th>Arrival</th>
				<th>Ticket price</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Flights f : F1) {
			%>
			<tr>
				<td><%=f.getID() %></td>
				<td><%=f.getAirline() %></td>
				<td><%=f.getSource() %></td>
				<td><%=f.getDestination() %></td>
				<td><%=f.getDate() %></td>
				<td><%=f.getDeparture() %></td>
				<td><%=f.getArival()%></td>
				<td><%=f.getTicketprice() %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<br>
	<%
	} catch (Exception e) {
	out.print(e.getMessage());
	}
	%>
	<br>
	<br>
	<br>
	<form action=booktickets method="post">
		<br>
		Enter the ID of the Flight to be Booked:<input type="number" name="id"> <br>
		Enter the number of tickets<input type="number" name="count"><br>
		Enter your name<input type="text" name="name"><br>
		Enter your age<input type="number" name="age"><br>
		Enter your email<input type="email" name="email"><br>
		Enter your phno<input type="number" name="phno"><br>
		<input type="submit" value="Click to go to payment page">
	</form>
</body>
</html>