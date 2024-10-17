package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import interfaces.ClienteRepository;
import modelo.Cliente;

public class ClienteControlador implements ClienteRepository {
    private final Connection connection;

    public ClienteControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public LinkedList<Cliente> getAllClientes() {
        LinkedList<Cliente> clientes = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("correo"),
                    resultSet.getString("telefono"),
                    resultSet.getString("direccion"),
                    resultSet.getInt("dni")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente getClienteByDNI(int dni) {
        Cliente cliente = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE dni = ?");
            statement.setInt(1, dni);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("correo"),
                    resultSet.getString("telefono"),
                    resultSet.getString("direccion"),
                    resultSet.getInt("dni")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public Cliente getClienteById(int id_cliente) {
        Cliente cliente = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente WHERE id_cliente = ?");
            statement.setInt(1, id_cliente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(
                    resultSet.getInt("id_cliente"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellido"),
                    resultSet.getString("correo"),
                    resultSet.getString("telefono"),
                    resultSet.getString("direccion"),
                    resultSet.getInt("dni")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void addCliente(Cliente cliente) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cliente (nombre, apellido, correo, telefono, direccion, dni) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getCorreo());
            statement.setString(4, cliente.getTelefono());
            statement.setString(5, cliente.getDireccion());
            statement.setInt(6, cliente.getDni());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cliente insertado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCliente(Cliente cliente) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, correo = ?, telefono = ?, direccion = ?, dni = ? WHERE id_cliente = ?");
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getCorreo());
            statement.setString(4, cliente.getTelefono());
            statement.setString(5, cliente.getDireccion());
            statement.setInt(6, cliente.getDni());
            statement.setInt(7, cliente.getId_cliente());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cliente actualizado exitosamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(int id_cliente) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            statement.setInt(1, id_cliente);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente");
        }
    }
}
