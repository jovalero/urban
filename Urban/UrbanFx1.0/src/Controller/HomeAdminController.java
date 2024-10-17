package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;

public class HomeAdminController {

    @FXML
    private Button btnStock;

    @FXML
    private Button btnPedido;

    @FXML
    private Button btnCliente;

    @FXML
    private Button btnVenta;

    @FXML
    private ImageView ImgZapato;

    @FXML
    private Label lblUrbanCasualShoes;

    // Método de manejo de evento para btnStock
    @FXML
    private void IraStock() {
        try {
            // Cargar el archivo FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/Compra.fxml"));
            Parent root = loader.load();

            // Obtener el escenario actual y cambiar la escena
            Stage stage = (Stage) btnStock.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos para los demás botones
    @FXML
    private void IraPedido() {
        // Implementar la lógica para cambiar a la ventana de pedidos
        System.out.println("Botón Pedido presionado");
    }

    @FXML
    private void IraCliente() {
        // Implementar la lógica para cambiar a la ventana de clientes
        System.out.println("Botón Cliente presionado");
    }

    @FXML
    private void IraVenta() {
        // Implementar la lógica para cambiar a la ventana de venta
        System.out.println("Botón Venta presionado");
    }
}
