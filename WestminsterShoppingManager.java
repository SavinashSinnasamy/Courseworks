import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WestminsterShoppingManager implements ShoppingManager, Serializable {
    public static ArrayList<Product> systemProductsList = new ArrayList<Product>();
    private WestminsterGui frame;
    /**
     * @param item - the product detail which is object is added to the list
     */ //can be used to describe each parameter or method
    public void addNewProduct(Product item) {
        if (systemProductsList.size() <= 50) {
            String productCode = item.getProductId();
            boolean productExistence = false;
            for (Product thing : systemProductsList) {
                String availableProduct = thing.getProductId();
                if (productCode.equals(availableProduct)) {
                    productExistence = true;
                    System.out.print("Invalid ID, A product exist with the above ID, therefore Try Again..\n ");
                    System.out.println("\n" + thing);
                    break;
                }
            }
            if (!productExistence) {
                System.out.println("The product added successfully");
                systemProductsList.add(item);
                System.out.println("\n" + item);
            }

        } else {
            System.out.println("Reached Maximum number - Only 50 products are allowed.");
        }
    }
    public void deleteProduct(String productCode ) {
        int totalCount = systemProductsList.size();
        System.out.println(productCode);
        if (totalCount != 0){
            for (Product item : systemProductsList) {
                System.out.println(item.getProductId());
                if (productCode.equals(item.getProductId())) {
                    systemProductsList.remove(item);
                    System.out.print("The product has been deleted successfully");
                    totalCount = totalCount - 1;
                    System.out.println("\nNo of Products in the store : " + totalCount);
                    break;
                }
            }
        } else {
            System.out.println("No products to delete");
        }
    }
    public void viewProducts() {
        sortProductList(systemProductsList);
        for (Product item : systemProductsList) {
            System.out.println(item.toString());
        }
    }

    public void saveToFile() {
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
            if (!file.exists()){ //check whether the file exists.
                file.createNewFile();
            } //Check whether the file is empty
            if (!file.exists() || file.length() == 0) {
                return;
            }
            FileInputStream file2 = new FileInputStream(file);
            ObjectInputStream value = new ObjectInputStream(file2);
            systemProductsList = (ArrayList)  value.readObject();
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
    public void openGui() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    if (frame != null) {
                            if (!frame.isVisible()){
                                frame.setVisible(true);
                            } else {
                                frame.updateTable(systemProductsList);
                            }
                    } else {
                        frame = new WestminsterGui();
                        frame.setTitle("WestminsterOnlineShopping");
                        frame.setSize(550, 600);
                        frame.setVisible(true);
                        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        frame.setLocationRelativeTo(null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private static class ProductNameComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            // Compare product names in a case-insensitive manner
            return p1.getProductId().compareToIgnoreCase(p2.getProductId());
        }
    }

    // Method to sort the ArrayList based on product names
    private static void sortProductList(ArrayList<Product> productList) {
        Collections.sort(productList, new ProductNameComparator());
    }
}