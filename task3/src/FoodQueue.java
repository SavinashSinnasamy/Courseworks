import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

class FoodQueue {
    static void greeting() {
        out.println("\nHi, Welcome to the Foodie Fave Food Centre !! ");
        out.println("\n100 or VFQ: View all Queues\n101 or VEQ: View all Empty Queues.\n102 or ACQ: Add customer to a Queue.\n103 or RCQ: Remove a customer from a Queue. (From a specific location)\n104 or PCQ: Remove a served customer.\n105 or VCS: View Customers Sorted in alphabetical order.\n106 or SPD: Store Program Data into file.\n107 or LPD: Load Program Data from file.\n108 or STK: View Remaining burgers Stock.\n109 or AFS: Add burgers to Stock.\n110 or IFQ: Income of each Queue\n999 or EXT: Exit the Program.\n");
    }

    static void viewQueues(Customer[] queue, String[] queue2, int count2) {
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

    static int addCustomer(Customer[] queue, ArrayList<Customer> customerArray, int burgerCount, int count) {
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
                System.out.println("\nThe customer has been added to the queue.");
                Customer value = queue[count];
                customerArray.add(value); //assigning the values in the cashier queues to the customer array
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

    static int addToWaiting(ArrayList <Customer> wait,ArrayList <Customer> customerQueue,int burgerCount,int index){
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
            wait.add(new Customer(firstName, secondName, burgerNo));//adding new values to waiting queue array
            burgerCount = burgerCount - burgerNo;
            if (burgerCount > 0) {
                out.println("\nwaiting queue");
                for (Customer values : wait) {
                    out.println(values.firstName + "," + values.secondName + "," + values.burgerCount);
                }
            } else {
                burgerCount = burgerCount + burgerNo;
                out.println("insufficient amount of burgers");
            }
        } catch (Exception error) {
            out.println("invalid input enter a number");
            throw error;
        }
        if (burgerCount <= 10) {// checks whether the stock is above 10
            out.println("Burger count is less than 10 !! ");
        }
        System.out.println("\nThe customer has been added to the queue.");
        customerQueue.add(wait.get(index));//Assigning the object in the waiting queue to customer names array
        return burgerCount;
    }

    static int removeCustomer(Customer[] queue, ArrayList<Customer> customerArray, ArrayList<Customer> extraQueue, int burgerCount, String index) {
        int index2 = Integer.parseInt(index); //changing the string customer position to integer shift indexes
        String value = queue[index2 - 1].firstName;//assigning the values in cashier array to variable using firstname attribute
        if (queue[index2 - 1] == null) { //checking whether the cashier array is null
            out.println("\nThe slot is empty");
        } else {
            burgerCount = burgerCount + queue[index2 - 1].burgerCount;
            for (int count = index2 - 1; count < queue.length - 1; count++) {
                queue[count] = queue[count + 1]; //moving the customer forward after removing previous one
            }
            out.println("\nThe customer has been removed from the queue.");
            for (int index3 = 0; index3 < customerArray.size(); index3++) {
                if (customerArray.get(index3).firstName.equals(value)) {// remove a customer in the customer arraylist
                    customerArray.remove(customerArray.get(index3));
                    break;
                }
            }
            if (!(extraQueue.isEmpty())) {
                queue[queue.length - 1] = extraQueue.get(0);//bringing the customer in the waiting queue to the end if available
            } else {
                queue[queue.length - 1] = null;
            }
            out.println(burgerCount);
        }
        return burgerCount;
    }

    static void removeServedCustomer(Customer[] queue, ArrayList<Customer> customerArray, ArrayList<Customer> extraQueue, String index) { //same method as removing a customer except reducing burger count
        int index2 = Integer.parseInt(index); //changing the string customer position to integer shift indexes
        String value = queue[index2 - 1].firstName;//assigning the values in cashier array to variable using firstname attribute
        if (queue[index2 - 1] == null) { //checking whether the cashier array is null
            out.println("\nThe slot is empty");
        } else {
            for (int count = index2 - 1; count < queue.length - 1; count++) {
                queue[count] = queue[count + 1]; //moving the customer forward after removing previous one
            }
            out.println("\nThe customer has been removed from the queue.");
            for (int index3 = 0; index3 < customerArray.size(); index3++) {
                if (customerArray.get(index3).firstName.equals(value)) {// remove a customer in the customer arraylist
                    customerArray.remove(customerArray.get(index3));
                    break;
                }
            }
            if (!(extraQueue.isEmpty())) {
                queue[queue.length - 1] = extraQueue.get(0);//bringing the customer in the waiting queue to the end if available
            } else {
                queue[queue.length - 1] = null;
            }
        }
    }

    static void sorting(ArrayList<Customer> customerArray) {
        ArrayList <Customer> customerSortArray = new ArrayList<>(customerArray);
        out.println(" ");
        int bottom = customerSortArray.size() - 1;
        Customer temper; boolean exchanged = true;
        while (exchanged) { // sort the arraylist using bubble sort method
            exchanged = false;
            for (int count = 0; count < bottom; count++) {
                if (customerSortArray.get(count).firstName.compareTo(customerSortArray.get(count + 1).firstName) > 0) { //compare the first names of the objects to sor the arraylist
                    temper = customerSortArray.get(count);
                    customerSortArray.set(count, customerSortArray.get(count + 1));
                    customerSortArray.set(count + 1, temper);
                    exchanged = true;
                }
            }
            bottom--;
        }
        for (Customer customer : customerSortArray) {
            System.out.print(customer.toString()); //printing each queue after adding customer
        }
    }

    static void income(String cashierName, Customer[] cashier) { //income of each cashier calculating function
        out.println("--------------Income Cashier " + cashierName + "--------------");
        int burgerNumbers = 0;
        for (Customer customer : cashier) {
            if (!(customer == null)) {
                burgerNumbers = burgerNumbers + customer.burgerCount;
            }
        }
        out.println("Number of burgers sold : " + burgerNumbers + "\nIncome : Rs." + (burgerNumbers * 650) + "/=");
    }
    static int addBurgers (int burgerCount) {
        boolean answer = true;
        while (answer) {//checking the stock quantity
            out.print("--------------Add burgers to stock--------------\nEnter the number of burgers to be added : ");
            Scanner input = new Scanner(System.in);
            int addCount = input.nextInt();
            burgerCount = burgerCount + addCount; //adding the burger's count to the prevailing stock
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

    static int loadingData (Customer [] queue1,Customer [] queue2,Customer [] queue3,ArrayList <Customer> wait,ArrayList <Customer> customerQueue,int burgerCount) {
        out.println("--------------Loading program data from file--------------");
        try {//reading the serialized file
            FileInputStream file = new FileInputStream("FoodFaveManagementSystem.ser");
            ObjectInputStream value = new ObjectInputStream(file);
            Customer[] customers = (Customer[]) value.readObject(); //initiating object array to write data into file
            value.close();
            file.close();
            out.println("the data are loaded back successfully");
            for (Customer elements : customers) {
                if (elements == null) {
                    out.println("empty");
                } else {
                    out.println(elements);
                }
            }
            for (int index = 0; index < queue1.length; index++) { //assigning the values taken from the array which contains each cashier data
                queue1[index] = customers[index];
            }
            for (int index = 0; index < queue2.length; index++) {
                queue2[index] = customers[index + 2];
            }
            for (int index = 0; index < queue3.length; index++) {
                queue3[index] = customers[index + 5];
            }
            for (int index = 0; index < customerQueue.size(); index++) {
                customerQueue.set(index, customers[index]);
            }

            burgerCount = customers[10].burgerCount; //assigning the stock count from the file
            for (int index = 11; index < customers.length; index++) {
                customerQueue.add(customers[index]);
            }
            for (int index = 11 + customerQueue.size(); index < wait.size(); index++) {
                wait.add(customers[index]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return burgerCount;
    }

    static void storeData(Customer [] queue1,Customer [] queue2,Customer [] queue3,ArrayList <Customer> wait,ArrayList <Customer> customerQueue,int burgerCount){
        out.println("--------------Store program data to file--------------");
        Customer[] cashierCopy = new Customer[11 + customerQueue.size() + wait.size()];//declaring the length of the array
        // merging all the three cashier arrays into one object array to write into file
        for (int index = 0; index < queue1.length; index++) {
            cashierCopy[index] = queue1[index];
        }
        for (int index = 0; index < queue2.length; index++) {
            cashierCopy[index + 2] = queue2[index];
        }
        for (int index = 0; index < queue3.length; index++) {
            cashierCopy[index + 5] = queue3[index];
        }
        //storing the current stock amount to the file
        cashierCopy[10] = new Customer("null", "null", burgerCount); //creating an object to store the burger count since an object array is written into the file
        // converting the arraylist to an array to write into the file
        Customer[] customerCopy = new Customer[customerQueue.size()];
        if (!(wait.isEmpty())) {
            Customer[] waitingQueueCopy = new Customer[wait.size()];
            waitingQueueCopy = wait.toArray(waitingQueueCopy);
            for (int index = 0; index < waitingQueueCopy.length; index++) {
                cashierCopy[index + 11 + customerQueue.size()] = waitingQueueCopy[index];
            }

        }
        customerCopy = customerQueue.toArray(customerCopy);
        for (int index = 0; index < customerCopy.length; index++) {
            cashierCopy[index + 11] = customerCopy[index];
        }

        try { // writing the customer array objects to a serialized file
            FileOutputStream file = new FileOutputStream("FoodFaveManagementSystem.ser");
            ObjectOutputStream value = new ObjectOutputStream(file);
            value.writeObject(cashierCopy);
            out.println("the data are stored to the file successfully");
            value.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
