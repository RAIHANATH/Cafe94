package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class bookingController {

    @FXML
    public DatePicker bookingDate;
    @FXML
    public TextField guests;
    @FXML
    public TextField bookingTime;

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    /**
     * Switches to customer home scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToCustomerHomeFromBooking(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customer-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches to table booked scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToTableBooked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("table-booked.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void saveBooking(ActionEvent event) throws IOException {

        LocalDate bDate = bookingDate.getValue();
        String bGuests = guests.getText();
        String bTime = bookingTime.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("table-booked.fxml"));
        root = loader.load();

        tableBookedController tablebookedcontroller = loader.getController();
        tablebookedcontroller.displayBooking(bDate, bTime, bGuests);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
