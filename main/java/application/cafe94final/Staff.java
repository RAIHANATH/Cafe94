package application.cafe94final;

public class Staff {

    String StaffId;
    String firstName;
    String lastName;
    int hoursWorked;
    int hoursToWork;


    public Staff(String name, String lastname, String id, int hoursToWork, int hoursWorked) {
        this.firstName = name;
        this.lastName = lastname;
        this.StaffId = id;
        this.hoursToWork = hoursToWork;
        this.hoursWorked = hoursWorked;
    }

    public Staff() {

    }


    /**
     * each array for each type of worker will store their firstName and lastName
     * in this class we can see the setters and getters of staff class atributes
     *
     * @return
     */

    public Order getOrder(Order order) {
        return order;
    }


    public int getOrderId(Order order) {
        return order.getId();
    }


    /**
     * @return
     */

    public String getStaffId() {
        return StaffId;
    }

    /**
     * @param StaffId
     */

    public void setStaffId(String StaffId) {
        this.StaffId = StaffId;
    }

    /**
     * @return
     */

    public String getFirstName() {
        return firstName;
    }

    /**
     * @return
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * @return
     */

    public int getHoursWorked() {
        return hoursWorked;
    }

    /**
     * @return
     */

    public int getHoursToWork() {
        return hoursToWork;
    }

    /**
     * @param firstName
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param hoursWorked
     */

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * @param hoursToWork
     */

    public void setHoursToWork(int hoursToWork) {
        this.hoursToWork = hoursToWork;
    }

    /**
     *
     */
}

