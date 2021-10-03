<%@ page import="productos.ProductosDTO" %>
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
<jsp:include page="../partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Productos</p>
        <form action="Productos" method="post" enctype="multipart/form-data">
            <div class="form-info">
                <label for="codigo_producto">Codigo de Producto</label>
                <input type="number" id="codigo_producto" name="codigo_producto" value="<%=request.getAttribute("PRODUCT") != null ? ((ProductosDTO) request.getAttribute("PRODUCT")).getCodigo_producto() : ""%>"/>
                <label for="iva_compra">IVA Compra</label>
                <input type="number" id="iva_compra" name="iva_compra" value="<%=request.getAttribute("PRODUCT") != null ? ((ProductosDTO) request.getAttribute("PRODUCT")).getIva_compra() : ""%>" />
                <label for="nit_proveedor">NIT Proveedor</label>
                <input type="text" id="nit_proveedor" name="nit_proveedor" value="<%=request.getAttribute("PRODUCT") != null ? ((ProductosDTO) request.getAttribute("PRODUCT")).getNit_proveedor() : ""%>" />
                <label for="nombre_producto">Nombre de Producto</label>
                <input type="text" id="nombre_producto" name="nombre_producto" value="<%=request.getAttribute("PRODUCT") != null ? ((ProductosDTO) request.getAttribute("PRODUCT")).getNombre_producto() : ""%>"/>
                <label for="precio_compra">Precio de Compra</label>
                <input type="number" id="precio_compra" name="precio_compra" value="<%=request.getAttribute("PRODUCT") != null ? ((ProductosDTO) request.getAttribute("PRODUCT")).getPrecio_compra() : ""%>" />
                <label for="precio_venta">Precio de Venta</label>
                <input type="number" id="precio_venta" name="precio_venta" value="<%=request.getAttribute("PRODUCT") != null ? ((ProductosDTO) request.getAttribute("PRODUCT")).getPrecio_venta() : ""%>"/>
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
                    <p style="margin:0; padding:0;" class="<%=request.getAttribute("RESULT") != null ? request.getAttribute("RESULT") : ""%>"><%=request.getAttribute("MESSAGE") != null ? request.getAttribute("MESSAGE") : ""%></p>
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
