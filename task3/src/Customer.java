import java.io.Serializable;

class Customer implements Serializable {
    public String firstName;
    public String secondName;
    public int burgerCount;

    public Customer(String firstName, String secondName, int burgerCount) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.burgerCount = burgerCount;
    }

    public String toString () {//converts integer values to string values and print them
        return "First name:" + firstName + ", Second Name:" + secondName + ", Burger count:" + burgerCount + "\n";
    }
}
