import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.out;

class FoodQueue {
    static void greeting() {
        out.println("\nHi, Welcome to the Foodie Fave Food Centre !! ");
        out.println("\n100 or VFQ: View all Queues\n101 or VEQ: View all Empty Queues.\n102 or ACQ: Add customer to a Queue.\n103 or RCQ: Remove a customer from a Queue. (From a specific location)\n104 or PCQ: Remove a served customer.\n105 or VCS: View Customers Sorted in alphabetical order.\n106 or SPD: Store Program Data into file.\n107 or LPD: Load Program Data from file.\n108 or STK: View Remaining burgers Stock.\n109 or AFS: Add burgers to Stock.\n110 or IFQ: Income of each Queue\n999 or EXT: Exit the Program.\n");
    }
    static void viewQueues(Customer[] queue, String [] queue2, int count2) {
        for (int count = 0; count < count2; count++) { //viewing customers in terms of 'x' and 'o' by iterating the elements in the cashier arrays
            if (queue[count] == null) {
                queue2[count] = ("X");
            } else {
                queue2[count] = ("O");
            }
        }
    }
    static void viewEmptyQueues(Customer[] queue, String cashier) { //To print the empty queues by using null (Array, statement )
        out.println(cashier);
        for (Customer customer : queue) {
            if (!(customer == null)) {
                System.out.print(customer); //Counting the customers in the queue
            } else {
                out.println("X");
            }
        }
    }
    static int addCustomer( Customer [] queue , Customer [] customerArray, int burgerCount,int customerPosition, int count) {
        try {
            Scanner nameData = new Scanner(System.in);
            System.out.print("first name:");
            String firstName = nameData.next();
            Scanner nameData2 = new Scanner(System.in);
            System.out.print("Second name:");
            String secondName = nameData2.next();
            Scanner burgers = new Scanner(System.in);
            System.out.print("Burger Count:");
            int burgerNo = burgers.nextInt();
            burgerCount = burgerCount - burgerNo;
            if (burgerCount > 0) {
                queue[count] = new Customer(firstName, secondName, burgerNo);//adding new values to queue array
                System.out.println("The customer has been added to the queue .");
                for (int customerCount = customerPosition; customerCount < customerArray.length - 1; customerCount++) {
                    if (customerArray[customerCount] == null) {
                        customerArray[customerCount] = queue[count]; //assigning the values in the cashier queues to the customer array
                        break;
                    }
                }
            } else {
                burgerCount = burgerCount + burgerNo;
                out.println("insufficient amount of burgers");
            }
        } catch (Exception error) {//exception handling to take integer inputs for burger count
            out.println("invalid input enter a number");
            throw error;
        }
        for (Customer customer : queue) {
            if (!(customer == null)) {
                System.out.print(customer); //printing each queue after adding customer
            }
        }
        return burgerCount;
    }

    static int removeCustomer(Customer [] queue, Customer [] customerArray, int burgerCount, String index) {
        int index2 = Integer.parseInt(index);
        if (queue[index2 - 1] == null) { //checking whether the cashier array is null
            out.println("\nThe slot is empty");
        } else {
            burgerCount = burgerCount + queue[index2-1].burgerCount;
            for (int count = index2 - 1 ; count < queue.length - 1; count++) {
                out.println(count);
                queue[count] = queue[count + 1]; //moving the customer forward after removing previous one
            }
            out.println("\nThe customer has been removed from the queue.");
            for (int customerCount = 0; customerCount < 10; customerCount++) {
                if (customerArray[customerCount] == queue[index2-1]) {
                    customerArray[customerCount] = null;  //removing the customer name from the customer array
                }
            }
        }
        queue[queue.length - 1] = null; //making the last value of the cashier object array null to avoid copying of the last value
        out.println(burgerCount);
        for (Customer customer : queue) {
            if (!(customer == null)) {
                System.out.print(customer); //printing each queue after adding customer
            }
        }
        return burgerCount;
    }
    static void removeServedCustomer(Customer [] queue, Customer [] customerArray, String index) { //same method as removing a customer except reducing burger count
        int index2 = Integer.parseInt(index);
        //queue [index2 ] = queue[index2 - 1]; //assigning the values in cashier array to variable
        if (queue[index2 - 1] == null) { //checking whether the cashier array is null
            out.println("\nThe slot is empty");
        } else {
            for (int count = index2 - 1 ; count < queue.length - 1; count++) {
                out.println(count);
                queue[count] = queue[count + 1]; //moving the customer forward after removing previous one
            }
            out.println("\nThe customer has been removed from the queue.");
            for (int customerCount = 0; customerCount < 10; customerCount++) {
                if (customerArray[customerCount] == queue[index2-1]) {
                    customerArray[customerCount] = null;  //removing the customer name from the customer array
                }
            }
        }
        queue[queue.length - 1] = null; //making the last value of the cashier object array null to avoid copying of the last value
        for (Customer customer : queue) {
            if (!(customer == null)) {
                System.out.print(customer); //printing each queue after adding customer
            }
        }
    }
    static void sorting(Customer [] customerArray) {
        Customer [] customerSortArray = Arrays.copyOfRange(customerArray,0,customerArray.length);
        for (int count = 0; count < customerSortArray.length; count++) { //these three lines prints "null" instead of null values in the customer array
            if (customerSortArray[count] == null) {
                customerSortArray[count] = new Customer ("null","null",0);
            }
        }
        out.println(" ");
        for (int count = 0; count < customerSortArray.length - 1; count++) { //sorting the customer array using bubble sort method
            for (int sortCount = count + 1; sortCount < customerSortArray.length; sortCount++) {
                if ((customerSortArray[count].firstName).compareTo(customerSortArray[sortCount].firstName) > 0) {
                    Customer temper = customerSortArray[count];
                    customerSortArray[count] = customerSortArray[sortCount];
                    customerSortArray[sortCount] = temper;
                }
            }
        }
        for (Customer customer : customerSortArray) {
            if (!(customer.firstName.equals("null"))) {
                System.out.print(customer); //printing each queue after adding customer
            }
        }
    }
    static void income (String cashierName , Customer [] cashier){ //income of each cashier calculating function
        out.println("--------------Income Cashier " + cashierName + "--------------");
        int burgerNumbers = 0;
        for (Customer customer : cashier) {
            if (!(customer == null)) {
                burgerNumbers = burgerNumbers + customer.burgerCount;
            }
        }
        out.println("Number of burgers sold : " + burgerNumbers + "\nIncome : Rs." + (burgerNumbers * 650) + "/=");
    }


    static void storeData (Customer [] customerQueue,int burgerCount){
        out.println("--------------Store program data to file--------------");
        try { // writing the customer array objects to a serialized file
            FileOutputStream file = new FileOutputStream("FoodFaveManagementSystem.ser");
            ObjectOutputStream value = new ObjectOutputStream(file);
            Customer [] cashierCopy = new Customer[customerQueue.length + 1]; //declaring the length of the array
            for (int index = 0; index < customerQueue.length ; index++) {
                cashierCopy[index] = customerQueue[index];
            }
            //storing the current stock amount to the file
            cashierCopy[10] = new Customer("null", "null", burgerCount); //creating an object to store the burger count since an object array is written into the file
            value.writeObject(cashierCopy);
            out.println("the data are stored into to the file");
            value.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int loadingData (Customer [] queue1,Customer [] queue2,Customer [] queue3,Customer [] customerQueue, int burgerCount){
        out.println("--------------Loading program data from file--------------");
        try {//reading the serialized file
            FileInputStream file = new FileInputStream("FoodFaveManagementSystem.ser");
            ObjectInputStream value = new ObjectInputStream(file);
            Customer[] customers = (Customer[]) value.readObject();
            value.close();
            file.close();
            for (int index = 0; index < queue1.length; index++) {//loading back the objects of the customer array to the cashier queues
                queue1[index] = customers[index];
            }
            for (int index = 0; index < queue2.length; index++) {
                queue2[index] = customers[index + 2];
            }
            for (int index = 0; index < queue3.length; index++) {
                queue3[index] = customers[index + 5];
            }
            for (int index = 0; index < customers.length-1; index++) {
                customerQueue[index] = customers[index];
            }
            burgerCount = customers[10].burgerCount;
            out.print("the data are loaded back to the file successfully");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return burgerCount;
    }

    static int addBurgers (int burgerCount){
        boolean answer = true;
        while (answer) {//checking the stock quantity
            out.println("--------------Add burgers to stock--------------\nEnter the number of burgers to be added : ");
            Scanner input = new Scanner(System.in);
            int addCount = input.nextInt();
            burgerCount += addCount; //adding the burger's count to the prevailing stock
            out.print("Burgers added to the stock successfully.");
            boolean addingLoop = true;
            while (addingLoop) {
                out.print("\nDo you want to add more burgers [currently available - " + burgerCount + "] (yes/no): ");
                String inputVal = input.next().toLowerCase();
                if (inputVal.equals("no")) {
                    answer = false;
                    break;
                } else if (!(inputVal.equals("yes"))) {
                    out.println("Invalid Input, Try Again");
                    addingLoop = false;
                }
            }
        }
        return burgerCount;
    }

}