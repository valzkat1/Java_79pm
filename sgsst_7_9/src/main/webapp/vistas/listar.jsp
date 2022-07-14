<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>

<div class="container">

<h3>Listado de Empleados   &nbsp;<a href="/crear"> <img src="https://findicons.com/files/icons/1014/ivista/256/plus.png" width="40"/></a> </h3>   
<table class="table">
<thead>
  <th>Nombre</th>
  <th>Apellidos</th>
  <th>Documento</th>
  <th>TipoID</th>
  <th>Cargo</th>
  <th>Editar</th>
  <th>Eliminar</th>

</thead>
<tbody>
<c:forEach items="${listaEmpleados}" var="emp">
<tr>
<td>${emp.getNombre()}</td>
<td>${emp.getApellidos()}</td>
<td>${emp.getNumID()}</td>
<td>${emp.getTipoID()}</td>
<td>${emp.getCargo()}</td>
<td><a href="/editarE?id=${emp.getId()}">Editar</a></td>
<td><button  onclick="confirmarEliminar(${emp.getId()})" type="button">Eliminar</button></td>
</tr>

</c:forEach>

</tbody>

</table>

</div>
<script>

function confirmarEliminar(idem){
	
	if(confirm("Esta seguro de eliminar el registro?")){
		
		window.location.href="/eliminarEmpleado?id="+idem;
	}
}

</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>