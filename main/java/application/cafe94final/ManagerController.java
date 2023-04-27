package application.cafe94final;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerController {

    /**
     * to CREATE CHEF
     */
    Manager manager = new Manager("Jhon", "wick", "Boss", 3, 3);
    @FXML
    private TextField createChefName;
    @FXML
    private TextField createChefLastname;
    @FXML
    private TextField createChefId;
    @FXML
    private TextField createChefHours;
    @FXML
    private TextField createChefHoursWorked;


    public void createChefMethod(ActionEvent event) throws IOException {
        Chef chef = new Chef(createChefName.getText(), createChefLastname.getText()
                , createChefId.getText(), Integer.parseInt(createChefHours.getText()), Integer.parseInt(createChefHoursWorked.getText()));
        Manager.chefArray.add(chef);
        System.out.println("Chef created");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * to create Waiter
     */
    @FXML
    private TextField createWaiterName;
    @FXML
    private TextField createWaiterLastname;
    @FXML
    private TextField createWaiterId;
    @FXML
    private TextField createWaiterHours;
    @FXML
    private TextField createWaiterHoursWorked;

    @FXML
    public void createWaiterMethod(ActionEvent event) throws IOException {
        Waiter waiter = new Waiter(createWaiterName.getText(), createWaiterLastname.getText()
                , createWaiterId.getText(), Integer.parseInt(createWaiterHours.getText()),
                Integer.parseInt(createWaiterHoursWorked.getText()));
        Manager.waiterArray.add(waiter);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void editWaiterMethod(ActionEvent event) throws IOException {
        //manager.editWaiter();
        //String firstName, String lastName,
        //                    int hoursToWork, String newName, String newLastName
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void deleteWaiter(ActionEvent event) throws IOException {
        manager.deleteWaiter(createWaiterName.getText(), createWaiterLastname.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * to create Driver
     */
    @FXML
    private TextField createDriverName;
    @FXML
    private TextField createDriverLastname;
    @FXML
    private TextField createDriverId;
    @FXML
    private TextField createDriverHours;
    @FXML
    private TextField createDriverHoursWorked;


    @FXML
    public void createDriverMethod(ActionEvent event) throws IOException {
        Driver driver = new Driver(createDriverName.getText(), createDriverLastname.getText(),
                createDriverId.getText(), Integer.parseInt(createDriverHours.getText()), Integer.parseInt(createDriverHoursWorked.getText()));
        Manager.driverArray.add(driver);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * to EDIT CHEF
     */

    @FXML
    private TextField editChefName;
    @FXML
    private TextField editChefLastname;
    @FXML
    private TextField editChefId;
    @FXML
    private TextField editChefHours;
    @FXML
    private TextField editChefHoursWorked;

    @FXML
    public void editChefName(ActionEvent event) throws IOException {


        Chef chef = new Chef(editChefName.getText(), editChefLastname.getText(),
                editChefId.getText(), Integer.parseInt(editChefHours.getText()), Integer.parseInt(editChefHoursWorked.getText()));
        Manager.chefArray.add(chef);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * to EDIT WAITER
     *
     */


    /**
     * to EDIT DRIVER
     */
    @FXML
    private TextField editDriverName;
    @FXML
    private TextField editDriverLastname;
    @FXML
    private TextField editDriverId;
    @FXML
    private TextField editDriverHours;
    @FXML
    private TextField editDriverHoursWorked;


    @FXML
    public void editDriverMethod(ActionEvent event) throws IOException {
        Driver driver = new Driver(editDriverName.getText(), editDriverLastname.getText(),
                editDriverId.getText(), Integer.parseInt(editDriverHours.getText()),
                Integer.parseInt(editDriverHoursWorked.getText()));
        Manager.driverArray.add(driver);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


}