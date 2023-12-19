public class Clothing extends Product{
    private String colour;
    private int size;

    public Clothing(String productId, String productName, int noOfItems, double productPrice,String colour, int size){
        super(productId,productName,noOfItems,productPrice);
        this.colour = colour;
        this.size = size;
    }

    public String getColour(){
        return colour;
    }

    public int getSize(){
        return size;
    }

    public void setColour(){
        this.colour = colour;
    }

    public void setSize(){
        this.size = size;
    }

    @Override
    public String toString(){
        return "Clothing Product : ID = " + getProductId() + ",Name = " + getProductName() + ", Number of Items = " + getNoOfItems() + ", Price = " + getProductPrice() + ", Colour = " + colour + ", Size" + size;
    }
}
