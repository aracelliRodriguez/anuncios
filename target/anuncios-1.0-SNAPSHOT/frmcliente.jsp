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
    <body color="red">
        <div class="container">
            <h1>FORMULARIO DE CLIENTES</h1>
            <br>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes" />
            </jsp:include>         
            <br>
            <form action="ClienteControlador" method="post">
                <input type="hidden" name="id" value="${cliente.id}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${cliente.nombre}" placeholder="Escriba su nombre">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Apellido</label>
                    <input type="text" class="form-control" name="apellido" value="${cliente.apellido}" placeholder="Escriba su apellido">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Direccion</label>
                    <input type="text" class="form-control" name="direccion" value="${cliente.direccion}" placeholder="Escriba su direccion">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Correo</label>
                    <input type="text" class="form-control" name="correo" value="${cliente.correo}" placeholder="Escriba su correo">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Celular</label>
                    <input type="text" class="form-control" name="celular" value="${cliente.celular}" placeholder="Escriba su celular">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Fechanac</label>
                    <input type="text" class="form-control" name="fechanac" value="${cliente.fechanac}" placeholder="Escriba su fechanac">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>






