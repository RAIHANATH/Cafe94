package application.cafe94final;

public class Waiter extends Staff {

    private Order order;

    public Waiter(String name, String lastname, String id, int hours, int hoursWorked) {
        super(name, lastname, id, hours, hoursWorked);
    }

    public Waiter() {
        super();
    }

    void grabOrder(Order order) {
        this.order = order;
    }

    public void aproveDeliveryOrder(int orderId) {
        System.out.println("Order number: " + order.getId() + "aproved by: " +
                this.getFirstName());
    }

    public String toString()//to print an object in a string representation
    {
        return "Waiter: " + this.getFirstName() + " " + this.getLastName();
    }

}
