package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class controls the pickup GUI.
 *
 * @author James Morgan
 * version 1
 */

public class PickUpController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    /**
     * Switches to customer home scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToCustomerHomeFromPickUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customer-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
