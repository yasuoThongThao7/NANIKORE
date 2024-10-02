import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelEnterWarehouse extends JPanelMini {
    private JLabel text = new JLabel("Nhập kho");
    private JLabel image = new JLabel();
    public JPanelEnterWarehouse() {
        //image
        image.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\vaokho.png"));
        image.setBounds(20,2,48,48);
        add(image);
        //text
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        text.setBounds(130, 10, 100, 30);
        add(text);
        // Thiết lập JPanelHome
        setBounds(0, 310, 280, 60);
        setLayout(null);
        setBackground(new Color(25, 188, 211));
    }
}

class JPanelEnterWarehouseMenu extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JPanel panelTable,panelText;
    private AddPanel panelAddProduct =  new AddPanel(10);
    private DefaultTableModel model;
    public JPanelEnterWarehouseMenu() {
            // Panel chứa JTextField
            panelText = new JPanel();
            panelText.setLayout(null);
            panelText.setBackground(new Color(25, 188, 211));

            //Thiết lập JTable
            String[] columnNames = {"ID","Mặt hàng","Giá nhập","Hãng","Số lượng","Điều chỉnh"};
            model = new DefaultTableModel(columnNames,15);
            if( ListEnterWareHouse.LIST_ENTER_WAREHOUSE != null) {
                for(Products products : ListEnterWareHouse.LIST_ENTER_WAREHOUSE){
                    addObject(products);
                }
            }
            jTable = new Table(model);
            // Tên table
            JLabel label = new JLabel("DANH SÁCH HÀNG NHẬP : ");
            label.setFont(new Font("Tahoma", Font.BOLD, 15));
            label.setBounds(10, 10, 250, 30);
            label.setForeground(new Color(102, 102, 102, 252));
            // Table
            jScrollPane = new ScrollPane(jTable);
            panelTable = new RoundedPanel(30);
            panelTable.setBounds(50,280,800,350);
            panelTable.add(jScrollPane);
            panelTable.add(label);
            // Thêm hàng hóa
            addListener(panelAddProduct.getjButton(),panelAddProduct.getjTextField1(),panelAddProduct.getjTextField2(),panelAddProduct.getjTextField3(),panelAddProduct.getjTextField4(),panelAddProduct.getjComboBox());
            // Thiết lập JPanel
            add(panelAddProduct);
            add(panelTable);
            setLayout(null);
            setBackground(new Color(176,196,195,255));
            setBounds(280, 0, 920, 680);
    }

    public void addListener(JButton button,JTextField jTextField1,JTextField jTextField2,JTextField jTextField3,JTextField jTextField4,JComboBox jComboBox) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Tạo  thuộc tính và đối tượng
               String nameProduct = jTextField1.getText();
               int priceIn = Integer.parseInt(jTextField2.getText());
               String supplierId = jTextField3.getText();
               Double quantity = Double.parseDouble(jTextField4.getText());
               String unit = jComboBox.getSelectedItem().toString();
               Products product = new Products(nameProduct,priceIn,supplierId,unit);

               jTextField1.setText("");
               jTextField2.setText("");
               jTextField3.setText("");
               jTextField4.setText("");
               jComboBox.setSelectedIndex(0);
            // Thêm đối tượng vào list

               ListWareHouseExport.add(product);

            // Thêm đối tượng vào table
                addObject(product);
            }
        });
    }
    // add product
    public void addObject(Products product){
            Object[] row = {product.getProduct_id(),
                    product.getProduct_name(),
                    product.getPrice_in(),
                    product.getSupplier_id(),
                    ListSupplier.getSuppliersName(product.getSupplier_id())
            };
            model.addRow(row);
    }

}


// Tạo panel thêm Đối Tượng trong table
class AddPanel extends RoundedPanel {
    private JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4;
    private JPanel jPanel,jPanel1,jPanel2,jPanel3,jPanel4,jPanelTextField1,jPanelTextField2,jPanelTextField3,jPanelTextField4,jPanelButton,jPanelComboBox;
    private JTextField jTextField1, jTextField2,jTextField3,jTextField4;
    private JButton jButton;
    private JComboBox jComboBox = new JComboBox(Unit.unit_name);

    public AddPanel(int cornerRadius) {
        super(cornerRadius);
        // Panel tiêu đề
        jLabel = new JLabel("Thêm Mặt Hàng");
        jLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel.setForeground(new Color(255, 255, 255));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setBounds(50, 3, 200, 30);

        jPanel = new RoundedPanel(10);
        jPanel.setLayout(null);
        jPanel.setBounds(5, 7, 317, 35);
        jPanel.setBackground(new Color(63, 81, 93));
        jPanel.add(jLabel);

        add(jPanel);

        // Panel 1 (Mặt Hàng)
        jPanel1 = new RoundedPanel(10);
        jLabel1 = new JLabel("Mặt Hàng");
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setVerticalAlignment(SwingConstants.CENTER);
        jLabel1.setForeground(Color.WHITE);
        jPanel1.setBounds(10, 60, 100, 30);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(jLabel1, BorderLayout.CENTER);
        jPanel1.setBackground(new Color(63, 81, 93, 255));

        // Panel chứa JTextField cho Mặt Hàng
        jPanelTextField1 = new RoundedPanel(10);
        jPanelTextField1.setBounds(120, 60, 190, 30);
        jPanelTextField1.setLayout(new BorderLayout());

        jTextField1 = new JTextField();
        jTextField1.setFont(new Font("Tahoma", Font.BOLD, 15));
        jTextField1.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        jTextField1.setOpaque(false);
        jPanelTextField1.add(jTextField1);

        // Panel 2 (Giá Nhập)
        jPanel2 = new RoundedPanel(10);
        jLabel2 = new JLabel("Hãng");
        jLabel2.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setVerticalAlignment(SwingConstants.CENTER);
        jLabel2.setForeground(Color.WHITE);
        jPanel2.setBounds(10, 105, 100, 30);
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(jLabel2, BorderLayout.CENTER);
        jPanel2.setBackground(new Color(63, 81, 93, 255));

        // Panel chứa JTextField cho Giá Nhập
        jPanelTextField2 = new RoundedPanel(10);
        jPanelTextField2.setBounds(120, 105, 190, 30);
        jPanelTextField2.setLayout(new BorderLayout());

        jTextField2 = new JTextField();
        jTextField2.setFont(new Font("Tahoma", Font.BOLD, 15));
        jTextField2.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        jTextField2.setOpaque(false);
        jPanelTextField2.add(jTextField2);

        // Panel 3 (Hãng)
        jPanel3 = new RoundedPanel(10);
        jLabel3 = new JLabel("Số Lượng");
        jLabel3.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setVerticalAlignment(SwingConstants.CENTER);
        jLabel3.setForeground(Color.WHITE);
        jPanel3.setBounds(10, 150, 100, 30);
        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(jLabel3, BorderLayout.CENTER);
        jPanel3.setBackground(new Color(63, 81, 93, 255));

        // Panel chứa JTextField cho Hãng
        jPanelTextField3 = new RoundedPanel(10);
        jPanelTextField3.setBounds(120, 150, 80, 30);
        jPanelTextField3.setLayout(new BorderLayout());

        jTextField3 = new JTextField();
        jTextField3.setFont(new Font("Tahoma", Font.BOLD, 15));
        jTextField3.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        jTextField3.setOpaque(false);
        jPanelTextField3.add(jTextField3);

        // Panel 4 (Số Lượng)
        jPanel4 = new RoundedPanel(10);
        jLabel4 = new JLabel("Giá Nhập");
        jLabel4.setFont(new Font("Tahoma", Font.BOLD, 15));
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setVerticalAlignment(SwingConstants.CENTER);
        jLabel4.setForeground(Color.WHITE);
        jPanel4.setBounds(10, 190, 100, 30);
        jPanel4.setLayout(new BorderLayout());
        jPanel4.add(jLabel4, BorderLayout.CENTER);
        jPanel4.setBackground(new Color(63, 81, 93, 255));

        // Panel chứa JTextField cho Số Lượng
        jPanelTextField4 = new RoundedPanel(10);
        jPanelTextField4.setBounds(120, 190, 80, 30);
        jPanelTextField4.setLayout(new BorderLayout());

        jTextField4 = new JTextField();
        jTextField4.setFont(new Font("Tahoma", Font.BOLD, 15));
        jTextField4.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        jTextField4.setOpaque(false);
        jPanelTextField4.add(jTextField4);

        //JButton và Panel của nó
        jButton = new JButton("Submit");
        jButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(new Color(0, 102, 204));
        jButton.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        jButton.setOpaque(false);

        jPanelButton = new RoundedPanel(10);
        jPanelButton.setBounds(210,190,100,30);
        jPanelButton.setLayout(new BorderLayout());
        jPanelButton.add(jButton);
        jPanelButton.setBackground(new Color(0, 102, 204));

        // JComboBox
        jComboBox.setOpaque(false);
        jComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jComboBox.setBorder(new MatteBorder(0,0,0,0,Color.BLACK));
        jComboBox.setBackground(Color.WHITE);
        jPanelComboBox = new RoundedPanel(10);
        jPanelComboBox.setBounds(210, 150, 100, 30);
        jPanelComboBox.setLayout(new BorderLayout());
        jPanelComboBox.add(jComboBox, BorderLayout.CENTER);

        // Thêm các thành phần vào AddPanel
        add(jPanelComboBox);
        add(jPanelButton);
        add(jPanel1);
        add(jPanelTextField1);
        add(jPanel2);
        add(jPanelTextField2);
        add(jPanel3);
        add(jPanelTextField3);
        add(jPanel4);
        add(jPanelTextField4);

        // Thiết lập bố cục và kích thước cho AddPanel
        setBounds(50, 15, 330, 250);
        setLayout(null);
        setBackground(new Color(31, 167, 189, 255));
    }




    public JButton getjButton() {
        return jButton;
    }

    public JComboBox getjComboBox() {
        return jComboBox;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }
}
