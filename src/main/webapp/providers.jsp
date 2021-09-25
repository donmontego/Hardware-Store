<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/12/2021
  Time: 5:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Proveedores</title>
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
    <link href="css/main.css" rel="stylesheet"/>
</head>
<body>
<%!
        String name = ""
                ,
                address = ""
                ,
                phone = ""
                ,
                city = ""
                ,
                nit = "";

%>
<%
    if (request.getParameter("nit") != null) {
        nit = request.getParameter("nit");
        name = request.getParameter("name");
        address = request.getParameter("address");
        phone = request.getParameter("phone");
        city = request.getParameter("city");
    }

    if (request.getParameter("msg") != null) {
        nit = "";
        name = "";
        address = "";
        phone = "";
        city = "";
        String msg = request.getParameter("msg");
        out.print("<script type='text/javascript'>alert('" + msg + "')</script>");
    }
%>
<jsp:include page="partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Proveedores</p>
        <form action="Proveedores" method="post">
            <div class="form-info">
                <label for="nit">NIT</label>
                <input type="text" id="nit" name="nit" value="<%=nit%>"/>
                <label for="name">Nombre Proveedor</label>
                <input type="text" id="name" name="name" value="<%=name%>"/>
                <label for="address">Dirección</label>
                <input type="text" id="address" name="address" value="<%=address%>"/>
                <label for="phone">Teléfono</label>
                <input type="text" id="phone" name="phone" value="<%=phone%>"/>
                <label for="city">Ciudad</label>
                <input type="text" id="city" name="city" value="<%=city%>"/>
            </div>
            <div class="form-buttons">
                <button type="submit" name="search">Consultar</button>
                <button type="submit" name="create">Crear</button>
                <button type="submit" name="update">Actualizar</button>
                <button type="submit" name="delete">Borrar</button>
            </div>
        </form>
    </div>
    <div
            class="img-container"
            style="background-image: url('images/providers.jpg')"
    >
    </div>
</div>
</body>
</html>
