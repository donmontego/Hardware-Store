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
    <title>Usuarios</title>
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
<%--    <link href="css/navbar.css" rel="stylesheet"/>--%>
    <link href="css/users.css" rel="stylesheet"/>
</head>
<body>
<%!
    int cedula;
    String email = "", name = "", password = "", user = "";
%>
<%
    if (request.getParameter("cedula") != null){
        cedula = Integer.parseInt(request.getParameter("cedula"));
        email = request.getParameter("email");
        name = request.getParameter("name");
        password = request.getParameter("password");
        user = request.getParameter("user");

    }
    if (request.getParameter("msg") != null){
        cedula = 0;
        email ="";
        name = "";
        password = "";
        user = "";
        String msg = request.getParameter("msg");
        out.print("<script type='text/javascript'?>alert('"+msg+"')</script");
    }
%>

<%--<header>--%>
<%--    <div class="main-nav">--%>
<%--        <div class="top-bar">--%>
<%--            <!-- <span class="store-name">Tienda Genérica</span> -->--%>
<%--            <span class="store-name">Hardware Store</span>--%>
<%--            <span class="exit"><a href="L">Salir</a></span>--%>
<%--        </div>--%>
<%--        <div class="dropdown">--%>
<%--            <button class="dropdown-button">Menú</button>--%>
<%--            <ul>--%>
<%--                <li class="selected"><a href="">Usuarios</a></li>--%>
<%--                <li><a href="">Clientes</a></li>--%>
<%--                <li><a href="">Proveedores</a></li>--%>
<%--                <li><a href="">Productos</a></li>--%>
<%--                <li><a href="">Ventas</a></li>--%>
<%--                <li><a href="">Reportes</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</header>--%>
<jsp:include page="partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestion de Usuarios</p>
        <form action="Usuarios" method="post">
            <div class="form-info">
                <label for="cedula">Cédula</label>
                <input type="number" id="cedula" name="cedula" value="<%=cedula%>"/>
                <label for="email">Correo Electrónico</label>
                <input type="email" id="email" name="email" value="<%=email%>"/>
                <label for="name">Nombre Completo</label>
                <input type="text" id="name" name="name" value="<%=name%>"/>
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" value="<%=password%>"/>
                <label for="user">Usuario</label>
                <input type="text" id="user" name="user" value="<%=user%>"/>
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
            style="background-image: url('images/users.jpg')"
    >
        <!-- <img src="images/users.jpg" alt="" /> -->
    </div>
</div>
<!-- Code injected by live-server -->
<script type="text/javascript">
    // <![CDATA[  <-- For SVG support
    if ('WebSocket' in window) {
        (function () {
            function refreshCSS() {
                var sheets = [].slice.call(document.getElementsByTagName("link"));
                var head = document.getElementsByTagName("head")[0];
                for (var i = 0; i < sheets.length; ++i) {
                    var elem = sheets[i];
                    head.removeChild(elem);
                    var rel = elem.rel;
                    if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                        var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                        elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
                    }
                    head.appendChild(elem);
                }
            }

            var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
            var address = protocol + window.location.host + window.location.pathname + '/ws';
            var socket = new WebSocket(address);
            socket.onmessage = function (msg) {
                if (msg.data == 'reload') window.location.reload();
                else if (msg.data == 'refreshcss') refreshCSS();
            };
            console.log('Live reload enabled.');
        })();
    }
    // ]]>
</script>
</body>
</html>
