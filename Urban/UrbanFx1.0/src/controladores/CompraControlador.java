package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import interfaces.CompraRepository;
import modelo.Compra;

public class CompraControlador implements CompraRepository {
    private final Connection connection;

    public CompraControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public LinkedList<Compra> getAllCompras() {
        LinkedList<Compra> compras = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Compras");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Compra compra = new Compra();
                compra.setId_compra(resultSet.getInt("ID_Compra"));
                compra.setId_zapato(resultSet.getInt("ID_Zapato"));
                compra.setCantidad(resultSet.getInt("Cantidad"));
                compra.setFecha_entrada(resultSet.getDate("Fecha_Entrada"));
                compras.add(compra);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }

    @Override
    public Compra getCompraById(int id_compra) {
        Compra compra = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Compras WHERE ID_Compra = ?");
            statement.setInt(1, id_compra);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                compra = new Compra();
                compra.setId_compra(resultSet.getInt("ID_Compra"));
                compra.setId_zapato(resultSet.getInt("ID_Zapato"));
                compra.setCantidad(resultSet.getInt("Cantidad"));
                compra.setFecha_entrada(resultSet.getDate("Fecha_Entrada"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compra;
    }

    @Override
    public void addCompra(Compra compra) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Compras (ID_Zapato, Cantidad, Fecha_Entrada) VALUES (?, ?, ?)");
            statement.setInt(1, compra.getId_zapato());
            statement.setInt(2, compra.getCantidad());
            statement.setDate(3, compra.getFecha_entrada());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Compra añadida exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCompra(Compra compra) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Compras SET ID_Zapato = ?, Cantidad = ?, Fecha_Entrada = ? WHERE ID_Compra = ?");
            statement.setInt(1, compra.getId_zapato());
            statement.setInt(2, compra.getCantidad());
            statement.setDate(3, compra.getFecha_entrada());
            statement.setInt(4, compra.getId_compra());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Compra actualizada exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompra(int id_compra) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Compras WHERE ID_Compra = ?");
            statement.setInt(1, id_compra);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Compra eliminada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la compra.");
        }
    }
}
