package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import interfaces.VentaRepository;
import modelo.Venta;

public class VentaControlador implements VentaRepository {
    private final Connection connection;

    public VentaControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public LinkedList<Venta> getAllVentas() {
        LinkedList<Venta> ventas = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Ventas");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Venta venta = new Venta();
                venta.setId_venta(resultSet.getInt("ID_Venta"));
                venta.setId_cliente(resultSet.getInt("ID_Cliente"));
                venta.setId_pedido(resultSet.getInt("ID_Pedido"));
                venta.setFecha_venta(resultSet.getDate("Fecha_Venta").toLocalDate());
                venta.setId_stock(resultSet.getInt("ID_Stock"));
                venta.setCantidad_vendida(resultSet.getInt("Cantidad_Vendida"));
                venta.setTotal_venta(resultSet.getDouble("Total_Venta"));
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    @Override
    public Venta getVentaById(int id_venta) {
        Venta venta = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Ventas WHERE ID_Venta = ?");
            statement.setInt(1, id_venta);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                venta = new Venta();
                venta.setId_venta(resultSet.getInt("ID_Venta"));
                venta.setId_cliente(resultSet.getInt("ID_Cliente"));
                venta.setId_pedido(resultSet.getInt("ID_Pedido"));
                venta.setFecha_venta(resultSet.getDate("Fecha_Venta").toLocalDate());
                venta.setId_stock(resultSet.getInt("ID_Stock"));
                venta.setCantidad_vendida(resultSet.getInt("Cantidad_Vendida"));
                venta.setTotal_venta(resultSet.getDouble("Total_Venta"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return venta;
    }

    @Override
    public void addVenta(Venta venta) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Ventas (ID_Cliente, ID_Pedido, Fecha_Venta, ID_Stock, Cantidad_Vendida, Total_Venta) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, venta.getId_cliente());
            statement.setInt(2, venta.getId_pedido());
            statement.setDate(3, Date.valueOf(venta.getFecha_venta()));
            statement.setInt(4, venta.getId_stock());
            statement.setInt(5, venta.getCantidad_vendida());
            statement.setDouble(6, venta.getTotal_venta());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Venta añadida exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVenta(Venta venta) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Ventas SET ID_Cliente = ?, ID_Pedido = ?, Fecha_Venta = ?, ID_Stock = ?, Cantidad_Vendida = ?, Total_Venta = ? WHERE ID_Venta = ?");
            statement.setInt(1, venta.getId_cliente());
            statement.setInt(2, venta.getId_pedido());
            statement.setDate(3, Date.valueOf(venta.getFecha_venta()));
            statement.setInt(4, venta.getId_stock());
            statement.setInt(5, venta.getCantidad_vendida());
            statement.setDouble(6, venta.getTotal_venta());
            statement.setInt(7, venta.getId_venta());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Venta actualizada exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVenta(int id_venta) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Ventas WHERE ID_Venta = ?");
            statement.setInt(1, id_venta);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Venta eliminada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar la venta.");
        }
    }
}
