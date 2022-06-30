<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method="POST" action="/crear_empleado" modelAttribute="emp" >

<labe>Nombre</labe>
<form:input type="text" path="nombre"/>
<br/>
<labe>Tipo Identificacion</labe>
<form:select  path="tipoID">

<form:option value="CC">Cedula Ciudadania</form:option>
<form:option value="CE">Cedula Extranjeria</form:option>

</form:select>
<br/>

<labe>No Identificacion</labe>
<form:input type="text" path="id_user"/>
<br/>


<button type="submit">Enviar</button>

</form:form>


</body>
</html>