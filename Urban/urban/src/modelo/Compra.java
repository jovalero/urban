package modelo;

import java.sql.Date;

public class Compra {

    private int id_compra;
    private int id_zapato;
    private int cantidad;
    private Date fecha_entrada;

    public Compra() {}

    public Compra(int id_zapato, int cantidad, Date fecha_entrada) {
        this.id_zapato = id_zapato;
        this.cantidad = cantidad;
        this.fecha_entrada = fecha_entrada;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_zapato() {
        return id_zapato;
    }

    public void setId_zapato(int id_zapato) {
        this.id_zapato = id_zapato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    @Override
    public String toString() {
        return "Compra: ID=" + id_compra + ", ID Zapato=" + id_zapato + ", Cantidad=" + cantidad + ", Fecha Entrada=" + fecha_entrada;
    }
}
