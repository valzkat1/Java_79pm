<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 

 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

<div class="container">
<h3>Crear Empleado</h3>
<form:form method="POST" action="/crear_empleado" modelAttribute="emp" >

<labe>Nombre</labe>
<form:input type="text" path="nombre" class="form-control"/>
<form:errors path="nombre"  style="color:red"></form:errors>

<br/>

<labe>Apellidos</labe>
<form:input type="text" path="apellidos" class="form-control"/>
<form:errors path="apellidos"  style="color:red"></form:errors>

<labe>Tipo Identificacion</labe>
<form:select  path="tipoID" class="form-select">

<form:option value="">-- Seleccionar</form:option>
<form:option value="CC">Cedula Ciudadania</form:option>
<form:option value="CE">Cedula Extranjeria</form:option>

</form:select>
<form:errors path="tipoID"  style="color:red"></form:errors>
<br/>

<labe>No Identificacion</labe>
<form:input type="text" path="numID" class="form-control"/>
<form:errors path="numID"  style="color:red"></form:errors>
<br/>

<labe>Cargo</labe>
<form:input type="text" path="cargo" class="form-control"/>
<form:errors path="cargo"  style="color:red"></form:errors>
<br/>


<labe>Area Trabajo</labe>
<form:input type="text" path="areaTrabajo" class="form-control"/>
<form:errors path="areaTrabajo"  style="color:red"></form:errors>
<br/>


<labe>Salario</labe>
<form:input type="text" path="salario" class="form-control" />
<form:errors path="salario"  style="color:red"></form:errors>
<br/>


<labe>Edad</labe>
<form:input type="text" path="edad" class="form-control" />
<form:errors path="edad"  style="color:red"></form:errors>
<br/>

<labe>EPS</labe>
<form:input type="text" path="EPS" class="form-control" />
<form:errors path="EPS"  style="color:red"></form:errors>
<br/>

<labe>AFP</labe>
<form:input type="text" path="AFP" class="form-control" />
<form:errors path="AFP"  style="color:red"></form:errors>
<br/>

<labe>ARL</labe>
<form:input type="text" path="ARL" class="form-control" />
<form:errors path="ARL"  style="color:red"></form:errors>
<br/>



<button type="submit" class="btn btn-primary">Enviar</button>

</form:form>

${textonormal} 

<br/>
${textodinamico} 

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>