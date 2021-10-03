<%@ page import="usuarios.UsuariosDTO" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/12/2021
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Usuarios</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link
            href="http://fonts.googleapis.com/css?family=Roboto:400,900,700,500,300,100"
            rel="stylesheet"
            type="text/css"
    />
    <link
            rel="stylesheet"
            type=""
            href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    />
    <link href="../../css/main.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="../partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Usuarios</p>
        <form action="Usuarios" method="post">
            <div class="form-info">
                <label for="cedula">Cédula</label>
                <input type="number" id="cedula" name="cedula" value="<%=request.getAttribute("USER") != null ? ((UsuariosDTO) request.getAttribute("USER")).getCedula() : ""%>"/>
                <label for="email">Correo Electrónico</label>
                <input type="email" id="email" name="email" value="<%=request.getAttribute("USER") != null ? ((UsuariosDTO) request.getAttribute("USER")).getEmail() : ""%>"/>
                <label for="name">Nombre Completo</label>
                <input type="text" id="name" name="name" value="<%=request.getAttribute("USER") != null ? ((UsuariosDTO) request.getAttribute("USER")).getName() : ""%>"/>
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" value="<%=request.getAttribute("USER") != null ? ((UsuariosDTO) request.getAttribute("USER")).getPassword() : ""%>"/>
                <label for="user">Usuario</label>
                <input type="text" id="user" name="user" value="<%=request.getAttribute("USER") != null ? ((UsuariosDTO) request.getAttribute("USER")).getUser() : ""%>"/>
            </div>
            <div class="form-buttons">
                <button type="submit" name="search">Consultar</button>
                <button type="submit" name="create">Crear</button>
                <button type="submit" name="update">Actualizar</button>
                <button type="submit" name="delete">Borrar</button>
            </div>
            <p style="margin:0; padding:0;" class="<%=request.getAttribute("RESULT") != null ? request.getAttribute("RESULT") : ""%>"><%=request.getAttribute("MESSAGE") != null ? request.getAttribute("MESSAGE") : ""%></p>
        </form>
    </div>
    <div
            class="img-container"
            style="background-image: url('../../images/users.jpg')"
    >
    </div>
</div>
</body>
</html>
