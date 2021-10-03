var prods
var idCod=1
$(document).ready(function () {
    $.ajax({
        type: "POST",
        url:"Ventas",
        dataType: "json",
        data:{
            option: "clientes"
        },
        success: function(clientes){
            console.log(clientes);
            var lista=document.getElementById("listaClientes")
            console.log(lista)
            lista.innerHTML=''
            for(let cliente of clientes){
                lista.innerHTML+= `<option value="${cliente.name}">${cliente.cedula}</option>`
            }
        }
  })
    $.ajax({
        type: "POST",
        url:"Ventas",
        dataType: "json",
        data:{
            option: "productos"
        },
        success: function(productos){
            console.log(productos);
            prods = productos
            var listaProductos =document.getElementById("cod-prod")
            console.log(listaProductos)
            listaProductos.innerHTML=''
            for(let producto of productos){
                listaProductos.innerHTML+= `<option value="${producto.nombre_producto}">${producto.codigo_producto}</option>`
            }
        }
    })
});

function populateCodes(id){
    var listaProductos =document.getElementById("cod-prod"+id)
    console.log(listaProductos)
    listaProductos.innerHTML=''
    for(let producto of prods){
        listaProductos.innerHTML+= `<option value="${producto.nombre_producto}">${producto.codigo_producto}</option>`
    }
}
$(".add-row").click(function () {
    var newRow =
        "<tr>" +
        "<td><select id='cod-prod"+idCod+"' placeholder='código'></td>" +
        "<td><input type='text' placeholder='nombre producto'></td>" +
        "<td><input type='number' placeholder='cant.'></td>" +
        "<td><input type='number' placeholder='vlr. total'></td>" +
        "<td><button type='button' class='delete-row'><i class='fa fa-trash'></i></button></td>" +
        "</tr>";
    console.log(newRow);
    $("table tbody").append(newRow);
    populateCodes(idCod)
    idCod+=1
});

$("#tproducts").on("click", ".delete-row", function () {
    $(this).closest("tr").remove();
});

$("#listaClientes").change(function (){
   // var cliente = document.getElementById("name");
   $("#name").val($(this).val())
})