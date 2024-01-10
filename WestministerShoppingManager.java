import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
public class WestministerShoppingManager implements ShoppingManager {
    public ArrayList<Product> systemProductsList = new ArrayList<Product>();


    /**
     * @param item - the product detail which is object is added to the list
     */ //can be used to describe each parameter or method
    public void addNewProduct(Product item) {
       /* String productCode = item.getProductId();
        for (Product thing : systemProductsList ){
            if (thing.getProductId()){
                System.out.print("Invalid ID, A product exist with the above ID, therefore Try Again.. ");
            }else {*/
                System.out.println("The product added successfully");
                systemProductsList.add(item);

           /* }
       }*/
    }

    public void deleteProduct(String productCode) {
        for (Product item : systemProductsList){
            if (productCode.equals(item.getProductId())) {
                systemProductsList.remove(item);
                System.out.print("The product has been deleted successfully");
                break;
            } else {
                System.out.println("The product doesn't exists");
            }
        }
    }

    public void viewProducts() {
        for (Product item : systemProductsList) {
            System.out.println(item.toString());
        }
    }

    public void saveToFile() {
        System.out.println("summary of Products");
        try { // writing the product objects arraylist to a serialized file
            File file = new File("systemProducts.ser");
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream file2 = new FileOutputStream(file);
            ObjectOutputStream value = new ObjectOutputStream(file2);
            value.writeObject(systemProductsList);
            System.out.println("the data are stored into to the file");
            value.close();
            file2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadData() {
        try {
            File file = new File("systemProducts.ser");
            if (!file.exists()){
                file.createNewFile();
            }
            FileInputStream file2 = new FileInputStream(file);
            ObjectInputStream value = new ObjectInputStream(file2);
            ArrayList<Product> systemProductsList = (ArrayList <Product>) value.readObject();
            value.close();
            file2.close();
        } catch(IOException e) {
            System.out.println("good day");
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            System.out.print("File not found again");
            throw new RuntimeException(e);
        }
    }
}