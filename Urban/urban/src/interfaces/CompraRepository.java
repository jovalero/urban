package interfaces;

import java.util.LinkedList;
import modelo.Compra;

public interface CompraRepository {

    LinkedList<Compra> getAllCompras(); // Obtener todas las compras

    Compra getCompraById(int id_compra); // Obtener una compra por su ID

    void addCompra(Compra compra); // Añadir una nueva compra a la base de datos

    void updateCompra(Compra compra); // Actualizar una compra existente en la base de datos

    void deleteCompra(int id_compra); // Eliminar una compra por su ID
}
