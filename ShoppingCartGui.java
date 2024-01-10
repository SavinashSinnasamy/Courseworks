import javax.print.AttributeException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class ShoppingCartGui extends JFrame {
    ShoppingCartGui(){
        setLayout(new GridLayout(2,1));
        String [] columns = {"Product", "Quantity", "Price"};
        Object [][] TableInfo = {{"1","2","3"},{"1","2","3"}, {"1","2","3"},{"1","2","3"},{"1","2","3"}};

        TableModel model = new DefaultTableModel(TableInfo,columns){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };

        JTable ShoppingTable = new JTable(model);
        ShoppingTable.setModel(model);
        ShoppingTable.setRowHeight(40);
        ShoppingTable.setSize(400,150);
        ShoppingTable.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        ShoppingTable.setPreferredScrollableViewportSize(new Dimension (ShoppingTable.getPreferredScrollableViewportSize().width,3*ShoppingTable.getRowHeight()));
        JScrollPane scrollTablePane = new JScrollPane(ShoppingTable);
        scrollTablePane.setBorder(BorderFactory.createEmptyBorder(50,20,40,20));
        add(scrollTablePane);


        JPanel lowerPanel = new JPanel(new GridLayout(4,2,50,5));
        lowerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lowerPanel.setAlignmentX(RIGHT_ALIGNMENT);
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(10,50,50,-150));
        Font text = new Font(Font.DIALOG,Font.LAYOUT_RIGHT_TO_LEFT,12);
        JLabel total = new JLabel("Total - ");
        total.setFont(text);
        total.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(total);
        lowerPanel.add(new JLabel("12.00"));
        JLabel discount1 = new JLabel("First Purchase Discount (10%) - ");
        discount1.setFont(text);
        discount1.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(discount1);
        lowerPanel.add(new JLabel("12.00"));
        JLabel discount2 = new JLabel("Three times in same category (20%) - ");
        discount2.setFont(text);
        discount2.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(discount2);
        lowerPanel.add(new JLabel("12.00"));
        JLabel grandTotal = new JLabel("Grand Total");
        Font type = new Font(Font.SANS_SERIF,Font.BOLD,16);
        grandTotal.setFont(type);
        grandTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        lowerPanel.add(grandTotal);
        lowerPanel.add(new JLabel("12.00"));

        add(lowerPanel);


    }
    public static void main (String [] Args){
        ShoppingCartGui frame = new ShoppingCartGui();
        frame.setTitle("Shopping cart");
        frame.setSize(550, 600);
        frame.setBackground(Color.BLUE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        /*JButton shoppingCartBtn = new JButton("Shopping cart");
        frame.add(shoppingCartBtn);*/
    }
}
