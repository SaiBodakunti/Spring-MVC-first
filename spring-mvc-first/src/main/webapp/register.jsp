<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="datastu1" modelAttribute="stu">
Id :  <form:input path="id"/> <br>
Name:   <form:input path="name"/> <br>
Age :   <form:input path="age"/> <br>

<form:button>Save</form:button>
</form:form>
</body>
</html>