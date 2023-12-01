
package com.emergentes.controlador;

import com.emergentes.dao.ProveedorDAO;
import com.emergentes.dao.ProveedorDAOimpl;
import com.emergentes.modelo.Proveedor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProveedorDAO dao = new ProveedorDAOimpl();

        Proveedor pr = new Proveedor();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("proveedor", pr);
                request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    //obtener el objeto que corresponde al registro
                    pr = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                //colocar como atributo
                request.setAttribute("proveedor", pr);
                //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmproveedor.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("ProveedorControlador");
                break;

            case "view":
                List<Proveedor> lista = new ArrayList<Proveedor>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar " + ex.getMessage());
                }
                request.setAttribute("proveedores", lista);
                request.getRequestDispatcher("proveedores.jsp").forward(request, response);
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
        String fabrica = request.getParameter("fabrica");
        String direccion = request.getParameter("direccion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));

        Proveedor pr = new Proveedor();

        pr.setId(id);
        pr.setNombre(nombre);
        pr.setFabrica(fabrica);
        pr.setDireccion(direccion);
        pr.setTelefono(telefono);

        ProveedorDAO dao = new ProveedorDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(pr);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(pr);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("ProveedorControlador");
    }

    }



