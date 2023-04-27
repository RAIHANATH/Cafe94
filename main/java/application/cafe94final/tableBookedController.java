package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class tableBookedController {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;

    @FXML
    public Label bookingDate;
    @FXML
    public Label bookingTime;
    @FXML
    public Label bookingGuest;

    /**
     * Switches to manager home scene
     *
     * @param event
     * @throws IOException
     */
    public void switchToCustomerHomeFromBooked(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customer-home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    public void displayBooking(LocalDate bDate, String bTime,
                               String bGuests) {
        bookingGuest.setText(bGuests);
        bookingTime.setText(bTime);
        bookingDate.setText(String.valueOf(bDate));
    }
}
