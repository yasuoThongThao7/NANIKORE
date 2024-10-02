import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JPanelWarehouse extends JPanelMini{
    private JLabel text = new JLabel("Tồn kho");
    private JLabel image = new JLabel();

    public JPanelWarehouse () {
        //image
        image.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\kho.png"));
        image.setBounds(20,2,48,48);
        add(image);
        //text
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        text.setBounds(130, 10, 100, 30);
        add(text);
        // Thiết lập JPanelHome
        setBounds(0, 430, 280, 60);
        setLayout(null);
        setBackground(new Color(25, 188, 211));
    }
}

class JPanelWarehouseMenu extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JPanel panelTable,panelText;
    private ListWareHouse listWareHouse;
    public JPanelWarehouseMenu() {
        // Panel chứa JTextField
        panelText = new JPanel();
        panelText.setLayout(null);
        panelText.setBackground(new Color(25, 188, 211));

        //Thiết lập JTable
        String[] columnNames = {"ID","Mặt hàng"," Hãng","Giá xuất","Số lượng","Điều chỉnh"};
        DefaultTableModel model = new DefaultTableModel(columnNames,15);
        if( listWareHouse != null) {
            for(Products wareHouse : listWareHouse.getListWareHouse() ){
                Object[] row = {wareHouse.getProduct_id(),
                        wareHouse.getProduct_name(),
                        ListSupplier.getSuppliersName(wareHouse.getSupplier_id()),
                        wareHouse.getPrice_out(),
                };
                model.addRow(row);
            }
        }
        jTable = new Table(model);
        // Thêm thanh cuộn
        jScrollPane = new ScrollPane(jTable);
        // Tên table
        JLabel label = new JLabel("DANH SÁCH HÀNG : ");
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        label.setBounds(10, 10, 200, 30);
        label.setForeground(new Color(102, 102, 102, 252));
        // Table
        panelTable = new RoundedPanel(30);
        panelTable.setBounds(50,280,800,350);
        panelTable.add(jScrollPane);
        panelTable.add(label);
        //Thiết lập JPanel
        add(panelTable);
        setLayout(null);
        setBackground(new Color(239, 239, 239, 50));
        setBounds(280, 0, 920, 680);
    }
}
