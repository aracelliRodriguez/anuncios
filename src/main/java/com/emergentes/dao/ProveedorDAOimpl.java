
package com.emergentes.dao;

import com.emergentes.modelo.Proveedor;
import com.emergentes.modelo.Proveedor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAOimpl extends ConexionDB implements ProveedorDAO{
    
    @Override
    public void insert(Proveedor proveedor) throws Exception {
            
            String sql = "insert into proveedores (nombre,fabrica,direccion,telefono) values (?,?,?,?)";
            this.conectar ();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getFabrica());
            ps.setString(3, proveedor.getDireccion());                                                                                                                                                                                  
            ps.setInt(4, proveedor.getTelefono());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void update(Proveedor proveedor) throws Exception {
            
            String sql = "update proveedores set nombre=?, fabrica=?, direccion=?, telefono=? where id = ?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getFabrica());
            ps.setString(3, proveedor.getDireccion());
            ps.setInt(4, proveedor.getTelefono());
            ps.setInt(5, proveedor.getId());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void delete(int id) throws Exception {
        try {
        String sql = "delete from proveedores where id=?";
        this.conectar();
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
    public List<Proveedor> getAll() throws Exception {
        List<Proveedor> lista = null;
        String sql = "select * from proveedores";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Proveedor>();
        while (rs.next()) {
            Proveedor prov = new Proveedor();

                prov.setId(rs.getInt("id"));
                prov.setNombre(rs.getString("nombre"));
                prov.setFabrica(rs.getString("fabrica"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getInt("telefono"));

            lista.add(prov);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Proveedor getById(int id) throws Exception {
        Proveedor prov = new Proveedor();
        try {
            this.conectar();
            String sql = "select * from proveedores where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prov.setId(rs.getInt("id"));
                prov.setNombre(rs.getString("nombre"));
                prov.setFabrica(rs.getString("fabrica"));
                prov.setDireccion(rs.getString("direccion"));
                prov.setTelefono(rs.getInt("telefono"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return prov;
    }
}
