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
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />

</head>
<body>

<jsp:include page="../partials/navbar.jsp"/>
<div class="main-container">
    <div class="form-box">
        <p>Gestión de Ventas</p>
        <form action="" method="">
            <div class="form-info">
                <label for="listaClientes">Cédula Cliente</label>
                <select name="cedula" id="listaClientes" placeholder="cédula"></select>
<%--                <input type="number" id="cedula" name="cedula" value="" />--%>
                <label for="name">Nombre Cliente</label>
<%--                <span id="name" name="name" value=""></span>--%>
                <input type="text" id="name" name="name" value="" />
            </div>
            <div class="products-cart">
                <table id="tproducts">
                    <tbody>
                    <tr>
<%--                        <td><input type="text" placeholder="código" /></td>--%>
                        <td><select name="" id="cod-prod" placeholder="Código"></select></td>
                        <td><input type="text" placeholder="nombre producto" /></td>
                        <td>
                            <input type="number" placeholder="cant." />
                        </td>
                        <td>
                            <input type="number" placeholder="vlr. total" />
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
                    <i class="fa fa-plus"></i>Nuevo producto
                </button>
            </div>
            <div class="totals-box">
                <div class="consec">
                    <span><label class="lb">#</label></span>
                    <input
                            type="text"
                            name=""
                            value=""
                            placeholder="consec."
                            readonly
                            class="val"
                    />
                </div>
                <label class="vlr lb">Valor Total</label>
                <label class="iva lb">Valor IVA</label>
                <label class="total lb">Total</label>
                <div class="vlr div"></div>
                <div class="iva div"></div>
                <div class="total div"></div>
                <button type="submit" name="delete">Generar</button>
            </div>
        </form>
    </div>
    <div
            class="img-container"
            style="background-image: url('../../images/sales.jpg')"
    ></div>
</div>
<script type="text/javascript" src="../../js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../../js/scripts.js"></script>
</body>
</html>
