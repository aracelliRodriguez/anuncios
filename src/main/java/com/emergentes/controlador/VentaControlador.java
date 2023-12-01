
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.dao.VentaDAO;
import com.emergentes.dao.VentaDAOimpl;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Venta;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        VentaDAO dao = new VentaDAOimpl();
        ProductoDAO daoProducto = new ProductoDAOimpl();
        ClienteDAO daoCliente = new ClienteDAOimpl();
        int id;
        List<Producto> lista_productos = null;
        List<Cliente> lista_clientes = null;
        Venta venta = new Venta();
        

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            System.out.println("Opcion = " + action);
        switch (action) {
            case "add":
                lista_productos = daoProducto.getAll();
                lista_clientes = daoCliente.getAll();
                request.setAttribute("lista_productos", lista_productos);
                request.setAttribute("lista_clientes", lista_clientes);
                request.setAttribute("venta", venta);
                request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                
                    //obtener el objeto que corresponde al registro
                     venta = dao.getById(id);
                     lista_productos = daoProducto.getAll();
                     lista_clientes = daoCliente.getAll();
                     //colocar como atributo
                     request.setAttribute("lista_productos", lista_productos);
                     request.setAttribute("lista_clientes", lista_clientes);
                     request.setAttribute("venta", venta);
                     //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmventa.jsp").forward(request, response);
                break;
              
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                response.sendRedirect("VentaController");
                break;

            case "view":
                List<Venta> lista = dao.getAll();
                request.setAttribute("ventas", lista);
                request.getRequestDispatcher("ventas.jsp").forward(request, response);
                break;
        }
        }catch(Exception ex){
            System.out.println("Error fatal " + ex.getMessage());
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int cliente_id = Integer.parseInt(request.getParameter("cliente_id"));
        int producto_id = Integer.parseInt(request.getParameter("producto_id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        int total = Integer.parseInt(request.getParameter("total"));
        String fecha = request.getParameter("fecha");
        
        Venta venta = new Venta();

        venta.setId(id);
        venta.setCliente_id(cliente_id);
        venta.setProducto_id(producto_id);
        venta.setCantidad(cantidad);
        venta.setTotal(total);
        venta.setFecha(convierteFecha(fecha));
        
         

        if (id == 0) {
            VentaDAO dao = new VentaDAOimpl();
            try {
                //nuevo
                dao.insert(venta);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            VentaDAO dao = new VentaDAOimpl();
            try {
                //nuevo
                dao.update(venta);
                response.sendRedirect("VentaControlador");
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        }
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
       


