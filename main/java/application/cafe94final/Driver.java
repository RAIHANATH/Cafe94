package application.cafe94final;

import java.util.Scanner;

public class Driver extends Staff {
    /**
     *
     */
    Order order;

    public Driver(String name, String lastname, String id, int hours, int hoursWorked) {
        super(name, lastname, id, hours, hoursWorked);
    }

    void grabOrder(Order order) {
        this.order = order;
    }

    /**
     *
     */
    int timeDelay; //(hours and minutes in hundreds 0000h)

    /**
     * @return
     */

    //get time delayed not used
    //but it is a requirement on project?
    public int getTimeDelay() {
        return timeDelay;
    }

    /**
     * @param timeDelay
     */

    public void setTimeDelay(int timeDelay) {
        Scanner delayTime = new Scanner(System.in);
        timeDelay = delayTime.nextInt();
        this.timeDelay = timeDelay;
    }

    /**
     *
     */

    void completeDeliveryOrder() {
        System.out.println("Order number: " + order.getId()
                + " is ready for delivery.");
    }

    /**
     *
     */
    //to get orderId from Order

    void delayOrder() {
        System.out.println("Apologies, your order: " + order.getId() +
                "is delayed by: " + this.getTimeDelay());
    }


    @Override
    public String toString()//to print an object in a string representation
    {
        return "Driver: " + this.getFirstName() + " " + this.getLastName();
    }
/**
 *
 */

}

