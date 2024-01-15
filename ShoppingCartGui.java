import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShoppingCartGui extends JFrame {
    private final DefaultTableModel model;
    ShoppingCart cartOptions = new ShoppingCart();
    String [] columns = {"Product", "Quantity", "Price"};
    JTable ShoppingTable;
    ArrayList<ShoppingCart> array1 = ShoppingCart.ShoppingProductList;
    JLabel bill, dis, dis2, grand;
    JButton remove;

    String productId, category;

    ShoppingCartGui() {
        setLayout(new GridLayout(2, 1));
        model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column) { // this makes the cells un editable
                return false;
            }
        };

        //calling the arraylist into the gui
        for (ShoppingCart item : array1) {
            //  Object [] product = {};
            Object[] product = {item.getProductId(), String.valueOf(item.getCount()), item.getPrice()};
            model.addRow(product);
        }

        ShoppingTable = new JTable(model);
        ShoppingTable.setRowHeight(40);
        ShoppingTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        ShoppingTable.setPreferredScrollableViewportSize(new Dimension(ShoppingTable.getPreferredScrollableViewportSize().width, 3 * ShoppingTable.getRowHeight()));
        JScrollPane scrollTablePane = new JScrollPane(ShoppingTable);
        scrollTablePane.setBorder(BorderFactory.createEmptyBorder(50, 20, 40, 20));
        remove = new JButton("Remove");
        remove.setSize(60, 10);
        upperPanel.add(remove);
        remove.setVisible(true);
        upperPanel.add(scrollTablePane);
        add(upperPanel);

        JPanel lowerPanel = new JPanel(new GridLayout(4, 2, 50, 5));
        lowerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lowerPanel.setAlignmentX(RIGHT_ALIGNMENT);
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 50, -150));
        Font text = new Font(Font.DIALOG, Font.LAYOUT_RIGHT_TO_LEFT, 12);
        JLabel total = new JLabel("Total - ");
        total.setFont(text);
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(total);

        bill = new JLabel();
        lowerPanel.add(bill);
        bill.setVisible(true);

        JLabel discount1 = new JLabel("First Purchase Discount (10%) - ");
        discount1.setFont(text);
        discount1.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(discount1);

        dis = new JLabel();
        lowerPanel.add(dis);
        dis.setVisible(true);


        JLabel discount2 = new JLabel("Three times in same category (20%) - ");
        discount2.setFont(text);
        discount2.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(discount2);

        dis2 = new JLabel();
        lowerPanel.add(dis2);
        dis2.setVisible(true);

        JLabel grandTotal = new JLabel("Grand Total");
        Font type = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        grandTotal.setFont(type);
        grandTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(grandTotal);

        grand = new JLabel();
        lowerPanel.add(grand);

        add(lowerPanel);

    //    setVisible(false);
        setSize(500, 530);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Shopping cart");
        setLocationRelativeTo(null);

        remove.addMouseListener(new MouseClicks());
    }

    public void updateShopTable(ArrayList<ShoppingCart> productList) {
        // Clear existing data in the table
        //  if (model != null) {
            while (model.getRowCount() > 0) {
                model.setRowCount(0);
            }
            // Add new data to the table
            for (ShoppingCart product : productList) {
                Object[] rowData = {product.getName(), product.getCount(), product.getPrice()};
                model.addRow(rowData);
            }
        //}
    }
    public void addLabels(ArrayList<ShoppingCart> list) {
        if (!cartOptions.getArraylist().isEmpty() ) {
            double totalVal = cartOptions.calculateTotal(list);
            System.out.println(totalVal);
            bill.setText(String.valueOf(totalVal));

            double discount = cartOptions.calculateDiscount(list);
            System.out.println(discount);
            dis.setText(String.valueOf(discount));

            double discount01 = cartOptions.calculateDiscount2(list);
            System.out.println(discount01);
            dis2.setText(String.valueOf(discount01));

            double grandFinal = cartOptions.calculateFinal(list);
            System.out.println(grandFinal);
            grand.setText(String.valueOf(grandFinal));
        } else {
            bill.setText(String.valueOf(0.0));
            dis.setText(String.valueOf(0.0));
            dis2.setText(String.valueOf(0.0));
            grand.setText(String.valueOf(0.0));
            System.out.println("No products added");
        }
        updateShopTable(list);
    }
    private class MouseClicks extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int clickedRow = ShoppingTable.getSelectedRow();
            if (e.getSource() == remove) {
                try {
                    //  ShoppingCartGuiOpening();
                    ShoppingCart selectedProduct = cartOptions.getArraylist().get(clickedRow);
                    cartOptions.removeProduct(cartOptions.getArraylist(), selectedProduct);
                    updateShopTable(cartOptions.getArraylist());
                    addLabels(cartOptions.getArraylist());
                } catch (NullPointerException error) {
                    System.out.println("error1");
                }
            }
        }
    }
}



