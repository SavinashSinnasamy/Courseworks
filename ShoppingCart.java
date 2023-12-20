import java.util.ArrayList;

public class ShoppingCart{
    private ArrayList <Product> ProductList = new ArrayList<Product>();


    public void addProduct(Product product){
        ProductList.add(product);
    }
    public void removeProduct(Product product){
        ProductList.remove(product);
    }

    public double calculateTotal(ArrayList <Product> productList){
        double finalPrice = 0;
        for (Product item : productList){
            finalPrice += item.getProductPrice();

        }
        return finalPrice;
    }
}
