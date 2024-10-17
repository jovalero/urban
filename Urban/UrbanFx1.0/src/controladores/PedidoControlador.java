package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import interfaces.PedidoRepository;
import modelo.Pedido;

public class PedidoControlador implements PedidoRepository {
    private final Connection connection;

    public PedidoControlador() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public LinkedList<Pedido> getAllPedidos() {
        LinkedList<Pedido> pedidos = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pedidos");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setId_pedido(resultSet.getInt("ID_Pedido"));
                pedido.setId_cliente(resultSet.getInt("ID_Cliente"));
                pedido.setFecha_pedido(resultSet.getDate("Fecha_Pedido").toLocalDate());
                pedido.setId_zapato(resultSet.getInt("ID_Zapato"));
                pedido.setCantidad(resultSet.getInt("Cantidad"));
                pedido.setEstado(resultSet.getString("Estado"));
                pedido.setTotal_pedido(resultSet.getDouble("Total_Pedido"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public Pedido getPedidoById(int id_pedido) {
        Pedido pedido = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Pedidos WHERE ID_Pedido = ?");
            statement.setInt(1, id_pedido);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                pedido = new Pedido();
                pedido.setId_pedido(resultSet.getInt("ID_Pedido"));
                pedido.setId_cliente(resultSet.getInt("ID_Cliente"));
                pedido.setFecha_pedido(resultSet.getDate("Fecha_Pedido").toLocalDate());
                pedido.setId_zapato(resultSet.getInt("ID_Zapato"));
                pedido.setCantidad(resultSet.getInt("Cantidad"));
                pedido.setEstado(resultSet.getString("Estado"));
                pedido.setTotal_pedido(resultSet.getDouble("Total_Pedido"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public void addPedido(Pedido pedido) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Pedidos (ID_Cliente, Fecha_Pedido, ID_Zapato, Cantidad, Estado, Total_Pedido) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, pedido.getId_cliente());
            statement.setDate(2, Date.valueOf(pedido.getFecha_pedido()));
            statement.setInt(3, pedido.getId_zapato());
            statement.setInt(4, pedido.getCantidad());
            statement.setString(5, pedido.getEstado());
            statement.setDouble(6, pedido.getTotal_pedido());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Pedido añadido exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePedido(Pedido pedido) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Pedidos SET ID_Cliente = ?, Fecha_Pedido = ?, ID_Zapato = ?, Cantidad = ?, Estado = ?, Total_Pedido = ? WHERE ID_Pedido = ?");
            statement.setInt(1, pedido.getId_cliente());
            statement.setDate(2, Date.valueOf(pedido.getFecha_pedido()));
            statement.setInt(3, pedido.getId_zapato());
            statement.setInt(4, pedido.getCantidad());
            statement.setString(5, pedido.getEstado());
            statement.setDouble(6, pedido.getTotal_pedido());
            statement.setInt(7, pedido.getId_pedido());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Pedido actualizado exitosamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePedido(int id_pedido) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Pedidos WHERE ID_Pedido = ?");
            statement.setInt(1, id_pedido);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Pedido eliminado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el pedido.");
        }
    }
}

