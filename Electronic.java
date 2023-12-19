public class Electronic extends Product {

    private String brand;
    private int warrantyPeriod;

    public Electronic(String productId, String productName, int noOfItems, double productPrice, String brand, int warrantyPeriod){
        super(productId, productName,noOfItems,productPrice);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public Electronic(String productId, String productName, int noOfItems, double productPrice, String brand){
        super(productId, productName,noOfItems,productPrice);
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }
    public int getWarrantyPeriod(){
        return warrantyPeriod;
    }

    public void setBrand(){
        this.brand = brand;
    }

    public void setWarrantyPeriod(){
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString(){
        return "Electrionic Product : ID = " + getProductId() + ",Name = " + getProductName() + ", Number of Items = " + getNoOfItems() + ", Price = "+ getProductPrice() + ",Brand = " + brand + ", Warranty Period = " + warrantyPeriod;
    }
}
