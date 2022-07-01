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

<form:form method="POST" action="/crear_empleado" modelAttribute="emp" >

<labe>Nombre</labe>
<form:input type="text" path="nombre" class="form-control"/>
<form:errors path="nombre"  style="color:red"></form:errors>

<br/>
<labe>Tipo Identificacion</labe>
<form:select  path="tipoID" class="form-select">

<form:option value="">-- Seleccionar</form:option>
<form:option value="CC">Cedula Ciudadania</form:option>
<form:option value="CE">Cedula Extranjeria</form:option>

</form:select>
<form:errors path="tipoID"  style="color:red"></form:errors>
<br/>

<labe>No Identificacion</labe>
<form:input type="text" path="id_user" class="form-control"/>
<form:errors path="id_user"  style="color:red"></form:errors>
<br/>

<labe>Email</labe>
<form:input type="text" path="email" class="form-control"/>
<form:errors path="email"  style="color:red"></form:errors>
<br/>


<labe>Confirmar Email</labe>
<form:input type="text" path="confirmarEmail" class="form-control"/>
<form:errors path="confirmarEmail"  style="color:red"></form:errors>
<br/>


<labe>Telefono</labe>
<form:input type="text" path="telefono" class="form-control" placeholder="+57-XXXXXXX"/>
<form:errors path="telefono"  style="color:red"></form:errors>
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