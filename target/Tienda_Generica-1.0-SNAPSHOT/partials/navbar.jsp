<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 9/18/2021
  Time: 12:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="../css/navbar.css" rel="stylesheet"/>
</head>
<body>
<header>
    <div class="main-nav">
        <div class="top-bar">
            <!-- <span class="store-name">Tienda Genérica</span> -->
            <span class="store-name">Hardware Store</span>
            <span class="exit"><a href="../login.jsp">Salir</a></span>
        </div>
        <div class="dropdown">
            <button class="dropdown-button">Menú</button>
            <ul>
                <li class="selected"><a href="../users.jsp">Usuarios</a></li>
                <li><a href="../clients.jsp" onclick="dynamicNavbar();">Clientes</a></li>
                <li><a href="" onclick="dynamicNavbar();">Proveedores</a></li>
                <li><a href="" onclick="dynamicNavbar();">Productos</a></li>
                <li><a href="" onclick="dynamicNavbar();">Ventas</a></li>
                <li><a href="" onclick="dynamicNavbar();">Reportes</a></li>
            </ul>
        </div>
    </div>
</header>
<script type="text/javascript">
    function dynamicNavbar() {
            $('.main-nav .dropdown').find('a.selected').removeClass('selected');
            $(this).addClass('selected');

    }
</script>
</body>
</html>
