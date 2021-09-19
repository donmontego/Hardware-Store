<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/17/2021
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clientes</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
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
    <link href="css/users.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Clientes</p>
        <form action="/Clientes" method="post">
            <div class="form-info">
                <label for="cedula">Cédula</label>
                <input type="number" id="cedula" name="cedula" value=""/>
                <label for="name">Nombre Completo</label>
                <input type="text" id="name" name="name" value=""/>
                <label for="address">Dirección</label>
                <input type="text" id="address" name="address" value=""/>
                <label for="phone">Teléfono</label>
                <input type="text" id="phone" name="phone" value=""/>
                <label for="email">Correo Electrónico</label>
                <input type="email" id="email" name="email" value=""/>
            </div>
            <div class="form-buttons">
                <button type="submit">Consultar</button>
                <button type="submit" name="create">Crear</button>
                <button type="submit">Actualizar</button>
                <button type="submit">Borrar</button>
            </div>
        </form>
    </div>
    <div
            class="img-container"
            style="background-image: url('images/clients.jpg')"
    >
        <!-- <img src="images/users.jpg" alt="" /> -->
    </div>
</div>
</body>
</html>
