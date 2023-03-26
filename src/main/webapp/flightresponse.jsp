<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="com.to.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights</title>
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
	<form action=deleteflight method="post">
		<br>Enter the ID of the Flight to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the Flight">
	</form>
</body>
</html>