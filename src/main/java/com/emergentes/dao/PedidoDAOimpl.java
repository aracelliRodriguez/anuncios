
package com.emergentes.dao;

import com.emergentes.modelo.Pedido;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOimpl extends ConexionDB implements PedidoDAO{
    
    @Override
    public void insert(Pedido pedido) throws Exception {
            
            String sql = "insert into pedidos (fechaPedido,cliente,repVenta,fabrica,producto,cantidad) values (?,?,?,?,?,?)";
            this.conectar ();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setDate(1, pedido.getFechaPedido());
            ps.setString(2, pedido.getCliente());
            ps.setString(3, pedido.getRepVenta());
            ps.setString(4, pedido.getFabrica());
            ps.setString(5, pedido.getProducto());
            ps.setInt(6, pedido.getCantidad());
            ps.executeUpdate();
            this.desconectar();
    }

    @Override
    public void update(Pedido pedido) throws Exception {
            
            String sql = "update pedidos set fechaPedido=?, cliente=?, repVenta=?, fabrica=?, producto=?, cantidad=? where id = ?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setDate(1, pedido.getFechaPedido());
            ps.setString(2, pedido.getCliente());
            ps.setString(3, pedido.getRepVenta());
            ps.setString(4, pedido.getFabrica());
            ps.setString(5, pedido.getProducto());
            ps.setInt(6, pedido.getCantidad());
            ps.setInt(7, pedido.getId());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void delete(int id) throws Exception {
        try {
        this.conectar();
        String sql = "delete from pedidos where id=?";
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
    public List<Pedido> getAll() throws Exception {
        List<Pedido> lista = null;
        this.conectar();
        String sql = "select * from pedidos";
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Pedido>();
        while (rs.next()) {
            Pedido pe = new Pedido();

                pe.setId(rs.getInt("id"));
                pe.setFechaPedido(rs.getDate("fechaPedido"));
                pe.setCliente(rs.getString("cliente"));
                pe.setRepVenta(rs.getString("repVenta"));
                pe.setFabrica(rs.getString("fabrica"));
                pe.setProducto(rs.getString("producto"));
                pe.setCantidad(rs.getInt("cantidad"));
            lista.add(pe);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Pedido getById(int id) throws Exception {
        Pedido pe = new Pedido();
        try {
            this.conectar();
            String sql = "select * from pedidos where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pe.setId(rs.getInt("id"));
                pe.setFechaPedido(rs.getDate("fechaPedido"));
                pe.setCliente(rs.getString("cliente"));
                pe.setRepVenta(rs.getString("repVenta"));
                pe.setFabrica(rs.getString("fabrica"));
                pe.setProducto(rs.getString("producto"));
                pe.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return pe;
    }
}
