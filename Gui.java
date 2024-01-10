import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class Gui extends JFrame {
    public Gui (){

        setLayout(new BorderLayout(0,20));

        JPanel upperLayer = new JPanel(new BorderLayout()); // layout to group the text and btn panels together
        // The label and the drop-down menu are placed in the center

        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
        //The label
        textPanel.add(new JLabel("Select Product Category : "));
        //The drop-down menu
        String [] categories = {"All", "Electronics", "Clothing"};
        textPanel.add(new JComboBox<>(categories));
        upperLayer.add(textPanel, BorderLayout.CENTER);

        // The shopping cart button is placed in the top-right corner
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,15,20));
        btnPanel.add(new JButton("Shopping cart"));
        upperLayer.add(btnPanel, BorderLayout.EAST);
        add(upperLayer,BorderLayout.NORTH);

        //The Data to the table
        String columnHeader [] = { "Product ID", "Name", "Category","Price (£)", "Info"};
        Object productInfo [] [] = {
                    {"A1", "P1","E",25.0,"TV"},
                    {"A2", "P2","E",30.0,"T4"},
                    {"A3", "P3","E",22.0,"Te"},
                    {"A4", "P4","E",40.0,"T7"},
                    {"A5", "P5","E",2.0,"Tw3"},
                    {"A6", "P6","E",5.0,"T7"},
                    {"A7", "P7","E",90.0,"V"},
                    {"A8", "P8","E",6.0,"0V"},
                    {"A9", "P9","E",5.0,"7V"},
                    {"A10", "P10","E",25.0,"9V"}};
        DefaultTableModel model = new DefaultTableModel(productInfo,columnHeader) {
            public boolean isCellEditable(int row, int column) { // this makes the cells un editable
                return false;
            }
        };
        /*String columnHeader [] = { "Product ID", "Name", "Category","Price (£)", "Info"};
        DefaultTableModel model = new DefaultTableModel(columnHeader,0);*/

        //calling the arraylist into the gui
        /*for (Product item : systemProducts) {
            if (item instanceof  Electronics) {
                Electronics electricItem = (Electronics) item;
                Object[] productInfo = {electricItem.getProductId(), electricItem.getProductName(), "Electronics", item.getProductPrice(), "Description"};
                model.addRow(productInfo);
            } else if (item instanceof Clothing){
                Clothing dress = (Clothing) item;
                Object [] productInfo = {dress.getProductId(),dress.getProductName(),"Clothing",dress.getProductPrice(), "Description"};
                model.addRow(productInfo);

        }*/
//the table
        JTable productTable = new JTable(model);
        productTable.setModel(model);
        productTable.setRowHeight(25);
        productTable.setSize(400,150);
        productTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        productTable.setPreferredScrollableViewportSize(new Dimension(productTable.getPreferredScrollableViewportSize().width,8*productTable.getRowHeight()));
        JScrollPane productListPane = new JScrollPane(productTable);
       // productListPane.setBounds(20,140,500,260);
        productListPane.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
//the panel which has the table
        JPanel midLayer = new JPanel();
       // midLayer.setBounds(10,70,500,600);
     //   midLayer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        midLayer.add(productListPane,BorderLayout.CENTER);
        add(midLayer, BorderLayout.CENTER);
//the panel which has the lower content
        JPanel lowerMain = new JPanel(new GridLayout(1,2));
        JPanel bottomLayer = new JPanel(new GridLayout(7,2, 0,5));
        bottomLayer.setBorder(BorderFactory.createEmptyBorder(10,30,50,10));
        JLabel title = new JLabel("Selected Product - Details");
        Font type = new Font(Font.SANS_SERIF,Font.CENTER_BASELINE,16);
        title.setFont(type);
        bottomLayer.add(title);
        bottomLayer.add(new JLabel(""));
        bottomLayer.add(new JLabel("Product ID : "));
        bottomLayer.add(new JLabel("A1"));
        bottomLayer.add(new JLabel("Category : "));
        bottomLayer.add(new JLabel("Clothing"));
        bottomLayer.add(new JLabel("Name : "));
        bottomLayer.add(new JLabel("WH"));
        bottomLayer.add(new JLabel("Size : "));
        bottomLayer.add(new JLabel("S"));
        bottomLayer.add(new JLabel("Colour : "));
        bottomLayer.add(new JLabel("Red"));
        bottomLayer.add(new JLabel("Items Available : "));
        bottomLayer.add(new JLabel("6"));
        lowerMain.add(bottomLayer);

        JPanel btnPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
        JButton addBtn = new JButton("Add to Shopping cart");
        btnPanel2.setBorder(BorderFactory.createEmptyBorder(150,20,-30,100));
        btnPanel2.add(addBtn);
        lowerMain.add(btnPanel2, BorderLayout.SOUTH);
        lowerMain.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(lowerMain,BorderLayout.SOUTH);
    }

    public static void main (String [] Args){
        Gui frame = new Gui();
        frame.setTitle("WestminsterOnlineShopping");
        frame.setSize(550, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        /*JButton shoppingCartBtn = new JButton("Shopping cart");
        frame.add(shoppingCartBtn);*/
    }
}
