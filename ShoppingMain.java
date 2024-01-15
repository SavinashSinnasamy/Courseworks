import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingMain implements Serializable {
    public static void main(String[] Args) {
            WestminsterShoppingManager products = new WestminsterShoppingManager();
            Boolean programLoop = true;
            products.loadData();
          //  products.viewProducts();
            System.out.println("The data are loaded");
            while (programLoop) {
                System.out.println("====================================================================");
                System.out.println("\t\t\t\t\tOnline Shopping System");
                System.out.println("====================================================================");
                System.out.println("Manager Option");
                System.out.println("\t1 = Add new Product");
                System.out.println("\t2 = Delete Product");
                System.out.println("\t3 = View Products");
                System.out.println("\t4 = Save setting\n");
                System.out.println("User Option");
                System.out.println("\t5 = if you are user");
                System.out.println("Select any option if you are a manager, Select option 5 if you are user.");
                Scanner input = new Scanner(System.in);
                System.out.print("Select option : ");
                int option = input.nextInt();
                switch (option) {
                    case 1:
                        while (true) {
                            try {
                            System.out.println("==========================================================");
                            System.out.println("\t\t\t\t\tAdd new Product");
                            System.out.println("==========================================================");
                            System.out.println("Categories");
                            System.out.println("\t1 = Electronics");
                            System.out.println("\t2 = Clothing");
                            System.out.print("Select Category : ");
                            int category = input.nextInt();

                            if (category == 1) {
                                System.out.print("\nEnter Product Details\n");
                                System.out.print("-------------------------");
                                System.out.print("\nEnter Product ID : ");
                                String productId = input.next();

                                System.out.print("Enter Product Name : ");
                                String name = input.next();

                                System.out.print("Enter number of items :");
                                int number = input.nextInt();

                                System.out.print("Enter Product Price :");
                                double price = input.nextDouble();

                                System.out.print("Enter Product Brand :");
                                String brand = input.next();

                                System.out.print("Enter Product's warranty period (In months) :");
                                int warranty = input.nextInt();
                                Electronics electronic = new Electronics(productId, name, number, price, brand, warranty);
                                products.addNewProduct(electronic);

                            } else if (category == 2) {
                                System.out.print("\nEnter Product Details\n");
                                System.out.print("Enter Product ID : ");
                                String productId = input.next();

                                System.out.print("Enter Product Name : ");
                                String name = input.next();

                                System.out.print("Enter number of items :");
                                int number = input.nextInt();

                                System.out.print("Enter Product Price :");
                                double price = input.nextDouble();

                                System.out.print("Enter Material colour :");
                                String colour = input.next();

                                System.out.print("Enter dress size :");
                                char size = input.next().charAt(0);

                                Clothing clothing = new Clothing(productId, name, number, price, colour, size);
                                products.addNewProduct(clothing);
                            }
                            } catch (InputMismatchException error) {
                                System.out.println("Invalid Input try again");
                            }

                            System.out.println("==========================================================");
                            System.out.print("\nDo you wish to add another product ?(Yes/No) : ");
                            String loop1 = input.next().toLowerCase();
                            if (loop1.equals("no")) {
                                break;
                            } else if (loop1.equals("yes")) {
                                continue;
                            } else {
                                System.out.print("\nInvalid input ; Back to Main menu");
                                break;
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.println("==========================================================");
                            System.out.println("\t\t\t\t\tDelete Product");
                            System.out.println("==========================================================");
                            products.viewProducts();
                            System.out.print("\nEnter Product ID : ");
                            String productId = input.next();
                            products.deleteProduct(productId);
                            System.out.println("\n==========================================================");
                            System.out.print("\nDo you wish to delete another product ? (Yes/No) : ");
                            String loop2 = input.next().toLowerCase();
                            if (loop2.equals("no")) {
                                break;
                            } else if (loop2.equals("yes")) {
                                continue;
                            } else {
                                System.out.print("\nInvalid input ; Back to Main menu");
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("==========================================================");
                        System.out.println("\t\t\t\t\tView Products");
                        System.out.println("==========================================================");

                        products.viewProducts();
                        break;
                    case 4:
                        System.out.println("==========================================================");
                        System.out.println("\t\t\t\t\tSave settings");
                        System.out.println("==========================================================");
                        products.saveToFile();
                        break;
                    case 5:
                        System.out.println("==========================================================");
                        System.out.println("\t\t\t\t\tShopping cart");
                        System.out.println("==========================================================");
                        products.openGui();
                        System.out.println("View on the Gui");
                        break;
                    default:
                        System.out.println("Invalid Selection");
                }
                System.out.print("\nDo you wish to continue ? (Yes/No) : ");
                String loopInput = input.next().toLowerCase();
                if (loopInput.equals("no")) {
                    System.out.print("Program terminated");
                    break;
                } else if (loopInput.equals("yes")) {
                    continue;
                } else {
                    System.out.print("Invalid input, Program terminated");
                    break;
                }
            }
    }
}
       