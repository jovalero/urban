package modelo;

import java.time.LocalDate;

public class Pedido {
    private int id_pedido;
    private int id_cliente;
    private LocalDate fecha_pedido;
    private int id_zapato;
    private int cantidad;
    private String estado;
    private double total_pedido;

    public Pedido() {}

    public Pedido(int id_cliente, LocalDate fecha_pedido, int id_zapato, int cantidad, String estado, double total_pedido) {
        this.id_cliente = id_cliente;
        this.fecha_pedido = fecha_pedido;
        this.id_zapato = id_zapato;
        this.cantidad = cantidad;
        this.estado = estado;
        this.total_pedido = total_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public LocalDate getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(LocalDate fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(double total_pedido) {
        this.total_pedido = total_pedido;
    }

    @Override
    public String toString() {
        return "Pedido: ID=" + id_pedido + ", ID Cliente=" + id_cliente + ", Fecha Pedido=" + fecha_pedido +
               ", ID Zapato=" + id_zapato + ", Cantidad=" + cantidad + ", Estado=" + estado + ", Total Pedido=" + total_pedido;
    }
}
