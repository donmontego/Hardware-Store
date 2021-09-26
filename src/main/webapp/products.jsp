<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Productos</title>
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

int codigo_producto;

double  iva_compra
        ,

        precio_compra
        ,

        precio_venta;


String
        nit_proveedor = ""
        ,
        nombre_producto = "",

        estado = "";

%>
<%
    if (request.getParameter("codigo_producto") != null) {
        codigo_producto = Integer.parseInt(request.getParameter("codigo_producto"));
        iva_compra = Double.parseDouble(request.getParameter("iva_compra"));
        precio_compra = Double.parseDouble(request.getParameter("precio_compra"));
        precio_venta = Double.parseDouble(request.getParameter("precio_venta"));
        nit_proveedor = request.getParameter("nit_proveedor");
        nombre_producto = request.getParameter("nombre_producto");
        estado = "Disabled";
    }

    if (request.getParameter("msg") != null) {
        codigo_producto = 0;
        iva_compra = 0;
        precio_compra = 0; // MOD en pantalla
        precio_venta = 0;   //  MOD en pantalla
        nit_proveedor = "";
        nombre_producto = "";   // MOD en pantalla
        estado = "";
        String msg = request.getParameter("msg");
        out.print("<script type='text/javascript'>alert('" + msg + "')</script>");
    }
%>
<jsp:include page="partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Productos</p>
        <form action="Productos" method="post" enctype="multipart/form-data">
            <div class="form-info">
                <label for="codigo_producto">Codigo de Producto</label>
                <input type="number" id="codigo_producto" name="codigo_producto" value="<%=codigo_producto%>"/>
                <label for="iva_compra">IVA Compra</label>
                <input type="number" id="iva_compra" name="iva_compra" value="<%=iva_compra%>" <%=estado%>/>
                <label for="nit_proveedor">NIT Proveedor</label>
                <input type="text" id="nit_proveedor" name="nit_proveedor" value="<%=nit_proveedor%>" <%=estado%>/>
                <label for="nombre_producto">Nombre de Producto</label>
                <input type="text" id="nombre_producto" name="nombre_producto" value="<%=nombre_producto%>"/>
                <label for="precio_compra">Precio de Compra</label>
                <input type="number" id="precio_compra" name="precio_compra" value="<%=precio_compra%>" <%=estado%>/>
                <label for="precio_venta">Precio de Venta</label>
                <input type="number" id="precio_venta" name="precio_venta" value="<%=precio_venta%>"/>
            </div>
            <div class="form-buttons">
                <button type="submit" name="search">Consultar</button>
                <button type="submit" name="update">Actualizar</button>
            </div>
            <div>
                <form action="Productos" method="post">
                    <div class="form-info">
                        <label> Nombre del archivo: <input type="file" name="archivo" value="examinar"
                                                           accept=".csv"> </label>
                    </div>
                    <div class="form-buttons">
                       <button type="submit" name="upload" value="cargar archivo">Cargar</button>
                        <!-- <input type="submit" name="upload" value="cargar archivo"> -->
                    </div>
                </form>
            </div>
        </form>
    </div>
    <div
            class="img-container"
            style="background-image: url('images/products.jpg')"
    >
    </div>
</div>
</body>
</html>
