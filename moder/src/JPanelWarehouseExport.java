import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JPanelWarehouseExport extends JPanelMini {
    private JLabel text = new JLabel("Xuất kho");
    private JLabel image = new JLabel();

    public JPanelWarehouseExport() {
        //image
        image.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\rakho.png"));
        image.setBounds(20,2,48,48);
        add(image);
        //text
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        text.setBounds(130, 10, 100, 30);
        add(text);
        // Thiết lập JPanelHome
        setBounds(0, 370, 280, 60);
        setLayout(null);
        setBackground(new Color(25, 188, 211));
    }
}
class JPanelWarehouseExportMenu extends JPanel{
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JPanel panelTable,panelText;
    public JPanelWarehouseExportMenu() {

            // Panel chứa JTextField
            panelText = new JPanel();
            panelText.setLayout(null);
            panelText.setBackground(new Color(25, 188, 211));

            //Thiết lập JTable
            String[] columnNames = {"ID","Mặt hàng","Hãng","Số lượng","Giá xuất","Điều chỉnh"};
            DefaultTableModel model = new DefaultTableModel(columnNames,15);
            if( ListWareHouseExport.LIST_WAREHOUSE_EXPORT != null) {
                for(Products products : ListWareHouseExport.LIST_WAREHOUSE_EXPORT){
                    Object[] row = {products.getProduct_id(),
                            products.getProduct_name(),
                            ListSupplier.getSuppliersName(products.getSupplier_id()),
                            products.getPrice_out(),

                    };
                    model.addRow(row);
                }
            }
            jTable = new Table(model);
            // Thêm thanh cuộn
            jScrollPane = new ScrollPane(jTable);
            // Tên table
            JLabel label = new JLabel("DANH SÁCH HÀNG XUẤT : ");
            label.setFont(new Font("Tahoma", Font.BOLD, 15));
            label.setBounds(10, 10, 250, 30);
            label.setForeground(new Color(102, 102, 102, 252));
            // Table
            panelTable = new RoundedPanel(30);
            panelTable.setBounds(50,280,800,350);
            panelTable.add(jScrollPane);
            panelTable.add(label);
            // Thiết lập JPanel
            add(panelTable);
            setLayout(null);
            setBackground(new Color(239, 239, 239, 50));
            setBounds(280, 0, 920, 680);
    }

}
