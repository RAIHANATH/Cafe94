package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * This class represents a special menu item with a name, a description, an ID, and a price.
 * that can be edited by the chef.
 *
 * @author Kate H
 * @version 1.0
 */

public class MenuEditChefController {

    @FXML
    Button deleteItem;
    @FXML
    Button addNewItem;
    @FXML
    TextField itemName;
    @FXML
    TextField itemPrice;
    @FXML
    ListView menuList;

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    public void initialize() {

        deleteItem.setOnAction(e -> {
            handleDeleteItemAction();
        });

        addNewItem.setOnAction(e -> {
            handleAddItemAction();
        });

        refreshList();
    }

    public void handleDeleteItemAction() {
        int selectedIndex = menuList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            MenuItem.getMenu("DailySpecial").remove(selectedIndex);
        }
        refreshList();
    }

    public void handleAddItemAction() {
        if (itemName.getText() != null && itemPrice.getText() != null) {
            String name = itemName.getText();
            Double price = Double.parseDouble(itemPrice.getText());
            MenuItem item = new MenuItem(name, price);
            item.addToMenu("DailySpecial");
        }

        refreshList();
    }

    private void refreshList() {
        menuList.getItems().clear();
        for (MenuItem eachItem : MenuItem.getMenu("DailySpecial")) {
            menuList.getItems().add(eachItem.toString());
        }
    }

    public void switchToStaffHomeFromEditMenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("staff-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
