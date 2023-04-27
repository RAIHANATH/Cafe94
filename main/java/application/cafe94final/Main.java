package application.cafe94final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class launches the GUI.
 *
 * @author James Morgan
 * version 1
 */

public class Main extends Application {

    /**
     * Loads the GUI
     *
     * @param stage The password in text field.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("log-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Loads the main()
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // read in database
        try {
            DatabaseParser.readInMenuItems("menu- eat in.txt", "EatIn");
            DatabaseParser.readInMenuItems("menu- daily special.txt", "DailySpecial");
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
}