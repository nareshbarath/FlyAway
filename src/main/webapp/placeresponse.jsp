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
		List<Places> P1= (List<Places>) request.getAttribute("message");
	%>
	<table border=1 align=center style="text-align: center">
		<thead>
			<tr>
				<th>ID</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Places p : P1) {
			%>
			<tr>
				<td><%=p.getID() %></td>
				<td><%=p.getPlace() %></td>
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
	<form action=deleteplace method="post">
		<br>Enter the ID of the Place to be deleted:
		<input type="number" name="id"> 
		<input type="submit" value="Click to delete the Place">
	</form>
</body>
</html>