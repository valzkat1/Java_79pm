<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 

<jsp:include page="cabecera.jsp"/>


<h3>Reporte por area Empleados</h3>
<form method="POST" action="/reporteArea"  >
<div class="input-group mb-3">
  <span class="input-group-text" id="basic-addon1">Area de Trabajo</span>		
<select  path="areaTrabajo" class="form-select">
<option value="Sistemas">Sistemas</option>
<option value="Ventas">Ventas</option>
<option value="Cartera">Cartera</option>
<option value="Oficios">Oficios</option>
<option value="Administracion">Administracion</option>
<option value="Otros">Otros</option>
</select>
</div>


<button type="submit" class="btn btn-primary">Enviar</button>

</form>


<jsp:include page="pie.jsp"/>