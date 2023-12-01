
package com.emergentes.dao;

import com.emergentes.modelo.Venta;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOimpl extends ConexionDB implements VentaDAO{
    
    @Override
    public void insert(Venta venta) throws Exception {
            this.conectar ();
            String sql = "insert into ventas (producto_id,cliente_id,cantidad,total,fecha) values (?,?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setInt(3, venta.getCantidad());
            ps.setInt(4, venta.getTotal());
            ps.setDate(5, venta.getFecha());
            ps.executeUpdate();
            this.desconectar();
    }

    @Override
    public void update(Venta venta) throws Exception {
            this.conectar();
            String sql = "update ventas set producto_id=?, cliente_id=?, cantidad=?, total=?, fecha=? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, venta.getProducto_id());
            ps.setInt(2, venta.getCliente_id());
            ps.setInt(3, venta.getCantidad());
            ps.setInt(4, venta.getTotal());
            ps.setDate(5, venta.getFecha());
            ps.setInt(6, venta.getId());
            ps.executeUpdate();
            this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        try {
        this.conectar();
        String sql = "delete from ventas where id=?";
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
    public List<Venta> getAll() throws Exception {
        List<Venta> lista = null;
        this.conectar();
        String sql = "SELECT v.*,p.nombre as producto, c.nombre as cliente FROM ventas v ";
                     sql += "LEFT JOIN productos p ON v.producto_id = p.id "; 
                     sql += "LEFT JOIN clientes c ON v.cliente_id = c.id ";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Venta>();
        while (rs.next()) {
            Venta v = new Venta();

                v.setId(rs.getInt("id"));
                v.setProducto_id(rs.getInt("producto_id"));
                v.setCliente_id(rs.getInt("cliente_id"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setTotal(rs.getInt("total"));
                v.setFecha(rs.getDate("fecha"));
                v.setCliente(rs.getString("cliente"));
                v.setProducto(rs.getString("producto"));

            lista.add(v);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Venta getById(int id) throws Exception {
        Venta v = new Venta();
        try {
            this.conectar();
            String sql = "select * from ventas where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setProducto_id(rs.getInt("producto_id"));
                v.setCliente_id(rs.getInt("cliente_id"));
                v.setCantidad(rs.getInt("cantidad"));
                v.setTotal(rs.getInt("total"));
                v.setFecha(rs.getDate("fecha"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return v;
    }
}
