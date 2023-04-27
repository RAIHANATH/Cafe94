package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerViewStaffController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    private Button managerGoHome1;
    @FXML
    private Button removeWaiter;
    @FXML
    private Button removeChef;
    @FXML
    private Button removeDriver;
    @FXML
    private Button goToEditChef;
    @FXML
    private Button goToEditDriver;
    @FXML
    private Button goToEditWaiter;
    @FXML
    private Label managerWaiterName;
    @FXML
    private Label managerWaiterID;
    @FXML
    private Label managerChefName;
    @FXML
    private Label managerChefID;
    @FXML
    private Label managerDriverName;
    @FXML
    private Label managerDriverID;
    @FXML
    private Label waiterWorked;
    @FXML
    private Label waiterRemaining;
    @FXML
    private Label chefWorked;
    @FXML
    private Label chefRemaining;
    @FXML
    private Label driverWorked;
    @FXML
    private Label driverRemaining;

    public void switchToManagerHome(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditChef(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("edit-chef.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditWaiter(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("edit-waiter.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEditDriver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("edit-driver.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
