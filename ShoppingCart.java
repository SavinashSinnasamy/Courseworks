import java.util.ArrayList;

public class ShoppingCart{
    private ArrayList <Product> ShoppingProductList = new ArrayList<Product>();



    public void addProduct(Product product){
        ShoppingProductList.add(product);
    }
    public void removeProduct(Product product){
        ShoppingProductList.remove(product);
        product.setNoOfItems(product.getNoOfItems() - 1);
    }

    public double calculateTotal(){
        double finalPrice = 0;
        for (Product item : ShoppingProductList){
            finalPrice = finalPrice +  item.getProductPrice();
        }
        return finalPrice;
    }

}
