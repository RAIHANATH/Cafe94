package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * This class controls the manager home GUI.
 *
 * @author James Morgan
 * version 1
 */

public class ManagerHomeController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    /**
     * Switches to log in scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToLogIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("log-in.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches to reports scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToReports(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("reports.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches to manager staff view scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToManagerViewStaff(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-view-staff.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
