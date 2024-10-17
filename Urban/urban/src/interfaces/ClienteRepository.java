package interfaces;

import java.util.LinkedList;
import modelo.Cliente;

public interface ClienteRepository {
    
    LinkedList<Cliente> getAllClientes(); // Obtiene todos los clientes
    
    Cliente getClienteById(int id_cliente); // Obtiene un cliente por su ID
    
    Cliente getClienteByDNI(int dni); // Obtiene un cliente por su DNI
    
    void addCliente(Cliente cliente); // Añade un cliente a la base de datos
    
    void updateCliente(Cliente cliente); // Actualiza un cliente en la base de datos
    
    void deleteCliente(int id_cliente); // Elimina un cliente de la base de datos
}