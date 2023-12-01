<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Comercial</title>
    </head>
    <body>
        <div class="container">
            <h1>PROVEEDORES</h1>
            <br>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="proveedores" />
            </jsp:include>         
            <br>
            <a href="ProveedorControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i>Nuevo</a> 
            <br>
            <table class="table table-dark table-striped">
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>FABRICA</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${proveedores}">
                    <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.fabrica}</td>
                    <td>${item.direccion}</td>
                    <td>${item.telefono}</td>
                    <td><a href="ProveedorControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="ProveedorControlador?action=delete&id=${item.id}"onclick="return(confirm('Esta seguro de eliminar ?'))"><i class="fa-regular fa-trash-can"></i></a></td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    </body>
</html>




