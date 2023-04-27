package application.cafe94final;

import java.util.ArrayList;

/**
 * This class represents an order of menu items and quantities.
 * Each order has an ID.
 *
 * @author Kate H
 * @version 1.0
 */
public abstract class Order {

    protected final int Id;
    protected ArrayList<MenuItem> items = new ArrayList<>();
    protected ArrayList<Integer> itemQuantities = new ArrayList<>();
    protected static int counter;

    /**
     * Create a new order with input from user.
     * This will also generate an order ID based on existing orders.
     *
     * @param whichWaiter The waiter creating the order.
     */
    public Order(Waiter whichWaiter) {
        counter++;
        Id = counter;
    }

    /**
     * @return The ID of an order.
     */
    public int getId() {
        return Id;
    }

    /**
     * Returns a formatted string representing an order.
     *
     * @return The name and individual price of each item in the order,
     * along with the quantity.
     */
    public String toString() {
        String entireOrder = "";
        for (int i = 0; i < items.size(); i++) {
            entireOrder += items.get(i).toString() +
                    "    Quantity:" + itemQuantities.get(i) + "\n";
        }
        return entireOrder;
    }

    /**
     * Calculates the price of an order.
     *
     * @return The total price of an order.
     */
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice() * itemQuantities.get(i);
        }
        return totalPrice;
    }

    /**
     * Adds an item and its quantity to an order.
     *
     * @param item     The item.
     * @param quantity The corresponding quantity.
     */
    public void addItemToOrder(MenuItem item, int quantity) {
        items.add(item);
        itemQuantities.add(quantity);
    }

}

