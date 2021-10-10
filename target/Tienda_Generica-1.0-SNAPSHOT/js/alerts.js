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

$('#search').click(function () {
    var opt = $("<input>").attr("type", "hidden").attr("name", "search").val("");
    $('#main-form').append(opt).submit()
})

$('#create').click(function () {
    var opt = $("<input>").attr("type", "hidden").attr("name", "create").val("");
    popup({
        type: "question",
        title: "Crear",
        message: "¿Desea agregar el registro?",
    }).then((e) => {
        if (e == "confirm") $('#main-form').append(opt).submit()
    })
})

$('#update').click(function () {
    var opt = $("<input>").attr("type", "hidden").attr("name", "update").val("");
    popup({
        type: "question",
        title: "Crear",
        message: "¿Desea actualizar el registro?",
    }).then((e) => {
        if (e == "confirm") $('#main-form').append(opt).submit()
    })
})

$('#delete').click(function () {
    var opt = $("<input>").attr("type", "hidden").attr("name", "delete").val("");
    popup({
        type: "question",
        title: "Crear",
        message: "¿Desea eliminar el registro?",
    }).then((e) => {
        if (e == "confirm") $('#main-form').append(opt).submit()
    })
})
