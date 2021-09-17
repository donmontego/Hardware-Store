<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/12/2021
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Usuarios</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
            href="http://fonts.googleapis.com/css?family=Roboto:400,900,700,500,300,100"
            rel="stylesheet"
            type="text/css"
    />
    <!-- <link rel="stylesheet" type="" -->
    <!-- href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <link
            rel="stylesheet"
            type=""
            href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
    />
    <link href="css/navbar.css" rel="stylesheet" />
    <link href="css/users.css" rel="stylesheet" />
</head>
<body>
<header>
    <div class="main-nav">
        <div class="top-bar">
            <span class="store-name">Tienda Genérica</span>
            <span class="exit"><a href="index.jsp">Salir</a></span>
        </div>
        <div class="dropdown">
            <button class="dropdown-button">Menú</button>
            <ul>
                <li class="selected"><a href="">Usuarios</a></li>
                <li><a href="">Clientes</a></li>
                <li><a href="">Proveedores</a></li>
                <li><a href="">Productos</a></li>
                <li><a href="">Ventas</a></li>
                <li><a href="">Reportes</a></li>
            </ul>
        </div>
    </div>
</header>

<div class="main-container">
    <div class="form-box">
        <form>
            <div class="form-info">
                <label for="cedula">Cédula</label>
                <input type="number" id="cedula" name="cedula" value="" />
                <label for="usuario">Usuario</label>
                <input type="text" id="usuario" name="usuario" value="" />
                <label for="name">Nombre Completo</label>
                <input type="text" id="name" name="name" value="" />
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" value="" />
                <label for="email">Correo Electrónico</label>
                <input type="email" id="email" name="email" value="" />
            </div>
            <div class="form-buttons">
                <button type="submit">Consultar</button>
                <button type="submit">Crear</button>
                <button type="submit">Actualizar</button>
                <button type="submit">Borrar</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
