import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JPanelSupplier extends JPanelMini{
    private JLabel text = new JLabel("Nhà cung cấp");
    private JLabel image = new JLabel();

    public JPanelSupplier () {
        image.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\nhacungcap.png"));
        image.setBounds(20,2,48,48);
        add(image);
        //text
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        text.setBounds(130, 10, 130, 30);
        add(text);
        // Thiết lập JPanelHome
        setBounds(0, 490, 280, 60);
        setLayout(null);
        setBackground(new Color(25, 188, 211));
    }
}
class JPanelSupplierMenu extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JPanel panelTable,panelText;
    private ListSupplier listSupplier;
    public JPanelSupplierMenu() {
            // Panel chứa JTextField
            panelText = new JPanel();
            panelText.setLayout(null);
            panelText.setBackground(new Color(25, 188, 211));

            //Thiết lập JTable
            String[] columnNames = {"ID Hãng ","Hãng","Địa chỉ","Email","SĐT","Điều chỉnh"};
            DefaultTableModel model = new DefaultTableModel(columnNames,15);
            if( listSupplier != null) {
                for(Suppliers suppliers : listSupplier.getListSuppliers()){
                    Object[] row = {
                            suppliers.getSupplier_id(),
                            suppliers.getName(),
                            suppliers.getAddress(),
                            suppliers.getEmail(),
                            suppliers.getPhone(),
                    };
                    model.addRow(row);
                }
            }
            jTable = new Table(model);
            // Thêm thanh cuộn
            jScrollPane = new ScrollPane(jTable);
            // Tên table
            JLabel label = new JLabel("DANH SÁCH NHÀ CUNG CẤP :");
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
