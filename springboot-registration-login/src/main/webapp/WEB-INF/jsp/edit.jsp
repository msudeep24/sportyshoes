<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Update Employee </title>
</head>
<body>
<div>
 <h1>Product Edit Form</h1>
 <br/>
 <form th:object="${product}" th:action="@{/update_product}" method="post">
 <table border="1">
   <tr>
    <td>Employee Id</td>
    <td><input type="text" th:field="*{id}" /></td>
   </tr>
   <tr>
    <td>Brand</td>
    <td><input type="text" th:field="*{brand}" /></td>
   </tr>
   <tr>
    <td>Manufactured Country</td>
    <td><input type="text" th:field="*{madein}" /></td>
   </tr>
   <tr>
    <td>Name</td>
    <td><input type="text" th:field="*{name}" /></td>
   </tr>
   <tr>
    <td>Price</td>
    <td><input type="text" th:field="*{price}" /></td>
   </tr>
   
   <tr>
        <td><button type="submit">Update</button></td>
   </tr>
 </table>
 </form>
</div>

</body>
</html>