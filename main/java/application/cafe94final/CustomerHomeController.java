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
 * This class controls the customer home GUI.
 *
 * @author James Morgan
 * version 1
 */

public class CustomerHomeController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    /**
     * Switches to the order waiter scene
     *
     * @param event The password in text field.
     * @throws IOException
     */
    public void switchToTakeOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OrderWaiter.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches to the book table scene
     *
     * @param event The password in text field.
     * @throws IOException
     */
    public void switchToBookTable(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("booking.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches to the customer details scene
     *
     * @param event The password in text field.
     * @throws IOException
     */
    public void switchToCustomerAccount(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customer-details.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches to the log in scene
     *
     * @param event The password in text field.
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
     * Switches to the previous orders scene
     *
     * @param event The password in text field.
     * @throws IOException
     */
    public void switchToPreviousOrders(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("previous-orders.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
