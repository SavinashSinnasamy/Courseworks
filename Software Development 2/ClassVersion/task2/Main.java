//importing the required packages
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

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
        FoodQue.greeting();
        while (programLoop) { //program loop
            out.print("\nChoose the option to move into from the menu : ");
            String option = input.next().toUpperCase();
            switch (option) {
                case "100":
                case "VFQ":
                    out.println("--------------All queues--------------\n");
                    FoodQue.viewQues(cashier1, cashier1null, 2); // calling the ViewQues function which has the "X" and "O" values instead of actual values
                    FoodQue.viewQues(cashier2, cashier2null, 3);
                    FoodQue.viewQues(cashier3, cashier3null, 5);

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
                    FoodQue.viewEmptyQues(cashier1, "Cashier 1"); //this function prints the actual values in the arrays and "X" instead of null
                    FoodQue.viewEmptyQues(cashier2, "Cashier 2");
                    FoodQue.viewEmptyQues(cashier3, "Cashier 3");
                    break;

                case "102":
                case "ACQ":
                    boolean addLoop = true;
                    while (addLoop) {
                        out.println("--------------Add customer to a que--------------");
                        if (stock == 0) { // checks whether the stock is 0 //checks the stock availability
                            out.print("The stock is empty, Add some burgers");
                            break;
                        } else if (!(cashier3[4] == null)) {
                            out.print("the ques are full");
                        } else {
                            if (stock > 0) {  //checks the stock availability
                                if (cashier1[0] == null) {
                                    stock = FoodQue.addCustomer(cashier1, customerNames, stock, 0, 0);// the stock gets updated when adding a customer by assigning the method to it.
                                } else if (cashier1[1] == null) {
                                    stock = FoodQue.addCustomer(cashier1, customerNames, stock, 1, 1);
                                } else if (cashier2[0] == null) {
                                    stock = FoodQue.addCustomer(cashier2, customerNames, stock, 0, 0);
                                } else if (cashier2[1] == null) {
                                    stock = FoodQue.addCustomer(cashier2, customerNames, stock, 1, 1);
                                } else if (cashier2[2] == null) {
                                    stock = FoodQue.addCustomer(cashier2, customerNames, stock, 2, 2);
                                } else if (cashier3[0] == null) {
                                    stock = FoodQue.addCustomer(cashier3, customerNames, stock, 0, 0);
                                } else if (cashier3[1] == null) {
                                    stock = FoodQue.addCustomer(cashier3, customerNames, stock, 1, 1);
                                } else if (cashier3[2] == null) {
                                    stock = FoodQue.addCustomer(cashier3, customerNames, stock, 2, 2);
                                } else if (cashier3[3] == null) {
                                    stock = FoodQue.addCustomer(cashier3, customerNames, stock, 3, 3);
                                } else {
                                    stock = FoodQue.addCustomer(cashier3, customerNames, stock, 4, 4);
                                }
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
                        out.print("\nEnter que number to proceed (1,2,3) : ");
                        String removeQue = input.next(); // Selecting the que by taking user input
                        switch (removeQue) {
                            case "1":
                                for (Customer customer : cashier1) {
                                    if (!(customer == null)) {
                                        System.out.print(customer); //printing each que after adding customer
                                    }
                                }
                                out.print("\nEnter customer position to remove (1,2) :");
                                String customerLocation1 = input.next(); // Selecting the customer location by taking user input in que 1
                                if (customerLocation1.equals("1") || customerLocation1.equals("2")) {
                                    stock = FoodQue.removeCustomer(cashier1, customerNames, stock, customerLocation1);//calling removeCustomer function by passing parameters
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "2":
                                for (Customer customer : cashier2) {
                                    if (!(customer == null)) {
                                        System.out.print(customer); //printing each que after adding customer
                                    }
                                }
                                out.print("\nEnter customer position to remove (1,2,3) :");
                                String customerLocation2 = input.next();// Selecting the customer location by taking user input in que 2
                                if (customerLocation2.equals("1") || customerLocation2.equals("2") || customerLocation2.equals("3")) {
                                    stock = FoodQue.removeCustomer(cashier2, customerNames, stock, customerLocation2);//calling removeCustomer function by passing parameters
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "3":
                                for (Customer customer : cashier3) {
                                    if (!(customer == null)) {
                                        System.out.print(customer); //printing each que after adding customer
                                    }
                                }
                                out.print("\nEnter customer position to remove (1,2,3,4,5) :");
                                String customerLocation3 = input.next();// Selecting the customer location by taking user input in que 3
                                if (customerLocation3.equals("1") || customerLocation3.equals("2") || customerLocation3.equals("3") || customerLocation3.equals("4") || customerLocation3.equals("5")) {
                                    stock = FoodQue.removeCustomer(cashier3, customerNames, stock, customerLocation3);//calling removeCustomer function by passing parameters
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            default:
                                out.print("Invalid input !!\nEnter desired number\n");
                        }
                        while (true) {
                            out.print("\nDo you want to remove another customer from the que (yes/no):");
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
                        out.print("\nEnter que number to proceed (1,2,3) : ");
                        String removeServedQue = input.next(); // Selecting the que by taking user input
                        switch (removeServedQue) {
                            case "1":
                                for (Customer customer : cashier1) {// Selecting the customer location by taking user input in que 1
                                    if (!(customer == null)) {
                                        System.out.print(customer);//printing each que
                                    }
                                }
                                out.print("\nEnter customer position to remove (1,2) :");
                                String customerLocation1 = input.next();
                                if (customerLocation1.equals("1") || customerLocation1.equals("2")) {
                                    FoodQue.removeServedCustomer(cashier1, customerNames, customerLocation1);
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "2":
                                for (Customer customer : cashier2) {
                                    if (!(customer == null)) {
                                        System.out.print(customer);//printing each que after adding customer
                                    }
                                }
                                out.print("\nEnter customer position to remove (1,2,3) :");
                                String customerLocation2 = input.next();
                                if (customerLocation2.equals("1") || customerLocation2.equals("2") || customerLocation2.equals("3")) {
                                    FoodQue.removeServedCustomer(cashier2, customerNames, customerLocation2);
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            case "3":
                                for (Customer customer : cashier3) {
                                    if (!(customer == null)) {
                                        System.out.print(customer); //printing each que after adding customer
                                    }
                                }
                                out.print("\nEnter customer position to remove (1,2,3,4,5) :");
                                String customerLocation3 = input.next();
                                if (customerLocation3.equals("1") || customerLocation3.equals("2") || customerLocation3.equals("3") || customerLocation3.equals("4") || customerLocation3.equals("5")) {
                                    FoodQue.removeServedCustomer(cashier3, customerNames, customerLocation3);
                                } else {
                                    out.print("Invalid input !!\nEnter desired number\n");
                                }
                                break;
                            default:
                                out.print("Invalid input !!\nEnter desired number\n");
                        }
                        while (true) {
                            out.print("\nDo you want to remove another customer from the que (yes/no):");
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
                    out.println("--------------Current customer names who are at the que in alphabetical order--------------");
                    FoodQue.sorting(customerNames); // Sorting the customer names in the customer array
                    break;

                case "106":
                case "SPD":
                    out.println("--------------Store program data to file--------------");
                    try { // writing the customer array objects to a serialized file
                        FileOutputStream file = new FileOutputStream("FoodFaveManagementSystem.ser");
                        ObjectOutputStream value = new ObjectOutputStream(file);
                        value.writeObject(customerNames);
                        out.println("the data are loaded to the file");
                        value.close();
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case "107":
                case "LPD":
                    out.println("--------------Loading program data from file--------------");
                    try {//reading the serialized file
                        FileInputStream file = new FileInputStream("FoodFaveManagementSystem.ser");
                        ObjectInputStream value = new ObjectInputStream(file);
                        Customer[] customers = (Customer[]) value.readObject();
                        value.close();
                        file.close();
                        for (int index = 0; index < cashier1.length; index++) {
                            cashier1[index] = customers[index];
                        }
                        for (int index = 0; index < cashier2.length; index++) {
                            cashier2[index] = customers[index + 2];
                        }
                        for (int index = 0; index < cashier3.length; index++) {
                            cashier3[index] = customers[index + 5];
                        }
                        for (int index = 0; index < customers.length; index++) {
                            customerNames[index] = customers[index];
                        }
                        int count = 1; //count to display customer number
                        for (Customer customer : customers) {
                            if (!(customer == null)) { //printing the customers wile the customer positions are not null
                                out.println("customer " + count + " :- " + "First name : " + customer.firstName + ", Second name :" + customer.secondName + ", Burgers :" + customer.burgerCount);
                                count++;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "108":
                case "STK":
                    out.println("The remaining burger count in the stock : " + stock); // printing the available stock
                    break;

                case "109":
                case "AFS":
                    boolean answer = true;
                    while (answer) {//checking the stock quantity
                        out.println("--------------Add burgers to stock--------------\nEnter the number of burgers to be added : ");
                        int burgercount = input.nextInt();
                        stock += burgercount; //adding the burger's count to the prevailing stock
                        out.print("Burgers added to the stock successfully.");
                        boolean addingLoop = true;
                        while (addingLoop) {
                            out.print("\nDo you want to add more burgers [currently available - " + stock + "] (yes/no): ");
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
                    break;
                case "IFQ":
                case "110":
                    out.println("--------------Total Income--------------");
                    out.println("Number of burgers sold : " + (50 - stock) + "\nIncome : Rs." + ((50 - stock) * 650) + "/="); //total income
                    out.print("Enter que number to proceed (1,2,3) : ");
                    String que = input.next();
                    switch (que) {
                        case "1":
                            FoodQue.income("cashier1", cashier1); // the income of cashier1 is calculated here
                            break;
                        case "2":
                            FoodQue.income("cashier2", cashier2);
                            break;
                        case "3":
                            FoodQue.income("cashier3", cashier3);
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
