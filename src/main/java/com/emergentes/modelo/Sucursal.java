
package com.emergentes.modelo;

public class Sucursal {
    private int id;
    private String ciudad;
    private String director;
    private int objetivoVen;
    private int ventaReal;

    public Sucursal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getObjetivoVen() {
        return objetivoVen;
    }

    public void setObjetivoVen(int objetivoVen) {
        this.objetivoVen = objetivoVen;
    }

    public int getVentaReal() {
        return ventaReal;
    }

    public void setVentaReal(int ventaReal) {
        this.ventaReal = ventaReal;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", ciudad=" + ciudad + ", director=" + director + ", objetivoVen=" + objetivoVen + ", ventaReal=" + ventaReal + '}';
    }
    
    
}
