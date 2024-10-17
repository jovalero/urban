package interfaces;

import java.util.LinkedList;
import modelo.Admin;

public interface AdminRepository {
    LinkedList<Admin> getAllAdmins();
    
    Admin getAdminByDni(String dni);
    
    void addAdmin(Admin admin);
    
    void updateAdmin(Admin admin);
    
    void deleteAdmin(int idAdmin);
}
