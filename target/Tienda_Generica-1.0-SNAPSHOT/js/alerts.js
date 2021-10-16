$('document').ready(function () {
    if (success !== 'null') {
        console.log(success, msg);
        if (success === "success-msg") {
            popup({
                type: "success",
                title: "",
                message: msg,
                buttonText: "Continuar",
            })
        } else {
            popup({
                type: "error",
                title: "",
                message: msg,
                buttonText: "Continuar",
            })
        }
    }
})

function validarCreate() {
    var validador = true

    $("#main-form input").each(function (){

        if ($(this).val() === "") {
            validador = false
        }

    })
    if (!validador) {
        popup({
            type: "error",
            title: "",
            message: "Debe llenar todos los campos",
            buttonText: "Continuar",
        })
    }

    return validador
}

function validarSearch() {
    var datoRequerido = $("#main-form label").first().text()
    var cedula = $("#main-form input").first().val()

    if (cedula === "" || cedula === null) {
        popup({
            type: "error",
            title: "",
            message: "La busqueda requiere " + datoRequerido,
            buttonText: "Continuar",
        })
        return false
    }
}

$('#search').click(function () {

    if (validarSearch() === false) {

    }else {
        var opt = $("<input>").attr("type", "hidden").attr("name", "search").val("");
        $('#main-form').append(opt).submit()
    }

})

$('#create').click(function () {

    if (validarCreate() === false) {

    }else {
        var opt = $("<input>").attr("type", "hidden").attr("name", "create").val("");
        popup({
            type: "question",
            title: "Crear",
            message: "¿Desea agregar el registro?",
        }).then((e) => {
            if (e === "confirm") $('#main-form').append(opt).submit()
        })
    }
})

$('#update').click(function () {
    var opt = $("<input>").attr("type", "hidden").attr("name", "update").val("");
    popup({
        type: "question",
        title: "Crear",
        message: "¿Desea actualizar el registro?",
    }).then((e) => {
        if (e === "confirm") $('#main-form').append(opt).submit()
    })
})

$('#delete').click(function () {
    var opt = $("<input>").attr("type", "hidden").attr("name", "delete").val("");
    popup({
        type: "question",
        title: "Crear",
        message: "¿Desea eliminar el registro?",
    }).then((e) => {
        if (e === "confirm") $('#main-form').append(opt).submit()
    })
})
