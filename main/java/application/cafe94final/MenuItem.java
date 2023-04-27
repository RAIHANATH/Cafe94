package application.cafe94final;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * This class represents a menu item with a name, a description, an ID, and a price.
 * There are also three menu lists the menu items can be added to.
 *
 * @author Kate H
 * @version 1.0
 */
public class MenuItem {

    private final String name;
    private final int ID;
    private final double price; //in pounds

    private static int menuItemCounter = 0;
    private static ArrayList<MenuItem> menuEatIn = new ArrayList<>();
    private static ArrayList<MenuItem> menuTakeaway = new ArrayList<>();
    private static ArrayList<MenuItem> menuDailySpecial = new ArrayList<>();

    /**
     * Create a new menu item with specified name, description, and price.
     * This will also generate an item ID based on existing menu items.
     *
     * @param name  The name of the item.
     * @param price The price of the item in GBP£.
     */
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
        menuItemCounter++;
        this.ID = menuItemCounter;
    }

    /**
     * @return The name of a menu item.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The price of a menu item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a formatted string representing a menu item.
     *
     * @return The name and price of menu item.
     */
    public String toString() {
        return (name + "  ----- £" + price);
    }

    /**
     * Get all items in a menu.
     *
     * @param menuName Specify which of the three menus. Available menu names
     *                 are: "EatIn", "Takeaway", and "DailySpecial".
     * @return List of menu items in said menu.
     */
    public static ArrayList<MenuItem> getMenu(String menuName)
            throws InvalidParameterException {
        switch (menuName) {
            case ("EatIn"):
                return menuEatIn;
            case ("TakeAway"):
                return menuTakeaway;
            case ("DailySpecial"):
                return menuDailySpecial;
            default:
                throw new InvalidParameterException("bad");

        }
    }

    /**
     * Adds a menu item to a specified Menu.
     *
     * @param whichMenu The menu to add to.
     */
    public void addToMenu(String whichMenu) {
        getMenu(whichMenu).add(this);
    }

    /**
     * Removes a menu item from a specified Menu.
     *
     * @param whichMenu The menu to remove from.
     */
    public void removeFromMenu(String whichMenu) {
        getMenu(whichMenu).remove(this);

    }
}
