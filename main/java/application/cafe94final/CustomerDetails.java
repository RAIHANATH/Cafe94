package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerDetails {

    @FXML
    public Label customerName;
    @FXML
    public Label customerEmailDisplay;
    @FXML
    public Label customerAddress;
    @FXML
    public Label customerPasswordDisplay;

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    public void displayDetails(String cName, String cEmail,
                               String cAddress, String cPassword) {
        customerName.setText(cName);
        customerEmailDisplay.setText(cEmail);
        customerAddress.setText(cAddress);
        customerPasswordDisplay.setText(cPassword);
    }

    public void switchToCustomerHomeFromDetails(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customer-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }
}
