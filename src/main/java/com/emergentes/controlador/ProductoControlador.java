
package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimpl;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ProductoDAO dao = new ProductoDAOimpl();

        Producto prod = new Producto();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("producto", prod);
                request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    //obtener el objeto que corresponde al registro
                    prod = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                //colocar como atributo
                request.setAttribute("producto", prod);
                //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmproducto.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("ProductoController");
                break;

            case "view":
                List<Producto> lista = new ArrayList<Producto>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar " + ex.getMessage());
                }
                request.setAttribute("productos", lista);
                request.getRequestDispatcher("productos.jsp").forward(request, response);
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
        String descripcion = request.getParameter("descripcion");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        int existenciaAlm = Integer.parseInt(request.getParameter("existenciaAlm"));

        Producto prod = new Producto();

        prod.setId(id);
        prod.setNombre(nombre);
        prod.setFabrica(fabrica);
        prod.setDescripcion(descripcion);
        prod.setPrecio(precio);
        prod.setExistenciaAlm(existenciaAlm);

        ProductoDAO dao = new ProductoDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(prod);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(prod);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("ProductoController");
    }
    }



