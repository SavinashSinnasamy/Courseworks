import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;;

public class WestminsterGui extends JFrame {
    private ShoppingCartGui instance;
    ArrayList<Product> instanceArray;
    JLabel pId,  pCategory , pName ,title, brandORSize, warrantyORColour, brandLabel, warrantySize, itemAvailability, itemAvailabilityLabel, pIdLabel, pCategoryLabel , pNameLabel;
    JTable productTable;
    JButton shoppingCartBtn, addBtn;
    String brandTest, colourTest;
    int warrantyTest, itemCount1, itemCount2;
    char sizeTest;
    double priceTest1, priceTest2;
    private int productCount;
    ShoppingCart cartInstance = new ShoppingCart();

    String [] columnHeader = {"Product ID", "Name", "Category", "Price (£)", "Info"};
    private DefaultTableModel myModel;

    private JComboBox <String> categorization;

    public WestminsterGui() {

        // WestminsterShoppingManager object = new WestminsterShoppingManager(); // creating an object to call the arraylist
        this.instanceArray = WestminsterShoppingManager.systemProductsList;

        setLayout(new BorderLayout(0, 20));

        JPanel upperLayer = new JPanel(new BorderLayout(10, 0)); // layout to group the text and btn panels together
        // The label and the drop-down menu are placed in the center

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));

        textPanel.add(new JLabel("Select Product Category : "));//The label
        String[] categories = {"All", "Electronics", "Clothing"};//The drop-down menu
        categorization = new JComboBox(categories);
        textPanel.add(categorization);

        upperLayer.add(textPanel, BorderLayout.CENTER);

        // The shopping cart button is placed in the top-right corner
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 20));
        shoppingCartBtn = new JButton("Shopping cart");

        btnPanel.add(shoppingCartBtn);
        upperLayer.add(btnPanel, BorderLayout.EAST);

        add(upperLayer, BorderLayout.NORTH);

        //The Data to the table

//the table
        JPanel midLayer = new JPanel(new FlowLayout());
        productTable = new JTable(myModel);
        productTable.setVisible(true);
        productTable.setRowHeight(25);
        productTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        productTable.setPreferredScrollableViewportSize(new Dimension(450, 4 * productTable.getRowHeight()));
        JScrollPane productListPane = new JScrollPane(productTable);


//the panel which has the table
        //   midLayer.setPreferredSize(new Dimension(550,150));
        midLayer.add(productListPane);
        productListPane.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));
        midLayer.setVisible(true);
        add(midLayer, BorderLayout.CENTER);

//the panel which has the lower content
        JPanel lowerMain = new JPanel(new BorderLayout(20,10));
        title = new JLabel("Selected Product - Details");
        Font type = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        title.setFont(type);
        lowerMain.add(title,BorderLayout.NORTH);
        title.setVisible(false);

        JPanel bottomLayer = new JPanel(new GridLayout(6, 2, 0, 10));
        bottomLayer.setBorder(BorderFactory.createEmptyBorder(10, 20, 30, 0));
        pIdLabel = new JLabel("Product Id");
        bottomLayer.add(pIdLabel);
        pIdLabel.setVisible(false);

        pId = new JLabel();
        bottomLayer.add(pId);
        pId.setVisible(false);

        pCategoryLabel = new JLabel("Category");
        bottomLayer.add(pCategoryLabel);
        pCategoryLabel.setVisible(false);
        pCategory = new JLabel();
        bottomLayer.add(pCategory);
        pCategory.setVisible(false);

        pNameLabel = new JLabel("Name : ");
        bottomLayer.add(pNameLabel);
        pNameLabel.setVisible(false);

        pName = new JLabel();
        bottomLayer.add(pName);
        pName.setVisible(false);

        brandORSize = new JLabel();
        bottomLayer.add(brandORSize);

        brandLabel = new JLabel();
        bottomLayer.add(brandLabel);

        warrantyORColour = new JLabel();
        bottomLayer.add(warrantyORColour);
        warrantyORColour.setVisible(false);

        warrantySize = new JLabel();
        bottomLayer.add(warrantySize);

        itemAvailabilityLabel =  new JLabel("Items Available : ");
        bottomLayer.add(itemAvailabilityLabel);
        itemAvailabilityLabel.setVisible(false);

        itemAvailability = new JLabel();
        bottomLayer.add(itemAvailability);
        itemAvailability.setVisible(false);

        lowerMain.add(bottomLayer,BorderLayout.CENTER);

        JPanel btnPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        addBtn = new JButton("Add to Shopping cart");
        btnPanel2.add(addBtn);
        lowerMain.add(btnPanel2,BorderLayout.EAST);
        lowerMain.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(lowerMain, BorderLayout.SOUTH);

        // Event Handling
        //registering event handlers
        // ActionListeners handler = new ActionListeners();

        categorization.addActionListener(new ActionListeners());
        shoppingCartBtn.addMouseListener(new MouseClicks());
        productTable.addMouseListener(new MouseClicks());
     //   addBtn.addMouseListener(new MouseClicks());
        addBtn.addActionListener(new ActionListeners());
    }
    private void ShoppingCartGuiOpening() {
        if (instance != null) {
            instance.updateShopTable(cartInstance.getArraylist());
            instance.addLabels(cartInstance.getArraylist());
            instance.setVisible(true);
            System.out.println("new");

        } else {
            //Displaying the shopping cart without covering the shopping gui and the frame setup
            instance = new ShoppingCartGui();
            Point frame1Loc = getLocation();
            int frame2LocX = (int) (frame1Loc.getX() + 450);
            int frame2LocY = (int) (frame1Loc.getY() + 80);
            instance.setLocation(frame2LocX, frame2LocY);
            instance.setVisible(true);
            System.out.println("old");
        }
    }
    public void updateTable(ArrayList<Product> productList) {
        // Clear existing data in the table
        if (myModel != null) {
            while (myModel.getRowCount() > 0) {
                myModel.setRowCount(0);
            }
            // Add new data to the table
            for (Product product : productList) {
                if (product instanceof Electronics) {
                    Object[] rowData = {product.getProductId(), product.getProductName(), "Electronics", product.getProductPrice()," Description"};
                    myModel.addRow(rowData);
                } else {
                    Object[] rowData = {product.getProductId(), product.getProductName(), "Clothing", product.getProductPrice(), "Description"};
                    myModel.addRow(rowData);
                }
            }
        }
    }
    private class MouseClicks extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == shoppingCartBtn) {
                ShoppingCartGuiOpening();
            }
            int clickedRow = productTable.getSelectedRow();
            if (clickedRow != -1) {
                productTable.setSelectionBackground(Color.CYAN);
                Product selectedProduct = instanceArray.get(clickedRow);
                String product = selectedProduct.getProductId();
                if (selectedProduct instanceof Electronics && selectedProduct.getProductId().equals(product)) {
                    brandTest = ((Electronics) selectedProduct).getBrand();
                    warrantyTest = ((Electronics) selectedProduct).getWarrantyPeriod();
                    itemCount1 = selectedProduct.getNoOfItems();
                    priceTest1 = selectedProduct.getProductPrice();

                } else if (selectedProduct instanceof Clothing && selectedProduct.getProductId().equals(product)) {
                    sizeTest = ((Clothing) selectedProduct).getSize();
                    colourTest = ((Clothing) selectedProduct).getColour();
                    itemCount2 = selectedProduct.getNoOfItems();
                    priceTest2 = selectedProduct.getProductPrice();
                }
                pId.setText(productTable.getValueAt(clickedRow, 0).toString());
                pName.setText(productTable.getValueAt(clickedRow, 1).toString());
                pCategory.setText(productTable.getValueAt(clickedRow, 2).toString());
                title.setVisible(true);
                pId.setVisible(true);
                pCategoryLabel.setVisible(true);
                pCategory.setVisible(true);
                pName.setVisible(true);
                pNameLabel.setVisible(true);
                pIdLabel.setVisible(true);
                itemAvailabilityLabel.setVisible(true);
                if (selectedProduct instanceof Electronics) {
                    brandORSize.setText("Brand :");
                    brandORSize.setVisible(true);
                    brandLabel.setVisible(true);
                    warrantyORColour.setText("Warranty Period :");
                    warrantyORColour.setVisible(true);
                    brandLabel.setText((brandTest));
                    warrantySize.setText((warrantyTest + "  Months"));
                    warrantySize.setVisible(true);
                    itemAvailability.setText(String.valueOf(itemCount1));
                    itemAvailability.setVisible(true);
                } else {
                    brandORSize.setText("Size :");
                    brandORSize.setVisible(true);
                    brandLabel.setVisible(true);
                    warrantyORColour.setText("Colour :");
                    warrantyORColour.setVisible(true);
                    brandLabel.setText(colourTest);
                    warrantySize.setText(String.valueOf(sizeTest));
                    warrantySize.setVisible(true);
                    itemAvailability.setText(String.valueOf(itemCount2));
                    itemAvailability.setVisible(true);
                }
            }
        }
    }

   private class ActionListeners implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String choice = (String) categorization.getSelectedItem();
        //calling the electronic section of arraylist into the gui
        if (choice.equals("Electronics")) {
            myModel = new DefaultTableModel(columnHeader, 0) {
                public boolean isCellEditable(int row, int column) { // this makes the cells un editable
                    return false;
                }
            };
            //calling the arraylist into the gui
            for (Product item : instanceArray) {
                if (item instanceof Electronics) {
                    Electronics electricItem = (Electronics) item;
                    Object[] productInfo = {electricItem.getProductId(), electricItem.getProductName(), "Electronics", electricItem.getProductPrice(), "Description"};
                    myModel.addRow(productInfo);
                    }
                }
            productTable.setModel(myModel);
        }
        //calling the clothes section of arraylist into the gui
        else if (choice.equals("Clothing")) {
            myModel = new DefaultTableModel(columnHeader, 0) {
                public boolean isCellEditable(int row, int column) { // this makes the cells un editable
                    return false;
                }
            };
            //calling the arraylist into the gui
            for (Product item : instanceArray) {
                if (item instanceof Clothing) {
                    Clothing dress = (Clothing) item;
                    Object[] productInfo = {dress.getProductId(), dress.getProductName(), "Clothing", dress.getProductPrice(), "Description"};
                    myModel.addRow(productInfo);
                }
            }
            productTable.setModel(myModel);
        }
        //calling the of arraylist into the gui
        else if (choice.equals("All")) {
            myModel = new DefaultTableModel(columnHeader, 0) {
                public boolean isCellEditable(int row, int column) { // this makes the cells un editable
                    return false;
                }
            };
            //calling the arraylist into the gui
            for (Product item : instanceArray) {
                if (item instanceof Electronics) {
                    Electronics electricItem = (Electronics) item;
                    Object[] productInfo = {electricItem.getProductId(), electricItem.getProductName(), "Electronics", item.getProductPrice(), "Description"};
                    myModel.addRow(productInfo);
                } else if (item instanceof Clothing) {
                    Clothing dress = (Clothing) item;
                    Object[] productInfo = {dress.getProductId(), dress.getProductName(), "Clothing", dress.getProductPrice(), "Description"};
                    myModel.addRow(productInfo);
                }
            }
            productTable.setModel(myModel);

        }
        int clickedRow2 = productTable.getSelectedRow();
        if (clickedRow2 != -1) {
            String productId = productTable.getValueAt(clickedRow2, 0).toString();
            String productName = productTable.getValueAt(clickedRow2, 1).toString();
            String category = productTable.getValueAt(clickedRow2, 2).toString();
            String prices = productTable.getValueAt(clickedRow2, 3).toString();
            productCount = 1;
            double price = Double.parseDouble(prices);
            System.out.println(productCount + "    " + productId + "        " + productName + "        " + category);
            ShoppingCart cartIn = new ShoppingCart(productName, productCount, price, productId, category);
            cartInstance.addProduct(cartInstance.getArraylist(), cartIn);
            for (ShoppingCart item : cartInstance.getArraylist() ) {
                System.out.println(item.toString());
            }
            ShoppingCartGuiOpening();
        }
    }
}
}