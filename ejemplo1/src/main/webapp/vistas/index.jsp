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

<form:form  action="/guardar" method="POST" modelAttribute="usuarios">


<label >Nombre</label>
<form:input path="nombre" type="text"  />
<form:errors path="nombre"></form:errors>

<label >Apellido</label>
<form:input path="apellidos" type="text"  />

<label >Edad</label>
<form:input path="edad" type="number"  />


<button type="submit">Enviar</button>

</form:form>



</body>
</html>