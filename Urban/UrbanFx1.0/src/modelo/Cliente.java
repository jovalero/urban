package modelo;

import javax.swing.JOptionPane;

import controladores.ClienteControlador;


public class Cliente {
    
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private int dni; // Nuevo atributo

    // Constructor vacío
    public Cliente() {
    }

    // Constructor completo
    public Cliente(int id_cliente, String nombre, String apellido, String correo, String telefono, String direccion, int dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
    }

    // Constructor sin ID (para nuevos registros)
    public Cliente(String nombre, String apellido, String correo, String telefono, String direccion, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
    }

    // Getters y Setters
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente: " + this.nombre + " " + this.apellido + " DNI: " + this.dni + " Correo: " + this.correo + " ID: " + this.id_cliente;
    }

    public void Menu() {
        JOptionPane.showMessageDialog(null, "Hola");
        ClienteControlador controlador = new ClienteControlador();
    }
}
