package modelo;

import java.time.LocalDate;

public class Venta {
    private int id_venta;
    private int id_cliente;
    private int id_pedido;
    private LocalDate fecha_venta;
    private int id_stock;
    private int cantidad_vendida;
    private double total_venta;

    public Venta() {}

    public Venta(int id_cliente, int id_pedido, LocalDate fecha_venta, int id_stock, int cantidad_vendida, double total_venta) {
        this.id_cliente = id_cliente;
        this.id_pedido = id_pedido;
        this.fecha_venta = fecha_venta;
        this.id_stock = id_stock;
        this.cantidad_vendida = cantidad_vendida;
        this.total_venta = total_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    @Override
    public String toString() {
        return "Venta: ID=" + id_venta + ", ID Cliente=" + id_cliente + ", ID Pedido=" + id_pedido + 
               ", Fecha Venta=" + fecha_venta + ", ID Stock=" + id_stock + ", Cantidad Vendida=" + 
               cantidad_vendida + ", Total Venta=" + total_venta;
    }
}
