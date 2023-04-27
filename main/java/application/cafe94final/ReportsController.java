package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class controls the reports GUI.
 *
 * @author James Morgan
 * version 1
 */

public class ReportsController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    /**
     * Switches to manager home scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToManagerHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
