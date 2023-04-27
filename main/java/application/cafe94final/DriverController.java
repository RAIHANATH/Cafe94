package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DriverController {

    @FXML
    private TextField assignDriverName;
    //assign driver method??
    @FXML
    private Label myAssignLabel;

    public void assignDriver(ActionEvent event) {

        myAssignLabel.setText(assignDriverName.getText() + " Is assigned to the task!");
        /**for (Driver driver: manager.driverArray){
         if (driver.getFirstName().equalsIgnoreCase(assignDriverName.getText())){
         myAssignLabel.setText(assignDriverName.getText() + " Is assigned to the task!");
         }
         }**/
    }
}

