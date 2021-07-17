<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Product Manager</title>
</head>
<body>
	<div align="center">
		<table border="1" cellpadding="10">
		<thead>
            <tr>
                <th>Product ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Made In</th>
                <th>Price</th>
                <th>Edit Action</th>
            </tr>
        </thead>
			<tbody>
				<c:forEach items="${lists}" var="em">
					<tr>
						<td> ${em.id} </td>
						<td> ${em.name} </td>
						<td> ${em.brand} </td>
						<td> ${em.madein} </td>
						<td> ${em.price} </td>
						<td> <a href="${contextPath}/edit/${em.id}">Edit</a> </td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>