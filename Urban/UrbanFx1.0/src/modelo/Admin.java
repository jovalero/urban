package modelo;

import java.util.LinkedList;
import java.util.List;

import controladores.AdminControlador;

public class Admin {
    private int idAdmin;
    private String nombre;
    private String apellido;
    private String dni;
    private String usuario;
    private String contrasena;

    public Admin() {
    }

    public Admin(String nombre, String apellido, String dni, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Admin: " + this.getNombre() + " " + this.getApellido() + " DNI: " + this.getDni();
    }
    
    public static Admin iniciarSesion( String usuario, String contrasena) {
    	AdminControlador admin= new AdminControlador();
    	LinkedList<Admin> lista= admin.getAllAdmins();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUsuario().equalsIgnoreCase(usuario) && lista.get(i).getContrasena().equals(contrasena)) {
                return lista.get(i); 
            }
        }
        return null;
    }
    
}
