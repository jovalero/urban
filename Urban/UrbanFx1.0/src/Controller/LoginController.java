package Controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Admin;
import controladores.AdminControlador;

public class LoginController {

    @FXML
    private TextField InputUsuario;

    @FXML
    private PasswordField InputContrasena;

    private AdminControlador adminControlador = new AdminControlador(); // Modelo para la autenticación

    @FXML
    private void iniciarSesion() {
    	
        String usuario = InputUsuario.getText();
        String contrasena = InputContrasena.getText();
        Admin admin= Admin.iniciarSesion(usuario, contrasena);
  
       
        if (admin != null) { 
  
            try {
                // Carga el archivo FXML del panel al que deseas cambiar
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/HomeAdmin.fxml")); // Reemplaza con la ruta correcta
                Parent homePanel = loader.load();

                // Obtiene la ventana actual
                Stage stage = (Stage) InputUsuario.getScene().getWindow();
                // Establece la nueva escena en la ventana
                stage.setScene(new Scene(homePanel));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Mostrar un mensaje de error
            System.out.println("Credenciales incorrectas.");
        }
    }
}
