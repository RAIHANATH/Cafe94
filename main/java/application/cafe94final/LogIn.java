package application.cafe94final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class controls the log in GUI.
 *
 * @author James Morgan
 * version 1
 */

public class LogIn {

    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    @FXML
    public TabPane tabPane;
    @FXML
    public Tab customerTab;
    @FXML
    public Tab staffTab;
    @FXML
    public Tab managerTab;
    @FXML
    public Label customerError;
    @FXML
    public TextField customerEmail;
    @FXML
    public PasswordField customerPassword;
    @FXML
    public TextField createCustomerEmail;
    @FXML
    public TextField createCustomerPassword;
    @FXML
    public TextField createCustomerName;
    @FXML
    public TextField createCustomerAddress;
    @FXML
    public TextField staffID;
    @FXML
    public PasswordField staffPassword;
    @FXML
    public TextField createStaffID;
    @FXML
    public TextField createStaffPassword;
    @FXML
    public TextField createStaffName;
    @FXML
    public TextField createStaffTelephone;
    @FXML
    public TextField staffVerifyManagerID;
    @FXML
    public TextField managerID;
    @FXML
    public Label staffError;
    @FXML
    public Label managerError;
    @FXML
    public Label managerStaffError;
    @FXML
    public Button createCustomer;
    @FXML
    public Button saveCustomer1;
    @FXML
    public Button customerLogIn;
    @FXML
    public Button createStaff;
    @FXML
    public Button staffLogIn;
    @FXML
    public Button managerLogIn;

    // Creates our txt files for use as a database
    File customerLogIns = new File("customerLogIns.txt");
    File customerAccounts = new File("customerAccounts.txt");
    File staffLogIns = new File("staffLogIns.txt");
    File staffAccounts = new File("staffAccounts.txt");

    // Stores info into a HashMap
    HashMap<String, String> customerLogInInfo = new HashMap<>();
    HashMap<String, String> customerAccountsInfo = new HashMap<>();
    HashMap<String, String> staffLogInInfo = new HashMap<>();
    HashMap<String, String> staffAccountsInfo = new HashMap<>();

    // Create an instances of the encryptor
    Encryptor encryptor = new Encryptor();

    /**
     * Verifies customer log in
     * from database
     *
     * @param event
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    void customerLogInHandler(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String email = customerEmail.getText();
        String password = customerPassword.getText();
        updateLoginUsernamesAndPasswords();

        String encryptedPassword = customerLogInInfo.get(email);
        if (encryptor.encryptString(password).equals(encryptedPassword)) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("customer-home.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } else {
            customerError.setVisible(true);
        }
    }

    /**
     * Verifies staff log in
     * from database
     *
     * @param event
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    void staffLogInHandler(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String ID = staffID.getText();
        String password = staffPassword.getText();
        updateLoginUserIDAndPasswords();

        String encryptedPassword = staffLogInInfo.get(ID);
        if (encryptor.encryptString(password).equals(encryptedPassword)) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("staff-home.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } else {
            staffError.setVisible(true);
        }
    }

    @FXML
    void customerAccountHandler(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String name = createCustomerName.getText();
        String address = createCustomerAddress.getText();
        updateLoginUserIDAndPasswords();
    }

    @FXML
    void staffAccountHandler(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String name = createStaffName.getText();
        String telephone = createStaffTelephone.getText();
        updateLoginUserIDAndPasswords();
    }

    /**
     * This method writes the customer
     * login details to our database on button press.
     *
     * @param event
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    void createCustomerLogIn(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        writeToCustomerLogInFile();
    }

    /**
     * This method writes the customer
     * account details to our database on button press.
     *
     * @param event
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    void createCustomerAccount(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        writeToCustomerAccountFile();
    }

    /**
     * This method writes the staff
     * login details to our database if verified
     * by a manager on button press.
     *
     * @param event
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    void createStaffLogIn(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String verifyManagerIDForStaff = staffVerifyManagerID.getText();
        if (verifyManagerIDForStaff.equals("007")) {
            writeToStaffLogInFile();
        } else {
            managerStaffError.setVisible(true);
        }
    }

    /**
     * This method writes the staff
     * account details to our database if verified
     * by a manager on button press.
     *
     * @param event
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    void createStaffAccount(ActionEvent event) throws IOException, NoSuchAlgorithmException {
        String verifyManagerIDForStaff = staffVerifyManagerID.getText();
        if (verifyManagerIDForStaff.equals("007")) {
            writeToStaffAccountFile();
        }
    }

    /**
     * This method updates the customer
     * login details in our database.
     *
     * @throws IOException
     */
    private void updateLoginUsernamesAndPasswords() throws IOException {
        Scanner scanner = new Scanner(customerLogIns);
        customerLogInInfo.clear();
        customerLogInInfo = new HashMap<>();
        while (scanner.hasNext()) {
            String[] emailAndPassword = scanner.nextLine().split(",");
            customerLogInInfo.put(emailAndPassword[0], emailAndPassword[1]);
        }
    }

    private void updateNameAndAddress() throws IOException {
        Scanner scanner = new Scanner(customerAccounts);
        customerAccountsInfo.clear();
        customerAccountsInfo = new HashMap<>();
        while (scanner.hasNext()) {
            String[] nameAndAddress = scanner.nextLine().split(",");
            customerAccountsInfo.put(nameAndAddress[0], nameAndAddress[1]);
        }
    }

    /**
     * This method updates the staff
     * login details in our database.
     *
     * @throws IOException
     */
    private void updateLoginUserIDAndPasswords() throws IOException {
        Scanner scanner = new Scanner(staffLogIns);
        staffLogInInfo.clear();
        staffLogInInfo = new HashMap<>();
        while (scanner.hasNext()) {
            String[] IDAndPassword = scanner.nextLine().split(",");
            staffLogInInfo.put(IDAndPassword[0], IDAndPassword[1]);
        }
    }

    private void updateNameAndTelephone() throws IOException {
        Scanner scanner = new Scanner(staffAccounts);
        staffAccountsInfo.clear();
        staffAccountsInfo = new HashMap<>();
        while (scanner.hasNext()) {
            String[] nameAndTelephone = scanner.nextLine().split(",");
            staffAccountsInfo.put(nameAndTelephone[0], nameAndTelephone[1]);
        }
    }

    /**
     * This method writes the customer
     * login details in our database.
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private void writeToCustomerLogInFile() throws IOException, NoSuchAlgorithmException {
        String email = createCustomerEmail.getText();
        String password = createCustomerPassword.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter(customerLogIns, true));

        writer.write(email + "," + encryptor.encryptString(password) + "\n");
        writer.close();
    }

    /**
     * This method writes the customer
     * account details in our database.
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private void writeToCustomerAccountFile() throws IOException, NoSuchAlgorithmException {
        String name = createCustomerName.getText();
        String address = createCustomerAddress.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter(customerAccounts, true));

        writer.write(name + "," + address + "\n");
        writer.close();
    }

    /**
     * This method writes the staff
     * login details in our database.
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private void writeToStaffLogInFile() throws IOException, NoSuchAlgorithmException {
        String ID = createStaffID.getText();
        String password = createStaffPassword.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter(staffLogIns, true));

        writer.write(ID + "," + encryptor.encryptString(password) + "\n");
        writer.close();
    }

    /**
     * This method writes the customer
     * account details in our database.
     *
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    private void writeToStaffAccountFile() throws IOException, NoSuchAlgorithmException {
        String name = createStaffName.getText();
        String telephone = createStaffTelephone.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter(staffAccounts, true));

        writer.write(name + "," + telephone + "\n");
        writer.close();
    }

    /**
     * This method verifies the managers ID
     * and switches to manager home scene
     * if correct
     *
     * @throws IOException
     */
    @FXML
    void verifyManagerID(ActionEvent event) throws IOException {
        String verifyManagerID = managerID.getText();
        if (verifyManagerID.equals("007")) {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("manager-home.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
        } else {
            managerError.setVisible(true);
        }
    }

    /**
     * This method saves customer details
     * and displays it onto the
     * customer details scene
     *
     * @throws IOException
     */
    public void saveCustomer(ActionEvent event) throws IOException {

        String cName = createCustomerName.getText();
        String cAddress = createCustomerAddress.getText();
        String cEmail = createCustomerEmail.getText();
        String cPassword = createCustomerPassword.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("customer-details.fxml"));
        root = loader.load();

        CustomerDetails customerDetails = loader.getController();
        customerDetails.displayDetails(cName, cEmail, cAddress, cPassword);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
