import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class WestministerShoppingManager implements ShoppingManager {
    private ArrayList <Product> SystemProducts = new ArrayList<Product>();
/**
 * @param item -
 * @param systemProducts -
 * */ //can be used to describe each parameter or method
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
}
