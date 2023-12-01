
package com.emergentes.controlador;

import com.emergentes.dao.EmpleadoDAO;
import com.emergentes.dao.EmpleadoDAOimpl;
import com.emergentes.modelo.Empleado;
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

@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/EmpleadoControlador"})
public class EmpleadoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EmpleadoDAO dao = new EmpleadoDAOimpl();

        Empleado emp = new Empleado();
        int id;

        String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
        switch (action) {
            case "add":
                request.setAttribute("empleado", emp);
                request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                break;
            case "edit":
                //AvisoController?action=edit&id=3
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    //obtener el objeto que corresponde al registro
                    emp = dao.getById(id);
                } catch (Exception ex) {
                    System.out.println("Error al obtener registro " + ex.getMessage());
                }
                //colocar como atributo
                request.setAttribute("empleado", emp);
                //transferir el control a frmaviso.jsp
                request.getRequestDispatcher("frmempleado.jsp").forward(request, response);
                break;

            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                try {
                    dao.delete(id);
                } catch (Exception ex) {
                    System.out.println("Error al eliminar: " + ex.getMessage());
                }
                response.sendRedirect("EmpleadoControlador");
                break;

            case "view":
                List<Empleado> lista = new ArrayList<Empleado>();
                try {
                    lista = dao.getAll();
                } catch (Exception ex) {
                    System.out.println("Error al listar " + ex.getMessage());
                }
                request.setAttribute("empleados", lista);
                request.getRequestDispatcher("empleados.jsp").forward(request, response);
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
        String cargo = request.getParameter("cargo");
        String direcion = request.getParameter("direcion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        String fechaContrato = request.getParameter("fechaContrato");

        Empleado emp = new Empleado();

        emp.setId(id);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setCargo(cargo);
        emp.setDireccion(direcion);
        emp.setTelefono(telefono);
        emp.setEdad(edad);
        emp.setFechaContrato(convierteFecha(fechaContrato));

        EmpleadoDAO dao = new EmpleadoDAOimpl();

        if (id == 0) {
            try {
                //nuevo
                dao.insert(emp);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ ex.getMessage());
            }
        } else {
            try {
                //edicion
                dao.update(emp);
            } catch (Exception ex) {
                System.out.println("Error al editar" + ex.getMessage());
            }
        }
        response.sendRedirect("EmpleadoControlador");
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



