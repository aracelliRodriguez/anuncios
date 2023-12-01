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
            <h1>FORMULARIO DE SUCURSALES</h1>
            <br>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="sucursales" />
            </jsp:include>         
            <br>
            <form action="SucursalControlador" method="post">
                <input type="hidden" name="id" value="${sucursal.id}">
                <div class="form-group">
                    <label for="" class="form-label">Ciudad</label>
                    <input type="text" class="form-control" name="ciudad" value="${sucursal.ciudad}" placeholder="Escriba su Ciudad">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Director</label>
                    <input type="text" class="form-control" name="director" value="${sucursal.director}" placeholder="Escriba su director">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">ObjetivoVen</label>
                    <input type="text" class="form-control" name="objetivoVen" value="${sucursal.objetivoVen}" placeholder="Escriba su objetivoVen">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">VentaReal</label>
                    <input type="text" class="form-control" name="ventaReal" value="${sucursal.ventaReal}" placeholder="Escriba su ventaReal">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>






