<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<jsp:include page="cabecera.jsp"/>


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


<script>

function confirmarEliminar(idem){
	
	if(confirm("Esta seguro de eliminar el registro?")){
		
		window.location.href="/eliminarEmpleado?id="+idem;
	}
}

</script>


<jsp:include page="pie.jsp"/>