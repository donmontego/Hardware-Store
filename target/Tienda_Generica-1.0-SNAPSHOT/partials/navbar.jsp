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
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link href="../css/navbar.css" rel="stylesheet"/>
</head>
<body>
<%!
    String usersTab = "";
    String clientsTab = "";
    String providersTab = "";
    String productsTab = "";
    String salesTab = "";
    String reportsTab = "";
%>
<%
    if ( request.getRequestURL().toString().contains("users.jsp")){
        usersTab = "selected";
        clientsTab = "";
        providersTab = "";
        productsTab = "";
        salesTab = "";
        reportsTab = "";
    }else if ( request.getRequestURL().toString().contains("clients.jsp")){
        usersTab = "";
        clientsTab = "selected";
        providersTab = "";
        productsTab = "";
        salesTab = "";
        reportsTab = "";

    }else if (request.getRequestURL().toString().contains("providers.jsp")){
        usersTab = "";
        clientsTab = "";
        providersTab = "selected";
        productsTab = "";
        salesTab = "";
        reportsTab = "";

    } else if (request.getRequestURL().toString().contains("products.jsp")){
        usersTab = "";
        clientsTab = "";
        providersTab = "";
        productsTab = "selected";
        salesTab = "";
        reportsTab = "";

    }else{
        usersTab = "";
        clientsTab = "";
        providersTab = "";
        productsTab = "";
        salesTab = "";
        reportsTab = "";
    }
%>
<header>
    <div class="main-nav">
        <div class="top-bar">
            <!-- <span class="store-name">Tienda Genérica</span> -->
            <span class="store-name">Hardware Store</span>
            <span class="exit"><a href="../login.jsp">Salir</a></span>
        </div>
        <div class="dropdown">
            <button class="dropdown-button">Menú</button>
            <ul class="nav-bar" id="nav-list">
                <li class="<%=usersTab%>"><a href="../users.jsp">Usuarios</a></li>
                <li class="<%=clientsTab%>"><a href="../clients.jsp">Clientes</a></li>
                <li class="<%=providersTab%>"><a href="../providers.jsp">Proveedores</a></li>
                <li class="<%=productsTab%>"><a href="../products.jsp">Productos</a></li>
                <li><a href="">Ventas</a></li>
                <li><a href="">Reportes</a></li>
            </ul>
        </div>
    </div>
</header>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
    $(document).ready(function (e) {
        var page_head = getUrlVars()["page_head"];
        console.log(page_head);
        try {
            $('#tab').removeClass('selected');
            $('#nav-list > li:nth-child(' + page_head + ')').addClass('selected');

        } catch (err) {
        }
    });
</script>
</body>
</html>
