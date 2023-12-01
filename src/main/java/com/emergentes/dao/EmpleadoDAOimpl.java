
package com.emergentes.dao;

import com.emergentes.modelo.Empleado;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOimpl extends ConexionDB implements EmpleadoDAO{
    @Override
    public void insert(Empleado empleado) throws Exception {
            
            String sql = "insert into empleados (nombre,apellido,cargo,direcion,telefono,edad,fechaContrato) values (?,?,?,?,?,?,?)";
            this.conectar ();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCargo());
            ps.setString(4, empleado.getDireccion());
            ps.setInt(5, empleado.getTelefono());
            ps.setInt(6, empleado.getEdad());
            ps.setDate(7, empleado.getFechaContrato());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void update(Empleado empleado) throws Exception {
            
            String sql = "update empleados set nombre=?, apellido=?, cargo=?, direcion=?, telefono=?, edad=?, fechaContrato=? where id = ?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCargo());
            ps.setString(4, empleado.getDireccion());
            ps.setInt(5, empleado.getTelefono());
            ps.setInt(6, empleado.getEdad());
            ps.setDate(7, empleado.getFechaContrato());
            ps.setInt(8, empleado.getId());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void delete(int id) throws Exception {
        try {
        this.conectar();
        String sql = "delete empleados where id=?";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Empleado> getAll() throws Exception {
        List<Empleado> lista = null;
        String sql = "select * from empleados";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Empleado>();
        while (rs.next()) {
            Empleado emp = new Empleado();

                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setCargo(rs.getString("cargo"));
                emp.setDireccion(rs.getString("direcion"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setEdad(rs.getInt("edad"));
                emp.setFechaContrato(rs.getDate("fechaContrato"));
                
            lista.add(emp);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Empleado getById(int id) throws Exception {
        Empleado emp = new Empleado();
        try {
            this.conectar();
            String sql = "select * from empleados where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setCargo(rs.getString("cargo"));
                emp.setDireccion(rs.getString("direcion"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setEdad(rs.getInt("edad"));
                emp.setFechaContrato(rs.getDate("fechaContrato"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return emp;
    }
}
