<%
    String opcion = request.getParameter("opcion");
%>

    
 <ul class="nav nav-pills">
   
  <li class="nav-item">
      <a class="nav-link <%= (opcion.equals("sucursales") ? "active" : "")%>" href="SucursalControlador">SUCURSALES</a>
  </li>
  <li class="nav-item">
      <a class="nav-link <%= (opcion.equals("proveedores") ? "active" : "")%>" href="ProveedorControlador">PROVEEDORES</a>
  </li>
  <li class="nav-item">
      <a class="nav-link <%= (opcion.equals("empleados") ? "active" : "")%>" href="EmpleadoControlador">EMPLEADOS</a>
  </li>
  <li class="nav-item">
      <a class="nav-link <%= (opcion.equals("pedidos") ? "active" : "")%>" href="PedidoControlador">PEDIDOS</a>
  </li>
  <li class="nav-item">
      <a class="nav-link <%= (opcion.equals("productos") ? "active" : "")%>" href="ProductoControlador">PRODUCTOS</a>
  </li>
  <li class="nav-item">
    <a class="nav-link <%= (opcion.equals("clientes") ? "active" : "")%>" href="ClienteControlador">CLIENTES</a>
  </li>
  <li class="nav-item">
    <a class="nav-link <%= (opcion.equals("ventas") ? "active" : "")%>" href="VentaControlador">VENTAS</a>
  </li>
</ul>

