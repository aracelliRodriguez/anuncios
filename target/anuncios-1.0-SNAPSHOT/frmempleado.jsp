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
            <h1>FORMULARIO DE EMPLEADOS</h1>
            <br>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="empleados" />
            </jsp:include>         
            <br>
            <form action="EmpleadoControlador" method="post">
                <input type="hidden" name="id" value="${empleado.id}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${empleado.nombre}" placeholder="Escriba su nombre">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Apellido</label>
                    <input type="text" class="form-control" name="apellido" value="${empleado.apellido}" placeholder="Escriba su apellido">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Cargo</label>
                    <input type="text" class="form-control" name="cargo" value="${empleado.cargo}" placeholder="Escriba su cargo">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Direcion</label>
                    <input type="text" class="form-control" name="direccion" value="${empleado.direccion}" placeholder="Escriba su direccion">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Telefono</label>
                    <input type="text" class="form-control" name="telefono" value="${empleado.telefono}" placeholder="Escriba su telefono">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Edad</label>
                    <input type="text" class="form-control" name="edad" value="${empleado.edad}" placeholder="Escriba su edad">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">FechaContrato</label>
                    <input type="text" class="form-control" name="fechaContrato" value="${empleado.fechaContrato}" placeholder="Escriba su fechaContrato">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>







