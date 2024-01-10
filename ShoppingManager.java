import java.util.ArrayList;

public interface ShoppingManager  {
    public void addNewProduct(Product item);
    public void deleteProduct(String productCode);
    public void viewProducts();
    public void saveToFile();
    public void loadData();

}
