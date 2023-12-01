
package com.emergentes.modelo;

public class Producto {
    private int id;
    private String nombre;
    private String fabrica;
    private String descripcion;
    private float precio;
    private int existenciaAlm;

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabrica() {
        return fabrica;
    }

    public void setFabrica(String fabrica) {
        this.fabrica = fabrica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistenciaAlm() {
        return existenciaAlm;
    }

    public void setExistenciaAlm(int existenciaAlm) {
        this.existenciaAlm = existenciaAlm;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", fabrica=" + fabrica + ", descripcion=" + descripcion + ", precio=" + precio + ", existenciaAlm=" + existenciaAlm + '}';
    }
    
}