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
            <h1>FORMULARIO DE VENTAS</h1>
            <br>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="ventas" />
            </jsp:include>         
            <br>
            <form action="VentaControlador" method="post">
                
                <input type="hidden" name="id" value="${venta.id}">
                <div class="form-group">
                    <label for="" class="form-label">Cliente</label>
                    <select name="cliente_id" class="form-control" >
                        <option values="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_clientes}">
                            <option values="${item.id}" 
                                    <c:if test="${venta.cliente_id == item.id}">
                                    selected
                                    </c:if> 
                                        >${item.nombre}</option>
                        </c:forEach>
                        
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Producto</label>
                    <select name="producto_id" class="form-control" >\
                        <option values="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_productos}">
                            <option values="${item.id}"
                                    <c:if test="${venta.producto_id == item.id}">
                                    selected
                                    </c:if> 
                                        >${item.nombre}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Cantidad</label>
                    <input type="text" class="form-control" name="cantidad" value="${venta.cantidad}" placeholder="Escriba su cantidad">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Total</label>
                    <input type="text" class="form-control" name="total" value="${venta.total}" placeholder="Escriba su total">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" name="fecha" value="${venta.fecha}" placeholder="Escriba la fecha">
                </div>
                
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>

        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>





