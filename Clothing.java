import java.io.Serializable;

public class Clothing extends Product implements Serializable {
    private String colour;
    private char size;

    public Clothing(String productId, String productName, int noOfItems, double productPrice,String colour, char size){
        super(productId,productName,noOfItems,productPrice);
        this.colour = colour;
        this.size = size;
    }
    public Clothing(String productId){
        super(productId);
    }
    public String getColour(){
        return colour;
    }

    public char getSize(){
        return size;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public void setSize(char size){
        this.size = size;
    }
    @Override
    public double getProductPrice() {
        return super.getProductPrice();
    }
    @Override
    public String toString(){
        return "Clothing Product    : ID = " + getProductId() + ",Name = " + getProductName() + ", Number of Items = " + getNoOfItems() + ", Price = " + getProductPrice() + ", Colour = " + colour + ", Size = " + size;
    }
}
