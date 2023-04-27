package application.cafe94final;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Controller for the waiter order window.
 *
 * @author Kate H
 * @version 1.0
 */
public class OrderWaiterController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    ListView<String> eatInList;
    @FXML
    ListView<String> specialList;
    @FXML
    TextField tableNo;
    @FXML
    TextField itemQuantity;
    @FXML
    Button addToOrder;
    @FXML
    Button finishOrder;

    ArrayList<MenuItem> eatInMenu = MenuItem.getMenu("EatIn");
    ArrayList<MenuItem> specialMenu = MenuItem.getMenu("DailySpecial");
    Waiter w1 = new Waiter();
    EatInOrder order = new EatInOrder(w1, 0);


    public void initialize() {

        addToOrder.setOnAction(e -> {
            handleAddToOrderAction();
        });

        finishOrder.setOnAction(e -> {
            handleFinishOrderAction();
        });

        // Display the countries
        refreshMenu(eatInList, eatInMenu);
        refreshMenu(specialList, specialMenu);
    }

    private void refreshMenu(ListView listDisplay, ArrayList<MenuItem> whichMenu) {
        listDisplay.getItems().clear();
        for (MenuItem eachItem : whichMenu) {
            listDisplay.getItems().add(eachItem.toString());
        }
    }

    private void handleAddToOrderAction() {
        int selectedIndex1 = eatInList.getSelectionModel().getSelectedIndex();
        int selectedIndex2 = specialList.getSelectionModel().getSelectedIndex();

        if (selectedIndex1 >= 0) {
            MenuItem selectedItem = eatInMenu.get(selectedIndex1);
            int quantity = Integer.parseInt(itemQuantity.getText());
            order.addItemToOrder(selectedItem, quantity);
        }

        if (selectedIndex2 >= 0) {
            MenuItem selectedItem = specialMenu.get(selectedIndex2);
            int quantity = Integer.parseInt(itemQuantity.getText());
            order.addItemToOrder(selectedItem, quantity);
        }
    }

    private void handleFinishOrderAction() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderFinishWaiter.fxml"));
            BorderPane finishRoot = (BorderPane) fxmlLoader.load();
            //move on to the next controller that was loaded in by the loader
            OrderFinishWaiterController finishController = fxmlLoader.<OrderFinishWaiterController>getController();
            //give this next controller the order we just generated in this controller
            finishController.passOrderToConfirm(order);

            Stage finishStage = new Stage();
            Scene finishScene = new Scene(finishRoot);

            finishStage.setScene(finishScene);
            finishStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToStaffHomeFromOrder(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("staff-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPickUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("pickup-confirmed.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDelivery(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("delivery-confirmed.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}