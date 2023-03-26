<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="com.to.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airlines</title>
</head>
<body>
	<%
	try {
		List<Airlines> A1= (List<Airlines>) request.getAttribute("message");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Airline name</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Airlines a : A1) {
			%>
			<tr>
				<td><%=a.getID() %></td>
				<td><%=a.getAirlineName() %></td>
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
	<form action=deleteairline method="post">
		<br>Enter the ID of the Airline to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the Airline">
	</form>
</body>
</html>