package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import interfaces.ZapatoRepository;
import modelo.Zapato;

public class ZapatoControlador implements ZapatoRepository {
    private final Connection connection;

    public ZapatoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public LinkedList<Zapato> getAllZapatos() {
        LinkedList<Zapato> zapatos = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Zapatos");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Zapato zapato = new Zapato();
                zapato.setId_zapato(resultSet.getInt("ID_Zapato"));
                zapato.setNombre(resultSet.getString("Nombre"));
                zapato.setColor(resultSet.getString("Color"));
                zapato.setNumero(resultSet.getDouble("Numero"));
                zapato.setPrecio(resultSet.getDouble("Precio"));
                zapato.setCategoria(resultSet.getString("Categoria"));
                zapatos.add(zapato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zapatos;
    }

    @Override
    public Zapato getZapatoById(int id_zapato) {
        Zapato zapato = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Zapatos WHERE ID_Zapato = ?");
            statement.setInt(1, id_zapato);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                zapato = new Zapato();
                zapato.setId_zapato(resultSet.getInt("ID_Zapato"));
                zapato.setNombre(resultSet.getString("Nombre"));
                zapato.setColor(resultSet.getString("Color"));
                zapato.setNumero(resultSet.getDouble("Numero"));
                zapato.setPrecio(resultSet.getDouble("Precio"));
                zapato.setCategoria(resultSet.getString("Categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zapato;
    }

    @Override
    public void addZapato(Zapato zapato) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Zapatos (Nombre, Color, Numero, Precio, Categoria) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, zapato.getNombre());
            statement.setString(2, zapato.getColor());
            statement.setDouble(3, zapato.getNumero());
            statement.setDouble(4, zapato.getPrecio());
            statement.setString(5, zapato.getCategoria());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Zapato añadido exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateZapato(Zapato zapato) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Zapatos SET Nombre = ?, Color = ?, Numero = ?, Precio = ?, Categoria = ? WHERE ID_Zapato = ?");
            statement.setString(1, zapato.getNombre());
            statement.setString(2, zapato.getColor());
            statement.setDouble(3, zapato.getNumero());
            statement.setDouble(4, zapato.getPrecio());
            statement.setString(5, zapato.getCategoria());
            statement.setInt(6, zapato.getId_zapato());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Zapato actualizado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteZapato(int id_zapato) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Zapatos WHERE ID_Zapato = ?");
            statement.setInt(1, id_zapato);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Zapato eliminado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el zapato.");
        }
    }
}
