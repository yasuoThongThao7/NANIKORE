
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JPanelCustomer extends JPanelMini{
        private JLabel text = new JLabel("Khách hàng");
        private JLabel image = new JLabel();

        public JPanelCustomer () {
            image.setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\moder\\icons\\nhacungcap.png"));
            image.setBounds(20,2,48,48);
            add(image);
            //text
            text.setFont(new Font("Tahoma", Font.BOLD, 15));
            text.setBounds(130, 10, 130, 30);
            add(text);
            // Thiết lập JPanelHome
            setBounds(0, 550, 280, 60);
            setLayout(null);
            setBackground(new Color(25, 188, 211));
        }
}
class JPanelCustomerMenu extends JPanel {
    private JTable jTable;
    private JScrollPane jScrollPane;
    private JPanel panelTable,panelText;
    public JPanelCustomerMenu() {
            // Panel chứa JTextField
//            panelText = new JPanel();
//            panelText.setLayout(null);
//            panelText.setBackground(new Color(25, 188, 211));
//
//            //Thiết lập JTable
//            String[] columnNames = {"Mặt hàng","Ngày nhập","Hãng","Số lượng","Điều chỉnh"};
//            DefaultTableModel model = new DefaultTableModel(columnNames,15);
//            if(listEnterWareHouse != null) {
//                for(EnterWareHouse enterWareHouse : listEnterWareHouse.getListEnterWareHouse() ){
//                    Object[] row = {enterWareHouse.getID(),
//                            enterWareHouse.getProduct_ID(),
//                            enterWareHouse.getQuantity(),
//                            enterWareHouse.getDate(),
//                            enterWareHouse.getSupplier_ID(),
//                            enterWareHouse.getUnit_ID()
//                    };
//                    model.addRow(row);
//                }
//            }
//            jTable = new Table(model);
//            // Thêm thanh cuộn
//            jScrollPane = new ScrollPane(jTable);
//            // Tên table
//            JLabel label = new JLabel("DANH SÁCH HÀNG : ");
//            label.setFont(new Font("Tahoma", Font.BOLD, 15));
//            label.setBounds(10, 10, 200, 30);
//            label.setForeground(new Color(102, 102, 102, 252));
//            // Table
//            panelTable = new RoundedPanel(30);
//            panelTable.setBounds(50,280,800,350);
//            panelTable.add(jScrollPane);
//            panelTable.add(label);
//            // Thiết lập JPanel
//            add(panelTable);
            setLayout(null);
            setBackground(new Color(239, 239, 239, 50));
            setBounds(280, 0, 920, 680);
    }
}


