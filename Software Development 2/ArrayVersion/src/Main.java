//importing the required packages
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) { //main method
        Scanner input = new Scanner(System.in);
        int stock = 50; // initializing integer variables to store data
        String[] cashier1 = new String[2]; String[] cashier2 = new String[3]; String[] cashier3 = new String[5];
        String[] cashier1null = new String[2];String[] cashier2null = new String[3]; String[] cashier3null = new String[5];
        String[] customers = new String[10];
        // initializing the arrays which hold the cashier data
        boolean programLoop = true;
        do { //program loop
            greeting(); // calling the method which has the option menu
            out.print("\nChoose the option to move into from the menu : ");
            String option = input.next().toUpperCase();
            switch (option) {
                case "100":
                case "VFQ":
                    out.println("--------------All queues--------------\n");
                    viewQueues(cashier1, cashier1null, 2); // calling the ViewQues function which has the "X" and "O" values instead of actual values
                    viewQueues(cashier2, cashier2null, 3);
                    viewQueues(cashier3, cashier3null, 5);
                    out.println("*****************\n*   Cashiers    *\n*****************"); //Printing the values according to the required structure
                    out.print(" ".repeat(4) + cashier1null[0] + "\t" + cashier2null[0] + "\t" + cashier3null[0] + " \n");
                    out.print(" ".repeat(4) + cashier1null[1] + "\t" + cashier2null[1] + "\t" + cashier3null[1] + " \n");
                    out.print(" ".repeat(8) + cashier2null[2] + " \t" + cashier3null[2] + " \n");
                    out.print(" ".repeat(8) + " " + "\t" + cashier3null[3] + " \n");
                    out.print(" ".repeat(8) + " " + "\t" + cashier3null[4] + " \n");
                    out.print("\n X - Not Occupied\tO - Occupied\n");
                    break;
                case "101":
                case "VEQ":
                    out.println("--------------The empty queues--------------");
                    viewEmptyQueues(cashier1, "Cashier 1"); //this function prints the actual values in the arrays and "X" instead of null
                    viewEmptyQueues(cashier2, "Cashier 2");
                    viewEmptyQueues(cashier3, "Cashier 3");
                    break;
                case "102":
                case "ACQ":
                    out.println("--------------Add customer to a queue--------------");
                    if (stock <= 0) { // checks whether the stock is 0 //checks the stock availability
                        out.print("The stock is empty, Add some burgers");
                        stock = addBurger(stock);
                    } else {
                        if (stock <= 10) { // checks whether the stock is above 10 // checks whether the stock is 0 //checks the stock availability
                            out.println("Burger count is less than 10 !! ");
                        }
                        out.print("Enter queue number to proceed (1,2,3) : ");
                        String queue = input.next();
                        switch (queue) {
                            case "1":
                                stock = addCustomer(cashier1, customers, stock, 0); // the stock gets updated when adding a customer by assigning the method to it.
                                break;
                            case "2":
                                stock = addCustomer(cashier2, customers, stock, 2);
                                break;
                            case "3":
                                stock = addCustomer(cashier3, customers, stock, 5);
                                break;
                            default:
                                out.print("Invalid input !!\nEnter desired number\n");
                        }
                    }
                    break;
                case "103":
                case "RCQ":
                    boolean removeLoop = true;
                    while (removeLoop) {
                        out.println("--------------Remove a customer from a Queue--------------");
                        //customer removing function loop
                        out.print("\nEnter queue number to proceed (1,2,3) : ");
                        String removeQueue = input.next(); // Selecting the queue by taking user input
                        switch (removeQueue) {
                            case "1":
                                for (String values : cashier1) {
                                    out.print(values + ", ");
                                }
                                out.print("\nEnter customer position to remove (1,2) :");
                                String customerLocation1 = input.next(); // Selecting the customer location by taking user input in queue 1
                                if (customerLocation1.equals("1") || customerLocation1.equals("2")) {
                                    stock = removeCustomer(cashier1, customers, stock, customerLocation1);//calling removeCustomer function by passing parameters
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "2":
                                for (String values : cashier2) {
                                    out.print(values + ", ");
                                }
                                out.print("\nEnter customer position to remove (1,2,3) :");
                                String customerLocation2 = input.next();// Selecting the customer location by taking user input in queue 2
                                if (customerLocation2.equals("1") || customerLocation2.equals("2") || customerLocation2.equals("3")) {
                                    stock = removeCustomer(cashier2, customers, stock, customerLocation2);//calling removeCustomer function by passing parameters
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "3":
                                for (String values : cashier3) {
                                    out.print(values + ", ");
                                }
                                out.print("\nEnter customer position to remove (1,2,3,4,5) :");
                                String customerLocation3 = input.next();// Selecting the customer location by taking user input in queue 3
                                if (customerLocation3.equals("1") || customerLocation3.equals("2") || customerLocation3.equals("3") || customerLocation3.equals("4") || customerLocation3.equals("5")) {
                                    stock = removeCustomer(cashier3, customers, stock, customerLocation3);//calling removeCustomer function by passing parameters
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            default:
                                out.print("Invalid input !!\nEnter desired number\n");
                        }
                        while (true) {
                            out.print("Do you want to remove another customer from the que (yes/no):");
                            String removeLoopVal = input.next().toLowerCase();//customer removing function loop execution
                            if (removeLoopVal.equals("no")) {
                                removeLoop = false;
                                break;
                            } else if (removeLoopVal.equals("yes")) {
                                break;
                            } else {
                                out.println("Invalid input try again");
                            }
                        }
                    }
                    break;
                case "104":
                case "PCQ":
                    boolean removeCustomerLoop = true;
                    while (removeCustomerLoop) {//served customer removing function loop
                        out.println("--------------Remove a served customer from a Queue--------------");
                        out.print("\nEnter queue number to proceed (1,2,3) : ");
                        String removeServedQueue = input.next(); // Selecting the Queue by taking user input
                        switch (removeServedQueue) {
                            case "1":// Selecting the customer location by taking user input in queue 1
                                for (String values : cashier1) {
                                    out.print(values + ", ");
                                }
                                out.print("\nEnter customer position to remove (1,2) :");
                                String customerLocation1 = input.next();
                                if (customerLocation1.equals("1") || customerLocation1.equals("2")) {
                                    removeServedCustomer(cashier1, customers, customerLocation1);
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "2":
                                for (String values : cashier2) {
                                    out.print(values + ", ");
                                }
                                out.print("\nEnter customer position to remove (1,2,3) :");
                                String customerLocation2 = input.next();
                                if (customerLocation2.equals("1") || customerLocation2.equals("2") || customerLocation2.equals("3")) {
                                    removeServedCustomer(cashier2, customers, customerLocation2);
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "3":
                                for (String values : cashier3) {
                                    out.print(values + ", ");
                                }
                                out.print("\nEnter customer position to remove (1,2,3,4,5) :");
                                String customerLocation3 = input.next();
                                if (customerLocation3.equals("1") || customerLocation3.equals("2") || customerLocation3.equals("3") || customerLocation3.equals("4") || customerLocation3.equals("5")) {
                                    removeServedCustomer(cashier3, customers, customerLocation3);
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            default:
                                out.print("Invalid input !!\nEnter desired number\n");
                        }
                        while (true) {
                            out.print("Do you want to remove another customer from the queue (yes/no):");
                            String removeLoopVal = input.next().toLowerCase();//customer removing function loop execution
                            if (removeLoopVal.equals("no")) {
                                removeCustomerLoop = false;
                                break;
                            } else if (removeLoopVal.equals("yes")) {
                                break;
                            } else {
                                out.println("Invalid input try again");
                            }
                        }
                    }
                    break;
                case "105":
                case "VCS":
                    out.println("--------------Current customer names who are at the queue in alphabetical order--------------");
                    sorting(customers); // Sorting the customer names in the customer array
                    break;
                case "106":
                case "SPD":
                    storeData(stock, customers); // data storing method
                    break;
                case "107":
                case "LPD":
                    out.println("--------------Loading program data from file--------------");
                    try {
                        File file = new File("CashierData.txt");
                        Scanner readFile = new Scanner(file);
                        while (readFile.hasNextLine()) {
                            String text = readFile.nextLine();
                            String[] textData = text.split(" ; ");
                            stock = Integer.parseInt(textData[0]);  //stock amount stored in the text file
                            loadingData(textData, customers, 1, 11);// assigning the elements in the textData array taken from the text file into customers array
                            loadingData(textData, cashier1, 1, 3);// slicing and copying elements in the textData array to cashiers
                            loadingData(textData, cashier2, 3, 6);
                            loadingData(textData, cashier3, 6, 11);
                            customers = Arrays.copyOfRange(textData, 1, 11);
                        }
                        out.print("The available number of burgers in the stock : " + (stock) + "\n");
                        readFile.close();
                    } catch (IOException e) {
                        out.println("Error reading the file.");//error handling in file reading process
                        e.printStackTrace();
                    }
                    break;
                case "108":
                case "STK":
                    out.println("The remaining burger count in the stock : " + stock); // printing the available stock
                    break;
                case "109":
                case "AFS":
                    stock = addBurger(stock);
                    break;

                case "999":
                case "EXT":
                    out.println("The program terminates"); // exiting the program
                    programLoop = false;
                    break;
                default:
                    out.print("Invalid input, Try Again\n");
                    break;
                }

        } while(programLoop);
    }
    private static void greeting() {
        out.println("\nHi, Welcome to the Foodie Fave Food Centre!! ");
        out.println("\n100 or VFQ: View all Queues\n101 or VEQ: View all Empty Queues.\n102 or ACQ: Add customer to a Queue.\n103 or RCQ: Remove a customer from a Queue. (From a specific location)\n104 or PCQ: Remove a served customer.\n105 or VCS: View Customers Sorted in alphabetical order.\n106 or SPD: Store Program Data into file.\n107 or LPD: Load Program Data from file.\n108 or STK: View Remaining burgers Stock.\n109 or AFS: Add burgers to Stock.\n999 or EXT: Exit the Program.\n");
    }
    private static void viewQueues (String[] queue, String[] queue2, int count2) {
        for (int count = 0; count < count2; count++) { //viewing customers in terms of 'x' and 'o' by iterating the elements in the cashier arrays
            if (queue[count] == null) {
                queue2[count] = ("X");
            } else {
                queue2[count] = ("O");
            }
        }
    }
    private static void viewEmptyQueues (String[] queue, String cashier) { //To print the empty queues by using null (Array, statement )
        int num = 0;
        for (String values : queue) {
            if (values == null) {
                num++;
            }
        }
        if (num > 0) {
            out.println(cashier);
            for (String values : queue) {
                if (!(values == null)) {
                    out.println(values);
                } else {
                    out.println("X");
                }
            }
        }
    }
    private static int addCustomer(String[] queue, String[] customerArray, int burgerCount,int customerPosition) {
        Scanner input = new Scanner(System.in);
        int count = 0; //variable to iterate queue
        boolean answer = true;
        while (answer) {
            if (queue[0] != null && queue[queue.length - 1] != null) { //checking whether the queue is full
                out.println("\nThe queue is full try the other queue.");
                break;
            } else if (queue[count] == null) {
                out.print("Enter name: ");
                queue[count] = input.next(); //adding new values to queue array
                burgerCount -= 5;
                out.println("The customer has been added to the queue.");
                for (int customerCount = customerPosition; customerCount < customerArray.length - 1; customerCount++) {
                    if (customerArray[customerCount] == null) {
                        customerArray[customerCount] = queue[count]; //assigning the values in the cashier queues to the customer array
                        break;
                    }
                }
                for (String values : queue) {
                    out.print(values + ", "); //printing each queue after adding customer
                }
                while (true) {
                    out.print("\nDo you want to add another customer (yes/no): ");
                    String loop = input.next().toLowerCase();
                    if (loop.equals("no")) {
                        answer = false;
                        break;

                    } else if (loop.equals("yes")) {
                        count++;
                        break;
                    } else {
                        out.println("Invalid Input, Try Again");
                    }
                }
            } else {
                count++;
            }

        }
        return burgerCount;
    }
    private static int removeCustomer(String [] queue, String [] customerArray, int burgerCount, String index) {
        int index2 = Integer.parseInt(index);
        String customer = queue[index2 - 1]; //assigning the values in cashier array to variable
        if (queue[index2 - 1] == null) { //checking whether the cashier array is null
            out.println("\nThe slot is empty");
        } else {
            burgerCount += 5;
            for (int count = index2 - 1 ; count < queue.length - 1; count++) {
                queue[count] = queue[count + 1]; //moving the customer forward after removing previous one
            }
            out.println("\nThe customer has been removed from the queue.");
            for (int customerCount = 0; customerCount < 10; customerCount++) {
                if (customerArray[customerCount].equals(customer)) {
                    customerArray[customerCount] = null;  //removing the customer name from the customer array
                } else {
                    customerCount++;
                }
            }
        }
        queue[queue.length - 1] = null; //making the last value of the cashier array null to avoid copying of the last value
        out.println(burgerCount);
        return burgerCount;
    }
    private static void removeServedCustomer(String [] queue, String [] customerArray, String index) { //same method as removing a customer except reducing burger count
        int index2 = Integer.parseInt(index);
        String customer = queue[index2 - 1];
        if (queue[index2 - 1] == null) {
            out.println("\nThe slot is empty");
        } else {
            for (int count = index2 - 1 ; count < queue.length - 1; count++) {
                queue[count] = queue[count + 1];
                out.println("\nThe customer has been removed from the queue.");
            }
            for (int customerCount = 0; customerCount < 10; customerCount++) {
                if (customerArray[customerCount] == (customer)) {
                    customerArray[customerCount] = null;
                }
            }
        }
        queue[queue.length - 1] = null;
    }
    private static void sorting(String[] customerArray) {
        String[] customerSortArray = Arrays.copyOfRange(customerArray,0,customerArray.length);
        for (int count = 0; count < customerSortArray.length; count++) { //these three lines prints "null" instead of null values in the customer array
            if (customerSortArray[count] == null) {
                customerSortArray[count] = "null";
            }
        }
        out.println(" ");
        for (int count = 0; count < customerSortArray.length - 1; count++) { //sorting the customer array using bubble sort method
            for (int sortCount = count + 1; sortCount < customerSortArray.length; sortCount++) {
                if ((customerSortArray[count]).compareTo(customerSortArray[sortCount]) > 0) {
                    String temper = customerSortArray[count];
                    customerSortArray[count] = customerSortArray[sortCount];
                    customerSortArray[sortCount] = temper;
                }
            }
        }
        for (String elements : customerSortArray) {
            if (!(elements.equals("null"))) {
                out.print(elements + ", ");
            }
        }
    }
    private static void storeData( int burgerCount,String [] customerArray ){
        out.println("--------------Store program data to file--------------");
        try {
            File file = new File("cashierData.txt");
            boolean file_created = file.createNewFile();
            if (file_created) {//creating a text file
                FileWriter fileWriter = new FileWriter("cashierData.txt");
                fileWriter.write((burgerCount) + " ; ");//Loading the stock count to the text file
                for (String element : customerArray) {
                    fileWriter.write(element + " ; ");
                }
                fileWriter.close();
            } else if (file.exists()) { //checking whether the text file already exists
                FileWriter fileWriter = new FileWriter("cashierData.txt");
                fileWriter.write((burgerCount + " ; "));
                for (String element : customerArray) {
                    fileWriter.write(element + " ; ");
                }
                fileWriter.close();
            }
            out.println("The data are stored into the file.");
        } catch (IOException error) {
            out.print("causing error");//error handling in file writing process
            error.printStackTrace();
        }
    }
    private static void loadingData( String [] textQueue, String [] queue , int beginNum, int endNum  ){
        queue = Arrays.copyOfRange(textQueue,beginNum,endNum); // assigning the elements in the textData array taken from the text file into customers array
        for (int count = 0; count < queue.length; count++ ) {
            if (queue[count].equals("null")) {
                queue[count] = null;
            }
        }
        for (String values : queue) {
            out.print(values + ", ");
        }
        out.print("\n");
    }

    private static int addBurger (int burgerCount) {
        boolean answer = true;
        while (answer) {
            out.println("--------------Add burgers to stock--------------");
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