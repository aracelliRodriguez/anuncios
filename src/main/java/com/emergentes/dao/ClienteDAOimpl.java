package com.emergentes.dao;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOimpl extends ConexionDB implements ClienteDAO {

     @Override
    public void insert(Cliente cliente) throws Exception {
            this.conectar ();
            String sql = "insert into clientes (nombre,apellido,direccion,correo,celular,fechanac) values (?,?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getCelular());
            ps.setDate(6, cliente.getFechanac());
            ps.executeUpdate();
            this.desconectar();
        }
    

    @Override
    public void update(Cliente cliente) throws Exception {
            
            String sql = "update clientes set nombre=?, apellido=?, direccion=?, correo=? celular=?, fechanac=? where id = ?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getCelular());
            ps.setDate(6, cliente.getFechanac());
            ps.setInt(7, cliente.getId());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void delete(int id) throws Exception {
        
        String sql = "delete from clientes where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public List<Cliente> getAll() throws Exception {
        List<Cliente> lista = null;
        String sql = "select * from clientes";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Cliente>();
        while (rs.next()) {
            Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreo(rs.getString("correo"));
                c.setCelular(rs.getString("celular"));
                c.setFechanac(rs.getDate("fechanac"));

            lista.add(c);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Cliente getById(int id) throws Exception {
        Cliente c = new Cliente();
        try {
            this.conectar();
            String sql = "select * from clientes where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreo(rs.getString("correo"));
                c.setCelular(rs.getString("celular"));
                c.setFechanac(rs.getDate("fechanac"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return c;
    }
}
