import java.util.Scanner;

public class Main {
    public static void main (String [] Args){
        WestministerShoppingManager Products = new WestministerShoppingManager();
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
        System.out.print("Select option :");
        int option = input.nextInt();

        switch (option){
            case 1 :
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

                    System.out.print("Enter Prouduct's warranty period (In months) :");
                    int warranty = input.nextInt();

                    Electronics electronic = new Electronics(productId, name, number, price, brand, warranty);
                }
                else if (category == 2) {
                    System.out.print("\nEnter Product Details\n");
                    System.out.print("Enter Product ID");
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
                    int size = input.nextInt();

                    Clothing clothing = new Clothing(productId, name, number, price, colour, size);


                }
                System.out.println("==========================================================");
                break;
            case 2:
                System.out.println("==========================================================");
                System.out.println("\t\t\t\t\tDelete Product");
                System.out.println("==========================================================");
                break;
            case 3:
                System.out.println("==========================================================");
                System.out.println("\t\t\t\t\tView Products");
                System.out.println("==========================================================");
                break;
            case 4:
                System.out.println("==========================================================");
                System.out.println("\t\t\t\t\tSave settings");
                System.out.println("==========================================================");
                break;
            case 5:
                System.out.println("==========================================================");
                System.out.println("\t\t\t\t\tShooping cart");
                System.out.println("==========================================================");
        }
    }
}
