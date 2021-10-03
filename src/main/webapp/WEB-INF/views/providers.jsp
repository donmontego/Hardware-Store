<%@ page import="proveedores.ProveedoresDTO" %>
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
    <link href="../../css/main.css" rel="stylesheet"/>
</head>
<body>

<jsp:include page="../partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Proveedores</p>
        <form action="Proveedores" method="post">
            <div class="form-info">
                <label for="nit">NIT</label>
                <input type="text" id="nit" name="nit" value="<%=request.getAttribute("PROVIDER") != null ? ((ProveedoresDTO) request.getAttribute("PROVIDER")).getNit() : ""%>"/>
                <label for="name">Nombre Proveedor</label>
                <input type="text" id="name" name="name" value="<%=request.getAttribute("PROVIDER") != null ? ((ProveedoresDTO) request.getAttribute("PROVIDER")).getName() : ""%>"/>
                <label for="address">Dirección</label>
                <input type="text" id="address" name="address" value="<%=request.getAttribute("PROVIDER") != null ? ((ProveedoresDTO) request.getAttribute("PROVIDER")).getAddress() : ""%>"/>
                <label for="phone">Teléfono</label>
                <input type="text" id="phone" name="phone" value="<%=request.getAttribute("PROVIDER") != null ? ((ProveedoresDTO) request.getAttribute("PROVIDER")).getPhone() : ""%>"/>
                <label for="city">Ciudad</label>
                <input type="text" id="city" name="city" value="<%=request.getAttribute("PROVIDER") != null ? ((ProveedoresDTO) request.getAttribute("PROVIDER")).getCity() : ""%>"/>
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
            style="background-image: url('../../images/providers.jpg')"
    >
    </div>
</div>
</body>
</html>