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
            <h1>FORMULARIO DE PEDIDOS</h1>
            <br>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="pedidos" />
            </jsp:include>         
            <br>
            <form action="PedidoControlador" method="post">
                <input type="hidden" name="id" value="${pedido.id}">
                <div class="form-group">
                    <label for="" class="form-label">FechaPedido</label>
                    <input type="text" class="form-control" name="fechaPedido" value="${pedido.fechaPedido}" placeholder="Escriba su fechaPedido">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Cliente</label>
                    <input type="text" class="form-control" name="cliente" value="${pedido.cliente}" placeholder="Escriba su cliente">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">RepVenta</label>
                    <input type="text" class="form-control" name="repVenta" value="${pedido.repVenta}" placeholder="Escriba su repVenta">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Fabrica</label>
                    <input type="text" class="form-control" name="fabrica" value="${pedido.fabrica}" placeholder="Escriba su fabrica">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Producto</label>
                    <input type="text" class="form-control" name="producto" value="${pedido.producto}" placeholder="Escriba su producto">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Cantidad</label>
                    <input type="text" class="form-control" name="cantidad" value="${pedido.cantidad}" placeholder="Escriba su cantidad">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>








