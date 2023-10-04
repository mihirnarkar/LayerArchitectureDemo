<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/insertlap" method="post">
		Enter laptop id : <input type="text" name="lid"/>
		Enter laptop make : <input type="text" name="make"/>
		Enter laptop cost : <input type="text" name="cost"/>
		<button type="submit">submit</button>
		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/getdata'">GetDetails</button>
	</form>
</body>
</html>