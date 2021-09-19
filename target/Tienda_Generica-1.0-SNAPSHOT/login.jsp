<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
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
    <link href="css/navbar.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <!-- <link rel="stylesheet" type="" -->
    <!-- href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <style>
        body {
            font-family: "Roboto";
        }
    </style>
</head>
<body>
<header>
    <div class="main-nav">
        <div class="top-bar">
            <span class="store-name">Hardware Store</span>
            <span class="exit"><a href="index.jsp">Salir</a></span>
        </div>
    </div>
</header>

<div class="main">
    <div class="login-box">
        <i class="fas fa-laptop logo"></i>
        <!-- <img src="images/mouse-solid.png" alt="" class="logo" /> -->
        <h1>Login</h1>
        <p>Ingresa a tu cuenta</p>
        <form action="Login" method="post">
            <div class="user-icon">
                <input type="text" name="user" value="" placeholder="Usuario"/>
                <i class="fas fa-user icon"></i>
            </div>
            <div class="pass-icon">
                <input
                        type="password"
                        name="password"
                        value=""
                        placeholder="Contraseña"
                />
                <i class="fas fa-key icon"></i>
            </div>
            <input type="submit" name="login-acc" value="Ingresar"/>
            <p class="recover-password">
                <a href="https://www.google.com" class="recover-password"
                >Olvidé mi contraseña</a
                >
            </p>
            <input
                    type="submit"
                    name="register-acc"
                    value="Solicitar nueva cuenta"
                    class="register-acc"
            />
        </form>
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

