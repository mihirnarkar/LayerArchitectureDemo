<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Laptop data</title>
</head>
<body>
	<h2>Laptop Data</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Make</th>
            <th>Cost</th>
        </tr>
        <c:forEach items="${laptops}" var="laptop">
            <tr>
                <td>${not empty laptop.lid ? laptop.lid : ''}</td>
			    <td>${not empty laptop.make ? laptop.make : ''}</td>
			    <td>${not empty laptop.cost ? laptop.cost : ''}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>