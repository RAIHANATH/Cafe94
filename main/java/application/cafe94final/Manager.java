package application.cafe94final;

import java.util.ArrayList;

class Manager extends Staff {

    static ArrayList<Waiter> waiterArray = new ArrayList<>();
    static ArrayList<Chef> chefArray = new ArrayList<>();
    static ArrayList<Driver> driverArray = new ArrayList<>();
    static ArrayList<Manager> managerArray = new ArrayList<>();

    public Manager(String name, String lastname, String id, int hours, int hoursWorked) {
        super(name, lastname, id, hours, hoursWorked);
    }

    /**
     *
     */

    void printDrivers() {
        System.out.println(driverArray);

        /*
        for (Driver d : driverArray)
        {
        System.out.println(d.getFirstName() + " " + d.getLastName());
        }
        */
    }

    void addDriver(Driver driver, String firstName, String lastName) {
        driver.setFirstName(firstName);
        driver.setLastName(lastName);
        driverArray.add(driver);
    }

    void deleteDriver(String firstName, String lastName) {
        for (int i = 0; i < driverArray.size(); i++) {
            if (getFirstName().equals(firstName)
                    && getLastName().equals(lastName)) {
                driverArray.remove(i);
            }
        }
    }

    void editDriver(String firstName, String lastName,
                    int hoursToWork, String newName, String newLastName) {
        for (int i = 0; i < driverArray.size(); i++) {
            if (getFirstName().equals(firstName) &&
                    getLastName().equals(lastName)) {
                setFirstName(newName);
                setLastName(newLastName);
                setHoursToWork(hoursToWork);
            } else {
                break;
            }
        }
    }

    void printChefs() {
        System.out.println(chefArray);

        /**
         for (Chef c : chefArray)
         {
         System.out.println(c.getFirstName() + " " + c.getLastName());
         }
         * */
    }

    void addChef(Chef chefi, String firstName, String lastName) {
        chefi.setFirstName(firstName);
        chefi.setLastName(lastName);
        chefArray.add(chefi);
    }

    void deleteChef(String firstName, String lastName) {
        for (int i = 0; i < chefArray.size(); i++) {
            if (getFirstName().equals(firstName)
                    && getLastName().equals(lastName)) {
                chefArray.remove(i);
            }
        }
    }

    void editChef(String firstName, String lastName,
                  int newHoursToWork, String newName, String newLastName) {
        for (int i = 0; i < chefArray.size(); i++) {
            if ((getFirstName().equals(firstName) &&
                    getLastName().equals(lastName))) {
                setFirstName(newName);
                setLastName(newLastName);
                setHoursToWork(newHoursToWork);
            } else {
                break;
            }
        }
    }

    void printWaiter() {
        System.out.println(waiterArray);

        /**
         for (Waiter w : waiterArray)
         {
         System.out.println(c.getFirstName() + " " + c.getLastName());
         }
         * */
    }

    void addWaiter(Waiter waiter, String firstName, String lastName) {
        waiter.setFirstName(firstName);
        waiter.setLastName(lastName);
        waiterArray.add(waiter);
    }

    public void deleteWaiter(String firstName, String lastName) {
        for (int i = 0; i < waiterArray.size(); i++) {
            if (getFirstName().equals(firstName)
                    && getLastName().equals(lastName)) {
                waiterArray.remove(i);
            }
        }
    }

    void editWaiter(String firstName, String lastName,
                    int hoursToWork, String newName, String newLastName) {
        for (int i = 0; i < waiterArray.size(); i++) {
            if ((getFirstName().equals(firstName) &&
                    getLastName().equals(lastName))) {
                setFirstName(newName);
                setLastName(newLastName);
                setHoursToWork(hoursToWork);
            } else {
                break;
            }
        }
    }

    void printManager() {
        System.out.println(managerArray);

        /**
         for (Manager c : managerArray)
         {
         System.out.println(c.getFirstName() + " " + c.getLastName());
         }
         * */
    }

    void addManager(Manager manager, String firstName, String lastName) {
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        managerArray.add(manager);
    }

    void deleteManager(String firstName, String lastName) {
        for (int i = 0; i < managerArray.size(); i++) {
            if (getFirstName().equals(firstName)
                    && getLastName().equals(lastName)) {
                managerArray.remove(i);
            }
        }
    }

    void editManager(String firstName, String lastName,
                     int hoursToWork, String newName, String newLastName) {
        for (int i = 0; i < managerArray.size(); i++) {
            if ((getFirstName().equals(firstName) &&
                    getLastName().equals(lastName))) {
                setFirstName(newName);
                setLastName(newLastName);
                setHoursToWork(hoursToWork);
            } else {
                break;
            }
        }
    }
}