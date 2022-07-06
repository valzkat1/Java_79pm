<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
<thead>
  <th>Nombre</th>
  <th>Email</th>
  <th>Telefono</th>

</thead>
<tbody>
<c:forEach items="${listaEmpleados}" var="emp">
<tr>
<td>${emp.getNombre()}</td>
<td>emp.getEmail()</td>
<td>emp.getTelefono()</td>


</tr>

</c:forEach>

</tbody>

</table>



</body>
</html>