
package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimpl;
import com.emergentes.modelo.Cliente;
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

@WebServlet(name = "ClienteControlador", urlPatterns = {"/ClienteControlador"})
public class ClienteControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClienteDAO dao = new ClienteDAOimpl();

        Cliente cli = new Cliente();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("cliente", cli);
                request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    //obtener el objeto que corresponde al registro
                    cli = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                //colocar como atributo
                request.setAttribute("cliente", cli);
                //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmcliente.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("ClienteControlador");
                break;

            case "view":
                List<Cliente> lista = new ArrayList<Cliente>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar " + ex.getMessage());
                }
                request.setAttribute("clientes", lista);
                request.getRequestDispatcher("clientes.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String celular = request.getParameter("celular");
        String fechanac = request.getParameter("fechanac");
        
        Cliente cli = new Cliente();

        cli.setId(id);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDireccion(direccion);
        cli.setCorreo(correo);
        cli.setCelular(celular);
        cli.setFechanac(convierteFecha(fechanac));

        ClienteDAO dao = new ClienteDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(cli);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(cli);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("ClienteControlador");
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
