package modelo;

public class Zapato {
    private int id_zapato;
    private String nombre;
    private String color;
    private double numero;
    private double precio;
    private String categoria;

    public Zapato() {}

    public Zapato(String nombre, String color, double numero, double precio, String categoria) {
        this.nombre = nombre;
        this.color = color;
        this.numero = numero;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getId_zapato() {
        return id_zapato;
    }

    public void setId_zapato(int id_zapato) {
        this.id_zapato = id_zapato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Zapato: ID=" + id_zapato + ", Nombre=" + nombre + ", Color=" + color + ", Numero=" + numero + ", Precio=" + precio + ", Categoria=" + categoria;
    }
}
