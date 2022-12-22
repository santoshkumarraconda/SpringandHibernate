<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student Confirmation Page</title>
</head>
<body>
The Student is confirmed :${student.firstName} ${student.lastName} 

<br><br>

Country: ${student.country}
<br><br>
Favorite Language:${student.favouriteLanguage}
<br><br>

Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystem}">
		<li>${temp}</li>
	</c:forEach>
</ul>
<br><br>

</body>
</html>
