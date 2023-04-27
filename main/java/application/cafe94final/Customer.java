package application.cafe94final;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * This class represents the customer details and their order history
 * Contains customer name and address with order history
 * @author Shawn A
 * @version 1.0
 */
public class Customer {

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String email;
    protected String password;

    /**
     * Create a customer with first name, last name, address, email and password input.
     */
    public Customer() {
    }

    /**
     * Get the first name of customer.
     *
     * @return The first name of customer.
     */
    protected String getcustomerfirstName() {
        return firstName;
    }

    /**
     * Set the first name of customer.
     *
     * @param customerfirstName The first name of customer.
     */
    public void setcustomerfirstName(String customerfirstName) {
        this.firstName = customerfirstName;
    }

    /**
     * Get the last name of customer.
     *
     * @return The last name of customer.
     */
    protected String getcustomerlastName() {
        return lastName;
    }

    /**
     * Set the last name of customer.
     *
     * @param customerlastName The last name of customer.
     */
    public void setcustomerlastName(String customerlastName) {
        this.lastName = customerlastName;
    }

    /**
     * Get the address of customer.
     *
     * @return The address of the customer.
     */
    protected String getcustomerAddress() {
        return address;
    }

    /**
     * Set the address name of customer.
     *
     * @param customerAddress The address of customer.
     */
    public void setcustomerAddress(String customerAddress) {
        this.address = customerAddress;
    }

    /**
     * Get the email of the customer.
     *
     * @return The email of the customer.
     */
    protected String getcustomerEmail() {
        return email;
    }

    /**
     * Set the email of customer.
     *
     * @param customerEmail The email of customer.
     */
    public void setcustomerEmail(String customerEmail) {
        this.email = customerEmail;
    }

    /**
     * Get the password of the customer.
     *
     * @return The password of the customer.
     */
    protected String getcustomerPassword() {
        return password;
    }

    /**
     * Set the password of customer.
     *
     * @param customerPassword The password of customer.
     */
    public void setcustomerPassword(String customerPassword) {
        this.password = customerPassword;

    }
}