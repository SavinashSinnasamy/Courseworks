import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class WestministerShoppingManager implements ShoppingManager {
    private ArrayList <Product> SystemProducts = new ArrayList<Product>();
/**
 * @param item -
 * @param systemProducts - */ //can be used to describe each parameter or method
    public void addNewProduct(ArrayList <Product> systemProducts, Product item){
        systemProducts.add(item);
    }

    public void deleteProduct(ArrayList <Product> systemProducts, Product item){
        systemProducts.remove(item);
    }
    public void viewProducts(ArrayList <Product> systemProducts){
        for(Product item : systemProducts){
            System.out.println(item.toString());
        }
    }
    public void saveToFile(ArrayList <Product> systemProducts){

        /*System.out.println("--------------Store program data to file--------------");
        try { // writing the customer array objects to a serialized file
            FileOutputStream file = new FileOutputStream("FoodFaveManagementSystem.ser");
            ObjectOutputStream value = new ObjectOutputStream(file);
            ArrayList <Product> SystemProductsCopy = new ArrayList<Product>(); //declaring the length of the array
            for (int index = 0; index < systemProducts.size()+1 ; index++) {
                SystemProductsCopy[index] = systemProducts[index];
            }
            //storing the current stock amount to the file
            cashierCopy[10] = new Customer("null", "null", burgerCount); //creating an object to store the burger count since an object array is written into the file
            value.writeObject(cashierCopy);
            out.println("the data are stored into to the file");
            value.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
    public void loadData(){

    }

    public static void main (String [] Args){
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
        System.out.println("Select option :");
        int option = input.nextInt();

        switch (option){
            case 1 :
                System.out.println("==========================================================");
                System.out.println("\t\t\t\t\tAdd new Product");
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
        ;}
}
