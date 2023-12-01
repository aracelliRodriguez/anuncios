
package com.emergentes.controlador;

import com.emergentes.dao.PedidoDAO;
import com.emergentes.dao.PedidoDAOimpl;
import com.emergentes.modelo.Pedido;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PedidoControlador", urlPatterns = {"/PedidoControlador"})
public class PedidoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PedidoDAO dao = new PedidoDAOimpl();

        Pedido ped = new Pedido();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("pedido", ped);
                request.getRequestDispatcher("frmpedido.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    //obtener el objeto que corresponde al registro
                    ped = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                //colocar como atributo
                request.setAttribute("pedido", ped);
                //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmpedido.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("PedidoControlador");
                break;

            case "view":
                List<Pedido> lista = new ArrayList<Pedido>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar " + ex.getMessage());
                }
                request.setAttribute("pedidos", lista);
                request.getRequestDispatcher("pedidos.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String fechaPedido = request.getParameter("fechaPedido");
        String cliente = request.getParameter("cliente");
        String repVenta = request.getParameter("repVenta");
        String fabrica = request.getParameter("fabrica");
        String producto = request.getParameter("producto");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        Pedido ped = new Pedido();

        ped.setId(id);
        ped.setFechaPedido(convierteFecha(fechaPedido));
        ped.setCliente(cliente);
        ped.setRepVenta(repVenta);
        ped.setFabrica(fabrica);
        ped.setProducto(producto);
        ped.setCantidad(cantidad);

        PedidoDAO dao = new PedidoDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(ped);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(ped);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("PedidoControlador");
    }
    
    public Date convierteFecha(String fecha)
    {
        Date fechaBD = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date (fechaTMP.getTime());
        } catch (ParseException ex) {
            Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return fechaBD;
    }

}
