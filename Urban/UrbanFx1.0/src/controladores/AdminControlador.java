package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import interfaces.AdminRepository;
import modelo.Admin;

public class AdminControlador implements AdminRepository {
    private final Connection connection;

    public AdminControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }
    
    @Override
    public LinkedList<Admin> getAllAdmins() {
        LinkedList<Admin> admins = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Admin");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Admin admin = new Admin(
                    resultSet.getString("Nombre"),
                    resultSet.getString("Apellido"),
                    resultSet.getString("DNI"),
                    resultSet.getString("Usuario"),
                    resultSet.getString("Contrasena")
                );
                admin.setIdAdmin(resultSet.getInt("ID_Admin"));
                admins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admins;
    }

    @Override
    public Admin getAdminByDni(String dni) {
        Admin admin = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Admin WHERE DNI = ?");
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                admin = new Admin(
                    resultSet.getString("Nombre"),
                    resultSet.getString("Apellido"),
                    resultSet.getString("DNI"),
                    resultSet.getString("Usuario"),
                    resultSet.getString("Contrasena")
                );
                admin.setIdAdmin(resultSet.getInt("ID_Admin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public void addAdmin(Admin admin) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Admin (Nombre, Apellido, DNI, Usuario, Contrasena) VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, admin.getNombre());
            statement.setString(2, admin.getApellido());
            statement.setString(3, admin.getDni());
            statement.setString(4, admin.getUsuario());
            statement.setString(5, admin.getContrasena());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Administrador insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "UPDATE Admin SET Nombre = ?, Apellido = ?, DNI = ?, Usuario = ?, Contrasena = ? WHERE ID_Admin = ?"
            );
            statement.setString(1, admin.getNombre());
            statement.setString(2, admin.getApellido());
            statement.setString(3, admin.getDni());
            statement.setString(4, admin.getUsuario());
            statement.setString(5, admin.getContrasena());
            statement.setInt(6, admin.getIdAdmin());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Administrador actualizado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAdmin(int idAdmin) {
        try {  
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Admin WHERE ID_Admin = ?");
            statement.setInt(1, idAdmin);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Administrador eliminado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
