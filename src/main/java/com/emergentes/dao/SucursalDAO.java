
package com.emergentes.dao;

import com.emergentes.modelo.Sucursal;
import java.util.List;

public interface SucursalDAO {
    public void insert(Sucursal sucursal)throws Exception;
    public void update(Sucursal sucursal)throws Exception;
    public void delete(int id)throws Exception;
    public List<Sucursal> getAll() throws Exception;
    public Sucursal getById(int id) throws Exception;
}
