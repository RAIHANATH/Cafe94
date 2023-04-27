package application.cafe94final;

import java.util.ArrayList;

/**
 * This class represents an eat-in order of menu items and quantities.
 * Each order has an ID and a table number.
 *
 * @author Kate H
 * @version 1.0
 */
public class EatInOrder extends Order {

    private Waiter whichWaiter;
    private int tableNo;
    private static ArrayList<EatInOrder> orderHistory = new ArrayList<>();

    /**
     * Creates a new eat-in order.
     * This will also generate an order ID based on existing orders.
     *
     * @param whichWaiter The waiter creating the order.
     * @param tableNo     The table number of the order.
     */
    public EatInOrder(Waiter whichWaiter, int tableNo) {
        super(whichWaiter);
        this.tableNo = tableNo;
        orderHistory.add(this);
    }

    /**
     * @return The existing orders.
     */
    public static ArrayList<EatInOrder> getHistory() {
        return orderHistory;
    }
}

