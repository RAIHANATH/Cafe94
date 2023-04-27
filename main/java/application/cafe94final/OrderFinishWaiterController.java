package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the waiter finish order screen.
 *
 * @author Kate H
 * @version 1.0
 */
public class OrderFinishWaiterController {

    @FXML
    Label orderDisplay;
    @FXML
    Label priceDisplay;

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    // The order passed.
    EatInOrder order;

    public void initialize() {

    }

    public void passOrderToConfirm(EatInOrder order) {
        this.order = order;
        orderDisplay.setText(order.toString());
        priceDisplay.setText(String.format("%.2f", order.calculateTotalPrice()));
    }

    public void switchToManagerViewStaff(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-view-staff.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}