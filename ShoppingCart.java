import java.util.ArrayList;

public class ShoppingCart {
    Product instance2;
    public static ArrayList<ShoppingCart> ShoppingProductList = new ArrayList<ShoppingCart>();
    private String id, name, category;
    private double price;
    private int count;
    double discount1 = 0, discount2 = 0, Finalprices = 0;

    public ShoppingCart(String productName, int count, double price, String productId, String category) {
        this.name = productName;
        this.count = count;
        this.price = price;
        this.id = productId;
        this.category = category;
    }

    public ShoppingCart() {
    }

    public String getProductId() {
        return id;
    }

    public void setProductId(String productId) {
        this.id = productId;
    }

    public void addProduct(ArrayList<ShoppingCart> list, ShoppingCart product1) { // made changes
        String productCode = product1.getProductId();
        //  ArrayList<ShoppingCart> copyList = new ArrayList<>(list);
        for (Product item : WestminsterShoppingManager.systemProductsList) {
            if (item.getProductId().equals(productCode)) {
                int num = item.getNoOfItems();
                if (num > 0) {
                    list.add(product1);
                    /*if(list.isEmpty()) {
                        list.add(product1);
                    }
                    else {
                        copyList.addAll(list);
                        for (ShoppingCart item2 : list) {
                            if (item2.getProductId().equals(product1.getProductId())) {
                                item2.setCount(item2.getCount() + 1);
                            } else { // Concurrency exception is occurred
                                copyList.add(product1);
                                list.clear();
                            }
                        }
                        list.addAll(copyList);
                               *//* loop = false;
                                break;
                            }
                        }
                        for (ShoppingCart item2 : ShoppingProductList) {
                            if (loop) {
                                item2.setCount(item2.getCount() + 1);
                                break;
                            }
                        }*/
                }
                    item.setNoOfItems(item.getNoOfItems()-1);
                } else {
                    System.out.println("The product is not more available");
                }
            }
        }
    public void removeProduct(ArrayList <ShoppingCart> list,ShoppingCart product) {
        String productCode = product.getProductId();
        for (Product item : WestminsterShoppingManager.systemProductsList) {
            if (item.getProductId().equals(productCode)) {
                int num = item.getNoOfItems();
                if (num > 0) {
                    list.remove(product);
                    item.setNoOfItems(item.getNoOfItems() + 1);
                } else {
                    System.out.println("The product is not more available");
                }
            }
        }
    }

    public ArrayList<ShoppingCart> getArraylist() {
        return ShoppingProductList;
    }

    public double calculateTotal(ArrayList<ShoppingCart> list) { // made changes
        double finalPrice = 0;
        for (ShoppingCart product : list) {
            finalPrice = finalPrice + product.getPrice() * product.getCount();
        }
        return finalPrice;
    }

    public double calculateFinal(ArrayList<ShoppingCart> list) { //made changes
        double grandTotal = 0;
        Finalprices = calculateTotal(list);
        grandTotal = Finalprices - (calculateDiscount(list) + calculateDiscount2(list));
        return grandTotal;
    }

    public double calculateDiscount(ArrayList<ShoppingCart> list) { // made changes
        double prices = calculateTotal(list);
        discount1 = prices * 0.1;
        return discount1;
    }

    public double calculateDiscount2(ArrayList<ShoppingCart> list) { //made changes
        int electricCount = 0, clothingCount = 0;
        double prices2 = calculateTotal(list);
        for (ShoppingCart item : list) {
            if (item.category.equals("Electronics")) {
                electricCount += 1;
            } else {
                clothingCount += 1;
            }
        }
        if (electricCount >= 3 || clothingCount > 3) {
            discount2 = prices2 * 0.2;
        } else {
            discount2 = 0;
        }
        return discount2;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
    @Override
    public String toString() {
        return "ShoppingCart Product : ID = " + id + ", Name = " + name + ", Price = " + price + ", Item count = " + count + ", Category = " + category;
    }
}
