abstract class Product {
    private String productId;
    private String productName;
    private int noOfItems;
    private double productPrice;

    public Product(String productId, String productName, int noOfItems, double productPrice){
        this.productId = productId;
        this.productName = productName;
        this.noOfItems = noOfItems;
        this.productPrice = productPrice;
    }

    public Product(String productId){
        this.productId = productId;
    }

    public String getProductId(){
        return productId;
    }

    public String getProductName(){
        return productName;
    }

    public int getNoOfItems(){
        return noOfItems;
    }

    public double getProductPrice(){
        return productPrice;
    }

    public void setProductId(String productId){
        this.productId = productId;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setNoOfItems(int noOfItems){
        this.noOfItems = noOfItems;
    }

    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }

    @Override
    public String toString(){
        return "Product : ID = " + productId + ",Name = " + productName + ", Number of Items = " + noOfItems + ", Price = "+ productPrice;
    }


}
