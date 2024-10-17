package interfaces;

import java.util.LinkedList;
import modelo.Pedido;

public interface PedidoRepository {

    LinkedList<Pedido> getAllPedidos(); // Obtener todos los pedidos

    Pedido getPedidoById(int id_pedido); // Obtener un pedido por su ID

    void addPedido(Pedido pedido); // Añadir un nuevo pedido a la base de datos

    void updatePedido(Pedido pedido); // Actualizar un pedido existente en la base de datos

    void deletePedido(int id_pedido); // Eliminar un pedido por su ID
}
