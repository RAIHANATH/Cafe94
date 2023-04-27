package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller for the waiter view order screen.
 *
 * @author Kate H
 * @version 1.0
 */
public class ViewOrderWaiterController {
    @FXML
    Button popOrderButton;
    @FXML
    Button exitButton;
    @FXML
    ListView<String> ordersList;

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    private ArrayList<EatInOrder> orderHistory = EatInOrder.getHistory();

    public void initialize() {
        popOrderButton.setOnAction(e -> {
            handlePopOrderButtonAction();
        });
        //populate list
        ordersList.getItems().clear();
        for (EatInOrder eachOrder : orderHistory) {
            ordersList.getItems().add(eachOrder.toString());
        }
    }

    private void handlePopOrderButtonAction() {

        int selectedIndex = ordersList.getSelectionModel().getSelectedIndex();

        if (selectedIndex >= 0) {
            orderHistory.remove(selectedIndex);
        }

        ordersList.getItems().clear();
        for (EatInOrder eachOrder : orderHistory) {
            ordersList.getItems().add(eachOrder.toString());
        }
    }

    public void switchToStaffHomeFromPrevious(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("staff-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
