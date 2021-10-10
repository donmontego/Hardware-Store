<%@ page import="ventas.VentasDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Ventas</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link
            href="http://fonts.googleapis.com/css?family=Roboto:400,900,700,500,300,100"
            rel="stylesheet"
            type="text/css"
    />
<%--    <link--%>
<%--            rel="stylesheet"--%>
<%--            type=""--%>
<%--            href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"--%>
<%--    />--%>
    <link href="../../css/main.css" rel="stylesheet"/>
    <link href="../../popup/style.css" rel="stylesheet"/>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="preload" href="../../images/sales.jpg" as="image">


</head>
<body>

<jsp:include page="../partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestión de Ventas</p>
        <form id="sales-form">
            <div class="form-info" id="client-form">
                <label for="listaClientes">Cédula Cliente</label>
                    <select name="cedula" id="listaClientes" class="client-select">
                        <option selected hidden style="color:gray;">Seleccione la cédula</option>
                    </select>
<%--                <input type="number" id="cedula" name="cedula" value="" />--%>
                <label for="name">Nombre Cliente</label>
<%--                <span id="name" name="name" value=""></span>--%>
                <input type="text" id="name" name="name" value="" readonly class="client-name"/>
            </div>
            <div class="products-cart">
                <table id="tproducts">
                    <tbody>
                    <tr>
<%--                        <td><input type="text" placeholder="código" /></td>--%>
                        <td><select name="" id="cod-prod" class="cod-prod">
                            <option selected hidden style="color:gray;">Código</option>
                        </select></td>
                        <td><input type="text" placeholder="nombre producto" class="name-prod" readonly /></td>
                        <td>
                            <input type="number" placeholder="cant." class="cant-prod"/>
                        </td>
                        <td>
                            <input type="number" placeholder="vlr. total" class="total-prod" readonly />
                        </td>
                        <td>
                            <button type="button" class="delete-row">
                                <i class="fa fa-trash"></i>
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="add-row">
                    <i class="fa fa-plus"></i>Añadir producto
                </button>
            </div>
            <div class="totals-box" id="totals-box">
                <div class="consec">
                    <span><label class="lb">#</label></span>
                    <input
                            type="text"
                            name=""
                            value=""
                            placeholder="consec."
                            readonly
                            class="val"
                            id="consec"
                    />
                </div>
                <label class="vlr lb">Valor Total</label>
                <label class="iva lb">Valor IVA</label>
                <label class="total lb">Total</label>
                <div id="vlr" class="vlr div"></div>
                <div id="iva" class="iva div"></div>
                <div id="total" class="total div"></div>
                <button type="button" name="generate" id="generate">Generar</button>
                <button type="reset" name="clean" id="clean" onclick="window.location.reload()" hidden>Nueva</button>
            </div>
            <p id="result-msg" style="margin:0; padding:0;" ></p>
        </form>
    </div>
    <div
            class="img-container"
            style="background-image: url('../../images/sales.jpg');"
    >
        <img class="img-container" src='../../images/sales.jpg' alt="" style="display: none;">
    </div>
</div>
<script type="text/javascript" src="../../js/jquery-3.6.0.min.js"></script>
<script src="../../popup/popup.js"></script>
<script type="text/javascript" src="../../js/scripts.js"></script>
</body>
</html>
