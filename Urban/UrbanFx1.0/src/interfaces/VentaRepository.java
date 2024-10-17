package interfaces;

import java.util.LinkedList;
import modelo.Venta;

public interface VentaRepository {

    LinkedList<Venta> getAllVentas(); // Obtener todas las ventas

    Venta getVentaById(int id_venta); // Obtener una venta por su ID

    void addVenta(Venta venta); // Añadir una nueva venta a la base de datos

    void updateVenta(Venta venta); // Actualizar una venta existente en la base de datos

    void deleteVenta(int id_venta); // Eliminar una venta por su ID
}
