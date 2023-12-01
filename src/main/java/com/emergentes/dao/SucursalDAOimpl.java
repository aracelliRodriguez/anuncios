
package com.emergentes.dao;

import com.emergentes.modelo.Sucursal;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAOimpl extends ConexionDB implements SucursalDAO{
    
    @Override
    public void insert(Sucursal sucursal) throws Exception {
            this.conectar ();
            String sql = "insert into sucursales (ciudad,director,objetivoVen,ventaReal) values (?,?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, sucursal.getCiudad());
            ps.setString(2, sucursal.getDirector());
            ps.setInt(3, sucursal.getObjetivoVen());
            ps.setInt(4, sucursal.getVentaReal());
            ps.executeUpdate();
            this.desconectar();
        }
    

    @Override
    public void update(Sucursal sucursal) throws Exception {
            
            String sql = "update sucursales set ciudad=?, director=?, objetivoVen=?, ventaReal=? where id = ?";
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, sucursal.getCiudad());
            ps.setString(2, sucursal.getDirector());
            ps.setInt(3, sucursal.getObjetivoVen());
            ps.setInt(4, sucursal.getVentaReal());
            ps.setInt(5, sucursal.getId());
            ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public void delete(int id) throws Exception {
        
        String sql = "delete from sucursales where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
            this.desconectar();
        }

    @Override
    public List<Sucursal> getAll() throws Exception {
        List<Sucursal> lista = null;
        String sql = "select * from sucursales";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        lista = new ArrayList<Sucursal>();
        while (rs.next()) {
            Sucursal s = new Sucursal();

                s.setId(rs.getInt("id"));
                s.setCiudad(rs.getString("ciudad"));
                s.setDirector(rs.getString("director"));
                s.setObjetivoVen(rs.getInt("objetivoVen"));
                s.setVentaReal(rs.getInt("ventaReal"));

            lista.add(s);
        }
            this.desconectar();
        return lista;
    }

    @Override
    public Sucursal getById(int id) throws Exception {
        Sucursal s = new Sucursal();
        try {
            this.conectar();
            String sql = "select * from sucursales where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setCiudad(rs.getString("ciudad"));
                s.setDirector(rs.getString("director"));
                s.setObjetivoVen(rs.getInt("objetivoVen"));
                s.setVentaReal(rs.getInt("ventaReal"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return s;
    }
}
