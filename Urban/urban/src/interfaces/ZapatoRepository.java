package interfaces;

import java.util.LinkedList;
import modelo.Zapato;

public interface ZapatoRepository {

    LinkedList<Zapato> getAllZapatos(); // Obtener todos los zapatos

    Zapato getZapatoById(int id_zapato); // Obtener un zapato por su ID

    void addZapato(Zapato zapato); // Añadir un nuevo zapato a la base de datos

    void updateZapato(Zapato zapato); // Actualizar un zapato existente en la base de datos

    void deleteZapato(int id_zapato); // Eliminar un zapato por su ID
}
