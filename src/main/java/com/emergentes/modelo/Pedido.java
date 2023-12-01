
package com.emergentes.modelo;

import java.sql.Date;

public class Pedido {
    private int id;
    private Date fechaPedido;
    private String cliente;
    private String repVenta; 
    private String fabrica;
    private String producto;
    private int cantidad;

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRepVenta() {
        return repVenta;
    }

    public void setRepVenta(String repVenta) {
        this.repVenta = repVenta;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Pedidos{" + "id=" + id + ", fechaPedido=" + fechaPedido + ", cliente=" + cliente + ", repVenta=" + repVenta + ", fabrica=" + fabrica + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
    
}


