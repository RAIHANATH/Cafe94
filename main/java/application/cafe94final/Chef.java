package application.cafe94final;

public class Chef extends Staff {
    Order order;

    public Chef(String name, String lastname, String id, int hours, int hoursWorked) {
        super(name, lastname, id, hours, hoursWorked);
    }

    /**
     * @param order
     */
    void completeOrder(Order order) {
        this.order = order;
        System.out.println("Order number: " + order.getId() +
                " complete. Ready to collect!");
    }

    /**
     * method to complete order and printing order Id
     *
     * @return
     */
    public String toString() {
        return "chef: " + this.getFirstName() + " " + this.getLastName();
    }
/**
 * to string method to transform objects from the array in a string representation
 */
}
