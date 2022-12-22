<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>Student Registration Form </title>
</head>
<body>
	
	<form:form action="processForm" modelAttribute="student">
	First Name: <form:input path="firstName"/>
	<br><br>
	Last Name: <form:input path="lastName"/>
	<br><br>
	
	Country : <form:select path="country">
	
	<form:options items="${student.countryOptions}"/>
	
	</form:select>
	<br><br>
	
	Favorite Language: 
	Java<form:radiobutton path="favouriteLanguage" value="Java"/>
	Php<form:radiobutton path="favouriteLanguage" value="Php"/>
	Ruby<form:radiobutton path="favouriteLanguage" value="Ruby"/>
	C#<form:radiobutton path="favouriteLanguage" value="C#"/>
	<br><br>
	
	Windows:<form:checkbox path="operatingSystem" value="Windows"/>
	Linux:<form:checkbox path="operatingSystem" value="Linux"/>
	MACOS:<form:checkbox path="operatingSystem" value="MACOS"/>
	
	<input type="submit" value="submit"/>
	</form:form>

</body>
</html>