//importing the required packages
import java.util.Scanner;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) { //main method
        Scanner input = new Scanner(System.in);
        int stock = 50;// initializing integer variables to store data
        Customer[] cashier1 = new Customer[2];
        Customer[] cashier2 = new Customer[3];
        Customer[] cashier3 = new Customer[5];
        String[] cashier1null = new String[2];
        String[] cashier2null = new String[3];
        String[] cashier3null = new String[5];
        Customer[] customerNames = new Customer[10]; // initializing the arrays which hold the cashier data

        boolean programLoop = true;
        while (programLoop) { //program loop
            FoodQueue.greeting();
            if (stock >= 0) {
                out.print("\nChoose the option to move into from the menu : ");
                String option = input.next().toUpperCase();
                switch (option) {
                    case "100":
                    case "VFQ":
                        out.println("--------------All queues--------------\n");
                        FoodQueue.viewQueues(cashier1, cashier1null, 2); // calling the ViewQueues function which has the "X" and "O" values instead of actual values
                        FoodQueue.viewQueues(cashier2, cashier2null, 3);
                        FoodQueue.viewQueues(cashier3, cashier3null, 5);

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
                        FoodQueue.viewEmptyQueues(cashier1, "Cashier 1"); //this function prints the actual values in the arrays and "X" instead of null
                        FoodQueue.viewEmptyQueues(cashier2, "Cashier 2");
                        FoodQueue.viewEmptyQueues(cashier3, "Cashier 3");
                        break;

                    case "102":
                    case "ACQ":
                        boolean addLoop = true;
                        while (addLoop) {
                            out.println("--------------Add customer to a queue--------------");
                            if (stock == 0) { // checks whether the stock is 0 //checks the stock availability
                                out.print("The stock is empty, Add some burgers");
                                break;
                            } else if (!(cashier3[4] == null)) {
                                out.print("the queues are full");
                            } else {
                                if (cashier1[0] == null) {
                                    stock = FoodQueue.addCustomer(cashier1, customerNames, stock, 0, 0);// the stock gets updated when adding a customer by assigning the method to it.
                                } else if (cashier1[1] == null) {
                                    stock = FoodQueue.addCustomer(cashier1, customerNames, stock, 1, 1);
                                } else if (cashier2[0] == null) {
                                        stock = FoodQueue.addCustomer(cashier2, customerNames, stock, 0, 0);
                                } else if (cashier2[1] == null) {
                                    stock = FoodQueue.addCustomer(cashier2, customerNames, stock, 1, 1);
                                } else if (cashier2[2] == null) {
                                    stock = FoodQueue.addCustomer(cashier2, customerNames, stock, 2, 2);
                                } else if (cashier3[0] == null) {
                                    stock = FoodQueue.addCustomer(cashier3, customerNames, stock, 0, 0);
                                } else if (cashier3[1] == null) {
                                    stock = FoodQueue.addCustomer(cashier3, customerNames, stock, 1, 1);
                                } else if (cashier3[2] == null) {
                                    stock = FoodQueue.addCustomer(cashier3, customerNames, stock, 2, 2);
                                } else if (cashier3[3] == null) {
                                    stock = FoodQueue.addCustomer(cashier3, customerNames, stock, 3, 3);
                                } else {
                                    stock = FoodQueue.addCustomer(cashier3, customerNames, stock, 4, 4);
                                }
                                if (stock <= 10) {// checks whether the stock is above 10
                                    out.println("Burger count is less than 10 !! ");
                                }
                                while (true) {
                                    out.print("\nDo you want to add another customer (yes/no): ");
                                    String loop = input.next().toLowerCase();
                                    if (loop.equals("no")) {
                                        addLoop = false;
                                        break;
                                    } else if (loop.equals("yes")) {
                                        if (stock <= 0) {
                                            out.print("insufficient amount of burgers");
                                            addLoop = false;
                                        }
                                        break;
                                    } else {
                                        out.println("Invalid Input, Try Again");
                                    }
                                }
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
                                    for (Customer customer : cashier1) {
                                        if (!(customer == null)) {
                                            System.out.print(customer); //printing each queue after adding customer
                                        }
                                    }
                                    out.print("\nEnter customer position to remove (1,2) :");
                                    String customerLocation1 = input.next(); // Selecting the customer location by taking user input in queue 1
                                    if (customerLocation1.equals("1") || customerLocation1.equals("2")) {
                                        stock = FoodQueue.removeCustomer(cashier1, customerNames, stock, customerLocation1);//calling removeCustomer function by passing parameters
                                    } else {
                                        out.print("Invalid input !!\nEnter desired number\n");
                                    }
                                    break;
                                case "2":
                                    for (Customer customer : cashier2) {
                                        if (!(customer == null)) {
                                            System.out.print(customer); //printing each queue after adding customer
                                        }
                                    }
                                    out.print("\nEnter customer position to remove (1,2,3) :");
                                    String customerLocation2 = input.next();// Selecting the customer location by taking user input in queue 2
                                    if (customerLocation2.equals("1") || customerLocation2.equals("2") || customerLocation2.equals("3")) {
                                        stock = FoodQueue.removeCustomer(cashier2, customerNames, stock, customerLocation2);//calling removeCustomer function by passing parameters
                                    } else {
                                        out.print("Invalid input !!\nEnter desired number\n");
                                    }
                                    break;
                                case "3":
                                    for (Customer customer : cashier3) {
                                        if (!(customer == null)) {
                                            System.out.print(customer); //printing each queue after adding customer
                                        }
                                    }
                                    out.print("\nEnter customer position to remove (1,2,3,4,5) :");
                                    String customerLocation3 = input.next();// Selecting the customer location by taking user input in queue 3
                                    if (customerLocation3.equals("1") || customerLocation3.equals("2") || customerLocation3.equals("3") || customerLocation3.equals("4") || customerLocation3.equals("5")) {
                                        stock = FoodQueue.removeCustomer(cashier3, customerNames, stock, customerLocation3);//calling removeCustomer function by passing parameters
                                    } else {
                                        out.print("Invalid input !!\nEnter desired number\n");
                                    }
                                    break;
                                default:
                                    out.print("Invalid input !!\nEnter desired number\n");
                            }
                            while (true) {
                                out.print("\nDo you want to remove another customer from the queue (yes/no):");
                                String loop = input.next().toLowerCase();//customer removing function loop execution
                                if (loop.equals("no")) {
                                    removeLoop = false;
                                    break;
                                } else if (loop.equals("yes")) {
                                    break;
                                } else {
                                    out.println("Invalid input try again");
                                }
                            }
                        }
                        break;

                    case "104":
                    case "PCQ":
                        out.println("--------------Remove a served customer from a Queue--------------");
                        boolean removeServedLoop = true;
                        while (removeServedLoop) {//served customer removing function loop
                            out.print("\nEnter queue number to proceed (1,2,3) : ");
                            String removeServedQueue = input.next(); // Selecting the queue by taking user input
                            switch (removeServedQueue) {
                                case "1":
                                    for (Customer customer : cashier1) {// Selecting the customer location by taking user input in queue 1
                                        if (!(customer == null)) {
                                            System.out.print(customer);//printing each queue
                                        }
                                    }
                                    out.print("\nEnter customer position to remove (1,2) :");
                                    String customerLocation1 = input.next();
                                    if (customerLocation1.equals("1") || customerLocation1.equals("2")) {
                                        FoodQueue.removeServedCustomer(cashier1, customerNames, customerLocation1);
                                    } else {
                                        out.print("Invalid input !!\nEnter desired number\n");
                                    }
                                    break;
                                case "2":
                                    for (Customer customer : cashier2) {
                                        if (!(customer == null)) {
                                            System.out.print(customer);//printing each queue after adding customer
                                        }
                                    }
                                    out.print("\nEnter customer position to remove (1,2,3) :");
                                    String customerLocation2 = input.next();
                                    if (customerLocation2.equals("1") || customerLocation2.equals("2") || customerLocation2.equals("3")) {
                                        FoodQueue.removeServedCustomer(cashier2, customerNames, customerLocation2);
                                    } else {
                                        out.print("Invalid input !!\nEnter desired number\n");
                                    }
                                    break;
                                case "3":
                                    for (Customer customer : cashier3) {
                                        if (!(customer == null)) {
                                            System.out.print(customer); //printing each queue after adding customer
                                        }
                                    }
                                    out.print("\nEnter customer position to remove (1,2,3,4,5) :");
                                    String customerLocation3 = input.next();
                                    if (customerLocation3.equals("1") || customerLocation3.equals("2") || customerLocation3.equals("3") || customerLocation3.equals("4") || customerLocation3.equals("5")) {
                                        FoodQueue.removeServedCustomer(cashier3, customerNames, customerLocation3);
                                    } else {
                                        out.print("Invalid input !!\nEnter desired number\n");
                                    }
                                    break;
                                default:
                                    out.print("Invalid input !!\nEnter desired number\n");
                            }
                            while (true) {
                                out.print("\nDo you want to remove another customer from the queue (yes/no):");
                                String removeLoop2 = input.next().toLowerCase();// served customer removing function loop execution
                                if (removeLoop2.equals("no")) {
                                    removeServedLoop = false;
                                    break;
                                } else if (removeLoop2.equals("yes")) {
                                    break;

                                } else {
                                    out.print("Invalid Input, Try Again");
                                }
                            }
                        }
                        break;

                    case "105":
                    case "VCS":
                        out.println("--------------Current customer names who are at the queue in alphabetical order--------------");
                        FoodQueue.sorting(customerNames); // Sorting the customer names in the customer array
                        break;

                    case "106":
                    case "SPD":
                        FoodQueue.storeData (customerNames,stock);
                        break;

                    case "107":
                    case "LPD":
                        stock = FoodQueue.loadingData(cashier1,cashier2,cashier3,customerNames,stock);
                        break;

                    case "108":
                    case "STK":
                        out.println("The remaining burger count in the stock : " + stock); // printing the available stock
                        break;

                    case "109":
                    case "AFS":
                        stock = FoodQueue.addBurgers (stock);
                        break;
                    case "IFQ":
                    case "110":
                        out.println("--------------Income of each queue--------------");
                        out.print("Enter queue number to proceed (1,2,3) : ");
                        String queue = input.next();
                        switch (queue) {
                            case "1":
                                FoodQueue.income("cashier1",cashier1); // the income of cashier1 is calculated here
                                break;
                            case "2":
                                FoodQueue.income("cashier2",cashier2);
                                break;
                            case "3":
                                FoodQueue.income("cashier3",cashier3);
                                break;
                            default:
                                out.print("Invalid input !!\nEnter desired number\n");
                        }

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
            }

        }
    }
}
