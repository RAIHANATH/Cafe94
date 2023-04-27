package application.cafe94final;

import java.util.Scanner;
import java.io.File;

/**
 * This class can read in text files of a given format into data which
 * the Cafe94 system can use.
 *
 * @author Kate H
 * @version 1.0
 */
public class DatabaseParser {

    /**
     * Fills a menu with the items provided in a text file database.
     *
     * @param filename  the file path
     * @param whichMenu name of the menu
     */
    public static void readInMenuItems(String filename, String whichMenu)
            throws Exception {
        File file = new File(filename);
        Scanner in = new Scanner(file).useDelimiter("\\s*/\\s*");
        while (in.hasNext()) {
            String name = in.next();
            double price = Double.parseDouble(in.next());
            MenuItem newMenuItem = new MenuItem(name, price);
            MenuItem.getMenu(whichMenu).add(newMenuItem);
        }
        in.close();
    }

    /**
     * Adds menu items to the text file database.
     *
     * @param filename the file path
     * @param whatItem the item to add
     */
    public static void writeToMenuItems(String filename, MenuItem whatItem) {

    }
}
