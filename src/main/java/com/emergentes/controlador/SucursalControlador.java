
package com.emergentes.controlador;

import com.emergentes.dao.SucursalDAO;
import com.emergentes.dao.SucursalDAOimpl;
import com.emergentes.modelo.Sucursal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SucursalControlador", urlPatterns = {"/SucursalControlador"})
public class SucursalControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SucursalDAO dao = new SucursalDAOimpl();

        Sucursal suc = new Sucursal();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("sucursal", suc);
                request.getRequestDispatcher("frmsucursal.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    //obtener el objeto que corresponde al registro
                    suc = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                //colocar como atributo
                request.setAttribute("sucursal", suc);
                //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmsucursal.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("SucursalControlador");
                break;

            case "view":
                List<Sucursal> lista = new ArrayList<Sucursal>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar " + ex.getMessage());
                }
                request.setAttribute("sucursales", lista);
                request.getRequestDispatcher("sucursales.jsp").forward(request, response);
                break;
            default:
                break;
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String ciudad = request.getParameter("ciudad");
        String director = request.getParameter("director");
        int objetivoVen = Integer.parseInt(request.getParameter("objetivoVen"));
        int ventaReal = Integer.parseInt(request.getParameter("ventaReal"));

        Sucursal suc = new Sucursal();

        suc.setId(id);
        suc.setCiudad(ciudad);
        suc.setDirector(director);
        suc.setObjetivoVen(objetivoVen);
        suc.setVentaReal(ventaReal);

        SucursalDAO dao = new SucursalDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(suc);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(suc);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("SucursalControlador");
    }

    }



