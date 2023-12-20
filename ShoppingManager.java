import java.util.ArrayList;

public interface ShoppingManager  {
    public void addNewProduct(ArrayList<Product> systemProducts, Product item);
    public void deleteProduct(ArrayList <Product> systemProducts, Product item);
    public void viewProducts(ArrayList <Product> systemProducts);
    public void saveToFile(ArrayList <Product> systemProducts);
    public void loadData();

}
