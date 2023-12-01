
package com.emergentes.dao;

import com.emergentes.modelo.Producto;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOimpl extends ConexionDB implements ProductoDAO {
    
    @Override
    public void insert(Producto producto) throws Exception {
            String sql = "insert into productos (nombre,fabrica,descripcion,precio,existenciaAlm) values (?,?,?,?,?)";
            this.conectar ();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getFabrica());
            ps.setString(3, producto.getDescripcion());
            ps.setFloat(4, producto.getPrecio());
            ps.setInt(5, producto.getExistenciaAlm());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void update(Producto producto) throws Exception {
            
            String sql = "update productos set nombre=?, fabrica=?, descripcion=?, precio=?, existenciaAlm=? where id = ?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getFabrica());
            ps.setString(3, producto.getDescripcion());
            ps.setFloat(4, producto.getPrecio());
            ps.setInt(5, producto.getExistenciaAlm());
            ps.setInt(6, producto.getId());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void delete(int id) throws Exception {
        try {
        this.conectar();
        String sql = "delete from productos where id=?";
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
    public List<Producto> getAll() throws Exception {
        List<Producto> lista = null;
        String sql = "select * from productos";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //inicializar la coleccion
        lista = new ArrayList<Producto>();
        while (rs.next()) {
            Producto p = new Producto();

                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setFabrica(rs.getString("fabrica"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getFloat("precio"));
                p.setExistenciaAlm(rs.getInt("existenciaAlm"));

            lista.add(p);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Producto getById(int id) throws Exception {
        Producto p = new Producto();
        try {
            this.conectar();
            String sql = "select * from productos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setFabrica(rs.getString("fabrica"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getFloat("Precio"));
                p.setExistenciaAlm(rs.getInt("existenciaAlm"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return p;
    }

    
}